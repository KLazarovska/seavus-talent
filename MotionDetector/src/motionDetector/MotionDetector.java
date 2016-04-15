package motionDetector;

import java.util.LinkedList;
import java.util.Scanner;

import alarm.AlarmChannels;
import alarm.Alarm;
import imageDevics.Camera;
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
			if(count == 0){
				System.out.println("image 1");
				String image1 = device.getImage();
				System.out.println("image 2");
				String image2 = device.getImage();
				
				if (!image1.trim().isEmpty() && !image2.trim().isEmpty()){
					images.add(image1);
					images.add(image2);
					count += 2;
					
					if(!image1.equals(image2)){
						alarm.startAlarm();
					}
				}
				else
				{
					System.out.println("one of the inputs is null");
					break;
				}
				
			}
			else{
				System.out.println("image");
				String image = device.getImage();
				System.out.println(image);
				if(!image.trim().isEmpty()){
					if(images.getLast().equals(image))
					{
						images.add(image);
						count++;
					}
					else
					{
						alarm.startAlarm();
						images.add(image);
						count++;
					}
				}
				else{
					System.out.println("the input is null");
					break;
				}
				
			}

			
		}
		
		
	}

}
