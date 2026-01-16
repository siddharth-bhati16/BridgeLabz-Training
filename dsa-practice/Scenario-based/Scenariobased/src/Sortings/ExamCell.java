package Sortings;

class ExamCell {

    static class Student {
        String name;
        double score;

        Student(String name, double score) {
            this.name = name;
            this.score = score;
        }

        void display() {
            System.out.println(name + " | Score: " + score);
        }
    }

    static void mergeSort(Student[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(Student[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i].score >= R[j].score) { 
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void displayRanks(Student[] arr) {
        System.out.println("Ranked Students:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Rank " + (i + 1) + ": ");
            arr[i].display();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Student[] center1 = {
            new Student("ram", 88),
            new Student("gopal", 75),
            new Student("utkarsht", 90)
        };

        Student[] center2 = {
            new Student("ravi", 85),
            new Student("shyam", 92),
            new Student("sonam", 78)
        };

        Student[] allStudents = new Student[center1.length + center2.length];
        int index = 0;
        for (Student s : center1) allStudents[index++] = s;
        for (Student s : center2) allStudents[index++] = s;

        System.out.println("Before Sorting:");
        for (Student s : allStudents) s.display();

        mergeSort(allStudents, 0, allStudents.length - 1);

        System.out.println("\nAfter Sorting (Ranked List):");
        displayRanks(allStudents);
    }
}

