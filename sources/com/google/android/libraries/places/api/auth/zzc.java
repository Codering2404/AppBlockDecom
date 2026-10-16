package com.google.android.libraries.places.api.auth;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzc extends zza {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f74904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f74905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f74906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte f74907d;

    zzc() {
    }

    @Override // com.google.android.libraries.places.api.auth.zza
    public final zza a(boolean z2) {
        this.f74904a = z2;
        this.f74907d = (byte) 1;
        return this;
    }

    @Override // com.google.android.libraries.places.api.auth.zza
    public final zza b(String str) {
        this.f74905b = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.auth.zza
    public final zza c(String str) {
        this.f74906c = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.auth.zza
    public final zzb d() {
        if (this.f74907d == 1) {
            return new zzd(this.f74904a, this.f74905b, this.f74906c, null);
        }
        throw new IllegalStateException("Missing required properties: appCheckEnabled");
    }
}
