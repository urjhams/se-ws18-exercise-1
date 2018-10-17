
public class Image {
  public byte[] imageData;
  int width;
  int height;

  public Image(int width, int height) {
    this.width = width;
    this.height = height;

    int numberOfPixel = width * height;
    int numberOfBytes = numberOfPixel * 3  // because 24 bit image -> 3 bytes per pixel
    this.imageData = new byte[numberOfBytes]
  }

  public void set(int x, int y, int val) {
    
  }
}
