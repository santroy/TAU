package pl.edu.pjatk.tau;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class VectorTest {
	
	@Test
	public void setVectorValuesSuccessTest() {
		
		Vector vector1 = new VectorImpl();
		List<Double> vector1Values = new ArrayList<Double>();
		vector1Values.add(3.33);
		vector1.setVectorValues(vector1Values);	
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void setVectorValuesExceptionTest() {
		
		Vector vector1 = new VectorImpl();
		List<Double> vector1Values = new ArrayList<Double>();
		vector1.setVectorValues(vector1Values);	
		
	}
	
	@Test
	public void addVectorSuccessTest() {
		
		Vector vector1 = new VectorImpl();
		Vector vector2 = new VectorImpl();
		
		List<Double> vector1Values = new ArrayList<Double>();
		List<Double> vector2Values = new ArrayList<Double>();
		List<Double> expectedValue = new ArrayList<Double>();
		expectedValue.add(5.5);
		
		
		vector1Values.add(3.2);
		vector2Values.add(2.3);
		
		vector1.setVectorValues(vector1Values);
		vector2.setVectorValues(vector2Values);
		
		assertEquals(expectedValue, vector1.addVector(vector2).getVectorValues());
			
	}
	
	@Test
	public void addTwoVectorsSuccessTest() {
		
		Vector vector1 = new VectorImpl();
		Vector vector2 = new VectorImpl();
		Vector vector3 = new VectorImpl();
		
		List<Double> vector1Values = new ArrayList<Double>();
		List<Double> vector2Values = new ArrayList<Double>();
		List<Double> vector3Values = new ArrayList<Double>();
		
		vector1Values.add(1.0);
		vector1Values.add(3.0);
		
		vector1.setVectorValues(vector1Values);
		
		vector2Values.add(2.0);
		vector2Values.add(5.0);
		
		vector2.setVectorValues(vector2Values);
		
		vector3Values.add(3.0);
		vector3Values.add(8.0);
			
		vector3.setVectorValues(vector3Values);
		
		assertEquals(vector3.getVectorValues() , VectorImpl.addVectors(vector1, vector2).getVectorValues());
		
	}
	
	@Test
	public void vectorIsNotNullTest() {
		
		Vector vector1 = new VectorImpl();
		
		assertNotNull(vector1);
		
	}
	
	@Test
	public void vectorsSameLengthsFailureTest() {
		
		Vector vector1 = new VectorImpl();
		Vector vector2 = new VectorImpl();
		
		List<Double> vector1Values = new ArrayList<Double>();
		List<Double> vector2Values = new ArrayList<Double>();
		
		vector1Values.add(2.0);
		vector1Values.add(2.6);
		
		vector1.setVectorValues(vector1Values);
		
		vector2Values.add(4.6);
		
		vector2.setVectorValues(vector2Values);
		
		assertFalse(vector1.getVectorValues().size() == vector2.getVectorValues().size());
		
	}

}
