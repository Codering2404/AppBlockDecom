package com.valentinilk.shimmer;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.valentinilk.shimmer.ShimmerBounds;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShimmerBoundsKt {
    public static final Rect a(ShimmerBounds shimmerBounds, Composer composer, int i3) {
        Object objA;
        Intrinsics.checkNotNullParameter(shimmerBounds, "shimmerBounds");
        composer.F(1234290070);
        if (ComposerKt.M()) {
            ComposerKt.U(1234290070, i3, -1, "com.valentinilk.shimmer.rememberShimmerBounds (ShimmerBounds.kt:8)");
        }
        DisplayMetrics displayMetrics = ((Context) composer.q(AndroidCompositionLocals_androidKt.g())).getResources().getDisplayMetrics();
        composer.F(511388516);
        boolean Z = composer.Z(shimmerBounds) | composer.Z(displayMetrics);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            if (Intrinsics.areEqual(shimmerBounds, ShimmerBounds.Window.f93799b)) {
                objA = new Rect(0.0f, 0.0f, displayMetrics.widthPixels, displayMetrics.heightPixels);
            } else if (Intrinsics.areEqual(shimmerBounds, ShimmerBounds.Custom.f93797b)) {
                objA = Rect.f25601e.a();
            } else {
                if (!Intrinsics.areEqual(shimmerBounds, ShimmerBounds.View.f93798b)) {
                    throw new NoWhenBranchMatchedException();
                }
                objA = null;
            }
            objG = objA;
            composer.w(objG);
        }
        composer.Y();
        Rect rect = (Rect) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return rect;
    }
}
