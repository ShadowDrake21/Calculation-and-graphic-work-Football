package model;

import view.DlgAmplua;
import view.DlgClub;
import view.IDlg;

/**
 * @author Dmytro Krapyvianskiy PI-211
 *
 */

//клас Club, що відтворює дану абстракцію для другого рівня дерева
public class Club extends AnyData {
	// визначимо приватні поля для характеристик об'єкта
	private String coachName;
	private int championshipPos;
	private float budgetValue;
	
	// створимо конструктор класу, використовуючи параметри 
	public Club(String name, String coachName, int championshipPos, float budgetValue) throws Exception {
		this.setName(name);
		this.setCoachName(coachName);
		this.setChampionshipPos(championshipPos);
		this.setBudgetValue(budgetValue);
	}
	
	// створимо публічні методи get та set
	// для забезпечення можливості отримувати і записувати дані полів
	public void setCoachName(String coachName) throws Exception {
		if(coachName.isEmpty()) {
			throw new Exception("Field coach name cannot"
					+ " be empty.\n");
		}
		this.coachName = coachName;
	}
	
	public String getCoachName() {
		return coachName;
	}
	
	public void setChampionshipPos(int championshipPos) throws Exception {
		if(championshipPos < 1 || championshipPos > 16) {
			throw new Exception(championshipPos 
					+ " is not correct position.\n" 
		+ "Must be from 1 to 16.");
		}
		this.championshipPos = championshipPos;
	}
	
	public int getChampionshipPos() {
		return championshipPos;
	}
	
	public void setBudgetValue(float budgetValue) throws Exception {
		if(budgetValue < 5 || budgetValue > 200) {
			throw new Exception(budgetValue
					+ " is not correct budget value.\n"
					+ "Must be from 5 to 200 millions euro");
		}
		this.budgetValue = budgetValue;
	}
	
	public float getBudgetValue() {
		return budgetValue;
	}

	@Override
	public IDlg getDialog() {
		return new DlgClub();
	}

	@Override
	public IDlg getSonDialog() {
		return new DlgAmplua();
	}
}
