package com.acme.adapters;

import com.acme.interfaces.ThermometerInterface;
import com.ventoelectrics.waterheater.VentoThermometer;

public class ThermometerAdapter implements ThermometerInterface{
	
	VentoThermometer ventoThermometer;
	
	public ThermometerAdapter(VentoThermometer ventoThermometer){
		this.ventoThermometer = ventoThermometer;
	}
	
	public Integer getTemperature(){
		return ventoThermometer.getTemperature();
	}
}
