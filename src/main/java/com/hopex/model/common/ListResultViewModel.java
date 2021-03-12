package com.hopex.model.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ListResultViewModel<T> {
    public int TotalCount;
    public int Page;
    public int PageSize;
    public List<T> Result;
}
