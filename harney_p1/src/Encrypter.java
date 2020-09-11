public class Encrypter {

    public String encrypt(String code){

        int [] array  = encryptNumber(code);

        int[] notSortedArray = sortEncryptedNumbers(array);

        String sorted = concatenateArray(notSortedArray);

        return sorted;
    }

    public static int[] encryptNumber (String code){

        int i=0;
        int [] num = new int[4];

        //Do the required encryption using ASCII manipulation
        while(i<code.length()){
            num[i] = code.charAt(i) - '0';
            num[i] += 7;
            num[i] %= 10;
            i++;
        }
        //Return the encrypted digits
        return num;
    }

    public static int [] sortEncryptedNumbers( int [] array){

        int [] newArray = new int[4];

        //Arrange the encrypted digits in the desired way
        newArray[0] = array[2];
        newArray[1] = array[3];
        newArray[2] = array[0];
        newArray[3] = array[1];

        return newArray;
    }

    public String concatenateArray(int [] passedArray) {

        String[] finalNum = new String[4];

        //Transfer the digits from an array to strings
        for (int i = 0; i < passedArray.length; i++) {
            finalNum[i] = String.valueOf(passedArray[i]);
        }

        //Concatenate
        String answer = finalNum[0] + finalNum[1] + finalNum[2] + finalNum[3];

        return answer;
    }
}
