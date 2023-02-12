package Service;

import java.util.List;

public class ReplaceService {

    public Boolean isContainsPassword(String text) {
        return text.matches("^([.\\S\\s]*)(([pP]assword)|([пП]ароль))([.\\S\\s]*)$");
    }

    public String replacePassword(String text) {

        String result = text;
        List<String> stringList = List.of(text
                .replace("\n", " ")
                .replaceAll("[,.!?;:\\t]", "")
                .split(" "));
        for (int i=0; i < stringList.size(); i++) {
            if (stringList.get(i).matches("([pP]assword)|([пП]ароль)")) {
                result = result.replace(stringList.get(i+1), "*".repeat(stringList.get(i+1).length()));
            }
        }
        return result;
    }

}
