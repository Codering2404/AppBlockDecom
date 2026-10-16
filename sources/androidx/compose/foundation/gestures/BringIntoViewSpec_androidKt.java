package androidx.compose.foundation.gestures;

import android.content.Context;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class BringIntoViewSpec_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f5550a = CompositionLocalKt.f(new Function1<CompositionLocalAccessorScope, BringIntoViewSpec>() { // from class: androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt$LocalBringIntoViewSpec$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final BringIntoViewSpec invoke(CompositionLocalAccessorScope compositionLocalAccessorScope) {
            return !((Context) compositionLocalAccessorScope.z(AndroidCompositionLocals_androidKt.g())).getPackageManager().hasSystemFeature("android.software.leanback") ? BringIntoViewSpec.f5546a.b() : BringIntoViewSpec_androidKt.b();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final BringIntoViewSpec f5551b = new BringIntoViewSpec() { // from class: androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt$PivotBringIntoViewSpec$1

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f5553b = 0.3f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f5554c;

        @Override // androidx.compose.foundation.gestures.BringIntoViewSpec
        public float a(float f3, float f4, float f5) {
            float fAbs = Math.abs((f4 + f3) - f3);
            boolean z2 = fAbs <= f5;
            float f6 = (this.f5553b * f5) - (this.f5554c * fAbs);
            float f7 = f5 - f6;
            if (z2 && f7 < fAbs) {
                f6 = f5 - fAbs;
            }
            return f3 - f6;
        }
    };

    public static final ProvidableCompositionLocal a() {
        return f5550a;
    }

    public static final BringIntoViewSpec b() {
        return f5551b;
    }
}
