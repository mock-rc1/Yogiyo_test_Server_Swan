package com.server.yogiyo.menu;

import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import com.server.yogiyo.menu.dto.DetailMenuRes;
import com.server.yogiyo.restaurant.dto.DetailRestaurantRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app")
public class MenuController {

    private final MenuService menuService;
    private final ResponseService responseService;

    @GetMapping(value = "/menus/{id}")
    public DataResponse<DetailMenuRes> getDetailMenu(@PathVariable(name = "id") Long id) {
        DetailMenuRes detailMenu = menuService.getDetailMenu(id);
        return responseService.getDataResponse(detailMenu);
    }

}
