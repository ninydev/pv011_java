package org.example.button;

public abstract class CmdBase implements IButtonClick
{
    @Override
    public void onClick() {
        System.out.println(this.toString());
    }

    // @Override
    public void onDoubleClick() {
        System.out.println(this.toString());
    }
}
