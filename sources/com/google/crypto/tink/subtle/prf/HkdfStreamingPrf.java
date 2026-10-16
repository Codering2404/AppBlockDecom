package com.google.crypto.tink.subtle.prf;

import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
public class HkdfStreamingPrf implements StreamingPrf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Enums.HashType f87545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f87546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f87547c;

    /* JADX INFO: renamed from: com.google.crypto.tink.subtle.prf.HkdfStreamingPrf$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f87548a;

        static {
            int[] iArr = new int[Enums.HashType.values().length];
            f87548a = iArr;
            try {
                iArr[Enums.HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f87548a[Enums.HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f87548a[Enums.HashType.SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f87548a[Enums.HashType.SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(Enums.HashType hashType) throws GeneralSecurityException {
        int i3 = AnonymousClass1.f87548a[hashType.ordinal()];
        if (i3 == 1) {
            return "HmacSha1";
        }
        if (i3 == 2) {
            return "HmacSha256";
        }
        if (i3 == 3) {
            return "HmacSha384";
        }
        if (i3 == 4) {
            return "HmacSha512";
        }
        throw new GeneralSecurityException("No getJavaxHmacName for given hash " + hashType + " known");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class HkdfInputStream extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f87549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Mac f87550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private byte[] f87551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ByteBuffer f87552d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f87553f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ HkdfStreamingPrf f87554g;

        private void a() throws InvalidKeyException, IOException {
            try {
                this.f87550b = (Mac) EngineFactory.f87433c.a(HkdfStreamingPrf.e(this.f87554g.f87545a));
                if (this.f87554g.f87547c == null || this.f87554g.f87547c.length == 0) {
                    this.f87550b.init(new SecretKeySpec(new byte[this.f87550b.getMacLength()], HkdfStreamingPrf.e(this.f87554g.f87545a)));
                } else {
                    this.f87550b.init(new SecretKeySpec(this.f87554g.f87547c, HkdfStreamingPrf.e(this.f87554g.f87545a)));
                }
                this.f87550b.update(this.f87554g.f87546b);
                this.f87551c = this.f87550b.doFinal();
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(0);
                this.f87552d = byteBufferAllocateDirect;
                byteBufferAllocateDirect.mark();
                this.f87553f = 0;
            } catch (GeneralSecurityException e3) {
                throw new IOException("Creating HMac failed", e3);
            }
        }

        private void b() throws InvalidKeyException {
            this.f87550b.init(new SecretKeySpec(this.f87551c, HkdfStreamingPrf.e(this.f87554g.f87545a)));
            this.f87552d.reset();
            this.f87550b.update(this.f87552d);
            this.f87550b.update(this.f87549a);
            int i3 = this.f87553f + 1;
            this.f87553f = i3;
            this.f87550b.update((byte) i3);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f87550b.doFinal());
            this.f87552d = byteBufferWrap;
            byteBufferWrap.mark();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            byte[] bArr = new byte[1];
            int i3 = read(bArr, 0, 1);
            if (i3 == 1) {
                return bArr[0] & 255;
            }
            if (i3 == -1) {
                return i3;
            }
            throw new IOException("Reading failed");
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) throws IOException {
            try {
                if (this.f87553f == -1) {
                    a();
                }
                int i5 = 0;
                while (i5 < i4) {
                    if (!this.f87552d.hasRemaining()) {
                        if (this.f87553f == 255) {
                            break;
                        }
                        b();
                    }
                    int iMin = Math.min(i4 - i5, this.f87552d.remaining());
                    this.f87552d.get(bArr, i3, iMin);
                    i3 += iMin;
                    i5 += iMin;
                }
                return i5;
            } catch (GeneralSecurityException e3) {
                this.f87550b = null;
                throw new IOException("HkdfInputStream failed", e3);
            }
        }
    }
}
