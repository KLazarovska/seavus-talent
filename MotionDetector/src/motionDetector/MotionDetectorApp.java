package motionDetector;

import alarm.AlarmChannels;
import alarm.Alarm;
import imageDevics.Camera;
import imageDevics.ImageCapturingDevice;

public class MotionDetectorApp {

	public static void main(String[] args) {
		AlarmChannels alarm = new Alarm();
		ImageCapturingDevice device = new Camera();	
		MotionDetector md = new MotionDetector(device, alarm);
		
		md.run();

	}

}
