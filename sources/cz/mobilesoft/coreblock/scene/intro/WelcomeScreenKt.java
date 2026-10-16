package cz.mobilesoft.coreblock.scene.intro;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
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
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.TextKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsV2Kt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class WelcomeScreenKt {
    private static final void h(final ColumnScope columnScope, final Function0 function0, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(442929860);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(columnScope) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.v1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return WelcomeScreenKt.i();
                        }
                    };
                    composerK.w(objG);
                }
                function0 = (Function0) objG;
            }
            Function0 function02 = function0;
            if (ComposerKt.M()) {
                ComposerKt.U(442929860, i5, -1, "cz.mobilesoft.coreblock.scene.intro.AlreadyAMemberButton (WelcomeScreen.kt:164)");
            }
            ComposeButtonsV2Kt.d(columnScope.c(PaddingKt.k(Modifier.b8, 0.0f, Dp.g(8), 1, null), Alignment.f25072a.g()), StringResources_androidKt.b(R.string.G0, composerK, 0), function02, composerK, (i5 << 3) & 896, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            function0 = function02;
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.w1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WelcomeScreenKt.j(columnScope, function0, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(ColumnScope columnScope, Function0 function0, int i3, int i4, Composer composer, int i5) {
        h(columnScope, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier n(Function0 function0, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ClickableKt.f(applyIf, false, null, null, function0, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(String str, WelcomeScreenKt$WelcomeScreen$3$uriHandler$1 welcomeScreenKt$WelcomeScreen$3$uriHandler$1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1468999693, i3, -1, "cz.mobilesoft.coreblock.scene.intro.WelcomeScreen.<anonymous>.<anonymous> (WelcomeScreen.kt:143)");
            }
            float f3 = 24;
            TextKt.h(str, PaddingKt.m(Modifier.b8, Dp.g(f3), 0.0f, Dp.g(f3), Dp.g(16), 2, null), ComposeTypographyKt.g(composer, 0).d(), ComposeColorsKt.j(composer, 0).O(), TextAlign.h(TextAlign.f29616b.a()), 0, null, null, new SpanStyle(ComposeColorsKt.j(composer, 0).b(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61438, (DefaultConstructorMarker) null), welcomeScreenKt$WelcomeScreen$3$uriHandler$1, composer, 48, 224);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(boolean z2, Function0 function0, Function0 function02, Function0 function03, int i3, int i4, Composer composer, int i5) {
        k(z2, function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Type inference failed for: r8v12, types: [cz.mobilesoft.coreblock.scene.intro.WelcomeScreenKt$WelcomeScreen$3$uriHandler$1, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(boolean r44, final kotlin.jvm.functions.Function0 r45, kotlin.jvm.functions.Function0 r46, kotlin.jvm.functions.Function0 r47, androidx.compose.runtime.Composer r48, final int r49, final int r50) {
        /*
            Method dump skipped, instruction units count: 1041
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.WelcomeScreenKt.k(boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
