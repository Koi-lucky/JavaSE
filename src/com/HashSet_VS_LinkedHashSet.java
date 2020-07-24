package com;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 比较一下 HashSet  和 LinkedHashSet
 *  LinkedHashSet 是 HashSet 的子类
 *  LinkedHashSet 继承了 HashSet  并实现了 Set 接口
 *  LinkedHashSet集合的特点：
 *  1.（多重链表）
 *          底层是一个哈希表（数组+链表/红黑树）+链表，—— 多了一条链表（记录元素的存储顺序），保证元素的有序
 *  2.LinkedHashSet集合里的元素【有序 并且 不允许重复】，HashSet集合里元素【无序 且 不允许重复】
 */
public class HashSet_VS_LinkedHashSet {

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("www");
        hashSet.add("acb");
        hashSet.add("inthe");
        hashSet.add("acb");
        System.out.println(hashSet);//[acb, www, inthe]—— 元素无序 且 不允许重复

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("www");
        linkedHashSet.add("acb");
        linkedHashSet.add("inthe");
        linkedHashSet.add("acb");
        System.out.println(linkedHashSet);//[www, acb, inthe]—— 元素有序 且 不允许重复
    }
}
