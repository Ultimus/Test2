public class LeapYear {
public static int main (String [] args) {
int year = Integer.parseInt (args [0]);


boolean isLeapYear;
// M1 = {Leere menge}
isLeapYear = (year % 4 == 0);
//M2 = {x| x % 4 = 0 ^ x% 100 !=0}
isLeapYear = isLeapYear && (year % 100 != 0);
//M3 = {x| <&4 = 0 ^ x%100 != 0}
isLeapYear = isLeapYear || (year % 400 == 0);
// M4= {x| <% 4 =0 ^(x%100=0 v x % 400 = 0}

System.out.println (isLeapYear);
}
}
