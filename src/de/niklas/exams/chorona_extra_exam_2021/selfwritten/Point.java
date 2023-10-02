package de.niklas.exams.chorona_extra_exam_2021.selfwritten;

public class Point {

    private final int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
	public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + this.x;
      result = prime * result + this.y;
      return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
         return true;
      }
		if (obj == null) {
         return false;
      }
		if (this.getClass() != obj.getClass()) {
         return false;
      }
		Point other = (Point) obj;
		if (this.x != other.x) {
         return false;
      }
		if (this.y != other.y) {
         return false;
      }
		return true;
	}	
}
