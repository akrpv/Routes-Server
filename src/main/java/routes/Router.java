package routes;

import routes.data.Category;
import routes.data.Place;
import java.util.Map;
import static java.lang.Math.sqrt;

class Router {
    Place[] getRoute(Map<Category, Place[]> categoryPlaces, double x, double y) {
        Place[] places = new Place[categoryPlaces.size()];
        int counter = 0;
        Place curPlace = new Place(x,y,"startplace",0,0);
        for (Category category: categoryPlaces.keySet()){
            double curDist = 100000000;// выбрал это чтоб наверняка, как в плюсах
            for (Place place: categoryPlaces.get(category)){
                if (getDist(curPlace.getX(),curPlace.getY(),place.getX(),place.getY())<=curDist){
                    curDist = getDist(x,y,place.getX(),place.getY());
                    places[counter] = place;
                    curPlace = places[counter];
                }
            }
            counter+=1;
        }
        return places;
    }
    //Тестовая функция расстояния, нужно будет заменить на гугловскую или яндексовскую, не забыть потереть импорт.
    private double getDist(double x1, double y1, double x2, double y2){
        return sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
}

