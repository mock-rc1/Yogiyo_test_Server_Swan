package com.server.yogiyo.category;

import com.server.yogiyo.category.dto.GetCategoryRes;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.server.yogiyo.configure.entity.Status.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/app")
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final ResponseService responseService;

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
}
