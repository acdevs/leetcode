public class P0012_IntegertoRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(456));
    }
    static String intToRoman(int num) {
        String roman = "";
        String[] chars = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] integers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        for(int i = 0; i < 13; i++){
            int integer = integers[i];
            if( num >= integer){
                for(int j = 0; j < (num / integer); j++){
                    roman += chars[i];
                }
                num %= integer;
            }
        }
        return roman;
    }
}
