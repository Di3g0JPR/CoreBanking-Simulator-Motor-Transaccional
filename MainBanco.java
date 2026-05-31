public class MainBanco{
    public static void main(String[] args){
        String [] clientes = {"M. Gallardo", "E. Fernandez", "L. Pisculichi", "J. Alvarez"};
        double [] saldoPesos = {50000.0, 120000.0, 85000.0, 30000.0};

        // Positivos = Ingresos | Negativos = Gastos/Extracciones
        double [][] movimientos ={ {15000.0, -5000.0, -80000.0, 2000.0, -1000.0},
            {5000.0, 2000.0, -15000.0, -10000.0, 50000.0},
            {-200000.0, 5000.0, 10000.0, -5000.0, -2000.0},
            {10000.0, -2000.0, -5000.0, 15000.0, -4000.0}
        };
    
        System.out.println("--CORE BANKING: PROCESAMIENTO NOCTURNO--");

        //Posible Fraude

            int clienteSospechoso = LogicaBancaria.auditoriaFraude(movimientos);
        System.out.println("ALERTA DE SEGURIDAD: Movimiento inusual detectado en la cuenta de " + clientes[clienteSospechoso]);
        System.out.println("Bloqueando tarjeta preventivamente...\n");

        //Procesamiento y Conciliacion
    
        System.out.println("--Conciliacion de saldos--");
        
            double[] saldosFinales = LogicaBancaria.movimientosSaldos(movimientos, saldoPesos, clientes);
    
        for (int i = 0; i < clientes.length; i++) {
            System.out.println(clientes[i] + " - Saldo final: $" + saldosFinales[i]);
        }

        //Transferencias
    
        int cliente = 2;

        System.out.println("\n--- MODULO DE TRANSFERENCIAS ---");
    
        System.out.println("Bienvenido/a, " + clientes[cliente]);
        
            LogicaBancaria.realizarTransaccion(saldosFinales, cliente);
        
        System.out.println("Operacion finalizada. Saldo actual: $" + saldosFinales[cliente]);
    }
}