import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 {
    private JButton okbutton;
    public JPanel mainPanel;
    private JTextField consultaTxt;
    private JLabel resultadoTxt;
    private JButton nombre;
    private JLabel cedula;
    private JLabel b1;
    private JLabel bi2;
    private JLabel promedio;

    public form1() {
        okbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://localhost:3306/estudiantes1";
                String user="root";
                String password="123456";
                try (Connection connection= DriverManager.getConnection(url,user,password))
                {

                    System.out.println("Conectado a la base de datos");
                    String query="select * from estudiantes1 where cedula = "+ consultaTxt.getText();
//                    System.out.println(query);
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        float pnotas = (resultSet.getFloat("b1")+resultSet.getFloat("b2"))/2;
                        System.out.println(resultSet.getString("nombre"));
                        resultadoTxt.setText(resultSet.getString("nombre"));
                        System.out.println(resultSet.getString("cedula"));
                        cedula.setText(resultSet.getString("cedula"));
                        System.out.println(resultSet.getString("b1"));
                        b1.setText(resultSet.getString("b1"));
                        System.out.println(resultSet.getString("b2"));
                        bi2.setText(resultSet.getString("b2"));
                        promedio.setText(String.valueOf(pnotas));
                    }
                }catch (SQLException e1){
                    System.out.println(e1);
                    System.out.println("Error al conectar a la base de datos: " + e1.getMessage());
                }
            }
        });
        nombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://localhost:3306/estudiantes1";
                String user="root";
                String password="123456";
                try (Connection connection= DriverManager.getConnection(url,user,password))
                {

                    System.out.println("Conectado a la base de datos");
                    String query="select * from estudiantes1 where nombre = "+ consultaTxt.getText();
//                    System.out.println(query);
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        float pnotas = (resultSet.getFloat("b1")+resultSet.getFloat("b2"))/2;
                        System.out.println(resultSet.getString("nombre"));
                        resultadoTxt.setText(resultSet.getString("nombre"));
                        System.out.println(resultSet.getString("cedula"));
                        cedula.setText(resultSet.getString("cedula"));
                        System.out.println(resultSet.getString("b1"));
                        b1.setText(resultSet.getString("b1"));
                        System.out.println(resultSet.getString("b2"));
                        bi2.setText(resultSet.getString("b2"));
                        promedio.setText(String.valueOf(pnotas));
                    }
                }catch (SQLException e2){
                    System.out.println(e2);
                    System.out.println("Error al conectar a la base de datos: " + e2.getMessage());
                }
            }
        });
    }
}
