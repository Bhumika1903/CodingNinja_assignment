/*Reverse the given string word wise. That is, the last word in given string should come at 1st place, 
last second word at 2nd place and so on. Individual words should remain as it is.

Input format :
String in a single line

Output format :
Word wise reversed string in a single line

Constraints :
0 <= |S| <= 10^7
where |S| represents the length of string, S.

Sample Input 1:
Welcome to Coding Ninjas

Sample Output 1:
Ninjas Coding to Welcome

Sample Input 2:
Always indent your code

Sample Output 2:
code your indent Always*/

public class Reverse_String_Word_Wise {
	public static String reverseWordWise(String input) {
        int i = input.length() - 1;
        int start, end = i + 1;
        String result = "";
        while(i >= 0)
        {
            if(input.charAt(i) == ' ')
            {
               start = i + 1;
               while(start != end){
                    result += input.charAt(start++);
               }
                  result += ' ';
                  end = i;
            }
            i--;
        }
        start = 0;
        while(start != end){
            result += input.charAt(start++);
        }
        return result;
	}

	public static void main(String[] args) {
		String input = "Welcome to Coding Ninjas";
		System.out.println(reverseWordWise(input)); 

	}

}
