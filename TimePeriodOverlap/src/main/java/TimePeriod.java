import java.time.LocalTime;

public class TimePeriod {
	
	private LocalTime startDate;
	private LocalTime endDate;
	
	public TimePeriod(LocalTime startDate, LocalTime endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public TimePeriod() {
	}

	public LocalTime getStartDate(){
		return startDate;
	}
	
	public LocalTime getEndDate(){
		return endDate;
	}
	
	public boolean overlapsWith(TimePeriod timePeriod){
		try{
			if(startDate.isBefore(timePeriod.getEndDate()) && endDate.isAfter(timePeriod.getStartDate())){
				return true;
			}
		}catch(Exception e){
			throw new IllegalArgumentException("invalid input");
		}
		
		return false;
	}
}
