package athread.talk3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
	//선언부
	String imgPath = "D:\\workspace_java\\basic1\\src\\image\\talk\\";
	//JPanel에 쓰일 이미지 아이콘
	ImageIcon img = new ImageIcon(imgPath + "main.png");
	JLabel jlb_id = new JLabel("아이디");
	JLabel jlb_pw = new JLabel("패스워드");
	Font font = new Font("휴먼매직체", Font.BOLD, 18);
	JTextField jtf_id = new JTextField("tomato");
	JPasswordField jpf_pw = new JPasswordField("123");
	JButton btn_login = new JButton(new ImageIcon(imgPath+"login.png"));
	JButton btn_join = new JButton(new ImageIcon(imgPath+"confirm.png"));
	TalkDao tDao = new TalkDao();
	String nickName = null;

	//생성자
	public LoginForm() {
		System.out.println("LoginForm 디폴트 생성자");
		initDisplay();
	}

	//JPanel은 다양한 컴포넌트(독립적인 역할을 하는 클래스:버튼,라디오버튼,...)를 담을 수 있다.
	class Mypanel extends JPanel {
		//컴포넌트가 그려질 때 호출되는 메소드. 패널에 맞춤형 그래픽 그릴 수 있음
		public void paintComponent(Graphics g) {
			//이미지를 패널의 (0,0)위치에 그려준다.
			g.drawImage(img.getImage(), 0, 0, null);
			setOpaque(false);//패널의 배경을 투명하게 설정함
			//super는 상위 클래스를 가리키는 수정자 입니다.
			super.paintComponent(g);//이미지처리는 개발자가 호출만 할 수 있고 내부적으로 처리됨
		}
	}

	//화면처리부
	public void initDisplay(){
		System.out.println("initDisplay 호출");
		btn_login.addActionListener(this);
		btn_join.addActionListener(this);
		setContentPane(new Mypanel());
		//여기서는 this가 JFrame인데 디폴트 레이아웃이 BorderLayout이라서
		//동서남북중앙 이렇게 배치되므로 좌표값으로 하나하나 배치하려면
		//디폴트로 잡혀있는 레이아웃을 파괴해 주어야 합니다. 그래서 null줌
		this.setLayout(null);
		//아이디 라인
		jlb_id.setBounds(45, 200, 80,40);
		jlb_id.setFont(font);
		jtf_id.setBounds(110,200,185,40);
		this.add(jlb_id);
		this.add(jtf_id);
		//비밀번호 라인
		jlb_pw.setBounds(45, 240, 80,40);
		jlb_pw.setFont(font);
		jpf_pw.setBounds(110,240,185,40);
		this.add(jlb_pw);
		this.add(jpf_pw);
		//로그인 버튼 라인 추가
		btn_login.setBounds(175, 285, 120,40);
		this.add(btn_login);
		//회원가입 버튼 라인 추가
		btn_join.setBounds(45, 285, 120,40);
		this.add(btn_join);
		this.setLocation(800,250);
		this.setSize(350,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	//메인메소드
	public static void main(String[] args) {
		//오늘은 메인메소드 내에서 initDisplay를 호출하지 않고
		//생성자 안에서 호출합니다. 따라서 인스턴스 변수가 필요없다.
		new classes.ui.LoginForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		//로그인
		if (obj == btn_login) {

			if ("".equals(jtf_id.getText()) || "".equals(jpf_pw.getText())) {
				JOptionPane.showMessageDialog(this,"로그인요청","INFO",JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			try {
				String mem_id = jtf_id.getText();
				String mem_pw = jpf_pw.getText();

				String mem_nick = tDao.login(mem_id, mem_pw);

				if("비밀번호가 맞지 않습니다.".equals(mem_nick)) {
					JOptionPane.showMessageDialog(this, "비밀번호가 맞지 않습니다.");
					jpf_pw.setText("");
				} else if("아이디가 맞지 않습니다.".equals(mem_nick)) {
					JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다.");
					jtf_id.setText("");
				} else {
					nickName = mem_nick;
					this.setVisible(false);
					jtf_id.setText("");
					jpf_pw.setText("");

					// 로그인 성공 시, 파라미터로 로그인폼 주소번지를 넘겨서
					// @TO_
					// DO 멤버변수들을 사용할 수 있도록 조치한다. - this 추가한 생성자 추가할 것.....
					TalkClient tc = new TalkClient();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		//회원가입
		else if (obj == btn_join) {
			JOptionPane.showMessageDialog(this,"회원가입요청","ERROR",JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
}
