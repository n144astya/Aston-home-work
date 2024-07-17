package homework.lesson_2;

import java.time.LocalTime;

public class Park {

    private Attraction[] attractions;
    private String name;

    public Park(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attraction[] getAttractions() {
        return attractions;
    }

    public void setAttractions(Attraction[] attractions) {
        this.attractions = attractions;
    }

    public class Attraction {

        private String name;
        private LocalTime openTime;
        private LocalTime closeTime;
        private double price;

        public Attraction(String name, LocalTime openTime, LocalTime closeTime, double price) {
            this.name = name;
            this.openTime = openTime;
            this.closeTime = closeTime;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalTime getOpenTime() {
            return openTime;
        }

        public void setOpenTime(LocalTime openTime) {
            this.openTime = openTime;
        }

        public LocalTime getCloseTime() {
            return closeTime;
        }

        public void setCloseTime(LocalTime closeTime) {
            this.closeTime = closeTime;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
