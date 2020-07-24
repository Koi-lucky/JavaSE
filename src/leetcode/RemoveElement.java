package leetcode;

public class RemoveElement {

    public static void main(String[] args) {

        int[] s = { 0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement( s, val));
    }

    public static int removeElement(int[] nums, int val) {

        //快慢指针解决
        //元素的顺序可以更改
        //每找到一个相等的元素就把数组末尾的值赋给他，赋完之后再将数组的长度-1。（后指针前移）
        //如果没找到，前面的指针后移
        //
        //当我们遇到nums[i]=val 时，我们可以将当前元素与最后一个元素进行交换，并释放最后一个元素。这实际上使数组的大小减少了 1。
        //请注意，被交换的最后一个元素可能是您想要移除的值。但是不要担心，在下一次迭代中，我们仍然会检查这个元素。
        int i = 0;
        int j = nums.length;
        while(i < j) {
            if(val == nums[i]) {
                nums[i] = nums[j - 1];
                j--;
            } else {
                i ++;
            }
        }
        return j;
    }
}
