package com.google.common.io;

import com.google.common.base.Ascii;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ByteSource {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AsCharSource extends CharSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Charset f85225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ByteSource f85226b;

        @Override // com.google.common.io.CharSource
        public Reader a() {
            return new InputStreamReader(this.f85226b.a(), this.f85225a);
        }

        public String toString() {
            return this.f85226b.toString() + ".asCharSource(" + this.f85225a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ByteArrayByteSource extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final byte[] f85227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f85228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f85229c;

        ByteArrayByteSource(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream a() {
            return new ByteArrayInputStream(this.f85227a, this.f85228b, this.f85229c);
        }

        public String toString() {
            return "ByteSource.wrap(" + Ascii.h(BaseEncoding.a().h(this.f85227a, this.f85228b, this.f85229c), 30, "...") + ")";
        }

        ByteArrayByteSource(byte[] bArr, int i3, int i4) {
            this.f85227a = bArr;
            this.f85228b = i3;
            this.f85229c = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ConcatenatedByteSource extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterable f85230a;

        @Override // com.google.common.io.ByteSource
        public InputStream a() {
            return new MultiInputStream(this.f85230a.iterator());
        }

        public String toString() {
            return "ByteSource.concat(" + this.f85230a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EmptyByteSource extends ByteArrayByteSource {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final EmptyByteSource f85231d = new EmptyByteSource();

        EmptyByteSource() {
            super(new byte[0]);
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource
        public String toString() {
            return "ByteSource.empty()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class SlicedByteSource extends ByteSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f85232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f85233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ByteSource f85234c;

        private InputStream b(InputStream inputStream) throws IOException {
            long j3 = this.f85232a;
            if (j3 > 0) {
                try {
                    if (ByteStreams.i(inputStream, j3) < this.f85232a) {
                        inputStream.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } finally {
                }
            }
            return ByteStreams.d(inputStream, this.f85233b);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream a() {
            return b(this.f85234c.a());
        }

        public String toString() {
            return this.f85234c.toString() + ".slice(" + this.f85232a + ", " + this.f85233b + ")";
        }
    }

    protected ByteSource() {
    }

    public abstract InputStream a();
}
