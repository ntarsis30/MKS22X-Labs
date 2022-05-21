public class Kernel {
    float[][]kernel;

    /**Constructor takes the kernel that will be applied to the image
    *This implementation only allows 3x3 kernels
    */
    public Kernel(float[][]init) {
      kernel = init;
    }

    /**If part of the kernel is off of the image, return black, Otherwise
    *Calculate the convolution of r/g/b separately, and return that color
    */
    color calcNewColor(PImage img, int x, int y) {
      float r = 0; float g = 0; float b = 0;
      for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
          r+=(kernel[i][j] * red(img.get(x+j-1,y+i-1)));
          g+=(kernel[i][j] * green(img.get(x+j-1,y+i-1)));
          b+=(kernel[i][j] * blue(img.get(x+j-1,y+i-1)));
        }
      }
      if (r>255){
        r=255;
      }
      if (r<0){
        r=0;
      }
      if (b>255){
        b=255;
      }
      if (b<0){
        b=0;
      }
      if (g>255){
        g=255;
      }
      if (g<0){
        g=0;
      }
      return color(r,g,b);
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
      //return 0;
    }

    /**You must write this method that applies the kernel to the source,
    *and saves the data to the destination.*/
    void apply(PImage source, PImage destination) {
      for (int i = 0; i < source.height; i++){
        for (int j = 0; j < source.width; j++){
          if(i==0||j==0||i==source.height-1||j==source.width-1){
            destination.set(j,i,0);
          }
          else{
            destination.set(j,i,calcNewColor(source,j,i));
          }
          
        }
      }
        
      
      
    }

}
