package it.polito.tdp.formulaone.model;

import java.util.List;

public class FantaPilota {
	//dato DRiver e il circuito
	
	private int year;
	private List<Integer> lapTimes;
	
	private int points; //punti associati a qual pilota
	private int lap; //giro corrente per sapere come si posiziona rispetto agli altri
	private int rank;//ultima posizione per sapere se ha fatto un sorpasso
	private boolean eliminato;
	
	public FantaPilota(int year, List<Integer> lapTimes) {
		this.year = year;
		this.lapTimes = lapTimes;
		
		this.points = 0 ;
		this.lap = -1 ;
		this.rank = Integer.MAX_VALUE ;
		this.eliminato = false;
		
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Integer> getLapTimes() {
		return lapTimes;
	}

	public void setLapTimes(List<Integer> lapTimes) {
		this.lapTimes = lapTimes;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getLap() {
		return lap;
	}

	public void setLap(int lap) {
		this.lap = lap;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	

	public boolean isEliminato() {
		return eliminato;
	}

	public void setEliminato() {
		this.eliminato = true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FantaPilota [year=");
		builder.append(year);
		builder.append(", lapTimes=");
		builder.append(lapTimes);
		builder.append(", points=");
		builder.append(points);
		builder.append(", lap=");
		builder.append(lap);
		builder.append(", rank=");
		builder.append(rank);
		builder.append("]");
		return builder.toString();
	}
	
	

}
