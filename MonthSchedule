import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MonthSchedule extends JFrame implements ActionListener{
      JPanel totalPanel = new JPanel(new BorderLayout());
      JPanel northPanel = new JPanel(new GridLayout(1,3));
      JPanel nCenterPanel = new JPanel(new GridLayout(2,1));
         
      //nCenterPanel 에 넣어줄 연도 정보와 달 정보 Label 로 선언
      JLabel yearLabel;
      JLabel monthLabel;
      JButton prevbut = new JButton("<");
      JButton nextbut = new JButton(">");
      JPanel southPanel = new JPanel(new GridLayout(0,7));
      JPanel daysPanel = new JPanel(new GridLayout(0,7));
      
      //dayspanel 에서 mon~sun 출력해주기위해 문자열 배열을 저장
      String montosun[] = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
      DaySchedule ang;
      Calendar cal = Calendar.getInstance();

      private int num;
      private int year;
      private int month;
      private int sDayNum;
      private int endDate;
      //프로그램 동작 내내 사용해야하니까 static
      static int calnum = 0;
      
      //기본 생성자
      MonthSchedule(){
         setCal(calnum);
         makePanel();
         add(totalPanel);
         }
      
      //특정 날짜 입력받으면
      MonthSchedule(String k){
         setCal(calnum,k);
         makePanel();
         add(totalPanel);
         }
      
      //>> <<실행시 setCal 을 통해 calendar 의 month 를 다음달, 전달로 설정하고, 그 날의
      일정을 띄우는 ang 객체 생성
      public void setCal(int num){
         String tempm = "";
         int temp = cal.get(Calendar.DATE);
         cal.set(Calendar.DATE,1);
         cal.add(Calendar.MONTH, num);
         year = cal.get(Calendar.YEAR);
         month = cal.get(Calendar.MONTH)+1;
         if (month<10) {
            tempm = "0"+month;
            };
         
         String sday = year+"-"+tempm+"-"+temp;
         ang = new DaySchedule(sday);
         sDayNum = cal.get(Calendar.DAY_OF_WEEK);
         endDate = cal.getActualMaximum(Calendar.DATE);
         }
         
      //특정 날짜(button 을 통해 string 변환) 
      public void setCal(int num,String a){
         cal.set(Calendar.DATE,1);
         cal.add(Calendar.MONTH, num);
         year = cal.get(Calendar.YEAR);
         month = cal.get(Calendar.MONTH)+1;
         ang = new DaySchedule(a);
         sDayNum = cal.get(Calendar.DAY_OF_WEEK);
         endDate = cal.getActualMaximum(Calendar.DATE);
         }
      
      public void makePanel() {
         setLocation(0,0);
         northPanel.add(prevbut);
         yearLabel = new JLabel(""+year,JLabel.CENTER);
         monthLabel = new JLabel(""+(month),JLabel.CENTER);
         nCenterPanel.add(yearLabel);
         nCenterPanel.add(monthLabel);
         northPanel.add(nCenterPanel);
         northPanel.add(nextbut);
         nextbut.addActionListener(this);
         prevbut.addActionListener(this);
         totalPanel.add(northPanel,"North");
         for(int i = 0; i<montosun.length; i++) {
            JLabel temp = new JLabel(montosun[i],JLabel.CENTER);
            daysPanel.add(temp);
            }
         totalPanel.add(daysPanel,"Center");

         //calendar frame 만들기
         JButton[] day = new JButton[32];
         for(int i = 1; i<=31; i++) {
            day[i] = new JButton(""+i);
            day[i].addActionListener(this);
            }
         
         for(int i=1; i<sDayNum; i++) {
            southPanel.add(new JLabel(""));
            }
         
         for(int i=1; i<=endDate; i++) {
            southPanel.add(day[i]);
            }
         totalPanel.add(southPanel,"South");
         setSize(400,300);
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         setTitle("Schedule Planner");
         setVisible(true);
      }
      
      
      
      public void actionPerformed(ActionEvent e){
         //버튼마다 그 날짜로 다시 설정 후, 다시 생성자를 불러들여 gui 다시 띄우기
         if(e.getSource() == nextbut) {
            calnum++;
            ang.dispose();
            setVisible(false);
            new MonthSchedule();
            }
         else if(e.getSource() == prevbut) {
            calnum--;
            ang.dispose();
            setVisible(false);
            new MonthSchedule();
            }
         else if(Integer.parseInt(e.getActionCommand()) >= 1 &&
               Integer.parseInt(e.getActionCommand()) <=31){
            Integer day = Integer.parseInt(e.getActionCommand());
            String temp;
            String tempm;
            if(1<=day&&day<10) {
               temp = "0"+day;
            }
            else {
               temp = day.toString();
            }
            if(month<10) {
               tempm = "0"+month;
            }
            else {
               tempm = ""+month;
            }
            
            //날짜 정보 저장 후 새 생성자로 gui 초기화
            String sday = year+"-"+tempm+"-"+temp;
            ang.dispose();
            setVisible(false);
            new MonthSchedule(sday);
            } 
      }
}
