import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void ChangeFile(String newfileName,String oldfileName,List<String> data) {
        FileWriter fiw = null;
        List<String> listfilenew = new ArrayList<>();
        try {
            if(Files.exists(Paths.get(newfileName))){
                listfilenew = readerFile(newfileName);
            }
            fiw = new FileWriter(newfileName,true);
            for(String str : data) {
                if(!listfilenew.contains(str)) {
                    fiw.write(str+"\n");

                    Path path = Paths.get(oldfileName);
                    Files.deleteIfExists(path);
                }
            }
            System.out.println("write to " + newfileName);
            System.out.println("Deleted " + oldfileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (fiw != null) {
                    fiw.close(); // Đóng FileWriter để ghi dữ liệu xuống file
                }
            } catch (IOException e) {
                e.printStackTrace(); // Xử lý ngoại lệ khi đóng FileWriter
            }
        }
    }
    public static List<String> readerFile(String fileName) {
        BufferedReader reader = null;
        List<String> namesList = new ArrayList<>(); // Danh sách để lưu trữ các tên

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                namesList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Không thể đọc từ file " + fileName, e);
        } finally {
            try {
                if (reader != null) {
                    reader.close(); // Đóng BufferedReader sau khi đọc xong
                }
            } catch (IOException e) {
                e.printStackTrace(); // Xử lý ngoại lệ khi đóng BufferedReader
            }
        }
        return namesList;
    }
    public static void main(String[] args) {
        String oldFileName = "fileB.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap file new name: ");
        String newfileName = scanner.nextLine();
        ChangeFile(newfileName,oldFileName,readerFile(oldFileName));
    }
}