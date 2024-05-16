import java.util.Scanner;

public class App {
    static String[] nombre_empleado=new String[5];
    static String[] categoria_empleado=new String[5];
    static double[] salario_empleado=new double[5];
    static double aumento=0;
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("<---------Registro de empleados---------->");
        RegistroEmpleados(nombre_empleado, categoria_empleado, salario_empleado, sc);
        CalcularAumentos(categoria_empleado, salario_empleado,aumento);
        MostrarEmpleados(nombre_empleado, categoria_empleado, salario_empleado);
    }

    public static void RegistroEmpleados(String[] nombre_empleado, String[] categoria_empleado, double[] salario_empleado, Scanner sc){
        for (int i = 0; i < nombre_empleado.length; i++) {
            System.out.print("\nIngrese el nombre del Empleado("+(i+1)+"/"+(nombre_empleado.length)+"): ");
            nombre_empleado[i]=sc.nextLine();
            System.out.print("Ingrese la categoria del empleado: ");
            categoria_empleado[i]=sc.nextLine();
            boolean key=true;
            while (key) {
                try {
                    System.out.print("Ingrese el salario del empleado: ");
                    salario_empleado[i]=sc.nextDouble();
                    key=false;
                } catch (Exception e) {
                    System.out.println("(!)Error: Solo se aceptan valores numericos......");
                    sc.next();
                }
            }
            sc.nextLine();
            
        }
    }

    public static double CalcularAumentos(String[] categoria_empleado, double[] salario_empleado,double aumento){
        for (int i = 0; i < categoria_empleado.length; i++) {
            if ((categoria_empleado[i].equalsIgnoreCase("Supervisor")) && (salario_empleado[i]<=10000)) {
                aumento=(salario_empleado[i]*0.15);
                salario_empleado[i]=salario_empleado[i]+aumento;
                return salario_empleado[i];
            } else {
                if ((categoria_empleado[i].equalsIgnoreCase("Secretario")) && (salario_empleado[i]<=7000)) {
                    aumento=(salario_empleado[i]*0.20);
                    salario_empleado[i]=salario_empleado[i]+aumento;
                    return salario_empleado[i];
                } else {
                    if ((categoria_empleado[i].equalsIgnoreCase("Recepcionista")) && (salario_empleado[i]<=5000)) {
                        aumento=(salario_empleado[i]*0.20);
                        salario_empleado[i]=salario_empleado[i]+aumento;
                        return salario_empleado[i];
                    }
                }
            }
        }return -1;
        
    }

    public static void MostrarEmpleados(String[] nombre_empleado, String[] categoria_empleado, double[] salario_empleado){
        for (int i = 0; i < salario_empleado.length; i++) {
            System.out.println((i+1)+"- "+nombre_empleado[i]+"-----"+categoria_empleado[i]+"-----"+salario_empleado[i]);
        }
    }
}
