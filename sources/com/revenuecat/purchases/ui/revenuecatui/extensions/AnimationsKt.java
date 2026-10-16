package com.revenuecat.purchases.ui.revenuecatui.extensions;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import com.revenuecat.purchases.ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import kotlin.Metadata;
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
public final class AnimationsKt {
    public static final float packageButtonActionInProgressOpacityAnimation(PaywallViewModel paywallViewModel, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(paywallViewModel, "<this>");
        composer.a0(-1704661559);
        if (ComposerKt.M()) {
            ComposerKt.U(-1704661559, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.packageButtonActionInProgressOpacityAnimation (Animations.kt:13)");
        }
        float fPackageButtonActionInProgressOpacityAnimation$lambda$0 = packageButtonActionInProgressOpacityAnimation$lambda$0(AnimateAsStateKt.d(((Boolean) paywallViewModel.getActionInProgress().getValue()).booleanValue() ? 0.4f : 1.0f, UIConstant.INSTANCE.defaultAnimation(), 0.0f, "Package button action in progress alpha", null, composer, 3072, 20));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return fPackageButtonActionInProgressOpacityAnimation$lambda$0;
    }

    private static final float packageButtonActionInProgressOpacityAnimation$lambda$0(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: renamed from: packageButtonColorAnimation-9z6LAg8, reason: not valid java name */
    public static final long m1156packageButtonColorAnimation9z6LAg8(PaywallState.Loaded.Legacy packageButtonColorAnimation, TemplateConfiguration.PackageInfo packageInfo, long j3, long j4, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(packageButtonColorAnimation, "$this$packageButtonColorAnimation");
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        composer.a0(792231715);
        if (ComposerKt.M()) {
            ComposerKt.U(792231715, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.extensions.packageButtonColorAnimation (Animations.kt:28)");
        }
        long j5 = Intrinsics.areEqual(packageInfo, packageButtonColorAnimation.getSelectedPackage().getValue()) ? j3 : j4;
        long jPackageButtonColorAnimation_9z6LAg8$lambda$1 = packageButtonColorAnimation_9z6LAg8$lambda$1(SingleValueAnimationKt.a(j5, UIConstant.INSTANCE.defaultAnimation(), "Package button selected color: " + packageInfo.getRcPackage().getIdentifier(), null, composer, 0, 8));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return jPackageButtonColorAnimation_9z6LAg8$lambda$1;
    }

    private static final long packageButtonColorAnimation_9z6LAg8$lambda$1(State<Color> state) {
        return ((Color) state.getValue()).B();
    }
}
