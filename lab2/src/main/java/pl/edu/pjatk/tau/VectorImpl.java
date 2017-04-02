package pl.edu.pjatk.tau;

import java.util.ArrayList;
import java.util.List;

public class VectorImpl implements Vector {
	
	private List<Double> vectorValues;
	
	public VectorImpl() {
        vectorValues = new ArrayList<Double>();
    }

	public Vector addVector(Vector vector) {
		
		if(vector.getVectorValues().size() ==  this.vectorValues.size()) {		
			for(int i = 0; i < this.vectorValues.size(); i++) {
		          this.vectorValues.set(i, (this.vectorValues.get(i) + vector.getVectorValues().get(i)));
		    }	
			return this;
        } else
       throw new IllegalArgumentException("Nie mo¿na dodaæ do tego wektora!");   
	}

	public static Vector addVectors(Vector vector1, Vector vector2) {
		
		Vector vector = new VectorImpl();
		List<Double> newVectorValues = new ArrayList<Double>();
		
		if(vector1.getVectorValues().size() == vector2.getVectorValues().size() && vector1 != null && vector2 != null)
		{
			for(int i = 0; i < vector1.getVectorValues().size(); i++) {
				
				newVectorValues.add(i, (vector1.getVectorValues().get(i) + vector2.getVectorValues().get(i)));
				
			}
			vector.setVectorValues(newVectorValues);
			return vector;	
		} else
		throw new IllegalArgumentException("Nie mo¿na dodaæ tych wektorów!");   
		
	}

	public void setVectorValues(List<Double> vector) {
		
		if(vector != null && vector.size() != 0) {
			this.vectorValues = vector;
		} else
		throw new IllegalArgumentException("Nie mo¿na ustawiæ wartoœci w ten sposób!");			
	}

	public List<Double> getVectorValues() {
		return this.vectorValues;
	}

	@Override
	public Vector subVector(Vector vector) {
		if(vector.getVectorValues().size() ==  this.vectorValues.size()) {		
			for(int i = 0; i < this.vectorValues.size(); i++) {
		          this.vectorValues.set(i, (this.vectorValues.get(i) - vector.getVectorValues().get(i)));
		    }	
			return this;
        } else
       throw new IllegalArgumentException("Nie mo¿na odj¹æ tego wektora!");
	}
	
}
