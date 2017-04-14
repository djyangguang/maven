package com.yangg.spring.model;

public class OrderInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_info.id
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_info.name
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_info.stutas
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    private Integer stutas;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_order_info.amount
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    private String amount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_info.id
     *
     * @return the value of tb_order_info.id
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_info.id
     *
     * @param id the value for tb_order_info.id
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_info.name
     *
     * @return the value of tb_order_info.name
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_info.name
     *
     * @param name the value for tb_order_info.name
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_info.stutas
     *
     * @return the value of tb_order_info.stutas
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public Integer getStutas() {
        return stutas;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_info.stutas
     *
     * @param stutas the value for tb_order_info.stutas
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public void setStutas(Integer stutas) {
        this.stutas = stutas;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_order_info.amount
     *
     * @return the value of tb_order_info.amount
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public String getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_order_info.amount
     *
     * @param amount the value for tb_order_info.amount
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_info
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", stutas=").append(stutas);
        sb.append(", amount=").append(amount);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_info
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
        OrderInfo other = (OrderInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStutas() == null ? other.getStutas() == null : this.getStutas().equals(other.getStutas()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_order_info
     *
     * @mbggenerated Tue Feb 07 17:09:25 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStutas() == null) ? 0 : getStutas().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        return result;
    }
}