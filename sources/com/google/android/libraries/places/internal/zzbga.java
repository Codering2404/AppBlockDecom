package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbga extends zzbfy {
    zzbga() {
    }

    @Override // com.google.android.libraries.places.internal.zzbfy
    final /* bridge */ /* synthetic */ void a(Object obj, int i3, long j3) {
        ((zzbfz) obj).k(i3 << 3, Long.valueOf(j3));
    }

    @Override // com.google.android.libraries.places.internal.zzbfy
    final /* bridge */ /* synthetic */ void b(Object obj, int i3, int i4) {
        ((zzbfz) obj).k((i3 << 3) | 5, Integer.valueOf(i4));
    }

    @Override // com.google.android.libraries.places.internal.zzbfy
    final /* bridge */ /* synthetic */ void c(Object obj, int i3, long j3) {
        ((zzbfz) obj).k((i3 << 3) | 1, Long.valueOf(j3));
    }

    @Override // com.google.android.libraries.places.internal.zzbfy
    final /* bridge */ /* synthetic */ void d(Object obj, int i3, zzbcl zzbclVar) {
        ((zzbfz) obj).k((i3 << 3) | 2, zzbclVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbfy
    final /* bridge */ /* synthetic */ void e(Object obj, int i3, Object obj2) {
        ((zzbfz) obj).k((i3 << 3) | 3, (zzbfz) obj2);
    }

    @Override // com.google.android.libraries.places.internal.zzbfy
    final /* synthetic */ Object f() {
        return zzbfz.b();
    }

    @Override // com.google.android.libraries.places.internal.zzbfy
    final /* synthetic */ Object g(Object obj) {
        zzbfz zzbfzVar = (zzbfz) obj;
        zzbfzVar.d();
        return zzbfzVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbfy
    final /* bridge */ /* synthetic */ Object h(Object obj) {
        zzbdq zzbdqVar = (zzbdq) obj;
        zzbfz zzbfzVar = zzbdqVar.zzc;
        if (zzbfzVar != zzbfz.a()) {
            return zzbfzVar;
        }
        zzbfz zzbfzVarB = zzbfz.b();
        zzbdqVar.zzc = zzbfzVarB;
        return zzbfzVarB;
    }

    @Override // com.google.android.libraries.places.internal.zzbfy
    final /* synthetic */ void i(Object obj, Object obj2) {
        ((zzbdq) obj).zzc = (zzbfz) obj2;
    }

    @Override // com.google.android.libraries.places.internal.zzbfy
    final void j(Object obj) {
        ((zzbdq) obj).zzc.d();
    }
}
