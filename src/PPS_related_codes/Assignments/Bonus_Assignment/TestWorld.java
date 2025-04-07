package PPS_related_codes.Assignments.Bonus_Assignment;

class City {
    String name;
    int population;
    City next;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
        this.next = null;
    }
}

class Country {
    String name;
    Country prev, next;
    City cityHead;

    public Country(String name) {
        this.name = name;
        this.cityHead = null;
    }

    public void addCity(String name, int population) {
        City newCity = new City(name, population);
        if (cityHead == null) {
            cityHead = newCity;
        } else {
            City temp = cityHead;
            while (temp.next != null) temp = temp.next;
            temp.next = newCity;
        }
    }
}

class World {
    Country head, tail;

    public void addCountry(String name) {
        Country newCountry = new Country(name);
        if (head == null) {
            head = tail = newCountry;
        } else {
            tail.next = newCountry;
            newCountry.prev = tail;
            tail = newCountry;
        }
    }

    public Country findCountry(String name) {
        Country temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void swapCitiesWithExtremePopulation() {
        Country minCountry = null, maxCountry = null;
        City minCity = null, maxCity = null;
        City minPrev = null, maxPrev = null;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        Country currCountry = head;
        while (currCountry != null) {
            City prev = null, city = currCountry.cityHead;
            while (city != null) {
                if (city.population < min) {
                    min = city.population;
                    minCity = city;
                    minPrev = prev;
                    minCountry = currCountry;
                }
                if (city.population > max) {
                    max = city.population;
                    maxCity = city;
                    maxPrev = prev;
                    maxCountry = currCountry;
                }
                prev = city;
                city = city.next;
            }
            currCountry = currCountry.next;
        }

        if (minCity == null || maxCity == null || minCity == maxCity) return;

        // Swap nodes (not just values)
        if (minPrev != null) minPrev.next = maxCity;
        else minCountry.cityHead = maxCity;

        if (maxPrev != null) maxPrev.next = minCity;
        else maxCountry.cityHead = minCity;

        City temp = minCity.next;
        minCity.next = maxCity.next;
        maxCity.next = temp;
    }

    public void printWorld() {
        Country c = head;
        while (c != null) {
            System.out.println("Country: " + c.name);
            City city = c.cityHead;
            while (city != null) {
                System.out.println("  City: " + city.name + ", Population: " + city.population);
                city = city.next;
            }
            c = c.next;
        }
    }
}

public class TestWorld {
    public static void main(String[] args) {
        World world = new World();

        world.addCountry("Canada");
        world.addCountry("USA");

        world.findCountry("Canada").addCity("Toronto", 600);
        world.findCountry("Canada").addCity("Vancouver", 2500000);
        world.findCountry("USA").addCity("New York", 8400000);
        world.findCountry("USA").addCity("Los Angeles", 4000000);
        world.findCountry("USA").addCity("Tiny Town", 50000); // Smallest

        System.out.println("Before Swap:");
        world.printWorld();

        world.swapCitiesWithExtremePopulation();

        System.out.println("\nAfter Swap:");
        world.printWorld();
    }
}

