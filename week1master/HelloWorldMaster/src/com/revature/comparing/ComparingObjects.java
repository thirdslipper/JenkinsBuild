package com.revature.comparing;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import com.revature.beans.Bean;

public class ComparingObjects {
	public static void main(String[] args) {
		TreeSet<Bean> beanTree = new TreeSet<Bean>();
		beanTree.add(new Bean("pinto", "tan", 10, .5f, true));
		beanTree.add(new Bean("pinto", "tan", 5, .2f, false));
		beanTree.add(new Bean("pinto", "tan", 4, .4f, true));
		beanTree.add(new Bean("pinto", "tan", 4, .4f, false));
		beanTree.add(new Bean("black-eye", "brown", 10, .5f, true));
		beanTree.add(new Bean("pinto", "tan", 4, 3f, false));
		System.out.println(beanTree);
		
		BeanComparator bc = new BeanComparator();
		Set<Bean> comparatorBeanTree = new TreeSet<Bean>(bc);
		comparatorBeanTree.addAll(beanTree);
		System.out.println(comparatorBeanTree);
		
		Comparator<Bean> beanComparator = (b1, b2) -> {
			if(b1.getMass() == b2.getMass())
				return b1.compareTo(b2);
			return (b1.getMass() > b2.getMass()) ? -1: 1;
		};
		comparatorBeanTree = new TreeSet<Bean>(beanComparator);
		comparatorBeanTree.addAll(beanTree);
		System.out.println(comparatorBeanTree);
	}
}
