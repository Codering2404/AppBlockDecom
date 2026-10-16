package cz.mobilesoft.coreblock.scene.schedule.summary;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
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
import coil.compose.SingletonAsyncImageKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.detail.App;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.scene.schedule.detail.WebOrKeyword;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.summary.ScheduleSummaryScreenKt;
import cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.PackageManagerHelperKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.graph.BarGraphKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class ScheduleSummaryScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(List list, Modifier modifier, long j3, long j4, long j5, boolean z2, int i3, int i4, Composer composer, int i5) {
        y(list, modifier, j3, j4, j5, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void B(ProfileWithConfiguration profileWithConfiguration, final long j3, ScheduleViewState scheduleViewState, Composer composer, final int i3) {
        final ProfileWithConfiguration profileWithConfiguration2;
        int i4;
        ScheduleViewState scheduleViewState2;
        Composer composer2;
        Modifier.Companion companion;
        int i5;
        Composer composerK = composer.k(-1354446756);
        if ((i3 & 6) == 0) {
            profileWithConfiguration2 = profileWithConfiguration;
            i4 = (composerK.I(profileWithConfiguration2) ? 4 : 2) | i3;
        } else {
            profileWithConfiguration2 = profileWithConfiguration;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            scheduleViewState2 = scheduleViewState;
            i4 |= composerK.Z(scheduleViewState2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            scheduleViewState2 = scheduleViewState;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1354446756, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.summary.SchedulePreviewHeader (ScheduleSummaryScreen.kt:188)");
            }
            boolean z2 = scheduleViewState2.g().k() == ProfileType.USAGE_LIMIT || scheduleViewState2.g().k() == ProfileType.LAUNCH_COUNT;
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
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
            Integer iconResId = profileWithConfiguration2.p().q().getIconResId();
            if (iconResId == null) {
                composerK.a0(-1759059716);
                composerK.U();
                companion = companion2;
                i5 = 0;
            } else {
                composerK.a0(-1759059715);
                companion = companion2;
                i5 = 0;
                ImageKt.a(PainterResources_androidKt.c(iconResId.intValue(), composerK, 0), null, SizeKt.v(companion2, Dp.g(88)), null, null, 0.0f, null, composerK, 432, 120);
                composerK.U();
            }
            SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composerK, 6);
            String strA = profileWithConfiguration2.p().A();
            String strC = StringResources_androidKt.c(z2 ? R.string.ku : R.string.ju, new Object[]{strA}, composerK, i5);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(i5, 1, null);
            builder.l(strC);
            int iN0 = StringsKt.n0(strC, strA, 0, false, 6, null);
            if (iN0 >= 0) {
                builder.f(new SpanStyle(j3, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), iN0, strA.length() + iN0);
            }
            composer2 = composerK;
            TextKt.d(builder.t(), SizeKt.h(companion, 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, null, TextStyle.e(ComposeTypographyKt.g(composerK, i5).f(), ComposeColorsKt.j(composerK, i5).L(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer2, 48, 0, 130556);
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
            final ScheduleViewState scheduleViewState3 = scheduleViewState2;
            scopeUpdateScopeN.a(new Function2() { // from class: o1.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSummaryScreenKt.C(profileWithConfiguration2, j3, scheduleViewState3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(ProfileWithConfiguration profileWithConfiguration, long j3, ScheduleViewState scheduleViewState, int i3, Composer composer, int i4) {
        B(profileWithConfiguration, j3, scheduleViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void D(final long j3, final ScheduleViewState scheduleViewState, final ScheduleViewState.MainCardSummaryData mainCardSummaryData, final ProfileWithConfiguration profileWithConfiguration, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-2057224697);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scheduleViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(mainCardSummaryData) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(profileWithConfiguration) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2057224697, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.summary.ScheduleSummaryMainCard (ScheduleSummaryScreen.kt:288)");
            }
            ProfileType profileTypeK = scheduleViewState.g().k();
            String strM = mainCardSummaryData.m();
            String strK = mainCardSummaryData.k();
            String strL = mainCardSummaryData.l();
            int iJ = mainCardSummaryData.j();
            List listH = mainCardSummaryData.h();
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: o1.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScheduleSummaryScreenKt.E((SchedulePreviewViewEvent) obj);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            SchedulePreviewScreenKt.q0(j3, profileTypeK, null, strM, strK, strL, iJ, false, listH, (Function1) objG, ComposableLambdaKt.e(2099895491, true, new Function2() { // from class: o1.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSummaryScreenKt.F(mainCardSummaryData, profileWithConfiguration, scheduleViewState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(1672625762, true, new Function2() { // from class: o1.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSummaryScreenKt.G(mainCardSummaryData, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), false, false, false, composer2, (i4 & 14) | 817889664, 54, 28672);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: o1.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSummaryScreenKt.H(j3, scheduleViewState, mainCardSummaryData, profileWithConfiguration, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(SchedulePreviewViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(ScheduleViewState.MainCardSummaryData mainCardSummaryData, ProfileWithConfiguration profileWithConfiguration, ScheduleViewState scheduleViewState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2099895491, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.summary.ScheduleSummaryMainCard.<anonymous> (ScheduleSummaryScreen.kt:306)");
            }
            if (mainCardSummaryData.n()) {
                composer.a0(1787963555);
                SchedulePreviewScreenKt.l0(null, profileWithConfiguration, ProfileType.Companion.b(profileWithConfiguration.p().E()), scheduleViewState.d(), false, false, false, false, composer, 0, 241);
                composer.U();
            } else {
                ImmutableList immutableListG = mainCardSummaryData.g();
                if (immutableListG == null || immutableListG.isEmpty()) {
                    composer.a0(1788631419);
                    Integer numC = mainCardSummaryData.c();
                    SchedulePreviewScreenKt.j0(1.0f, numC != null ? numC.intValue() : mainCardSummaryData.j(), RangesKt.f(mainCardSummaryData.j(), 1), 0L, 0L, composer, 6, 24);
                    composer.U();
                } else {
                    composer.a0(1788408839);
                    y(mainCardSummaryData.g(), PaddingKt.k(Modifier.b8, 0.0f, Dp.g(4), 1, null), 0L, 0L, 0L, false, composer, 48, 60);
                    composer.U();
                }
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
    public static final Unit G(ScheduleViewState.MainCardSummaryData mainCardSummaryData, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1672625762, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.summary.ScheduleSummaryMainCard.<anonymous> (ScheduleSummaryScreen.kt:300)");
            }
            O(mainCardSummaryData.d(), mainCardSummaryData.e(), 0L, 0L, composer, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(long j3, ScheduleViewState scheduleViewState, ScheduleViewState.MainCardSummaryData mainCardSummaryData, ProfileWithConfiguration profileWithConfiguration, int i3, Composer composer, int i4) {
        D(j3, scheduleViewState, mainCardSummaryData, profileWithConfiguration, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void I(final cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState r54, java.lang.Float r55, kotlin.jvm.functions.Function0 r56, final kotlin.jvm.functions.Function0 r57, androidx.compose.runtime.Composer r58, final int r59, final int r60) {
        /*
            Method dump skipped, instruction units count: 1452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.summary.ScheduleSummaryScreenKt.I(cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState, java.lang.Float, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(ScheduleViewState scheduleViewState, Float f3, Function0 function0, Function0 function02, int i3, int i4, Composer composer, int i5) {
        I(scheduleViewState, f3, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(ScheduleViewState scheduleViewState, Float f3, Function0 function0, Function0 function02, int i3, int i4, Composer composer, int i5) {
        I(scheduleViewState, f3, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(ScheduleViewState scheduleViewState, Float f3, Function0 function0, Function0 function02, int i3, int i4, Composer composer, int i5) {
        I(scheduleViewState, f3, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x026b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void O(final java.lang.String r59, final java.lang.Integer r60, long r61, long r63, androidx.compose.runtime.Composer r65, final int r66, final int r67) {
        /*
            Method dump skipped, instruction units count: 654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.summary.ScheduleSummaryScreenKt.O(java.lang.String, java.lang.Integer, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float P(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(String str, Integer num, long j3, long j4, int i3, int i4, Composer composer, int i5) {
        O(str, num, j3, j4, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void R(final int r54, final long r55, final java.lang.String r57, androidx.compose.ui.Modifier r58, kotlin.jvm.functions.Function2 r59, final kotlin.jvm.functions.Function2 r60, androidx.compose.runtime.Composer r61, final int r62, final int r63) {
        /*
            Method dump skipped, instruction units count: 881
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.summary.ScheduleSummaryScreenKt.R(int, long, java.lang.String, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(int i3, long j3, String str, Modifier modifier, Function2 function2, Function2 function22, int i4, int i5, Composer composer, int i6) {
        R(i3, j3, str, modifier, function2, function22, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    private static final void s(final long j3, final ProfileWithConfiguration profileWithConfiguration, final ScheduleViewState scheduleViewState, final ScheduleViewState.MainCardSummaryData mainCardSummaryData, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(700074143);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(profileWithConfiguration) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(scheduleViewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(mainCardSummaryData) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(700074143, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.summary.BlockingAndStatsSection (ScheduleSummaryScreen.kt:230)");
            }
            ProfileType profileTypeK = scheduleViewState.g().k();
            ProfileType profileType = ProfileType.USAGE_LIMIT;
            boolean z2 = profileTypeK == profileType || profileTypeK == ProfileType.LAUNCH_COUNT;
            boolean z3 = scheduleViewState.g().k() == profileType;
            boolean z4 = scheduleViewState.g().k() == ProfileType.WIFI || scheduleViewState.g().k() == ProfileType.LOCATION || scheduleViewState.g().k() == ProfileType.COMBINED;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(16));
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, Alignment.f25072a.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
            boolean z5 = profileWithConfiguration.p().o() == Profile.BlockingMode.Blocklist;
            int i5 = ((i4 << 3) & 112) | 196608;
            R(z5 ? R.drawable.X0 : R.drawable.f95573w0, j3, StringResources_androidKt.b(z5 ? R.string.l4 : R.string.k4, composerK, 0), null, null, ComposableLambdaKt.e(1949438263, true, new Function2() { // from class: o1.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSummaryScreenKt.t(profileWithConfiguration, scheduleViewState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, i5, 24);
            if (z4) {
                composerK.a0(1487083353);
            } else {
                composerK.a0(1498027624);
                R(z2 ? R.drawable.A6 : R.drawable.f95582z0, j3, StringResources_androidKt.b(z3 ? R.string.Au : R.string.Bu, composerK, 0), null, z3 ? ComposableSingletons$ScheduleSummaryScreenKt.f117925a.b() : null, ComposableLambdaKt.e(894419516, true, new Function2() { // from class: o1.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScheduleSummaryScreenKt.u(mainCardSummaryData, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerK, 54), composerK, i5, 8);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: o1.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSummaryScreenKt.v(j3, profileWithConfiguration, scheduleViewState, mainCardSummaryData, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(ProfileWithConfiguration profileWithConfiguration, ScheduleViewState scheduleViewState, Composer composer, int i3) throws Exception {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1949438263, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.summary.BlockingAndStatsSection.<anonymous>.<anonymous> (ScheduleSummaryScreen.kt:244)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            TextKt.c(String.valueOf(profileWithConfiguration.i()), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.A(companion, Dp.g(4)), composer, 6);
            w(scheduleViewState, composer, 0);
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
    public static final Unit u(ScheduleViewState.MainCardSummaryData mainCardSummaryData, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(894419516, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.summary.BlockingAndStatsSection.<anonymous>.<anonymous> (ScheduleSummaryScreen.kt:272)");
            }
            TextKt.c(mainCardSummaryData.f(), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(long j3, ProfileWithConfiguration profileWithConfiguration, ScheduleViewState scheduleViewState, ScheduleViewState.MainCardSummaryData mainCardSummaryData, int i3, Composer composer, int i4) {
        s(j3, profileWithConfiguration, scheduleViewState, mainCardSummaryData, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v23 */
    private static final void w(final ScheduleViewState scheduleViewState, Composer composer, final int i3) throws Exception {
        Composer composerK = composer.k(-1095358803);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(scheduleViewState) ? 4 : 2) | i3 : i3;
        ?? r7 = 0;
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1095358803, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.summary.BlockingIconsRow (ScheduleSummaryScreen.kt:434)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = context.getPackageManager();
                composerK.w(objG);
            }
            PackageManager packageManager = (PackageManager) objG;
            ImmutableList immutableListA = scheduleViewState.g().d().a();
            ImmutableList immutableListG = scheduleViewState.g().d().g();
            List<App> listTake = CollectionsKt.take(immutableListA, 10);
            List<WebOrKeyword> listTake2 = CollectionsKt.take(immutableListG, RangesKt.f(10 - listTake.size(), 0));
            Arrangement arrangement = Arrangement.f6574a;
            float fG = Dp.g(-8);
            Alignment.Companion companion = Alignment.f25072a;
            Arrangement.Horizontal horizontalP = arrangement.p(fG, companion.k());
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalP, companion.l(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(1943493173);
            for (App app : listTake) {
                boolean Z = composerK.Z(app.c());
                Object objG2 = composerK.G();
                if (Z || objG2 == Composer.f23746a.a()) {
                    Intrinsics.checkNotNull(packageManager);
                    objG2 = PackageManagerHelperKt.a(packageManager, app.c());
                    composerK.w(objG2);
                }
                Drawable drawable = (Drawable) ((Pair) objG2).b();
                Modifier.Companion companion4 = Modifier.b8;
                float f3 = 24;
                Modifier modifierA = ClipKt.a(SizeKt.v(companion4, Dp.g(f3)), RoundedCornerShapeKt.g());
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), r7);
                int iA2 = ComposablesKt.a(composerK, r7);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierA);
                ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                Function0 function0A2 = companion5.a();
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
                Updater.e(composerA2, measurePolicyG, companion5.e());
                Updater.e(composerA2, compositionLocalMapU2, companion5.g());
                Function2 function2B2 = companion5.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion5.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                Composer composer2 = composerK;
                SingletonAsyncImageKt.b(drawable, null, SizeKt.v(companion4, Dp.g(f3)), null, null, PainterResources_androidKt.c(R.drawable.H6, composerK, r7), null, null, null, null, null, 0.0f, null, 0, composer2, 432, 0, 16344);
                composerK = composer2;
                composerK.y();
                r7 = r7 == true ? 1 : 0;
                packageManager = packageManager;
            }
            ?? r2 = r7;
            composerK.U();
            composerK.a0(1943512527);
            for (WebOrKeyword webOrKeyword : listTake2) {
                Modifier.Companion companion6 = Modifier.b8;
                Modifier modifierD = BackgroundKt.d(ClipKt.a(SizeKt.v(companion6, Dp.g(24)), RoundedCornerShapeKt.g()), ComposeColorsKt.j(composerK, r2 == true ? 1 : 0).l0(), null, 2, null);
                MeasurePolicy measurePolicyG2 = BoxKt.g(Alignment.f25072a.e(), r2);
                int iA3 = ComposablesKt.a(composerK, r2 == true ? 1 : 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierD);
                ComposeUiNode.Companion companion7 = ComposeUiNode.f8;
                Function0 function0A3 = companion7.a();
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
                Updater.e(composerA3, measurePolicyG2, companion7.e());
                Updater.e(composerA3, compositionLocalMapU3, companion7.g());
                Function2 function2B3 = companion7.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion7.f());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                BaseWebsiteSelectionScreenKt.D(webOrKeyword.a(), ClipKt.a(SizeKt.v(companion6, Dp.g(20)), RoundedCornerShapeKt.g()), composerK, r2 == true ? 1 : 0, r2 == true ? 1 : 0);
                composerK.y();
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: o1.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScheduleSummaryScreenKt.x(scheduleViewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(ScheduleViewState scheduleViewState, int i3, Composer composer, int i4) throws Exception {
        w(scheduleViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void y(final java.util.List r20, androidx.compose.ui.Modifier r21, long r22, long r24, long r26, boolean r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.summary.ScheduleSummaryScreenKt.y(java.util.List, androidx.compose.ui.Modifier, long, long, long, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(long j3, List list, boolean z2, long j4, long j5, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fM1 = Canvas.M1(Dp.g(4));
        float fIntBitsToFloat = (Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) - fM1) / 2.0f;
        float f3 = fM1 / 2.0f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (Canvas.b() >> 32));
        DrawScope.f2(Canvas, j3, Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L)), Size.d((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fM1)) & 4294967295L)), CornerRadius.b((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), null, 0.0f, null, 0, 240, null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            float fFloatValue = ((Number) pair.a()).floatValue() * fIntBitsToFloat2;
            DrawScope.f2(Canvas, j5, Offset.e((((long) Float.floatToRawIntBits(fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L)), Size.d((((long) Float.floatToRawIntBits((((Number) pair.b()).floatValue() * fIntBitsToFloat2) - fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(fM1)) & 4294967295L)), CornerRadius.b((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), null, 0.0f, null, 0, 240, null);
        }
        if (z2) {
            BarGraphKt.u(Canvas, j4, true);
        }
        return Unit.f139807a;
    }
}
