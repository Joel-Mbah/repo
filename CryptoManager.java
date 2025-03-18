/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This code creates methods that encrypt and deprypt strings using the Caesar encryption and Bellaso.
 * Due: 03/17/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: ___JOEL MBAH_______
*/



/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);
			if (c < LOWER_RANGE || c > UPPER_RANGE) {
				return false; // Character is out of bounds
			}
		}
		return true; // All characters are within bounds



		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		//throw new RuntimeException("method not implemented");	
		    key = key % RANGE; //  to verify that the key is within the valid range
		    if (key < 0) {
		        key += RANGE;  //to verify that the key is non-negative
		    }

		    // Check if the string is within bounds
		    for (char c : plainText.toCharArray()) {
		        if (c < LOWER_RANGE || c > UPPER_RANGE) {
		            return "The selected string is not in bounds, Try again.";
		        }
		    }

		    // Encrypting the string using Caesar Cipher logic
		    StringBuilder encryptedText = new StringBuilder();

		    for (int i = 0; i < plainText.length(); i++) {
		        char c = plainText.charAt(i);

		        // Encrypt each character by shifting it with the key
		        char encryptedChar = (char) ((c - LOWER_RANGE + key) % RANGE + LOWER_RANGE);
		        encryptedText.append(encryptedChar);
		    }

		    return encryptedText.toString();
		

		
		    
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");

		
		    //Had so much trouble with this part so I had to seek help from lines 93 to 96
		    StringBuilder extendedKey = new StringBuilder();
		    int bellasoLength = bellasoStr.length();
		    for (int i = 0; i < plainText.length(); i++) {
		        extendedKey.append(bellasoStr.charAt(i % bellasoLength));
		    }

		    StringBuilder encryptedText = new StringBuilder();

		    for (int i = 0; i < plainText.length(); i++) {
		        char plainChar = plainText.charAt(i);
		        char bellasoChar = extendedKey.charAt(i);

		        int encryptedValue = (plainChar + bellasoChar);  // Add the ASCII values

		        while (encryptedValue > UPPER_RANGE) {
		            encryptedValue -= RANGE;
		        }

		        encryptedValue = (encryptedValue - LOWER_RANGE) % RANGE + LOWER_RANGE;

		        encryptedText.append((char) encryptedValue);
		    }

		    return encryptedText.toString();
		

		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		    key = key % RANGE;

		    StringBuilder decryptedText = new StringBuilder();

		    // use a for loop to walk through each character in the text
		    for (int i = 0; i < encryptedText.length(); i++) {
		        char c = encryptedText.charAt(i);

		        int decryptedChar = c - key;
                      // making sure the decrypted character is within range
		        if (decryptedChar < LOWER_RANGE) {
		            decryptedChar += RANGE; 
		        } else if (decryptedChar > UPPER_RANGE) {
		            decryptedChar -= RANGE; 
		        }
//use the .append funcion to merge the characters to form a single word
		        decryptedText.append((char) decryptedChar);
		    }

		    // Return the decrypted string
		    return decryptedText.toString();
		
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented"); 
		//reverse engineering the bellaso encryption process to come up with the decryption process
		    StringBuilder extendedKey = new StringBuilder();
		    int bellasoLen = bellasoStr.length();
		    for (int i = 0; i < encryptedText.length(); i++) {
		        extendedKey.append(bellasoStr.charAt(i % bellasoLen));
		    }

		    StringBuilder decryptedText = new StringBuilder();

		    for (int i = 0; i < encryptedText.length(); i++) {
		        char encryptedChar = encryptedText.charAt(i);
		        char bellasoChar = extendedKey.charAt(i);

		        int decryptedValue = (encryptedChar - bellasoChar); 

		        while (decryptedValue < LOWER_RANGE) {
		            decryptedValue += RANGE;
		        }

		        decryptedValue = (decryptedValue - LOWER_RANGE) % RANGE + LOWER_RANGE;

		        decryptedText.append((char) decryptedValue);
		    }

		    return decryptedText.toString();
		

		
		    
		}


}
