package com.server.yogiyo.restaurant;

import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.restaurant.dto.DetailRestaurantRes;
import com.server.yogiyo.restaurant.dto.LookupRestaurantRes;
import com.server.yogiyo.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.server.yogiyo.configure.entity.Status.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/app")
public class RestaurantController {

    private final ResponseService responseService;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    @GetMapping(value = "/restaurants")
    DataResponse<Page<LookupRestaurantRes>> getAllRestaurants(@PageableDefault Pageable pageable, @RequestParam(name = "address") String address){
        Page<LookupRestaurantRes> restaurants = restaurantRepository.findAllByStatusAndGeneralAddressOrderByUpdatedAtDesc(pageable, Valid, address);
        return responseService.getDataResponse(restaurants);
    }

    @GetMapping(value = "/restaurants/condition/{condition}")
    DataResponse<List<LookupRestaurantRes>> getConditionList(@PathVariable(name = "condition") String condition,
                                                             @RequestParam(name = "address") String address) {
        List<LookupRestaurantRes> restaurants = restaurantService.getConditionList(condition, address);
        return responseService.getDataResponse(restaurants);
    }

    @GetMapping(value = "/restaurants/{id}")
    public DataResponse<DetailRestaurantRes> getDetailRestaurant(@AuthenticationPrincipal CustomUserDetails customUserDetails, @PathVariable(name = "id") Long id) {
        DetailRestaurantRes restaurant = restaurantService.getDetailRestaurant(customUserDetails, id);
        return responseService.getDataResponse(restaurant);
    }
}
