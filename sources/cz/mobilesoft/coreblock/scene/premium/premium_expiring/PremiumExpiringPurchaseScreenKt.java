package cz.mobilesoft.coreblock.scene.premium.premium_expiring;

import android.app.Activity;
import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsV2Kt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class PremiumExpiringPurchaseScreenKt {
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f(final java.lang.String r16, final java.lang.String r17, final kotlin.jvm.functions.Function1 r18, final kotlin.jvm.functions.Function0 r19, java.lang.String r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseScreenKt.f(java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Context context, Function1 function1) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            AnswersHelper.f128199a.T3(true);
            function1.invoke(new PremiumScreenViewEvent.OnPurchase(activityB, null, 2, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(final Function0 function0, BoxScope BaseScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseScreen, "$this$BaseScreen");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1654655277, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseScreen.<anonymous> (PremiumExpiringPurchaseScreen.kt:57)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(SizeKt.b(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(56), 1, null), 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            Modifier modifierC = ColumnScopeInstance.f6666a.c(companion, companion2.g());
            String strB = StringResources_androidKt.b(R.string.o8, composer, 0);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.a1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PremiumExpiringPurchaseScreenKt.i(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsV2Kt.d(modifierC, strB, (Function0) objG, composer, 0, 0);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function0 function0) {
        AnswersHelper.f128199a.T3(false);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(String str, String str2, String str3, BoxScope BaseScreen, Composer composer, int i3) {
        int iS;
        Intrinsics.checkNotNullParameter(BaseScreen, "$this$BaseScreen");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-529620660, i3, -1, "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseScreen.<anonymous> (PremiumExpiringPurchaseScreen.kt:74)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(SizeKt.f(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer, 6);
            Modifier modifierK2 = PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null);
            String strB = StringResources_androidKt.b(R.string.aq, composer, 0);
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, modifierK2, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 48, 0, 65020);
            Modifier modifierH = SizeKt.h(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierK3 = PaddingKt.k(SizeKt.h(boxScopeInstance.f(companion, companion2.e()), 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null);
            Painter painterC = PainterResources_androidKt.c(R.drawable.r7, composer, 0);
            ContentScale.Companion companion5 = ContentScale.f27054a;
            Composer composer2 = composer;
            ImageKt.a(painterC, "", modifierK3, null, companion5.d(), 0.0f, null, composer2, 24624, 104);
            ImageKt.a(PainterResources_androidKt.c(R.drawable.D7, composer2, 0), "", SizeKt.h(boxScopeInstance.f(companion, companion2.e()), 0.0f, 1, null), null, companion5.d(), 0.0f, null, composer2, 24624, 104);
            composer2.y();
            if (str == null) {
                composer2.a0(1956557188);
            } else {
                composer2.a0(1956557189);
                TextKt.c(StringResources_androidKt.c(R.string.lq, new Object[]{str}, composer2, 0), null, ComposeColorsKt.j(composer2, 0).k(), 0L, null, null, null, 0L, TextDecoration.f29625b.b(), TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).h(), composer, 100663296, 0, 64762);
                composer2 = composer;
                SpacerKt.a(SizeKt.i(companion, Dp.g(4)), composer2, 6);
                Unit unit = Unit.f139807a;
            }
            composer2.U();
            composer2.a0(1171508358);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            if (str2 == null) {
                composer2.a0(-1374867827);
            } else {
                composer2.a0(-1374867826);
                composer2.a0(-1014181112);
                iS = builder.s(new SpanStyle(ComposeColorsKt.j(composer2, 0).L(), ComposeTypographyKt.g(composer2, 0).i().n(), ComposeTypographyKt.g(composer2, 0).i().q(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null));
                try {
                    builder.l(StringResources_androidKt.c(R.string.lq, new Object[]{str2}, composer2, 0));
                    Unit unit2 = Unit.f139807a;
                    builder.q(iS);
                    composer2.U();
                } finally {
                }
            }
            composer2.U();
            if (str3 == null) {
                composer2.a0(-1374371765);
            } else {
                composer2.a0(-1374371764);
                composer2.a0(-1014165110);
                iS = builder.s(new SpanStyle(ComposeColorsKt.j(composer2, 0).P(), ComposeTypographyKt.g(composer2, 0).d().n(), ComposeTypographyKt.g(composer2, 0).d().q(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null));
                try {
                    builder.l(" (" + StringResources_androidKt.c(R.string.kq, new Object[]{str3}, composer2, 0) + ")");
                    Unit unit3 = Unit.f139807a;
                    builder.q(iS);
                    composer2.U();
                } finally {
                }
            }
            composer2.U();
            AnnotatedString annotatedStringT = builder.t();
            composer2.U();
            TextKt.d(annotatedStringT, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, null, null, composer, 0, 0, 261630);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(String str, String str2, Function1 function1, Function0 function0, String str3, int i3, int i4, Composer composer, int i5) {
        f(str, str2, function1, function0, str3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
