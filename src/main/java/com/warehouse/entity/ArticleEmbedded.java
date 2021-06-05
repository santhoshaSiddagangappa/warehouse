package com.warehouse.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ArticleEmbedded {

    @NotNull
    private Long art_id;

    @JsonProperty("amount_of")
    private int stock;
}
