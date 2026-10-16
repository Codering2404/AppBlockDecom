package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface StreamSegmentEncrypter {
    void a(ByteBuffer byteBuffer, boolean z2, ByteBuffer byteBuffer2);

    void b(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z2, ByteBuffer byteBuffer3);
}
