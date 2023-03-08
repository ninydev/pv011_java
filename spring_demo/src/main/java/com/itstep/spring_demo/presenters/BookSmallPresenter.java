package com.itstep.spring_demo.presenters;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookSmallPresenter {
    private String name;
    private long num;
}
