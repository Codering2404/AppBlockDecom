package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.Utils_jvmKt;
import androidx.compose.runtime.internal.WeakReference;
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
public final class SnapshotWeakSet<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f25011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f25012b = new int[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference[] f25013c = new WeakReference[16];

    private final int b(Object obj, int i3) {
        int i4 = this.f25011a - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = this.f25012b[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else {
                if (i7 <= i3) {
                    WeakReference weakReference = this.f25013c[i6];
                    return obj == (weakReference != null ? weakReference.get() : null) ? i6 : c(i6, obj, i3);
                }
                i4 = i6 - 1;
            }
        }
        return -(i5 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        r4 = r4 + 1;
        r0 = r3.f25011a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
    
        if (r4 >= r0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0027, code lost:
    
        if (r3.f25012b[r4] == r6) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        return -(r4 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002d, code lost:
    
        r2 = r3.f25013c[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        if (r2 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        r2 = r2.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        if (r2 != r5) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003c, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        r4 = r3.f25011a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int c(int r4, java.lang.Object r5, int r6) {
        /*
            r3 = this;
            int r0 = r4 + (-1)
        L2:
            r1 = 0
            r2 = -1
            if (r2 >= r0) goto L1d
            int[] r2 = r3.f25012b
            r2 = r2[r0]
            if (r2 == r6) goto Ld
            goto L1d
        Ld:
            androidx.compose.runtime.internal.WeakReference[] r2 = r3.f25013c
            r2 = r2[r0]
            if (r2 == 0) goto L17
            java.lang.Object r1 = r2.get()
        L17:
            if (r1 != r5) goto L1a
            return r0
        L1a:
            int r0 = r0 + (-1)
            goto L2
        L1d:
            int r4 = r4 + 1
            int r0 = r3.f25011a
        L21:
            if (r4 >= r0) goto L3f
            int[] r2 = r3.f25012b
            r2 = r2[r4]
            if (r2 == r6) goto L2d
        L29:
            int r4 = r4 + 1
            int r4 = -r4
            return r4
        L2d:
            androidx.compose.runtime.internal.WeakReference[] r2 = r3.f25013c
            r2 = r2[r4]
            if (r2 == 0) goto L38
            java.lang.Object r2 = r2.get()
            goto L39
        L38:
            r2 = r1
        L39:
            if (r2 != r5) goto L3c
            return r4
        L3c:
            int r4 = r4 + 1
            goto L21
        L3f:
            int r4 = r3.f25011a
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotWeakSet.c(int, java.lang.Object, int):int");
    }

    public final boolean a(Object obj) {
        int iB;
        int i3 = this.f25011a;
        int iA = Utils_jvmKt.a(obj);
        if (i3 > 0) {
            iB = b(obj, iA);
            if (iB >= 0) {
                return false;
            }
        } else {
            iB = -1;
        }
        int i4 = -(iB + 1);
        WeakReference[] weakReferenceArr = this.f25013c;
        int length = weakReferenceArr.length;
        if (i3 == length) {
            int i5 = length * 2;
            WeakReference[] weakReferenceArr2 = new WeakReference[i5];
            int[] iArr = new int[i5];
            int i6 = i4 + 1;
            System.arraycopy(weakReferenceArr, i4, weakReferenceArr2, i6, i3 - i4);
            System.arraycopy(this.f25013c, 0, weakReferenceArr2, 0, i4);
            ArraysKt.copyInto(this.f25012b, iArr, i6, i4, i3);
            ArraysKt.copyInto$default(this.f25012b, iArr, 0, 0, i4, 6, (Object) null);
            this.f25013c = weakReferenceArr2;
            this.f25012b = iArr;
        } else {
            int i7 = i4 + 1;
            System.arraycopy(weakReferenceArr, i4, weakReferenceArr, i7, i3 - i4);
            int[] iArr2 = this.f25012b;
            ArraysKt.copyInto(iArr2, iArr2, i7, i4, i3);
        }
        this.f25013c[i4] = new WeakReference(obj);
        this.f25012b[i4] = iA;
        this.f25011a++;
        return true;
    }

    public final int[] d() {
        return this.f25012b;
    }

    public final int e() {
        return this.f25011a;
    }

    public final WeakReference[] f() {
        return this.f25013c;
    }

    public final void g(int i3) {
        this.f25011a = i3;
    }
}
