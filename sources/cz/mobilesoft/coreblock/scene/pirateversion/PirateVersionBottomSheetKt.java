package cz.mobilesoft.coreblock.scene.pirateversion;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.material.ChipColors;
import androidx.compose.material.ChipDefaults;
import androidx.compose.material.ChipKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.BottomSheetType;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class PirateVersionBottomSheetKt {
    public static final void e(final Function0 onOpenGooglePlay, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onOpenGooglePlay, "onOpenGooglePlay");
        Composer composerK = composer.k(-1361003196);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onOpenGooglePlay) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1361003196, i4, -1, "cz.mobilesoft.coreblock.scene.pirateversion.PirateVersionBottomSheet (PirateVersionBottomSheet.kt:48)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            ComposeBottomSheetsKt.f(new BottomSheetType.FullScreen(0.0f, 1, null), MaterialTheme.f13091a.b(composerK, MaterialTheme.f13092b).c().a(CornerSizeKt.c(Dp.g(0))), true, ComposableLambdaKt.e(1033958467, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.pirateversion.b
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return PirateVersionBottomSheetKt.f(onOpenGooglePlay, coroutineScope, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), null, null, composerK, 3456, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.pirateversion.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PirateVersionBottomSheetKt.i(onOpenGooglePlay, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function0 function0, final CoroutineScope coroutineScope, ColumnScope AppBottomSheet, final SheetState state, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(state, "state");
        if ((i3 & 48) == 0) {
            i4 = i3 | (composer.Z(state) ? 32 : 16);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 145) != 144, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1033958467, i4, -1, "cz.mobilesoft.coreblock.scene.pirateversion.PirateVersionBottomSheet.<anonymous> (PirateVersionBottomSheet.kt:57)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.f(companion, 0.0f, 1, null), Dp.g(f3));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.h(), false);
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
            ImageVector.Companion companion4 = ImageVector.f26323k;
            ImageVector imageVectorB = VectorResources_androidKt.b(companion4, R.drawable.C1, composer, 6);
            boolean zI = ((i4 & 112) == 32) | composer.I(coroutineScope);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.pirateversion.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PirateVersionBottomSheetKt.g(coroutineScope, state);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, 0L, null, (Function0) objG, composer, 0, 253);
            composer.y();
            SpacerKt.a(SizeKt.v(companion, Dp.g(8)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.GC, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            TextKt.c(strB, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65022);
            float f4 = 12;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.FC, composer, 0), null, ComposeColorsKt.j(composer, 0).M(), TextUnitKt.i(13), null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 3072, 0, 65010);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            Modifier modifierI2 = SizeKt.i(companion, Dp.g(24));
            ChipColors chipColorsA = ChipDefaults.f12397a.a(ComposeColorsKt.j(composer, 0).k(), ComposeColorsKt.j(composer, 0).q0(), 0L, 0L, 0L, 0L, composer, ChipDefaults.f12402f << 18, 60);
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.pirateversion.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PirateVersionBottomSheetKt.h();
                    }
                };
                composer.w(objG2);
            }
            ChipKt.a((Function0) objG2, modifierI2, false, null, null, null, chipColorsA, null, ComposableSingletons$PirateVersionBottomSheetKt.f112328a.b(), composer, 100663350, 188);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            ImageKt.b(VectorResources_androidKt.b(companion4, DarkThemeKt.a(composer, 0) ? R.drawable.Q7 : R.drawable.R7, composer, 6), "Pirate Copy Image", null, null, null, 0.0f, null, composer, 48, 124);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            ComposeButtonsKt.i0(SizeKt.h(companion, 0.0f, 1, null), new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.EC, composer, 0), 0.0f, 11, null), new ButtonColor.Accent(false, null, false, null, 15, null), function0, composer, 6, 0);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
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
    public static final Unit g(CoroutineScope coroutineScope, SheetState sheetState) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new PirateVersionBottomSheetKt$PirateVersionBottomSheet$1$1$1$1$1$1(sheetState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function0 function0, int i3, Composer composer, int i4) {
        e(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
