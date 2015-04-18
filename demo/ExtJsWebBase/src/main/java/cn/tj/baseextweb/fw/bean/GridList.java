package cn.tj.baseextweb.fw.bean;

import java.util.ArrayList;
import java.util.List;

public class GridList<T> {

  private int total;
  private List<T> data;
  
  public GridList() {
    total = 0;
    data = new ArrayList<T>();
  }

  public GridList(int total, List<T> data) {
    this.total = total;
    this.data = data;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }
}
