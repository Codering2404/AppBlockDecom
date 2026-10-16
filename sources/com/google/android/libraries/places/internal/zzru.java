package com.google.android.libraries.places.internal;

import android.os.Trace;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzru {
    static void a(zzrv zzrvVar) {
        c(zzrvVar);
        Trace.beginSection(zzrvVar.zzd());
        String strZze = zzrvVar.zze();
        zzqs zzqsVar = zzrh.f78506b;
        if (strZze.length() > 127) {
            strZze = strZze.substring(0, 127);
        }
        Trace.beginSection(strZze);
    }

    static void b(zzrv zzrvVar) {
        c(zzrvVar);
        Trace.endSection();
        Trace.endSection();
    }

    private static boolean c(zzrv zzrvVar) {
        return zzrvVar.zza() != Thread.currentThread();
    }
}
