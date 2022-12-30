package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ModelTest {

    Model model = new Model();

    private static Stream<Arguments> returnObjectToParamTest() {
        return Stream.of(
                arguments(444,9999, "444|9999\n" +
                        "   |----\n" +
                        "   |0"),
                arguments(14789,20, "_14789|20\n" +
                        " 140  |---\n" +
                        " ---  |739\n" +
                        " _78\n" +
                        "  60\n" +
                        "  --\n" +
                        "  _189\n" +
                        "   180\n" +
                        "   ---\n" +
                        "     9"),
                arguments(78945,4,"_78945|4\n" +
                        " 4    |-----\n" +
                        " -    |19736\n" +
                        " _38\n" +
                        "  36\n" +
                        "  --\n" +
                        "  _29\n" +
                        "   28\n" +
                        "   --\n" +
                        "   _14\n" +
                        "    12\n" +
                        "    --\n" +
                        "    _25\n" +
                        "     24\n" +
                        "     --\n" +
                        "      1"),
                arguments(8000,2000,"_8000|2000\n" +
                        " 8000|----\n" +
                        " ----|4\n" +
                        "    0"),
                arguments(55,5691,"55|5691\n" +
                        "  |----\n" +
                        "  |0"),
                arguments(-42561,341,"_42561|341\n" +
                        " 341  |----\n" +
                        " ---  |-124\n" +
                        " _846\n" +
                        "  682\n" +
                        "  ---\n" +
                        "  _1641\n" +
                        "   1364\n" +
                        "   ----\n" +
                        "    277"),
                arguments(-56782,-6869,"_56782|6869\n" +
                        " 54952|----\n" +
                        " -----|8\n" +
                        "  1830"),
                arguments(4444,4,"_4444|4\n" +
                        " 4   |----\n" +
                        " -   |1(1)\n" +
                        " _4\n" +
                        "  4\n" +
                        "  -\n" +
                        "  _4\n" +
                        "   4\n" +
                        "   -\n" +
                        "   _4\n" +
                        "    4\n" +
                        "    -\n" +
                        "    0"),
                arguments(0,58,"0|58\n" +
                        " |--\n" +
                        " |0"),
                arguments(3331000,3,"_3331000|3\n" +
                        " 3      |------\n" +
                        " -      |111(3)\n" +
                        " _3\n" +
                        "  3\n" +
                        "  -\n" +
                        "  _3\n" +
                        "   3\n" +
                        "   -\n" +
                        "   _10\n" +
                        "    9\n" +
                        "    -\n" +
                        "    _10\n" +
                        "     9\n" +
                        "     -\n" +
                        "     _10\n" +
                        "      9\n" +
                        "      -\n" +
                        "      1")
        );
    }

    @ParameterizedTest
    @MethodSource("returnObjectToParamTest")
    void testDivide (int divider, int divisor, String expect) {
        String actualResult = model.divide(divider, divisor);
        assertEquals(expect,actualResult);
    }
}