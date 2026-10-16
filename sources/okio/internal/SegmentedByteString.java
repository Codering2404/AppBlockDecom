package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.C2959SegmentedByteString;

/* JADX INFO: renamed from: okio.internal.-SegmentedByteString, reason: invalid class name */
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
public final class SegmentedByteString {
    public static final int a(int[] iArr, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i6 = i5 - 1;
        while (i4 <= i6) {
            int i7 = (i4 + i6) >>> 1;
            int i8 = iArr[i7];
            if (i8 < i3) {
                i4 = i7 + 1;
            } else {
                if (i8 <= i3) {
                    return i7;
                }
                i6 = i7 - 1;
            }
        }
        return (-i4) - 1;
    }

    public static final int b(C2959SegmentedByteString c2959SegmentedByteString, int i3) {
        Intrinsics.checkNotNullParameter(c2959SegmentedByteString, "<this>");
        int iA = a(c2959SegmentedByteString.Q(), i3 + 1, 0, c2959SegmentedByteString.R().length);
        return iA >= 0 ? iA : ~iA;
    }
}
