package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewParent;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.text.input.PlatformTextInputService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class AndroidComposeView_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Function1 f27830a = new Function1<PlatformTextInputService, PlatformTextInputService>() { // from class: androidx.compose.ui.platform.AndroidComposeView_androidKt$platformTextInputServiceInterceptor$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final PlatformTextInputService invoke(PlatformTextInputService platformTextInputService) {
            return platformTextInputService;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(View view, View view2) {
        if (Intrinsics.areEqual(view2, view)) {
            return false;
        }
        for (ViewParent parent = view2.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == view) {
                return true;
            }
        }
        return false;
    }

    private static final float f(float[] fArr, int i3, float[] fArr2, int i4) {
        int i5 = i3 * 4;
        return (fArr[i5] * fArr2[i4]) + (fArr[i5 + 1] * fArr2[4 + i4]) + (fArr[i5 + 2] * fArr2[8 + i4]) + (fArr[i5 + 3] * fArr2[12 + i4]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentCaptureSessionCompat g(View view) {
        ViewCompatShims.c(view, 1);
        return ViewCompatShims.b(view);
    }

    public static final Function1 h() {
        return f27830a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(float[] fArr, float[] fArr2) {
        float f3 = f(fArr2, 0, fArr, 0);
        float f4 = f(fArr2, 0, fArr, 1);
        float f5 = f(fArr2, 0, fArr, 2);
        float f6 = f(fArr2, 0, fArr, 3);
        float f7 = f(fArr2, 1, fArr, 0);
        float f8 = f(fArr2, 1, fArr, 1);
        float f9 = f(fArr2, 1, fArr, 2);
        float f10 = f(fArr2, 1, fArr, 3);
        float f11 = f(fArr2, 2, fArr, 0);
        float f12 = f(fArr2, 2, fArr, 1);
        float f13 = f(fArr2, 2, fArr, 2);
        float f14 = f(fArr2, 2, fArr, 3);
        float f15 = f(fArr2, 3, fArr, 0);
        float f16 = f(fArr2, 3, fArr, 1);
        float f17 = f(fArr2, 3, fArr, 2);
        float f18 = f(fArr2, 3, fArr, 3);
        fArr[0] = f3;
        fArr[1] = f4;
        fArr[2] = f5;
        fArr[3] = f6;
        fArr[4] = f7;
        fArr[5] = f8;
        fArr[6] = f9;
        fArr[7] = f10;
        fArr[8] = f11;
        fArr[9] = f12;
        fArr[10] = f13;
        fArr[11] = f14;
        fArr[12] = f15;
        fArr[13] = f16;
        fArr[14] = f17;
        fArr[15] = f18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(float[] fArr, float f3, float f4, float[] fArr2) {
        Matrix.h(fArr2);
        Matrix.o(fArr2, f3, f4, 0.0f, 4, null);
        i(fArr, fArr2);
    }
}
