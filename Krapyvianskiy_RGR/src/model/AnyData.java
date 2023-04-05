package model;

import java.io.Serializable;

import view.IDlg;

/**
 * @author Dmytro Krapyvianskiy PI-211
 *
 */

// ����������� ���� AnyData, �� � ����������� ��� �����-���������
public abstract class AnyData implements Serializable{
	// ��������� �������� ���� ��� name
	protected String name;
	
	// �������� ������ ������ get �� set
	// ��� ������������ ��������� ���������� � ���������� ��� ����
	public String getName() {
		return name;
	}
	
	public void setName(String name) throws Exception {
		if(name.isEmpty()) {
			throw new Exception
						("Field name cannot be empty.\n");
		}
		this.name = name;
	}
	
	public abstract IDlg getDialog();
	public abstract IDlg getSonDialog();
	// ������������� ����� toString() �������� ����� 
	@Override
	public String toString() {
		return name;
	}
}
