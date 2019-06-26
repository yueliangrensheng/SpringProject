package com.yazao.ssm.domain;

import java.util.ArrayList;

public class QueryVo {

	private Items items;

	private int [] ids;

	private ArrayList<Items> itemsList;

	public ArrayList<Items> getItemsList() {
		return itemsList;
	}

	public void setItemsList(ArrayList<Items> itemsList) {
		this.itemsList = itemsList;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
	
}
