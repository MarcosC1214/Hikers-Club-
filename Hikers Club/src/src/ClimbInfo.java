 package src;
 
public class ClimbInfo { // Class containing getters and setters for list along with a few helper methods.

            String pName;
            String cTime;
            String hName;
            
            public static int kn = 0;
            public static boolean foundKoala;
        /** Creates a ClimbInfo object with name peakName and time climbTime.
         *  @param peakName the name of the mountain peak
         *  @param t the number of minutes taken to complete the climb
         * @param h 
         */
        public ClimbInfo( String h, String peakName, String t){ 
        	hName = h;
            pName = peakName;
            cTime = t;
            foundKoala = (Math.random() * 10 > 7);   
        }
        public String getName(){ // Getter for name.
            return pName;
        }       
        
        public boolean getFound() { // Getter for Koala found.
        	return foundKoala;
        }
        
        public String getHName() { // Getter for hiker name.
        	return hName;
        }
        public String getTime(){ // Getter for hike duration time.
            return cTime;
        }
        public String toString(){ // toString method to format all lines in corresponding font.
            return(getName() + " , " + getTime());
        }
    }
