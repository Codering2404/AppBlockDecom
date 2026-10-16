package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhms {
    public static final zziaz zza = zziaz.zza(new byte[0]);

    public static final zziaz zza(int i3) {
        return zziaz.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(i3).array());
    }

    public static final zziaz zzb(int i3) {
        return zziaz.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(i3).array());
    }
}
