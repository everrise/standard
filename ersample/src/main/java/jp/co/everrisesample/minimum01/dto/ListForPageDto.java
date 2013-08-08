package jp.co.everrisesample.minimum01.dto;

import java.util.List;

/**
 * 一覧表示画面へ値を持っていくための入れ物
 */
public class ListForPageDto<T> {
	public List<T> resultList;
	public int page;
	public int limit;
	public long total;
	public String name;
	public String orderBy;

	/**
	 * 最終ページを得る
	 *
	 * @return
	 */
	public int getMaxPage() {
		if (total == 0) {
			return 0;
		}
		if ((total % limit) == 0) {
			return (int) (total / limit);
		}
		return (int) (total / limit) + 1;
	}

	public int getFirstRow() {
		return (page - 1) * limit + 1;
	}

	public int getLastRow() {
		if (total == limit * page) {
			return limit * page;
		}
		if (hasNext()) {
			return getFirstRow() + limit - 1;
		}
		return (int) (getFirstRow() + (total % limit)) - 1;
	}

	public boolean hasNext() {
		return (getMaxPage() > 1 && page < getMaxPage());
	}

	public boolean getHasFirst() {
		return true;
	}

	public boolean getHasNext() {
		return hasNext();
	}

	public boolean hasPrev() {
		return page > 1;
	}

	public boolean getHasPrev() {
		return hasPrev();
	}

	public boolean getHasLast() {
		return true;
	}

}
