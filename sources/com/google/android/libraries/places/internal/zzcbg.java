package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbg extends zzbog {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final zzcff f77398q = new zzcff();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbml f77399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f77400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzcaa f77401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f77402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zzcbf f77403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final zzcbe f77404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final zzbio f77405o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f77406p;

    zzcbg(zzbml zzbmlVar, zzbmg zzbmgVar, zzcav zzcavVar, zzcbp zzcbpVar, zzccd zzccdVar, Object obj, int i3, int i4, String str, String str2, zzcaa zzcaaVar, zzcal zzcalVar, zzbis zzbisVar, boolean z2) {
        super(new zzcby(), zzcaaVar, zzcalVar, zzbmgVar, zzbisVar, false);
        this.f77404n = new zzcbe(this);
        this.f77406p = false;
        this.f77401k = (zzcaa) Preconditions.u(zzcaaVar, "statsTraceCtx");
        this.f77399i = zzbmlVar;
        this.f77402l = str;
        this.f77400j = str2;
        this.f77405o = zzcbpVar.zzf();
        this.f77403m = new zzcbf(this, i3, zzcaaVar, obj, zzcavVar, zzccdVar, zzcbpVar, i4, zzbmlVar.b(), zzbisVar);
    }

    final /* synthetic */ zzcbf A() {
        return this.f77403m;
    }

    protected final zzcbf B() {
        return this.f77403m;
    }

    public final zzbmj C() {
        return this.f77399i.a();
    }

    @Override // com.google.android.libraries.places.internal.zzbog, com.google.android.libraries.places.internal.zzbok
    protected final /* synthetic */ zzboj j() {
        return this.f77403m;
    }

    @Override // com.google.android.libraries.places.internal.zzbog
    protected final /* synthetic */ zzbof m() {
        return this.f77403m;
    }

    @Override // com.google.android.libraries.places.internal.zzbog
    protected final /* synthetic */ zzbod n() {
        return this.f77404n;
    }

    final boolean r() {
        return false;
    }

    final /* synthetic */ zzbml w() {
        return this.f77399i;
    }

    final /* synthetic */ String x() {
        return this.f77400j;
    }

    final /* synthetic */ zzcaa y() {
        return this.f77401k;
    }

    final /* synthetic */ String z() {
        return this.f77402l;
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final zzbio zzam() {
        return this.f77405o;
    }
}
