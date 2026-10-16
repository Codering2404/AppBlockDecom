package cz.mobilesoft.coreblock.scene.app_feel.screens;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppFeelSummaryScreenKt {
    public static final void c(final AppFeelViewState viewState, Function0 onFinishClicked, Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final Function0 function0;
        final Function0 function02;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onFinishClicked, "onFinishClicked");
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(-648651375);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onFinishClicked) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onContinueClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-648651375, i4, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelSummaryScreen (AppFeelSummaryScreen.kt:50)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = context.getApplicationContext().getPackageManager();
                composerK.w(objG);
            }
            final PackageManager packageManager = (PackageManager) objG;
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.k(BackgroundKt.d(SizeKt.f(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).e(), null, 2, null), Dp.g(f3), 0.0f, 2, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.g(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierG);
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
            String strB = StringResources_androidKt.b(R.string.f95768a1, composerK, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 0, 0, 65022);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Z0, composerK, 0), null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65018);
            Modifier modifierK = PaddingKt.k(ColumnScope.b(columnScopeInstance, SizeKt.h(companion, 0.0f, 1, null), 1.0f, false, 2, null), 0.0f, Dp.g(f3), 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.e(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            FlowLayoutKt.d(SizeKt.h(companion, 0.0f, 1, null), arrangement.p(Dp.g(f3), companion2.g()), arrangement.q(Dp.g(f3), companion2.i()), null, 0, 0, ComposableLambdaKt.e(1367197840, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.u0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppFeelSummaryScreenKt.d(viewState, packageManager, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 1573302, 56);
            composerK.y();
            int i5 = i4;
            ComposeButtonsKt.J(null, StringResources_androidKt.b(R.string.Ue, composerK, 0), false, false, null, onFinishClicked, composerK, ((i4 << 12) & 458752) | 3072, 21);
            function0 = onFinishClicked;
            if (viewState.g().isEmpty()) {
                composer2 = composerK;
                function02 = onContinueClicked;
                composer2.a0(-1949130105);
            } else {
                composerK.a0(-1943631914);
                int i6 = (i5 << 3) & 7168;
                function02 = onContinueClicked;
                ComposeButtonsKt.i0(null, new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.T0, composerK, 0), 0.0f, 11, null), new ButtonColor.SurfaceContrast(false, null, false, null, 15, null), function02, composerK, i6, 1);
                composer2 = composerK;
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            function0 = onFinishClicked;
            function02 = onContinueClicked;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.v0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppFeelSummaryScreenKt.e(viewState, function0, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    public static final Unit d(AppFeelViewState appFeelViewState, PackageManager packageManager, FlowRowScope FlowRow, Composer composer, int i3) throws XmlPullParserException, IOException {
        long jB;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        ?? r10 = 0;
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1367197840, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelSummaryScreen.<anonymous>.<anonymous>.<anonymous> (AppFeelSummaryScreen.kt:90)");
            }
            List listE = appFeelViewState.e();
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listE) {
                if (hashSet.add((String) ((Pair) obj).e())) {
                    arrayList.add(obj);
                }
            }
            int i4 = 0;
            for (Object obj2 : CollectionsKt.take(arrayList, 5)) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) obj2;
                String str = (String) pair.e();
                AppDistractionType appDistractionType = (AppDistractionType) pair.f();
                boolean Z = composer2.Z(str);
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    Intrinsics.checkNotNull(packageManager);
                    objG = appFeelViewState.c(packageManager, str);
                    composer2.w(objG);
                }
                Drawable drawable = (Drawable) ((Pair) objG).b();
                Alignment alignmentC = Alignment.f25072a.c();
                Modifier.Companion companion = Modifier.b8;
                MeasurePolicy measurePolicyG = BoxKt.g(alignmentC, r10);
                int iA = ComposablesKt.a(composer2, r10);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, companion);
                ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                Function0 function0A = companion2.a();
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
                Updater.e(composerA, measurePolicyG, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                ImageKt.a(DrawablePainterKt.e(drawable, composer2, r10), null, ClipKt.a(SizeKt.v(companion, Dp.g(48)), RoundedCornerShapeKt.g()), null, null, 0.0f, null, composer, 48, 120);
                float f3 = 10;
                Modifier modifierC = OffsetKt.c(SizeKt.v(companion, Dp.g(32)), Dp.g(f3), Dp.g(f3));
                ImageVector imageVectorB = null;
                Color colorN = appDistractionType != null ? Color.n(appDistractionType.m1357getColor0d7_KjU()) : null;
                if (colorN == null) {
                    composer.a0(-1259904688);
                    jB = ComposeColorsKt.j(composer, 0).c0();
                    composer.U();
                } else {
                    composer.a0(-1259906052);
                    composer.U();
                    jB = colorN.B();
                }
                Modifier modifierC2 = BackgroundKt.c(modifierC, jB, RoundedCornerShapeKt.g());
                Integer numValueOf = appDistractionType != null ? Integer.valueOf(appDistractionType.getIconRes()) : null;
                if (numValueOf == null) {
                    composer.a0(-402229458);
                } else {
                    composer.a0(-402229457);
                    imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, numValueOf.intValue(), composer, 6);
                }
                composer.U();
                if (imageVectorB == null) {
                    imageVectorB = CloseKt.a(Icons.f15145a.a());
                }
                IconKt.d(imageVectorB, null, modifierC2, ComposeColorsKt.j(composer, 0).q0(), composer, 48, 0);
                composer.y();
                composer2 = composer;
                r10 = 0;
                i4 = i5;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(AppFeelViewState appFeelViewState, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        c(appFeelViewState, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
