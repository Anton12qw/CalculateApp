public class Conventor {
           private double stepLength; // Длина одного шага в Сантиметрах
        private double caloriesPerStep; // Количество калорий, сжигаемых за один шаг

        public Conventor(double stepLength, double caloriesPerStep) {
            this.stepLength = stepLength;
            this.caloriesPerStep = caloriesPerStep;
        }

        public double stepsToSantimetres(int steps) {
            /**
             * Преобразует количество шагов в километры.
             */
            double santimetres = steps * stepLength;
            return santimetres;
        }

        public double stepsToCalories(int steps) {
            /**
             * Преобразует количество шагов в калории.
             */
            double calories = steps * caloriesPerStep;
            return calories;
        }
    }


