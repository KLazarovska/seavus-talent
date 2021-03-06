package com.ventoelectrics.waterheater;

import com.acme.adapters.PowerDeviceAdapter;
import com.acme.adapters.ThermometerAdapter;
import com.acme.adapters.ThermoregulatorAdapter;
import com.acme.thermoregulator.EfficientThermoregulator;

public class EfficientVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();

		final VentoThermoregulator ventoThermoregulator = new ThermoregulatorAdapter(new EfficientThermoregulator(new ThermometerAdapter(ventoThermometer), new PowerDeviceAdapter(ventoHeater)));
		
		ventoPowerSwitch.controlPowerFor(ventoThermoregulator);
		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);

		VentoWaterHeaterApp.run(ventoThermoregulator, ventoPowerSwitch);
	}
}
