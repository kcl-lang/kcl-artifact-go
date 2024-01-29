package com.kcl.ast;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * BinaryExpr, e.g.
 *
 * <pre>
 * {@code
 * 1 + 1
 * 3 - 2
 * 5 / 2
 * a is None
 * }
 * </pre>
 */
@JsonTypeName("Binary")
public class BinaryExpr extends Expr {
    @JsonProperty("left")
    private NodeRef<Expr> left;

    @JsonProperty("op")
    private BinOp op;

    @JsonProperty("right")
    private NodeRef<Expr> right;

    public NodeRef<Expr> getLeft() {
        return left;
    }

    public void setLeft(NodeRef<Expr> left) {
        this.left = left;
    }

    public BinOp getOp() {
        return op;
    }

    public void setOp(BinOp op) {
        this.op = op;
    }

    public NodeRef<Expr> getRight() {
        return right;
    }

    public void setRight(NodeRef<Expr> right) {
        this.right = right;
    }
}
