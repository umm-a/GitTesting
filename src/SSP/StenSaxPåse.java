package sprint3.test.u5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class StenSaxPåse extends JFrame implements ActionListener {

    int dinaPoängCount = 0;
    int datornsPoängCount = 0;
    JPanel playPanel = new JPanel();
    JPanel buttonPanelDu = new JPanel();
    JPanel buttonPanelDatorn = new JPanel();
    JButton stenButton = new JButton("STEN");
    JButton saxButton = new JButton("SAX");
    JButton påseButton = new JButton("PÅSE");
    JButton stenButtonDatorn = new JButton("STEN");
    JButton saxButtonDatorn = new JButton("SAX");
    JButton påseButtonDatorn = new JButton("PÅSE");
    JLabel du = new JLabel("DU");
    JLabel datorn = new JLabel("DATORN");
    JPanel emptyColumn1 = new JPanel();
    JPanel emptyColumn2 = new JPanel();
    JPanel emptyColumn3 = new JPanel();
    JLabel dinaPoäng = new JLabel("Dina poäng: 0");
    JLabel datornsPoäng = new JLabel("Datorns poäng: 0");
    JButton nyttSpel = new JButton("Nytt spel");
    JLabel denSomVann = new JLabel("");

    StenSaxPåse(){
        this.add(playPanel);
        playPanel.setLayout(new GridLayout(1, 5));
        buttonPanelDu.setLayout(new GridLayout(5, 1));
        buttonPanelDatorn.setLayout(new GridLayout(5, 1));

        emptyColumn3.setLayout(new GridLayout(5,2));
        emptyColumn3.add(nyttSpel);

        buttonPanelDu.add(du);
        buttonPanelDu.add(stenButton);
        buttonPanelDu.add(saxButton);
        buttonPanelDu.add(påseButton);
        buttonPanelDu.add(dinaPoäng);
        buttonPanelDatorn.add(datorn);
        buttonPanelDatorn.add(stenButtonDatorn);
        buttonPanelDatorn.add(saxButtonDatorn);
        buttonPanelDatorn.add(påseButtonDatorn);
        buttonPanelDatorn.add(datornsPoäng);
        playPanel.setSize(1000, 120);
        stenButton.setBackground(new Color(255, 180, 200));
        påseButton.setBackground(new Color(255, 180, 200));
        saxButton.setBackground(new Color(255, 180, 200));
        stenButtonDatorn.setBackground(new Color(255, 180, 200));
        påseButtonDatorn.setBackground(new Color(255, 180, 200));
        saxButtonDatorn.setBackground(new Color(255, 180, 200));

        nyttSpel.setBackground(new Color(255,200,200));
        buttonPanelDu.setBackground(new Color(255, 200, 200));

        buttonPanelDatorn.setBackground(new Color(255, 200,200));
        emptyColumn1.setBackground(new Color(255, 210,210));
        emptyColumn2.setBackground(new Color(255, 210, 210));
        emptyColumn3.setBackground(new Color(255, 210, 210));

        playPanel.add(emptyColumn1);
        playPanel.add(buttonPanelDu);
        playPanel.add(emptyColumn2);
        emptyColumn2.add(denSomVann);
        playPanel.add(buttonPanelDatorn);
        playPanel.add(emptyColumn3);

        stenButton.addActionListener(this);
        saxButton.addActionListener(this);
        påseButton.addActionListener(this);

        nyttSpel.addActionListener(this);

        setVisible (true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(820, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        StenSaxPåse ssp = new StenSaxPåse();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==stenButton){
            stenButton.setBackground(new Color(255, 123 ,123));
            vemFårPoäng(0);
            saxButton.setBackground(new Color(255, 255,255));
            påseButton.setBackground(new Color(255, 255,255));
        } else if (e.getSource()==saxButton) {
            saxButton.setBackground(new Color(255, 123 ,123));
            stenButton.setBackground(new Color(255, 255,255));
            påseButton.setBackground(new Color(255, 255,255));
            vemFårPoäng(1);
        } else if (e.getSource()==påseButton) {
            påseButton.setBackground(new Color(255, 123 ,123));
            stenButton.setBackground(new Color(255, 255,255));
            saxButton.setBackground(new Color(255, 255,255));
            vemFårPoäng(2);
        } else if (e.getSource()==nyttSpel) {
            saxButton.setBackground(new Color(255, 255,255));
            stenButton.setBackground(new Color(255, 255,255));
            påseButton.setBackground(new Color(255, 255,255));
            saxButtonDatorn.setBackground(new Color(255, 255,255));
            stenButtonDatorn.setBackground(new Color(255, 255,255));
            påseButtonDatorn.setBackground(new Color(255, 255,255));
            dinaPoäng.setText("Dina poäng: 0");
            dinaPoängCount=0;
            datornsPoäng.setText("Datorns poäng: 0");
            datornsPoängCount=0;
        }
    }

    public void vemFårPoäng(int stenSaxEllerPåse){
        boolean duFårPoäng = false;
        boolean datornFårPoäng = false;
        Random ran = new Random();
        int datornsVal = ran.nextInt(3); //+ 0;
        System.out.println(datornsVal);

        if(datornsVal==0){
            stenButtonDatorn.setBackground(new Color(255, 120, 200));
            saxButtonDatorn.setBackground(new Color(255, 255, 255));
            påseButtonDatorn.setBackground(new Color(255, 255, 255));
            if(stenSaxEllerPåse==1){
                datornFårPoäng=true;
            }else if(stenSaxEllerPåse==2){
                duFårPoäng=true;
            }
        }else if(datornsVal==1){
            saxButtonDatorn.setBackground(new Color(255, 120, 200));
            stenButtonDatorn.setBackground(new Color(255, 255, 255));
            påseButtonDatorn.setBackground(new Color(255, 255, 255));
            if(stenSaxEllerPåse==0){
                duFårPoäng=true;
            }else if(stenSaxEllerPåse==2){
                datornFårPoäng=true;
            }
        }else if(datornsVal==2){
            påseButtonDatorn.setBackground(new Color(255, 120, 200));
            stenButtonDatorn.setBackground(new Color(255, 255, 255));
            saxButtonDatorn.setBackground(new Color(255, 255, 255));
            if(stenSaxEllerPåse==0){
                datornFårPoäng=true;
            }else if(stenSaxEllerPåse==1){
                duFårPoäng=true;
            }
        }

        if (duFårPoäng){
            dinaPoängCount++;
            dinaPoäng.setText("Dina poäng: " + dinaPoängCount);
            denSomVann.setText("Du vann denna omgång");
        }else if (datornFårPoäng) {
            datornsPoängCount++;
            datornsPoäng.setText("Datorns poäng: " + datornsPoängCount);
            denSomVann.setText("Datorn vann denna omgång");
        }else {
            denSomVann.setText("Lika denna omgång");
        }

    }
}
