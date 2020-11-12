package com.review.entity;

/**
 * @Author: Guo
 * @Date: 2020/11/12 14:07
 * @Name: java_demo_review
 * explain：抽象方法实现化
 */
public class Demo02 extends AbstractDemo {
    private double salary; //Annual salary
    public Demo02(String name, String address, int number, double
            salary)
    {
        super(name, address, number);
        setSalary(salary);
    }
    @Override
    public void mailCheck()
    {
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName()
                + " with salary " + salary);
    }
    public double getSalary()
    {
        return salary;
    }
    public void setSalary(double newSalary)
    {
        if(newSalary >= 0.0)
        {
            salary = newSalary;
        }
    }
    @Override
    public double computePay()
    {
        System.out.println("Computing salary pay for " + getName());
        return salary/52;
    }
}
