package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.BitSet;

import view.DlgFootballer;
import view.IDlg;

/**
 * @author Dmytro Krapyvianskiy PI-211
 *
 */

//клас Footballer, що відтворює дану абстракцію для четвертого рівня дерева
public class Footballer extends AnyData{
	// визначимо приватні поля для характеристик об'єкта
	private String position;
	private LocalDate birthday;
	private String nationality;
	private float transferValue;
	private boolean oneFromFourCaptains;

	// створимо конструктор класу, використовуючи параметри 
	public Footballer(String name, String position, LocalDate birthday, String nationality, 
			float transferValue, boolean oneFromFourCaptains) throws Exception {
		this.setName(name);
		this.setPosition(position);
		this.setBirthday(birthday);
		this.setNationality(nationality);
		this.setTransferValue(transferValue);
		this.setOneFromFourCaptains(oneFromFourCaptains);
	}

	// створимо публічні методи get та set
	// для забезпечення можливості отримувати і записувати дані полів
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) throws Exception {
		if(position.isEmpty()) {
			throw new Exception("Field position cannot be empty.");
		}
		this.position = position;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) throws Exception {
		if(Period.between(birthday, LocalDate.now()).getYears() < 16 
				|| Period.between(birthday, LocalDate.now()).getYears() > 50) {
			throw new Exception("Invalid value of years.\n" 
					+ "Footballer must be at least 16-year-old, but younger than 50-year-old.\n" 
					+ "Date of birthday must be after " + LocalDate.now().minusYears(50) +
					" and before " + LocalDate.now().minusYears(16));
		}

		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) throws Exception {
		if(nationality.isEmpty()) {
			throw new Exception("Field nationality cannot be empty.");
		}
		this.nationality = nationality;
	}

	public float getTransferValue() {
		return transferValue;
	}

	public void setTransferValue(float transferValue) throws Exception {
		if(transferValue < 0.4 || transferValue > 100) {
			throw new Exception(transferValue + " is not correct transfer value.\n" 
					+ "Must be from 0.4 to 100 millions euro");
		}
		this.transferValue = transferValue;
	}

	public boolean isOneFromFourCaptains() {
		return oneFromFourCaptains;
	}

	public void setOneFromFourCaptains(boolean oneFromFourCaptains) {
		this.oneFromFourCaptains = oneFromFourCaptains;
	}

	// визначимо метод getAge, який повертає вік футболіста
	public int getAge() {
		return Period.between(getBirthday(), LocalDate.now()).getYears();
	}

	// перевизначимо метод toString() базового класу 
	public String toString() {
		return getPosition() + " " + getName();
	}

	@Override
	public IDlg getDialog() {
		return new DlgFootballer();
	}

	@Override
	public IDlg getSonDialog() {
		return null;
	}
}
