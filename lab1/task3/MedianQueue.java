package task3;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.PriorityQueue;

public class MedianQueue {
	private PriorityQueue<Integer> higher;
	private PriorityQueue<Integer> lower;

	MedianQueue() {
		higher = new PriorityQueue<>(Comparator.naturalOrder());
		lower = new PriorityQueue<>(Comparator.reverseOrder());
	}

	private void rebalance() {
		if (higher.size()-lower.size()>1) {
			lower.add(higher.poll());
		} else if (lower.size() - higher.size() >1) {
			higher.add(lower.poll());
		}
	}

	public void add(Integer value) {
		if (value > Optional.ofNullable(higher.peek()).orElse(Integer.MIN_VALUE)) {
			higher.add(value);
		} else {
			lower.add(value);
		}
		rebalance();
	}

	/**
	 * Get the median of the number in the queue
	 * @return median value or null if queue is empty
	 */
	public Integer getMedian() throws NullPointerException {
		if (higher.size() == 0) {
			return lower.peek();
		}
		if (lower.size() == 0) {
			return higher.peek();
		}
		if (higher.size() == lower.size()) {
			return (higher.peek()+lower.peek())/2;
		}
		if (higher.size() > lower.size()) {
			return higher.peek();
		} else {
			return lower.peek();
		}
	}

	/**
	 * Return and remove the median
	 * @return median value or null if queue is empty
	 */

	public Integer pollMedian()  {
		if (higher.size() == 0) {
			return lower.poll();
		}
		if (lower.size() == 0) {
			return higher.poll();
		}
		if (higher.size() == lower.size()) {
			return (higher.poll()+lower.peek())/2;
		}
		if (higher.size() > lower.size()) {
			return higher.poll();
		} else {
			return lower.poll();
		}
	}
	public void removeMedian() {
		pollMedian();
	}

}
