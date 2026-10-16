package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzatg extends zzbiw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbiw f75827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f75828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzatk f75829c;

    zzatg(zzatk zzatkVar, zzbiw zzbiwVar) {
        Objects.requireNonNull(zzatkVar);
        this.f75829c = zzatkVar;
        this.f75828b = false;
        this.f75827a = zzbiwVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void a(final zzbmg zzbmgVar) {
        this.f75829c.t().execute(new Runnable() { // from class: com.google.android.libraries.places.internal.zzatf
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75825a.e(zzbmgVar);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void b(final Object obj) {
        this.f75829c.t().execute(new Runnable() { // from class: com.google.android.libraries.places.internal.zzatc
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75819a.f(obj);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void c(final zzbnp zzbnpVar, final zzbmg zzbmgVar) {
        this.f75829c.t().execute(new Runnable() { // from class: com.google.android.libraries.places.internal.zzatd
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75821a.g(zzbnpVar, zzbmgVar);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void d() {
        this.f75829c.t().execute(new Runnable() { // from class: com.google.android.libraries.places.internal.zzate
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75824a.h();
            }
        });
    }

    final /* synthetic */ void e(zzbmg zzbmgVar) {
        if (this.f75828b) {
            return;
        }
        this.f75827a.a(zzbmgVar);
    }

    final /* synthetic */ void f(Object obj) {
        if (this.f75828b) {
            return;
        }
        this.f75827a.b(obj);
    }

    final /* synthetic */ void g(zzbnp zzbnpVar, zzbmg zzbmgVar) {
        if (this.f75828b) {
            return;
        }
        try {
            this.f75827a.c(zzbnpVar, zzbmgVar);
        } finally {
            this.f75828b = true;
            this.f75829c.v().zza();
        }
    }

    final /* synthetic */ void h() {
        if (this.f75828b) {
            return;
        }
        this.f75827a.d();
    }
}
