package linkedlists;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedListTest {
	 @Test
	    public void testInsert() {
	        LinkedList list = new LinkedList();
	        Assert.assertEquals(list.search(100), false);
	        list.insert(100);
	        Assert.assertEquals(list.search(100), true);

	        Assert.assertEquals(list.search(200), false);
	        list.insert(200);
	        Assert.assertEquals(list.search(200), true);

	        Assert.assertEquals(list.search(300), false);
	        list.insert(300);
	        Assert.assertEquals(list.search(300), true);
	    }

	    @Test
	    public void testInsertAfter() {
	        LinkedList list = new LinkedList();
	        list.insertAfter(10, 100);
	        Assert.assertEquals(list.search(10), true);

	        list.insert(20);
	        list.insert(30);
	        list.insert(40);
	        list.insert(50);

	        list.insertAfter(35, 30);
	        Assert.assertEquals(list.search(35), true);
	        ArrayList arrayList = list.getAllElements();
	        Assert.assertEquals(arrayList.indexOf(30), 2);
	        Assert.assertEquals(arrayList.indexOf(35), 3);

	        list.insertAfter(45, 40);
	        Assert.assertEquals(list.search(45), true);
	        arrayList = list.getAllElements();
	        Assert.assertEquals(arrayList.indexOf(40), 4);
	        Assert.assertEquals(arrayList.indexOf(45), 5);

	        list.insertAfter(55, 50);
	        Assert.assertEquals(list.search(55), true);
	        arrayList = list.getAllElements();
	        Assert.assertEquals(arrayList.indexOf(50), 6);
	        Assert.assertEquals(arrayList.indexOf(55), 7);
	    }

	    @Test
	    public void testSearch() {
	        LinkedList list = new LinkedList();
	        Assert.assertEquals(list.search(25), false);

	        list.insert(25);
	        Assert.assertEquals(list.search(25), true);

	        list.insert(35);
	        Assert.assertEquals(list.search(35), true);

	        Assert.assertEquals(list.search(45), false);
	    }

	    @Test
	    public void testDelete() {
	        LinkedList list = new LinkedList();
	        Assert.assertEquals(list.delete(25), false);

	        list.insert(25);
	        Assert.assertEquals(list.search(25), true);

	        list.delete(25);
	        Assert.assertEquals(list.search(25), false);

	        list.insert(35);
	        Assert.assertEquals(list.search(35), true);
	        list.insert(45);
	        Assert.assertEquals(list.search(45), true);
	        list.insert(55);
	        Assert.assertEquals(list.search(55), true);

	        list.delete(55);
	        Assert.assertEquals(list.search(55), false);
	        list.delete(45);
	        Assert.assertEquals(list.search(45), false);
	        list.delete(35);
	        Assert.assertEquals(list.search(35), false);
	    }
	    @Test
	    public void testMerge() {
	        LinkedList list1 = new LinkedList(new int[]{1,3,5});
	        LinkedList list2 = new LinkedList(new int[]{2,4,6});
	        list1.merge(list2);
	        ArrayList list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }

	        list1 = new LinkedList(new int[]{2,4,6});
	        list2 = new LinkedList(new int[]{1,3,5});
	        list1.merge(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }


	        list1 = new LinkedList(new int[]{});
	        list2 = new LinkedList(new int[]{1, 2, 3, 4, 5, 6});
	        list1.merge(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }

	        list2 = new LinkedList(new int[]{});
	        list1 = new LinkedList(new int[]{1, 2, 3, 4, 5, 6});
	        list1.merge(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }


	        list2 = new LinkedList(new int[]{3});
	        list1 = new LinkedList(new int[]{1, 2, 4, 5, 6});
	        list1.merge(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }

	        list1 = new LinkedList(new int[]{3});
	        list2 = new LinkedList(new int[]{1, 2, 4, 5, 6});
	        list1.merge(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }

	        list1 = new LinkedList(new int[]{3, 5});
	        list2 = new LinkedList(new int[]{1, 2, 4, 6});
	        list1.merge(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }

	        list2 = new LinkedList(new int[]{3, 5});
	        list1 = new LinkedList(new int[]{1, 2, 4, 6});
	        list1.merge(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }
	    }


	    @Test
	    public void testMergeRecursive() {
	        LinkedList list1 = new LinkedList(new int[]{1,3,5});
	        LinkedList list2 = new LinkedList(new int[]{2,4,6});
	        list1.mergeRecursive(list2);
	        ArrayList list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }

	        list1 = new LinkedList(new int[]{2,4,6});
	        list2 = new LinkedList(new int[]{1,3,5});
	        list1.mergeRecursive(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }


	        list1 = new LinkedList(new int[]{});
	        list2 = new LinkedList(new int[]{1, 2, 3, 4, 5, 6});
	        list1.mergeRecursive(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }

	        list2 = new LinkedList(new int[]{});
	        list1 = new LinkedList(new int[]{1, 2, 3, 4, 5, 6});
	        list1.mergeRecursive(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }


	        list2 = new LinkedList(new int[]{3});
	        list1 = new LinkedList(new int[]{1, 2, 4, 5, 6});
	        list1.mergeRecursive(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }

	        list1 = new LinkedList(new int[]{3});
	        list2 = new LinkedList(new int[]{1, 2, 4, 5, 6});
	        list1.mergeRecursive(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }

	        list1 = new LinkedList(new int[]{3, 5});
	        list2 = new LinkedList(new int[]{1, 2, 4, 6});
	        list1.mergeRecursive(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }

	        list2 = new LinkedList(new int[]{3, 5});
	        list1 = new LinkedList(new int[]{1, 2, 4, 6});
	        list1.mergeRecursive(list2);
	        list = list1.getAllElements();
	        for(int i=0;i<list.size();i++) {
	            Assert.assertEquals(list.get(i), i+1);
	        }
	    }
}
