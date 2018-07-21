package Models;

public class BoxModel {
    public int height;
    public int width;
    public int length;

    public int boxId;

    // Constructor for the Box Model.
    public boxModel(int boxId, int height, int width, int length) {
        this.boxId = boxId;
        this.height = height;
        this.width = width;
        this.length = length;
    }
}
