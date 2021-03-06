package com.yangg.spring.model;

public class GoodInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_goods_info.fid
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    private Integer fid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_goods_info.GOOD_CODE
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    private String goodCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_goods_info.AMOUNT
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    private Long amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_goods_info.SINGLE_AMOUNT
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    private Long singleAmount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_goods_info.fid
     *
     * @return the value of tb_goods_info.fid
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public Integer getFid() {
        return fid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_goods_info.fid
     *
     * @param fid the value for tb_goods_info.fid
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public void setFid(Integer fid) {
        this.fid = fid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_goods_info.GOOD_CODE
     *
     * @return the value of tb_goods_info.GOOD_CODE
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public String getGoodCode() {
        return goodCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_goods_info.GOOD_CODE
     *
     * @param goodCode the value for tb_goods_info.GOOD_CODE
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_goods_info.AMOUNT
     *
     * @return the value of tb_goods_info.AMOUNT
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_goods_info.AMOUNT
     *
     * @param amount the value for tb_goods_info.AMOUNT
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_goods_info.SINGLE_AMOUNT
     *
     * @return the value of tb_goods_info.SINGLE_AMOUNT
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public Long getSingleAmount() {
        return singleAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_goods_info.SINGLE_AMOUNT
     *
     * @param singleAmount the value for tb_goods_info.SINGLE_AMOUNT
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public void setSingleAmount(Long singleAmount) {
        this.singleAmount = singleAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_goods_info
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", goodCode=").append(goodCode);
        sb.append(", amount=").append(amount);
        sb.append(", singleAmount=").append(singleAmount);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_goods_info
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        GoodInfo other = (GoodInfo) that;
        return (this.getFid() == null ? other.getFid() == null : this.getFid().equals(other.getFid()))
            && (this.getGoodCode() == null ? other.getGoodCode() == null : this.getGoodCode().equals(other.getGoodCode()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getSingleAmount() == null ? other.getSingleAmount() == null : this.getSingleAmount().equals(other.getSingleAmount()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_goods_info
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFid() == null) ? 0 : getFid().hashCode());
        result = prime * result + ((getGoodCode() == null) ? 0 : getGoodCode().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getSingleAmount() == null) ? 0 : getSingleAmount().hashCode());
        return result;
    }
}