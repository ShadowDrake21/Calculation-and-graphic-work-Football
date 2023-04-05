package test;

import view.DlgAmplua;
import view.DlgClub;
import view.DlgFootballer;
import view.DlgLeague;
import view.IDlg;

public class TestDlg {
	public static void main(String[] args) {
		IDlg dlgLeague = new DlgLeague();
		dlgLeague.setEditable(true);
		dlgLeague.setVisible(true);
		System.out.println(dlgLeague.getObject());
		dlgLeague.dispose();
		
		IDlg dlgClub = new DlgClub();
		dlgClub.setEditable(true);
		dlgClub.setVisible(true);
		System.out.println(dlgClub.getObject());
		dlgClub.dispose();
		
		IDlg dlgAmplua = new DlgAmplua();
		dlgAmplua.setEditable(true);
		dlgAmplua.setVisible(true);
		System.out.println(dlgAmplua.getObject());
		dlgAmplua.dispose();
		
		IDlg dlgFootballer = new DlgFootballer();
		dlgFootballer.setEditable(true);
		dlgFootballer.setVisible(true);
		System.out.println(dlgFootballer.getObject());
		dlgFootballer.dispose();
	}
}
