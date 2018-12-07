/**
 * 
 */
package com.jpm.collections.list;

import java.util.Comparator;

import com.jpm.collections.entities.Employee;

/**
 * @author Swati
 *
 */
public class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getEmpName().compareTo(o2.getEmpName());
	}

}
