package com.java.algo;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * A: 우로만 이동
 * B: 좌우로 이동
 * C: 상하좌우로 이동
 * S: 공백, W: 벽 
 * Input: 첫 줄에는 테스트 케이스 T, 다음 줄에는 배열의 크기인 N
 * Output: 로봇들이 움직인 거리의 총합 
 * Condition: 로봇은 벽과 다른 로봇이 있던 초기 위치를 넘지 못한다. 
 */
public class RobotMoveDistance {
	static int T, N;
	static int Answer;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Solution11.txt"));
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
			//////////////////////////////
			// ( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////

			Answer = 0;
			int standard = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 'S' && map[i][j] != 'W') {
						if (map[i][j] == 'A') {
							standard = 1;
						} else if (map[i][j] == 'B') {
							standard = 2;
						} else if (map[i][j] == 'C') {
							standard = 4;
						}

						Answer += getDistance(map, i, j, standard);

					}
				}
			}

			System.out.println("#" + test_case + " " + Answer);
		}
	}

	static int getDistance(char[][] map, int i, int j, int q) {
		int distance = 0;
		for (int p = 0; p < q; p++) {
			int x = i;
			int y = j;
			while (true) {
				x += dx[p];
				y += dy[p];
				if (x >= 0 && y >= 0 && x < N && y < N && map[x][y] == 'S') {
					distance++;
				} else {
					break;
				}
			}
		}
		return distance;
	}
}