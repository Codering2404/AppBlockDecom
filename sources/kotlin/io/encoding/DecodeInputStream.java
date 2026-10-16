package kotlin.io.encoding;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

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
final class DecodeInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f140008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Base64 f140009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f140010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f140011d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f140012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f140013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f140014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f140015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f140016j;

    private final void a(byte[] bArr, int i3, int i4) {
        byte[] bArr2 = this.f140014h;
        int i5 = this.f140015i;
        ArraysKt.copyInto(bArr2, bArr, i3, i5, i5 + i4);
        this.f140015i += i4;
        j();
    }

    private final int b(byte[] bArr, int i3, int i4, int i5) {
        int i6 = this.f140016j;
        this.f140016j = i6 + this.f140009b.f(this.f140013g, this.f140014h, i6, 0, i5);
        int iMin = Math.min(c(), i4 - i3);
        a(bArr, i3, iMin);
        k();
        return iMin;
    }

    private final int c() {
        return this.f140016j - this.f140015i;
    }

    private final int f(int i3) throws IOException {
        this.f140013g[i3] = 61;
        if ((i3 & 3) != 2) {
            return i3 + 1;
        }
        int i4 = i();
        if (i4 >= 0) {
            this.f140013g[i3 + 1] = (byte) i4;
        }
        return i3 + 2;
    }

    private final int i() throws IOException {
        int i3;
        if (!this.f140009b.m()) {
            return this.f140008a.read();
        }
        do {
            i3 = this.f140008a.read();
            if (i3 == -1) {
                break;
            }
        } while (!Base64Kt.e(i3));
        return i3;
    }

    private final void j() {
        if (this.f140015i == this.f140016j) {
            this.f140015i = 0;
            this.f140016j = 0;
        }
    }

    private final void k() {
        byte[] bArr = this.f140014h;
        int length = bArr.length;
        int i3 = this.f140016j;
        if ((this.f140013g.length / 4) * 3 > length - i3) {
            ArraysKt.copyInto(bArr, bArr, 0, this.f140015i, i3);
            this.f140016j -= this.f140015i;
            this.f140015i = 0;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f140010c) {
            return;
        }
        this.f140010c = true;
        this.f140008a.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i3 = this.f140015i;
        if (i3 < this.f140016j) {
            int i4 = this.f140014h[i3] & 255;
            this.f140015i = i3 + 1;
            j();
            return i4;
        }
        int i5 = read(this.f140012f, 0, 1);
        if (i5 == -1) {
            return -1;
        }
        if (i5 == 1) {
            return this.f140012f[0] & 255;
        }
        throw new IllegalStateException("Unreachable");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:
    
        if (r3 != r11) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
    
        if (r4 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        return r3 - r11;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(byte[] r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "destination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            if (r11 < 0) goto L86
            if (r12 < 0) goto L86
            int r0 = r11 + r12
            int r1 = r10.length
            if (r0 > r1) goto L86
            boolean r1 = r9.f140010c
            if (r1 != 0) goto L7e
            boolean r1 = r9.f140011d
            r2 = -1
            if (r1 == 0) goto L18
            return r2
        L18:
            r1 = 0
            if (r12 != 0) goto L1c
            return r1
        L1c:
            int r3 = r9.c()
            if (r3 < r12) goto L26
            r9.a(r10, r11, r12)
            return r12
        L26:
            int r3 = r9.c()
            int r12 = r12 - r3
            int r12 = r12 + 2
            int r12 = r12 / 3
            int r12 = r12 * 4
            r3 = r11
        L32:
            boolean r4 = r9.f140011d
            if (r4 != 0) goto L77
            if (r12 <= 0) goto L77
            byte[] r4 = r9.f140013g
            int r4 = r4.length
            int r4 = java.lang.Math.min(r4, r12)
            r5 = r1
        L40:
            boolean r6 = r9.f140011d
            if (r6 != 0) goto L63
            if (r5 >= r4) goto L63
            int r6 = r9.i()
            r7 = 1
            if (r6 == r2) goto L60
            r8 = 61
            if (r6 == r8) goto L59
            byte[] r7 = r9.f140013g
            byte r6 = (byte) r6
            r7[r5] = r6
            int r5 = r5 + 1
            goto L40
        L59:
            int r5 = r9.f(r5)
            r9.f140011d = r7
            goto L40
        L60:
            r9.f140011d = r7
            goto L40
        L63:
            if (r6 != 0) goto L70
            if (r5 != r4) goto L68
            goto L70
        L68:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Check failed."
            r10.<init>(r11)
            throw r10
        L70:
            int r12 = r12 - r5
            int r4 = r9.b(r10, r3, r0, r5)
            int r3 = r3 + r4
            goto L32
        L77:
            if (r3 != r11) goto L7c
            if (r4 == 0) goto L7c
            return r2
        L7c:
            int r3 = r3 - r11
            return r3
        L7e:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "The input stream is closed."
            r10.<init>(r11)
            throw r10
        L86:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "offset: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = ", length: "
            r1.append(r11)
            r1.append(r12)
            java.lang.String r11 = ", buffer size: "
            r1.append(r11)
            int r10 = r10.length
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.encoding.DecodeInputStream.read(byte[], int, int):int");
    }
}
