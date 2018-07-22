package Models;

import java.util.Map;

// Box Data is an object that contains a box, the coordinate of where the box
// should be located, and its orientation.
public class BoxData {
    public BoxModel boxModel;
    public Coordinate coordinate;

    public BoxData(BoxModel boxModel, Coordinate coordinate) {
        this.boxModel = boxModel;
        this.coordinate = coordinate;
    }

    public BoxModel getBoxModel() {
        return this.boxModel;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }
}
