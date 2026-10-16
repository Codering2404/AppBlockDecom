package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;
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
public final class TransformGestureDetectorKt {
    private static final float a(long j3) {
        if (Float.intBitsToFloat((int) (j3 >> 32)) == 0.0f && Float.intBitsToFloat((int) (j3 & 4294967295L)) == 0.0f) {
            return 0.0f;
        }
        return ((-((float) Math.atan2(Float.intBitsToFloat(r0), Float.intBitsToFloat((int) (j3 & 4294967295L))))) * 180.0f) / 3.1415927f;
    }

    public static final long b(PointerEvent pointerEvent, boolean z2) {
        long jC = Offset.f25596b.c();
        List listC = pointerEvent.c();
        int size = listC.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            PointerInputChange pointerInputChange = (PointerInputChange) listC.get(i4);
            if (pointerInputChange.i() && pointerInputChange.l()) {
                jC = Offset.q(jC, z2 ? pointerInputChange.h() : pointerInputChange.k());
                i3++;
            }
        }
        return i3 == 0 ? Offset.f25596b.b() : Offset.h(jC, i3);
    }

    public static final float c(PointerEvent pointerEvent, boolean z2) {
        long jB = b(pointerEvent, z2);
        float fK = 0.0f;
        if (Offset.j(jB, Offset.f25596b.b())) {
            return 0.0f;
        }
        List listC = pointerEvent.c();
        int size = listC.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            PointerInputChange pointerInputChange = (PointerInputChange) listC.get(i4);
            if (pointerInputChange.i() && pointerInputChange.l()) {
                fK += Offset.k(Offset.p(z2 ? pointerInputChange.h() : pointerInputChange.k(), jB));
                i3++;
            }
        }
        return fK / i3;
    }

    public static final long d(PointerEvent pointerEvent) {
        long jB = b(pointerEvent, true);
        Offset.Companion companion = Offset.f25596b;
        return Offset.j(jB, companion.b()) ? companion.c() : Offset.p(jB, b(pointerEvent, false));
    }

    public static final float e(PointerEvent pointerEvent) {
        List listC = pointerEvent.c();
        int size = listC.size();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = 1;
            if (i3 >= size) {
                break;
            }
            PointerInputChange pointerInputChange = (PointerInputChange) listC.get(i3);
            if (!pointerInputChange.l() || !pointerInputChange.i()) {
                i5 = 0;
            }
            i4 += i5;
            i3++;
        }
        if (i4 < 2) {
            return 0.0f;
        }
        long jB = b(pointerEvent, true);
        long jB2 = b(pointerEvent, false);
        List listC2 = pointerEvent.c();
        int size2 = listC2.size();
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (int i6 = 0; i6 < size2; i6++) {
            PointerInputChange pointerInputChange2 = (PointerInputChange) listC2.get(i6);
            if (pointerInputChange2.i() && pointerInputChange2.l()) {
                long jH = pointerInputChange2.h();
                long jP = Offset.p(pointerInputChange2.k(), jB2);
                long jP2 = Offset.p(jH, jB);
                float fA = a(jP2) - a(jP);
                float fK = Offset.k(Offset.q(jP2, jP)) / 2.0f;
                if (fA > 180.0f) {
                    fA -= 360.0f;
                } else if (fA < -180.0f) {
                    fA += 360.0f;
                }
                f4 += fA * fK;
                f3 += fK;
            }
        }
        if (f3 == 0.0f) {
            return 0.0f;
        }
        return f4 / f3;
    }

    public static final float f(PointerEvent pointerEvent) {
        float fC = c(pointerEvent, true);
        float fC2 = c(pointerEvent, false);
        if (fC == 0.0f || fC2 == 0.0f) {
            return 1.0f;
        }
        return fC / fC2;
    }
}
