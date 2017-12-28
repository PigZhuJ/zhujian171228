package wangconghui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class iloveyou {
    public static void main(String[] args) throws InterruptedException {


        JFrame jFrame=new JFrame();//窗体
        Container container=jFrame.getContentPane();
        container.setLayout(new BorderLayout());
        jFrame.setTitle("I Love You  王聪慧");
        jFrame.setSize(600,360);
        jFrame.setLocationRelativeTo(null);

        JTextArea jTextArea=new JTextArea();
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        jScrollPane.setViewportView(jTextArea);
        jScrollPane.setAutoscrolls(true);

        jTextArea.setLineWrap(true);//换行
        jTextArea.setWrapStyleWord(true);// 激活断行不断字功能
        jTextArea.setBackground(Color.pink);
        container.add(jScrollPane,BorderLayout.CENTER);

        JButton jButton1=new JButton("你爱我嘛？");
        JButton jButton2=new JButton("我爱你嘛？");
        JPanel jPanel=new JPanel();
        FlowLayout flowLayout=new FlowLayout();
        flowLayout.setHgap(60);
        flowLayout.setVgap(30);
        jPanel.setLayout(flowLayout);
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        container.add(jPanel,BorderLayout.SOUTH);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread = new MyThread(jTextArea);
                thread.start();
            }

        });

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i <5 ; i++) {
                    String zhujian="王聪慧爱我";


                }
            }
        });
        jFrame.setVisible(true);
    }

}

class MyThread extends Thread {
    JTextArea jTextArea;

    public MyThread(JTextArea jTextPane) {
        this.jTextArea = jTextPane;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1314; i++) {
            jTextArea.setText(""+jTextArea.getText() + "                      我爱王聪慧" + "\n");
            jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}