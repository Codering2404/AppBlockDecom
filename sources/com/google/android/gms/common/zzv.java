package com.google.android.gms.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f72360a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f72361b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f72362c = null;

    /* synthetic */ zzv(byte[] bArr) {
    }

    final zzv a(String str) {
        this.f72360a = str;
        return this;
    }

    final zzv b(boolean z2) {
        this.f72361b = Boolean.valueOf(z2);
        return this;
    }

    final zzv c(boolean z2) {
        this.f72362c = Boolean.valueOf(z2);
        return this;
    }

    final zzw d() {
        Boolean bool = this.f72361b;
        if (bool == null) {
            throw new IllegalStateException("allowTestKeys must be set");
        }
        if (this.f72362c != null) {
            return new zzw(this.f72360a, bool.booleanValue(), false, false, this.f72362c.booleanValue(), false, null);
        }
        throw new IllegalStateException("isGoogleOrPlatformOnly must be set");
    }
}
