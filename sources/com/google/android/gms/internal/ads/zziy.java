package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zziy {
    private final Map zza;

    public zziy() {
        this.zza = new HashMap();
    }

    public final zziy zza(String str, int i3) {
        this.zza.put(str, Integer.valueOf(i3));
        return this;
    }

    public final zziy zzb(String str, long j3) {
        this.zza.put(str, Long.valueOf(j3));
        return this;
    }

    public final zziy zzc(String str, float f3) {
        this.zza.put(str, Float.valueOf(f3));
        return this;
    }

    public final zziy zzd(String str, String str2) {
        this.zza.put(str, str2);
        return this;
    }

    public final zziy zze(String str, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            this.zza.put(str, null);
            return this;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        byteBufferAllocate.put(byteBuffer.duplicate());
        byteBufferAllocate.flip();
        this.zza.put(str, byteBufferAllocate);
        return this;
    }

    public final zziy zzf(String str) {
        this.zza.remove(str);
        return this;
    }

    public final zziz zzg() {
        return new zziz(this.zza, null);
    }
}
