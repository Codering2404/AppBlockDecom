package com.google.android.libraries.places.internal;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface zzcfg extends WritableByteChannel, zzcft {
    zzcfg C1(int i3);

    zzcfg X1(int i3);

    @Override // com.google.android.libraries.places.internal.zzcft, java.io.Flushable
    void flush();

    zzcfg n1(byte[] bArr);

    zzcfg v1(int i3);

    zzcfg zzH(String str);
}
