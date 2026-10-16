package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SlotTableKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long[] f24196a = new long[0];

    /* JADX INFO: Access modifiers changed from: private */
    public static final int n(int[] iArr, int i3) {
        int i4 = i3 * 5;
        return i4 >= iArr.length ? iArr.length : iArr[i4 + 4] + Integer.bitCount(iArr[i4 + 1] >> 29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Anchor o(ArrayList arrayList, int i3, int i4) {
        int iT = t(arrayList, i3, i4);
        if (iT >= 0) {
            return (Anchor) arrayList.get(iT);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(int[] iArr, int i3) {
        return iArr[(i3 * 5) + 3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(int[] iArr, int i3, int i4, boolean z2, boolean z3, boolean z4, int i5, int i6) {
        int i7 = i3 * 5;
        iArr[i7] = i4;
        iArr[i7 + 1] = ((z2 ? 1 : 0) << 30) | ((z3 ? 1 : 0) << 29) | ((z4 ? 1 : 0) << 28);
        iArr[i7 + 2] = i5;
        iArr[i7 + 3] = 0;
        iArr[i7 + 4] = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int r(ArrayList arrayList, int i3, int i4) {
        int iT = t(arrayList, i3, i4);
        return iT >= 0 ? iT : -(iT + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s(int[] iArr, int i3) {
        int i4 = i3 * 5;
        return iArr[i4 + 4] + Integer.bitCount(iArr[i4 + 1] >> 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(ArrayList arrayList, int i3, int i4) {
        int size = arrayList.size() - 1;
        int i5 = 0;
        while (i5 <= size) {
            int i6 = (i5 + size) >>> 1;
            int iA = ((Anchor) arrayList.get(i6)).a();
            if (iA < 0) {
                iA += i4;
            }
            int iCompare = Intrinsics.compare(iA, i3);
            if (iCompare < 0) {
                i5 = i6 + 1;
            } else {
                if (iCompare <= 0) {
                    return i6;
                }
                size = i6 - 1;
            }
        }
        return -(i5 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int u(int[] iArr, int i3) {
        int i4 = i3 * 5;
        return iArr[i4 + 4] + Integer.bitCount(iArr[i4 + 1] >> 28);
    }

    public static final void v() {
        throw new ConcurrentModificationException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(int[] iArr, int i3, boolean z2) {
        int i4 = (i3 * 5) + 1;
        iArr[i4] = ((z2 ? 1 : 0) << 26) | (iArr[i4] & (-67108865));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(int[] iArr, int i3, int i4) {
        iArr[(i3 * 5) + 3] = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(int[] iArr, int i3, boolean z2) {
        int i4 = (i3 * 5) + 1;
        iArr[i4] = ((z2 ? 1 : 0) << 27) | (iArr[i4] & (-134217729));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(int[] iArr, int i3, int i4) {
        if (i4 >= 0) {
        }
        int i5 = (i3 * 5) + 1;
        iArr[i5] = i4 | (iArr[i5] & (-67108864));
    }
}
