package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbpb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcag f76580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbug f76581b = zzbuh.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbug f76582c = zzbuh.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbug f76583d = zzbuh.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f76584e;

    zzbpb(zzcag zzcagVar) {
        this.f76580a = zzcagVar;
    }

    public final void a() {
        this.f76581b.zza(1L);
        this.f76584e = this.f76580a.zza();
    }

    public final void b(boolean z2) {
        if (z2) {
            this.f76582c.zza(1L);
        } else {
            this.f76583d.zza(1L);
        }
    }
}
