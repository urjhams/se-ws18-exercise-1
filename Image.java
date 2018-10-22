import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

public class Image {
  public byte[] imageData = null ;
  private int width = 0;
  private int height = 0;

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

  // write image data to file as image format P3 or P6

  public void  write( String filename) throws IOException{
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
    // write header
    int rowdimension = width;
    int columndimension = height;
    writer.write("P6");
    writer.newLine();
    writer.write(width+" "+height);
    writer.newLine();
    writer.write("256");
    writer.newLine();
    for(int row=0;row<rowdimension;row++){
      for(int column=0;column<columndimension;column++){
        writer.write(String.valueOf(imageData));
        if(column < columndimension - 1)writer.write(" ");
      }
      writer.newLine();
    }
    writer.flush();
    writer.close();
  }


}
