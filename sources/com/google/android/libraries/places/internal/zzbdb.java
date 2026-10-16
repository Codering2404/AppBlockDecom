package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbdb {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final zzbdb f76041b = new zzbdb(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f76042a;

    zzbdb() {
        this.f76042a = new HashMap();
    }

    public static zzbdb a() {
        int i3 = zzbcc.f75986a;
        return f76041b;
    }

    public final zzbdp b(zzbex zzbexVar, int i3) {
        return (zzbdp) this.f76042a.get(new zzbda(zzbexVar, i3));
    }

    zzbdb(boolean z2) {
        this.f76042a = Collections.EMPTY_MAP;
    }
}
