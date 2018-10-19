import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Image {
  public byte[] imageData = null ;
  int width = 0;
  int height = 0;
  //private static String matrix="";

  public Image(int width, int height) {
    this.width = width;
    this.height = height;

    int numberOfPixel = width * height;
    int numberOfBytes = numberOfPixel * 3 ; // because 24 bit image -> 3 bytes per pixel
    this.imageData = new byte[numberOfBytes];

  }
  // set single pixel to index value of RGB

  public void set(int x, int y, int val) {

    for(int i = 0; i < height; i++){
      for (int j = 0; j< width; j++){
          imageData [x + y * width] = (byte) val;
      }
    }
  }

  // write image data to file as image format

  public void write( String filename) throws FileNotFoundException, IOException{
    FileOutputStream fos = new FileOutputStream(filename);
    fos.write(new String(imageData).getBytes());
    fos.close();

  }
}
