/*  v1
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package res;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.json.*;
public class TestMethod {
    public static JsonObject updateJsonObj(JsonObject obj,String objKey, String newval){
        JsonObjectBuilder jobuilder=Json.createObjectBuilder();
        for(String key : obj.keySet()) {
            if(key.equals(objKey)){
                jobuilder.add(key, newval);
            }
            else{
                jobuilder.add(key, obj.get(key));
            }
         }
                obj = jobuilder.build();
    return obj;
    }
    public static JsonArray viewDetailsByID(JsonArray allProperty,String id) {
        JsonObject obj = null;
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("id", id);
        JsonObject param = jsonObjBuilder.build();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (int i = 0; i < allProperty.size(); i++) {
            obj = allProperty.getJsonObject(i);
            if(obj.get("id").equals(param.get("id"))){
            arrayBuilder.add(obj);             
            }
        }
        JsonArray newArr = arrayBuilder.build();
        return newArr;
    } 
    public static JsonArray delPropertyByID(JsonArray allProperty,String id){
        JsonObject obj = null;
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("id", id);
        JsonObject param = jsonObjBuilder.build();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (int i = 0; i < allProperty.size(); i++) {
            obj = allProperty.getJsonObject(i);
            if(!obj.get("id").equals(param.get("id"))){
                arrayBuilder.add(obj);             
            }
            
        }
        JsonArray newArr = arrayBuilder.build();
        return newArr;
    }   
    public static JsonArray searchProperty(JsonArray allProperty,String t1,String l2,String s3) {
        JsonObject obj = null;
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("typeofproperty", t1);
        jsonObjBuilder.add("location", l2);
        jsonObjBuilder.add("size", s3);
        JsonObject param = jsonObjBuilder.build();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (int i = 0; i < allProperty.size(); i++) {
            obj = allProperty.getJsonObject(i);
            if(obj.get("typeofproperty").equals(param.get("typeofproperty"))
                || obj.get("location").equals(param.get("location"))
                || obj.get("size").equals(param.get("size"))){
                    arrayBuilder.add(obj);             
            }
        }
        JsonArray newArr = arrayBuilder.build();
        return newArr;
    } 

    public static JsonArray createJasonArray(JsonObject obj) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        arrayBuilder.add(obj);
        JsonArray ar = arrayBuilder.build();
        return ar;
    }
    public static JsonObject createproperty(String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("id", s1);jsonObjBuilder.add("name", s2);
        jsonObjBuilder.add("price", s3);jsonObjBuilder.add("typeofproperty", s4);
        jsonObjBuilder.add("location", s5);jsonObjBuilder.add("size", s6);
        jsonObjBuilder.add("yearbuilt", s7);
        JsonObject jsonObj = jsonObjBuilder.build();
        return jsonObj;
    }
    public static void persist(JsonArray obj, String filename) {
        try (JsonWriter jsonWriter = Json.createWriter(new FileWriter(filename))) {
            jsonWriter.writeArray(obj);
            System.out.println("Object was written to " + filename);
        } catch (IOException ex) {
            System.out.println("Writing object failed... " + ex);
        }
    }
     public static JsonArray addJsonToArray(JsonArray jar, JsonObject job) {
        JsonObject obj = null; boolean found=false; String newsize="";String newprice;
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (int i = 0; i < jar.size(); i++) {
            obj = jar.getJsonObject(i);
            if(obj.get("id").equals(job.get("id"))){
                newsize=job.get("size").toString();
                obj= TestMethod.updateJsonObj(obj, "size", newsize);
                newprice=job.get("price").toString();
                obj= TestMethod.updateJsonObj(obj, "price", newprice);
            }
            arrayBuilder.add(obj);
           
        }
         arrayBuilder.add(job);
        JsonArray newArr = arrayBuilder.build();
        return newArr;
    }
    public static JsonArray readArray(String filename) {
        System.out.println("\nReading object from file " + filename);
        try {
            JsonReader jsonReader = Json.createReader(new FileReader(filename));
            JsonArray obj = jsonReader.readArray();
            System.out.println("Your Array was read from file " + filename);
            return obj;
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't find file " + ex);
            return null;
        }
    }
    public static String tellMeAbout(JsonArray ar) {
        String arrData = "", clean="";
        System.out.println("\n About your array ......................................");
        for (int i = 0; i < ar.size(); i++) {
            arrData = arrData + "<tr>";
            JsonObject obj = ar.getJsonObject(i);
            for (String name : obj.keySet()) {
                JsonValue jv = obj.get(name);// replaceAll("\"", "")
                clean = jv.toString().replaceAll("\"", "");
                System.out.println("cleaned:   "+ clean);
                arrData = arrData + "<td>" + clean + "</tc>";
            }
            arrData = arrData + "</tr>";

        }
        return arrData;
    }
    public static String tellMeAbout(JsonObject obj) {
        String data = "",clean="";
        System.out.println("\nAbout your object ......................................");
        for (String name : obj.keySet()) {
            JsonValue jv = obj.get(name);
            clean = jv.toString().replaceAll("\"", "");

            data = data + "<br>" + name + "\n";
            //System.out.printf("%-20s is type %-10s with value %s%n", name, jv.getValueType(), jv);
        }
        return data;
    }

    public static void ArrayIterate(JsonArray ar) {
        for (int i = 0; i < ar.size(); i++) {
            JsonValue jv = (JsonValue) ar.get(i);
            JsonObject j = ar.getJsonObject(i);
            System.out.printf("At index %s is %8s  %-10s%n", i, jv.getValueType(), jv);

        }
    }
    public static void DeleteFile(String filename) {
        File myObj = new File(filename);
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void main(String[] args) {
        JsonArray myAr = TestMethod.createJasonArray(TestMethod.createproperty(
                "id value", "name value", "price value","typeofproperty value","location value","size value","yearbuilt value"));               
        System.out.println("Made a JSON array " + myAr);
        TestMethod.tellMeAbout(myAr);
        String fname = "JSON.txt";
        TestMethod.persist(myAr, fname);

        //Read it back
        JsonArray data = TestMethod.readArray(fname);
        System.out.println("read JSON object " + data);

    }
}
