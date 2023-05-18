package com.gxu.bsdn.param;

import lombok.Data;

@Data
public class ArticleParam {
    private String author;
    private String title;
    private String category;
    private int pageNumber;
    private int pageSize;
}
