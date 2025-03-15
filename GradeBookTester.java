import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	
	private GradeBook gradeBook;
	private GradeBook gradeBook2;

	@BeforeEach
	void setUp() throws Exception {
		gradeBook = new GradeBook(5);
		gradeBook2 = new GradeBook(5);
		
		gradeBook.addScore(50.5);
		gradeBook.addScore(75.0);
		
		gradeBook2.addScore(30.0);
		gradeBook2.addScore(90.0);
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
		gradeBook = null;
		gradeBook2 = null;
	}

	@Test
	void testAddScore() {
		// test to compare the contents in the method gradeBook vs what is expected
		assertTrue(gradeBook.toString().contains("50.5 " )&& gradeBook.toString().contains("75.0 "), " strings should match");
		assertEquals(2, gradeBook.getScoreSize(),"Sizes should be same");
		
		assertTrue(gradeBook2.toString().contains("30.0 ") && gradeBook2.toString().contains("90.0 "), " strings should match");
		assertEquals(2, gradeBook2.getScoreSize(),"Sizes ahould be thesame");
		
		
		
		
	}

	@Test
	void testSum() {
		
		assertEquals(125.5, gradeBook.sum(), "The total sum should be 125.5");
		assertEquals(120.0, gradeBook2.sum(), "The total sum should be 120.0");
	}

	@Test
	void testMinimum() {
		assertEquals(50.5, gradeBook.minimum(), "50.5 should be the minimum score");
		assertEquals(30.0, gradeBook2.minimum(), "30.0 should be the minimum score");
	}

	@Test
	void testFinalScore() {
		assertEquals(75.0, gradeBook.finalScore(), "75.0 should be the final score");
		assertEquals(90.0, gradeBook2.finalScore(), "90.0 should be the final score");
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, gradeBook.getScoreSize(), "Score size should equal 2");
		assertEquals(2, gradeBook2.getScoreSize(), " Score size should equal 2");
	}

	@Test
	void testToString() {
		assertEquals(gradeBook.toString().contains("50.5" )&& gradeBook.toString().contains("75.0"), " strings should match");
		assertEquals(gradeBook2.toString().contains("30.0") && gradeBook2.toString().contains("90.0"), " strings should match");

	}

}
