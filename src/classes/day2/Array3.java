package classes.day2;

public class Array3 {
    public static void main(String[] args) {
        Object[][] obj = new Object[4][3];

        for(int i=0; i<4; i++) {
            for(int j=0; j<3; j++) {
                obj[i][j] = new Object[i+j+2];
            }
        }

        Object[] leng = (Object[]) obj[3][2];
        System.out.println(leng.length);
    }
}
