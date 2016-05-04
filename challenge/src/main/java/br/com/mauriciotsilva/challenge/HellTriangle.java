package br.com.mauriciotsilva.challenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HellTriangle {

	private final int[][] rows;

	public HellTriangle(int[][] rows) {
		this.rows = rows;
	}

	public Collection<Integer> path() {
		final List<Integer> path = new ArrayList<>();

		for (int i = 0; i < rows.length; i++) {

			int selected = 0;
			int[] columns = rows[i];

			for (int j = 0; j < columns.length; j++) {
				if (i != j && i != j + 1) {
					continue;
				}

				int value = columns[j];
				if (selected < value) {
					selected = value;

				}
			}
			path.add(selected);
		}

		return Collections.unmodifiableCollection(path);
	}

	public int sum() {
		return path().stream().reduce(Integer::sum).orElse(0);
	}

}
