package com.lyb.linkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: pz
 * Date: 2021/7/12
 * Time: 22:45
 * Description: No Description
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(4, "林冲s", "豹子头s");

        SingleLinkedList list = new SingleLinkedList();


//        list.add(hero1);
//        list.add(hero2);
//        list.add(hero3);
//        list.add(hero4);

        list.addByOrder(hero4);
        list.addByOrder(hero2);
        list.addByOrder(hero1);
        list.addByOrder(hero3);

//        list.update(hero5);

        list.delete(1);
//        list.delete(2);
//        list.delete(3);
//        list.delete(4);

        list.show();
    }
}

class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助指针temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到，将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向链表最后
        //将最后这个节点next指向新的节点
        temp.next = heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的temp 是位于 添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;// flag标志添加的编号是否存在，默认为false
        while (true) {
            //说明temp已经在链表的最后
            if (temp.next == null) {
                break;
            }
            //说明希望添加的heroNode的编号已然存在
            if (temp.next.no == heroNode.no) {
                flag = true;//说明编号存在
                break;
            }
            //位置找到，就在temp的后面插入
            if (temp.next.no > heroNode.no) {
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }

        if (flag) {
            System.out.println("准备插入的英雄的编号" + heroNode.no + "已经存在了, 不能加入");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息, 根据no编号来修改，即no编号不能改.
    //说明
    //1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode newHeroNode) {
        //判断是否空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点, 根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("没有找到编号"+ newHeroNode.no +"的节点，不能修改");

        }
    }
    //删除节点
    //思路
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;//标识是否找到待删除的节点
        while (true){
            ////已经到链表的最后
            if (temp.next == null){
                System.out.println("链表为空");
                break;
            }
            if (temp.next.no == no){
                //找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("要删除的节点不存在");
        }
    }

    public void show() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助指针temp
        HeroNode temp = head.next;
        while (true) {
            //判断是否链表为空
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
}


class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
    //为了显示方法，我们重新toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
