package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhzx implements zzhzy {
    private final zziah zza;

    @Override // com.google.android.gms.internal.ads.zzhzy
    public final Object zza(String str) throws GeneralSecurityException {
        Iterator it = zzhzz.zza("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return this.zza.zza(str, (Provider) it.next());
            } catch (Exception e3) {
                if (exc == null) {
                    exc = e3;
                }
            }
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
