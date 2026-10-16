package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzatx extends zzbiw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbiw f75894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzsd f75895b = zzsd.a();

    public zzatx(zzbiw zzbiwVar) {
        this.f75894a = zzbiwVar;
    }

    private final void h(Runnable runnable) {
        Preconditions.t(zzsg.f78546a);
        if (zzrh.e()) {
            runnable.run();
        } else {
            zzsd.b(this.f75895b, runnable).run();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void a(final zzbmg zzbmgVar) {
        h(new Runnable() { // from class: com.google.android.libraries.places.internal.zzatw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75892a.e(zzbmgVar);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void b(final Object obj) {
        h(new Runnable() { // from class: com.google.android.libraries.places.internal.zzatu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75887a.f(obj);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void c(final zzbnp zzbnpVar, final zzbmg zzbmgVar) {
        h(new Runnable() { // from class: com.google.android.libraries.places.internal.zzatv
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f75889a.g(zzbnpVar, zzbmgVar);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzbiw
    public final void d() {
        final zzbiw zzbiwVar = this.f75894a;
        Objects.requireNonNull(zzbiwVar);
        h(new Runnable() { // from class: com.google.android.libraries.places.internal.zzatt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzbiwVar.d();
            }
        });
    }

    final /* synthetic */ void e(zzbmg zzbmgVar) {
        this.f75894a.a(zzbmgVar);
    }

    final /* synthetic */ void f(Object obj) {
        this.f75894a.b(obj);
    }

    final /* synthetic */ void g(zzbnp zzbnpVar, zzbmg zzbmgVar) {
        this.f75894a.c(zzbnpVar, zzbmgVar);
    }
}
