 package src;
 
public class ClimbInfo {

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
        public String getName(){    
            return pName;
        }       
        
        public boolean getFound() {
        	return foundKoala;
        }
        
        public String getHName() {
        	return hName;
        }
        public String getTime(){
            return cTime;
        }
        public String toString(){
            return(getName() + " , " + getTime());
        }
    }