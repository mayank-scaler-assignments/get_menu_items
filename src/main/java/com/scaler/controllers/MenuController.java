package com.scaler.controllers;

import com.scaler.dtos.*;
import com.scaler.models.MenuItem;
import com.scaler.services.MenuService;

import java.util.List;

public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    public GetMenuItemsResponseDto getMenuItems(GetMenuItemsRequestDto requestDto) {
        GetMenuItemsResponseDto responseDto = new GetMenuItemsResponseDto();
        List<MenuItem> menuItems = menuService.getMenuItems(requestDto.getDietaryRequirement());
        responseDto.setMenuItems(menuItems);
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return responseDto;
    }
}
