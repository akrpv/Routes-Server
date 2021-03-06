package routes;

import javafx.util.Pair;
import routes.data.Category;
import routes.data.Place;
import java.util.ArrayList;
import static java.lang.Math.sqrt;

class Router {
    Place[] getRoute(ArrayList<Pair<Category, Place[]>> categoryPlaces, double x, double y) {
        Place[] places = new Place[categoryPlaces.size()];
        int counter = 0;
        Place curPlace = new Place(0,x,y,"startplace",0);

        for (Pair<Category, Place[]> pair: categoryPlaces) {
            double curDist = 100000000;// выбрал это чтоб наверняка, как в плюсах
            for (Place place: pair.getValue()){
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

