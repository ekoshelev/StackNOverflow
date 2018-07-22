package Models;

public class Container {
    private int length;
    private int width;
    private int height;
    private int volume;
    private int area;

    public Container(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = length * width * height;
        this.area = length * width;
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getArea() {
        return this.area;
    }
}
