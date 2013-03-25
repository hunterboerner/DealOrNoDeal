package me.hunterboerner.dealornodeal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Map<String, String> data = new HashMap<String, String>();
	public static void main(String[] args) {

		System.out.println("Welcome to Deal or No Deal");

		// Todo List
		// TODO Finish the Commands

		// Declare them variables
		
		List<Integer> dontRepeat = Collections
				.synchronizedList(new ArrayList<Integer>(26));
		List<Integer> caseChoices = Collections
				.synchronizedList(new ArrayList<Integer>(26));
		int[] cases;
		cases = new int[26];
		Random rn = new Random();
		Scanner input = new Scanner(System.in);

		// begin the game
		System.out.println("Would you like to load a previous game?");
		String newGame = input.next();
		if (newGame.equalsIgnoreCase("yes")) {
			try {
				SLAPI.load("data.bin");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			
			for (int i = 0; i < 26; i++) {
				int rnum = rn.nextInt(26);
				if (!dontRepeat.contains(rnum)) {
					dontRepeat.add(rnum);

				} else {
					i--;
					continue;
				}
				caseChoices.add(i);
				cases[i] = caseHandler.caseHandler(rnum);
				data.put(i + "", cases[i] + "");
				System.out.println("Created case " + i + " with value of: "
						+ cases[i]);

			}
			for (int i = 0; i < 1; i++) {
				System.out.println("Please choose a case!");
				String inputString = input.next();

				// System.out.println(inputString);
				int inputInt = 0;
				try {
					inputInt = Integer.parseInt(inputString);
					caseChoices.remove(inputInt);
				} catch (NumberFormatException the_input_string_isnt_an_integer) {
					System.out.println("Yo, dat ain't a string!");
					i--;
					continue;
				}
				if (inputInt < 26) {
					System.out.println("You have chosen case number "
							+ inputInt);
				} else {
					System.out
							.println("Nope, that's not a case, you could've lost your hand!");
					i--;
					continue;
				}

				System.out
						.println("Please select 6 cases with a comma after each one: ");
				String sixCasesRaw = input.next();
				String sixCases[] = sixCasesRaw.split(",");
				
				
				for (int i1 = 0; i1<6; i1++) {
					data.put("FSix", sixCases[i1]);
					System.out.println(sixCases[i1]);
				}
				saveThatData();
				
				for(int i2 = 0; i2<6; i2++){
					String caseValue = data.get(sixCases[i2]);
					System.out.println("Case " + i2 + " has " + caseValue + " dollarz in it");
				}
			}
		}

	}

	public static void saveThatData(){
		try {
			SLAPI.save(data, "data.bin");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
