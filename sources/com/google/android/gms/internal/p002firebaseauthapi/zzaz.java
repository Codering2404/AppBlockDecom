package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaz implements zzbv {
    private final InputStream zza;

    private zzaz(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzbv zza(byte[] bArr) {
        return new zzaz(new ByteArrayInputStream(bArr));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbv
    public final zzxh zzb() throws IOException {
        try {
            return zzxh.zza(this.zza, zzaku.zza());
        } finally {
            this.zza.close();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbv
    public final zzvv zza() throws IOException {
        try {
            return zzvv.zza(this.zza, zzaku.zza());
        } finally {
            this.zza.close();
        }
    }
}
