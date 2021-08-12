package com.server.yogiyo.util.location;

import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/app")
public class LocationController {

    private final NaverGeocode naverGeocode;
    private final LocationService locationService;
    private final ResponseService responseService;

    @GetMapping(value = "/coordinate/{address}")
    public DataResponse<String> getCoordinate(@PathVariable(name = "address") String  address) {
        String coordinate = naverGeocode.getCoordinate(address);
        return responseService.getDataResponse(coordinate);
    }

    @GetMapping(value = "/distance/auth/restaurant/{restaurantId}")
    public DataResponse<String> getDistance(@AuthenticationPrincipal CustomUserDetails customUserDetails, @PathVariable(name = "restaurantId") Long restaurantId){
        String distance = locationService.getDistance(customUserDetails, restaurantId)+"km";
        return responseService.getDataResponse(distance);
    }

}
