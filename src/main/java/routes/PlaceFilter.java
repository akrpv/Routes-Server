package routes;

import routes.data.Category;
import routes.data.DataWrapper;
import routes.data.Place;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PlaceFilter {

    private final double AVERAGE_SPEED = 5; //km/h

    public Map<Category, Place[]> getNearestPlaces(Category[] categories, double time, double x, double y) throws ClassNotFoundException, SQLException {
        double r = time / 60 * AVERAGE_SPEED;
        Map<Category, Place[]> categoryPlaces = new HashMap<>();
        for (Category category: categories) {
            categoryPlaces.put(category, DataWrapper.getPlacesByCategoryId(category.getId(), x, y, r).toArray(new Place[0]));
        }
        return categoryPlaces;
    }
}