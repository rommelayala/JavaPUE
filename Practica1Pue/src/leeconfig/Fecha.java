package leeconfig;



import java.util.*;
public class Fecha {
	Calendar hoy=Calendar.getInstance();
	private Integer año,mes,dia;
	

	public void setFecha(Integer aaaa,Integer mm,Integer dd){
		año=aaaa;
		mes=mm;
		dia=dd;             
	}
	public void setFecha(){
		año=hoy.get(Calendar.YEAR);
		mes=hoy.get(Calendar.MONTH)+1;
		dia=hoy.get(Calendar.DAY_OF_MONTH);        
	}
	public int getAño(){return año;}
	public int getMes(){return mes;}
	public int getDia(){return dia;}
	
	public String fechaToString(){
		String strFecha=Integer.toString(año)+"/";
		
		if(mes<10)strFecha+="0"+Integer.toString(mes)+"/";
		else strFecha+=Integer.toString(mes)+"/";
		if(dia<10)strFecha+="0"+Integer.toString(dia);
		else strFecha+=Integer.toString(dia);
		return strFecha;
	}   

	public boolean esBisiesto(){
		return año%4==0||año%100==0&&año%400!=0;        
	}
	public int obtenerDiasMes(int año,int mes){
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
			m=m+obtenerDiasMes(año,xmes)%7;
		}
		m=m%7;        
		return (m+(año-1)%7+((año-1)/4-(3*((año-1)/100+1))/4)%7+1%7)%7;       
	}
	public boolean esValidaFecha(int año,int mes,int dia){
		if(año<1)return false;
		else if(mes<1||mes>12)return false;
		else if(dia<1||dia>obtenerDiasMes(año,mes)) return false;
		else return true;
	} 

	void adelantarAño(){
		año++;mes=1;dia=1;
	}
	void atrazarAño(){
		if(año!=1){año--;mes=12;dia=1;}
	}
	void atrazarMes(){
		if(mes==1)atrazarAño();           
		else{mes--;dia=1;}
	}
	void adelantarMes(){
		if(mes==12)adelantarAño();           
		else{mes++;dia=1;}
	}
	void setDia(int dia){
		this.dia=dia;
	}
}


