package com.hopex.model.response.wallet;

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
public class GetUserWalletResponse {
    /// <summary>
    /// 概况
    /// </summary>
    public AllAssetSummaryViewModel Summary;

    /// <summary>
    /// 各个资产的概况
    /// </summary>
    public List<AssetSummaryViewModel> Detail;
}
