package com.graduation.treeTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TreeTestServiceImpl implements TreeTestService {
    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List getTreeData() {
        List<TreeModel> listTree = treeMapper.getData();
        List dataList =getTree(listTree);
        return dataList;
    }

    public List getTree(List<TreeModel> listTree) {
        List list = new ArrayList<>();
        for (TreeModel entry: listTree) {
            Map<String,Object> mapArr = new HashMap<>();
            if(entry.getFather().equals("")){ //判断是否为父级
                mapArr.put("id", entry.getId());
                mapArr.put("title", entry.getMc());
                mapArr.put("children", menuChild(entry.getId(),listTree));  //去子集查找遍历
                list.add(mapArr);
                return list;
            }
        }
        return list;
    }
    /**
     *  hhl 递归树
     * @param id
     * @param list
     * @return
     */
    public static List<TreeModel> menuChild(String id, List<TreeModel> list){ //子集查找遍历
        List lists = new ArrayList<>();
        for(TreeModel entry: list){
            Map<String,Object> childArray = new HashMap<>();
            if(entry.getFather().equals(id) ){
                childArray.put("id", entry.getId());
                childArray.put("title", entry.getMc());
                childArray.put("children", menuChild(entry.getId(),list));
                lists.add(childArray);
            }
        }
        return lists;
    }

}
