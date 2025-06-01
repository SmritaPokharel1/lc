package adventofcode;

import java.util.List;
import java.util.Map;

//This is not completed yet will attempt later

public class CrossedWires {


    int xor(int b1, int b2){

        if(b1==1 && b2==1) return 0;

        if(b1==0 && b2==0) return 0;

        return 1;
    }

    int and(int b1, int b2){

        if(b1 == 1 && b2==1) return 1;

        return 0;
    }

    int or(int b1, int b2){

        if(b1==1 || b2 == 1) return 1;

        return 0;
    }

    public static void main(String[] args){

        DataProcessor dataProcessor = new DataProcessor();

        Map<String, Integer> wireInputMap = dataProcessor.getWireMap();
        List<WireData> wireDataList = dataProcessor.getWireData();

        wireInputMap.forEach((key, value) -> System.out.println(key + " = " + value));

        wireDataList.forEach(wd ->
                System.out.println("i1=" + wd.i1 + ", i2=" + wd.i2 + ", op=" + wd.op + ", result=" + wd.result));

    }
}
