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

    public BinaryTree<Memo, Date> bTreeDate;
    public BinaryTree<Memo, String> bTreeTitle;

    public void addMemo(String date, String title, String message) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Memo memo = new Memo();
        try {
            // converting a string to date
            memo.date = dateFormat.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(MemoManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        memo.title = title;
        memo.message = message;

        addToTree(memo, (E) memo.title);
        addToTree(memo, (E) memo.date);

    }

    public void addToTree(Memo memo, E key) {
        if (key instanceof Date) {
            if (bTreeDate == null) {
                bTreeDate = new BinaryTree<Memo, Date>();
            }

            bTreeDate.addElement(memo, memo.date);

        }

        if (key instanceof String) {
            if (bTreeTitle == null) {
                bTreeTitle = new BinaryTree<Memo, String>();
            }

            bTreeTitle.addElement(memo, memo.title);
        }
    }

    public Memo findMemo(E key) {
        if (key instanceof Date) {
            return bTreeDate.searchElement((Date) key);
        }
        if (key instanceof String) {
            return bTreeTitle.searchElement((String) key);
        }
        return null;
    }

    public Memo[] getSortedMemoList(E key) {

        if (key instanceof Date) {
            Node[] sortedNode = bTreeDate.toSortedList();
            Memo[] sortedMemo = new Memo[sortedNode.length];
            for (int index = 0; index < sortedMemo.length; index++) {
                sortedMemo[index] = (Memo) sortedNode[index].memo;
            }
            return sortedMemo;
        } else {
            Node[] sortedNode = bTreeTitle.toSortedList();
            Memo[] sortedMemo = new Memo[sortedNode.length];
            for (int index = 0; index < sortedMemo.length; index++) {
                sortedMemo[index] = (Memo) sortedNode[index].memo;
            }
            return sortedMemo;
        }
    }

    public void reverseOrder() {
        if (bTreeTitle != null) {
            bTreeTitle.reverseOrder();
        }
        if (bTreeDate != null) {
            bTreeDate.reverseOrder();
        }
    }
}
