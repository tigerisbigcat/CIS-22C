package QueuePackage;


/**
 * An abstract class that can be used as the base for other event classes.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public abstract class SimulationEvent  implements SimulationEventInterface, Comparable<SimulationEvent>
    {
        private double atTime;
        private String description;
        protected String postActionReport;
        public SimulationEvent (double theTime, String action)
        {
            atTime = theTime;
            description = action;
            postActionReport = "Event has not fired yet";
        }
            
        /**
         * Get the time for the event.
         * 
         * @return  The time of the event. 
         */
        public double getTime()
        {
            return atTime;
        }
            
        /**
         * Process the event.
         */
        abstract public void process();
        
        /**
         * Get a string representing the action for the event.
         * 
         * @return  A description of the event. 
         */
        
        public String getDescription()
        {
           return description;
        }
        
        /**
         * Get a string representing reporting on the status of the event
         * after it has finished executing.
         * 
         * @return  A post event action report. 
         */
        public String getPostActionReport()
        {
            return postActionReport;
        }

        @Override
        public String toString() {
            return "{" +
                    atTime +
                    ", \'" + description + '\'' +
                    '}';
        }
    }  // end of Event
