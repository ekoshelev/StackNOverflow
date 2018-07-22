package Models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BoxModel implements Comparator<BoxModel> {
    private final String HEIGHT = "Height";
    private final String LENGTH = "Length";
    private final String WIDTH = "Width";
    private int height;
    private int width;
    private int length;
    private int orientationUp = 90;
    private int orientationBase = 0;
    private int currentOrientation = 0;
    private int boxId;
    private int volume;

    // Constructor for the Box Model.
    public BoxModel(int boxId, int height, int width, int length) {
        this.boxId = boxId;
        this.height = height;
        this.width = width;
        this.length = length;
        this.volume = height * length * width;

    }

    public int getHeight() {
        return this.height;
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public int getBoxId() {
        return this.boxId;
    }

    public int getVolume() {
        return this.volume;
    }

    // return all a map of dimension values and their appropriate key.
    public Map<String, Integer> getDimensions() {
        Map<String, Integer> dimensionMap = new HashMap<>();
        dimensionMap.put(HEIGHT, this.height);
        dimensionMap.put(LENGTH, this.length);
        dimensionMap.put(WIDTH, this.width);
        return dimensionMap;
    }

    @Override
    public int compare(BoxModel boxModel1, BoxModel boxModel2) {
        if (boxModel1.getVolume() < boxModel2.getVolume()) {
            return -1;
        } else if (boxModel1.getVolume() > boxModel2.getVolume()) {
            return 1;
        }
        return 0;
    }
}
