import java.util.Scanner;

public class LogicaBancaria{
    public static int auditoriaFraude ( double [][] matriz ){
        double minimo = matriz[0][0];
        int cliente = 0;
        
        for (int i = 0; i < matriz.length; i++){
            for(int j = 0 ; j < matriz [i].length; j++ ){
                if (matriz [i][j] < minimo ){
                    minimo = matriz [i][j];
                    cliente = i;
                }
            }
        }
        return cliente;
        
    }

    public static double [] movimientosSaldos ( double [][] matriz, double [] saldos, String[] clientes ){
        
        int fila = matriz.length;
        double [] saldosActuales = new double [fila];

        for (int i = 0 ; i < fila ; i ++ ){
            saldosActuales [i] = saldos [i];
            
            for ( int j = 0 ; j < matriz[i].length ; j++ ){
                if ( (saldosActuales [i] + matriz [i] [j]) >= 0 ){
                    saldosActuales [i] = saldosActuales [i] + matriz [i] [j];
                }else {
                    System.out.println("La transaccion de " + matriz[i][j] + "$, es rechazada por fondos insuficientes");
                }
            }
        }
        
        return saldosActuales;
    }

    public static void realizarTransaccion( double [] saldos, int idCliente ){
        Scanner sc = new Scanner ( System.in );
        
        System.out.println("Saldo disponible: $" + saldos [idCliente] );
        
        System.out.println("Ingrese el monto a transferir:");
        double monto = sc.nextDouble();

        while(monto <= 0 || monto > saldos[idCliente] ){
            System.out.println("Error: Por fondos insuficientes o monto ingresado invalido. Ingrese otro monto :");
            monto = sc.nextDouble();
        }

        saldos [idCliente] = saldos[idCliente] - monto;

        sc.close();
    }
}