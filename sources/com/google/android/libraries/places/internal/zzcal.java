package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcal {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final zzcaj f77335h = new zzcaj(zzcag.f77331a);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcag f77336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f77337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f77338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f77339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f77340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbug f77341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile long f77342g;

    public zzcal() {
        this.f77341f = zzbuh.a();
        this.f77336a = zzcag.f77331a;
    }

    public static zzcaj e() {
        return f77335h;
    }

    public final void a() {
        this.f77337b++;
        this.f77336a.zza();
    }

    public final void b(boolean z2) {
        if (z2) {
            this.f77338c++;
        } else {
            this.f77339d++;
        }
    }

    public final void c(int i3) {
        if (i3 == 0) {
            return;
        }
        this.f77340e += (long) i3;
        this.f77336a.zza();
    }

    public final void d() {
        this.f77341f.zza(1L);
        this.f77342g = this.f77336a.zza();
    }

    /* synthetic */ zzcal(zzcag zzcagVar, byte[] bArr) {
        this.f77341f = zzbuh.a();
        this.f77336a = zzcagVar;
    }
}
