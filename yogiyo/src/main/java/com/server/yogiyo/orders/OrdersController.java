package com.server.yogiyo.orders;

import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.orders.dto.OrdersTableRes;
import com.server.yogiyo.orders.dto.PostOrdersReq;
import com.server.yogiyo.orders.dto.OrdersListRes;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/app")
public class OrdersController {

    private final OrdersService ordersService;
    private final ResponseService responseService;

    @PostMapping(value = "/orders")
    public DataResponse<Long> createOrders(@AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestBody PostOrdersReq req)  {
        Long ordersId = ordersService.
                createOrders(customUserDetails,
                        req.getRestaurantId(),
                        req.getMenuId(),
                        req.getOptionsIdList());
        return responseService.getDataResponse(ordersId);
    }

    @GetMapping(value = "/orders/accounts/auth")
    public DataResponse<OrdersTableRes> getTableByAccount(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        OrdersTableRes ordersTableRes = ordersService.getTableByAccount(customUserDetails);
        return responseService.getDataResponse(ordersTableRes);
    }

}

