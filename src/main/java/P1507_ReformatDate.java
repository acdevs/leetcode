public class P1507_ReformatDate {
    public static void main(String[] args) {
        String date = "3st Jun 1933";
        System.out.println(reformatDate(date));
    }

    static String reformatDate(String date) {
        StringBuilder DATE = new StringBuilder();
        String elems[] = date.split(" ");
        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        elems[0] = elems[0].substring(0, elems[0].length() - 2);
        for (int i = 0; i < months.length; i++) {
            if(elems[1].equals(months[i])) elems[1] = String.valueOf(i + 1);
        }
        for (int i = 2; i >= 0; i--) {
            if (elems[i].length() == 1) DATE.append(0).append(elems[i]);
            else DATE.append(elems[i]);
            if(i != 0) DATE.append('-');
        }
        return DATE.toString();
    }
}
