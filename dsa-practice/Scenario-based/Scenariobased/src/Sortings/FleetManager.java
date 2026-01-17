package Sortings;

class CropMonitor {

    static class SensorData {
        long timestamp;
        double temperature;

        SensorData(long timestamp, double temperature) {
            this.timestamp = timestamp;
            this.temperature = temperature;
        }
    }

    static void quickSort(SensorData[] data, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(data, low, high);
            quickSort(data, low, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, high);
        }
    }

    static int partition(SensorData[] data, int low, int high) {
        long pivot = data[high].timestamp;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (data[j].timestamp < pivot) {
                i++;
                SensorData temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        SensorData temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        SensorData[] readings = {
            new SensorData(1705123000, 28.5),
            new SensorData(1705121000, 26.8),
            new SensorData(1705125000, 29.1),
            new SensorData(1705122000, 27.4)
        };

        quickSort(readings, 0, readings.length - 1);

        System.out.println("Sorted Sensor Data by Timestamp:");
        for (SensorData s : readings) {
            System.out.println("Time: " + s.timestamp + " Temp: " + s.temperature);
        }
    }
}

