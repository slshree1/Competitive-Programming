// 96A - Football
// http://codeforces.com/problemset/problem/96/A
// Farwa Naqi

import java.util.*;
import java.lang.*;
import java.io.*;

public class football
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// Input
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int counter = 1;
		char curr = s.charAt(0);
		
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != curr) {
				counter = 1;
				curr = c; 
			} else {
				counter++;
				if (counter == 7) break;
			}
		}

		String output = (counter >= 7) ? "YES" : "NO";
		System.out.println(output);
	}	
}