package com.google.android.libraries.places.internal;

import java.util.IdentityHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbim {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbio f76245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IdentityHashMap f76246b;

    /* synthetic */ zzbim(zzbio zzbioVar, byte[] bArr) {
        this.f76245a = zzbioVar;
    }

    private final IdentityHashMap d(int i3) {
        if (this.f76246b == null) {
            IdentityHashMap identityHashMap = new IdentityHashMap(this.f76245a.d().size() + i3);
            this.f76246b = identityHashMap;
            identityHashMap.putAll(this.f76245a.d());
            this.f76245a = null;
        }
        return this.f76246b;
    }

    public final zzbim a(zzbin zzbinVar, Object obj) {
        d(1).put(zzbinVar, obj);
        return this;
    }

    public final zzbim b(zzbin zzbinVar) {
        zzbio zzbioVar = this.f76245a;
        if (zzbioVar == null) {
            this.f76246b.remove(zzbinVar);
            return this;
        }
        if (zzbioVar.d().containsKey(zzbinVar)) {
            d(0).remove(zzbinVar);
        }
        return this;
    }

    public final zzbio c() {
        if (this.f76246b != null) {
            this.f76245a = new zzbio(this.f76246b, null);
            this.f76246b = null;
        }
        return this.f76245a;
    }
}
