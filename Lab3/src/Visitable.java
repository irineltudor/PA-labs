import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    default LocalTime getOpeningTime(){

        return LocalTime.of(9,30);
    }

    default LocalTime getClosingTime(){

        return LocalTime.of(20,0);
    }


    static Duration getVisitingDuration(LocalTime a1,LocalTime a2)
    {
        return Duration.between(a1,a2);
    }

}
