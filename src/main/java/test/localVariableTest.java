package test;

import java.util.ArrayList;
import java.util.List;

import ipproxypool.Myexception.checkStringNull;
import ipproxypool.Myexception.responseException;

public class localVariableTest {
	
	public static void main(String[] args) {
		/*
		 * String s = "1"; showStr(s); System.out.println(s);
		 */
		for(int i =0;i<4;i++) {
			System.out.println(localVariableTest.showStr(i));
		}
		
	}
	public static String showStr(int s) {
		/* s = s+"1"; */
		//List<String> list = new ArrayList<String>();
		//list.add("show");
		int k=0;
		String[] st = {"show",null,"time","flower"};
		//System.out.println(st[2]);
		try {
			checkStringNull.check(st[s]);
		} catch (responseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(++k);
		//System.out.println(k++);
		return st[s];
		}
}
