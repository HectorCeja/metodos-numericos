package interfazgraficametodos;

import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Matriz {

	public static double[][] Copia(double[][] M, double[][] A, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				A[i][j] = M[i][j];
		}
		return A;
	}

	public static JTable Copia(double[][] A, JTable M, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				M.setValueAt(A[i][j], i, j);
		}
		return M;
	}
	
	public static double[] CopiaVector(JTable M, double[] A, int m) {
		for (int i = 0; i < m; i++)
			A[i] = Double.parseDouble(String.valueOf(M.getValueAt(i, 0)));
		return A;
	}

	public static JTable CopiaVector(double[] A, JTable M, int m) {
		for (int i = 0; i < m; i++)
			M.setValueAt(Double.parseDouble(String.valueOf(A[i])), i, 0);
		return M;
	}
}