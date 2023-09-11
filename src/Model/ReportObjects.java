/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.Month;

/**
 * objects used in report generation
 * @author scott
 */
public class ReportObjects {
    
    /**
     * object used for aggregation
     */
    public static class CountObj {
        private String type;
        private Long count;
        private Month month;
        
        /**
         * constructor
         * @param type
         * @param count
         */
        public CountObj(String type, Long count){
            this.type = type;
            this.count = count;
        }
        
        /**
         * constructor
         * @param type
         */
        public CountObj(String type){
            this.type = type;
            this.count = null;
        }
        
        /**
         * constructor
         * @param month
         * @param count
         */
        public CountObj(Month month, Long count){
            this.month = month;
            this.count = count;
        }

        /**
         * get count type
         * @return the type
         */
        public String getType() {
            return type;
        }

        /**
         * get count
         * @return the count
         */
        public Long getCount() {
            return count;
        }

        /**
         * set count type
         * @param type the type to set
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * set count
         * @param count the count to set
         */
        public void setCount(Long count) {
            this.count = count;
        }
        
        /**
         * set month
         * @param month
         */
        public void setMonth(Month month) {
            this.month = month;
        }

        /**
         * get month
         * @return
         */
        public Month getMonth() {
            return month;
        }
        
    }
    
}
