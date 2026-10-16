package androidx.compose.ui.platform;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RenderEffect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public interface DeviceRenderNode {
    void A(int i3);

    int B();

    void C(float f3);

    void D(float f3);

    void E(Outline outline);

    void F(int i3);

    void G(boolean z2);

    void H(CanvasHolder canvasHolder, Path path, Function1 function1);

    void I(int i3);

    float J();

    float a();

    void b(Canvas canvas);

    void c(float f3);

    void d(float f3);

    void e(float f3);

    void f(RenderEffect renderEffect);

    void g(float f3);

    int getHeight();

    int getWidth();

    void h(float f3);

    void i(float f3);

    void j(float f3);

    void k(float f3);

    void l(float f3);

    int m();

    void n();

    boolean o();

    int p();

    void q(boolean z2);

    boolean r(int i3, int i4, int i5, int i6);

    void s(int i3);

    void t(float f3);

    void u(int i3);

    boolean v();

    int w();

    boolean x();

    boolean y(boolean z2);

    void z(Matrix matrix);
}
