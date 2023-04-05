package model;

import java.io.Serializable;

import view.IDlg;

/**
 * @author Dmytro Krapyvianskiy PI-211
 *
 */

// абстрактний клас AnyData, що є батьківським для класів-сутностей
public abstract class AnyData implements Serializable{
	// визначимо захищене поле для name
	protected String name;
	
	// створимо публічні методи get та set
	// для забезпечення можливості отримувати і записувати дані полів
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
	// перевизначимо метод toString() базового класу 
	@Override
	public String toString() {
		return name;
	}
}
