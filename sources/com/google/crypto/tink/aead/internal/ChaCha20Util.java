package com.google.crypto.tink.aead.internal;

import com.facebook.stetho.dumpapp.Framer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ChaCha20Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f86148a = a(new byte[]{101, Framer.EXIT_FRAME_PREFIX, 112, 97, 110, 100, 32, 51, Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 98, 121, 116, 101, 32, 107});

    static int[] a(byte[] bArr) {
        IntBuffer intBufferAsIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        intBufferAsIntBuffer.get(iArr);
        return iArr;
    }
}
