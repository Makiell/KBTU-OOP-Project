package utils;

import java.io.Serializable;

public class Mark implements Serializable {
	
	private double attestation1;
	private double attestation2;
	private double finalExam;
	
	
	
	
	public Mark() {
		this.attestation1 = (Double) null;
		this.attestation2 = (Double) null;
		this.finalExam = (Double) null;
	}


	public Mark(double attestation1, double attestation2, double finalExam) {
		this.attestation1 = attestation1;
		this.attestation2 = attestation2;
		this.finalExam = finalExam;
	}


	@Override
	public String toString() {
		return "Mark [attestation1=" + attestation1 + ", attestation2=" + attestation2 + ", finalExam=" + finalExam
				+ "]";
	}
	
	
}
