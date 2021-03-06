package App;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.EventQueue;

import java.awt.Color;
import java.util.TimeZone;
import java.util.Calendar;
import java.awt.BorderLayout;

import WorldTime.WorldTime;
import Timer.Timer;
import StopWatch.StopWatch;
import AlarmClock.AlarmClock;
import Index.Index;
import Timer.CountMain;

import java.awt.Font;
import javax.swing.ImageIcon;

public class App extends JFrame{


    ImageIcon icon = new ImageIcon("WorldMap");

    // 이동하는 버튼 변수
    private JButton btnAlarm;
    private JButton btnStopWatch;
    private JButton btnTimer;
    private JButton btnWorldTime;
    private JLabel lblNorth;
    private JLabel lblCenter;
    private JLabel lblSouth;

    public JButton Previous;   // 이전 버튼

    public Thread t1;
    public boolean aa;

    Font font;

    Color color = (Color.WHITE);

    public void Timer() {

   }

    public App() {  // App  실행 함수
       font = new Font("Sherif",Font.BOLD,30); //폰트 기본값

        WorldTime world = new WorldTime();   // 세계시간 메소드 불러 오기
        
        // 실행과 동시에 실행
        world.aa=true;
        world.ThreadTime(); 
       

        world.lblCenter = new JLabel("",JLabel.CENTER);
        world.lblCenter.setFont(font);
        
        btnAlarm = new JButton("알람");
        btnStopWatch = new JButton("스톱워치");
        btnTimer = new JButton("타이머");
        btnWorldTime = new JButton("세계시간");
        Previous = new JButton("이전");
        
        JPanel pnlbtn = new JPanel(); // 버튼 패널 추가
        JPanel Prebtn = new JPanel(); // 이전 버튼을 위한 패널

        pnlbtn.add(btnWorldTime);
        pnlbtn.add(btnTimer);
        pnlbtn.add(btnAlarm);
        pnlbtn.add(btnStopWatch);
        Prebtn.add(Previous);

        //위치 설정 
        JPanel pnlSouth = new JPanel(new BorderLayout());
        JPanel pnlNorth = new JPanel(new BorderLayout());
        pnlSouth.add(pnlbtn, BorderLayout.SOUTH);
        pnlNorth.add(Prebtn, BorderLayout.NORTH);

        JPanel pnlMain = new JPanel(new BorderLayout());
        pnlMain.add(world.lblCenter, BorderLayout.CENTER);
        pnlMain.add(pnlSouth, BorderLayout.SOUTH);
        pnlMain.add(pnlNorth, BorderLayout.NORTH);
        add(pnlMain);
        pnlMain.setBackground(new Color(0,0,0));
        world.lblCenter.setForeground(new Color(255,255,255));
        // 버튼 클릭 이벤트
        StopWatch fra = new StopWatch("   ");  
        btnAlarm.addActionListener((e)->{
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        AlarmClock window = new AlarmClock();
                        window.frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            setVisible(false);
            world.f1.setVisible(false);
            fra.setVisible(false); 
        });
        btnStopWatch.addActionListener((e)->{
            try {  
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
            } catch (Exception ee) {  
                ee.printStackTrace();  
            }  
            fra.pack();  
            fra.setVisible(true);
            setVisible(false);
            world.f1.setVisible(false);

        });
        btnTimer.addActionListener((e)->{
            new CountMain("Timer");
            setVisible(false);
            world.f1.setVisible(false);
        });
        btnWorldTime.addActionListener((e)->{
            ImageIcon WorldMap = new ImageIcon("WorldMap.png");
            world.aa=true;
            world.ThreadTime();
        });

        // 이전 버튼 
        Previous.addActionListener((e)->{
            new Index();
            world.f1.setVisible(false);
            setVisible(false);
            fra.setVisible(false); 

        });

        setLocation(730,250);
        setTitle("Watch");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
}
