/*Print the following pattern for the given number of rows.

Pattern for N = 4
1234 
1234 
1234 
1234 */

package lecture3;
import java.util.Scanner;

public class pattern3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while (i <= n) {
			int j = 1;
			while (j <= n) {
				System.out.print(j);
				j++;
			}
			System.out.println(" ");
			i++;
		}

	}

}