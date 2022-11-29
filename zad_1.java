/* 
Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. 
Данные для фильтрации приведены ниже в виде json строки. Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.HashSet;


public class zad_1 {
    public static void main(String[] args) throws ParseException {
        String myString = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String startString = "select * from students where ";
        System.out.println(jsonToSql(parseJson(myString), startString));
    }

    public static JSONObject parseJson(String myJSON) throws ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(myJSON);
        JSONObject jsonObj = (JSONObject) obj;
        return jsonObj;
    }

    public static String jsonToSql(JSONObject myJSON, String myString) {
      StringBuilder myBuilder = new StringBuilder();
      myBuilder.append(myString);
      HashSet <String> keys = new HashSet<>();
        keys.addAll(myJSON.keySet());
        int n = 0;
        for (String item:keys
             ) {
            if(!myJSON.get(item).toString().equals("null")) {
                if (n > 0) {
                    myBuilder.append(" and ");
                }
                myBuilder.append(String.format("%s = %s", item, myJSON.get(item)));
                n++;
            }
        }
        
        return myBuilder.toString();
    };

}