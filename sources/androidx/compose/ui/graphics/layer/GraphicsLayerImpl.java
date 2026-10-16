package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public interface GraphicsLayerImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f26149a = Companion.f26150a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f26150a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Function1 f26151b = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.layer.GraphicsLayerImpl$Companion$DefaultDrawBlock$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(DrawScope drawScope) {
                DrawScope.L1(drawScope, Color.f25715b.j(), 0L, 0L, 0.0f, null, null, 0, 126, null);
            }
        };

        private Companion() {
        }

        public final Function1 a() {
            return f26151b;
        }
    }

    float A();

    void B(boolean z2);

    void C(long j3);

    float D();

    void E(float f3);

    void F(boolean z2);

    void G(Outline outline, long j3);

    void H(long j3);

    void I(int i3);

    float J();

    float K();

    float L();

    float M();

    void N(Canvas canvas);

    float P();

    float a();

    ColorFilter b();

    void c(float f3);

    void d(float f3);

    void e(float f3);

    void f(RenderEffect renderEffect);

    void g(float f3);

    void h(float f3);

    void i(float f3);

    void j(float f3);

    void k(float f3);

    void l(float f3);

    int m();

    void n();

    default boolean o() {
        return true;
    }

    RenderEffect p();

    void q(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1 function1);

    int r();

    void s(int i3, int i4, long j3);

    float t();

    long u();

    long v();

    float w();

    Matrix x();

    void y(long j3);

    default boolean z() {
        return false;
    }
}
