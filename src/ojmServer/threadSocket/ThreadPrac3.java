package ojmServer.threadSocket;

public class ThreadPrac3 {
    public static void main(String[] args) {

        // Thread create | 자막번호 실행
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                String[] strArray = {"하나", "둘", "셋", "넷", "다섯"};

                for (int i=0; i < strArray.length; i++) {
                    System.out.println("(자막번호)" + strArray[i]);
                    try {Thread.sleep(200);} catch(InterruptedException e) {}
                }
            }
        });

        // Thread | 비디오 번호
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 1. 비디오 프레임
                int[] intArray = {1, 2, 3, 4, 5};

                // 3. 비디오 프레임 출력
                for (int i=0; i < intArray.length; i++) {
                    System.out.println("(비디오프레임)" + intArray[i]);
                    try {Thread.sleep(200);} catch(InterruptedException e) {}
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
