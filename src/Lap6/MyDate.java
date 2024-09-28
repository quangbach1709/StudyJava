package Lap6;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private String[] strMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
    private String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        if (isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        } else {
            System.out.println("Invalid date!");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0; //kiem tra nam nhuan
    }

    public boolean isValidDate(int year, int month, int day) { //kiem tra ngay thang nam hop le
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        if (isLeapYear(year) && month == 2) {
            return day <= 29;
        }
        return day <= daysInMonth[month - 1];
    }

    public int getDayOfWeek(int year, int month, int day) {//tinh ngay cua tuan
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31 * m0) / 12) % 7;
        return d0;
    }

    @Override
    public String toString() {
        return strDays[getDayOfWeek(year, month, day)] + " " + day + " " + strMonths[month - 1] + " " + year;
    }

    public MyDate nextDay() {
        if (isValidDate(year, month, day + 1)) {
            return new MyDate(year, month, day + 1);
        } else if (isValidDate(year, month + 1, 1)) {
            return new MyDate(year, month + 1, 1);
        } else {
            return new MyDate(year + 1, 1, 1);
        }
    }

    public MyDate nextMonth() {
        if (isValidDate(year, month + 1, day)) {
            return new MyDate(year, month + 1, day);
        } else {
            return new MyDate(year + 1, 1, day);
        }
    }

    public MyDate nextYear() {
        return new MyDate(year + 1, month, day);
    }

    public MyDate previousDay() {
        if (isValidDate(year, month, day - 1)) {
            return new MyDate(year, month, day - 1);
        } else if (isValidDate(year, month - 1, daysInMonth[month - 2])) {
            return new MyDate(year, month - 1, daysInMonth[month - 2]);
        } else {
            return new MyDate(year - 1, 12, 31);
        }
    }

    public MyDate previousMonth() {
        if (isValidDate(year, month - 1, day)) {
            return new MyDate(year, month - 1, day);
        } else {
            return new MyDate(year - 1, 12, day);
        }
    }

    public MyDate previousYear() {
        return new MyDate(year - 1, month, day);
    }
    
}
