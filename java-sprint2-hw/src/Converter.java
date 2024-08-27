public class Converter {
    int stepToKm = 75;
    int stepToKal = 50;

    int convertToKm(int steps) {
        int distance = steps * stepToKm / 100000;
        return distance;
    }

    int convertToStepsToKilocalories(int steps) {
        int kkal = steps * stepToKal / 1000;
        return kkal;
    }
}
