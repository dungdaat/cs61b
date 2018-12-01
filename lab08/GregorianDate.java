public class GregorianDate extends Date {

    private static final int[] MONTH_LENGTHS = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public GregorianDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }

    @Override
    public int dayOfYear() {
        int precedingMonthDays = 0;
        for (int m = 1; m < month; m += 1) {
            precedingMonthDays += getMonthLength(m);
        }
        return precedingMonthDays + dayOfMonth;
    }

    private static int getMonthLength(int m) {
        return MONTH_LENGTHS[m - 1];
    }

    @Override
    public Date nextDate(){
        if(dayOfMonth==getMonthLength(month)) {
            if(month==12){
                Date nextday = new GregorianDate(year+1,1,1);
                return nextday;
            }
            Date nextday = new GregorianDate(year,month+1,1);
            return nextday;
        }
        Date nextday = new GregorianDate(year, month, dayOfMonth+1);
        return nextday;   /** should the return type be Date or GregorianDate??*/
    }
}
