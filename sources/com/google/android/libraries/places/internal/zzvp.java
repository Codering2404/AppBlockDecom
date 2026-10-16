package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzvp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzwx f78694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f78695b;

    public final zzwx a() {
        return this.f78694a;
    }

    public final String b() {
        return this.f78695b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzvp) {
            zzvp zzvpVar = (zzvp) obj;
            if (this.f78694a.equals(zzvpVar.f78694a) && this.f78695b.equals(zzvpVar.f78695b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f78695b;
        return str.hashCode() ^ this.f78694a.hashCode();
    }
}
