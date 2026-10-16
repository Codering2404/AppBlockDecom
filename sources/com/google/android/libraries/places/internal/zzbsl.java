package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbsl implements zzbpl {
    zzbsl() {
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public void a(zzbpn zzbpnVar) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void b(zzbjj zzbjjVar) {
        d().b(zzbjjVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void c(zzbnp zzbnpVar) {
        d().c(zzbnpVar);
    }

    protected abstract zzbpl d();

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void e(zzbjy zzbjyVar) {
        d().e(zzbjyVar);
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void f(InputStream inputStream) {
        d().f(inputStream);
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void g(zzbtf zzbtfVar) {
        d().g(zzbtfVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void h(zzbjv zzbjvVar) {
        d().h(zzbjvVar);
    }

    public final String toString() {
        return MoreObjects.c(this).d("delegate", d()).toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzb(int i3) {
        d().zzb(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzc(int i3) {
        d().zzc(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbpl
    public final void zzk() {
        d().zzk();
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final boolean zzm() {
        return d().zzm();
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzr() {
        d().zzr();
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzs(int i3) {
        d().zzs(i3);
    }

    @Override // com.google.android.libraries.places.internal.zzcab
    public final void zzu() {
        d().zzu();
    }
}
