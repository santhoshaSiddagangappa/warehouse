package com.warehouse.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class ProductDTO {

    @NotNull
    private String name;

    private Set<ArticleEmbededDTO> contain_articles = new HashSet<>();

}
