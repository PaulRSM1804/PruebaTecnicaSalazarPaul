package com.vehiculo.Vehiculo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class PicoYPlacaPredictor {

    private static final LocalTime MORNING_START = LocalTime.of(6, 0);
    private static final LocalTime MORNING_END = LocalTime.of(9, 30);
    private static final LocalTime EVENING_START = LocalTime.of(16, 0);
    private static final LocalTime EVENING_END = LocalTime.of(20, 0);

    private static final Map<Integer, int[]> restrictions = new HashMap<>();

    static {
        restrictions.put(1, new int[]{1, 2}); // Lunes
        restrictions.put(2, new int[]{3, 4}); // Martes
        restrictions.put(3, new int[]{5, 6}); // Miércoles
        restrictions.put(4, new int[]{7, 8}); // Jueves
        restrictions.put(5, new int[]{9, 0}); // Viernes
    }

    public static boolean canCirculate(Vehiculo vehiculo, String date, String time) {
        int lastDigit = vehiculo.getUltimoDigito();
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime localTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        int dayOfWeek = localDate.getDayOfWeek().getValue();

        if (dayOfWeek > 5) {
            return true;  // Fin de semana, no hay restricciones
        }

        if (isRestricted(dayOfWeek, lastDigit)) {
            return !isWithinRestrictedHours(localTime);
        }

        return true;
    }

    private static boolean isRestricted(int dayOfWeek, int lastDigit) {
        int[] restrictedDigits = restrictions.get(dayOfWeek);
        for (int digit : restrictedDigits) {
            if (digit == lastDigit) {
                return true;
            }
        }
        return false;
    }

    private static boolean isWithinRestrictedHours(LocalTime time) {
        return (time.isAfter(MORNING_START) && time.isBefore(MORNING_END)) ||
               (time.isAfter(EVENING_START) && time.isBefore(EVENING_END));
    }
}
