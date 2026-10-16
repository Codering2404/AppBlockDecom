package com.revenuecat.purchases.ui.revenuecatui.components.button;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.text.intl.Locale;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final /* synthetic */ class ButtonComponentStateKt {
    public static final /* synthetic */ ButtonComponentState rememberButtonComponentState(ButtonComponentStyle style, final PaywallState.Loaded.Components paywallState, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(paywallState, "paywallState");
        composer.a0(1389420952);
        if (ComposerKt.M()) {
            ComposerKt.U(1389420952, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.rememberButtonComponentState (ButtonComponentState.kt:26)");
        }
        composer.a0(1826062199);
        boolean z2 = (((i3 & 112) ^ 48) > 32 && composer.Z(paywallState)) || (i3 & 48) == 32;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function0<Locale>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentStateKt$rememberButtonComponentState$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Locale invoke() {
                    return paywallState.getLocale();
                }
            };
            composer.w(objG);
        }
        composer.U();
        ButtonComponentState buttonComponentStateRememberButtonComponentState = rememberButtonComponentState(style, (Function0) objG, composer, i3 & 14);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return buttonComponentStateRememberButtonComponentState;
    }

    public static final /* synthetic */ ButtonComponentState rememberButtonComponentState(ButtonComponentStyle style, Function0 localeProvider, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        composer.a0(-1664983180);
        if (ComposerKt.M()) {
            ComposerKt.U(-1664983180, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.rememberButtonComponentState (ButtonComponentState.kt:37)");
        }
        composer.a0(1826068755);
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(style)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new ButtonComponentState(style, localeProvider);
            composer.w(objG);
        }
        ButtonComponentState buttonComponentState = (ButtonComponentState) objG;
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return buttonComponentState;
    }
}
