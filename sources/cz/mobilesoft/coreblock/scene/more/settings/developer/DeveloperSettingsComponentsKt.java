package cz.mobilesoft.coreblock.scene.more.settings.developer;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.SearchKt;
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
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class DeveloperSettingsComponentsKt {
    public static final AnnotatedString A(String text, String searchQuery) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        if (StringsKt.p0(searchQuery) || StringsKt.p0(text)) {
            return new AnnotatedString(text, null, 2, null);
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = text.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
        String lowerCase2 = searchQuery.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        int length = 0;
        while (true) {
            if (length >= text.length()) {
                break;
            }
            int iN0 = StringsKt.n0(lowerCase, lowerCase2, length, false, 4, null);
            if (iN0 == -1) {
                String strSubstring = text.substring(length);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                builder.l(strSubstring);
                break;
            }
            if (iN0 > length) {
                String strSubstring2 = text.substring(length, iN0);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                builder.l(strSubstring2);
            }
            int iS = builder.s(new SpanStyle(0L, 0L, FontWeight.f29233b.b(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null));
            try {
                String strSubstring3 = text.substring(iN0, searchQuery.length() + iN0);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                builder.l(strSubstring3);
                Unit unit = Unit.f139807a;
                builder.q(iS);
                length = iN0 + searchQuery.length();
            } catch (Throwable th) {
                builder.q(iS);
                throw th;
            }
        }
        return builder.t();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final java.lang.String r64, final kotlin.jvm.functions.Function1 r65, androidx.compose.ui.Modifier r66, java.lang.String r67, androidx.compose.runtime.Composer r68, final int r69, final int r70) {
        /*
            Method dump skipped, instruction units count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsComponentsKt.k(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final String l(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void m(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(SoftwareKeyboardController softwareKeyboardController, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (softwareKeyboardController != null) {
            softwareKeyboardController.a();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function1 function1, MutableState mutableState, String newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        m(mutableState, newValue);
        function1.invoke(newValue);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-847566033, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsSearchBar.<anonymous> (DeveloperSettingsComponents.kt:83)");
            }
            TextKt.c(str, null, ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(final Function1 function1, final MutableState mutableState, Composer composer, int i3) {
        Composer composer2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1663613263, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsSearchBar.<anonymous> (DeveloperSettingsComponents.kt:97)");
            }
            if (l(mutableState).length() > 0) {
                composer.a0(-1075029347);
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.c0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsComponentsKt.r(function1, mutableState);
                        }
                    };
                    composer.w(objG);
                }
                composer2 = composer;
                IconButtonKt.a((Function0) objG, null, false, null, ComposableSingletons$DeveloperSettingsComponentsKt.f108249a.c(), composer2, 24576, 14);
            } else {
                composer2 = composer;
                composer2.a0(-1079074351);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Function1 function1, MutableState mutableState) {
        m(mutableState, "");
        function1.invoke("");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(String str, Function1 function1, Modifier modifier, String str2, int i3, int i4, Composer composer, int i5) {
        k(str, function1, modifier, str2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void t(Modifier modifier, Composer composer, final int i3, final int i4) {
        final Modifier modifier2;
        int i5;
        Composer composer2;
        Composer composerK = composer.k(616731289);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = i3 | (composerK.Z(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(616731289, i5, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.SearchEmptyState (DeveloperSettingsComponents.kt:246)");
            }
            Modifier modifierI = PaddingKt.i(SizeKt.h(modifier3, 0.0f, 1, null), Dp.g(32));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), Alignment.f25072a.g(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            ImageVector imageVectorA = SearchKt.a(Icons.f15145a.a());
            long jO = ComposeColorsKt.j(composerK, 0).O();
            Modifier.Companion companion2 = Modifier.b8;
            IconKt.b(imageVectorA, null, SizeKt.v(companion2, Dp.g(48)), jO, composerK, 432, 0);
            SpacerKt.a(SizeKt.v(companion2, Dp.g(16)), composerK, 6);
            composer2 = composerK;
            Modifier modifier4 = modifier3;
            TextKt.c(StringResources_androidKt.b(R.string.el, composerK, 0), null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composer2, 0, 0, 65530);
            SpacerKt.a(SizeKt.v(companion2, Dp.g(8)), composer2, 6);
            TextKt.c("Try a different search term", null, ComposeColorsKt.j(composer2, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer2, 6, 0, 65530);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsComponentsKt.u(modifier2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        t(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void v(final cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsCategory r23, final boolean r24, final kotlin.jvm.functions.Function0 r25, final kotlin.jvm.functions.Function2 r26, androidx.compose.ui.Modifier r27, java.lang.String r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsComponentsKt.v(cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsCategory, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function2 function2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(1789317369, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.SettingsCategory.<anonymous>.<anonymous> (DeveloperSettingsComponents.kt:227)");
        }
        Modifier modifierM = PaddingKt.m(SizeKt.h(Modifier.b8, 0.0f, 1, null), 0.0f, Dp.g(4), 0.0f, 0.0f, 13, null);
        MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
        ComposeUiNode.Companion companion = ComposeUiNode.f8;
        Function0 function0A = companion.a();
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
        Updater.e(composerA, measurePolicyA, companion.e());
        Updater.e(composerA, compositionLocalMapU, companion.g());
        Function2 function2B = companion.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF, companion.f());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
        function2.invoke(composer, 0);
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(DeveloperSettingsCategory developerSettingsCategory, boolean z2, Function0 function0, Function2 function2, Modifier modifier, String str, int i3, int i4, Composer composer, int i5) {
        v(developerSettingsCategory, z2, function0, function2, modifier, str, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void y(final java.lang.Integer r34, final java.lang.String r35, final int r36, final boolean r37, final kotlin.jvm.functions.Function0 r38, androidx.compose.ui.Modifier r39, java.lang.String r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 886
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsComponentsKt.y(java.lang.Integer, java.lang.String, int, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Integer num, String str, int i3, boolean z2, Function0 function0, Modifier modifier, String str2, int i4, int i5, Composer composer, int i6) {
        y(num, str, i3, z2, function0, modifier, str2, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }
}
