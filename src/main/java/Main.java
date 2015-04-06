public class Main {

    public static void main(String[] args) {
        String fileName = System.getProperty("user.home")+"/Desktop/msncomplete2-trial.csv";
        System.out.println("\nRead CSV file: "+fileName);
        CsvFileReader.readCsvFile(fileName);
    }
}