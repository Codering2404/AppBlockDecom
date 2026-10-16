package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.StreamingAead;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class StreamingAeadHelper implements StreamingAead {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    PrimitiveSet f87324a;

    @Override // com.google.crypto.tink.StreamingAead
    public ReadableByteChannel a(ReadableByteChannel readableByteChannel, byte[] bArr) {
        return new ReadableByteChannelDecrypter(this.f87324a, readableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public SeekableByteChannel b(SeekableByteChannel seekableByteChannel, byte[] bArr) {
        return new SeekableByteChannelDecrypter(this.f87324a, seekableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.StreamingAead
    public InputStream c(InputStream inputStream, byte[] bArr) {
        return new InputStreamDecrypter(this.f87324a, inputStream, bArr);
    }
}
