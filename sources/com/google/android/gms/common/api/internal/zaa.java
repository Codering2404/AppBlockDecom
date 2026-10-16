package com.google.android.gms.common.api.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaa extends LifecycleCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f71623a;

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void onStop() {
        List list;
        synchronized (this) {
            list = this.f71623a;
            this.f71623a = new ArrayList();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }
}
