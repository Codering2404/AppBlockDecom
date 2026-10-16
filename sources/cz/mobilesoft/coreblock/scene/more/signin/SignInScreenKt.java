package cz.mobilesoft.coreblock.scene.more.signin;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.core.text.HtmlCompat;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.signin.SignInViewEvent;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.ScreenProgressBarKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsV2Kt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
public final class SignInScreenKt {
    /* JADX WARN: Removed duplicated region for block: B:121:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0108  */
    /* JADX WARN: Type inference failed for: r5v4, types: [cz.mobilesoft.coreblock.scene.more.signin.SignInScreenKt$SignInScreen$uriHandler$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(final java.lang.Float r25, final cz.mobilesoft.coreblock.scene.more.signin.SignInViewState r26, java.lang.String r27, java.lang.String r28, boolean r29, boolean r30, boolean r31, final kotlin.jvm.functions.Function1 r32, final kotlin.jvm.functions.Function1 r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.signin.SignInScreenKt.h(java.lang.Float, cz.mobilesoft.coreblock.scene.more.signin.SignInViewState, java.lang.String, java.lang.String, boolean, boolean, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static final Unit i(boolean z2, boolean z3, String str, String str2, final SignInScreenKt$SignInScreen$uriHandler$1 signInScreenKt$SignInScreen$uriHandler$1, final Function1 function1, boolean z4, Float f3, final SignInViewState signInViewState, final Function1 function12, final Context context, BoxScope GradientBox, Composer composer, int i3) throws XmlPullParserException, IOException {
        Object obj;
        Modifier.Companion companion;
        int i4;
        ?? r2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        int i5 = (i3 & 6) == 0 ? i3 | (composer2.Z(GradientBox) ? 4 : 2) : i3;
        if (composer2.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2141293446, i5, -1, "cz.mobilesoft.coreblock.scene.more.signin.SignInScreen.<anonymous> (SignInScreen.kt:87)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierF = SizeKt.f(WindowInsetsPaddingKt.d(companion2, WindowInsets_androidKt.c(WindowInsets.f7172a, composer2, 6)), 0.0f, 1, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            Modifier modifierG = ScrollKt.g(GradientBox.f(modifierF, companion3.m()), ScrollKt.c(0, composer2, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion3.k(), composer2, 0);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierG);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A);
            } else {
                composer2.v();
            }
            Composer composerA = Updater.a(composer2);
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (z2 || z3) {
                composer2.a0(484383355);
                Modifier modifierM = PaddingKt.m(SizeKt.h(companion2, 0.0f, 1, null), 0.0f, Dp.g(12), 0.0f, 0.0f, 13, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierM);
                Function0 function0A2 = companion4.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A2);
                } else {
                    composer2.v();
                }
                Composer composerA2 = Updater.a(composer2);
                Updater.e(composerA2, measurePolicyG, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF3, companion4.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer2, 6);
                Modifier modifierF4 = boxScopeInstance.f(companion2, companion3.h());
                boolean Z = composer2.Z(function1);
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.n1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SignInScreenKt.j(function1);
                        }
                    };
                    composer2.w(objG);
                }
                obj = null;
                companion = companion2;
                i4 = 6;
                r2 = 0;
                ComposeButtonsKt.q0(modifierF4, imageVectorB, null, false, 0.0f, 0.0f, 0L, null, (Function0) objG, composer, 0, 252);
                composer2 = composer;
                if (z4) {
                    composer2.a0(1997268821);
                    ScreenProgressBarKt.b(boxScopeInstance.f(companion, companion3.e()), f3 != null ? f3.floatValue() : 0.1f, composer2, 0, 0);
                } else {
                    composer2.a0(1992756275);
                }
                composer2.U();
                composer2.y();
                composer2.U();
            } else {
                composer2.a0(480364050);
                composer2.U();
                companion = companion2;
                obj = null;
                r2 = 0;
                i4 = 6;
            }
            float f4 = 32;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer2, i4);
            AnnotatedString annotatedStringI = StringHelperExtKt.i(str, ComposeColorsKt.j(composer2, r2).b());
            TextStyle textStyleE = ComposeTypographyKt.g(composer2, r2).e();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            TextKt.d(annotatedStringI, PaddingKt.k(SizeKt.h(companion, 0.0f, 1, obj), Dp.g(f4), 0.0f, 2, obj), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, null, textStyleE, composer, 48, 0, 130556);
            Composer composer3 = composer;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer3, i4);
            if (str2.length() > 0) {
                composer3.a0(485513739);
                TextKt.c(str2, PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer3, r2), 0.0f, 2, obj), ComposeColorsKt.j(composer3, r2).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer3, r2).a(), composer, 0, 0, 65016);
                composer3 = composer;
                SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer3, i4);
            } else {
                composer3.a0(480364050);
            }
            composer3.U();
            composer3.a0(1678246145);
            for (final SignInMethod signInMethod : SignInMethod.getEntries()) {
                Modifier.Companion companion6 = Modifier.b8;
                Modifier modifierK = PaddingKt.k(companion6, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer3, r2), 0.0f, 2, obj);
                MeasurePolicy measurePolicyG2 = BoxKt.g(Alignment.f25072a.o(), r2);
                int iA3 = ComposablesKt.a(composer3, r2);
                CompositionLocalMap compositionLocalMapU3 = composer3.u();
                Modifier modifierF5 = ComposedModifierKt.f(composer3, modifierK);
                ComposeUiNode.Companion companion7 = ComposeUiNode.f8;
                Function0 function0A3 = companion7.a();
                if (composer3.m() == null) {
                    ComposablesKt.c();
                }
                composer3.L();
                if (composer3.i()) {
                    composer3.P(function0A3);
                } else {
                    composer3.v();
                }
                Composer composerA3 = Updater.a(composer3);
                Updater.e(composerA3, measurePolicyG2, companion7.e());
                Updater.e(composerA3, compositionLocalMapU3, companion7.g());
                Function2 function2B3 = companion7.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF5, companion7.f());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                float f5 = 16;
                ButtonType.EmptyWrapperBig emptyWrapperBig = new ButtonType.EmptyWrapperBig(PaddingKt.a(Dp.g(f5)), ComposableLambdaKt.e(13685682, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.signin.o1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return SignInScreenKt.k(signInMethod, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer3, 54));
                ButtonColor.Surface surface = new ButtonColor.Surface(false, null, false, null, null, 31, null);
                boolean zE = composer3.e(signInMethod.ordinal()) | composer3.Z(signInViewState) | composer3.Z(function12) | composer3.I(context);
                Object objG2 = composer3.G();
                if (zE || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.p1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SignInScreenKt.l(signInMethod, signInViewState, function12, context);
                        }
                    };
                    composer3.w(objG2);
                }
                ComposeButtonsKt.i0(null, emptyWrapperBig, surface, (Function0) objG2, composer3, 0, 1);
                composer3.y();
                SpacerKt.a(SizeKt.i(companion6, Dp.g(f5)), composer3, i4);
            }
            composer3.U();
            Modifier.Companion companion8 = Modifier.b8;
            SpacerKt.a(SizeKt.i(companion8, Dp.g(16)), composer3, i4);
            PrefManager prefManager = PrefManager.f126839a;
            String strQ0 = prefManager.Q0();
            if (strQ0 == null) {
                strQ0 = "https://appblock.app/privacy-policy-google-play";
            }
            String strT0 = prefManager.t0();
            if (strT0 == null) {
                strT0 = "https://appblock.app/conditions-of-use";
            }
            final String string = HtmlCompat.a(StringResources_androidKt.c(R.string.uq, new Object[]{strQ0, strT0}, composer3, r2), 63).toString();
            CompositionLocalKt.b(CompositionLocalsKt.s().d(signInScreenKt$SignInScreen$uriHandler$1), ComposableLambdaKt.e(-1444757744, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.signin.q1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SignInScreenKt.m(string, signInScreenKt$SignInScreen$uriHandler$1, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer3, 54), composer3, ProvidedValue.f24012i | 48);
            if (z2) {
                composer3.a0(489519435);
                float f6 = 48;
                SpacerKt.a(ColumnScope.b(columnScopeInstance, SizeKt.b(companion8, 0.0f, Dp.g(f6), 1, obj), 1.0f, false, 2, null), composer3, r2);
                Modifier modifierC = columnScopeInstance.c(companion8, Alignment.f25072a.g());
                String strB = StringResources_androidKt.b(R.string.n8, composer3, r2);
                boolean Z2 = composer3.Z(function1);
                Object objG3 = composer3.G();
                if (Z2 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.signin.r1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SignInScreenKt.n(function1);
                        }
                    };
                    composer3.w(objG3);
                }
                ComposeButtonsV2Kt.d(modifierC, strB, (Function0) objG3, composer3, 0, 0);
                SpacerKt.a(SizeKt.i(companion8, Dp.g(f6)), composer3, i4);
            } else {
                composer3.a0(480364050);
            }
            composer3.U();
            composer3.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function1 function1) {
        function1.invoke(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(SignInMethod signInMethod, RowScope EmptyWrapperBig, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(EmptyWrapperBig, "$this$EmptyWrapperBig");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(13685682, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.SignInScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SignInScreen.kt:136)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, signInMethod.getIcon(), composer, 6), null, boxScopeInstance.f(companion, companion2.h()), ComposeColorsKt.j(composer, 0).L(), composer, 48, 0);
            TextKt.c(StringResources_androidKt.b(signInMethod.getTitle(), composer, 0), boxScopeInstance.f(SizeKt.h(companion, 0.0f, 1, null), companion2.e()), ComposeColorsKt.j(composer, 0).L(), 0L, null, FontWeight.f29233b.b(), null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 196608, 0, 64984);
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
    public static final Unit l(SignInMethod signInMethod, SignInViewState signInViewState, Function1 function1, Context context) {
        if (signInMethod != SignInMethod.Google || signInViewState.j()) {
            function1.invoke(new SignInViewEvent.OnSignInMethodClicked(signInMethod, context));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(String str, SignInScreenKt$SignInScreen$uriHandler$1 signInScreenKt$SignInScreen$uriHandler$1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1444757744, i3, -1, "cz.mobilesoft.coreblock.scene.more.signin.SignInScreen.<anonymous>.<anonymous>.<anonymous> (SignInScreen.kt:183)");
            }
            float f3 = 24;
            cz.mobilesoft.coreblock.view.TextKt.h(str, SizeKt.h(PaddingKt.m(Modifier.b8, Dp.g(f3), 0.0f, Dp.g(f3), Dp.g(16), 2, null), 0.0f, 1, null), ComposeTypographyKt.g(composer, 0).d(), ComposeColorsKt.j(composer, 0).O(), TextAlign.h(TextAlign.f29616b.a()), 0, null, null, new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), signInScreenKt$SignInScreen$uriHandler$1, composer, 100663344, 224);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function1 function1) {
        function1.invoke(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Float f3, SignInViewState signInViewState, String str, String str2, boolean z2, boolean z3, boolean z4, Function1 function1, Function1 function12, int i3, int i4, Composer composer, int i5) {
        h(f3, signInViewState, str, str2, z2, z3, z4, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
