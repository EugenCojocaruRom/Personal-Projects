import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Compare t1 and t2 by using ==
        Time t1 = new Time();
        Time t2 = new Time();
        //== --> Returns false because for objects == does not compare their contents, but their references (memory address)
        System.out.println("t1 == t2 ?: " + (t1 == t2));
        System.out.println("t1: " + t1 + ", t2: " + t2);

        //Time instances
        Time t3 = new Time(5, 10, 15);
        Time t4 = new Time();
        Time t5 = new Time(3, 4, 5);
        Time time1 = new Time(1, 10, 30);
        Time time2 = new Time(12, 35, 48);
        Time time3 = new Time(25, 61, 70);
        Time time4 = new Time(-17, 30, 50);
        Time time5 = new Time(10, -10, 20);
        Time time6 = new Time(15, 12, -50);
        Time time7 = new Time(2, 15, 45);
        Time time8 = new Time(15, 34, 54);

        //Print after calling methods
        System.out.println("\n<=== Time Instances ===>");
        System.out.println("Time instance (constructor with no arguments): " + t3.toString());
        System.out.println("Time instance (getters): " + t4.getHours() + ":" + t4.getMinutes() + ":" + t4.getSeconds());
        System.out.println("Time instance 1: " + time1.toString());
        System.out.println("Time instance 2: " + time2.toString());
        System.out.println("Time instance 3 (wrong values): " + time3.toString());
        System.out.println("Time instance 4 (negative hours): " + time4.toString());
        System.out.println("Time instance 5 (negative minutes): " + time5.toString());
        System.out.println("Time instance 6 (negative seconds): " + time6.toString());

        System.out.println("\n<=== secondsSinceMidnight ===>");
        System.out.println("Seconds since midnight 1: " + t3.secondsSinceMidnight());
        System.out.println("Seconds since midnight 2: " + t4.secondsSinceMidnight());

        System.out.println("\n<=== secondsSince ===>");
        System.out.println("Seconds since other time instance 1: " + t4.secondsSince(time1));
        System.out.println("Seconds since other time instance 2: " + t5.secondsSince(time7));

        System.out.println("\n<=== Instance counter ===>");
        Time time9 = new Time(18, 14, 15);
        System.out.println("Time instance with instance counter 1: " + Time.createInstancesCounter);
        Time time10 = new Time(2, 15, 45);
        System.out.println("Time instance with instance counter 2: " + Time.createInstancesCounter);
        Time time11 = new Time(20, 34, 54);
        System.out.println("Time instance with instance counter 3: " + Time.createInstancesCounter);
        Time time12 = new Time(11, 10, 11);
        System.out.println("Time instance with instance counter 4: " + Time.createInstancesCounter);

        System.out.println("\n<=== TimeUtils ===>");
        System.out.println("TimeUtils instance 1: " + TimeUtils.descriptionOf(time8));
        System.out.println("TimeUtils instance 2: " + TimeUtils.descriptionOf(t3));

        System.out.println("\n<=== isAfter ===>");
        System.out.println("Is " + time8 + " after " + time7 + "? ==> "+ time8.isAfter(time7));
        System.out.println("Is " + time7 + " after " + time8 + "? ==> "+ time7.isAfter(time8));

        //for the findLatest() method
        System.out.println("\n<=== findLatest ===>");
        Time[] timeArray = new Time[4];
        timeArray[0] = time9;
        timeArray[1] = time10;
        timeArray[2] = time11;
        timeArray[3] = time12;

        System.out.println("Comparing the following values: " + Arrays.toString(timeArray));
        Time latest = TimeUtils.findLatest(timeArray);
        if (latest != null) {
            System.out.println("The latest time is: " + latest.toString());
        } else {
            System.out.println("Array was empty!");
        }
    }
}

class Time {

    //Variables of type int for hour, minute and second - private and final
    private final int hours;
    private final int minutes;
    private final int seconds;
    public static int createInstancesCounter = 0;

    //Constructor
//    public Time(int hours, int minutes, int seconds) {
//        if (hours < 0 || hours > 23) {
//            System.out.println("Invalid hours");
//        }
//        else {
//            this.hours = hours;
//        }
//        if (minutes < 0 || minutes > 59) {
//            System.out.println("Invalid minutes");
//        }
//        else {
//            this.minutes = minutes;
//        }
//        if (seconds < 0 || seconds > 59) {
//            System.out.println("Invalid seconds");
//        }
//        else {
//            this.seconds = seconds;
//        }
//    }

    //Constructor with arguments - modified
    public Time(int hours, int minutes, int seconds) {
        int h = 0, m = 0, s = 0;
        if (hours >= 0 && hours <= 23) {
            h = hours;
        }
        if (minutes >= 0 && minutes <= 59) {
            m = minutes;
        }
        if (seconds >= 0 && seconds <= 59) {
            s = seconds;
        }
        this.hours = h;
        this.minutes = m;
        this.seconds = s;

        createInstancesCounter++;
    }

    //Constructor with no arguments
    public Time() {
        this.hours = 23;
        this.minutes = 59;
        this.seconds = 59;

        createInstancesCounter++;
    }

    //Getters - for the constructor with no arguments
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    //Method description() ==> cannot be static because it uses instance fields, and a static method has no access to instance fields
    public String description() { //
        return hours + ":" + minutes + ":" + seconds;
    }

    //Method secondsSinceMidnight()
    public int secondsSinceMidnight() {
        return (hours * 60 + minutes) * 60 + seconds;
    }

    //Method secondsSince(Time)
    public int secondsSince(Time otherTime) {
        return this.secondsSinceMidnight() - otherTime.secondsSinceMidnight();
    }

    public boolean isAfter(Time other) {
        return this.secondsSinceMidnight() > other.secondsSinceMidnight();
        //Alternative
//        return this.secondsSince(other) > 0;
    }

    /*Both System.out.println(t.toString()) and System.out.println(t) produce the same result.
    t.toString() specifically calls the toString method to be applied to 't',
    while println() already uses the toString() method behind the scenes.
    This happens in Java for any object passed to println().*/
    @Override
    public String toString() {
//        return description();
        return hours + ":" + minutes + ":" + seconds;
    }
}

class TimeUtils {
    static String descriptionOf(Time t) {
        int h = t.getHours();
        String suffix = h < 12 ? "AM" : "PM";
        if (h == 0) {
            h = 12; // midnight -> 12 AM
        }
        else if (h > 12) {
            h -= 12; // convert 13-23 to 1-11 PM
        }
        return h + ":" + t.getMinutes() + ":" + t.getSeconds() + " " + suffix;
    }

    static Time findLatest(Time[] times) {
        if (times == null || times.length == 0) {
            return null;
        }
        Time latestOfAll = times[0];
        for (int i = 1; i < times.length; i++) {
            if (times[i].isAfter(latestOfAll)) {
                latestOfAll = times[i];
            }
        }
        return latestOfAll;
    }
}