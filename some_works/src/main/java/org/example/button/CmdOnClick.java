package org.example.button;

public class CmdOnClick implements IButtonClick
{
    @Override
    public void onClick() {
        System.out.println("CmsOnClick");
        System.out.println(this.toString());
    }
}
