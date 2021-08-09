package com.server.yogiyo.restaurant;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.restaurant.dto.DetailRestaurantRes;
import com.server.yogiyo.restaurant.dto.LookupRestaurantRes;
import com.server.yogiyo.restaurant.entity.AccountRestaurantRelation;
import com.server.yogiyo.restaurant.repository.AccountRestaurantRelationRepository;
import com.server.yogiyo.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.server.yogiyo.configure.entity.Status.Valid;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final AccountRestaurantRelationRepository accountRestaurantRelationRepository;

    public List<LookupRestaurantRes> getConditionList(String condition, String address) {
        List<LookupRestaurantRes> restaurants = null;
        if (condition.equals("express"))
            restaurants = restaurantRepository.findAllByStatusAndGeneralAddressAndIsExpressOrderByUpdatedAtDesc(Valid, address, true);
        else if (condition.equals("discount"))
            restaurants = restaurantRepository.findAllByStatusAndGeneralAddressAndDiscountValueNotNullOrderByUpdatedAtDesc(Valid, address);
        else if (condition.equals("ranking"))
            restaurants = restaurantRepository.findAllByStatusAndGeneralAddressOrderByOrderQuantityDesc(Valid, address);
        else if (condition.equals("focus")) {
            restaurants = restaurantRepository.findTopByStatusAndGeneralAddressAndFocusADOrderByUpdatedAtDesc(Valid, address, true);
        } else throw new CustomException(CustomExceptionStatus.REQUEST_ERROR);
        return restaurants;
    }

    public DetailRestaurantRes getDetailRestaurant(CustomUserDetails customUserDetails, Long id) {
        DetailRestaurantRes detailRestaurantRes = restaurantRepository.findByRestaurantId(id)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.Restaurant_NOT_FOUND));
        detailRestaurantRes.setLike(false);
        if (customUserDetails != null) {
            Account account = customUserDetails.getAccount();
            List<AccountRestaurantRelation> isLike = accountRestaurantRelationRepository.findByAccountAndRestaurantAndStatusAndIsLike(account, restaurantRepository.findById(id).get(), Valid, true);
            if (isLike.size() > 0) detailRestaurantRes.setLike(true);
        }

        return detailRestaurantRes;
    }
}
