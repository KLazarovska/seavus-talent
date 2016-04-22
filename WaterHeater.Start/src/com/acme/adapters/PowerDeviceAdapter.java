package com.acme.adapters;

import com.acme.interfaces.PowerDeviceInterface;
import com.ventoelectrics.waterheater.VentoHeater;

public class PowerDeviceAdapter implements PowerDeviceInterface{

	VentoHeater ventoHeater;
	
	public PowerDeviceAdapter(VentoHeater ventoHeater){
		this.ventoHeater = ventoHeater;
	}
	@Override
	public void enablePower() {
		ventoHeater.enablePower();
	}

	@Override
	public void disablePower() {
		ventoHeater.disablePower();
	}

}
