package leeconfig;



import java.util.*;
public class Fecha {
	Calendar hoy=Calendar.getInstance();
	private Integer a�o,mes,dia;
	

	public void setFecha(Integer aaaa,Integer mm,Integer dd){
		a�o=aaaa;
		mes=mm;
		dia=dd;             
	}
	public void setFecha(){
		a�o=hoy.get(Calendar.YEAR);
		mes=hoy.get(Calendar.MONTH)+1;
		dia=hoy.get(Calendar.DAY_OF_MONTH);        
	}
	public int getA�o(){return a�o;}
	public int getMes(){return mes;}
	public int getDia(){return dia;}
	
	public String fechaToString(){
		String strFecha=Integer.toString(a�o)+"/";
		
		if(mes<10)strFecha+="0"+Integer.toString(mes)+"/";
		else strFecha+=Integer.toString(mes)+"/";
		if(dia<10)strFecha+="0"+Integer.toString(dia);
		else strFecha+=Integer.toString(dia);
		return strFecha;
	}   

	public boolean esBisiesto(){
		return a�o%4==0||a�o%100==0&&a�o%400!=0;        
	}
	public int obtenerDiasMes(int a�o,int mes){
		int dias;
		switch (mes){
		case 4:case 6:case 9:case 11: dias=30;break;
		case 2:if(esBisiesto())dias=29;else dias=28;
		break;
		default: dias=31;
		}
		return dias;
	}
	public int obtenerDiaSemana(){ 
		int m=0;
		for(int xmes=1;xmes<mes;xmes++){
			m=m+obtenerDiasMes(a�o,xmes)%7;
		}
		m=m%7;        
		return (m+(a�o-1)%7+((a�o-1)/4-(3*((a�o-1)/100+1))/4)%7+1%7)%7;       
	}
	public boolean esValidaFecha(int a�o,int mes,int dia){
		if(a�o<1)return false;
		else if(mes<1||mes>12)return false;
		else if(dia<1||dia>obtenerDiasMes(a�o,mes)) return false;
		else return true;
	} 

	void adelantarA�o(){
		a�o++;mes=1;dia=1;
	}
	void atrazarA�o(){
		if(a�o!=1){a�o--;mes=12;dia=1;}
	}
	void atrazarMes(){
		if(mes==1)atrazarA�o();           
		else{mes--;dia=1;}
	}
	void adelantarMes(){
		if(mes==12)adelantarA�o();           
		else{mes++;dia=1;}
	}
	void setDia(int dia){
		this.dia=dia;
	}
}


