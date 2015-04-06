import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * @author iyoung
 *
 */
public class CsvFileReader {

    //CSV file header
    private static final String [] FILE_HEADER_MAPPING = {"object_name","firstcreated","date_created","time_created", "copyrightnotice", "orientation", "supplemental_category",
            "city", "category","usageterms", "language","credit" ,"byline" ,"description_text" ,"copyrightholder" ,"caption_writer" ,"uri" ,
            "urn" ,"type" ,"version_created" ,"original_reference","headline", "keywords","starred","sample_image_name","full_rendition","production_dimensions"};

    public static void readCsvFile(String fileName) {

        FileReader fileReader = null;

        CSVParser csvFileParser = null;

        //Create the CSVFormat object with the header mapping
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);

        try {
            //initialize FileReader object
            fileReader = new FileReader(fileName);

            //initialize CSVParser object
            csvFileParser = new CSVParser(fileReader, csvFileFormat);
            int i=1;

            /*for (CSVRecord csvRecord : csvFileParser) {
                i++;
                System.out.println("Record " + i + " read");
            }*/

            Iterator<CSVRecord> csvIt = csvFileParser.iterator();
            boolean run=true;
            while (run){
                i++;
                try{
                    run = csvIt.hasNext();
                }catch(Exception e){
                    i--;
                    System.out.println("Broken line " + i);
                    continue;
                }
                if (!run){
                    break;
                }
                try{
                    CSVRecord csvRecord = csvIt.next();
                } catch(Exception e){
                    System.out.println("Broken line skip " + i);
                }
            }

        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader/csvFileParser !!!");
                e.printStackTrace();
            }
        }

    }

}