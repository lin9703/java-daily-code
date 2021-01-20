package com.java.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * input: 100 미만의 양의 정수들 
 * output: 정수들의 십의 자리 숫자의 개수 
 * condition: 0이 입력되면 종료
 */
public class DigitTest1 {

	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		// output
		int[] result = new int[10];
		Arrays.fill(result, 0);

		// logic
		int temp;
		while (st.hasMoreTokens()) {
			temp = Integer.parseInt(st.nextToken());

			if (temp >= 100 || temp < 0) {
				System.out.println("100 미만의 양의 정수를 입력해주세요.");
				break;
			}
			if (temp == 0) {
				break;
			}

			result[temp / 10]++;
		}

		// print
		for (int i = 0; i < 10; i++) {
			if (result[i] != 0) {
				System.out.printf("%d : %d개\n", i, result[i]);
			}
		}
	}

}
