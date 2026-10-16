package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
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
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.enums.ScheduleTemplate;
import cz.mobilesoft.coreblock.enums.SeasonalTemplateColors;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.IconCircleBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.LabelsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ScheduleTemplatesSectionKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f99977a;

        static {
            int[] iArr = new int[SeasonalTemplateColors.values().length];
            try {
                iArr[SeasonalTemplateColors.Purple.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SeasonalTemplateColors.Green.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SeasonalTemplateColors.Blue.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SeasonalTemplateColors.Red.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SeasonalTemplateColors.Orange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f99977a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(ScheduleTemplate it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(ScheduleTemplate it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Modifier modifier, ScheduleTemplate scheduleTemplate, Function1 function1, Function1 function12, int i3, int i4, Composer composer, int i5) {
        z(modifier, scheduleTemplate, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Function1 function1, ScheduleTemplate scheduleTemplate) {
        function1.invoke(scheduleTemplate);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(final Function1 function1, final ScheduleTemplate scheduleTemplate, final Function1 function12, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1721268565, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.SeasonTemplate.<anonymous> (ScheduleTemplatesSection.kt:153)");
            }
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            long jQ = ComposeColorsKt.j(composer, 0).q();
            Modifier modifierF2 = boxScopeInstance.f(companion, companion2.n());
            boolean Z = composer.Z(function1) | composer.e(scheduleTemplate.ordinal());
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.b1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleTemplatesSectionKt.F(function1, scheduleTemplate);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(modifierF2, imageVectorB, null, false, 0.0f, 0.0f, jQ, null, (Function0) objG, composer, 0, 188);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion2.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(companion, Dp.g(f3), Dp.g(f3), Dp.g(f3), 0.0f, 8, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composer, 0);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierM);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyA2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion3.f());
            LabelsKt.e(StringResources_androidKt.b(R.string.dE, composer, 0), ComposeColorsKt.j(composer, 0).q0(), S(scheduleTemplate, composer, 0), 0.0f, 0.0f, null, Integer.valueOf(R.drawable.kb), composer, 0, 56);
            float f4 = 8;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(scheduleTemplate.getSeasonalTitle().intValue(), composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion, Dp.g(10)), composer, 6);
            TextKt.c(StringResources_androidKt.b(scheduleTemplate.getSeasonalSubtitle().intValue(), composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            composer.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(18)), composer, 6);
            long jH = ColorKt.h(ComposeColorsKt.j(composer, 0).v(), Color.r(S(scheduleTemplate, composer, 0), 0.3f, 0.0f, 0.0f, 0.0f, 14, null));
            Modifier modifierM2 = PaddingKt.m(companion, Dp.g(f4), 0.0f, Dp.g(f4), Dp.g(f4), 2, null);
            boolean Z2 = composer.Z(function12) | composer.e(scheduleTemplate.ordinal());
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.c1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleTemplatesSectionKt.G(function12, scheduleTemplate);
                    }
                };
                composer.w(objG2);
            }
            N(scheduleTemplate, jH, (Function0) objG2, modifierM2, composer, 0, 0);
            composer.y();
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
    public static final Unit F(Function1 function1, ScheduleTemplate scheduleTemplate) {
        function1.invoke(scheduleTemplate);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1, ScheduleTemplate scheduleTemplate) {
        function1.invoke(scheduleTemplate);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Modifier modifier, ScheduleTemplate scheduleTemplate, Function1 function1, Function1 function12, int i3, int i4, Composer composer, int i5) {
        z(modifier, scheduleTemplate, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void I(final cz.mobilesoft.coreblock.enums.ScheduleTemplate r48, kotlin.jvm.functions.Function1 r49, androidx.compose.runtime.Composer r50, final int r51, final int r52) {
        /*
            Method dump skipped, instruction units count: 603
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.ScheduleTemplatesSectionKt.I(cz.mobilesoft.coreblock.enums.ScheduleTemplate, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(ScheduleTemplate it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(ScheduleTemplate scheduleTemplate, Function1 function1, int i3, int i4, Composer composer, int i5) {
        I(scheduleTemplate, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Function1 function1, ScheduleTemplate scheduleTemplate) {
        function1.invoke(scheduleTemplate);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(ScheduleTemplate scheduleTemplate, Function1 function1, int i3, int i4, Composer composer, int i5) {
        I(scheduleTemplate, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void N(cz.mobilesoft.coreblock.enums.ScheduleTemplate r22, long r23, final kotlin.jvm.functions.Function0 r25, androidx.compose.ui.Modifier r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.ScheduleTemplatesSectionKt.N(cz.mobilesoft.coreblock.enums.ScheduleTemplate, long, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void O(final int i3, final int i4, final ScheduleEmoji emoji, final String stateString, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        Intrinsics.checkNotNullParameter(stateString, "stateString");
        Composer composerK = composer.k(2050502724);
        if ((i5 & 6) == 0) {
            i6 = (composerK.e(i3) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composerK.e(i4) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= composerK.e(emoji.ordinal()) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 3072) == 0) {
            i6 |= composerK.Z(stateString) ? 2048 : 1024;
        }
        if (composerK.r((i6 & 1171) != 1170, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2050502724, i6, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.TemplateCardContent (ScheduleTemplatesSection.kt:268)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 12;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            ImageVector.Companion companion4 = ImageVector.f26323k;
            float f4 = 32;
            int i7 = i6;
            ImageKt.b(VectorResources_androidKt.b(companion4, i3, composerK, ((i6 << 3) & 112) | 6), null, boxScopeInstance.f(SizeKt.v(companion, Dp.g(f4)), companion2.o()), null, null, 0.0f, null, composerK, 48, 120);
            Alignment.Horizontal horizontalG = companion2.g();
            Modifier modifierM2 = PaddingKt.m(boxScopeInstance.f(companion, companion2.m()), 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM2);
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
            float f5 = 8;
            float f6 = 56;
            Modifier modifierI = SizeKt.i(SizeKt.h(SizeKt.E(PaddingKt.m(companion, 0.0f, Dp.g(20), 0.0f, Dp.g(f5), 5, null), null, true, 1, null), 0.0f, 1, null), Dp.g(f6));
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.e(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierI);
            Function0 function0A3 = companion3.a();
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
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            Integer iconResId = emoji.getIconResId();
            ImageKt.a(PainterResources_androidKt.c(iconResId != null ? iconResId.intValue() : R.drawable.o9, composerK, 0), null, SizeKt.v(companion, Dp.g(f6)), null, null, 0.0f, null, composerK, 432, 120);
            composerK.y();
            String strB = StringResources_androidKt.b(i4, composerK, (i7 >> 3) & 14);
            TextStyle textStyleG = ComposeTypographyKt.g(composerK, 0).g();
            long jP = ComposeColorsKt.j(composerK, 0).p();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            TextKt.c(strB, null, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, textStyleG, composerK, 0, 0, 65018);
            TextKt.c(stateString, PaddingKt.m(companion, 0.0f, Dp.g(f5), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composerK, 0).s(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, ((i7 >> 9) & 14) | 48, 0, 65016);
            composerK.y();
            IconCircleBackgroundKt.c(boxScopeInstance.f(companion, companion2.n()), Dp.g(f4), 0.0f, VectorResources_androidKt.b(companion4, R.drawable.f95558r0, composerK, 6), ComposeColorsKt.j(composerK, 0).b(), ComposeColorsKt.j(composerK, 0).l0(), null, composerK, 48, 68);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.d1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleTemplatesSectionKt.P(i3, i4, emoji, stateString, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(int i3, int i4, ScheduleEmoji scheduleEmoji, String str, int i5, Composer composer, int i6) {
        O(i3, i4, scheduleEmoji, str, composer, RecomposeScopeImplKt.a(i5 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(ScheduleTemplate scheduleTemplate, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-288804401, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.TemplateCard.<anonymous> (ScheduleTemplatesSection.kt:251)");
            }
            O(scheduleTemplate.getStateIcon(), scheduleTemplate.getTitle(), scheduleTemplate.getEmoji(), scheduleTemplate.getStateString((Context) composer.q(AndroidCompositionLocals_androidKt.g())), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(ScheduleTemplate scheduleTemplate, long j3, Function0 function0, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        N(scheduleTemplate, j3, function0, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final long S(ScheduleTemplate scheduleTemplate, Composer composer, int i3) {
        long jX;
        if (ComposerKt.M()) {
            ComposerKt.U(374836070, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.getSeasonalTemplateColor (ScheduleTemplatesSection.kt:337)");
        }
        SeasonalTemplateColors seasonalTemplateColor = scheduleTemplate.getSeasonalTemplateColor();
        int i4 = seasonalTemplateColor == null ? -1 : WhenMappings.f99977a[seasonalTemplateColor.ordinal()];
        if (i4 == -1) {
            composer.a0(-559777803);
            jX = ComposeColorsKt.j(composer, 0).X();
            composer.U();
        } else if (i4 == 1) {
            composer.a0(-559785012);
            jX = ComposeColorsKt.j(composer, 0).a0();
            composer.U();
        } else if (i4 == 2) {
            composer.a0(-559783413);
            jX = ComposeColorsKt.j(composer, 0).A();
            composer.U();
        } else if (i4 == 3) {
            composer.a0(-559781876);
            jX = ComposeColorsKt.j(composer, 0).b();
            composer.U();
        } else if (i4 == 4) {
            composer.a0(-559780338);
            jX = ComposeColorsKt.j(composer, 0).k();
            composer.U();
        } else {
            if (i4 != 5) {
                composer.a0(-559787380);
                composer.U();
                throw new NoWhenBranchMatchedException();
            }
            composer.a0(-559778644);
            jX = ComposeColorsKt.j(composer, 0).V();
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jX;
    }

    public static final void t(Modifier modifier, final boolean z2, final Function1 onEvent, Composer composer, final int i3, final int i4) throws XmlPullParserException, IOException {
        Modifier modifier2;
        int i5;
        Composer composer2;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-1067775444);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1067775444, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.ScheduleTemplatesHeader (ScheduleTemplatesSection.kt:56)");
            }
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(BackgroundKt.d(SizeKt.h(modifier4, 0.0f, 1, null), Color.f25715b.j(), null, 2, null), 0.0f, Dp.g(f3), 0.0f, Dp.g(f3), 5, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion3, 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH);
            Function0 function0A2 = companion2.a();
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
            Updater.e(composerA2, measurePolicyG, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            int i7 = i5;
            TextKt.c(StringResources_androidKt.b(R.string.AC, composerK, 0), boxScopeInstance.f(companion3, companion.h()), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 0, 0, 65532);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, z2 ? R.drawable.f95560s : R.drawable.R2, composerK, 6);
            long jS = ComposeColorsKt.j(composerK, 0).s();
            float fG = Dp.g(24);
            Modifier modifierF3 = boxScopeInstance.f(companion3, companion.f());
            boolean z3 = (i7 & 896) == 256;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.u0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ScheduleTemplatesSectionKt.u(onEvent);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifier5 = modifier4;
            ComposeButtonsKt.q0(modifierF3, imageVectorB, null, false, fG, 0.0f, jS, "", (Function0) objG, composerK, 12607488, 44);
            composerK.y();
            SpacerKt.a(SizeKt.k(companion3, Dp.g(4), 0.0f, 2, null), composerK, 6);
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.b(R.string.zC, composerK, 0), null, ComposeColorsKt.j(composerK, 0).s(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composer2, 0, 0, 65530);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.e1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleTemplatesSectionKt.v(modifier3, z2, onEvent, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function1 function1) {
        function1.invoke(BlockingScreenViewEvent.OnTemplatesVisibilityChanged.f99555a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Modifier modifier, boolean z2, Function1 function1, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        t(modifier, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void w(androidx.compose.ui.Modifier r22, cz.mobilesoft.coreblock.enums.ScheduleTemplate r23, final kotlin.jvm.functions.Function1 r24, kotlin.jvm.functions.Function1 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.ScheduleTemplatesSectionKt.w(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.enums.ScheduleTemplate, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(ScheduleTemplate it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Modifier modifier, ScheduleTemplate scheduleTemplate, Function1 function1, Function1 function12, int i3, int i4, Composer composer, int i5) {
        w(modifier, scheduleTemplate, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void z(androidx.compose.ui.Modifier r25, final cz.mobilesoft.coreblock.enums.ScheduleTemplate r26, kotlin.jvm.functions.Function1 r27, kotlin.jvm.functions.Function1 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.blocking.ScheduleTemplatesSectionKt.z(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.enums.ScheduleTemplate, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
