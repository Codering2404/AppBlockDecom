package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu f74088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlj f74089b;

    zzkm(zzlj zzljVar, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.f74088a = zzcuVar;
        Objects.requireNonNull(zzljVar);
        this.f74089b = zzljVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzlj r0 = r8.f74089b
            com.google.android.gms.measurement.internal.zzic r1 = r0.f73997a
            com.google.android.gms.measurement.internal.zzoc r1 = r1.z()
            com.google.android.gms.measurement.internal.zzic r1 = r1.f73997a
            com.google.android.gms.measurement.internal.zzhh r2 = r1.x()
            com.google.android.gms.measurement.internal.zzjl r2 = r2.w()
            com.google.android.gms.measurement.internal.zzjk r3 = com.google.android.gms.measurement.internal.zzjk.ANALYTICS_STORAGE
            boolean r2 = r2.o(r3)
            r3 = 0
            if (r2 != 0) goto L2a
            com.google.android.gms.measurement.internal.zzgu r1 = r1.a()
            com.google.android.gms.measurement.internal.zzgs r1 = r1.t()
            java.lang.String r2 = "Analytics storage consent denied; will not get session id"
            r1.a(r2)
        L28:
            r1 = r3
            goto L5b
        L2a:
            com.google.android.gms.measurement.internal.zzhh r2 = r1.x()
            com.google.android.gms.common.util.Clock r4 = r1.e()
            long r4 = r4.currentTimeMillis()
            boolean r2 = r2.A(r4)
            if (r2 != 0) goto L28
            com.google.android.gms.measurement.internal.zzhh r2 = r1.x()
            com.google.android.gms.measurement.internal.zzhe r2 = r2.f73824r
            long r4 = r2.a()
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L4d
            goto L28
        L4d:
            com.google.android.gms.measurement.internal.zzhh r1 = r1.x()
            com.google.android.gms.measurement.internal.zzhe r1 = r1.f73824r
            long r1 = r1.a()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
        L5b:
            if (r1 == 0) goto L6d
            com.google.android.gms.measurement.internal.zzic r0 = r0.f73997a
            com.google.android.gms.internal.measurement.zzcu r2 = r8.f74088a
            com.google.android.gms.measurement.internal.zzpp r0 = r0.C()
            long r3 = r1.longValue()
            r0.b0(r2, r3)
            return
        L6d:
            com.google.android.gms.internal.measurement.zzcu r0 = r8.f74088a     // Catch: android.os.RemoteException -> L73
            r0.zzb(r3)     // Catch: android.os.RemoteException -> L73
            return
        L73:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzlj r1 = r8.f74089b
            com.google.android.gms.measurement.internal.zzic r1 = r1.f73997a
            com.google.android.gms.measurement.internal.zzgu r1 = r1.a()
            com.google.android.gms.measurement.internal.zzgs r1 = r1.o()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.b(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkm.run():void");
    }
}
