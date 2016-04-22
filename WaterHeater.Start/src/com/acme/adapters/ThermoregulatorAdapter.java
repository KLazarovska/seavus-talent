package com.acme.adapters;

import com.acme.interfaces.ThermoregulatorInterface;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class ThermoregulatorAdapter implements VentoThermoregulator{

	ThermoregulatorInterface thermoregulator;
	
	public ThermoregulatorAdapter(ThermoregulatorInterface termoregulator){
		this.thermoregulator = termoregulator;
	}
	
	@Override
	public void enablePower() {
		thermoregulator.enableHeater();
	}

	@Override
	public void disablePower() {
		thermoregulator.disableHeater();
	}

	@Override
	public void setTemperature(Integer temperature) {
		thermoregulator.setTemperature(temperature);
	}

}
