package com.java.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * input: 행, 열, 방향 
 * output: 살아남은 소금쟁이의 수 
 * condition: 뛰는 중 연못 밖으로 나가거나 다른 소금쟁이가 머물고 있는 곳과 부딪히면 사망 
 */
public class LivingWaterstrider {
	// 상:1, 하:2, 좌:3, 우:4 (0은 사용 X)
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("testcase/Solution22.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int saltNum = Integer.parseInt(st.nextToken());

			// 연못 초기화
			boolean[][] pond = new boolean[N][N];
			for (int i = 0; i < pond.length; i++) {
				Arrays.fill(pond[i], false);
			}

			int answer = 0;

			for (int i = 0; i < saltNum; i++) {
				int count = 3;

				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());

				while (count >= 0) {
					if (x >= 0 && y >= 0 && x < N && y < N && !pond[x][y]) {
						if (count == 0 && !pond[x][y]) {
							pond[x][y] = true;
							answer++;
							break;
						}
						x += (dx[direction] * count);
						y += (dy[direction] * count);
						count--;
						
					} else {
						break;
					}
				}

			}
			
			System.out.println("#" + test_case + " " + answer);
		}

	}

}
