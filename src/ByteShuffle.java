import java.util.*;

public class ByteShuffle {


    /* The goal is to convert a 32-bit integer from Little Endian (Java, iPhone, Xbox) to Big Endian (Intel, TCP, IPv6)
        encoding, and also to other possible encodings as well. This is a very common task in software engineering. In
        Little Endian encoding the first byte contains the most significant bits, and bytes 2, 3, and 4 decrease in
        significance. In Big Endian encoding the first byte contains the least significant bits, and bytes 2, 3 and 4 increase
        in significance
    */

    public static void main( String arg[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int bitOrder = sc.nextInt();

        // Short method single digits from the second input in order to store the order for later use
        
        LinkedList<Integer> stack = new LinkedList<>();
        while (bitOrder > 0) {
            stack.push( bitOrder % 10 );
            bitOrder = bitOrder / 10;
        }

        int one = stack.pop();
        int two = stack.pop();
        int three = stack.pop();
        int four = stack.pop();

        byte [] byteArr = intToByteArray(num);

        int result = convertByteArrayToInt2(byteArr, one, two, three, four);
        System.out.println(result);

    }

    /* This method coverts the number to a byte array */

    static byte[] intToByteArray( int data ) {

        return new byte[] {
                (byte)(data >> 24), // Shifting to first byte position and casting to byte data type
                (byte)(data >> 16),
                (byte)(data >> 8),
                (byte)data
        };

    }

    /* This method converts byte array back to an int, joining each byte with  the OR bitwise operator */

    public static int convertByteArrayToInt2(byte[] bytes, int first, int second, int third, int fourth) {

        // Bytes are taken from the array in the specified order
        // Anding the byte with 0xFF masks all of the bits bar the byte position it has been shifted to

        return  ((bytes[first-1] & 0xFF) << 24) |
                ((bytes[second-1] & 0xFF) << 16) |
                ((bytes[third-1] & 0xFF) << 8) |
                ((bytes[fourth-1] & 0xFF) << 0);

    }



}

