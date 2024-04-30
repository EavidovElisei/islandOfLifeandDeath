package config;

public class FieldSizeConfig {
    private int width; // ширина
    private int height; // высота

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public FieldSizeConfig(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
