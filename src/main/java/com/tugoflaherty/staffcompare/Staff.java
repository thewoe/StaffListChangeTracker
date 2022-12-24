/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tugoflaherty.staffcompare;

/**
 *
 * @author tugso
 */		 	  	 	        	     		  		 	  	 	        	     	

public class Staff {	  		 	  	 	        	     	
	  		 	  	 	        	     	
    private String fullName;	  		 	  	 	        	     	
    private String jobTitle;	  		 	  	 	        	     	
    private String emailAddress;	  		 	  	 	        	     	  		 	  	 	        	     		  		 	  	 	        	     	
	  		 	  	 	        	     		 	  	 	        	     	
    public Staff(String fullName, String jobTitle, String emailAddress) {	  		 	  	 	        	     	
      this.setFullName(fullName);	  		 	  	 	        	     	
      this.setJobTitle(jobTitle);	  		 	  	 	        	     	
      this.setEmailAddress(emailAddress);	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
 		 	  	 	        	     	
    public String getFullName() {	  		 	  	 	        	     	
        return fullName;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
  		 	  	 	        	     	
    public void setFullName(String fullName) {	  		 	  	 	        	     	
        this.fullName = fullName;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	  		 	  	 	        	      		 	  	 	        	     	
  		 	  	 	        	     	
    public String getJobTitle() {	  		 	  	 	        	     	
        return jobTitle;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	  		 	  	 	        	     			 	  	 	        	     	
    public void setJobTitle(String jobTitle) {	  		 	  	 	        	     	
        this.jobTitle = jobTitle;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	 	  	 	        	     	
    public String getEmailAddress() {	  		 	  	 	        	     	
        return emailAddress;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	  		 	  	 	        	     			 	  	 	        	     	
    public void setEmailAddress(String emailAddress) {	  		 	  	 	        	     	
        this.emailAddress = emailAddress;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
		 	  	 	        	     	
    @Override	  		 	  	 	        	     	
    public String toString() {	  		 	  	 	        	     	
        return fullName + "  |  " + jobTitle + "  |  " + emailAddress;  		 	  	 	        	     	
    }	  		 	  	 	        	     	

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Staff))
            return false;
        Staff other = (Staff) o;
        boolean fullNameEquals = (this.fullName == null && other.fullName == null)
          || (this.fullName != null && this.fullName.equals(other.fullName));
        boolean jobTitleEquals = (this.jobTitle == null && other.jobTitle == null)
          || (this.jobTitle != null && this.jobTitle.equals(other.jobTitle));
        boolean emailAddressEquals = (this.emailAddress == null && other.emailAddress == null)
          || (this.emailAddress != null && this.emailAddress.equals(other.emailAddress));
        return fullNameEquals && jobTitleEquals && emailAddressEquals;
    }

    @Override
    public final int hashCode() {
        int result = 13;
        if (fullName != null) {
            result = 31 * result + fullName.hashCode();
        }
        if (jobTitle != null) {
            result = 31 * result + jobTitle.hashCode();
        }
        if (emailAddress != null) {
            result = 31 * result + emailAddress.hashCode();
        }
        return result;
    }
}