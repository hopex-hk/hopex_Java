package com.hopex.model.response.trade;

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
public class QueryConditionOrdersResponse {
    /// <summary>
    /// 条件单类型
    /// </summary>
    public int TaskType;

    /// <summary>
    /// 条件单类型-描述
    /// </summary>
    public String TaskTypeD;

    /// <summary>
    /// 条件单任务id
    /// </summary>
    public long TaskId;

    /// <summary>
    /// 合约编码
    /// </summary>
    public String ContractCode;

    /// <summary>
    /// 合约名称
    /// </summary>
    public String ContractName;

    /// <summary>
    /// 1.开仓 2:平仓
    /// </summary>
    public int Action;

    /// <summary>
    /// 1.多仓 2:空仓
    /// </summary>
    public int Direct;

    /// <summary>
    /// 1卖2买
    /// </summary>
    public int Side;

    /// <summary>
    /// 条件单任务当前状态，1:创建ok 2.已撤销 3.已触发委托成功 4.已触发委托失败'
    /// </summary>
    public int TaskStatus;

    /// <summary>
    /// 条件单任务当前状态-描述
    /// </summary>
    public String TaskStatusD;

    /// <summary>
    /// 触发类型
    /// </summary>
    public int TrigType;

    /// <summary>
    /// 触发类型-描述
    /// </summary>
    public String TrigTypeD;

    /// <summary>
    /// 触发价格
    /// </summary>
    public String TrigPrice;

    /// <summary>
    /// 期待数量
    /// </summary>
    public String ExpectedQuantity;

    /// <summary>
    /// 期待价格
    /// </summary>
    public String ExpectedPrice;

    /// <summary>
    /// 有效期
    /// </summary>
    public String ExpireTime;

    /// <summary>
    /// 委托时间-时间戳-微秒
    /// </summary>
    public double Timestamp;

    /// <summary>
    /// 委托时间
    /// </summary>
    public String CreateTime;

    /// <summary>
    /// 委托ID
    /// </summary>
    public long OrderId;

    /// <summary>
    /// 订单里面的委托数量
    /// </summary>
    public String OrderQuantity;

    /// <summary>
    /// 订单里面的委托价格
    /// </summary>
    public String OrderPrice;

    /// <summary>
    /// 触发时间,精确到微秒
    /// </summary>
    public String FinishTime;

    /// <summary>
    /// 失败原因
    /// </summary>
    public String FailureReason;

    /// <summary>
    /// 杠杆倍数
    /// </summary>
    public String Leverage;
}
