package alarm;

public class Alarm implements AlarmChannels{

	@Override
	public void startAlarm() {
		System.out.println("alarm.start");
	}

}
