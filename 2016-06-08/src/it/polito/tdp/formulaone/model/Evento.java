package it.polito.tdp.formulaone.model;
/**
 * Evento per ciascun giro
 * @author sere9
 *
 */
public class Evento implements Comparable<Evento>{
	
	private FantaPilota fp;
	private int lap; //giro a cui si riferisce evento
	private int time; //perché eventi in priorityqueue vengono ordinati in base al tempo
	
	public Evento(FantaPilota fp, int lap, int time) {
		
		this.fp = fp;
		this.lap = lap;
		this.time = time;
	}
	
	public FantaPilota getFantaPilota() {
		return fp;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setLap(int lap) {
		this.lap = lap;
	}

	public int getLap() {
		return lap;
	}


	@Override
	public int compareTo(Evento altro) {
		return Integer.compare(this.time, altro.time) ;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Evento [fp=");
		builder.append(fp.getYear());
		builder.append(", lap=");
		builder.append(lap);
		builder.append(", time=");
		builder.append(time);
		builder.append("]");
		return builder.toString();
	}
	
	
}
