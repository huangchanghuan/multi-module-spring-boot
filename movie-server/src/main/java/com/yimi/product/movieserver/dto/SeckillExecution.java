package com.yimi.product.movieserver.dto;


import com.yimi.product.movieserver.entity.SuccessKilled;
import com.yimi.product.movieserver.enums.SeckillStatEnum;

/**
 * 封装秒杀后的执行结果
 *
 * @author Peter  2016-9-2下午1:28:50
 */
public class SeckillExecution {

    private long seckillId;

    //秒杀执行的结果状态
    private int state;

    //秒杀状态描述
    private String stateInfo;

    //秒杀成功对象
    private SuccessKilled successKilled;


    @Override
    public String toString() {
        return "SeckillExecution [seckillId=" + seckillId + ", state=" + state
                + ", stateInfo=" + stateInfo + ", successKilled="
                + successKilled + "]";
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum,
                            SuccessKilled successKilled) {
        super();
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
        super();
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }


}
