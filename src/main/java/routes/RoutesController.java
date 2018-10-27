package routes;

import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutesController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/check-connection", method = RequestMethod.GET)
    public ResponseEntity checkConnection() {
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<String> getCategories() {
        return ResponseEntity.ok().body(new JSONArray()
                .put("cat1")
                .put("cat2")
                .put("cat3")
                .put("cat4")
                .put("cat5")
                .toString());
    }

    @RequestMapping(value = "/route-points", method = RequestMethod.GET)
    public ResponseEntity<String> getRoutePoints(@RequestParam(value="time") int time,
                                  @RequestParam(value="start") String start,
                                  @RequestParam(value="categories") String categories) {
        return ResponseEntity.ok().body(new JSONArray()
                .put(new JSONObject()
                        .put("x", 1)
                        .put("y", 2)
                        .put("name", "name")
                        .put("category", "category")
                        .put("time", 3))
                .toString());
    }
}