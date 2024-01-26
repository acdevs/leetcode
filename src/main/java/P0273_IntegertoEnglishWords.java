public class P0273_IntegertoEnglishWords {
    public static void main(String[] args) {
        int num = 2145893475;
        System.out.println(numberToWords((num)));
    }
    static String numberToWords(int num) {
        String words = "";
        String[] notes = {"Billion ", "Million ", "Thousand ", "Hundred "};
        String[] ones = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        String[] tens = {"Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        String[] tensone = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        int len = (int)Math.log10(num) + 1;
        int size = len;
        int div, trip, pos, posdigit, carry = 0, ifnotes = 0;
        if(num == 0){
            return "Zero";
        }
        for(int i = 0; i < len; i++){
            div = (int)Math.pow(10, size - 1);
            trip = (size + 2) / 3;
            pos = (size + 2) % 3;
            posdigit = num / div;
            if(trip == 4){
                if(pos == 0){
                    words += ones[posdigit - 1];
                    words += notes[0];
                }
            }
            if(trip == 3){
                if(pos == 2){
                    if(posdigit == 0){
                        ifnotes += 1;
                    }else {
                        words += ones[posdigit - 1];
                        words += notes[3];
                    }
                }else if(pos == 1){
                    if(posdigit == 1) {
                        carry = 1;
                    }else if(posdigit == 0){
                        ifnotes += 1;
                    }else{
                        words += tens[posdigit - 2];
                    }
                }else if(pos == 0){
                    if(carry == 1){
                        words += tensone[posdigit];
                    }else if(posdigit == 0){
                        ifnotes += 1;
                    }else{
                        words += ones[posdigit - 1];
                    }
                    carry = 0;
                    if(ifnotes != 3){
                        words += notes[1];
                    }
                    ifnotes = 0;
                }

            }
            if(trip == 2){
                if(pos == 2){
                    if(posdigit == 0){
                        ifnotes += 1;
                    }else {
                        words += ones[posdigit - 1];
                        words += notes[3];
                    }
                }else if(pos == 1){
                    if(posdigit == 1){
                        carry = 1;
                    }else if(posdigit == 0){
                        ifnotes += 1;
                    }else{
                        words += tens[posdigit - 2];
                    }
                }else if(pos == 0){
                    if(carry == 1){
                        words += tensone[posdigit];
                    }else if(posdigit == 0){
                        ifnotes += 1;
                    }else{
                        words += ones[posdigit - 1];
                    }
                    carry = 0;
                    if(ifnotes != 3){
                        words += notes[2];
                    }
                    ifnotes = 0;

                }
            }
            if(trip == 1){
                if(pos == 2){
                    if(posdigit == 0){
                        ifnotes += 1;
                    }else {
                        words += ones[posdigit - 1];
                        words += notes[3];
                    }
                }else if(pos == 1){
                    if(posdigit == 1){
                        carry = 1;
                    }else{
                        words += posdigit == 0 ? "" : tens[posdigit - 2];
                    }
                }else if(pos == 0){
                    if(carry == 1){
                        words += tensone[posdigit];
                    }else{
                        words += posdigit == 0 ? "" : ones[posdigit - 1];
                    }
                    carry = 0;
                }
            }
            num %= div;
            size -= 1;
        }
        return words.trim();
    }
}

