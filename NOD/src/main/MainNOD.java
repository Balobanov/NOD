package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainNOD {

	public static void main(String[] args) {

		int numbers[] = new int[]{12, 24, 23, 33, 12, 12, 33, 55};
		System.out.println("The NOD of numbers: " + Arrays.toString(numbers) + " = " + NOD(numbers));
	}

	// Find NOD of numbers
	public static int NOD(int [] numbers)
	{
		// Map of numbers and their divisors  
		Map<Integer, List<Integer>> divisors = new HashMap<>();
		
		for(int i = 0; i < numbers.length; i++)
		{
			// Computing divisors for first number
			int num = numbers[i];
			
			// If map yet does not contain the number add it there
			// if map contain the number that go to the next number
			if(!divisors.containsKey(num))
				divisors.put(num, new ArrayList<Integer>());
			else
				continue;
			
			// Computing divisors of numbers
			for(int j = 1; j <= num; j++)
			{
				if(num % j == 0)
					divisors.get(num).add(j);
			}
			
			System.out.println("divisors of " + num + divisors.get(num));
		}
		
		// Find max value
		int maxValue = Collections.max(divisors.keySet());
		int maxDiv = 1; // At the beginning max divisor is 1
		
		// Flag for finding matching in all divisors
		// When flag will contain size of map meaning what divisor the same for all numbers
		int flag = 0; 
		
		// Get all divisors for max value
		List<Integer> divOfMaxValue = divisors.get(maxValue);
		
		// Finding the NOD
		for(Integer i: divOfMaxValue)
		{
			// Checking divisor for another numbers
			for(int n = 0; n < numbers.length; n++)
			{
				//If have been matched increase flag
				if(divisors.get(numbers[n]).contains(i))
					flag++;
			}
			
			// If matched for all numbers
			// Save divisor
			if(flag == divisors.size())
				maxDiv = i;
			flag = 0;
		}
	
		return maxDiv;
	}
}
