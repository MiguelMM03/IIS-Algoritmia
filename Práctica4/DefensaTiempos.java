package alg.p4;

public class DefensaTiempos {
	
	public static void main(String[] args) {
		int n=Integer.MAX_VALUE;
		for(int i=10;i<n;i*=2) {
			int[] defensas=Defensa.generarGrupoDefensa(i);
			int[] enemigos=Defensa.generarEnemigos(i);
	
			Defensa defensa=new Defensa(i,enemigos,defensas);
			long t1 = System.currentTimeMillis();
			int[] asignacion=defensa.asignar();
			long t2=System.currentTimeMillis();
			System.out.printf("size:%d - time:%d ms\n", i, t2-t1);
		}
		
	}
}
