package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public interface Paragraph {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    static /* synthetic */ void E(Paragraph paragraph, Canvas canvas, Brush brush, float f3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-hn5TExg");
        }
        if ((i4 & 4) != 0) {
            f3 = Float.NaN;
        }
        paragraph.w(canvas, brush, f3, (i4 & 8) != 0 ? null : shadow, (i4 & 16) != 0 ? null : textDecoration, (i4 & 32) != 0 ? null : drawStyle, (i4 & 64) != 0 ? DrawScope.e8.a() : i3);
    }

    static /* synthetic */ void v(Paragraph paragraph, Canvas canvas, long j3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: paint-LG529CI");
        }
        paragraph.j(canvas, (i4 & 2) != 0 ? Color.f25715b.k() : j3, (i4 & 4) != 0 ? null : shadow, (i4 & 8) != 0 ? null : textDecoration, (i4 & 16) == 0 ? drawStyle : null, (i4 & 32) != 0 ? DrawScope.e8.a() : i3);
    }

    long A(Rect rect, int i3, TextInclusionStrategy textInclusionStrategy);

    ResolvedTextDirection B(int i3);

    float C(int i3);

    List D();

    float a(int i3);

    float b(int i3);

    float c();

    float d(int i3);

    float e();

    Rect f(int i3);

    ResolvedTextDirection g(int i3);

    float getHeight();

    float getWidth();

    float h(int i3);

    Rect i(int i3);

    void j(Canvas canvas, long j3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3);

    long k(int i3);

    float l();

    int m(long j3);

    boolean n(int i3);

    int o(int i3);

    int p(int i3, boolean z2);

    int q();

    boolean r();

    int s(float f3);

    Path t(int i3, int i4);

    float u(int i3, boolean z2);

    void w(Canvas canvas, Brush brush, float f3, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int i3);

    void x(long j3, float[] fArr, int i3);

    float y();

    int z(int i3);
}
