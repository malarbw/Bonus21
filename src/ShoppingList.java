import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cont = "y";
		System.out.println("Welcome to Brad's Fruit Market!");
		System.out.println();
		ArrayList<Products> inventory = new ArrayList<Products>();
		ArrayList<Products> cart = new ArrayList<Products>();
		inventory.add(new Products("Mango", 2.99));
		inventory.add(new Products("Apple", 0.99));
		inventory.add(new Products("Orange", 1.49));
		inventory.add(new Products("Banana", 0.69));
		inventory.add(new Products("Lemon", 0.99));
		inventory.add(new Products("Dragon Fruit", 3.99));
		inventory.add(new Products("Papaya", 1.99));
		inventory.add(new Products("Pineapple", 2.49));

		displayList(inventory);
		System.out.println();
		while (cont.equalsIgnoreCase("y")) {
			String fruit = Validator.getString(scan, "Which fruit would you like to order?");

			addItem(inventory, cart, fruit);
			cont = Validator.getString(scan, "Would you like to add another fruit?");

		}
		System.out.println();
		displayList(cart);
		lowCost(cart);
		highCost(cart);
		getAvg(cart);
		System.out.println("Thanks for shopping!");
	}

	public static void highCost(ArrayList<Products> cart) {
		double maxPrice = 0.0;
		for (Products i : cart) {
			if (maxPrice < i.getPrice()) {
				maxPrice = i.getPrice();
			}
		}
		System.out.println("Most expensive fruit costs: $" + maxPrice);
	}
	
	public static void lowCost (ArrayList<Products> cart) {
		double minPrice = 3.99;
			for (Products i : cart) {
				if (minPrice > i.getPrice()) {
					minPrice = i.getPrice();
				}
			}
			System.out.println("Least expensive fruit costs: $" + minPrice);
		 }

	public static void getAvg(ArrayList<Products> cart) {
		double sum = 0;
		for (Products i : cart) {
			sum += i.getPrice();
		}
		double avg = sum / cart.size();
		System.out.println("Average price per item: " + avg);
	}

	public static void addItem(ArrayList<Products> inventory, ArrayList<Products> cart, String fruit) {
		switch (fruit) {
		case "mango":
			cart.add(inventory.get(0));
			break;
		case "apple":
			cart.add(inventory.get(1));
			break;
		case "orange":
			cart.add(inventory.get(2));
			break;
		case "banana":
			cart.add(inventory.get(3));
			break;
		case "lemon":
			cart.add(inventory.get(4));
			break;
		case "dragon":
			cart.add(inventory.get(5));
			break;
		case "papaya":
			cart.add(inventory.get(6));
			break;
		case "pineapple":
			cart.add(inventory.get(7));
			break;
		default:
			System.out.println("Error: we do not carry this fruit!");
		}
	}

	public static void displayList(ArrayList<Products> inventory) {
		String s = String.format("%-15s %10s\n", "Item", "Price");
		String s1 = String.format("%-15s %10s\n", "----", "-----");
		System.out.println(s);
		System.out.println(s1);
		for (Products i : inventory) {
			System.out.print(i);
		}
	}

}
