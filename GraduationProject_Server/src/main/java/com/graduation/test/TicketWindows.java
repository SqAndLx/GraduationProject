package com.graduation.test;
/**
 * Thread模拟叫号机程序
 */
public class TicketWindows extends Thread{
    /**
     * 柜台名称
     */
    private final String name;
    /**
     * 最大接号数
     */
    private static final int MAX = 50;
    /**
     * 起始叫号数
     */
    private static int index = 1;

    public  TicketWindows (String name){
        this.name = name;
    }

    @Override
    public void run(){
        while (index <= MAX){
            System.out.println("柜台：" + name + "当前号码是：" + (index++));
        }
    }

    public static void main(String[] args) {
        TicketWindows ticketWindows1 = new TicketWindows("一号出号机");
        ticketWindows1.start();
        TicketWindows ticketWindows2 = new TicketWindows("二号出号机");
        ticketWindows2.start();
        TicketWindows ticketWindows3 = new TicketWindows("三号出号机");
        ticketWindows3.start();
        TicketWindows ticketWindows4 = new TicketWindows("四号出号机");
        ticketWindows4.start();
    }
}
