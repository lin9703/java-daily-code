package com.java.algo;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * B: 빌딩을 세울 수 있는 구획 
 * G: 공원 조성단지 
 * Input: 첫 줄에는 테스트 케이스 T, 다음 줄에는 배열의 크기인 N
 * Output: 가장 높은 빌딩의 층수 
 * Condition1: B의 인접한 구획에 G가 있다면 2층 높이여야 한다.
 * Condition2: 인접한 구획에 G가 없다면 현 위치의 가로세로에 있는 B의 개수만큼 층수를 세울 수 있다. 
 */
public class HighestBuilding {
	static int T, N;
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[] dy = { -1, 1, 0, 0, 1, 1, -1, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}

			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'B') {
						result = Math.max(result, getBuildingHeight(map, i, j));
					}

				}
			}

			System.out.println("#" + test_case + " " + result);
		}

	}

	private static int getBuildingHeight(char[][] map, int r, int c) {
		for (int i = 0; i < dx.length; i++) {
			int x = r + dx[i];
			int y = c + dy[i];

			if (isIn(x, y)) {
				if (map[x][y] == 'G') {
					return 2;
				}
			}
		}

		int height = 1;

		for (int i = 0; i < 4; i++) {
			int x = r + dx[i];
			int y = c + dy[i];

			while (isIn(x, y)) {
				if (map[x][y] == 'B')
					height++;

				x += dx[i];
				y += dy[i];
			}
		}

		return height;
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}
