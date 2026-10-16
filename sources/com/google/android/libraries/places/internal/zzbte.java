package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbte {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f76848a = Collections.newSetFromMap(new IdentityHashMap());

    public final void a(Object obj, boolean z2) {
        Set set = this.f76848a;
        int size = set.size();
        if (z2) {
            set.add(obj);
            if (size == 0) {
                d();
                return;
            }
            return;
        }
        if (set.remove(obj) && size == 1) {
            e();
        }
    }

    public final boolean b() {
        return !this.f76848a.isEmpty();
    }

    public final boolean c(Object... objArr) {
        for (int i3 = 0; i3 < 2; i3++) {
            if (this.f76848a.contains(objArr[i3])) {
                return true;
            }
        }
        return false;
    }

    protected abstract void d();

    protected abstract void e();
}
