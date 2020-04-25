//package com.example.demo.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//import com.example.demo.model.user.Patient;
//
//@Entity
//public class Appointment {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	 private int appointmentId;
//	
//	 private String appointmenttitle;
//	 private String additionalInfo;
//	 private Long timeinMillis;
//	 
//	 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
//	 @JoinColumn(name = "patient_id")
//	 private Patient patient;
//
//	 
//	 
//	 //Methods below
//	 
//	 	public Appointment() {}
//
//	    public Appointment(String appointmenttitle, String additionalInfo, Long timeinMillis) {
//	        this.appointmenttitle = appointmenttitle;
//	        this.additionalInfo = additionalInfo;
//	        this.timeinMillis = timeinMillis;
//	    }
//
//
//
//		public int getAppointmentId() {
//			return appointmentId;
//		}
//
//
//
//		public void setAppointmentId(int appointmentId) {
//			this.appointmentId = appointmentId;
//		}
//
//
//
//		public String getAppointmenttitle() {
//			return appointmenttitle;
//		}
//
//
//
//		public void setAppointmenttitle(String appointmenttitle) {
//			this.appointmenttitle = appointmenttitle;
//		}
//
//
//
//		public String getAdditionalInfo() {
//			return additionalInfo;
//		}
//
//
//
//		public void setAdditionalInfo(String additionalInfo) {
//			this.additionalInfo = additionalInfo;
//		}
//
//
//
//		public Long getTimeinMillis() {
//			return timeinMillis;
//		}
//
//
//
//		public void setTimeinMillis(Long timeinMillis) {
//			this.timeinMillis = timeinMillis;
//		}
//
//
//
//		public Patient getPatient() {
//			return patient;
//		}
//
//
//
//		public void setPatient(Patient patient) {
//			this.patient = patient;
//		}
//
//	
//		
//	    
//	    
//	    
//	  
//	    
//	    
//}
