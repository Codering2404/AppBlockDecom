package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
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
public final class PointerEventKt {
    public static final boolean a(PointerInputChange pointerInputChange) {
        return (pointerInputChange.p() || pointerInputChange.l() || !pointerInputChange.i()) ? false : true;
    }

    public static final boolean b(PointerInputChange pointerInputChange) {
        return !pointerInputChange.l() && pointerInputChange.i();
    }

    public static final boolean c(PointerInputChange pointerInputChange) {
        return (pointerInputChange.p() || !pointerInputChange.l() || pointerInputChange.i()) ? false : true;
    }

    public static final boolean d(PointerInputChange pointerInputChange) {
        return pointerInputChange.l() && !pointerInputChange.i();
    }

    public static final boolean e(PointerInputChange pointerInputChange, long j3) {
        long jH = pointerInputChange.h();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jH >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jH & 4294967295L));
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (j3 & 4294967295L);
        return (fIntBitsToFloat > ((float) i3)) | (fIntBitsToFloat < 0.0f) | (fIntBitsToFloat2 < 0.0f) | (fIntBitsToFloat2 > ((float) i4));
    }

    public static final boolean f(PointerInputChange pointerInputChange, long j3, long j4) {
        boolean zH = PointerType.h(pointerInputChange.n(), PointerType.f26922b.d());
        long jH = pointerInputChange.h();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jH >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jH & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j4 >> 32));
        float f3 = zH ? 1.0f : 0.0f;
        float f4 = fIntBitsToFloat3 * f3;
        float f5 = ((int) (j3 >> 32)) + f4;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j4 & 4294967295L)) * f3;
        return (fIntBitsToFloat > f5) | (fIntBitsToFloat < (-f4)) | (fIntBitsToFloat2 < (-fIntBitsToFloat4)) | (fIntBitsToFloat2 > ((int) (j3 & 4294967295L)) + fIntBitsToFloat4);
    }

    public static final long g(PointerInputChange pointerInputChange) {
        return i(pointerInputChange, false);
    }

    public static final long h(PointerInputChange pointerInputChange) {
        return i(pointerInputChange, true);
    }

    private static final long i(PointerInputChange pointerInputChange, boolean z2) {
        return (z2 || !pointerInputChange.p()) ? Offset.p(pointerInputChange.h(), pointerInputChange.k()) : Offset.f25596b.c();
    }

    public static final boolean j(PointerInputChange pointerInputChange) {
        return !Offset.j(i(pointerInputChange, false), Offset.f25596b.c());
    }

    public static final boolean k(PointerInputChange pointerInputChange) {
        return !Offset.j(i(pointerInputChange, true), Offset.f25596b.c());
    }
}
