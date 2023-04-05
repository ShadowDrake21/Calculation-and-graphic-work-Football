package model;

import view.DlgClub;
import view.DlgLeague;
import view.IDlg;

/**
 * @author Dmytro Krapyvianskiy PI-211
 *
 */

// ���� League, �� �������� ���� ���������� ��� ������� ���� ������
public class League extends AnyData{
	// ��������� ������� ���� ��� ������������� ��'����
	private String presidentName;
	private float budgetValue;
	private int level;
	
	// �������� ����������� �����, �������������� ��������� 
	public League(String name, String presidentName, int level, float budgetValue) throws Exception {
		this.setLevel(level);
		this.setName(name);
		this.setPresidentName(presidentName);
		this.setBudgetValue(budgetValue);
	}
	
	// �������� ������ ������ get �� set
	// ��� ������������ ��������� ���������� � ���������� ��� ����
	public void setLevel(int level) throws Exception {
		if(level < 1 || level > 4) {
			throw new Exception(level + " is not correct level.\n"
					+ "Must be from 1 to 4.");
		}
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setPresidentName(String presidentName) throws Exception {
		if(presidentName.isEmpty()) {
			throw new Exception("Field president name cannot be empty.");
		}
		this.presidentName = presidentName;
	}
	
	public String getPresidentName() {
		return presidentName;
	}
	
	public void setBudgetValue(float budgetValue) throws Exception {
		if(budgetValue < 10 || budgetValue > 800) {
			throw new Exception(budgetValue + " is not correct budget value.\n" 
					+ "Must be from 10 to 800 millions euro.");
		}
		this.budgetValue = budgetValue;
	}
	
	public float getBudgetValue() {
		return budgetValue;
	}

	@Override
	public IDlg getDialog() {
		return new DlgLeague();
	}

	@Override
	public IDlg getSonDialog() {
		return new DlgClub();
	}
}
