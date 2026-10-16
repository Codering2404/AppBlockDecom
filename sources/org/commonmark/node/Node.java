package org.commonmark.node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class Node {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Node f145531a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Node f145532b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Node f145533c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Node f145534d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Node f145535e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f145536f = null;

    public abstract void a(Visitor visitor);

    public void b(SourceSpan sourceSpan) {
        if (this.f145536f == null) {
            this.f145536f = new ArrayList();
        }
        this.f145536f.add(sourceSpan);
    }

    public void c(Node node) {
        node.n();
        node.k(this);
        Node node2 = this.f145533c;
        if (node2 == null) {
            this.f145532b = node;
            this.f145533c = node;
        } else {
            node2.f145535e = node;
            node.f145534d = node2;
            this.f145533c = node;
        }
    }

    public Node d() {
        return this.f145532b;
    }

    public Node e() {
        return this.f145533c;
    }

    public Node f() {
        return this.f145535e;
    }

    public Node g() {
        return this.f145531a;
    }

    public List h() {
        List list = this.f145536f;
        return list != null ? Collections.unmodifiableList(list) : Collections.EMPTY_LIST;
    }

    public void i(Node node) {
        node.n();
        Node node2 = this.f145535e;
        node.f145535e = node2;
        if (node2 != null) {
            node2.f145534d = node;
        }
        node.f145534d = this;
        this.f145535e = node;
        Node node3 = this.f145531a;
        node.f145531a = node3;
        if (node.f145535e == null) {
            node3.f145533c = node;
        }
    }

    public void j(Node node) {
        node.n();
        Node node2 = this.f145534d;
        node.f145534d = node2;
        if (node2 != null) {
            node2.f145535e = node;
        }
        node.f145535e = this;
        this.f145534d = node;
        Node node3 = this.f145531a;
        node.f145531a = node3;
        if (node.f145534d == null) {
            node3.f145532b = node;
        }
    }

    protected void k(Node node) {
        this.f145531a = node;
    }

    public void l(List list) {
        if (list.isEmpty()) {
            this.f145536f = null;
        } else {
            this.f145536f = new ArrayList(list);
        }
    }

    protected String m() {
        return "";
    }

    public void n() {
        Node node = this.f145534d;
        if (node != null) {
            node.f145535e = this.f145535e;
        } else {
            Node node2 = this.f145531a;
            if (node2 != null) {
                node2.f145532b = this.f145535e;
            }
        }
        Node node3 = this.f145535e;
        if (node3 != null) {
            node3.f145534d = node;
        } else {
            Node node4 = this.f145531a;
            if (node4 != null) {
                node4.f145533c = node;
            }
        }
        this.f145531a = null;
        this.f145535e = null;
        this.f145534d = null;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + m() + "}";
    }
}
