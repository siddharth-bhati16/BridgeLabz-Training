package Week2;

public class FoodFest {

    static class Stall {
        String name;
        int footfall;
        int zoneOrder;

        Stall(String name, int footfall, int zoneOrder) {
            this.name = name;
            this.footfall = footfall;
            this.zoneOrder = zoneOrder;
        }
    }

    public static void mergeSort(Stall[] stalls, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(stalls, left, mid);
            mergeSort(stalls, mid + 1, right);
            merge(stalls, left, mid, right);
        }
    }

    private static void merge(Stall[] stalls, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Stall[] L = new Stall[n1];
        Stall[] R = new Stall[n2];

        for (int i = 0; i < n1; i++)
            L[i] = stalls[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = stalls[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].footfall <= R[j].footfall) {
                stalls[k++] = L[i++];
            } else {
                stalls[k++] = R[j++];
            }
        }

        while (i < n1)
            stalls[k++] = L[i++];

        while (j < n2)
            stalls[k++] = R[j++];
    }

    public static void display(Stall[] stalls) {
        for (Stall s : stalls) {
            System.out.println(
                s.name + " | Footfall: " + s.footfall + " | Zone Order: " + s.zoneOrder
            );
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Stall[] masterList = {
            new Stall("Burger ", 120, 1),
            new Stall("Pizza ", 200, 2),
            new Stall("coffee", 200, 3),
            new Stall("biryani", 300, 4),
            new Stall("ice-cream", 250, 5),
            new Stall("Noodles", 300, 6)
        };

        System.out.println("Before Merge Sort:");
        display(masterList);

        mergeSort(masterList, 0, masterList.length - 1);

        System.out.println("After Merge Sort (Master List):");
        display(masterList);
    }
}

