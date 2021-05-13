package src;
import java.util.*;

    public class ClimbingClub { // Class including helper methods within the list.

        /** The list of climbs completed by members of the club.
         * Guaranteed not to be null. Contains only non-null references.
         */
        private List<ClimbInfo> climbList;

        /** Creates a new ClimbingClub object. - AP CB */
        public ClimbingClub(){
            climbList = new ArrayList<ClimbInfo>();
        }


 
        public void addClimbOne(String h, String peakName, String t) { // Adder method for the first conditions.
            ClimbInfo ci = new ClimbInfo(h, peakName,t);
            climbList.add(ci);
        }
        
        
        public ClimbInfo addClimbTwo(String h2, String peakName, String t2) { // 2nd Variation of adder method along with a few more conditions.
            for (int i = 0; i < climbList.size(); i++) {
                if (peakName.compareTo(climbList.get(i).getName()) <= 0) {
                    climbList.add(i, new ClimbInfo(h2, peakName, t2));
                    return new ClimbInfo(h2, peakName, t2);
                }
            }
            this.climbList.add(new ClimbInfo(h2, peakName, t2));
            return new ClimbInfo(h2, peakName, t2);
        }



        public void displayClimbList() { // Helper method to display current climb list.
            String a = "";
        	for(ClimbInfo ci: climbList){
               a += "Name:   " + " Location:   " + " Duration(Hours):" + "\n" + ci.getHName() + "        " + ci.getName() + "            " + ci.getTime() + "\n";
            }
        	
        	JOP.msg(a);
        }
        
        public void removeClimbList() { // Helper method to remove hiker from list.
        	
        	String s = JOP.in("Which hiker do you want to remove?");
        	for(ClimbInfo di: climbList) {
        		if(di.getHName().equalsIgnoreCase(s)) {
        			JOP.msg("Hiker " + di.getHName() + " has been removed");
        			climbList.remove(di);
        			return;
        		}
        	}
        	String x = JOP.in("No hiker with that name was found. Do you wish to search again?");
        	if(x.equalsIgnoreCase("yes")) {
        		removeClimbList();
        	}
        }


        /** @return the number of distinct names in the list of climbs - MP */
        public int modifiedDistinctPeakNames(){ 
            int count = 1;
            for(int i = 0; i < climbList.size()- 1; i++){
                if(!climbList.get(i).getName().equalsIgnoreCase(climbList.get(i+1).getName())){
                count++;
                }
            }
            return count;
        }

        
        /** @return the number of distinct names in the list of climbs - AP CB */
        public int distinctPeakNamesFromAP(){
            if (climbList.size() == 0){
              return 0;
            }
            ClimbInfo currInfo = climbList.get(0);
            String prevName = currInfo.getName();
            String currName = null;
            int numNames = 1;
            
            for (int k = 1; k < climbList.size(); k++){
                currInfo = climbList.get(k);
                currName = currInfo.getName();
                if (prevName.compareTo(currName) != 0){
                    numNames++;
                    prevName = currName;
                }
            }
            return numNames;
        }
    }
