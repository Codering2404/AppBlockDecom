package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class AesCtrHmacStreaming extends NonceBasedStreamingAead {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f87335i = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f87336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f87337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f87338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f87339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f87340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f87341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f87342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f87343h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AesCtrHmacStreamDecrypter implements StreamSegmentDecrypter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SecretKeySpec f87344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SecretKeySpec f87345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Cipher f87346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Mac f87347d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private byte[] f87348e;

        AesCtrHmacStreamDecrypter() {
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void a(ByteBuffer byteBuffer, byte[] bArr) {
            if (byteBuffer.remaining() != AesCtrHmacStreaming.this.g()) {
                throw new InvalidAlgorithmParameterException("Invalid header length");
            }
            if (byteBuffer.get() != AesCtrHmacStreaming.this.g()) {
                throw new GeneralSecurityException("Invalid ciphertext");
            }
            this.f87348e = new byte[7];
            byte[] bArr2 = new byte[AesCtrHmacStreaming.this.f87336a];
            byteBuffer.get(bArr2);
            byteBuffer.get(this.f87348e);
            byte[] bArrT = AesCtrHmacStreaming.this.t(bArr2, bArr);
            this.f87344a = AesCtrHmacStreaming.this.u(bArrT);
            this.f87345b = AesCtrHmacStreaming.this.s(bArrT);
            this.f87346c = AesCtrHmacStreaming.r();
            this.f87347d = AesCtrHmacStreaming.this.v();
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentDecrypter
        public synchronized void b(ByteBuffer byteBuffer, int i3, boolean z2, ByteBuffer byteBuffer2) {
            int iPosition = byteBuffer.position();
            byte[] bArrX = AesCtrHmacStreaming.this.x(this.f87348e, i3, z2);
            int iRemaining = byteBuffer.remaining();
            if (iRemaining < AesCtrHmacStreaming.this.f87338c) {
                throw new GeneralSecurityException("Ciphertext too short");
            }
            int i4 = iPosition + (iRemaining - AesCtrHmacStreaming.this.f87338c);
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.limit(i4);
            ByteBuffer byteBufferDuplicate2 = byteBuffer.duplicate();
            byteBufferDuplicate2.position(i4);
            this.f87347d.init(this.f87345b);
            this.f87347d.update(bArrX);
            this.f87347d.update(byteBufferDuplicate);
            byte[] bArrCopyOf = Arrays.copyOf(this.f87347d.doFinal(), AesCtrHmacStreaming.this.f87338c);
            byte[] bArr = new byte[AesCtrHmacStreaming.this.f87338c];
            byteBufferDuplicate2.get(bArr);
            if (!Bytes.a(bArr, bArrCopyOf)) {
                throw new GeneralSecurityException("Tag mismatch");
            }
            byteBuffer.limit(i4);
            this.f87346c.init(1, this.f87344a, new IvParameterSpec(bArrX));
            this.f87346c.doFinal(byteBuffer, byteBuffer2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AesCtrHmacStreamEncrypter implements StreamSegmentEncrypter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SecretKeySpec f87350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SecretKeySpec f87351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Cipher f87352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Mac f87353d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f87354e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f87355f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ AesCtrHmacStreaming f87356g;

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void a(ByteBuffer byteBuffer, boolean z2, ByteBuffer byteBuffer2) {
            int iPosition = byteBuffer2.position();
            byte[] bArrX = this.f87356g.x(this.f87354e, this.f87355f, z2);
            this.f87352c.init(1, this.f87350a, new IvParameterSpec(bArrX));
            this.f87355f++;
            this.f87352c.doFinal(byteBuffer, byteBuffer2);
            ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
            byteBufferDuplicate.flip();
            byteBufferDuplicate.position(iPosition);
            this.f87353d.init(this.f87351b);
            this.f87353d.update(bArrX);
            this.f87353d.update(byteBufferDuplicate);
            byteBuffer2.put(this.f87353d.doFinal(), 0, this.f87356g.f87338c);
        }

        @Override // com.google.crypto.tink.subtle.StreamSegmentEncrypter
        public synchronized void b(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z2, ByteBuffer byteBuffer3) {
            int iPosition = byteBuffer3.position();
            byte[] bArrX = this.f87356g.x(this.f87354e, this.f87355f, z2);
            this.f87352c.init(1, this.f87350a, new IvParameterSpec(bArrX));
            this.f87355f++;
            this.f87352c.update(byteBuffer, byteBuffer3);
            this.f87352c.doFinal(byteBuffer2, byteBuffer3);
            ByteBuffer byteBufferDuplicate = byteBuffer3.duplicate();
            byteBufferDuplicate.flip();
            byteBufferDuplicate.position(iPosition);
            this.f87353d.init(this.f87351b);
            this.f87353d.update(bArrX);
            this.f87353d.update(byteBufferDuplicate);
            byteBuffer3.put(this.f87353d.doFinal(), 0, this.f87356g.f87338c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher r() {
        return (Cipher) EngineFactory.f87432b.a("AES/CTR/NoPadding");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec s(byte[] bArr) {
        return new SecretKeySpec(bArr, this.f87336a, 32, this.f87337b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] t(byte[] bArr, byte[] bArr2) {
        return Hkdf.a(this.f87342g, this.f87343h, bArr, bArr2, this.f87336a + 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec u(byte[] bArr) {
        return new SecretKeySpec(bArr, 0, this.f87336a, "AES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mac v() {
        return (Mac) EngineFactory.f87433c.a(this.f87337b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] x(byte[] bArr, long j3, boolean z2) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(bArr);
        SubtleUtil.b(byteBufferAllocate, j3);
        byteBufferAllocate.put(z2 ? (byte) 1 : (byte) 0);
        byteBufferAllocate.putInt(0);
        return byteBufferAllocate.array();
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
        return g() + this.f87341f;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int e() {
        return this.f87338c;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int f() {
        return this.f87339d;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int g() {
        return this.f87336a + 8;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    public int h() {
        return this.f87340e;
    }

    @Override // com.google.crypto.tink.subtle.NonceBasedStreamingAead
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public AesCtrHmacStreamDecrypter i() {
        return new AesCtrHmacStreamDecrypter();
    }
}
