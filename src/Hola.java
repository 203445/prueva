import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Hola {
    public static void main(String[]args){
        Marco m = new Marco();
    }
}
class Marco extends JFrame{
    public Marco(){
        this.setSize(280,80);
        this.setTitle("Ventana");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setAlwaysOnTop(true);
        Lamina l = new Lamina();
        this.add(l);
        this.setVisible(true);
    }
}
class Lamina extends JPanel{
    private JButton botonClose;

    public Lamina(){

        this.setBackground(new Color(50,50,50));
        JButton botonAdd = new JButton("Presiona");
        AccionAdd ad  = new AccionAdd();
        botonAdd.setMnemonic('n');
        botonAdd.addActionListener(ad);
        this.add(botonAdd);

        botonClose = new JButton("Cerrar ventanas");
        this.add(botonClose);

    }
    class AccionAdd  implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i<5 ; i++ ){
                VariosMarcos vm = new VariosMarcos(botonClose);

            }

        }
    }
}
class VariosMarcos extends JFrame {
    private Dimension medidaPantalla = Toolkit.getDefaultToolkit().getScreenSize();
    private static int serie = 0 ;

    public VariosMarcos(JButton bt){
        this.setTitle("Ventana: " + serie);

        this.setSize(600,200);

        int r = new Random().nextInt(255);
        int g = new Random().nextInt(255);
        int b = new Random().nextInt(255);

        this.getContentPane().setBackground(new Color(r,g,b));

        JLabel etiqueta = new JLabel("Te quiero mucho", SwingConstants.CENTER);
        etiqueta.setBounds(100,50,100,100);
        etiqueta.setForeground(new Color(r,g,b).darker().darker());
        etiqueta.setFont(new Font("Arial", Font.BOLD,40));

        this.add(etiqueta);

        //Números aleatorios para la localización
        int x = new Random().nextInt(medidaPantalla.width);
        int y = new Random().nextInt(medidaPantalla.height);

        this.setLocation(x,y);
        this.setResizable(false);

        Accion a = new Accion();
        bt.addActionListener(a);

        this.setVisible(true);

    }

    private class Accion implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
           dispose();
           serie = 0;
        }

    }

}
