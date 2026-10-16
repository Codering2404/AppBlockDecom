package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzmv extends zzmx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f78224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f78225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzmy f78226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte f78227d;

    zzmv() {
    }

    @Override // com.google.android.libraries.places.internal.zzmx
    final zzmx a(int i3) {
        this.f78225b = i3;
        this.f78227d = (byte) 1;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzmx
    public final zzmx b(zzmy zzmyVar) {
        if (zzmyVar == null) {
            throw new NullPointerException("Null requestSource");
        }
        this.f78226c = zzmyVar;
        return this;
    }

    @Override // com.google.android.libraries.places.internal.zzmx
    final zzmz c() {
        String str;
        zzmy zzmyVar;
        if (this.f78227d == 1 && (str = this.f78224a) != null && (zzmyVar = this.f78226c) != null) {
            return new zzmw(str, this.f78225b, zzmyVar, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f78224a == null) {
            sb.append(" packageName");
        }
        if (this.f78227d == 0) {
            sb.append(" versionCode");
        }
        if (this.f78226c == null) {
            sb.append(" requestSource");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    final zzmx e(String str) {
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.f78224a = str;
        return this;
    }
}
