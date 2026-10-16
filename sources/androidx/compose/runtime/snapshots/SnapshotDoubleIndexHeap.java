package androidx.compose.runtime.snapshots;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SnapshotDoubleIndexHeap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f24926b = SnapshotId_jvmKt.b(16);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f24927c = new int[16];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f24928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f24929e;

    public SnapshotDoubleIndexHeap() {
        int[] iArr = new int[16];
        int i3 = 0;
        while (i3 < 16) {
            int i4 = i3 + 1;
            iArr[i3] = i4;
            i3 = i4;
        }
        this.f24928d = iArr;
    }

    private final int b() {
        int length = this.f24928d.length;
        if (this.f24929e >= length) {
            int i3 = length * 2;
            int[] iArr = new int[i3];
            int i4 = 0;
            while (i4 < i3) {
                int i5 = i4 + 1;
                iArr[i4] = i5;
                i4 = i5;
            }
            ArraysKt.copyInto$default(this.f24928d, iArr, 0, 0, 0, 14, (Object) null);
            this.f24928d = iArr;
        }
        int i6 = this.f24929e;
        this.f24929e = this.f24928d[i6];
        return i6;
    }

    private final void c(int i3) {
        int length = this.f24926b.length;
        if (i3 <= length) {
            return;
        }
        int i4 = length * 2;
        long[] jArrB = SnapshotId_jvmKt.b(i4);
        int[] iArr = new int[i4];
        ArraysKt.copyInto$default(this.f24926b, jArrB, 0, 0, 0, 12, (Object) null);
        ArraysKt.copyInto$default(this.f24927c, iArr, 0, 0, 0, 14, (Object) null);
        this.f24926b = jArrB;
        this.f24927c = iArr;
    }

    private final void d(int i3) {
        this.f24928d[i3] = this.f24929e;
        this.f24929e = i3;
    }

    private final void g(int i3) {
        long[] jArr = this.f24926b;
        int i4 = this.f24925a >> 1;
        while (i3 < i4) {
            int i5 = (i3 + 1) << 1;
            int i6 = i5 - 1;
            if (i5 < this.f24925a) {
                long j3 = jArr[i5];
                if (j3 < jArr[i6]) {
                    if (j3 >= jArr[i3]) {
                        return;
                    }
                    i(i5, i3);
                    i3 = i5;
                }
            }
            if (jArr[i6] >= jArr[i3]) {
                return;
            }
            i(i6, i3);
            i3 = i6;
        }
    }

    private final void h(int i3) {
        long[] jArr = this.f24926b;
        long j3 = jArr[i3];
        while (i3 > 0) {
            int i4 = ((i3 + 1) >> 1) - 1;
            if (jArr[i4] <= j3) {
                return;
            }
            i(i4, i3);
            i3 = i4;
        }
    }

    private final void i(int i3, int i4) {
        long[] jArr = this.f24926b;
        int[] iArr = this.f24927c;
        int[] iArr2 = this.f24928d;
        long j3 = jArr[i3];
        jArr[i3] = jArr[i4];
        jArr[i4] = j3;
        int i5 = iArr[i3];
        int i6 = iArr[i4];
        iArr[i3] = i6;
        iArr[i4] = i5;
        iArr2[i6] = i3;
        iArr2[i5] = i4;
    }

    public final int a(long j3) {
        c(this.f24925a + 1);
        int i3 = this.f24925a;
        this.f24925a = i3 + 1;
        int iB = b();
        this.f24926b[i3] = j3;
        this.f24927c[i3] = iB;
        this.f24928d[iB] = i3;
        h(i3);
        return iB;
    }

    public final long e(long j3) {
        return this.f24925a > 0 ? this.f24926b[0] : j3;
    }

    public final void f(int i3) {
        int i4 = this.f24928d[i3];
        i(i4, this.f24925a - 1);
        this.f24925a--;
        h(i4);
        g(i4);
        d(i3);
    }
}
