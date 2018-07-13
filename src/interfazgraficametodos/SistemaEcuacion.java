package interfazgraficametodos;
//UNIDAD III: M�TODOS DE SOLUCI�N DE SISTEMAS DE ECUACIONES LINEALES.
public class SistemaEcuacion {
	static double M[][], A[][], X[], Y[];
	static int m, n;
	static String Encabezado[];
	public static double [] Cramer(double [][] M, int m, int n) {
		double Det = 0, b []= new double[m], Copia[][] =  new double[m][m], Detx[] = new double[m];
		A = new double[m][n];
		X = new double[m];
		A = Matriz.Copia(M, A, m, n);
		M = new double[m][m];
		M = Matriz.Copia(A, M, m, m);
		for (int i = 0; i < m; i++)
			b[i] = A[i][m];
                Determinante d = new Determinante();
		Det = d.determinante(M);
		Copia = Matriz.Copia(M, Copia, m, m);
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < m; i++)
				Copia[i][j] = b[i];
			Detx[j] = d.determinante(Copia);
			Copia = Matriz.Copia(M, Copia, m, m);
			X[j] = Detx[j] / Det;
		}
		return X;
	}
}