package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzoz;
import com.google.android.gms.internal.consent_sdk.zzpa;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzpa<MessageType extends zzpa<MessageType, BuilderType>, BuilderType extends zzoz<MessageType, BuilderType>> implements zzrq {
    protected int zza = 0;

    public final void zzE(OutputStream outputStream) throws IOException {
        int iZzn = zzn();
        int i3 = zzpv.zzf;
        if (iZzn > 4096) {
            iZzn = 4096;
        }
        zzpt zzptVar = new zzpt(outputStream, iZzn);
        zzB(zzptVar);
        zzptVar.zzI();
    }

    int zzj(zzsa zzsaVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzrq
    public final zzpm zzk() {
        try {
            int iZzn = zzn();
            zzpm zzpmVar = zzpm.zzb;
            byte[] bArr = new byte[iZzn];
            int i3 = zzpv.zzf;
            zzpr zzprVar = new zzpr(bArr, 0, iZzn);
            zzB(zzprVar);
            if (zzprVar.zzb() == 0) {
                return new zzpk(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e3) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e3);
        }
    }
}
