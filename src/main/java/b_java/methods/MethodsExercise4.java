package b_java.methods;

import java.util.Arrays;

public class MethodsExercise4 {
/** Check if 2 Strings are the same -and-
	IF NOT SAME -> Check they at least have same chars set & (number + type) !
 	*/
	public static void main(String[] args) {
		System.out.println("Methods exersise 4:\n===================\n");

		/* # 0 */ System.out.println("=> main method\n");
		// Main will run the program with setting the 2 Strings to check-up methods:
		// String A = XYZ  |  String B = ZYX (not the same but contains the same chars)
			String wordA = "abcd";
			String wordB = "abdc";
			System.out.println(wordA + ", " + wordB + " - " + "isEquals (identical Strings): " +
					isEquals(wordA, wordB));
			System.out.println(wordA + ", " + wordB + " - " + "isSameCharsSet (number & tupe): " +
					isSameCharsSet(wordA, wordB));
		}
	// end of main

	/** # 1) this method will: check by comparing Strings to see if equal (get 2 Strings -&- return T \ F) */
	public static boolean isEquals(String word1, String word2) {
		return word1.equals(word2);
	}
	// -----
	
	/** # 2) this method will: check by comparing Strings to see if same length & chars (get 2 Strings -&- return T \ F) */
	// can be separated to 2 different methods
	public static boolean isSameCharsSet(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		} else { // if they do have the same length...
			char[] array1 = word1.toCharArray();
			char[] array2 = word2.toCharArray();
			Arrays.sort(array1);
			Arrays.sort(array2);
			if (Arrays.equals(array1, array2)) {
				return true;
			}else {
				return false;
			}
		}
	}
	// -----
}
//  comments:
/** STUFF TO work with:	
 
 
 //	Method to check if all chars composing Strings are the same (by convert each String to Char array & comparing):
public static boolean method1(String word1, String word2) {
	char[] array1 = word1.toCharArray();
	char[] array2 = word2.toCharArray();
	Arrays.sort(array1);
	Arrays.sort(array2);
	return Arrays.equals(array1, array2);
}

//	Method to check if all
	public static boolean method2(String word1, String word2) {
    if (word1.length() != word2.length()) {
        return false;
    } else { // if they do have the same length...
        char[] array1 = word1.toCharArray();
        for (int i = 0; i < word1.length(); i++) {
            if (!word2.contains(Character.toString(array1[i]))) {
                return false;
            }
        }
        return true;
	}
}
 
 
 
 
 
 * 
	//  Method to check if all chars are the same or not by converting each String to Char array & comparing:
		public static boolean method1(String word1, String word2) {
			char[] array1 = word1.toCharArray();
			char[] array2 = word2.toCharArray();
			Arrays.sort(array1);
			Arrays.sort(array2);
			return Arrays.equals(array1, array2);
		} 
		
	//  Method 2 - 2 options:
		public static boolean method2(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        } else { // if they do have the same length...
            char[] array1 = word1.toCharArray();
            for (int i = 0; i < word1.length(); i++) {
                if (!word2.contains(Character.toString(array1[i]))) {
                    return false;
                }
            }
            return true;
		}
    }
    
//---
	public static boolean method2(String word1, String word2) {
		// check if needed -v-
		boolean isSame = true;
		if (word1.length() != word2.length()) {
			isSame = false;
		}
		// check if needed -v-
		char[] array1 = word1.toCharArray();
		for (int i = 0; i < word1.length(); i++) {
			if (!word2.contains(Character.toString(array1[i]))) {
				isSame = false;
				break;
			}
		}
		return isSame;
	}


// Try 1:
	Arrays.sort(array1);
	Arrays.sort(array2);
	boolean sameChars;
	if(array1==array2){
	sameChars=true;}
	return sameChars

// Try 2: Comment: ENDLESS loop issue ???
	char[] test = name.toCharArray();
    for (int i = 0; i < test.length; i++) {
        if (name.length() == name1.length()) {
            if (){
                return true;
            }
        }

// can use convert to ASCII:
	char character = 'a';    
	int ascii = (int) character;
*/
