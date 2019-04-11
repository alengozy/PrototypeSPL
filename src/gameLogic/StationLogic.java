package gameLogic;

import java.util.*;

/**
 * This class implements the logic of passengers embarking and
 *  disembarking depending on the colors of the train and the station. 
 */
class StationLogic implements CellLogic {
	
	/**
	 * This attribute stores the boolean flag to identify the FinalStation.
	 */
	private boolean finalReportFlag = false;

	
	 /**
     * This attribute stores the station to which the logic belongs.
     */
    private Station parentStation;

    /**
     * This constructor assigns the given station as the parent station.
     */
    public StationLogic(Station parentStation) {
    	this.parentStation = parentStation;
    }

   

    /**
     * This method executes the corresponding logic.
     */
    @Override
    public boolean LogicRequest(Car car) {
    	System.out.print("\t>LogicRequest(Car car): allows people to disembark the train\n");
    	if(car.IsLocomotive()) {
    		Colors colors[] = parentStation.GetColors();
    		if(car.CurrentlyAtTheStation(colors)) {
    			System.out.print("\t<LogicRequest(Car car): Permission to leave the station.\n");
    			return false;
    		}else {
    			if(parentStation.IsFinal()) {
    				if(!finalReportFlag) {
    					finalReportFlag = true;
    					LevelContainer.FinalReport(car);
    				}
    		    	System.out.print("\t<LogicRequest(Car car): Permission to leave the station.\n");
    				return false;
    			}
    			System.out.print("\t<LogicRequest(Car car): Permission to leave the station.\n");
    			return true;
    		}
    		
    	}
    	System.out.print("\t<LogicRequest(Car car): Permission to leave the station.\n");
    	return true;
    }


}