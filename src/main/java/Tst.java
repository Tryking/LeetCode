import com.tryking.December;

import java.util.List;
import java.util.function.IntBinaryOperator;

/**
 * 测试
 *
 * @author dengkaiting
 * @date 2017/12/10
 */
public class Tst {
    public static void main(String[] args) {
        List<Integer> integers = new December().selfDividingNumbers(1, 22);
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(integers.get(i));
        }
    }
}