package com.neuedu.test;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyTest5 {
    public static void main(String[] args) {
        int[] a = {2};
        int[] b = {};
        System.out.println("中位数为"+findMedianSortedArrays(a,b));
    }
    public static int reverse(int x){

        byte[] b = new byte[10];
        int a;
        int n = 0;
        do {
            b[n] =(byte)(x%10);
            a = x / 10;
            x = a;
            n++;
        }while (a != 0);
        long y = 0;
        a = n;
        for (int i = 0; i < a; i++){
            y += b[i]*Math.pow(10,--n);
        }
        if (y > 2147483647||y<-2147483648)
            return 0;
        else {
            return (int)y;
        }

    }
    /**给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
     * 并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     *
     */

    //方法1
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        long a = 0;
        long b = 0;
        long c;
        long n = 1;
        while (p!=null){
            a = a+p.val*n;
            n = (n*10);
            p = p.next;
        }
        n=1;
        while (q!=null){
            b = b+q.val*n;
            n = (n*10);
            q = q.next;
            System.out.println(b);
        }
        c = a+b;
        ListNode m = new ListNode(0);
        ListNode r = new ListNode(0);
        q = m;
        do {
            ListNode l = new ListNode((int)(c%10));
            m.next = l;
            m=m.next;
            c=c/10;
        }while (c!=0);
        return q.next;
    }*/
    //方法2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(0);
        l3 = l4;
        byte a;
        byte b;
        byte flag = 0;
        byte flag1 = 0;
        while (true){
            if (l1!=null){
                a = (byte) (l1.val);
                l1 = l1.next;
            }else {
                a=0;
            }
            if (l2!=null){
                b = (byte) (l2.val);
                l2 = l2.next;
            }else {
                b=0;
            }
            a = (byte) (a+b+flag1);
            if (a/10!=0){
                a=(byte) (a%10);
                flag = 1;
            }
            System.out.print("a:"+a);
            ListNode l5 = new ListNode(a);
            l4.next = l5;
            flag1=flag;
            l4 = l4.next;
            if (l1 == null&&l2==null)
                break;
            flag = 0;
        }
        if (flag1==1){
            ListNode l5 = new ListNode(flag1);
            l4.next = l5;
        }
        return l3.next;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length+nums2.length];
        int i=0,j=0,k=0,n=0;
        double m=0;
        while (i < nums1.length && j < nums2.length){
            nums3[k++] = nums1[i]>nums2[j]?nums2[j++]:nums1[i++];
        }
        if (i == nums1.length){
            while (j < nums2.length)
                nums3[k++] = nums2[j++];
        }

        if (j == nums2.length){
            while (j < nums2.length)
                nums3[k++] = nums1[i++];
        }
        if (nums3.length%2==0){
            m = (double)(nums3[nums3.length/2]+nums3[nums3.length/2-1])/2.0;
        }else {
            m = nums3[nums3.length/2];
        }
        while (n < nums3.length){
            System.out.println(nums3[n++]);
        }
        return m;

    }
}
