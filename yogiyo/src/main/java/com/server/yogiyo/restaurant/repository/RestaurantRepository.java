package com.server.yogiyo.restaurant.repository;

import com.server.yogiyo.category.entity.Category;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.restaurant.entity.Restaurant;
import com.server.yogiyo.restaurant.dto.DetailRestaurantRes;
import com.server.yogiyo.restaurant.dto.LookupRestaurantRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("select r from Restaurant r left join fetch r.menuRelations m left join fetch r.account a where (r.restaurantId = :id and r.status != 'Deleted')")
    Optional<DetailRestaurantRes> findByRestaurantId(@Param("id") Long id);

    Optional<Restaurant> findByRestaurantIdAndStatus(Long id, Status status);

    Page<LookupRestaurantRes> findAllByStatusAndGeneralAddressOrderByUpdatedAtDesc(Pageable page, Status status, String generalAddress);
    List<LookupRestaurantRes> findAllByStatusAndGeneralAddressAndIsExpressOrderByUpdatedAtDesc(Status status, String generalAddress, Boolean isExpress);
    List<LookupRestaurantRes> findAllByStatusAndGeneralAddressAndDiscountValueNotNullOrderByUpdatedAtDesc(Status status, String generalAddress);
    List<LookupRestaurantRes> findAllByStatusAndGeneralAddressOrderByOrderQuantityDesc(Status status, String generalAddress);
    List<LookupRestaurantRes> findTopByStatusAndGeneralAddressAndFocusADOrderByUpdatedAtDesc(Status status, String generalAddress, Boolean focusAd);

    @Query("select r from Restaurant  r join fetch r.categoryRelationList c where (c.category = :category and r.status = :status and r.generalAddress = :address)")
    List<LookupRestaurantRes> findAllByCategoryAndStatusAndGeneralAddress(Category category, Status status, String address);

    @Query("select r from Restaurant  r join fetch r.categoryRelationList c where (c.category = :category and r.status = :status and r.generalAddress = :address)")
    List<Restaurant> findAllEntityByCategoryAndStatusAndGeneralAddress(Category category, Status status, String address);
}
