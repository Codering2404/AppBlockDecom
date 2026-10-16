package com.revenuecat.purchases.ui.revenuecatui.helpers;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.window.core.layout.WindowHeightSizeClass;
import androidx.window.core.layout.WindowSizeClass;
import androidx.window.core.layout.WindowWidthSizeClass;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallModeKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
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
public final class WindowHelperKt {
    public static final WindowHeightSizeClass computeWindowHeightSizeClass(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1980265325, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.computeWindowHeightSizeClass (WindowHelper.kt:22)");
        }
        WindowHeightSizeClass windowHeightSizeClassA = windowSizeClass(composer, 0).a();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return windowHeightSizeClassA;
    }

    public static final WindowWidthSizeClass computeWindowWidthSizeClass(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(173434359, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.computeWindowWidthSizeClass (WindowHelper.kt:16)");
        }
        WindowWidthSizeClass windowWidthSizeClassB = windowSizeClass(composer, 0).b();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return windowWidthSizeClassB;
    }

    private static final Pair<Float, Float> getScreenSize(Composer composer, int i3) {
        Pair<Float, Float> pairA;
        if (ComposerKt.M()) {
            ComposerKt.U(392213243, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.getScreenSize (WindowHelper.kt:59)");
        }
        Activity activity = (Activity) composer.q(HelperFunctionsKt.getLocalActivity());
        if (HelperFunctionsKt.isInPreviewMode(composer, 0) || activity == null) {
            Configuration configuration = (Configuration) composer.q(AndroidCompositionLocals_androidKt.f());
            pairA = TuplesKt.a(Float.valueOf(configuration.screenWidthDp), Float.valueOf(configuration.screenHeightDp));
        } else {
            float f3 = activity.getResources().getDisplayMetrics().density;
            WindowMetrics windowMetricsB = WindowMetricsCalculator.f54368a.b().b(activity);
            pairA = new Pair<>(Float.valueOf(windowMetricsB.a().width() / f3), Float.valueOf(windowMetricsB.a().height() / f3));
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return pairA;
    }

    public static final boolean hasCompactDimension(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(667952227, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.hasCompactDimension (WindowHelper.kt:28)");
        }
        boolean z2 = Intrinsics.areEqual(computeWindowHeightSizeClass(composer, 0), WindowHeightSizeClass.f54162c) || Intrinsics.areEqual(computeWindowWidthSizeClass(composer, 0), WindowWidthSizeClass.f54170c);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return z2;
    }

    public static final boolean shouldUseLandscapeLayout(PaywallState.Loaded.Legacy legacy, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(legacy, "<this>");
        if (ComposerKt.M()) {
            ComposerKt.U(405801034, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.shouldUseLandscapeLayout (WindowHelper.kt:35)");
        }
        boolean zShouldUseLandscapeLayout = shouldUseLandscapeLayout(legacy.getTemplateConfiguration().getMode(), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return zShouldUseLandscapeLayout;
    }

    private static final WindowSizeClass windowSizeClass(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1719780984, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.windowSizeClass (WindowHelper.kt:52)");
        }
        Pair<Float, Float> screenSize = getScreenSize(composer, 0);
        WindowSizeClass windowSizeClassA = WindowSizeClass.f54166c.a(((Number) screenSize.a()).floatValue(), ((Number) screenSize.b()).floatValue());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return windowSizeClassA;
    }

    private static final boolean shouldUseLandscapeLayout(PaywallMode paywallMode, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1400525098, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.helpers.shouldUseLandscapeLayout (WindowHelper.kt:41)");
        }
        boolean zShouldUseLandscapeLayout = shouldUseLandscapeLayout(paywallMode, computeWindowHeightSizeClass(composer, 0));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return zShouldUseLandscapeLayout;
    }

    public static final boolean shouldUseLandscapeLayout(PaywallMode mode, WindowHeightSizeClass sizeClass) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(sizeClass, "sizeClass");
        return PaywallModeKt.isFullScreen(mode) && Intrinsics.areEqual(sizeClass, WindowHeightSizeClass.f54162c);
    }
}
