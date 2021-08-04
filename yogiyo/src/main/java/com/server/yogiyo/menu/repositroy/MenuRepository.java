package com.server.yogiyo.menu.repositroy;

import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.menu.dto.DetailMenuRes;
import com.server.yogiyo.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("select m from Menu m  left join fetch m.optionsList o where (m.menuId = :id and m.status != 'Deletd' and o.orders = null)")
    Optional<DetailMenuRes> findByMenuId(Long id);

    Optional<Menu> findByMenuIdAndStatus(Long id, Status status);

}
