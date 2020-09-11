public class Decrypter {

    public String decrypt(String code) {

        int[] array = decryptNumber(code);

        int[] notSortedArray = arrangeDecryptedNumbers(array);

        String sorted = concatenateDecryptArray(notSortedArray);

        return sorted;
    }

    public static int[] decryptNumber(String code) {

        int i = 0;
        int[] num = new int[4];

        //Do the required decryption using ASCII manipulation
        while (i < code.length()) {
            num[i] = code.charAt(i) - '0';
            num[i] += 3;
            num[i] %= 10;
            i++;
        }

        //Return the decrypted digits
        return num;

    }

    public static int[] arrangeDecryptedNumbers(int[] array) {

        int[] newArray = new int[4];

        //Arrange the decrypted digits in the specified format
        newArray[0] = array[2];
        newArray[1] = array[3];
        newArray[2] = array[0];
        newArray[3] = array[1];

        return newArray;
    }

    public static String concatenateDecryptArray(int [] passedArray){

        String [] finalNum = new String [4];

        //Transfer the digits from an array to strings
        for(int i = 0; i<passedArray.length;i++) {
            finalNum[i] = String.valueOf(passedArray[i]);
        }

        //Concatenate
        String answer = finalNum[0] + finalNum[1] + finalNum[2] + finalNum[3];

        return answer;
    }
}
