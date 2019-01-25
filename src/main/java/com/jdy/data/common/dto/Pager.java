package com.jdy.data.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页对象")
public class Pager {

	public Pager() {
		// TODO Auto-generated constructor stub
	}

	public Pager(int total, int page, int size, int count) {
		this.total = total;
		this.page = page;
		this.size = size;
		this.count = count;
	}

	/**
	 * 总页数
	 */
	@ApiModelProperty(value = "总页数")
	private int total;
	/**
	 * 当前页
	 */
	@ApiModelProperty("当前页")
	private int page = 1;
	/**
	 * 总条数
	 */
	@ApiModelProperty(value = "总条数")
	private long count;
	/**
	 * 当页大小
	 */
	@ApiModelProperty("每页大小")
	private int size = 10;

	@ApiModelProperty("1-启用，0不启用")
	private int valid = 1;

	/**
	 * 重新构建分页对象
	 * 
	 * @param page
	 * @param count
	 * @return
	 */
	public static Pager of(Pager page, int count) {
		double d = count;
		return new Pager((int) Math.ceil(d / page.getSize()), page.getPage(), page.getSize(), count);
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	/**
	 * 构建默认分页对象
	 * 
	 * @return
	 */
	public static Pager build() {
		return new Pager();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSysPage() {
		return page - 1;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		if (page < 1) {
			this.page = 1;
		}
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
		double c = count;

		this.total = (int) Math.ceil(c / size);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		if (size < 1) {
			this.size = 10;
		}
	}

	@Override
	public String toString() {
		return "Pager [total=" + total + ", page=" + page + ", count=" + count + ", size=" + size + "]";
	}

	public static void main(String[] args) {
		Pager p = new Pager();
		p.setPage(1);
		p.setSize(10);

		System.out.println(of(p, 23).toString());
	}

}
