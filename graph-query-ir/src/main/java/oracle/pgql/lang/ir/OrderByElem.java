/**
 * Copyright (C) 2013 - 2016 Oracle and/or its affiliates. All rights reserved.
 */
package oracle.pgql.lang.ir;

import static oracle.pgql.lang.ir.PgqlUtils.printPgqlString;

public class OrderByElem {

  private final QueryExpression exp;
  
  private final boolean ascending;

  public QueryExpression getExp() {
    return exp;
  }

  public boolean isAscending() {
    return ascending;
  }

  public OrderByElem(QueryExpression exp, boolean ascending) {
    this.exp = exp;
    this.ascending = ascending;
  }

  @Override
  public String toString() {
    return printPgqlString(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    OrderByElem that = (OrderByElem) o;

    if (ascending != that.ascending) {
      return false;
    }
    return exp.equals(that.exp);
  }

  @Override
  public int hashCode() {
    int result = exp.hashCode();
    result = 31 * result + (ascending ? 1 : 0);
    return result;
  }
}
