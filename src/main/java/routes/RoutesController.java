package routes;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import routes.data.Category;
import routes.data.DataWrapper;
import routes.data.Place;

@RestController
public class RoutesController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/check-connection", method = RequestMethod.GET)
    public ResponseEntity checkConnectionGet() {
        System.out.println("GET request was received by check-connection controller. System time: " + System.currentTimeMillis());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/check-connection", method = RequestMethod.POST)
    public ResponseEntity checkConnectionPost() {
        System.out.println("POST request was received by check-connection controller. System time: " + System.currentTimeMillis());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> getCategories() throws ClassNotFoundException, SQLException {
        System.out.println("GET request was received by categories controller. System time: " + System.currentTimeMillis());
        return DataWrapper.getCategories();
    }

    @RequestMapping(value = "/route-points", method = RequestMethod.GET)
    public Place[] getRoutePoints(@RequestParam(value="time") int time,
                                      @RequestParam(value="start") String start,
                                      @RequestParam(value="categories") String categories) throws Exception {
        System.out.println("GET request was received by route-points controller. System time: " + System.currentTimeMillis());
        String[] categoryIds = categories.split(",");
        String[] xy = start.split(",");
        double x = Double.parseDouble(xy[0]);
        double y = Double.parseDouble(xy[1]);
        Category[] categoryObjects = new Category[categoryIds.length];
        for (int i = 0; i < categoryIds.length; i++) {
            categoryObjects[i] = DataWrapper.getCategoryById(Integer.parseInt(categoryIds[i]));
        }
        Map<Category, Place[]> categoryPlaces = new PlaceFilter().getNearestPlaces(categoryObjects, time, x, y);
        return new Router().getRoute(categoryPlaces, x, y);
    }
}