package process;

import standard.Standard;

import java.util.ArrayList;
import java.util.List;

public class Analyzer {

    public List<String> analyzeContent(String content){
        List<String> names = new ArrayList<>();
        String[] nameArr = content.split(Standard.INPUT_CONTENT_SPLIT_VAL);
        for(int i=0; i<nameArr.length; i++){
            names.add(nameArr[i].trim());
        }
        return names;
    }

    public void decider(){

    }
}
