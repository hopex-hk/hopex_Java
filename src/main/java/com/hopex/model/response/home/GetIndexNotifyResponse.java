package com.hopex.model.response.home;

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
public class GetIndexNotifyResponse {
    /// <summary>
    /// id
    /// </summary>
    public int Id;

    /// <summary>
    /// 标题
    /// </summary>
    public String Title;

    /// <summary>
    /// 跳转链接
    /// </summary>
    public String Link;

    /// <summary>
    /// 详细时间
    /// </summary>
    public String LastModifiedTime;

    /// <summary>
    /// 时间
    /// </summary>
    public String Time;

    /// <summary>
    /// 时间戳（秒）
    /// </summary>
    public long Timestamp;
}
