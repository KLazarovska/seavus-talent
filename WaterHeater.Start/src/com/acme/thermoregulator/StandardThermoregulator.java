package com.acme.thermoregulator;

import com.acme.adapters.ThermometerAdapter;
import com.acme.interfaces.PowerDeviceInterface;
import com.acme.interfaces.ThermoregulatorInterface;

public class StandardThermoregulator implements ThermoregulatorInterface{
	ThermometerAdapter adapter;
	PowerDeviceInterface device;
	Integer temperature = 0;
	boolean active = true;
	

	public StandardThermoregulator(ThermometerAdapter adapter, PowerDeviceInterface device) {
		this.adapter = adapter;
		this.device = device;
	}

	Thread StandardThermoregulatorThread = new Thread() {
		@Override
		public void run() {
			while (active) {
				try {
					Thread.sleep(3000);
					Integer currentTemperature = adapter.getTemperature();
					System.out.println("Current temperature " + currentTemperature);
					if (currentTemperature < temperature) {
						System.out.println("Enabled!");
						device.enablePower();
					} else if (currentTemperature > temperature) {
						System.out.println("Disabled!");
						device.disablePower();
					}
				} catch (Exception e) {}
			}
		}
	};
	
	@Override
	public void enableHeater() {
		StandardThermoregulatorThread.start();
	}


	@Override
	public void disableHeater() {
		active = false;
	}


	@Override
	public void setTemperature(Integer temperature) {
		this.temperature = temperature;
	}
}
