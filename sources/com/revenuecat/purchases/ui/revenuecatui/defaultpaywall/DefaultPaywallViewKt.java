package com.revenuecat.purchases.ui.revenuecatui.defaultpaywall;

import android.graphics.Bitmap;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class DefaultPaywallViewKt {
    private static final long RevenueCatBrandRed = ColorKt.d(4294071387L);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: AppIconSection-cf5BqRc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1106AppIconSectioncf5BqRc(final android.graphics.Bitmap r36, final java.lang.String r37, final long r38, androidx.compose.ui.Modifier r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt.m1106AppIconSectioncf5BqRc(android.graphics.Bitmap, java.lang.String, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: DefaultPaywallFooter-ZkgLGzA, reason: not valid java name */
    public static final void m1107DefaultPaywallFooterZkgLGzA(final Function0<Unit> function0, final Function0<Unit> function02, final boolean z2, final long j3, final long j4, Composer composer, final int i3) {
        int i4;
        boolean z3;
        Composer composer2;
        Composer composerK = composer.k(-1968152504);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function0) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function02) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            z3 = z2;
            i4 |= composerK.b(z3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            z3 = z2;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.f(j3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.f(j4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i4 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1968152504, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallFooter (DefaultPaywallView.kt:245)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MaterialTheme materialTheme = MaterialTheme.f18110a;
            int i5 = MaterialTheme.f18111b;
            Modifier modifierD = BackgroundKt.d(modifierH, Color.r(materialTheme.a(composerK, i5).o0(), 0.95f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierI = PaddingKt.i(WindowInsetsPadding_androidKt.b(SizeKt.h(SizeKt.C(companion, 0.0f, ReadableContentWidth.INSTANCE.m1115getDpD9Ej5fM(), 1, null), 0.0f, 1, null)), Dp.g(16));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierI);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            ButtonDefaults buttonDefaults = ButtonDefaults.f16077a;
            int i6 = ButtonDefaults.f16091o;
            ButtonColors buttonColorsB = buttonDefaults.b(j3, j4, 0L, 0L, composerK, ((i4 >> 9) & 126) | (i6 << 12), 12);
            Modifier modifierI2 = SizeKt.i(SizeKt.h(SizeKt.C(companion, 0.0f, Dp.g(480), 1, null), 0.0f, 1, null), Dp.g(52));
            ComposableSingletons$DefaultPaywallViewKt composableSingletons$DefaultPaywallViewKt = ComposableSingletons$DefaultPaywallViewKt.INSTANCE;
            ButtonKt.a(function0, modifierI2, z3, null, buttonColorsB, null, null, null, null, composableSingletons$DefaultPaywallViewKt.m1102getLambda2$revenuecatui_defaultsBc8Release(), composerK, (i4 & 14) | 805306416 | (i4 & 896), 488);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composerK, 6);
            composer2 = composerK;
            ButtonKt.e(function02, null, false, null, buttonDefaults.A(0L, materialTheme.a(composerK, i5).d0(), 0L, 0L, composerK, i6 << 12, 13), null, null, null, null, composableSingletons$DefaultPaywallViewKt.m1103getLambda3$revenuecatui_defaultsBc8Release(), composer2, ((i4 >> 3) & 14) | 805306368, 494);
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt$DefaultPaywallFooter$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i7) {
                    DefaultPaywallViewKt.m1107DefaultPaywallFooterZkgLGzA(function0, function02, z2, j3, j4, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void DefaultPaywallView(final java.util.List<com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageInfo> r39, final com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageInfo r40, final com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning r41, final kotlin.jvm.functions.Function1<? super com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration.PackageInfo, kotlin.Unit> r42, final kotlin.jvm.functions.Function0<kotlin.Unit> r43, final kotlin.jvm.functions.Function0<kotlin.Unit> r44, androidx.compose.ui.Modifier r45, com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewOverrides r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 1130
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt.DefaultPaywallView(java.util.List, com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration$PackageInfo, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.defaultpaywall.DefaultPaywallPreviewOverrides, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap DefaultPaywallView$lambda$3(MutableState<Bitmap> mutableState) {
        return (Bitmap) mutableState.getValue();
    }

    private static final List<Color> DefaultPaywallView$lambda$6(MutableState<List<Color>> mutableState) {
        return (List) mutableState.getValue();
    }

    private static /* synthetic */ void getRevenueCatBrandRed$annotations() {
    }
}
