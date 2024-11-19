package inheritance.step3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 힌트는 생성자
// setter 지원되지 않는 경우 어떻게
public class VectorSimulation extends Vector {

    public VectorSimulation() {
        super(5, 3);
    }

    public static void main(String[] args) {
        VectorSimulation vector = new VectorSimulation();

        Class cv = vector.getClass();
        Method[] methods = cv.getMethods();

        for(Method m : methods) {
            System.out.println(m.getName());
        }

        methods = cv.getDeclaredMethods();
        Field[] fields = cv.getFields();
        fields = cv.getDeclaredFields();
        System.out.println(fields.length);
    }
}
