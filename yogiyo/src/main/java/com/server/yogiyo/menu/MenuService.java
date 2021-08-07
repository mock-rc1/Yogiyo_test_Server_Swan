package com.server.yogiyo.menu;

import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import com.server.yogiyo.menu.dto.DetailMenuRes;
import com.server.yogiyo.menu.repositroy.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MenuService {

    private final MenuRepository menuRepository;


    public DetailMenuRes getDetailMenu(Long id) {
        return menuRepository.findByMenuId(id)
                .orElseThrow(() -> new CustomException(CustomExceptionStatus.MENU_NOT_FOUND));
    }
}
