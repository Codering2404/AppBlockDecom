package com.google.crypto.tink.subtle;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesGcmHkdfStreaming extends NonceBasedStreamingAead {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f87362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f87363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f87364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f87365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f87366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f87367f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AesGcmHkdfStreamDecrypter implements StreamSegmentDecrypter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SecretKeySpec f87368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Cipher f87369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f87370c;

        AesGcmHkdfStreamDecrypter() {
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void a(ByteBuffer byteBuffer, byte[] bArr) {
            if (byteBuffer.remaining() != AesGcmHkdfStreaming.this.g()) {
                throw new InvalidAlgorithmParameterException("Invalid header length");
            }
            if (byteBuffer.get() != AesGcmHkdfStreaming.this.g()) {
                throw new GeneralSecurityException("Invalid ciphertext");
            }
            this.f87370c = new byte[7];
            byte[] bArr2 = new byte[AesGcmHkdfStreaming.this.f87362a];
            byteBuffer.get(bArr2);
            byteBuffer.get(this.f87370c);
            this.f87368a = AesGcmHkdfStreaming.this.o(bArr2, bArr);
            this.f87369b = AesGcmHkdfStreaming.n();
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void b(ByteBuffer byteBuffer, int i3, boolean z2, ByteBuffer byteBuffer2) {
            this.f87369b.init(2, this.f87368a, AesGcmHkdfStreaming.q(this.f87370c, i3, z2));
            this.f87369b.doFinal(byteBuffer, byteBuffer2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AesGcmHkdfStreamEncrypter implements StreamSegmentEncrypter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SecretKeySpec f87372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Cipher f87373b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f87374c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f87375d;

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void a(ByteBuffer byteBuffer, boolean z2, ByteBuffer byteBuffer2) {
            this.f87373b.init(1, this.f87372a, AesGcmHkdfStreaming.q(this.f87374c, this.f87375d, z2));
            this.f87375d++;
            this.f87373b.doFinal(byteBuffer, byteBuffer2);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void b(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z2, ByteBuffer byteBuffer3) {
            try {
                this.f87373b.init(1, this.f87372a, AesGcmHkdfStreaming.q(this.f87374c, this.f87375d, z2));
                this.f87375d++;
                if (byteBuffer2.hasRemaining()) {
                    this.f87373b.update(byteBuffer, byteBuffer3);
                    this.f87373b.doFinal(byteBuffer2, byteBuffer3);
                } else {
                    this.f87373b.doFinal(byteBuffer, byteBuffer3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher n() {
        return (Cipher) EngineFactory.f87432b.a("AES/GCM/NoPadding");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec o(byte[] bArr, byte[] bArr2) {
        return new SecretKeySpec(Hkdf.a(this.f87366e, this.f87367f, bArr, bArr2, this.f87362a), "AES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GCMParameterSpec q(byte[] bArr, long j3, boolean z2) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(bArr);
        SubtleUtil.b(byteBufferAllocate, j3);
        byteBufferAllocate.put(z2 ? (byte) 1 : (byte) 0);
        return new GCMParameterSpec(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, byteBufferAllocate.array());
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ ReadableByteChannel a(ReadableByteChannel readableByteChannel, byte[] bArr) {
        return super.a(readableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ SeekableByteChannel b(SeekableByteChannel seekableByteChannel, byte[] bArr) {
        return super.b(seekableByteChannel, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead, com.google.crypto.tink.StreamingAead
    public /* bridge */ /* synthetic */ InputStream c(InputStream inputStream, byte[] bArr) {
        return super.c(inputStream, bArr);
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int d() {
        return g() + this.f87365d;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int e() {
        return 16;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int f() {
        return this.f87363b;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int g() {
        return this.f87362a + 8;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int h() {
        return this.f87364c;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public AesGcmHkdfStreamDecrypter i() {
        return new AesGcmHkdfStreamDecrypter();
    }
}
