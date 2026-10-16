package com.google.android.libraries.places.internal;

import com.google.common.base.Objects;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbio {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final IdentityHashMap f76248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzbio f76249c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IdentityHashMap f76250a;

    static {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        f76248b = identityHashMap;
        f76249c = new zzbio(identityHashMap);
    }

    private zzbio(IdentityHashMap identityHashMap) {
        this.f76250a = identityHashMap;
    }

    public static zzbim b() {
        return new zzbim(f76249c, null);
    }

    public final Object a(zzbin zzbinVar) {
        return this.f76250a.get(zzbinVar);
    }

    public final zzbim c() {
        return new zzbim(this, null);
    }

    final /* synthetic */ IdentityHashMap d() {
        return this.f76250a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzbio.class != obj.getClass()) {
            return false;
        }
        IdentityHashMap identityHashMap = this.f76250a;
        IdentityHashMap identityHashMap2 = ((zzbio) obj).f76250a;
        if (identityHashMap.size() != identityHashMap2.size()) {
            return false;
        }
        for (Map.Entry entry : identityHashMap.entrySet()) {
            if (!identityHashMap2.containsKey(entry.getKey()) || !Objects.a(entry.getValue(), identityHashMap2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iB = 0;
        for (Map.Entry entry : this.f76250a.entrySet()) {
            iB += Objects.b(entry.getKey(), entry.getValue());
        }
        return iB;
    }

    public final String toString() {
        return this.f76250a.toString();
    }

    /* synthetic */ zzbio(IdentityHashMap identityHashMap, byte[] bArr) {
        this.f76250a = identityHashMap;
    }
}
