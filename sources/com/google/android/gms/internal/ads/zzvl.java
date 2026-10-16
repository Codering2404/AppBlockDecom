package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzvl extends zzit {
    public final int zza;

    public zzvl(Throwable th, zzvm zzvmVar) {
        super("Decoder failed: ".concat(String.valueOf(zzvmVar == null ? null : zzvmVar.zza)), th);
        boolean z2 = th instanceof MediaCodec.CodecException;
        if (z2) {
            ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.zza = z2 ? ((MediaCodec.CodecException) th).getErrorCode() : 0;
    }
}
