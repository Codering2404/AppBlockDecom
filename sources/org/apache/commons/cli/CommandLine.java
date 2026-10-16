package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class CommandLine implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f145199a = new LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f145200b = new ArrayList();

    CommandLine() {
    }

    private Option e(String str) {
        String strB = Util.b(str);
        for (Option option : this.f145200b) {
            if (strB.equals(option.j()) || strB.equals(option.i())) {
                return option;
            }
        }
        return null;
    }

    void a(String str) {
        this.f145199a.add(str);
    }

    void b(Option option) {
        this.f145200b.add(option);
    }

    public List c() {
        return this.f145199a;
    }

    public boolean d(String str) {
        return this.f145200b.contains(e(str));
    }
}
