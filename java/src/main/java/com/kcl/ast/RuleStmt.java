package com.kcl.ast;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/**
 * RuleStmt, e.g.
 *
 * <pre>
 * {@code
 * rule RuleExample:
 *    a > 1
 *    b < 0
 * }
 * </pre>
 */
@JsonTypeName("Rule")
public class RuleStmt extends Stmt {
    @JsonProperty("doc")
    private NodeRef<String> doc;

    @JsonProperty("name")
    private NodeRef<String> name;

    @JsonProperty("parent_rules")
    private List<NodeRef<Identifier>> parentRules;

    @JsonProperty("decorators")
    private List<NodeRef<CallExpr>> decorators;

    @JsonProperty("checks")
    private List<NodeRef<CheckExpr>> checks;

    @JsonProperty("args")
    private NodeRef<Arguments> args;

    @JsonProperty("for_host_name")
    private NodeRef<Identifier> forHostName;

    public NodeRef<String> getDoc() {
        return doc;
    }

    public void setDoc(NodeRef<String> doc) {
        this.doc = doc;
    }

    public NodeRef<String> getName() {
        return name;
    }

    public void setName(NodeRef<String> name) {
        this.name = name;
    }

    public List<NodeRef<Identifier>> getParentRules() {
        return parentRules;
    }

    public void setParentRules(List<NodeRef<Identifier>> parentRules) {
        this.parentRules = parentRules;
    }

    public List<NodeRef<CallExpr>> getDecorators() {
        return decorators;
    }

    public void setDecorators(List<NodeRef<CallExpr>> decorators) {
        this.decorators = decorators;
    }

    public List<NodeRef<CheckExpr>> getChecks() {
        return checks;
    }

    public void setChecks(List<NodeRef<CheckExpr>> checks) {
        this.checks = checks;
    }

    public NodeRef<Arguments> getArgs() {
        return args;
    }

    public void setArgs(NodeRef<Arguments> args) {
        this.args = args;
    }

    public NodeRef<Identifier> getForHostName() {
        return forHostName;
    }

    public void setForHostName(NodeRef<Identifier> forHostName) {
        this.forHostName = forHostName;
    }
}
