package cz.mobilesoft.coreblock.scene.premium.components;

import android.app.Activity;
import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.constants.Constants;
import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumFooterKt {
    private static final void f(final long j3, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        int i5;
        Composer composerK = composer.k(-2127753507);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2127753507, i4, -1, "cz.mobilesoft.coreblock.scene.premium.components.DiscountRow (PremiumFooter.kt:214)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zE = ComparableExtKt.e(Long.valueOf(j3), Long.valueOf(Constants.f128444b));
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = context.getString(R.string.nc);
                composerK.w(objG);
            }
            String strQ = (String) objG;
            Intrinsics.checkNotNull(strQ);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                String string = context.getString(R.string.nc);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String strE = DateHelper.e(0L);
                Intrinsics.checkNotNullExpressionValue(strE, "getFormattedTime(...)");
                objG2 = StringHelperExtKt.q(string, strE, null, 2, null);
                composerK.w(objG2);
            }
            String str = (String) objG2;
            if (zE) {
                String strE2 = DateHelper.e(TimeUnit.MILLISECONDS.toSeconds(j3));
                Intrinsics.checkNotNull(strE2);
                strQ = StringHelperExtKt.q(strQ, strE2, null, 2, null);
            }
            String str2 = strQ;
            Modifier.Companion companion2 = Modifier.b8;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(8)), composerK, 6);
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyG, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion3.i(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.s4, composerK, 6), null, SizeKt.v(companion2, Dp.g(20)), ComposeColorsKt.j(composerK, 0).k(), composerK, 432, 0);
            SpacerKt.a(SizeKt.A(companion2, Dp.g(4)), composerK, 6);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.h(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, companion2);
            Function0 function0A3 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyG2, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion4.f());
            if (zE) {
                composerK.a0(1580615623);
                i5 = 0;
                TextKt.c(str, SizeKt.i(companion2, Dp.g(0)), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composerK, 0).i()), composerK, 54, 0, 65528);
                composerK = composerK;
            } else {
                i5 = 0;
                composerK.a0(1569569269);
            }
            composerK.U();
            composer2 = composerK;
            TextKt.c(str2, null, ComposeColorsKt.j(composerK, i5).k(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composerK, i5).i()), composer2, 0, 0, 65530);
            composer2.y();
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.components.p1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumFooterKt.g(j3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(long j3, int i3, Composer composer, int i4) {
        f(j3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0898  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x095c  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x096c  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x097f  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0992  */
    /* JADX WARN: Removed duplicated region for block: B:331:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(final cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState r51, boolean r52, boolean r53, boolean r54, boolean r55, boolean r56, java.lang.String r57, final kotlin.jvm.functions.Function0 r58, final kotlin.jvm.functions.Function1 r59, androidx.compose.ui.Modifier r60, boolean r61, androidx.compose.runtime.Composer r62, final int r63, final int r64, final int r65) {
        /*
            Method dump skipped, instruction units count: 2463
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.components.PremiumFooterKt.h(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState, boolean, boolean, boolean, boolean, boolean, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Context context) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            activityB.startActivity(Paywall.c(Paywall.f113165a, activityB, PaywallTarget.Generic.INSTANCE, "premium_screen", "schedule_button", false, false, false, null, 240, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Context context, Function1 function1, PremiumScreenViewState premiumScreenViewState) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            function1.invoke(new PremiumScreenViewEvent.OnPurchase(activityB, premiumScreenViewState.D()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(PremiumScreenViewState premiumScreenViewState, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, Function0 function0, Function1 function1, Modifier modifier, boolean z7, int i3, int i4, int i5, Composer composer, int i6) {
        h(premiumScreenViewState, z2, z3, z4, z5, z6, str, function0, function1, modifier, z7, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }
}
