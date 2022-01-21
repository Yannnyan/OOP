package Threads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Generate_TaxPayer_Json {

    public static int generate_savings(){// 10 milion range
        return (int)(Math.random() * 10000000);
    }
    public static int generate_income(){
        return (int)(Math.random() * 1000000 + 74800);
    }
    public static String generate_name(){
        // length is 1 to 5 characters
        String name = "";
        int len = (int)(Math.random() * 5)+1;
        char cur;
        boolean bol;
        for (int i = 0; i < len; i++) {
            bol = (int)(Math.random()*2) == 1;
            if (bol)
                cur = (char)(Math.random() * 26 + 65);
            else
                cur = (char)(Math.random() * 26 + 97);
            name = name + cur;
        }
        return name;
    }
    public static void generate_input(int size_kilo) {
        File file = new File("input.json");
        FileWriter tojson = null;
        try {
            tojson = new FileWriter(file);
            tojson.write("");

            int income,savings;
            String name = "", json = "[";
            // name is not more than 5 bytes
            // income is not more than 7 bytes
            // savings is not more than 8 bytes
            // json format is not more than 37 bytes
            for (int i = 0; i < size_kilo * 1000; i+= 57) {
                name = generate_name();
                income = generate_income();
                savings = generate_savings();
                json = json + "{\"name\": \"" + name + "\",\"income\": \"" + income + "\",\"savings\": \"" + savings + "\"}";
                if(i >= size_kilo*1000 -57){
                    break;
                }
                json += ",";
            }
            json += "]";
            tojson.append(json);
            tojson.close();
        }
        catch (IOException e){
            System.out.println("Failed reading");
        }
    }

    public static void main(String[] args){
        generate_input(5);

    }


}
