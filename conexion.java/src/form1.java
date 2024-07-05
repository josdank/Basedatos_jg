import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

public class form1 {
    private JButton button1;
    public JPanel mainPanel;
    private JLabel nombreTxt;

    public form1() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*String url = "jdbc:mysql://localhost:3306/estudiantes";
                String user = "root";
                String password = "123456";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.println("CONECTADO A LA BASE DE DATOS");

                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Ingrese la cédula del estudiante: ");
                    String cedula = scanner.nextLine();

                    String query = "SELECT * FROM estudiantes WHERE cedula = 1752370344";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, cedula);

                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        // Mostrar los datos del estudiante
                        String nombre = resultSet.getString("nombre");
                        String cedulaEstudiante = resultSet.getString("cedula");
                        double notaBim1 = Double.parseDouble(resultSet.getString("BIM_1"));
                        double notaBim2 = Double.parseDouble(resultSet.getString("BIM_2"));
                        double totalNotas = notaBim1 + notaBim2;

                        System.out.println("Nombre: " + nombre);
                        System.out.println("Cédula: " + cedulaEstudiante);
                        System.out.println("Notas del primer Bimestre: " + notaBim1);
                        System.out.println("Notas del segundo Bimestre: " + notaBim2);
                        System.out.println("Nota total: " + totalNotas);

                        double notaParaPasar = 28.0;
                        if (totalNotas >= notaParaPasar) {
                            System.out.println("El estudiante pasa.");
                        } else {
                            double faltaParaPasar = notaParaPasar - totalNotas;
                            System.out.println("Al estudiante le falta " + faltaParaPasar + " para pasar.");
                            System.out.println("El estudiante reprueba.");
                        }
                    } else {
                        System.out.println("No se encontraron registros para la cédula ingresada.");
                    }
                    while (resultSet.next()){
                        System.out.println(resultSet.getString("nombre"));
                        nombreTxt.setText(resultSet.getString("nombre"));
                    }
                } catch (SQLException e1) {
                    System.out.println("Error al conectar a la base de datos: " + e1.getMessage());
                }*/
                String url="jdbc:mysql://localhost:3306/estudiantes";
                String user="root";
                String password="123456";

                try (Connection connection= DriverManager.getConnection(url,user,password))
                {
                    System.out.println("Conectado a la base de datos");
                    String query="select * from estudiantes where cedula=1752370344";
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        System.out.println(resultSet.getString("nombre"));
                        nombreTxt.setText(resultSet.getString("nombre"));
                    }
                }catch (SQLException e1){
                    System.out.println(e1);
                    System.out.println("Error al conectar a la base de datos: " + e1.getMessage());
                }
            }
        });
    }
}
