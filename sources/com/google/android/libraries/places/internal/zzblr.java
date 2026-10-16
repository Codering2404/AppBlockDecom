package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzblr extends zzble {
    static {
        zzbms.a(new zzblq());
    }

    public abstract boolean b();

    public abstract int c();

    public abstract String d();

    public zzbms e(Map map) {
        throw null;
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final String toString() {
        return MoreObjects.c(this).d("policy", d()).b("priority", 5).e("available", true).toString();
    }
}
