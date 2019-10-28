/*
 * Amber Dostert
 */

package co.grandcircus;


	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
	import java.util.Set;
	import java.util.TreeSet;

	public class MoviesApp {

		static Set<String> movieSet = new TreeSet<>(); 
		
		public static void main(String[] args) {

			Scanner scnr = new Scanner(System.in);
			List<Movies> movieList = new ArrayList<Movies>(100);
			Set<String> catSet = new TreeSet<>(); // new set of strings of categories in alphabetical order
			String userCon = "y"; 
			int userCategorySelect; //
			
			// create a new list using the movies in the MovieIO file
			for(int i = 1; i <= 100; i++) {
				movieList.add(MovieIO.getMovie(i));
			}
			
			// create the set of categories based on the movie list
			for (Movies thisMovie : movieList) {
				catSet.add(thisMovie.getCategory());
			}
			
			Header();
			Menu();
			
			do {
				System.out.print("Choose an from the options in the categories (enter any number between 1-7, 0 exits): ");
				try {
					userCategorySelect = scnr.nextInt(); 
					scnr.nextLine(); 
					
				} catch (Exception e) {
					System.out.println("Please enter an number between 1-7: "); 
					scnr.nextLine(); //DUMP
					continue;
				}
				
				switch (userCategorySelect) {
				case 0:
					break;
				case 1:
					movieSet.clear(); // clear the existing movie set
					createMovieSet("animated", movieList); // create the movie set based on string category 'animated'
					displayMovieSet("animated", movieSet); // display the movie set based on what was created in createMovieSet
					break; // end switch case
				case 2: 
					movieSet.clear();
					createMovieSet("comedy", movieList);
					displayMovieSet("comedy", movieSet);
					break;
				case 3:
					movieSet.clear();
					createMovieSet("drama", movieList);
					displayMovieSet("drama", movieSet);
					break;
				case 4:
					movieSet.clear();
					createMovieSet("horror", movieList);
					displayMovieSet("horror", movieSet);
					break;
				case 5:
					movieSet.clear();
					createMovieSet("musical", movieList);
					displayMovieSet("musical", movieSet);
					break;
				case 6:
					movieSet.clear();
					createMovieSet("scifi", movieList);
					displayMovieSet("scifi", movieSet);
					break;
				default:
					System.out.println("You have entered an invalid number");
					continue;
				}
				
				System.out.print("Would you like to choose another category? (y or Y to continue, any other key exits): ");
				userCon = scnr.nextLine();
				if (userCon.equalsIgnoreCase("y")) {
					System.out.println();
					Menu();
				}
				
			} while (userCon.equalsIgnoreCase("y"));
			
			System.out.println("Goodbye!");
			scnr.close();
		}
		
		private static void Menu() {
			// TODO Auto-generated method stub
			
		}

		public static void Header(){
			System.out.println("Welcome to the movie app!");
			System.out.println();
		}
		
		public static void DisplayMenu() {
			System.out.println("There are 20 movies in this list. Please choose a catagory!");
			System.out.println("1. Animated");
			System.out.println("2. Comedy");
			System.out.println("3. Drama");
			System.out.println("4. Horror");
			System.out.println("5. Musical");
			System.out.println("6. SI-FI");
			System.out.println("");
		}
		
		public static void createMovieSet(String category, List<Movies> movieList) {
			for(Movies movie : movieList) {
				if(movie.getCategory() == category) {
					movieSet.add(movie.getTitle());
				}
			}
		}
		
		public static void displayMovieSet(String category, Set<String> movieSet) {
			System.out.println();
			System.out.println("Enjoy viewing" + category + " movies.");
			for (String movie : movieSet) {
				System.out.println(movie);
			}
			System.out.println();
		}
		
	}

