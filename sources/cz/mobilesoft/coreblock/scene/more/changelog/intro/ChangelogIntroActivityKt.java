package cz.mobilesoft.coreblock.scene.more.changelog.intro;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.IconedRowKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ChangelogIntroActivityKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f107008a;

        static {
            int[] iArr = new int[NavItem.values().length];
            try {
                iArr[NavItem.NAV_FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NavItem.NAV_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NavItem.NAV_THIRD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f107008a = iArr;
        }
    }

    private static final void h(final NavItem navItem, final Function0 function0, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        Composer composerK = composer.k(1383841465);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(navItem.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1383841465, i4, -1, "cz.mobilesoft.coreblock.scene.more.changelog.intro.BackOrCloseButton (ChangelogIntroActivity.kt:160)");
            }
            ImageVector.Companion companion = ImageVector.f26323k;
            NavItem navItem2 = NavItem.NAV_FIRST;
            ComposeButtonsKt.q0(PaddingKt.m(Modifier.b8, Dp.g(12), Dp.g(6), 0.0f, 0.0f, 12, null), VectorResources_androidKt.b(companion, navItem == navItem2 ? R.drawable.C1 : R.drawable.G0, composerK, 6), null, false, 0.0f, 0.0f, ComposeColorsKt.j(composerK, 0).O(), StringResources_androidKt.b(navItem == navItem2 ? R.string.Re : R.string.N7, composerK, 0), function0, composerK, (i4 << 21) & 234881024, 60);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChangelogIntroActivityKt.i(navItem, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(NavItem navItem, Function0 function0, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        h(navItem, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final NavItem navItem, final Function0 function0, final Function0 function02, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(1768293645);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(navItem.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function02) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1768293645, i4, -1, "cz.mobilesoft.coreblock.scene.more.changelog.intro.ChangelogIntroScreen (ChangelogIntroActivity.kt:128)");
            }
            composer2 = composerK;
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(-171021550, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChangelogIntroActivityKt.k(navItem, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-960793269, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ChangelogIntroActivityKt.l(navItem, function02, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 384, 12582912, 131067);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChangelogIntroActivityKt.m(navItem, function0, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(NavItem navItem, Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-171021550, i3, -1, "cz.mobilesoft.coreblock.scene.more.changelog.intro.ChangelogIntroScreen.<anonymous> (ChangelogIntroActivity.kt:131)");
            }
            h(navItem, function0, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(NavItem navItem, Function0 function0, PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-960793269, i4, -1, "cz.mobilesoft.coreblock.scene.more.changelog.intro.ChangelogIntroScreen.<anonymous> (ChangelogIntroActivity.kt:134)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(PaddingKt.j(PaddingKt.h(companion, paddingValues), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), PrimitiveResources_androidKt.a(R.dimen.f95468b, composer, 0)), 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
            Updater.e(composerA, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            int i5 = WhenMappings.f107008a[navItem.ordinal()];
            if (i5 == 1) {
                composer.a0(-961396178);
                n(boxScopeInstance, composer, 6);
                composer.U();
            } else if (i5 == 2) {
                composer.a0(-961393760);
                p(composer, 0);
                composer.U();
            } else {
                if (i5 != 3) {
                    composer.a0(-961397956);
                    composer.U();
                    throw new NoWhenBranchMatchedException();
                }
                composer.a0(-961391809);
                r(composer, 0);
                composer.U();
            }
            ComposeButtonsKt.i0(boxScopeInstance.f(companion, companion2.b()), new ButtonType.Big(null, null, StringResources_androidKt.b(navItem == NavItem.NAV_THIRD ? R.string.Se : R.string.Gk, composer, 0), 0.0f, 11, null), new ButtonColor.Accent(false, null, true, null, 11, null), function0, composer, 0, 0);
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
    public static final Unit m(NavItem navItem, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        j(navItem, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void n(final BoxScope boxScope, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(1150276569);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(boxScope) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1150276569, i4, -1, "cz.mobilesoft.coreblock.scene.more.changelog.intro.ContentFirst (ChangelogIntroActivity.kt:174)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = SizeKt.d(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.c(companion, 0.15f), composerK, 6);
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), Dp.g(30));
            String strB = StringResources_androidKt.b(R.string.Vh, composerK, 0);
            TextAlign.Companion companion3 = TextAlign.f29616b;
            composer2 = composerK;
            TextKt.c(strB, modifierJ, ComposeColorsKt.j(composerK, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).e(), 0L, TextUnitKt.i(46), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composer2, 48, 0, 65016);
            TextKt.c(StringResources_androidKt.b(R.string.Uh, composer2, 0), PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).a(), composer2, 48, 0, 65020);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChangelogIntroActivityKt.o(boxScope, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(BoxScope boxScope, int i3, Composer composer, int i4) {
        n(boxScope, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void p(Composer composer, final int i3) {
        Composer composer2;
        Composer composerK = composer.k(-183154212);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-183154212, i3, -1, "cz.mobilesoft.coreblock.scene.more.changelog.intro.ContentSecond (ChangelogIntroActivity.kt:200)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = SizeKt.d(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(12), 0.0f, Dp.g(22), 5, null);
            TextStyle textStyleG = ComposeTypographyKt.g(composerK, 0).g();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.b(R.string.U6, composerK, 0), modifierM, ComposeColorsKt.j(composerK, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleG, composer2, 48, 0, 65016);
            TextKt.c(StringResources_androidKt.b(R.string.T6, composer2, 0), PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).a(), composer2, 48, 0, 65020);
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.F7, composer2, 6), null, PaddingKt.m(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(40), 0.0f, 0.0f, 13, null), null, ContentScale.f27054a.e(), 0.0f, null, composer2, 25008, 104);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChangelogIntroActivityKt.q(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(int i3, Composer composer, int i4) {
        p(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void r(Composer composer, final int i3) {
        Composer composerK = composer.k(-1610751975);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1610751975, i3, -1, "cz.mobilesoft.coreblock.scene.more.changelog.intro.ContentThird (ChangelogIntroActivity.kt:235)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = SizeKt.d(companion, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 22;
            TextKt.c(StringResources_androidKt.b(R.string.X6, composerK, 0), PaddingKt.m(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null), 0.0f, Dp.g(12), 0.0f, Dp.g(f3), 5, null), ComposeColorsKt.j(composerK, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 48, 0, 65016);
            composerK = composerK;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(24), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ImageVector.Companion companion4 = ImageVector.f26323k;
            IconedRowKt.b(VectorResources_androidKt.b(companion4, R.drawable.Z0, composerK, 6), ComposeColorsKt.j(composerK, 0).b(), null, null, StringResources_androidKt.b(R.string.x4, composerK, 0), StringResources_androidKt.b(R.string.V6, composerK, 0), null, 0.0f, composerK, 0, 204);
            IconedRowKt.b(VectorResources_androidKt.b(companion4, R.drawable.X5, composerK, 6), ColorKt.d(4294939904L), null, null, StringResources_androidKt.b(R.string.PD, composerK, 0), null, null, 0.0f, composerK, 48, 236);
            IconedRowKt.b(VectorResources_androidKt.b(companion4, R.drawable.G5, composerK, 6), ComposeColorsKt.j(composerK, 0).k(), null, null, StringResources_androidKt.b(R.string.OD, composerK, 0), null, null, 0.0f, composerK, 0, 236);
            IconedRowKt.b(VectorResources_androidKt.b(companion4, R.drawable.N6, composerK, 6), ColorKt.d(4283482021L), null, null, StringResources_androidKt.b(R.string.mk, composerK, 0), StringResources_androidKt.b(R.string.W6, composerK, 0), null, 0.0f, composerK, 48, 204);
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.intro.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChangelogIntroActivityKt.s(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(int i3, Composer composer, int i4) {
        r(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
