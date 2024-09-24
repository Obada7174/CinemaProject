package Cinema3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage {

        UserPage(JFrame frame1,User user){

            JFrame frame = new JFrame("User Page ");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.setSize(960,540);
            frame.setTitle("User page");


            JPanel panel=new JPanel(null);
            panel.setBounds(0,0,960,540);
            panel.setBackground(new Color(0x411218));

            JLabel label1 = new JLabel("User Name : "+user.getUsername());
            label1.setFont(new Font("Helvetica Neue",Font.PLAIN,25));
            label1.setBounds(40, 20, 360, 20);
            label1.setForeground(new Color(0xffffff));

            JLabel label3=new JLabel("Tickets  : ");
            label3.setFont(new Font("Helvetica Neue",Font.PLAIN,25));
            label3.setHorizontalAlignment(SwingConstants.LEFT);
            label3.setBounds(40,60,150,80);
            label3.setForeground(new Color(0xffffff));
            int i=0;
            int j =0;
            for(Ticket t : user.getTickets()) {
                JLabel label4 = new JLabel(t.getMovie().getTitle()+"/"+t.getSeat().getSeatNumber()+"/"+t.getCinema());
                label4.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
                label4.setHorizontalAlignment(SwingConstants.LEFT);
                label4.setBounds(40, 130+(i*40), 450, 30);
                label4.setForeground(new Color(0xffffff));
                if (i>8) {
                    label4.setBounds(500, 130 + (j * 40), 400, 30);
                    j++;
                }
                panel.add(label4);
                i++;
            }

            JButton button=new JButton();
            button.setText(" Back ");
            button.setBounds(850,0,100,50);
            button.setBackground(new Color(0xffffff));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent){
                    frame1.setVisible(true);
                    frame.setVisible(false);
                }
            });

            panel.add(label1);
            panel.add(label3);
            panel.add(button);


            frame.setResizable(false);
            frame.getContentPane().add(panel);
            frame.setVisible(true);


        }
}
