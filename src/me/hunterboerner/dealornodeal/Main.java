package me.hunterboerner.dealornodeal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Deal or No Deal");
		int[] cases;
		cases = new int[26];
		Random rn = new Random();
		List<Integer> dontRepeat = Collections.synchronizedList(new ArrayList<Integer>(26));
		for (int i = 0; i < 26; i++) {
			int rnum = rn.nextInt(26);
			if (!dontRepeat.contains(rnum)) {
				dontRepeat.add(rnum);

			} else {
				i--;
				continue;
			}

			cases[i] = caseHandler.caseHandler(rnum);
			System.out.println("Created case " + i + " with value of: "
					+ cases[i]);
			
			System.out.println();
			System.out.println("Please select a case");

		}

	}

	
}
