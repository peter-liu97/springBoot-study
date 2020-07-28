package com.peter.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="BIS_MULTI")
public class BisMulti {
    /** 
     * BIS_MULTI.BIS_MULTI_ID
     */
    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="BIS_MULTI_ID")
    private String bisMultiId;

    /** 
     * BIS_MULTI.BIS_PROJECT_ID
     */
    @Column(name="BIS_PROJECT_ID")
    private String bisProjectId;

    /** 
     * BIS_MULTI.BIS_CONT_ID
     */
    @Column(name="BIS_CONT_ID")
    private String bisContId;

    /** 
     * BIS_MULTI.MULTI_NAME
     */
    @Column(name="MULTI_NAME")
    private String multiName;

    /** 
     * BIS_MULTI.RENTER_NAME
     */
    @Column(name="RENTER_NAME")
    private String renterName;

    /** 
     * BIS_MULTI.OPERATION_PROJECT_CD
     */
    @Column(name="OPERATION_PROJECT_CD")
    private String operationProjectCd;

    /** 
     * BIS_MULTI.OPERATION_AREA
     */
    @Column(name="OPERATION_AREA")
    private String operationArea;

    /** 
     * BIS_MULTI.SQUARE
     */
    @Column(name="SQUARE")
    private BigDecimal square;

    /** 
     * BIS_MULTI.CONT_PROMISE_BOND
     */
    @Column(name="CONT_PROMISE_BOND")
    private BigDecimal contPromiseBond;

    /** 
     * BIS_MULTI.RECEIVED_BOND
     */
    @Column(name="RECEIVED_BOND")
    private BigDecimal receivedBond;

    /** 
     * BIS_MULTI.REMARK
     */
    @Column(name="REMARK")
    private String remark;

    /** 
     * BIS_MULTI.CREATOR
     */
    @Column(name="CREATOR")
    private String creator;

    /** 
     * BIS_MULTI.CREATED_CENTER_CD
     */
    @Column(name="CREATED_CENTER_CD")
    private String createdCenterCd;

    /** 
     * BIS_MULTI.CREATED_DEPT_CD
     */
    @Column(name="CREATED_DEPT_CD")
    private String createdDeptCd;

    /** 
     * BIS_MULTI.CREATED_POSITION_CD
     */
    @Column(name="CREATED_POSITION_CD")
    private String createdPositionCd;

    /** 
     * BIS_MULTI.CREATED_DATE
     */
    @Column(name="CREATED_DATE")
    private Date createdDate;

    /** 
     * BIS_MULTI.UPDATOR
     */
    @Column(name="UPDATOR")
    private String updator;

    /** 
     * BIS_MULTI.UPDATED_CENTER_CD
     */
    @Column(name="UPDATED_CENTER_CD")
    private String updatedCenterCd;

    /** 
     * BIS_MULTI.UPDATED_DEPT_CD
     */
    @Column(name="UPDATED_DEPT_CD")
    private String updatedDeptCd;

    /** 
     * BIS_MULTI.UPDATED_POSITION_CD
     */
    @Column(name="UPDATED_POSITION_CD")
    private String updatedPositionCd;

    /** 
     * BIS_MULTI.UPDATED_DATE
     */
    @Column(name="UPDATED_DATE")
    private Date updatedDate;

    /** 
     * BIS_MULTI.RECORD_VERSION
     */
    @Column(name="RECORD_VERSION")
    private Long recordVersion;

    /** 
     * BIS_MULTI.MULTI_NO
     */
    @Column(name="MULTI_NO")
    private String multiNo;

    /** 
     * BIS_MULTI.MULTI_TYPE
     */
    @Column(name="MULTI_TYPE")
    private String multiType;

    /** 
     * BIS_MULTI.MULTI_FLOOR
     */
    @Column(name="MULTI_FLOOR")
    private String multiFloor;

    /** 
     * BIS_MULTI.MULTI_GRADE
     */
    @Column(name="MULTI_GRADE")
    private String multiGrade;

    /** 
     * BIS_MULTI.MULTI_PRICE
     * 平日租金标准
     */
    @Column(name="MULTI_PRICE")
    private String multiPrice;

    /** 
     * BIS_MULTI.MULTI_POLICY
     */
    @Column(name="MULTI_POLICY")
    private String multiPolicy;

    /** 
     * BIS_MULTI.COORDS
     */
    @Column(name="COORDS")
    private String coords;

    /** 
     * BIS_MULTI.BIS_FLOOR_ID
     */
    @Column(name="BIS_FLOOR_ID")
    private String bisFloorId;

    /** 
     * BIS_MULTI.IN_OR_OUTER
     */
    @Column(name="IN_OR_OUTER")
    private String inOrOuter;

    /** 
     * BIS_MULTI.MULTI_FLAT
     */
    @Column(name="MULTI_FLAT")
    private BigDecimal multiFlat;

    /** 
     * BIS_MULTI.MULTI_FEE
     */
    @Column(name="MULTI_FEE")
    private BigDecimal multiFee;

    /** 
     * BIS_MULTI.MULTI_CHARGE_TYPE
     */
    @Column(name="MULTI_CHARGE_TYPE")
    private String multiChargeType;

    /** 
     * BIS_MULTI.MULTI_OPEN_DATE
     */
    @Column(name="MULTI_OPEN_DATE")
    private Date multiOpenDate;

    /** 
     * BIS_MULTI.MULTI_END_DATE
     */
    @Column(name="MULTI_END_DATE")
    private Date multiEndDate;

    /** 
     * BIS_MULTI.MULTI_CONT_LIMIT
     */
    @Column(name="MULTI_CONT_LIMIT")
    private String multiContLimit;

    /** 
     * BIS_MULTI.MULTI_PROP_TYPE
     */
    @Column(name="MULTI_PROP_TYPE")
    private String multiPropType;

    /** 
     * BIS_MULTI.OPERATION_AREA2
     */
    @Column(name="OPERATION_AREA2")
    private String operationArea2;

    /** 
     * BIS_MULTI.COORDS2
     */
    @Column(name="COORDS2")
    private String coords2;

    /** 
     * BIS_MULTI.MAX_AREA
     */
    @Column(name="MAX_AREA")
    private String maxArea;

    /** 
     * BIS_MULTI.LENGTH
     */
    @Column(name="LENGTH")
    private String length;

    /** 
     * BIS_MULTI.WIDTH
     */
    @Column(name="WIDTH")
    private String width;

    /** 
     * BIS_MULTI.HIGTH
     */
    @Column(name="HIGTH")
    private String higth;

    /** 
     * BIS_MULTI.POINTEMPTYSTATERENDER_DIAGRAM
     */
    @Column(name="POINTEMPTYSTATERENDER_DIAGRAM")
    private String pointemptystaterenderDiagram;

    /** 
     * BIS_MULTI.COORDS_CIRC
     */
    @Column(name="COORDS_CIRC")
    private String coordsCirc;

    /** 
     * BIS_MULTI.CHARGE_TYPE
     * 多经业态
     */
    @Column(name="CHARGE_TYPE")
    private String chargeType;

    /** 
     * BIS_MULTI.MULTI_PRICE_WEEKEND
     * 周末租金标准
     */
    @Column(name="MULTI_PRICE_WEEKEND")
    private String multiPriceWeekend;

    /** 
     * BIS_MULTI.MULTI_PRICE_HOLIDAYS
     * 节假日租金标准
     */
    @Column(name="MULTI_PRICE_HOLIDAYS")
    private String multiPriceHolidays;

    public String getBisMultiId() {
        return bisMultiId;
    }

    public void setBisMultiId(String bisMultiId) {
        this.bisMultiId = bisMultiId;
    }

    public String getBisProjectId() {
        return bisProjectId;
    }

    public void setBisProjectId(String bisProjectId) {
        this.bisProjectId = bisProjectId;
    }

    public String getBisContId() {
        return bisContId;
    }

    public void setBisContId(String bisContId) {
        this.bisContId = bisContId;
    }

    public String getMultiName() {
        return multiName;
    }

    public void setMultiName(String multiName) {
        this.multiName = multiName;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public String getOperationProjectCd() {
        return operationProjectCd;
    }

    public void setOperationProjectCd(String operationProjectCd) {
        this.operationProjectCd = operationProjectCd;
    }

    public String getOperationArea() {
        return operationArea;
    }

    public void setOperationArea(String operationArea) {
        this.operationArea = operationArea;
    }

    public BigDecimal getSquare() {
        return square;
    }

    public void setSquare(BigDecimal square) {
        this.square = square;
    }

    public BigDecimal getContPromiseBond() {
        return contPromiseBond;
    }

    public void setContPromiseBond(BigDecimal contPromiseBond) {
        this.contPromiseBond = contPromiseBond;
    }

    public BigDecimal getReceivedBond() {
        return receivedBond;
    }

    public void setReceivedBond(BigDecimal receivedBond) {
        this.receivedBond = receivedBond;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatedCenterCd() {
        return createdCenterCd;
    }

    public void setCreatedCenterCd(String createdCenterCd) {
        this.createdCenterCd = createdCenterCd;
    }

    public String getCreatedDeptCd() {
        return createdDeptCd;
    }

    public void setCreatedDeptCd(String createdDeptCd) {
        this.createdDeptCd = createdDeptCd;
    }

    public String getCreatedPositionCd() {
        return createdPositionCd;
    }

    public void setCreatedPositionCd(String createdPositionCd) {
        this.createdPositionCd = createdPositionCd;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public String getUpdatedCenterCd() {
        return updatedCenterCd;
    }

    public void setUpdatedCenterCd(String updatedCenterCd) {
        this.updatedCenterCd = updatedCenterCd;
    }

    public String getUpdatedDeptCd() {
        return updatedDeptCd;
    }

    public void setUpdatedDeptCd(String updatedDeptCd) {
        this.updatedDeptCd = updatedDeptCd;
    }

    public String getUpdatedPositionCd() {
        return updatedPositionCd;
    }

    public void setUpdatedPositionCd(String updatedPositionCd) {
        this.updatedPositionCd = updatedPositionCd;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getRecordVersion() {
        return recordVersion;
    }

    public void setRecordVersion(Long recordVersion) {
        this.recordVersion = recordVersion;
    }

    public String getMultiNo() {
        return multiNo;
    }

    public void setMultiNo(String multiNo) {
        this.multiNo = multiNo;
    }

    public String getMultiType() {
        return multiType;
    }

    public void setMultiType(String multiType) {
        this.multiType = multiType;
    }

    public String getMultiFloor() {
        return multiFloor;
    }

    public void setMultiFloor(String multiFloor) {
        this.multiFloor = multiFloor;
    }

    public String getMultiGrade() {
        return multiGrade;
    }

    public void setMultiGrade(String multiGrade) {
        this.multiGrade = multiGrade;
    }

    public String getMultiPrice() {
        return multiPrice;
    }

    public void setMultiPrice(String multiPrice) {
        this.multiPrice = multiPrice;
    }

    public String getMultiPolicy() {
        return multiPolicy;
    }

    public void setMultiPolicy(String multiPolicy) {
        this.multiPolicy = multiPolicy;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public String getBisFloorId() {
        return bisFloorId;
    }

    public void setBisFloorId(String bisFloorId) {
        this.bisFloorId = bisFloorId;
    }

    public String getInOrOuter() {
        return inOrOuter;
    }

    public void setInOrOuter(String inOrOuter) {
        this.inOrOuter = inOrOuter;
    }

    public BigDecimal getMultiFlat() {
        return multiFlat;
    }

    public void setMultiFlat(BigDecimal multiFlat) {
        this.multiFlat = multiFlat;
    }

    public BigDecimal getMultiFee() {
        return multiFee;
    }

    public void setMultiFee(BigDecimal multiFee) {
        this.multiFee = multiFee;
    }

    public String getMultiChargeType() {
        return multiChargeType;
    }

    public void setMultiChargeType(String multiChargeType) {
        this.multiChargeType = multiChargeType;
    }

    public Date getMultiOpenDate() {
        return multiOpenDate;
    }

    public void setMultiOpenDate(Date multiOpenDate) {
        this.multiOpenDate = multiOpenDate;
    }

    public Date getMultiEndDate() {
        return multiEndDate;
    }

    public void setMultiEndDate(Date multiEndDate) {
        this.multiEndDate = multiEndDate;
    }

    public String getMultiContLimit() {
        return multiContLimit;
    }

    public void setMultiContLimit(String multiContLimit) {
        this.multiContLimit = multiContLimit;
    }

    public String getMultiPropType() {
        return multiPropType;
    }

    public void setMultiPropType(String multiPropType) {
        this.multiPropType = multiPropType;
    }

    public String getOperationArea2() {
        return operationArea2;
    }

    public void setOperationArea2(String operationArea2) {
        this.operationArea2 = operationArea2;
    }

    public String getCoords2() {
        return coords2;
    }

    public void setCoords2(String coords2) {
        this.coords2 = coords2;
    }

    public String getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(String maxArea) {
        this.maxArea = maxArea;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHigth() {
        return higth;
    }

    public void setHigth(String higth) {
        this.higth = higth;
    }

    public String getPointemptystaterenderDiagram() {
        return pointemptystaterenderDiagram;
    }

    public void setPointemptystaterenderDiagram(String pointemptystaterenderDiagram) {
        this.pointemptystaterenderDiagram = pointemptystaterenderDiagram;
    }

    public String getCoordsCirc() {
        return coordsCirc;
    }

    public void setCoordsCirc(String coordsCirc) {
        this.coordsCirc = coordsCirc;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getMultiPriceWeekend() {
        return multiPriceWeekend;
    }

    public void setMultiPriceWeekend(String multiPriceWeekend) {
        this.multiPriceWeekend = multiPriceWeekend;
    }

    public String getMultiPriceHolidays() {
        return multiPriceHolidays;
    }

    public void setMultiPriceHolidays(String multiPriceHolidays) {
        this.multiPriceHolidays = multiPriceHolidays;
    }
}