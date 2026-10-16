package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbsb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbmu f76758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbse f76759b;

    zzbsb(zzbse zzbseVar, zzbmu zzbmuVar) {
        Objects.requireNonNull(zzbseVar);
        this.f76759b = zzbseVar;
        this.f76758a = (zzbmu) Preconditions.u(zzbmuVar, "savedListener");
    }

    final /* synthetic */ void a(IOException iOException) {
        String strH = this.f76759b.h();
        zzbmv zzbmvVarA = zzbmw.a();
        zzbmvVarA.a(zzbnr.b(zzbnp.f76496m.e("Unable to resolve host ".concat(String.valueOf(strH))).d(iOException)));
        this.f76758a.a(zzbmvVarA.c());
    }

    final /* synthetic */ void b(zzbmv zzbmvVar) {
        this.f76758a.a(zzbmvVar.c());
    }

    final /* synthetic */ void c(zzbrv zzbrvVar) {
        zzbnp zzbnpVarA = zzbrvVar.a();
        zzbmv zzbmvVarA = zzbmw.a();
        zzbmvVarA.a(zzbnr.b(zzbnpVarA));
        this.f76758a.a(zzbmvVarA.c());
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ea A[DONT_GENERATE] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbsb.run():void");
    }
}
