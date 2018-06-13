package it.polito.tdp.formulaone.model;

import java.util.PriorityQueue;

public class Simulazione {
	
	private Model model;
	
	private PriorityQueue<Evento> pq;
	
	public Simulazione(Model model) {
		this.model = model ;
		pq = new PriorityQueue<Evento>();
	}
	
	//schedulo eventi= passaggio dal via del fantapilota=> ogni evento ha tempo di passaggio dal via
	public void simula() {
		
		//inizializzazione: inserisco eventi del primo giro in coda per ciascun pilota
		
		for(FantaPilota fp : model.getFantaPiloti()) {
			pq.add(new Evento(fp, 0, fp.getLapTimes().get(0)));//facciamo partire i giri e le posizioni da 0
		}
		
		//processo eventi e ne aggiungo di nuovi in caso
		while(!pq.isEmpty()) {
			Evento e = pq.poll();
			
			//devo assegnare dei punti al pilota: capire se pilota è in posizione migliora rispetto a quella precedente
			//mi chiedo quanti piloti correntemente hanno salvato un lap >del giro che sto compiendo:
			//cioè sono più avanti: al giro 0 guardo quanti piloti hanno già concluso il giro 0
			int count = 0 ; //se rimane 0 vuol dire che sono il primo pilota a completare il giro, nessuno l'ha già finito
			for(FantaPilota ifp : model.getFantaPiloti()) {
				if(!ifp.isEliminato()) {
					if(ifp.getLap() >= e.getLap()) {
						count++;	
					}
				}
				
				//ora mi chiedo se questa posizione è migliore di quella del giro precedente=>aggiorno punteggio
				if(count < e.getFantaPilota().getRank()) {
					int points = (e.getFantaPilota().getPoints())+1;
					e.getFantaPilota().setPoints(points);
				}
				e.getFantaPilota().setLap(e.getLap());
				e.getFantaPilota().setRank(count);
				
			}
			//devo capire se il pilota è stato doppiato: se un altro pilota ha due giri avanti in questo momento
			boolean doppiato = false;
			for(FantaPilota ifp : model.getFantaPiloti()) {
				if(!ifp.isEliminato()) {
					if(ifp.getLap()> e.getLap()+1) {
						doppiato = true;
					}
				}
			}
			if(doppiato == true) {
				//pilota eliminato => non aggiungo altri eventi relativi a lui e setto doppiato a true
				e.getFantaPilota().setEliminato();
				System.out.println("Pilota eliminato "+e.getFantaPilota().getYear());
			}else {
				//devo inserire un nuovo evento relativo al giro successivo
				if(e.getFantaPilota().getLapTimes().size()>e.getLap()+1) {
					//se ci sono ancora eventi da aggiungere
					int t = e.getFantaPilota().getLapTimes().get(e.getLap()+1);
					pq.add(new Evento(e.getFantaPilota(), e.getLap()+1, e.getTime() + t));
				}
			}
			
			
			
		}
		
	}

}
