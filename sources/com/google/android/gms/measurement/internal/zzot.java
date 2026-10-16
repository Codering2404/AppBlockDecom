package com.google.android.gms.measurement.internal;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f74399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f74400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzls f74401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.gms.internal.measurement.zzis f74402d;

    zzot(String str, Map map, zzls zzlsVar, com.google.android.gms.internal.measurement.zzis zzisVar) {
        this.f74399a = str;
        this.f74400b = map;
        this.f74401c = zzlsVar;
        this.f74402d = zzisVar;
    }

    public final String a() {
        return this.f74399a;
    }

    public final Map b() {
        Map map = this.f74400b;
        return map == null ? Collections.EMPTY_MAP : map;
    }

    public final zzls c() {
        return this.f74401c;
    }

    public final com.google.android.gms.internal.measurement.zzis d() {
        return this.f74402d;
    }
}
