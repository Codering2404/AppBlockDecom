package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface Canvas {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    static /* synthetic */ void l(Canvas canvas, Path path, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
        }
        if ((i4 & 2) != 0) {
            i3 = ClipOp.f25711b.b();
        }
        canvas.d(path, i3);
    }

    static /* synthetic */ void o(Canvas canvas, float f3, float f4, float f5, float f6, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-N_I0leg");
        }
        if ((i4 & 16) != 0) {
            i3 = ClipOp.f25711b.b();
        }
        canvas.c(f3, f4, f5, f6, i3);
    }

    static /* synthetic */ void s(Canvas canvas, Rect rect, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipRect-mtrdD-E");
        }
        if ((i4 & 2) != 0) {
            i3 = ClipOp.f25711b.b();
        }
        canvas.w(rect, i3);
    }

    void A(float f3, float f4, float f5, float f6, float f7, float f8, Paint paint);

    void c(float f3, float f4, float f5, float f6, int i3);

    void d(Path path, int i3);

    void e(float f3, float f4);

    void f(float f3, float f4);

    void g(float f3, float f4, float f5, float f6, Paint paint);

    void h(int i3, List list, Paint paint);

    void i(ImageBitmap imageBitmap, long j3, long j4, long j5, long j6, Paint paint);

    void j(ImageBitmap imageBitmap, long j3, Paint paint);

    void k();

    void m(float f3, float f4, float f5, float f6, float f7, float f8, boolean z2, Paint paint);

    void n();

    void p(Rect rect, Paint paint);

    void q(long j3, long j4, Paint paint);

    void r(float f3);

    void t();

    void u();

    void v(float[] fArr);

    default void w(Rect rect, int i3) {
        c(rect.o(), rect.r(), rect.p(), rect.i(), i3);
    }

    void x(Path path, Paint paint);

    default void y(Rect rect, Paint paint) {
        g(rect.o(), rect.r(), rect.p(), rect.i(), paint);
    }

    void z(long j3, float f3, Paint paint);
}
