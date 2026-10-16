package kotlin.io.encoding;

import androidx.glance.session.ecY.lisODU;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class EncodeOutputStream extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputStream f140017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Base64 f140018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f140019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f140020d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f140021f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f140022g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f140023h;

    private final void a() throws IOException {
        if (this.f140019c) {
            throw new IOException("The output stream is closed.");
        }
    }

    private final int b(byte[] bArr, int i3, int i4) {
        int iMin = Math.min(3 - this.f140023h, i4 - i3);
        ArraysKt.copyInto(bArr, this.f140022g, this.f140023h, i3, i3 + iMin);
        int i5 = this.f140023h + iMin;
        this.f140023h = i5;
        if (i5 == 3) {
            c();
        }
        return iMin;
    }

    private final void c() {
        if (f(this.f140022g, 0, this.f140023h) != 4) {
            throw new IllegalStateException("Check failed.");
        }
        this.f140023h = 0;
    }

    private final int f(byte[] bArr, int i3, int i4) throws IOException {
        int iH = this.f140018b.h(bArr, this.f140021f, 0, i3, i4);
        if (this.f140020d == 0) {
            this.f140017a.write(Base64.f139988f.p());
            this.f140020d = this.f140018b.k();
            if (iH > this.f140018b.k()) {
                throw new IllegalStateException("Check failed.");
            }
        }
        this.f140017a.write(this.f140021f, 0, iH);
        this.f140020d -= iH;
        return iH;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f140019c) {
            return;
        }
        this.f140019c = true;
        if (this.f140023h != 0) {
            c();
        }
        this.f140017a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f140017a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        a();
        byte[] bArr = this.f140022g;
        int i4 = this.f140023h;
        int i5 = i4 + 1;
        this.f140023h = i5;
        bArr[i4] = (byte) i3;
        if (i5 == 3) {
            c();
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] source, int i3, int i4) throws IOException {
        int i5;
        Intrinsics.checkNotNullParameter(source, "source");
        a();
        if (i3 < 0 || i4 < 0 || (i5 = i3 + i4) > source.length) {
            throw new IndexOutOfBoundsException("offset: " + i3 + lisODU.kON + i4 + ", source size: " + source.length);
        }
        if (i4 == 0) {
            return;
        }
        int i6 = this.f140023h;
        if (i6 < 3) {
            if (i6 != 0) {
                i3 += b(source, i3, i5);
                if (this.f140023h != 0) {
                    return;
                }
            }
            while (i3 + 3 <= i5) {
                int iMin = Math.min((this.f140018b.m() ? this.f140020d : this.f140021f.length) / 4, (i5 - i3) / 3);
                int i7 = (iMin * 3) + i3;
                if (f(source, i3, i7) != iMin * 4) {
                    throw new IllegalStateException("Check failed.");
                }
                i3 = i7;
            }
            ArraysKt.copyInto(source, this.f140022g, 0, i3, i5);
            this.f140023h = i5 - i3;
            return;
        }
        throw new IllegalStateException("Check failed.");
    }
}
