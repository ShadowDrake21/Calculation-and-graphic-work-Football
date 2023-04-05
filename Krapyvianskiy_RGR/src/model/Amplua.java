package model;

import view.DlgAmplua;
import view.DlgFootballer;
import view.IDlg;

/**
 * @author Dmytro Krapyvianskiy PI-211
 *
 */

//клас Amplua, що відтворює дану абстракцію для третього рівня дерева
public class Amplua extends AnyData{
	// визначимо приватні поля для характеристик об'єкта
	private String mainAttribute;
	private boolean keyPosition;
	
	// створимо конструктор класу, використовуючи параметри 
	public Amplua(String name, String mainAttribute, boolean keyPosition) throws Exception {
		this.setName(name);
		this.setMainAttribute(mainAttribute);
		this.setKeyPosition(keyPosition);
	}
	
	// створимо публічні методи get та set
	// для забезпечення можливості отримувати і записувати дані полів
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
