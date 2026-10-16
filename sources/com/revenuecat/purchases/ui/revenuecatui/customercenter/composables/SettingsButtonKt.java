package com.revenuecat.purchases.ui.revenuecatui.customercenter.composables;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final /* synthetic */ class SettingsButtonKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SettingsButtonStyle.values().length];
            try {
                iArr[SettingsButtonStyle.FILLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingsButtonStyle.OUTLINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ButtonContent-XO-JAsU, reason: not valid java name */
    public static final void m987ButtonContentXOJAsU(final String str, final boolean z2, final long j3, Composer composer, final int i3) {
        String str2;
        int i4;
        Composer composer2;
        Composer composerK = composer.k(483726370);
        if ((i3 & 6) == 0) {
            str2 = str;
            i4 = (composerK.Z(str2) ? 4 : 2) | i3;
        } else {
            str2 = str;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.f(j3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(483726370, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.ButtonContent (SettingsButton.kt:85)");
            }
            if (z2) {
                composerK.a0(-945467054);
                ProgressIndicatorKt.d(SizeKt.v(Modifier.b8, Dp.g(20)), j3, Dp.g(2), 0L, 0, composerK, ((i4 >> 3) & 112) | 390, 24);
                composerK.U();
                composer2 = composerK;
            } else {
                composerK.a0(-945298848);
                composer2 = composerK;
                TextKt.c(str2, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(MaterialTheme.f18110a.c(composerK, MaterialTheme.f18111b).b(), 0L, 0L, FontWeight.f29233b.f(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer2, i4 & 14, 0, 65534);
                composer2.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt$ButtonContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    SettingsButtonKt.m987ButtonContentXOJAsU(str, z2, j3, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void SettingsButton(final java.lang.String r30, final kotlin.jvm.functions.Function0 r31, final com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonConfig r32, androidx.compose.ui.Modifier r33, com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonStyle r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButton(java.lang.String, kotlin.jvm.functions.Function0, com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonConfig, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonStyle, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsButtonDisabled_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1257236177);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1257236177, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonDisabled_Preview (SettingsButton.kt:147)");
            }
            SettingsButton("Restore purchases", new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonDisabled_Preview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m989invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m989invoke();
                    return Unit.f139807a;
                }
            }, new SettingsButtonConfig(false, false, 2, null), null, null, composerK, 54, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonDisabled_Preview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    SettingsButtonKt.SettingsButtonDisabled_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsButtonLoading_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1692829163);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1692829163, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonLoading_Preview (SettingsButton.kt:126)");
            }
            SettingsButton("Restore purchases", new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonLoading_Preview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m990invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m990invoke();
                    return Unit.f139807a;
                }
            }, new SettingsButtonConfig(false, true, 1, null), null, null, composerK, 54, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonLoading_Preview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    SettingsButtonKt.SettingsButtonLoading_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsButtonOutlinedLoading_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-919118185);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-919118185, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonOutlinedLoading_Preview (SettingsButton.kt:136)");
            }
            SettingsButtonStyle settingsButtonStyle = SettingsButtonStyle.OUTLINED;
            SettingsButton("Restore purchases", new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonOutlinedLoading_Preview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m991invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m991invoke();
                    return Unit.f139807a;
                }
            }, new SettingsButtonConfig(false, true, 1, null), null, settingsButtonStyle, composerK, 24630, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonOutlinedLoading_Preview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    SettingsButtonKt.SettingsButtonOutlinedLoading_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsButtonOutlined_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(1472127241);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1472127241, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonOutlined_Preview (SettingsButton.kt:115)");
            }
            SettingsButtonStyle settingsButtonStyle = SettingsButtonStyle.OUTLINED;
            SettingsButton("Restore purchases", new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonOutlined_Preview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m992invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m992invoke();
                    return Unit.f139807a;
                }
            }, new SettingsButtonConfig(false, false, 3, null), null, settingsButtonStyle, composerK, 24630, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButtonOutlined_Preview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    SettingsButtonKt.SettingsButtonOutlined_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SettingsButton_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-745433269);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-745433269, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButton_Preview (SettingsButton.kt:104)");
            }
            SettingsButtonStyle settingsButtonStyle = SettingsButtonStyle.FILLED;
            SettingsButton("Cancel subscription", new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButton_Preview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m993invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m993invoke();
                    return Unit.f139807a;
                }
            }, new SettingsButtonConfig(false, false, 3, null), null, settingsButtonStyle, composerK, 24630, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt.SettingsButton_Preview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    SettingsButtonKt.SettingsButton_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
