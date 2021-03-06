package Model;

import java.util.Random;

public class Autogenerate {
	private int fertigesfeld[][] = new int[9][9];
	private int feld[][] = new int[9][9];
	private int x = 0;
	private int y = 0;

	public Autogenerate(int wieViele) {
		bereiten(wieViele);
	}

	public Autogenerate(int spiel[][], int loesung[][]) {
		if (spiel != null)
			fertigesfeld = spiel;
		if (loesung != null)
			feld = loesung;
	}

	/**
	 * @return the fertigesfeld
	 */
	public int[][] getFertigesfeld() {
		return fertigesfeld;
	}

	/**
	 *  set a Number in the int Array
	 * @param x cordinate
	 * @param y cordinate
	 * @param number is the value
	 */
	public void setFertigesfeld(int x, int y, int number) {
		if (fertigesfeld[x][y] != 0 && number <= 9) {
			fertigesfeld[x][y] = number;
		}
	}

	/**
	 * @return the feld
	 */
	public int[][] getFeld() {
		return feld;
	}

	/**
	 *  To get a specific int
	 * @param x cordinate
	 * @param y cordinate
	 * @return a value
	 */
	public int getFeld(int x, int y) {
		return feld[x][y];
	}

	public boolean reihe(int x, int y, int number) {
		for (int i = 0; i < 9; i++) {
			if (feld[i][y] == number) {
				return false;
			}
		}
		return true;
	}

	public boolean spalte(int x, int y, int number) {
		for (int i = 0; i < 9; i++) {
			if (feld[x][i] == number) {
				return false;
			}
		}
		return true;
	}

	public boolean notfinished() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (feld[j][i] == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean backtracking() {
		Random random = new Random();
		int oldx = x;
		int oldy = y;
		// ob es noch nicht fertig ist
		if (notfinished()) {
			int wert = random.nextInt(8) + 1;
			// pro zahl 0-8
			for (int versuch = 0; versuch < 9; ++versuch) {
				if (dreierfeld(x, y, wert) && reihe(x, y, wert) == true && spalte(x, y, wert)) {
					feld[x][y] = wert;
					if (x + 1 >= 9) {
						x = 0;
						y++;
					} else {
						x++;
					}
					if (backtracking()) {
						return true;
					}
					// wenn nicht geklappt rueckgaengig
					x = oldx;
					y = oldy;
					feld[x][y] = 0;
				}
				// neuer wert
				if (wert + 1 > 9) {
					wert = 1;
				} else {
					wert++;
				}

			}
		} else {
			return true;
		}
		return false;
	}

	public boolean dreierfeld(int x, int y, int number) {
		int newx = 0;
		int newy = 0;
		// Setzt kordinaten auf den beginn eines Drei mal Drei feldes
		if (x >= 0 && x <= 2) {
			newx = 0;
		}
		if (x >= 3 && x <= 5) {
			newx = 3;
		}
		if (x >= 6 && x <= 8) {
			newx = 6;
		}

		if (y >= 0 && y <= 2) {
			newy = 0;
		}
		if (y >= 3 && y <= 5) {
			newy = 3;
		}
		if (y >= 6 && y <= 8) {
			newy = 6;
		}
		// Prüft das drei aml drei feld ab
		for (int i = newy; i < newy + 3; i++) {
			for (int j = newx; j < newx + 3; j++) {
				if (feld[j][i] == number) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean minifeldNL(int x, int y) {
		int newx = 0;
		int newy = 0;
		if (x >= 0 && x <= 2) {
			newx = 0;
		}
		if (x >= 3 && x <= 5) {
			newx = 3;
		}
		if (x >= 6 && x < 8) {
			newx = 6;
		}
		if (y >= 0 && y <= 2) {
			newy = 0;
		}
		if (y >= 3 && y <= 5) {
			newy = 3;
		}
		if (y >= 6 && y < 8) {
			newy = 6;
		}
		for (int i = newy; i < newy + 2; i++) {
			for (int j = newx; j < newx + 2; j++) {
				if (feld[j][i] != 0) {
					return true;
				}
			}
		}
		return false;
	}

	public void bereiten(int wieViele) {
		backtracking();
		Random random = new Random();
		for (int y = 0; y < 9; ++y) {
			for (int x = 0; x < 9; ++x) {
				fertigesfeld[x][y] = feld[x][y];
			}
		}
		for (int soll = 0; soll < wieViele; soll++) {
			y = random.nextInt(9);
			x = random.nextInt(9);
			if (fertigesfeld[x][y] != 0) {
				if (minifeldNL(x, y)) {
					int i = fertigesfeld[x][y];
					fertigesfeld[x][y] = 0;
					if (!minifeldNL(x, y)) {
						fertigesfeld[x][y] = i;
					}
				} else {
					soll--;
				}
			} else {
				soll--;
			}
		}
	}
}