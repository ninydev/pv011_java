package org.example.button;

public class Button {

    final  IButtonClick clickDelegate;
    public Button(IButtonClick click) {
        clickDelegate = click;
    }

    public void onClick() {
        this.clickDelegate.onClick();
    }
}
