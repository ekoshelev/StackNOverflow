package Models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class BoxModel implements Comparator<BoxModel> {
    private final String HEIGHT = "Height";
    private final String LENGTH = "Length";
    private final String WIDTH = "Width";
    private int height;
    private int width;
    private int length;
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
    public int getOrientation() {
        return this.currentOrientation;
    }

    public void setOrientation(int orientation) {
        // actually need to check what the orientation is, and,
        // switch the lengths, widths, and heights, accordingly.
        // make an orientation class.
        this.currentOrientation = orientation;
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

    // get the bigger dimensions between two boxes.
    public ArrayList<String> getBiggerDimensions(BoxModel boxModel) {
        int height = boxModel.getHeight();
        int width = boxModel.getWidth();
        int length = boxModel.getLength();
        // holds the string name of the bigger dimension.
        ArrayList<String> maxDimensions = new ArrayList<String>();
        // if volume of this box is greater than the other box, no need to compare
        // dimensions since this box should go in the container first.
        if (this.volume > boxModel.getVolume()) {
            return maxDimensions;
        }

        // if the volume of this box is equal to the other box,
        // make sure the orientations are the same before comparing dimensions.
        if (this.volume == boxModel.getVolume()) {
            if (this.currentOrientation != boxModel.getOrientation()) {
                boxModel.setOrientation(this.currentOrientation);
            }
            // even though the volumes of the boxes may be equal, check if any of their dimensions
            // exceeds that of the other box, if so, save the name of those dimensions.
            // use the names to get the max dimension from the BoxModel.getDimensions method.
            if (this.height > height) {
                maxDimensions.add(HEIGHT);
            }
            if (this.width > width) {
                maxDimensions.add(WIDTH);
            }
            if (this.length > length) {
                maxDimensions.add(LENGTH);
            }
        }
        return maxDimensions;
    }
}
