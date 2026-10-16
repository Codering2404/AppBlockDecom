package com.google.crypto.tink.subtle;

import com.google.crypto.tink.StreamingAead;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class NonceBasedStreamingAead implements StreamingAead {
    @Override // com.google.crypto.tink.StreamingAead
    public ReadableByteChannel a(ReadableByteChannel readableByteChannel, byte[] bArr) {
        return new StreamingAeadDecryptingChannel(this, readableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public SeekableByteChannel b(SeekableByteChannel seekableByteChannel, byte[] bArr) {
        return new StreamingAeadSeekableDecryptingChannel(this, seekableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public InputStream c(InputStream inputStream, byte[] bArr) {
        return new StreamingAeadDecryptingStream(this, inputStream, bArr);
    }

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract StreamSegmentDecrypter i();
}
