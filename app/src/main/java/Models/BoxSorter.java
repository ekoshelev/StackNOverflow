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
        int currentHeight = 0;
        int currentWidth = 0;
        int currentLength = 0;
        Coordinate coordinate = null;
        // create N boxes of preset sizes.
        ArrayList<BoxData> sortedBoxesAndData = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            BoxModel box = new BoxModel(i, i, i, i);
            currentHeight = currentHeight + box.getHeight();
            currentLength = currentLength + box.getLength();
            currentWidth = currentWidth + box.getWidth();
            // check for available space and create coordinates for the box based on where the previous
            // box was placed
            for (int z = 0; z < this.containerHeight; z += box.getLength()) {
                for (int x = 0; x < this.containerWidth; x += box.getWidth()) {
                    for (int y = 0; y < this.containerLength; y += box.getHeight()) {
                        coordinate = new Coordinate(x,y,z);
                    }
                }
            }
            BoxData boxData = new BoxData(box, coordinate);
            sortedBoxesAndData.add(boxData);
        }
        return sortedBoxesAndData;
    }
}
