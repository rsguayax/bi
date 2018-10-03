/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;

/**
 *
 * @author utpl
 */
public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }
    
    public void test(){
        ArrayList a = new ArrayList();
        a.add("Select 1");
        a.add("select 2");
        String sql = String.join(";\n", a);
        System.out.println(sql);
    }
}
