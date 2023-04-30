package vista;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author Yovany Romo
 */
public class GUICalculadora extends JFrame {

    private Escucha escucha;

    private JLabel lblNumero1;
    private JLabel lblNumero2;
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JTextField txtResultado;
    private JButton btnSumar;
    private JButton btnRestar;
    private JButton btnMultiplicar;
    private JButton btnDividir;
    private JPanel panelIngreso;
    private JPanel panelBotones;
    private JPanel panelResultado;
    private Container contenedorPrincipal;

    private OperacionesFico operacion;
    
    public GUICalculadora()
    {
        escucha = new Escucha();

        lblNumero1 = new JLabel("Numero 1:");
        lblNumero2 = new JLabel("Numero 2:");
        
        txtNumero1 = new JTextField();
        txtNumero2 = new JTextField();
        txtResultado = new JTextField(25);
        
        btnSumar = new JButton("Sumar");
        btnRestar = new JButton("Restar");
        btnMultiplicar = new JButton("Multiplicar");
        btnDividir = new JButton("Dividir");
        
        
        panelIngreso = new JPanel();
        panelBotones = new JPanel();
        panelResultado = new JPanel();
        
        panelIngreso.setLayout(new GridLayout(2,2));
        panelIngreso.add(lblNumero1); 
        panelIngreso.add(txtNumero1);
        panelIngreso.add(lblNumero2); 
        panelIngreso.add(txtNumero2);
        
        panelBotones.setLayout(new GridLayout(1, 4,5,0));
        panelBotones.add(btnSumar); 
        panelBotones.add(btnRestar); 
        panelBotones.add(btnMultiplicar); 
        panelBotones.add(btnDividir);

        panelBotones.setFocusable(true);
        
        panelResultado.add(txtResultado);
        
        panelIngreso.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE,3),"Ingreso de Datos"));
        panelBotones.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE,3),"Controles"));
        panelResultado.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE,3),"Resultados"));
        
        contenedorPrincipal = getContentPane();

        contenedorPrincipal.setLayout(new GridLayout(3, 1));
        contenedorPrincipal.add(panelIngreso); 
        contenedorPrincipal.add(panelBotones); 
        contenedorPrincipal.add(panelResultado);

        /*
        Ahora debo adiconar los escuhas a los componentes indicados segun mi aplicacion.

         */

        txtNumero1.addActionListener(escucha);
        txtNumero2.addActionListener(escucha);
        txtResultado.addActionListener(escucha);

        txtNumero1.addKeyListener(escucha);
        txtNumero2.addKeyListener(escucha);

        btnSumar.addMouseListener(escucha);
        btnRestar.addMouseListener(escucha);
        btnMultiplicar.addMouseListener(escucha);
        btnDividir.addMouseListener(escucha);

        double t1=0, t2=0;
        operacion = new OperacionesFico(t1,t2);

        setTitle("Ejemplo Calculadora");
        setSize(500, 250);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null,"Dar ENTER \n al ingresar los datos");
                GUICalculadora myGUI = new GUICalculadora();
            }
        });
    }


    private class Escucha implements KeyListener, ActionListener, MouseListener {

        double dato1, dato2, resultado;

        //OperacionesFico miOperacion;


        @Override
        public void actionPerformed(ActionEvent e) {// valores iniciales a operar.

            if (e.getSource()==txtNumero1) {

                dato1 = Double.parseDouble(txtNumero1.getText());

                System.out.println(" soy txtnumero1 -> " + dato1);

            }
            else if (e.getSource()==txtNumero2){

                dato2 = Double.parseDouble(txtNumero2.getText());

                System.out.println(" soy txtnumero2 -> " + dato2);

            }


        }


        @Override
        public void keyTyped(KeyEvent e) {

//            int decisor = e.getKeyCode();
//
//            if (e.getSource()==txtNumero1){
//
//                if (decisor==KeyEvent.VK_ENTER || decisor==KeyEvent.VK_ESCAPE);
//
//                dato1 = Double.parseDouble(txtNumero1.getText());
//
//            }





         }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource()==btnSumar){
                resultado = operacion.sumar(dato1,dato2);
                txtResultado.setText(String.valueOf(resultado));
                System.out.print(" la suma da -> " + resultado);
            }
            else if (e.getSource()==btnRestar){
                resultado = operacion.restar(dato1,dato2);
                txtResultado.setText(String.valueOf(resultado));
            }
            else if (e.getSource()==btnMultiplicar){
                resultado = operacion.multiplicar(dato1,dato2);
                txtResultado.setText(String.valueOf(resultado));
            }
            else if (e.getSource()==btnDividir){
                if (dato2==0){
                    JOptionPane.showMessageDialog(null," La DIVISION \nentre CERO\nNO esta definida aun..");
                    txtResultado.setText(" Erro division entre cero ");
                }
                resultado = operacion.dividir(dato1,dato2);
                txtResultado.setText(String.valueOf(resultado));
            }




        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


}
