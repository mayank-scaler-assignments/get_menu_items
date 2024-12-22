package com.scaler.services;

import com.scaler.models.DietaryRequirement;
import com.scaler.models.MenuItem;
import com.scaler.repositories.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{


    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuItem> getMenuItems(String itemType) {
        return (itemType == null || itemType.isBlank())
                ? menuRepository.getAll()
                : menuRepository.getByDietaryRequirement(getDietaryRequirement(itemType));
    }

    private DietaryRequirement getDietaryRequirement(String itemType) {
        try {
            return DietaryRequirement.valueOf(itemType.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            // Default to VEG if itemType is invalid or null
            return DietaryRequirement.VEG;
        }
    }
}
