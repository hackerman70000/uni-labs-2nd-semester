package uk.blizni.jakub.lab1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MedianQueueTest {

	private Integer median(int[] arr) {
		if (arr.length == 0) return null;
		var a = arr.clone();
		Arrays.sort(a);
		if (a.length % 2 == 0) {
			return (int)(a[a.length/2] + a[a.length/2-1])/2;
		}
		return a[a.length/2];
	}

	static Stream<Arguments> getValues() {
		return IntStream.range(0, 100).mapToObj(i -> Arguments.of((Object) new Random().ints(i, 0, 1001).toArray()));
	}
	@ParameterizedTest
	@MethodSource("getValues")
	void add(int[] nums) {
		var queue = new MedianQueue();
		for (int num : nums) {
			assertDoesNotThrow(() -> queue.add(num));
		}
	}

	@ParameterizedTest
	@MethodSource("getValues")
	void getMedian(int[] nums) {
		var queue = new MedianQueue();
		for (int num : nums) {
			assertDoesNotThrow(() -> queue.add(num));
		}
		assertEquals(median(nums), queue.getMedian());
	}

	@ParameterizedTest
	@MethodSource("getValues")
	void pollMedian(int[] nums) {
		var queue = new MedianQueue();
		for (int num : nums) {
			assertDoesNotThrow(() -> queue.add(num));
		}
		assertEquals(median(nums), queue.pollMedian());
	}

	@ParameterizedTest
	@MethodSource("getValues")
	void removeMedian(int[] nums) {
		var queue = new MedianQueue();
		var uniqueNums = IntStream.of(nums).distinct().toArray();
		for (int num : uniqueNums) {
			assertDoesNotThrow(() -> queue.add(num));
		}
		assertDoesNotThrow(queue::removeMedian);
	}
}