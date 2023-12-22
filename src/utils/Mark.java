package utils;

import java.io.Serializable;

public class Mark implements Serializable {
	
	private Double attestation1;
	private Double attestation2;
	private Double finalExam;
	
	
	
	
	public Mark() {
		this.attestation1 = null;
		this.attestation2 = null;
		this.finalExam = null;
	}


	public Mark(double attestation1, double attestation2, double finalExam) {
		this.attestation1 = attestation1;
		this.attestation2 = attestation2;
		this.finalExam = finalExam;
	}
	
	public double getGpa() {
		double sum = attestation1 + attestation2 + finalExam;
		if(sum>=95) {
			return 4.0;
		}
		if(sum>=90) {
			return 3.67;
		}
		if(sum>=85) {
			return 3.33;
		}
		if(sum>=80) {
			return 3.0;
		}
		if(sum>=75) {
			return 2.67;
		}
		if(sum>=70) {
			return 2.33;
		}
		if(sum>=65) {
			return 2.0;
		}
		if(sum>=60) {
			return 1.67;
		}
		if(sum>=55) {
			return 1.33;
		}
		if(sum>=50) {
			return 1.0;
		}
		if(sum<50) {
			return 0;
		}
		return 0;
	}


	@Override
	public String toString() {
		return "Mark [attestation1=" + attestation1 + ", attestation2=" + attestation2 + ", finalExam=" + finalExam
				+ "]";
	}
	
	
}
