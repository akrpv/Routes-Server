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
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/check-connection", method = RequestMethod.POST)
    public ResponseEntity checkConnectionPost() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> getCategories() throws ClassNotFoundException, SQLException {
        return DataWrapper.getCategories();
    }

    @RequestMapping(value = "/route-points", method = RequestMethod.GET)
    public List<Place> getRoutePoints(@RequestParam(value="time") int time,
                                      @RequestParam(value="start") String start,
                                      @RequestParam(value="categories") String categories) {
//        String[] categoryNames = categories.split(",");
//        Category[] categoryObjects = new Category[categoryNames.length];
//        for (String category: categoryNames) {
//
//        }

//        new PlaceFilter().getNearestPlaces();
        return new ArrayList<Place>();
    }
}