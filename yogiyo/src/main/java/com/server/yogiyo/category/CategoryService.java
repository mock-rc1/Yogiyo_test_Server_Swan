package com.server.yogiyo.category;

import com.server.yogiyo.category.entity.Category;
import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import com.server.yogiyo.menu.dto.LookupMenuRes;
import com.server.yogiyo.menu.repositroy.MenuRepository;
import com.server.yogiyo.restaurant.RestaurantRepository;
import com.server.yogiyo.restaurant.dto.LookupRestaurantRes;
import com.server.yogiyo.restaurant.entity.Restaurant;
import com.server.yogiyo.restaurant.entity.RestaurantMenuRelation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.server.yogiyo.configure.entity.Status.*;


@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final RestaurantRepository restaurantRepository;

    public List<LookupRestaurantRes> getRestaurantListByCategory(Integer categoryId, String address) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.NOT_EXIST_CATEGORY));

        return restaurantRepository.findAllByCategoryAndStatusAndGeneralAddress(category, Valid, address);
    }

    public List<LookupMenuRes> getMenuListByCategory(Integer categoryId, String address) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.NOT_EXIST_CATEGORY));
        List<Restaurant> restaurantList = restaurantRepository.findAllEntityByCategoryAndStatusAndGeneralAddress(category, Valid, address);
        List<LookupMenuRes> menuList = new ArrayList<>();
        for (Restaurant restaurant : restaurantList) {
            for (RestaurantMenuRelation menuRelation : restaurant.getMenuRelations()) {
                menuList.add(new LookupMenuRes(menuRelation.getMenu()));
            }
        }

        return menuList;
    }
}
