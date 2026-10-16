package com.revenuecat.purchases.ui.revenuecatui.components.tabs;

import androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabsComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import java.util.Map;
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
public final /* synthetic */ class TabsComponentStateKt {
    public static final /* synthetic */ TabsComponentState rememberUpdatedTabsComponentState(TabsComponentStyle style, final PaywallState.Loaded.Components paywallState, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(paywallState, "paywallState");
        composer.a0(835107367);
        if (ComposerKt.M()) {
            ComposerKt.U(835107367, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.rememberUpdatedTabsComponentState (TabsComponentState.kt:31)");
        }
        composer.a0(455725763);
        int i4 = (i3 & 112) ^ 48;
        boolean z2 = (i4 > 32 && composer.Z(paywallState)) || (i3 & 48) == 32;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function0<PaywallState.Loaded.Components.SelectedPackageInfo>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentStateKt$rememberUpdatedTabsComponentState$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final PaywallState.Loaded.Components.SelectedPackageInfo invoke() {
                    return paywallState.getSelectedPackageInfo();
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        composer.U();
        composer.a0(455727941);
        boolean z3 = (i4 > 32 && composer.Z(paywallState)) || (i3 & 48) == 32;
        Object objG2 = composer.G();
        if (z3 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentStateKt$rememberUpdatedTabsComponentState$2$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, CustomVariableValue> invoke() {
                    return paywallState.getMergedCustomVariables();
                }
            };
            composer.w(objG2);
        }
        composer.U();
        TabsComponentState tabsComponentStateRememberUpdatedTabsComponentState = rememberUpdatedTabsComponentState(style, function0, (Function0) objG2, composer, i3 & 14);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return tabsComponentStateRememberUpdatedTabsComponentState;
    }

    private static final /* synthetic */ TabsComponentState rememberUpdatedTabsComponentState(TabsComponentStyle tabsComponentStyle, Function0 function0, Function0 function02, Composer composer, int i3) {
        composer.a0(-60149279);
        if (ComposerKt.M()) {
            ComposerKt.U(-60149279, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.rememberUpdatedTabsComponentState (TabsComponentState.kt:44)");
        }
        WindowWidthSizeClass windowWidthSizeClassB = AndroidWindowAdaptiveInfo_androidKt.b(composer, 0).a().b();
        composer.a0(455742185);
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(tabsComponentStyle)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new TabsComponentState(windowWidthSizeClassB, tabsComponentStyle, function0, function02);
            composer.w(objG);
        }
        TabsComponentState tabsComponentState = (TabsComponentState) objG;
        composer.U();
        tabsComponentState.update(windowWidthSizeClassB);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return tabsComponentState;
    }
}
