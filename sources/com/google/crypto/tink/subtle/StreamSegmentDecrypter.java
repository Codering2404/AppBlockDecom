package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface StreamSegmentDecrypter {
    void a(ByteBuffer byteBuffer, byte[] bArr);

    void b(ByteBuffer byteBuffer, int i3, boolean z2, ByteBuffer byteBuffer2);
}
