/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Child;

import java.util.Date;

/**
 *
 * @author jaspr
 */
public class ChildVitalSigns {
    
    private int BP;
    private int pulseRate;
    private int respirationRate;
    private double bodytemp;
    private double weight;
    
    private boolean isBpNormal;
    private boolean ispulserateNormal;
    private boolean isBreathingRateNorma;
    private boolean istempNormal;
    private boolean isWeightNormal;
    
    private Date VitalSignsDate;
    
    private boolean isVitalSignsNormal;
    
    public ChildVitalSigns(){
        
    }

    public int getBP() {
        return BP;
    }

    public void setBP(int BP) {
        this.BP = BP;
    }

    public int getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(int pulseRate) {
        this.pulseRate = pulseRate;
    }

    public int getRespirationRate() {
        return respirationRate;
    }

    public void setRespirationRate(int respirationRate) {
        this.respirationRate = respirationRate;
    }

    public double getBodytemp() {
        return bodytemp;
    }

    public void setBodytemp(double bodytemp) {
        this.bodytemp = bodytemp;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isIsBpNormal() {
        return isBpNormal;
    }

    public void setIsBpNormal(boolean isBpNormal) {
        this.isBpNormal = isBpNormal;
    }

    public boolean isIspulserateNormal() {
        return ispulserateNormal;
    }

    public void setIspulserateNormal(boolean ispulserateNormal) {
        this.ispulserateNormal = ispulserateNormal;
    }

    public boolean isIsBreathingRateNorma() {
        return isBreathingRateNorma;
    }

    public void setIsBreathingRateNorma(boolean isBreathingRateNorma) {
        this.isBreathingRateNorma = isBreathingRateNorma;
    }

    public boolean isIstempNormal() {
        return istempNormal;
    }

    public void setIstempNormal(boolean istempNormal) {
        this.istempNormal = istempNormal;
    }

    public boolean isIsWeightNormal() {
        return isWeightNormal;
    }

    public void setIsWeightNormal(boolean isWeightNormal) {
        this.isWeightNormal = isWeightNormal;
    }

    public Date getVitalSignsDate() {
        return VitalSignsDate;
    }

    public void setVitalSignsDate(Date VitalSignsDate) {
        this.VitalSignsDate = VitalSignsDate;
    }

    public boolean isIsVitalSignsNormal() {
        return isVitalSignsNormal;
    }

    public void setIsVitalSignsNormal(boolean isVitalSignsNormal) {
        this.isVitalSignsNormal = isVitalSignsNormal;
    }
    
    
    
}
