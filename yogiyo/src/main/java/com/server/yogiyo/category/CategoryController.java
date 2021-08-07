package com.server.yogiyo.category;

import com.server.yogiyo.category.dto.GetCategoryRes;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import com.server.yogiyo.menu.dto.LookupMenuRes;
import com.server.yogiyo.restaurant.dto.LookupRestaurantRes;
import com.server.yogiyo.restaurant.entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.server.yogiyo.configure.entity.Status.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/app")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final ResponseService responseService;
    private final CategoryService categoryService;

    @GetMapping(value = "/categories")
    public DataResponse<List<GetCategoryRes>> getCategories() {
        List<GetCategoryRes> categories = categoryRepository.findAllByStatus(Valid);
        return responseService.getDataResponse(categories);
    }

    @GetMapping(value = "/categories/menu")
    public DataResponse<List<GetCategoryRes>> getFoodCategories() {
        List<GetCategoryRes> categories = categoryRepository.findAllByStatusAndIsFood(Valid, true);
        return responseService.getDataResponse(categories);
    }

    @GetMapping(value = "/restaurants/categories/{categoryId}")
    public DataResponse<List<LookupRestaurantRes>> getRestaurantListByCategory(@PathVariable(name = "categoryId") Integer categoryId,
                                                                               @RequestParam(name = "address") String address) {
        List<LookupRestaurantRes> restaurantList = categoryService.getRestaurantListByCategory(categoryId, address);
        return responseService.getDataResponse(restaurantList);
    }

    @GetMapping(value = "/menus/categories/{categoryId}")
    public DataResponse<List<LookupMenuRes>> getMenuListByCategory(@PathVariable(name = "categoryId") Integer categoryId,
                                                                   @RequestParam(name = "address") String address) {
        List<LookupMenuRes> menuList = categoryService.getMenuListByCategory(categoryId, address);
        return responseService.getDataResponse(menuList);
    }
}
