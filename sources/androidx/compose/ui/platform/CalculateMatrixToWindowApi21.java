package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f27928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f27929b;

    public /* synthetic */ CalculateMatrixToWindowApi21(float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(fArr);
    }

    private final void b(float[] fArr, Matrix matrix) {
        AndroidMatrixConversions_androidKt.b(this.f27928a, matrix);
        AndroidComposeView_androidKt.i(fArr, this.f27928a);
    }

    private final void c(float[] fArr, float f3, float f4) {
        AndroidComposeView_androidKt.j(fArr, f3, f4, this.f27928a);
    }

    private final void d(View view, float[] fArr) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            d((View) parent, fArr);
            c(fArr, -view.getScrollX(), -view.getScrollY());
            c(fArr, view.getLeft(), view.getTop());
        } else {
            view.getLocationInWindow(this.f27929b);
            c(fArr, -view.getScrollX(), -view.getScrollY());
            c(fArr, r0[0], r0[1]);
        }
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        b(fArr, matrix);
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    public void a(View view, float[] fArr) {
        androidx.compose.ui.graphics.Matrix.h(fArr);
        d(view, fArr);
    }

    private CalculateMatrixToWindowApi21(float[] fArr) {
        this.f27928a = fArr;
        this.f27929b = new int[2];
    }
}
