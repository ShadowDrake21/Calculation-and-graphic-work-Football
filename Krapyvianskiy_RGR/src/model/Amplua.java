package model;

import view.DlgAmplua;
import view.DlgFootballer;
import view.IDlg;

/**
 * @author Dmytro Krapyvianskiy PI-211
 *
 */

//���� Amplua, �� �������� ���� ���������� ��� �������� ���� ������
public class Amplua extends AnyData{
	// ��������� ������� ���� ��� ������������� ��'����
	private String mainAttribute;
	private boolean keyPosition;
	
	// �������� ����������� �����, �������������� ��������� 
	public Amplua(String name, String mainAttribute, boolean keyPosition) throws Exception {
		this.setName(name);
		this.setMainAttribute(mainAttribute);
		this.setKeyPosition(keyPosition);
	}
	
	// �������� ������ ������ get �� set
	// ��� ������������ ��������� ���������� � ���������� ��� ����
	public void setMainAttribute(String mainAttribute) throws Exception {
		if(mainAttribute.isEmpty()) {
			throw new Exception("Field main attribute cannot be empty.");
		}
		this.mainAttribute = mainAttribute;
	}
	
	public void setKeyPosition(boolean keyPosition) {
		this.keyPosition = keyPosition;
	}

	public String getMainAttribute() {
		return mainAttribute;
	}

	public boolean isKeyPosition() {
		return keyPosition;
	}

	@Override
	public IDlg getDialog() {
		return new DlgAmplua();
	}

	@Override
	public IDlg getSonDialog() {
		return new DlgFootballer();
	}
}
