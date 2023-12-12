package it.edu.iisgubbio;


public class Sjn {

	public static void main(String[] args ) {	
		String[] processo= new String[4];
		int []tArrivo=new int [4];
		int []tEsecuzione=new int [4];
		int []tServizio=new int [4];
		double []tAttesa= new double [4];
		double media=0;

		processo[0]="P0";
		processo[1]="P1";
		processo[2]="P2";
		processo[3]="P3";

		tEsecuzione[0]=5;
		tEsecuzione[1]=3;
		tEsecuzione[2]=8;
		tEsecuzione[3]=6;

		tArrivo[0]=0;
		tArrivo[1]=1;
		tArrivo[2]=2;
		tArrivo[3]=3;

		//Uso un for per capire quale sia il processo più corto
		
		for (int c = 0; c < 4; c++) {
			
			 
			for(int superficie=0;superficie<=tEsecuzione.length-1-1;superficie=superficie+1){
				for(int pos=tEsecuzione.length-1-1;pos>=superficie;pos--){
					if(tEsecuzione[pos]>tEsecuzione[pos+1]){

						int Ese=tEsecuzione[pos];
						tEsecuzione[pos]=tEsecuzione[pos+1];
						tEsecuzione[pos+1]=Ese;

						String Pro=processo[pos];
						processo[pos]=processo[pos+1];
						processo[pos+1]=Pro;

						int appoggioArrivo=tArrivo[pos];
						tArrivo[pos]=tArrivo[pos+1];
						tArrivo[pos+1]=appoggioArrivo;			
					}
				}
			}
			
			if(c==0) {
				tServizio[0]=0;
				tAttesa[0]=0;
			}else {
				tServizio[c]=tServizio[c-1]+tEsecuzione[c-1];
				tAttesa[c]=tServizio[c]-tArrivo[c];
				media= media+tAttesa[c]/processo.length;
			}
		}
		
		//Stampo nella console i risultati
		
		for(int i=0;i<4;i++) {
			System.out.println("Processo: " + processo[i]);
			System.out.println("Tempo arrivo: " + tArrivo[i]);
			System.out.println("Tempo Esecuzione: " + tEsecuzione[i]);
			System.out.println("Tempo serrvizio: "+tServizio[i]);
			System.out.println("Tempo attesa: "+tAttesa[i]);
		}
		System.out.println("Media attesa: "+media);
	}	
}
