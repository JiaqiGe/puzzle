class Rectangle{
  int width;
  int height;

  public Rectangle(int width, int height){
    this.width = width;
    this.height = height;
  }
}

public class IsRectangle{
  public boolean isRectangle(List<Rectangle> rectangles){
    // divide and conquer

    // base
    if(rectangles.size() <= 1){
      return true;
    }

    for(int i = 0; i < rectangles.size(); i++){

    }

  }
}
