package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RolloutAssignmentList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f88551a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f88552b;

    public RolloutAssignmentList(int i3) {
        this.f88552b = i3;
    }

    public List a() {
        List listB = b();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < listB.size(); i3++) {
            arrayList.add(((RolloutAssignment) listB.get(i3)).h());
        }
        return arrayList;
    }

    public synchronized List b() {
        return Collections.unmodifiableList(new ArrayList(this.f88551a));
    }

    public synchronized boolean c(List list) {
        this.f88551a.clear();
        if (list.size() <= this.f88552b) {
            return this.f88551a.addAll(list);
        }
        Logger.f().k("Ignored 0 entries when adding rollout assignments. Maximum allowable: " + this.f88552b);
        return this.f88551a.addAll(list.subList(0, this.f88552b));
    }
}
