package Guangzhou_Hotel;
import java.util.Date;

public class Cancellation {
    private static final int CANCELLATION_FEE = 300;
    private static final int CANCELLATION_DAYS = 5;

    public static int calculateCancellationFee(Date reservationDate){
        long numDays = (new Date().getTime() - reservationDate.getTime()) / (1000 * 60 * 60 * 24);
        if(numDays >= CANCELLATION_DAYS){
            return CANCELLATION_FEE;
        }
        return 0;

    }
}
