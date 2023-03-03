/*
 * @lc app=leetcode id=4 lang=golang
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	if len(nums1) < len(nums2) {
		return findMedian(nums1, nums2)
	}
	return findMedian(nums2, nums1)
}
func findMedian(nums1 []int, nums2 []int) float64 {
	m := len(nums1)
	n := len(nums2)
	half := (m + n) / 2
	l := 0
	r := m
	for l <= r {
		i := (l + r) / 2
		j := half - i
		if i > 0 && j < n && nums1[i-1] > nums2[j] {
			r = i
			continue
		}
		if i < m && j > 0 && nums1[i] < nums2[j-1] {
			l = i + 1
			continue
		}
		var minRight int
		if i == m {
			minRight = nums2[j]
		} else if j == n {
			minRight = nums1[i]
		} else if nums1[i] < nums2[j] {
			minRight = nums1[i]
		} else {
			minRight = nums2[j]
		}
		if (m+n)%2 == 1 {
			return float64(minRight)
		}
		var maxLeft int
		if i == 0 {
			maxLeft = nums2[j-1]
		} else if j == 0 {
			maxLeft = nums1[i-1]
		} else if nums1[i-1] > nums2[j-1] {
			maxLeft = nums1[i-1]
		} else {
			maxLeft = nums2[j-1]
		}

		return (float64(maxLeft) + float64(minRight)) / 2.0
	}

	return 0.0
}

// @lc code=end

