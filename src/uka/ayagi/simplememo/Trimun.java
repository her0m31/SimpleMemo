package uka.ayagi.simplememo;

public class Trimun {
	public static String trimming(String s){
		int len = s.length();
		int st = 0;
		char[] val = s.toCharArray();

		while (st < len && (val[st] <= ' ' || val[st] == ' ')) {
			st++;
		}
	    while (st < len && (val[len - 1] <= ' ' || val[len - 1] == '　')) {
	    	len--;
	    }

	    if(st > 0 || len < s.length()) {
	    	return s.substring(st, len);
	    }

	    return s;
	}

	public static boolean trimCheck(String s) {
		return ( s.equals("") || s.equals(" ") || s.equals("　") );
	}
}
