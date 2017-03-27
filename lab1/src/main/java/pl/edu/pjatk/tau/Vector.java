package pl.edu.pjatk.tau;

import java.util.List;

public interface Vector {
    public Vector addVector(Vector vector);
    public static Vector addVectors(Vector vector1, Vector vector2) {
		return null;
	}
    public void setVectorValues(List<Double> vector);
    public List<Double> getVectorValues();
}
