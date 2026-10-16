package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
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
public final class LayoutCoordinatesKt {
    public static final Rect a(LayoutCoordinates layoutCoordinates) {
        Rect rectR;
        LayoutCoordinates layoutCoordinatesR0 = layoutCoordinates.r0();
        return (layoutCoordinatesR0 == null || (rectR = LayoutCoordinates.R(layoutCoordinatesR0, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, (int) (layoutCoordinates.a() >> 32), (int) (layoutCoordinates.a() & 4294967295L)) : rectR;
    }

    public static final Rect b(LayoutCoordinates layoutCoordinates) {
        return LayoutCoordinates.R(d(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    public static final Rect c(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinatesD = d(layoutCoordinates);
        float fA = (int) (layoutCoordinatesD.a() >> 32);
        float fA2 = (int) (layoutCoordinatesD.a() & 4294967295L);
        Rect rectR = LayoutCoordinates.R(layoutCoordinatesD, layoutCoordinates, false, 2, null);
        float fO = rectR.o();
        if (fO < 0.0f) {
            fO = 0.0f;
        }
        if (fO > fA) {
            fO = fA;
        }
        float fR = rectR.r();
        if (fR < 0.0f) {
            fR = 0.0f;
        }
        if (fR > fA2) {
            fR = fA2;
        }
        float fP = rectR.p();
        if (fP < 0.0f) {
            fP = 0.0f;
        }
        if (fP <= fA) {
            fA = fP;
        }
        float fI = rectR.i();
        float f3 = fI >= 0.0f ? fI : 0.0f;
        if (f3 <= fA2) {
            fA2 = f3;
        }
        if (fO == fA || fR == fA2) {
            return Rect.f25601e.a();
        }
        long jF0 = layoutCoordinatesD.f0(Offset.e((((long) Float.floatToRawIntBits(fO)) << 32) | (((long) Float.floatToRawIntBits(fR)) & 4294967295L)));
        long jF02 = layoutCoordinatesD.f0(Offset.e((((long) Float.floatToRawIntBits(fR)) & 4294967295L) | (((long) Float.floatToRawIntBits(fA)) << 32)));
        long jF03 = layoutCoordinatesD.f0(Offset.e((((long) Float.floatToRawIntBits(fA)) << 32) | (((long) Float.floatToRawIntBits(fA2)) & 4294967295L)));
        long jF04 = layoutCoordinatesD.f0(Offset.e((((long) Float.floatToRawIntBits(fA2)) & 4294967295L) | (((long) Float.floatToRawIntBits(fO)) << 32)));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jF0 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jF02 >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jF04 >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jF03 >> 32));
        float fMin = Math.min(fIntBitsToFloat, Math.min(fIntBitsToFloat2, Math.min(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fMax = Math.max(fIntBitsToFloat, Math.max(fIntBitsToFloat2, Math.max(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (jF0 & 4294967295L));
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (jF02 & 4294967295L));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (jF04 & 4294967295L));
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (jF03 & 4294967295L));
        return new Rect(fMin, Math.min(fIntBitsToFloat5, Math.min(fIntBitsToFloat6, Math.min(fIntBitsToFloat7, fIntBitsToFloat8))), fMax, Math.max(fIntBitsToFloat5, Math.max(fIntBitsToFloat6, Math.max(fIntBitsToFloat7, fIntBitsToFloat8))));
    }

    public static final LayoutCoordinates d(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates layoutCoordinatesR0 = layoutCoordinates.r0();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = layoutCoordinatesR0;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            layoutCoordinatesR0 = layoutCoordinates.r0();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator nodeCoordinatorY2 = nodeCoordinator.Y2();
        while (true) {
            NodeCoordinator nodeCoordinator2 = nodeCoordinatorY2;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator == null) {
                return nodeCoordinator3;
            }
            nodeCoordinatorY2 = nodeCoordinator.Y2();
        }
    }

    public static final long e(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinatesR0 = layoutCoordinates.r0();
        return layoutCoordinatesR0 != null ? layoutCoordinatesR0.S(layoutCoordinates, Offset.f25596b.c()) : Offset.f25596b.c();
    }

    public static final long f(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.x0(Offset.f25596b.c());
    }

    public static final long g(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.f0(Offset.f25596b.c());
    }

    public static final long h(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.H(Offset.f25596b.c());
    }
}
