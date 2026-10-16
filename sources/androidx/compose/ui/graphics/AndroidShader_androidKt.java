package androidx.compose.ui.graphics;

import android.graphics.Shader;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
public final class AndroidShader_androidKt {
    public static final Shader a(long j3, long j4, List list, List list2, int i3) {
        g(list, list2);
        int iD = d(list);
        return new android.graphics.LinearGradient(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)), e(list, iD), f(list2, list, iD), AndroidTileMode_androidKt.a(i3));
    }

    public static final Shader b(long j3, float f3, List list, List list2, int i3) {
        g(list, list2);
        int iD = d(list);
        return new android.graphics.RadialGradient(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), f3, e(list, iD), f(list2, list, iD), AndroidTileMode_androidKt.a(i3));
    }

    public static final Shader c(long j3, List list, List list2) {
        g(list, list2);
        int iD = d(list);
        return new android.graphics.SweepGradient(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), e(list, iD), f(list2, list, iD));
    }

    public static final int d(List list) {
        return 0;
    }

    public static final int[] e(List list, int i3) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr[i4] = ColorKt.k(((Color) list.get(i4)).B());
        }
        return iArr;
    }

    public static final float[] f(List list, List list2, int i3) {
        if (i3 == 0) {
            if (list != null) {
                return CollectionsKt.toFloatArray(list);
            }
            return null;
        }
        float[] fArr = new float[list2.size() + i3];
        fArr[0] = list != null ? ((Number) list.get(0)).floatValue() : 0.0f;
        int lastIndex = CollectionsKt.getLastIndex(list2);
        int i4 = 1;
        for (int i5 = 1; i5 < lastIndex; i5++) {
            long jB = ((Color) list2.get(i5)).B();
            float fFloatValue = list != null ? ((Number) list.get(i5)).floatValue() : i5 / CollectionsKt.getLastIndex(list2);
            int i6 = i4 + 1;
            fArr[i4] = fFloatValue;
            if (Color.u(jB) == 0.0f) {
                i4 += 2;
                fArr[i6] = fFloatValue;
            } else {
                i4 = i6;
            }
        }
        fArr[i4] = list != null ? ((Number) list.get(CollectionsKt.getLastIndex(list2))).floatValue() : 1.0f;
        return fArr;
    }

    private static final void g(List list, List list2) {
        if (list2 == null) {
            if (list.size() < 2) {
                throw new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
            }
        } else if (list.size() != list2.size()) {
            throw new IllegalArgumentException("colors and colorStops arguments must have equal length.");
        }
    }
}
