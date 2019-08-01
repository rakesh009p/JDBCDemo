package com.stackroute;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        JdbcDemo jdbcDemo= new JdbcDemo();
        jdbcDemo.displayUser();
        jdbcDemo.getUserByName("rakesh");
        RowSetDemo rowSetDemo=new RowSetDemo();
        rowSetDemo.rows();

}
}
