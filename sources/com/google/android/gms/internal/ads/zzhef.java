package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhef {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzhee zza(String str) throws GeneralSecurityException {
        for (zzhee zzheeVar : zza) {
            if (zzheeVar.zza()) {
                return zzheeVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
