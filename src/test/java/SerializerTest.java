import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

class SerializerTest {

    @ParameterizedTest
    @MethodSource("serializeMethodSource")
    void serializeTest(Object obj, byte[] expected) {
        byte[] actual = Serializer.serialize(obj);
        Assert.assertArrayEquals(actual, expected);

    }

    private static Stream<Arguments> serializeMethodSource() {
        char test1TestData = 'H';
        byte[] test1ExpectedResult = new byte[]{-84, -19, 0, 5, 115, 114, 0, 19, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 67, 104, 97, 114, 97, 99, 116, 101, 114, 52, -117, 71, -39, 107, 26, 38, 120, 2, 0, 1, 67, 0,
                5, 118, 97, 108, 117, 101, 120, 112, 0, 72};

        String test2TestData = "String";
        byte[] test2ExpectedResult = new byte[]{-84, -19, 0, 5, 116, 0, 6, 83, 116, 114, 105, 110, 103};

        short test3TestData = 29146;
        byte[] test3ExpectedResult = new byte[]{-84, -19, 0, 5, 115, 114, 0, 15, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 83, 104, 111, 114, 116, 104, 77, 55, 19, 52, 96, -38, 82, 2, 0, 1, 83, 0, 5, 118, 97, 108,
                117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98, 101, 114,
                -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 113, -38};

        int test4TestData = 572618;
        byte[] test4ExpectedResult = new byte[]{-84, -19, 0, 5, 115, 114, 0, 17, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 73, 110, 116, 101, 103, 101, 114, 18, -30, -96, -92, -9, -127, -121, 56, 2, 0, 1, 73, 0, 5,
                118, 97, 108, 117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98,
                101, 114, -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 0, 8, -68, -54};

        long test5TestData = 925657123552L;
        byte[] test5ExpectedResult = new byte[]{-84, -19, 0, 5, 115, 114, 0, 14, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 76, 111, 110, 103, 59, -117, -28, -112, -52, -113, 35, -33, 2, 0, 1, 74, 0, 5, 118, 97, 108,
                117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98, 101, 114,
                -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 0, 0, 0, -41, -123, 118, -54, -32};

        double test6TestData = 21.77;
        byte[] test6ExpectedResult = new byte[]{-84, -19, 0, 5, 115, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 68, 111, 117, 98, 108, 101, -128, -77, -62, 74, 41, 107, -5, 4, 2, 0, 1, 68, 0, 5, 118, 97,
                108, 117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98, 101,
                114, -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 64, 53, -59, 30, -72, 81, -21, -123};

        float test7TestData = 21.77F;
        byte[] test7ExpectedResult = new byte[]{-84, -19, 0, 5, 115, 114, 0, 15, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 70, 108, 111, 97, 116, -38, -19, -55, -94, -37, 60, -16, -20, 2, 0, 1, 70, 0, 5, 118, 97,
                108, 117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98,
                101, 114, -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 65, -82, 40, -10};

        ArrayList listFirst = new ArrayList();
        ArrayList listSecond = new ArrayList();
        listSecond.add("123");
        listSecond.add(2);
        listFirst.add(listSecond);
        listFirst.add("String");
        ArrayList test8TestData = listFirst;
        byte[] test8ExpectedResult = new byte[]{-84, -19, 0, 5, 115, 114, 0, 19, 106, 97, 118, 97, 46, 117, 116, 105,
                108, 46, 65, 114, 114, 97, 121, 76, 105, 115, 116, 120, -127, -46, 29, -103, -57, 97, -99, 3, 0, 1, 73,
                0, 4, 115, 105, 122, 101, 120, 112, 0, 0, 0, 2, 119, 4, 0, 0, 0, 2, 115, 113, 0, 126, 0, 0, 0, 0, 0, 2,
                119, 4, 0, 0, 0, 2, 116, 0, 3, 49, 50, 51, 115, 114, 0, 17, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46,
                73, 110, 116, 101, 103, 101, 114, 18, -30, -96, -92, -9, -127, -121, 56, 2, 0, 1, 73, 0, 5, 118, 97, 108,
                117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98, 101, 114, -122,
                -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 0, 0, 0, 2, 120, 116, 0, 6, 83, 116, 114, 105, 110,
                103, 120};

        return Stream.of(
                Arguments.of(test1TestData, test1ExpectedResult),
                Arguments.of(test2TestData, test2ExpectedResult),
                Arguments.of(test3TestData, test3ExpectedResult),
                Arguments.of(test4TestData, test4ExpectedResult),
                Arguments.of(test5TestData, test5ExpectedResult),
                Arguments.of(test6TestData, test6ExpectedResult),
                Arguments.of(test7TestData, test7ExpectedResult),
                Arguments.of(test8TestData, test8ExpectedResult)
        );
    }

    @ParameterizedTest
    @MethodSource("deserializeMethodSource")
    void deserializeTest(byte[] data, Object expected) {
        Object actual = Serializer.deserialize(data);
        Assert.assertEquals(actual, expected);
    }

    private static Stream<Arguments> deserializeMethodSource() {
        byte[] test1TestData = new byte[]{-84, -19, 0, 5, 115, 114, 0, 19, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 67, 104, 97, 114, 97, 99, 116, 101, 114, 52, -117, 71, -39, 107, 26, 38, 120, 2, 0, 1, 67, 0,
                5, 118, 97, 108, 117, 101, 120, 112, 0, 72};
        char test1ExpectedResult = 'H';

        byte[] test2TestData = new byte[]{-84, -19, 0, 5, 116, 0, 6, 83, 116, 114, 105, 110, 103};
        String test2ExpectedResult = "String";

        byte[] test3TestData = new byte[]{-84, -19, 0, 5, 115, 114, 0, 15, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 83, 104, 111, 114, 116, 104, 77, 55, 19, 52, 96, -38, 82, 2, 0, 1, 83, 0, 5, 118, 97, 108,
                117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98, 101, 114,
                -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 113, -38};
        short test3ExpectedResult = 29146;

        byte[] test4TestData = new byte[]{-84, -19, 0, 5, 115, 114, 0, 17, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 73, 110, 116, 101, 103, 101, 114, 18, -30, -96, -92, -9, -127, -121, 56, 2, 0, 1, 73, 0, 5,
                118, 97, 108, 117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98,
                101, 114, -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 0, 8, -68, -54};
        int test4ExpectedResult = 572618;

        byte[] test5TestData = new byte[]{-84, -19, 0, 5, 115, 114, 0, 14, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 76, 111, 110, 103, 59, -117, -28, -112, -52, -113, 35, -33, 2, 0, 1, 74, 0, 5, 118, 97, 108,
                117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98, 101, 114,
                -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 0, 0, 0, -41, -123, 118, -54, -32};
        long test5ExpectedResult = 925657123552L;

        byte[] test6TestData = new byte[]{-84, -19, 0, 5, 115, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 68, 111, 117, 98, 108, 101, -128, -77, -62, 74, 41, 107, -5, 4, 2, 0, 1, 68, 0, 5, 118, 97,
                108, 117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98, 101,
                114, -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 64, 53, -59, 30, -72, 81, -21, -123};
        double test6ExpectedResult = 21.77;

        byte[] test7TestData = new byte[]{-84, -19, 0, 5, 115, 114, 0, 15, 106, 97, 118, 97, 46, 108, 97, 110,
                103, 46, 70, 108, 111, 97, 116, -38, -19, -55, -94, -37, 60, -16, -20, 2, 0, 1, 70, 0, 5, 118, 97,
                108, 117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98,
                101, 114, -122, -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 65, -82, 40, -10};
        float test7ExpectedResult = 21.77F;

        byte[] test8TestData = new byte[]{-84, -19, 0, 5, 115, 114, 0, 19, 106, 97, 118, 97, 46, 117, 116, 105,
                108, 46, 65, 114, 114, 97, 121, 76, 105, 115, 116, 120, -127, -46, 29, -103, -57, 97, -99, 3, 0, 1, 73,
                0, 4, 115, 105, 122, 101, 120, 112, 0, 0, 0, 2, 119, 4, 0, 0, 0, 2, 115, 113, 0, 126, 0, 0, 0, 0, 0, 2,
                119, 4, 0, 0, 0, 2, 116, 0, 3, 49, 50, 51, 115, 114, 0, 17, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46,
                73, 110, 116, 101, 103, 101, 114, 18, -30, -96, -92, -9, -127, -121, 56, 2, 0, 1, 73, 0, 5, 118, 97, 108,
                117, 101, 120, 114, 0, 16, 106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98, 101, 114, -122,
                -84, -107, 29, 11, -108, -32, -117, 2, 0, 0, 120, 112, 0, 0, 0, 2, 120, 116, 0, 6, 83, 116, 114, 105, 110,
                103, 120};
        ArrayList listFirst = new ArrayList();
        ArrayList listSecond = new ArrayList();
        listSecond.add("123");
        listSecond.add(2);
        listFirst.add(listSecond);
        listFirst.add("String");
        ArrayList test8ExpectedResult = listFirst;

        return Stream.of(
                Arguments.of(test1TestData, test1ExpectedResult),
                Arguments.of(test2TestData, test2ExpectedResult),
                Arguments.of(test3TestData, test3ExpectedResult),
                Arguments.of(test4TestData, test4ExpectedResult),
                Arguments.of(test5TestData, test5ExpectedResult),
                Arguments.of(test6TestData, test6ExpectedResult),
                Arguments.of(test7TestData, test7ExpectedResult),
                Arguments.of(test8TestData, test8ExpectedResult)
        );
    }


}