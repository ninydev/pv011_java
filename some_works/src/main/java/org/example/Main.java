package org.example;

import org.example.button.Button;
import org.example.button.CmdOnClick;
import org.example.button.IButtonClick;
import org.example.interfaces.IToStringConversion;

public class Main {
    public static void main(String[] args) {
        btn();

    }

    public static void btn() {

        String msg = "Hello Word";

        Button btnSave = new Button(new IButtonClick() {
            @Override
            public void onClick() {
                System.out.println("Save: => " + msg);
                System.out.println(this.toString());
            }
        });
        Button btnCancel = new Button(new IButtonClick() {
            @Override
            public void onClick() {
                System.out.println("Cancel");
                System.out.println(this.toString());
            }
        });

        Button btnCommand = new Button( new CmdOnClick());

        btnSave.onClick();
        System.out.println(btnSave.toString());

        btnCancel.onClick();
        System.out.println(btnCancel.toString());

        btnCommand.onClick();
        System.out.println(btnCommand.toString());
    }

    public static void ver() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Run");
                    }
                }
        ).start();
    }

    public static void r() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Run");
            }
        };

        Thread t = new Thread(r);
        t.start();
    }

    public static void in() {
        IToStringConversion i = new IToStringConversion() {
            @Override
            public String toString() {
                return super.toString();
            }
        };

        IToStringConversion i1 = new IToStringConversion() {
            @Override
            public String toString() {
                return super.toString();
            }
        };

        System.out.println("Class: " + i.getClass());
        System.out.println("To String: " + i);
        System.out.println(" + ---------------------------- +");
        System.out.println("Class: " + i1.getClass());
        System.out.println("To String: " + i1);
        System.out.println(" + ---------------------------- +");
    }
}