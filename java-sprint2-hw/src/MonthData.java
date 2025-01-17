public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }
        int sumStepsFromMonth() {
            int sumSteps = 0;
            for (int i = 0; i < days.length; i++) {
                sumSteps += days[i];
            }
            return sumSteps;
        }

        int maxSteps() {
            int maxSteps = 0;
            for (int i = 0; i < days.length; i++) {
                if (maxSteps < days[i]) {
                    maxSteps = days[i];
                }
            }
            return maxSteps;
        }

            int bestSeries(int goalByStepsPerDay) {
                int currentSeries = 0;
                int finalSeries = 0;
                for (int i = 0; i < days.length; i++) {
                    if (goalByStepsPerDay <= days[i]) {
                        currentSeries++;
                        if (currentSeries > finalSeries) {
                            finalSeries = currentSeries;
                        }
                    } else {
                        currentSeries = 0;
                    }
                }
                return finalSeries;
            }

            int averageSteps() {
                int averageSteps = sumStepsFromMonth() / days.length;
                return averageSteps;
            }
        }


