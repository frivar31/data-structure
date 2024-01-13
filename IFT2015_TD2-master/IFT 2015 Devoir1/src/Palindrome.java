
public class Palindrome {
    
    public static boolean checker(String input) {
        if (input.equals(reverse(input))){   //si le mots reverse et le meme que le input alors c'est un palindome
            return true;
        }
        return false;
    }
    public static String Substr(String input, int first, int last){// implementation de substring
        String output = "";
        for (int i = first;  i < last; i++) {
            output+=input.charAt(i);
        }
        return output;

    }
    public static boolean checker_recursive(String input) {
        if (input.length() <= 1) {                          // cas de base
            return true;                                  // notre mot est un palindome
        }
        if (input.charAt(0) != input.charAt(input.length() - 1)) { // on compare le premier caractere avec le dernier
            return false;                                           // c'est pas un palindrom si false
        }
        return checker_recursive((Substr(input,1, input.length() - 1)));// on enleve les deux caractere et
                                                                                    // et on rappel notre fonction
    }
    public static String reverse(String input) {
        String inverse ="";
        for (int i = input.length()-1; i >=0; i--) { // on commence a ajoute les caractere du dernier
            inverse += input.charAt(i);
        }
        return inverse;
    }

    public static String transforme_palindrome(String input) {
        String output = reverse(input);
        return (input+output);              // on ne fait que rajoute le mot avec son inverse
    }

    public static String transforme_palindrome_compacte(String input) {
        String output="";
        if(checker(input)==true){                   // on verfie si le mot est deja in palindorme
            return input;
        }
        for (int i = 0; i < input.length()-1; i++) {
            output+=input.charAt(i);
            if (checker(input+reverse(output))==true){// on verfie si a chaque caractere ajoute
                return input+reverse(output);               // il deviens un palindrome
            }
        }
        return input+reverse(output); // on retourne un palindrome qui n'est pas compacte

}
}