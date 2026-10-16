package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class CalculateMatrixToWindowApi29 implements CalculateMatrixToWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f27930a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f27931b = new int[2];

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    public void a(View view, float[] fArr) {
        this.f27930a.reset();
        view.transformMatrixToGlobal(this.f27930a);
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            view = parent;
            parent = view.getParent();
        }
        view.getLocationOnScreen(this.f27931b);
        int[] iArr = this.f27931b;
        int i3 = iArr[0];
        int i4 = iArr[1];
        view.getLocationInWindow(iArr);
        int[] iArr2 = this.f27931b;
        this.f27930a.postTranslate(iArr2[0] - i3, iArr2[1] - i4);
        AndroidMatrixConversions_androidKt.b(fArr, this.f27930a);
    }
}
