/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xhu
 */
public class MemoManager<E extends Comparable> {
    
    public BinaryTree bTreeDate;
    public BinaryTree bTreeTitle;
    
    
    public void addMemo(String date, String title, String message)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Memo memo = new Memo();
        try {
            //converting a string to date
            memo.date = dateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(MemoManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addToTree(Memo memo, E key)
    {        
        
    }
    
    public Memo findMemo(E key)
    {
        return null;
    }
    
    public Memo[] getSortedMemoList(E key)
    {        
        return null;
    }
    
    public void reverseOrder()
    {
        
    }    
}
