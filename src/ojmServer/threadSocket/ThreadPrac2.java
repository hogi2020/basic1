package ojmServer.threadSocket;

class SMIFileRunnable implements Runnable {
    @Override
    public void run() {
        // 2. 자막 프레임
        String[] strArray = {"하나", "둘", "셋", "넷", "다섯"};

        // 4. 자막번호 출력
        for (int i=0; i < strArray.length; i++) {
            System.out.println("(자막번호)" + strArray[i]);
            try {Thread.sleep(200);} catch(InterruptedException e) {}
        }
    }
}


class VideoFileRunnable implements Runnable {
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
}

public class ThreadPrac2 {
    public static void main(String[] args) {

        // SMIRunnable 객체 생성
        Runnable smiFileRunnable = new SMIFileRunnable();
        Runnable videoFileRunnable = new VideoFileRunnable();
        Thread thread = new Thread(smiFileRunnable);
        Thread thread2 = new Thread(videoFileRunnable);
        thread.start();
        thread.start();
    }
}
