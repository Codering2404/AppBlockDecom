package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ReaderInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Reader f85281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharsetEncoder f85282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f85283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CharBuffer f85284d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteBuffer f85285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f85286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f85287h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f85288i;

    /* JADX WARN: Illegal instructions before constructor call */
    ReaderInputStream(Reader reader, Charset charset, int i3) {
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        this(reader, charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction), i3);
    }

    private static int a(Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    private int b(byte[] bArr, int i3, int i4) {
        int iMin = Math.min(i4, this.f85285f.remaining());
        this.f85285f.get(bArr, i3, iMin);
        return iMin;
    }

    private static CharBuffer c(CharBuffer charBuffer) {
        CharBuffer charBufferWrap = CharBuffer.wrap(Arrays.copyOf(charBuffer.array(), charBuffer.capacity() * 2));
        Java8Compatibility.d(charBufferWrap, charBuffer.position());
        Java8Compatibility.c(charBufferWrap, charBuffer.limit());
        return charBufferWrap;
    }

    private void f() throws IOException {
        if (a(this.f85284d) == 0) {
            if (this.f85284d.position() > 0) {
                Java8Compatibility.b(this.f85284d.compact());
            } else {
                this.f85284d = c(this.f85284d);
            }
        }
        int iLimit = this.f85284d.limit();
        int i3 = this.f85281a.read(this.f85284d.array(), iLimit, a(this.f85284d));
        if (i3 == -1) {
            this.f85286g = true;
        } else {
            Java8Compatibility.c(this.f85284d, iLimit + i3);
        }
    }

    private void i(boolean z2) {
        Java8Compatibility.b(this.f85285f);
        if (z2 && this.f85285f.remaining() == 0) {
            this.f85285f = ByteBuffer.allocate(this.f85285f.capacity() * 2);
        } else {
            this.f85287h = true;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f85281a.close();
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f85283c) == 1) {
            return UnsignedBytes.d(this.f85283c[0]);
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (r2 <= 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        return -1;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r8, int r9, int r10) throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r9 + r10
            int r1 = r8.length
            com.google.common.base.Preconditions.y(r9, r0, r1)
            r0 = 0
            if (r10 != 0) goto La
            return r0
        La:
            boolean r1 = r7.f85286g
            r2 = r0
        Ld:
            boolean r3 = r7.f85287h
            if (r3 == 0) goto L2e
            int r3 = r9 + r2
            int r4 = r10 - r2
            int r3 = r7.b(r8, r3, r4)
            int r2 = r2 + r3
            if (r2 == r10) goto L29
            boolean r3 = r7.f85288i
            if (r3 == 0) goto L21
            goto L29
        L21:
            r7.f85287h = r0
            java.nio.ByteBuffer r3 = r7.f85285f
            com.google.common.io.Java8Compatibility.a(r3)
            goto L2e
        L29:
            if (r2 <= 0) goto L2c
            return r2
        L2c:
            r8 = -1
            return r8
        L2e:
            boolean r3 = r7.f85288i
            if (r3 == 0) goto L35
            java.nio.charset.CoderResult r3 = java.nio.charset.CoderResult.UNDERFLOW
            goto L4c
        L35:
            if (r1 == 0) goto L40
            java.nio.charset.CharsetEncoder r3 = r7.f85282b
            java.nio.ByteBuffer r4 = r7.f85285f
            java.nio.charset.CoderResult r3 = r3.flush(r4)
            goto L4c
        L40:
            java.nio.charset.CharsetEncoder r3 = r7.f85282b
            java.nio.CharBuffer r4 = r7.f85284d
            java.nio.ByteBuffer r5 = r7.f85285f
            boolean r6 = r7.f85286g
            java.nio.charset.CoderResult r3 = r3.encode(r4, r5, r6)
        L4c:
            boolean r4 = r3.isOverflow()
            r5 = 1
            if (r4 == 0) goto L57
            r7.i(r5)
            goto Ld
        L57:
            boolean r4 = r3.isUnderflow()
            if (r4 == 0) goto L6f
            if (r1 == 0) goto L65
            r7.f85288i = r5
            r7.i(r0)
            goto Ld
        L65:
            boolean r3 = r7.f85286g
            if (r3 == 0) goto L6b
            r1 = r5
            goto L2e
        L6b:
            r7.f()
            goto L2e
        L6f:
            boolean r4 = r3.isError()
            if (r4 == 0) goto L2e
            r3.throwException()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.ReaderInputStream.read(byte[], int, int):int");
    }

    ReaderInputStream(Reader reader, CharsetEncoder charsetEncoder, int i3) {
        this.f85283c = new byte[1];
        this.f85281a = (Reader) Preconditions.t(reader);
        this.f85282b = (CharsetEncoder) Preconditions.t(charsetEncoder);
        Preconditions.h(i3 > 0, "bufferSize must be positive: %s", i3);
        charsetEncoder.reset();
        CharBuffer charBufferAllocate = CharBuffer.allocate(i3);
        this.f85284d = charBufferAllocate;
        Java8Compatibility.b(charBufferAllocate);
        this.f85285f = ByteBuffer.allocate(i3);
    }
}
