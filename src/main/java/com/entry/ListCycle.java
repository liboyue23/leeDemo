package com.entry;

import org.junit.Test;

/**
 * Created by lee on 16/2/15.
 */
public class ListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        } else {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        } else {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    break;
                }
            }
            if (fast == null || fast.next == null) {
                return null;
            } else {
                slow = fast;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
    }

    @Test
    public void test() {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        ListNode<Integer> head = ListNode.arrayToList(array);
        System.out.println(hasCycle(head));
        head = ListNode.createCycle(array, 3);
        System.out.println(hasCycle(head));
    }
}
