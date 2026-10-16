package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhbb extends zzhaz {
    private zzhbb() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhaz
    final void zza(zzhbc zzhbcVar, Set set, Set set2) {
        synchronized (zzhbcVar) {
            try {
                if (zzhbcVar.seenExceptionsField == null) {
                    zzhbcVar.seenExceptionsField = set2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhaz
    final int zzb(zzhbc zzhbcVar) {
        int i3;
        synchronized (zzhbcVar) {
            i3 = zzhbcVar.remainingField - 1;
            zzhbcVar.remainingField = i3;
        }
        return i3;
    }

    /* synthetic */ zzhbb(byte[] bArr) {
        super(null);
    }
}
