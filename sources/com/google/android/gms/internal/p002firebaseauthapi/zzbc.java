package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbc implements zzby {
    private final OutputStream zza;

    private zzbc(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzby zza(OutputStream outputStream) {
        return new zzbc(outputStream);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzby
    public final void zza(zzvv zzvvVar) throws IOException {
        try {
            ((zzvv) ((zzalf) zzvvVar.zzn().zza().zze())).zza(this.zza);
        } finally {
            this.zza.close();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzby
    public final void zza(zzxh zzxhVar) throws IOException {
        try {
            zzxhVar.zza(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
