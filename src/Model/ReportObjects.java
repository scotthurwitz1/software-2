/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.Month;

/**
 *
 * @author scott
 */
public class ReportObjects {
    
    
    
    public static class CountObj {
        private String type;
        private Long count;
        private Month month;
        
        public CountObj(String type, Long count){
            this.type = type;
            this.count = count;
        }
        
        public CountObj(String type){
            this.type = type;
            this.count = null;
        }
        
        public CountObj(Month month, Long count){
            this.month = month;
            this.count = count;
        }

        /**
         * @return the type
         */
        public String getType() {
            return type;
        }

        /**
         * @return the count
         */
        public Long getCount() {
            return count;
        }

        /**
         * @param type the type to set
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * @param count the count to set
         */
        public void setCount(Long count) {
            this.count = count;
        }
        
        public void setMonth(Month month) {
            this.month = month;
        }

        public Month getMonth() {
            return month;
        }
        
    }
    
}
