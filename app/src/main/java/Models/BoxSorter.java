// Given a container and a list of boxes, create the proper stacking order of boxes.

package Models;
import java.util.ArrayList;

public class BoxSorter {

    private Container container;
    private ArrayList<BoxModel> boxModels;
    private int containerWidth;
    private int containerLength;
    private int containerHeight;
    private int containerVolume;
    private int containerArea;

    // creates a BoxSorter with a container, and an ArrayList of boxModels
    public BoxSorter(Container container, ArrayList<BoxModel> boxeModels) {
        this.container = container;
        this.boxModels = boxModels;
        this.containerWidth = container.getWidth();
        this.containerHeight = container.getHeight();
        this.containerLength = container.getLength();
        this.containerVolume = container.getVolume();
        this.containerArea = container.getArea();
    }
    // write the sorting algorithm here.
    /*public ArrayList<BoxModel> sortBoxes() {

    };*/



    // Call this function to get boxes of descending cubic volumes.
    // Boxes are already sorted by volume, and use a 0 degree orientation to keep things simple.
    // This method is for testing purposes to see if the AR side can take a list of boxes and
    // put them in the proper location in the container.
    public ArrayList<BoxData> sortedBoxes(int N) {
        int i;
        int previousX = 0;
        // create N boxes of preset sizes.
        ArrayList<BoxData> sortedBoxesAndData = new ArrayList<BoxData>();
        for (i = 0; i < N; i++) {
            BoxModel box = new BoxModel(i, i, i, i);
            // using x axis as base for where new coordinates are computed from.
            // y and z axis stay the same for now.
            Coordinate coordinate = new Coordinate(previousX + i, i, i);
            previousX = i;
            BoxData boxData = new BoxData(box, coordinate);
            sortedBoxesAndData.add(boxData);
        }
        return sortedBoxesAndData;
    }
}
