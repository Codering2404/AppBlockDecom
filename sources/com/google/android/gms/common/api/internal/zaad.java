package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f71642a = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f71643b = Collections.synchronizedMap(new WeakHashMap());

    private final void h(boolean z2, Status status) {
        HashMap map;
        HashMap map2;
        synchronized (this.f71642a) {
            map = new HashMap(this.f71642a);
        }
        synchronized (this.f71643b) {
            map2 = new HashMap(this.f71643b);
        }
        for (Map.Entry entry : map.entrySet()) {
            if (z2 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).forceFailureUnlessReady(status);
            }
        }
        for (Map.Entry entry2 : map2.entrySet()) {
            if (z2 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).trySetException(new ApiException(status));
            }
        }
    }

    final void c(BasePendingResult basePendingResult, boolean z2) {
        this.f71642a.put(basePendingResult, Boolean.valueOf(z2));
        basePendingResult.addStatusListener(new zaab(this, basePendingResult));
    }

    final void d(TaskCompletionSource taskCompletionSource, boolean z2) {
        this.f71643b.put(taskCompletionSource, Boolean.valueOf(z2));
        taskCompletionSource.getTask().addOnCompleteListener(new zaac(this, taskCompletionSource));
    }

    final void e(int i3, String str) {
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i3 == 1) {
            sb.append(" due to service disconnection.");
        } else if (i3 == 3) {
            sb.append(" due to dead object exception.");
        }
        if (str != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(str);
        }
        h(true, new Status(20, sb.toString()));
    }

    public final void f() {
        h(false, GoogleApiManager.f71561q);
    }

    final boolean g() {
        return (this.f71642a.isEmpty() && this.f71643b.isEmpty()) ? false : true;
    }
}
