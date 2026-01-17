package Sortings;

class ArtExpo {

    static class Artist {
        String name;
        long registrationTime;

        Artist(String name, long registrationTime) {
            this.name = name;
            this.registrationTime = registrationTime;
        }
    }

    static void insertionSort(Artist[] artists) {
        for (int i = 1; i < artists.length; i++) {
            Artist key = artists[i];
            int j = i - 1;

            while (j >= 0 && artists[j].registrationTime > key.registrationTime) {
                artists[j + 1] = artists[j];
                j--;
            }
            artists[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Artist[] registrations = {
            new Artist("Aarav", 1705121000),
            new Artist("Meera", 1705122000),
            new Artist("Kabir", 1705121500),
            new Artist("Riya", 1705123000)
        };

        insertionSort(registrations);

        System.out.println("Artists Sorted by Registration Time:");
        for (Artist a : registrations) {
            System.out.println(a.name + " - " + a.registrationTime);
        }
    }
}

