package com.server.yogiyo.category;

import com.server.yogiyo.category.dto.GetCategoryRes;
import com.server.yogiyo.category.entity.Category;
import com.server.yogiyo.configure.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<GetCategoryRes> findAllByStatusAndIsFood(Status status, Boolean isFood);

    List<GetCategoryRes> findAllByStatus(Status status);
}
