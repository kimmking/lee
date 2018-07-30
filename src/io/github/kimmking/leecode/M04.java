package io.github.kimmking.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class M04 {

    public static void main(String[] args){
        int[] test1 = null,test2 = null;
        double ret = 0;

        test1 = new int[]{1,3,5,7,9,11,12};
        test2 = new int[]{2,4,6,8,10};

        ret = new Solution().findMedianSortedArrays(test1,test2);
        System.out.println(ret);

        test1 = new int[]{1,3,5,7,9,11,12};
        test2 = new int[]{};

        ret = new Solution().findMedianSortedArrays(test1,test2);
        System.out.println(ret);

        test1 = new int[]{1,1};
        test2 = new int[]{1,1};

        ret = new Solution().findMedianSortedArrays(test1,test2);
        System.out.println(ret);

        test1 = new int[]{1,3};
        test2 = new int[]{2};

        ret = new Solution().findMedianSortedArrays(test1,test2);
        System.out.println(ret);


        test1 = new int[]{1};
        test2 = new int[]{2};

        ret = new Solution().findMedianSortedArrays(test1,test2);
        System.out.println(ret);

        test1 = new int[]{2,2,2,2};
        test2 = new int[]{2,2,2};

        ret = new Solution().findMedianSortedArrays(test1,test2);
        System.out.println(ret);


        test1 = new int[]{1,4};
        test2 = new int[]{};

        ret = new Solution().findMedianSortedArrays(test1,test2);
        System.out.println(ret);

    }

    private static class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            if (nums1.length == 0 && nums2.length == 0) return 0;
            if (nums1.length == 0) {
                return nums2.length % 2 == 1 ? nums2[nums2.length / 2] : ((nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0d);
            } else if (nums2.length == 0) {
                return nums1.length % 2 == 1 ? nums1[nums1.length / 2] : ((nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0d);
            }

            int[] arr = new int[nums1.length+nums2.length];
            System.arraycopy(nums1,0,arr,0,nums1.length);
            System.arraycopy(nums2,0,arr,nums1.length,nums2.length);
            Arrays.sort(arr);

            return arr.length % 2 == 1 ? arr[arr.length / 2] : ((arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0d);

        }

        public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

            if(nums1.length == 0 && nums2.length ==0) return 0;
            if(nums1.length == 0){
                return nums2.length % 2 == 1? nums2[nums2.length/2] : ((nums2[nums2.length/2-1]+nums2[nums2.length/2])/2.0d);
            }else if(nums2.length == 0){
                return nums1.length % 2 == 1? nums1[nums1.length/2] : ((nums1[nums1.length/2-1]+nums1[nums1.length/2])/2.0d);
            }

            int p1=0,p2=nums1.length-1;
            int q1=0,q2=nums2.length-1;

            double ret = 0d;


            while(p1<=p2&&q1<=q2){


                if(p1==p2&&q1==q2)
                    return (nums1[p1] + nums2[q1])/2.0d;

                    if (nums1[p1] < nums2[q1]) {
                        p1++;
                    } else {
                        q1++;
                    }
                    if (nums1[p2] > nums2[q2]) {
                        p2--;
                    } else {
                        q2--;
                    }

               // System.out.println("p1="+p1+",p2="+p2+",q1="+q1+",q2="+q2);
            }

            if(p1>p2) {
                while (q1 + 1 < q2) {
                    q1++;
                    q2--;
                }
                if (q1 == q2) {
                    return nums2[q1];
                }else {
                    return (nums2[q1]+nums2[q2])/2.0d;
                }
            }


            if(q1>q2) {
                while (p1 + 1 < p2) {
                    p1++;
                    p2--;
                }
                if (p1 == p2) {
                    return nums1[p1];
                }else {
                    return (nums1[p1]+nums1[p2])/2.0d;
                }
            }

            return ret;
        }

    }

}


