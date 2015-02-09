import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class HexConv {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();
		List<String> list5 = new ArrayList<String>();
		List<String> list6 = new ArrayList<String>();
		List<String> list7 = new ArrayList<String>();
		List<String> list8 = new ArrayList<String>();
		List<String> list9 = new ArrayList<String>();
		List<String> list10 = new ArrayList<String>();
		List<String> list11 = new ArrayList<String>();
		List<String> list12 = new ArrayList<String>();
		List<String> list13 = new ArrayList<String>();
		
		list.add(Integer.toHexString(Integer.parseInt("0000000CC", 16)+448));
		list.add(Integer.toHexString(Integer.parseInt("000000120", 16)+448));
		list.add(Integer.toHexString(Integer.parseInt("000000174", 16)+448));
		list.add(Integer.toHexString(Integer.parseInt("0000001B8", 16)+448));
		list.add(Integer.toHexString(Integer.parseInt("0000001DC", 16)+448));
		list.add(Integer.toHexString(Integer.parseInt("000000200", 16)+448));
		list.add(Integer.toHexString(Integer.parseInt("00000025C", 16)+448));
		System.out.println("---");
		for (String string : list) {
			list2.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list2) {
			System.out.println(string);
		}
		
		System.out.println("---");
		for (String string : list2) {
			list3.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list3) {
			System.out.println(string);
		}
		System.out.println("---");
		for (String string : list3) {
			list4.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list4) {
			System.out.println(string);
		}
		
		System.out.println("---");
		for (String string : list4) {
			list5.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list5) {
			System.out.println(string);
		}
		
		
		System.out.println("--list5-");
		for (String string : list5) {
			list6.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list6) {
			System.out.println(string);
		}
		
		System.out.println("--list6-");
		for (String string : list6) {
			list7.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list7) {
			System.out.println(string);
		}
		
		System.out.println("--list7-");
		for (String string : list7) {
			list8.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list8) {
			System.out.println(string);
		}
		
		System.out.println("--list8-");
		for (String string : list8) {
			list9.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list9) {
			System.out.println(string);
		}
		
		System.out.println("--list9-");
		for (String string : list9) {
			list10.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list10) {
			System.out.println(string);
		}
		
		System.out.println("--list10-");
		for (String string : list10) {
			list11.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list11) {
			System.out.println(string);
		}
		
		System.out.println("--list11-");
		for (String string : list11) {
			list12.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list12) {
			System.out.println(string);
		}
		
		System.out.println("--list12-");
		for (String string : list12) {
			list13.add(Integer.toHexString(Integer.parseInt(string, 16)+448));
		}
		for (String string : list13) {
			System.out.println(string);
		}
		
		
	}

}
