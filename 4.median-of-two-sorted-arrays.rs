/*
 * @lc app=leetcode id=4 lang=rust
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
impl Solution {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        if nums1.len() > nums2.len() {
            Solution::solve(&nums2, &nums1)
        } else {
            Self::solve(&nums1, &nums2)
        }
    }

    pub fn solve(a: &Vec<i32>, b: &Vec<i32>) -> f64 {
        let m = a.len();
        let n = b.len();
        let half = (m + n + 1) / 2;
        let mut min = 0;
        let mut max = m;
        while min <= max {
            let i = (min + max) / 2;
            let j = half - i;
            if i > min && a[i - 1] > b[j] {
                max = i - 1;
            } else if i < max && b[j - 1] > a[i] {
                min = i + 1;
            } else {
                let maxLeft:i32;
                if i == 0 {
                    maxLeft = b[j - 1];
                } else if j == 0 {
                    maxLeft = a[i - 1];
                } else {
                    maxLeft = if a[i - 1] > b [j - 1] { a[i - 1]} else { b[j - 1] };
                }
                if (m + n) % 2 == 1 {
                    return maxLeft as f64;
                }
                let minRight: i32;
                if i == m {
                    minRight = b[j];
                } else if j == n {
                    minRight = a[i];
                } else {
                    minRight = if a[i] < b[j] { a[i] } else { b[j] };
                }

                return (maxLeft + minRight) as f64 / 2.0;
            }
        }

        0.0
    }
}
// @lc code=end

