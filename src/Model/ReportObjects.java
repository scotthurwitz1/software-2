/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author scott
 */
public class ReportObjects {
    
    
    
    public static class ApptTypeCount {
        private String type;
        private Integer count;
        
        public ApptTypeCount(String type, Integer count){
            this.type = type;
            this.count = count;
        }
        
        public ApptTypeCount(String type){
            this.type = type;
            this.count = null;
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
        public Integer getCount() {
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
        public void setCount(Integer count) {
            this.count = count;
        }
        
    }
    
}
