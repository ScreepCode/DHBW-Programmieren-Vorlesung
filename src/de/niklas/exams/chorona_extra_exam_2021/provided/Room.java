package de.niklas.exams.chorona_extra_exam_2021.provided;

import de.niklas.exams.chorona_extra_exam_2021.selfwritten.IRoom;
import de.niklas.exams.chorona_extra_exam_2021.selfwritten.Point;
import de.niklas.exams.chorona_extra_exam_2021.selfwritten.RoomSetting;

import java.util.Random;

/**
 * Class to represent a room. Simulates the distribution of pollutants.
 */
public class Room implements IRoom {

   /**
    * Random instance
    */
   private final static Random RND = new Random();

   /**
    * Array with pollution values for each cell
    */
	private double[][] cells;

   /**
    * Room setting with width/height and information about pollutants
    */
   private RoomSetting setting;

   /**
    * Factor for current variant
    */
   private double factor;

   /**
    * Current step
    */
   private int steps = 0;
	
   /**
    * Initalize the room
    * 
    * @param factor
    *           factor for the variant
    * @param setting
    *           setting for the room
    */
   public Room( double factor, RoomSetting setting ) {
      this.factor = factor;
      this.setting = setting;
      this.cells = new double[setting.getHeight()][setting.getWidth()];
	}
	
   /**
    * Get the dose at x, y
    * 
    * @param x
    *           x value
    * @param y
    *           y value
    * @return dose at provided position
    */
	@Override
   public double getDose(int x, int y) {
      return this.cells[y][x];
	}
	
   /**
    * Set the dose at x, y
    * 
    * @param x
    *           x value
    * @param y
    *           y value
    * @param dose
    *           dose to set at provided position
    */
	@Override
   public void setDose(int x, int y, double dose) {
      this.cells[y][x] = dose;
	}
	
   /**
    * Add the dose at x, y
    * 
    * @param x
    *           x value
    * @param y
    *           y value
    * @param dose
    *           dose to add at provided position
    */
	@Override
   public void addDose(int x, int y, double dose) {
      this.setDose( x, y, dose + this.getDose( x, y ) );
	}


   /**
    * Do a step (distribute pollution to neighbor cells)
    */
	@Override
   public void step() {
      this.pollute();
		double[][] result = new double[this.cells.length][this.cells[0].length];
      for ( int y = 0; y < this.setting.getHeight(); y++ ) {
         for ( int x = 0; x < this.setting.getWidth(); x++ ) {
				double av = this.getAverageForCellAndNeighbours(x, y);
            result[y][x] = av;
			}
		}	
      for ( int y = 0; y < this.setting.getHeight(); y++ ) {
         for ( int x = 0; x < this.setting.getWidth(); x++ ) {
            this.cells[y][x] = result[y][x];
			}
		}	
      this.steps++;
	}

   /**
    * Get the performed steps
    * 
    * @return performed steps
    */
   public int getSteps() {
      return this.steps;
   }

   /**
    * Get the room setting
    * 
    * @return room setting
    */
   public RoomSetting getSetting() {
      return this.setting;
   }

   /**
    * Add pollution to all cells with polluters
    */
   private void pollute() {
      for ( Point p : this.getSetting().getPolluters() ) {
         this.addDose( p.getX(), p.getY(), 50 + this.factor * Room.RND.nextDouble() );
      }
   }

   /**
    * Calculate average for current cell and it's neighbors
    * 
    * @param x
    *           x value of cell
    * @param y
    *           y value of cell
    * @return average value
    */
   private double getAverageForCellAndNeighbours( int x, int y ) {
      return this.getSumForCellAndNeighbours( x, y ) / this.getNoOfCellsForCellAndNeighbours( x, y );
   }

   /**
    * Get number cell plus it's neighbors
    * 
    * @param x
    *           x value of cell
    * @param y
    *           y value of cell
    * @return number of cells
    */
   private int getNoOfCellsForCellAndNeighbours( int x, int y ) {
      int cellsNo = 0;
      for ( int j = Math.max( y - 1, 0 ); j <= Math.min( this.setting.getHeight() - 1, y + 1 ); j++ ) {
         for ( int i = Math.max( x - 1, 0 ); i <= Math.min( this.setting.getWidth() - 1, x + 1 ); i++ ) {
            cellsNo++;
         }
      }
      return cellsNo;
   }

   /**
    * Get sum of the values of current cell and it's neighbors
    * 
    * @param x
    *           x value of cell
    * @param y
    *           y value of cell
    * @return sum
    */
   private double getSumForCellAndNeighbours( int x, int y ) {
      double sum = 0.0;
      for ( int j = Math.max( y - 1, 0 ); j <= Math.min( this.setting.getHeight() - 1, y + 1 ); j++ ) {
         for ( int i = Math.max( x - 1, 0 ); i <= Math.min( this.setting.getWidth() - 1, x + 1 ); i++ ) {
            sum += this.cells[j][i];
         }
      }
      return sum;
   }
}
