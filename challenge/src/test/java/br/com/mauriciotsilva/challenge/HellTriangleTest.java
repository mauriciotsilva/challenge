package br.com.mauriciotsilva.challenge;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.isOneOf;

import org.junit.Test;

public class HellTriangleTest {

	@Test
	public void shouldSumPathValue() {
		int[][] values = { { 6 }, { 3, 5 }, { 9, 7, 1 }, { 4, 6, 8, 4 } };
		HellTriangle triangle = new HellTriangle(values);

		assertEquals(26, triangle.sum());
	}

	@Test
	public void shouldBeNineOrSevenAtThirdRow() {

		int[][] values = { { 6 }, { 3, 1 }, { 9, 7, 1 } };
		HellTriangle triangle = new HellTriangle(values);

		Integer value = triangle.path().stream().skip(2).findFirst().get();
		assertThat(value, isOneOf(9, 7));
	}

	@Test
	public void shouldPathContainsGreatherValue() {

		int[][] values = { { 1 }, { 3, 5 }, { 10, 9, 7 } };
		HellTriangle triangle = new HellTriangle(values);

		assertThat(triangle.path(), contains(1, 5, 9));
	}

}
