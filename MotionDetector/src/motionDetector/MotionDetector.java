package motionDetector;

import java.util.LinkedList;
import java.util.Scanner;

import alarm.AlarmChannels;
import imageDevics.ImageCapturingDevice;

public class MotionDetector{

	ImageCapturingDevice device;
	AlarmChannels alarm;
	
	public MotionDetector(ImageCapturingDevice device, AlarmChannels alarm){
		this.device = device;
		this.alarm = alarm;
	}
	
	public void run(){
		LinkedList<String> images = new LinkedList<String>();
		int count = 0;
		
		while(true){
			Scanner in = new Scanner(System.in);
			String image = device.getImage();

			images.add(image);
			
			if(image.trim().isEmpty()){
				System.out.println("the input is null - exit");
				return;
			}

			if(count == 0){
				images.add(device.getImage());
				if(images.getLast().trim().isEmpty()){
					System.out.println("the input is null - exit");
					return;
				}
				count ++;
			}
			
			compareImages(images.getLast(), images.get(images.size() - 2));
		}
		
	}
	
	public boolean compareImages(String image1, String image2){
		if(!image1.equals(image2)){
			alarm.startAlarm();
		}
		return true;
	}

}
