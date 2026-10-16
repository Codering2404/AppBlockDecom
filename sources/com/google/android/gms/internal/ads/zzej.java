package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzej {
    public static void zza(MediaFormat mediaFormat, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 4);
            sb.append("csd-");
            sb.append(i3);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap((byte[]) list.get(i3)));
        }
    }

    public static void zzb(MediaFormat mediaFormat, String str, int i3) {
        if (i3 != -1) {
            mediaFormat.setInteger(str, i3);
        }
    }
}
