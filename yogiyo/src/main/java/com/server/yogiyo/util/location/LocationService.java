package com.server.yogiyo.util.location;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.restaurant.entity.Restaurant;
import com.server.yogiyo.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.server.yogiyo.configure.entity.Status.Valid;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LocationService {

    private final NaverDirection5 naverDirection5;
    private final NaverGeocode naverGeocode;
    private final RestaurantRepository restaurantRepository;

    public String getDistance(CustomUserDetails customUserDetails, Long restaurantId) {
        Account account = customUserDetails.getAccount();
        Restaurant restaurant = restaurantRepository.findByRestaurantIdAndStatus(restaurantId, Valid)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.Restaurant_NOT_FOUND));
        String authCoordinate = naverGeocode.getCoordinate(account.getDetailedAddress());
        String restaurantCoordinate = naverGeocode.getCoordinate(restaurant.getDetailedAddress());

        return naverDirection5.getDistance(authCoordinate, restaurantCoordinate);
    }

}
