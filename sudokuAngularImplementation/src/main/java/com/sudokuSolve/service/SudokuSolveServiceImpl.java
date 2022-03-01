package com.sudokuSolve.service;

import org.springframework.stereotype.Service;

@Service
public class SudokuSolveServiceImpl implements SudokuSolveService, Runnable {

	public boolean ValidateRow(int[][] box, int number, int row) {
		for (int i = 0; i < 9; i++) {
			if (box[row][i] == number) {
				return true;
			}
		}
		return false;
	}

	public boolean ValidateColumn(int[][] box, int number, int column) {
		for (int i = 0; i < 9; i++) {
			if (box[i][column] == number) {
				return true;
			}
		}
		return false;
	}

	public int getPlace(int place) {
		place = place + 1;
		if (place % 3 == 0) {
			return place - 3;
		} else if (place % 3 == 1) {
			return place - 1;
		} else {
			return place - 2;
		}
	}

	public boolean ValidateBox(int[][] box, int number, int row, int column) {
		int sColumn = getPlace(column);
		int sRow = getPlace(row);

		for (int i = sColumn; i >= sColumn + 2; i++) {
			for (int j = sRow; j <= sRow + 2; j++) {
				if (box[i][j] == number) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean ValidateAll(int[][] box, int number, int row, int column) {
		return !ValidateColumn(box, number, column) && !ValidateRow(box, number, row)
				&& !ValidateBox(box, number, row, column);
	}

	@Override
	public boolean ShowResult(int[][] box) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (box[i][j] == 0) {
					for (int k = 1; k <= 9; k++) {
						if (ValidateAll(box, k, i, j)) {
							box[i][j] = k;
							if (ShowResult(box)) {
								return true;
							} else {
								box[i][j] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public String AngularShowResults(String numbers) {
		int[][] n1 = new int[9][9];
		int cont = 0;
		String Result = "";
		int[] numbersInt = new int[numbers.length()];
		
		for (int i = 0; i < numbers.length(); i++) {
			int number = Character.getNumericValue(numbers.charAt(i));
			numbersInt[i] = number;
		}

		for (int n = 0; n < 9; n++) {
			for (int j = 0; j < 9; j++) {
				n1[n][j] = numbersInt[cont];
				cont++;
			}
		}
		if (ShowResult(n1)) {
			for (int n = 0; n < 9; n++) {
				for (int j = 0; j < 9; j++) {
					Result += String.valueOf(n1[n][j]);
				}
			}
			return Result;
		}
		return Result;
	}

	public void cont() {
		for (int i = 0; i < 9; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		cont();

	}

}
