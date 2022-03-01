package com.hackerrank.morganstanley;

import java.util.Date;

public final class InputWrapperImmutableDate {

	public InputWrapperImmutableDate(Date date, String city, int min, int max) {
		super();
		this.date = new Date(date.getTime());
		this.city = city;
		this.min = min;
		this.max = max;
	}

	private final Date date;
	private final String city;
	private final int min;
	private final int max;

	@Override
	public String toString() {
		return "InputWrapper [date=" + date + ", city=" + city + ", min=" + min + ", max=" + max + "]";
	}

	public final Date getDate() {
		return new Date(date.getTime());
	}

	public String getCity() {
		return city;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + max;
		result = prime * result + min;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InputWrapperImmutableDate other = (InputWrapperImmutableDate) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (max != other.max)
			return false;
		if (min != other.min)
			return false;
		return true;
	}

}
