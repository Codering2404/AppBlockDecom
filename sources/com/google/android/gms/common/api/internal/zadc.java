package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zadc {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Status f71830c = new Status(8, "The connection to Google Play services was lost");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Set f71831a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zadb f71832b = new zadb(this);

    final void a(BasePendingResult basePendingResult) {
        this.f71831a.add(basePendingResult);
        basePendingResult.zan(this.f71832b);
    }

    public final void b() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f71831a.toArray(new BasePendingResult[0])) {
            basePendingResult.zan(null);
            if (basePendingResult.zam()) {
                this.f71831a.remove(basePendingResult);
            }
        }
    }
}
