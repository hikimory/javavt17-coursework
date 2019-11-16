package edu.javavt17.dao;

import edu.javavt17.model.CarBrand;
import java.util.List;

public interface CarBrandDAO{

    void saveOrUpdate(CarBrand item);

    void delete(int itemId);

    CarBrand get(int itemId);

    List<CarBrand> list();

}