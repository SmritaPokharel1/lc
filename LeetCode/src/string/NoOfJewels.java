package string;

public class NoOfJewels {

    public int numJewelsInStones(String jewels, String stones) {

        int[] jewelAscii = new int[128];

        int noOfJewels = 0;

        for(int i =0; i< jewels.length(); i++){

            char c = jewels.charAt(i);
            jewelAscii[c] ++;
        }

        for(int i =0; i< stones.length(); i++){

            char c = stones.charAt(i);

            if(jewelAscii[c] > 0){
                noOfJewels ++;
            }
        }

        return noOfJewels;
    }
}
