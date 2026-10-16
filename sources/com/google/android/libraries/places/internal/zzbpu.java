package com.google.android.libraries.places.internal;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbpu implements zzbpw {
    zzbpu() {
    }

    @Override // com.google.android.libraries.places.internal.zzbpx
    public final /* bridge */ /* synthetic */ int a(zzbxo zzbxoVar, int i3, Object obj, int i4) {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(byteBuffer.position() + i3);
        zzbxoVar.M0(byteBuffer);
        byteBuffer.limit(iLimit);
        return 0;
    }
}
