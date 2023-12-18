package utils;

import java.io.Serializable;

public class Mark implements Serializable {
	
	private Integer attestation1;
	private Integer attestation2;
	private Integer finalExam;
	
	
	
	
	public Mark() {
		this.attestation1 = null;
		this.attestation2 = null;
		this.finalExam = null;
	}


	public Mark(Integer attestation1, Integer attestation2, Integer finalExam) {
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
