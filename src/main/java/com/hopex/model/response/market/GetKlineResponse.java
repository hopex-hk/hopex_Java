package com.hopex.model.response.market;

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
public class GetKlineResponse {

        /// <summary>
        /// 小数点位数
        /// </summary>
        public String Decimalplace;

        /// <summary>
        /// 数据
        /// </summary>
        public List<KLineItemViewModel> TimeData;
}
