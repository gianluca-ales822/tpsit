package it.edu.iisgubbio.fcfs;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Fcfs extends Application{
	
	/*
	 * imposto tutte le label e i valori per il programma
	 */
	
	Label processo = new Label("Processo");
	Label teArrivo= new Label("Tempo Di Arrivo");
	Label teEsecuzione= new Label("Tempo Di Esecuzione");
	Label teServizio= new Label("Tempo Di Servizio");
	Label tAttesa = new Label("Tempo Di Attesa");
	
	Label pZero= new Label();
	Label pUno= new Label();
	Label pDue= new Label();
	Label pTre= new Label();
	
	Label piZero= new Label("P0");
	Label piUno= new Label("P1");
	Label piDue= new Label("P2");
	Label piTre= new Label("P3");
	
	Label tempoArrivo0= new Label("0");
	Label tempoArrivo1= new Label("1");
	Label tempoArrivo2= new Label("2");
	Label tempoArrivo3= new Label("3");
	
	TextField tempoEsecuzione0= new TextField("5");
	TextField tempoEsecuzione1= new TextField("3");
	TextField tempoEsecuzione2= new TextField("8");
	TextField tempoEsecuzione3= new TextField("6");
	
	Label risP0= new Label();
	Label risP1= new Label();
	Label risP2= new Label();
	Label risP3= new Label();
	
	Label temAtt0= new Label();
	Label temAtt1= new Label();
	Label temAtt2= new Label();
	Label temAtt3= new Label();
	
	Button bFa = new Button("FA");
	
	public void start(Stage finestra) {
		
		//allargo le label
		
		processo.setMaxWidth(1231231233);
		teArrivo.setMaxWidth(432432432);
		teEsecuzione.setMaxWidth(34234234);
		teServizio.setMaxWidth(34324334);
		
		GridPane principale = new GridPane();
		
		//imposto la posizione al programma
		
		principale.add(processo,0,0);
		principale.add(teArrivo, 1, 0);
		principale.add(teEsecuzione, 2, 0);
		principale.add(teServizio, 3, 0);
		
		principale.add(piZero, 0, 1);
		principale.add(piUno, 0, 2);
		principale.add(piDue, 0, 3);
		principale.add(piTre, 0, 4);
		
		principale.add(tempoArrivo0,1,1);
		principale.add(tempoArrivo1,1,2);
		principale.add(tempoArrivo2,1,3);
		principale.add(tempoArrivo3,1,4);
		
		principale.add(tempoEsecuzione0,2,1);
		principale.add(tempoEsecuzione1,2,2);
		principale.add(tempoEsecuzione2,2,3);
		principale.add(tempoEsecuzione3,2,4);
		
		principale.add(risP0,3,1);
		principale.add(risP1,3,2);
		principale.add(risP2,3,3);
		principale.add(risP3,3,4);
		
		principale.add(temAtt0, 4, 1);
		principale.add(temAtt1, 4, 2);
		principale.add(temAtt2, 4, 3);
		principale.add(temAtt3, 4, 4);
		
		principale.add(bFa,1,5,4,4);
		principale.add(tAttesa, 4, 0);
		
		Scene scena = new Scene(principale);
		finestra.setTitle("Scuola");
		finestra.setScene(scena);
		finestra.show();
		
		bFa.setOnAction(e -> fa());
	}
	
	private void fa() {
		
		//prendo i numeri dalle varie label

		int nTemArr1 = Integer.parseInt(tempoArrivo1.getText());
		int nTemArr2 = Integer.parseInt(tempoArrivo2.getText());
		int nTemArr3 = Integer.parseInt(tempoArrivo3.getText());
		
		int nTemEse0 = Integer.parseInt(tempoEsecuzione0.getText());
		int nTemEse1 = Integer.parseInt(tempoEsecuzione1.getText());
		int nTemEse2 = Integer.parseInt(tempoEsecuzione2.getText());
		
		//calcolo il tempo di servizio
		
		risP0.setText("0");
		risP1.setText(""+nTemEse0);
		risP2.setText(""+(nTemEse0+nTemEse1));
		risP3.setText(""+((Integer.parseInt(risP2.getText()))+nTemEse2));
		
		//calcolo il tempo di attesa 
		
		temAtt0.setText("0");
		temAtt1.setText(""+(Integer.parseInt(risP1.getText())-nTemArr1));
		temAtt2.setText(""+(Integer.parseInt(risP2.getText())-nTemArr2));
		temAtt3.setText(""+(Integer.parseInt(risP3.getText())-nTemArr3));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}