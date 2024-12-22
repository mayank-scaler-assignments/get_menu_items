package com.scaler.repositories;

import com.scaler.models.DietaryRequirement;
import com.scaler.models.MenuItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuRepositoryImpl implements MenuRepository{

    private final List<MenuItem> menuItems;

    public MenuRepositoryImpl() {
        this.menuItems = new ArrayList<>();
    }

    @Override
    public MenuItem add(MenuItem menuItem) {
        menuItems.add(menuItem);
        return menuItem;
    }

    @Override
    public List<MenuItem> getAll() {
        return menuItems;
    }

    @Override
    public List<MenuItem> getByDietaryRequirement(DietaryRequirement dietaryRequirement) {
        return menuItems.stream().filter(menuItem ->
                menuItem.getDietaryRequirement().equals(dietaryRequirement)).toList();
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        menuItems.add(menuItem);
        return menuItem;
    }
}
