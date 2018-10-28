package routes;

import javafx.util.Pair;
import routes.data.Category;
import routes.data.DataWrapper;
import routes.data.Place;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceFilter {

    private final double AVERAGE_SPEED = 5; //km/h

    public ArrayList<Pair<Category, Place[]>> getNearestPlaces(Category[] categories, double time, double x, double y) throws ClassNotFoundException, SQLException {
        double r = time / 60 * AVERAGE_SPEED;
        ArrayList<Pair<Category, Place[]>> categoryPlaces = new ArrayList<>();
        for (Category category: categories) {
            categoryPlaces.add(new Pair(category, DataWrapper.getPlacesByCategoryId(category.getId(), x, y, r).toArray(new Place[0])));
        }
        return categoryPlaces;
    }
}