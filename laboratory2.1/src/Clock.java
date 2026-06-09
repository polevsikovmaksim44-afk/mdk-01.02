public class Clock {
    private int hours;
    private int minutes;

    public Clock(int hours, int minutes) {
        setTime(hours, minutes);
    }

    public void setTime(int hours, int minutes) {
        this.hours = hours % 24;
        this.minutes = minutes % 60;
    }

    public void tick() {
        minutes++;

        if (minutes == 60) {
            minutes = 0;
            hours = (hours + 1) % 24;
        }
    }

    public String getTime() {
        return String.format("%02d:%02d", hours, minutes);
    }
}