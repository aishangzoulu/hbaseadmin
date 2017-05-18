package cn.edu.muc.ilab.hbaseadmin.model;

import java.util.List;

/**
 * Created by DBW on 2017/5/4.
 * 用于将List的内容转换为Json格式
 * 要求为List<? super String>格式的List
 */
public class ListModel {

    private String[] mList;

    public ListModel(){}

    public ListModel(List<String> list){

        mList = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {

            mList[i] = list.get(i);

        }

    }


    public String[] getList() {
        return mList;
    }

    public void setList(String[] list) {

        mList = list;

    }
}
