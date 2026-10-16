package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzo<JcePrimitiveT> implements zzzn<JcePrimitiveT> {
    private final zzzp<JcePrimitiveT> zza;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzzn
    public final JcePrimitiveT zza(String str) throws GeneralSecurityException {
        Iterator<Provider> it = zzzj.zza("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return this.zza.zza(str, it.next());
            } catch (Exception e3) {
                if (exc == null) {
                    exc = e3;
                }
            }
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }

    private zzzo(zzzp<JcePrimitiveT> zzzpVar) {
        this.zza = zzzpVar;
    }
}
