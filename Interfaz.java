import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Interfaz extends JFrame implements ActionListener
{
    private JButton calcular;
    private JButton cerrarCaja;
    private JTextField cseguridad;
    private JTextField direccion;
    private JTextField email;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JTextField nombre;
    private JTextField ntarjeta;
    private JButton nuevaCompra;
    private JTextArea observacion;
    private JButton pagar;
    private JTextField telefono;
    private JTextField vcompra;
    private JTextField vdescuento;
    private JTextField viva;
    private JTextField vpago;
    private ArrayList<Venta> compras=new ArrayList<Venta>();
    public void nuevaCompra(){
        this.vcompra.setText("");
        this.vdescuento.setText("");
        this.viva.setText("");
        this.vpago.setText("");
        this.ntarjeta.setText("");
        this.cseguridad.setText("");
        this.nombre.setText("");
        this.direccion.setText("");
        this.email.setText("");
        this.telefono.setText("");
    }

    public Boolean validarCampos(Integer n){
        if(n==1){
            if(vcompra.getText().equals("") || ntarjeta.getText().equals("") || cseguridad.getText().equals("") || nombre.getText().equals("") || direccion.getText().equals("") || email.getText().equals("") || telefono.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Hay campos obligatorios vacios");
                return true;
            }
            return false;
        }else if(n==2){
            if(vcompra.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Para calcular debe digitar almenos el campo del valor de compra");
                return true;
            }
            return false;
        }
        return false;
    }

    public void actionPerformed(ActionEvent e){
        String comando=e.getActionCommand();
        if(comando.equals("Calcular")){
            Calcular();
        }else if(comando.equals("Nueva Compra")){
            nuevaCompra();
        }else if(comando.equals("Pagar")){
            Pagar();
        }else if(comando.equals("Cerrar Caja")){
            cerrarCaja();
        }
    }
    public void cerrarCaja(){
        observacion.setText("=========================== CIERRE CAJA =================================\n Total ventas: "+compras.size());
        this.vcompra.setEnabled(false);
        this.vdescuento.setEnabled(false);
        this.viva.setEnabled(false);
        this.vpago.setEnabled(false);
        this.ntarjeta.setEnabled(false);
        this.cseguridad.setEnabled(false);
        this.nombre.setEnabled(false);
        this.direccion.setEnabled(false);
        this.email.setEnabled(false);
        this.telefono.setEnabled(false);
    }
    private Integer descuento;
    private Integer iva;
    public void Calcular(){
        if(validarCampos(2)){

        }else{
            if(viva.getText().equals("")){
                iva=0;
            }else{
                iva=Integer.parseInt(viva.getText());
            }
            if(vdescuento.getText().equals("")){
                descuento=0;
            }else{
                descuento=Integer.parseInt(vdescuento.getText());
            }
            Float total;
            if(iva==0 || descuento==0){
                total=Float.parseFloat(vcompra.getText());
            }else{
                Float tota=Float.parseFloat(vcompra.getText());
                total=tota-(tota*descuento/100)+(tota*iva/100);
            }
            vpago.setText(total.toString());
        }
    }

    public void Pagar(){
        if(validarCampos(1)){
            
        }else{
            Calcular();
            Usuario user=new Usuario(nombre.getText(),direccion.getText(),email.getText(),Integer.parseInt(telefono.getText()));
            Tarjeta tarjeta=new Tarjeta(this.ntarjeta.getText(),Integer.parseInt(cseguridad.getText()),user);
            if(tarjeta.veriFicacionCodigoSeguridad()){
                Venta venta=new Venta(Float.parseFloat(vpago.getText()),descuento,iva);
                compras.add(venta);
                JOptionPane.showMessageDialog(null,"Venta realizada completamente");
                nuevaCompra();
            }else{
                JOptionPane.showMessageDialog(null,"Error al procesar el pago, Codigo de verificacion de tarjeta incorrecto");
            }
        }
    }

    Interfaz(){

        setTitle("Pago con Tarjeta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        vcompra = new JTextField();
        vdescuento = new JTextField();
        viva = new JTextField();
        vpago = new JTextField();
        jPanel3 = new JPanel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        ntarjeta = new JTextField();
        cseguridad = new JTextField();
        nombre = new JTextField();
        direccion = new JTextField();
        email = new JTextField();
        telefono = new JTextField();
        calcular = new JButton();
        pagar = new JButton();
        nuevaCompra = new JButton();
        cerrarCaja = new JButton();
        jScrollPane1 = new JScrollPane();
        observacion = new JTextArea();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(BorderFactory.createTitledBorder("Informacion de la compra"));

        jLabel1.setText("Valor compra:");

        jLabel2.setText("Descuento:");

        jLabel3.setText("IVA:");

        jLabel4.setText("Valor a pagar:");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vcompra, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(vdescuento)
                            .addComponent(vpago)
                            .addComponent(viva))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(vcompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(vdescuento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(viva, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(vpago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.setBorder(BorderFactory.createTitledBorder("Informacion de la Tarjeta"));

        jLabel5.setText("Número tarjeta: ");

        jLabel6.setText("Codigo de seguridad:");

        jLabel7.setText("Nombre*:");

        jLabel8.setText("Direccion*:");

        jLabel9.setText("Email*:");

        jLabel10.setText("Telefono*:");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cseguridad, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(nombre, GroupLayout.Alignment.LEADING)
                    .addComponent(direccion, GroupLayout.Alignment.LEADING)
                    .addComponent(email, GroupLayout.Alignment.LEADING)
                    .addComponent(telefono, GroupLayout.Alignment.LEADING)
                    .addComponent(ntarjeta))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ntarjeta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cseguridad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(telefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        calcular.setText("Calcular");

        pagar.setText("Pagar");
        nuevaCompra.setText("Nueva Compra");

        cerrarCaja.setText("Cerrar Caja");

        observacion.setColumns(20);
        observacion.setRows(5);
        jScrollPane1.setViewportView(observacion);

        /*Asigno actionlistener a botones*/
        calcular.addActionListener(this);
        pagar.addActionListener(this);
        nuevaCompra.addActionListener(this);
        cerrarCaja.addActionListener(this);
        /*Asigno actionlistener a botones*/

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(nuevaCompra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pagar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(calcular, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cerrarCaja, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(calcular)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pagar)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nuevaCompra)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cerrarCaja)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
        show();
    }
}
