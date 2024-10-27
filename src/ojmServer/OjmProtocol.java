package ojmServer;

public class OjmProtocol {
    OjmClient oc = null;

    // 생성자 생성
    public OjmProtocol(OjmClient oc) {
        this.oc = oc;
    }

    // run 메소드 생성
    public void run() {
        boolean isStop = false;

        while(!isStop) {
            try {
                String msg = null;
                msg = (String) oc.in.readLine();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
