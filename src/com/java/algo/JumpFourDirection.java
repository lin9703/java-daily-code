package com.java.algo;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
 * Input: 테스트 케이스 개수, 배열의 크기, 참가자 수, 숫자판 정보, 참가자 정보, 함정 정보 
 * Output: 참가자들의 상금의 합 
 * Condition: 참가비 1000원 
 */
public class JumpFourDirection {
	// 1234-동서남북 순서 (0 제외)
	static int[] dx = { 0, 1, 0, -1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Solution32.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int Y = sc.nextInt(); // 배열의 Y축
			int X = sc.nextInt(); // 배열의 X축
			int N = sc.nextInt(); // 참가자 수

			int answer = 0;
			// 숫자판
			int[][] map = new int[Y + 1][X + 1];
			for (int i = 1; i < Y + 1; i++) {
				for (int j = 1; j < X + 1; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 참가자 정보 (시작 위치 Y, X 좌표 및 참가횟수)
			List<Participant> participants = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				participants.add(new Participant(sc.nextInt(), sc.nextInt(), sc.nextInt(), -1000));
			}

			// 함정 정보
			int trapN = sc.nextInt();
			for (int i = 0; i < trapN; i++) {
				map[sc.nextInt()][sc.nextInt()] = 0;
			}

			for (int i = 0; i < N; i++) {
				Participant p = participants.get(i);

				int y = p.y;
				int x = p.x;
				int count = p.count;

				for (int j = 0; j < count; j++) {
					if (x < 1 && y < 1 && x > X && y > Y) { // 숫자판 경계 넘으면 아웃
						y = 0;
						x = 0;
						break;
					}

					int num = map[y][x];
					if (num == 0) { // 함정에 빠지면 아웃
						y = 0;
						x = 0;
						break;
					}

					y += dy[num / 10] * (num % 10);
					x += dx[num / 10] * (num % 10);
				}

				p.setLocation(y, x);
				answer += p.calculate(map[p.y][p.x]);
			}

			System.out.println("#" + test_case + " " + answer);
		}

	}

	static class Participant {
		int y;
		int x;
		int count;
		int money;

		public Participant(int y, int x, int count, int money) {
			this.y = y;
			this.x = x;
			this.count = count;
			this.money = money;
		}

		private void setLocation(int y, int x) {
			this.y = y;
			this.x = x;
		}

		private int calculate(int location) {
			return money += location * 100;
		}

	}
}
