package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@DrawScopeMarker
@Metadata
public interface DrawTransform {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    static /* synthetic */ void f(DrawTransform drawTransform, float f3, float f4, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
        }
        if ((i3 & 1) != 0) {
            f3 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f4 = 0.0f;
        }
        drawTransform.e(f3, f4);
    }

    static /* synthetic */ void g(DrawTransform drawTransform, Path path, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i4 & 2) != 0) {
            i3 = ClipOp.f25711b.b();
        }
        drawTransform.d(path, i3);
    }

    static /* synthetic */ void h(DrawTransform drawTransform, float f3, float f4, float f5, float f6, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i4 & 1) != 0) {
            f3 = 0.0f;
        }
        if ((i4 & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i4 & 4) != 0) {
            f5 = Float.intBitsToFloat((int) (drawTransform.b() >> 32));
        }
        if ((i4 & 8) != 0) {
            f6 = Float.intBitsToFloat((int) (drawTransform.b() & 4294967295L));
        }
        if ((i4 & 16) != 0) {
            i3 = ClipOp.f25711b.b();
        }
        drawTransform.c(f3, f4, f5, f6, i3);
    }

    void a(float[] fArr);

    long b();

    void c(float f3, float f4, float f5, float f6, int i3);

    void d(Path path, int i3);

    void e(float f3, float f4);

    void i(float f3, float f4, long j3);

    void j(float f3, long j3);

    void k(float f3, float f4, float f5, float f6);
}
