package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

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
public final class TextLayoutStateKt {
    public static final long a(long j3, Rect rect) {
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (j3 & 4294967295L);
        return Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i3) < rect.o() ? rect.o() : Float.intBitsToFloat(i3) > rect.p() ? rect.p() : Float.intBitsToFloat(i3))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i4) < rect.r() ? rect.r() : Float.intBitsToFloat(i4) > rect.i() ? rect.i() : Float.intBitsToFloat(i4))) & 4294967295L));
    }

    public static final long b(TextLayoutState textLayoutState, long j3) {
        Offset offsetD;
        LayoutCoordinates layoutCoordinatesJ = textLayoutState.j();
        if (layoutCoordinatesJ != null) {
            LayoutCoordinates layoutCoordinatesE = textLayoutState.e();
            if (layoutCoordinatesE != null) {
                offsetD = Offset.d((layoutCoordinatesJ.m() && layoutCoordinatesE.m()) ? layoutCoordinatesJ.S(layoutCoordinatesE, j3) : j3);
            } else {
                offsetD = null;
            }
            if (offsetD != null) {
                return offsetD.u();
            }
        }
        return j3;
    }

    public static final long c(TextLayoutState textLayoutState, long j3) {
        LayoutCoordinates layoutCoordinatesJ = textLayoutState.j();
        if (layoutCoordinatesJ != null) {
            Offset offsetD = null;
            if (!layoutCoordinatesJ.m()) {
                layoutCoordinatesJ = null;
            }
            if (layoutCoordinatesJ != null) {
                LayoutCoordinates layoutCoordinatesD = textLayoutState.d();
                if (layoutCoordinatesD != null) {
                    if (!layoutCoordinatesD.m()) {
                        layoutCoordinatesD = null;
                    }
                    if (layoutCoordinatesD != null) {
                        offsetD = Offset.d(layoutCoordinatesD.S(layoutCoordinatesJ, j3));
                    }
                }
                if (offsetD != null) {
                    return offsetD.u();
                }
            }
        }
        return j3;
    }

    public static final long d(TextLayoutState textLayoutState, long j3) {
        LayoutCoordinates layoutCoordinatesE = textLayoutState.e();
        return (layoutCoordinatesE == null || !layoutCoordinatesE.m()) ? j3 : layoutCoordinatesE.X(j3);
    }
}
