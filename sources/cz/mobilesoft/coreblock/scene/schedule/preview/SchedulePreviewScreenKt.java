package cz.mobilesoft.coreblock.scene.schedule.preview;

import android.content.Context;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
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
import androidx.compose.ui.unit.TextUnitKt;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState;
import cz.mobilesoft.coreblock.scene.schedule.summary.ScheduleSummaryScreenKt;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ImmutableList;
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
public final class SchedulePreviewScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(Function1 function1) {
        function1.invoke(SchedulePreviewViewEvent.OnProfilePausedFromCard.f117402a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(SchedulePreviewViewState schedulePreviewViewState, Function1 function1, boolean z2, boolean z3, int i3, int i4, Composer composer, int i5) {
        r0(schedulePreviewViewState, function1, z2, z3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec C0(Transition.Segment animateDp, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animateDp, "$this$animateDp");
        composer.a0(-1313163880);
        if (ComposerKt.M()) {
            ComposerKt.U(-1313163880, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.ScheduleMainCardActions.<anonymous> (SchedulePreviewScreen.kt:1075)");
        }
        TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, null, 6, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return tweenSpecN;
    }

    private static final float D0(State state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec E0(Transition.Segment animateFloat, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
        composer.a0(940462213);
        if (ComposerKt.M()) {
            ComposerKt.U(940462213, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.ScheduleMainCardActions.<anonymous> (SchedulePreviewScreen.kt:1084)");
        }
        TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, null, 6, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return tweenSpecN;
    }

    private static final float F0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec G0(Transition.Segment animateDp, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animateDp, "$this$animateDp");
        composer.a0(-2084714997);
        if (ComposerKt.M()) {
            ComposerKt.U(-2084714997, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.ScheduleMainCardActions.<anonymous> (SchedulePreviewScreen.kt:1093)");
        }
        TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, null, 6, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return tweenSpecN;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void H0(androidx.compose.ui.Modifier r27, final cz.mobilesoft.coreblock.enums.ProfileType r28, cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState r29, final java.lang.String r30, final java.lang.String r31, java.lang.String r32, final int r33, final boolean r34, final java.util.List r35, kotlin.jvm.functions.Function2 r36, boolean r37, boolean r38, float r39, androidx.compose.runtime.Composer r40, final int r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.H0(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.enums.ProfileType, cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState, java.lang.String, java.lang.String, java.lang.String, int, boolean, java.util.List, kotlin.jvm.functions.Function2, boolean, boolean, float, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(Modifier modifier, ProfileType profileType, SchedulePreviewViewState schedulePreviewViewState, String str, String str2, String str3, int i3, boolean z2, List list, Function2 function2, boolean z3, boolean z4, float f3, int i4, int i5, int i6, Composer composer, int i7) {
        H0(modifier, profileType, schedulePreviewViewState, str, str2, str3, i3, z2, list, function2, z3, z4, f3, composer, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), i6);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(String str, String str2, String str3, ProfileType profileType, boolean z2, Color color, float f3, int i3, int i4, Composer composer, int i5) {
        J0(str, str2, str3, profileType, z2, color, f3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void L0(final boolean r68, final java.util.List r69, androidx.compose.ui.graphics.Color r70, kotlin.jvm.functions.Function2 r71, boolean r72, float r73, androidx.compose.runtime.Composer r74, final int r75, final int r76) {
        /*
            Method dump skipped, instruction units count: 711
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.L0(boolean, java.util.List, androidx.compose.ui.graphics.Color, kotlin.jvm.functions.Function2, boolean, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier M0(RowScope rowScope, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return RowScope.c(rowScope, applyIf, 1.0f, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(boolean z2, List list, Color color, Function2 function2, boolean z3, float f3, int i3, int i4, Composer composer, int i5) {
        L0(z2, list, color, function2, z3, f3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(Function2 function2, ProfileType profileType, SchedulePreviewViewState schedulePreviewViewState, String str, String str2, String str3, int i3, boolean z2, List list, Function2 function22, boolean z3, boolean z4, Function1 function1, boolean z5, ColumnScope BaseCard, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(349515796, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.ScheduleMainCard.<anonymous> (SchedulePreviewScreen.kt:831)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (function2 == null) {
                composer.a0(1086895436);
            } else {
                composer.a0(1086895437);
                function2.invoke(composer, 0);
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            }
            composer.U();
            H0(null, profileType, schedulePreviewViewState, str, str2, str3, i3, z2, list, function22, z3, z4, 0.0f, composer, 0, 0, 4097);
            if (schedulePreviewViewState == null) {
                composer.a0(1087678155);
                composer.U();
            } else {
                composer.a0(1087678156);
                r0(schedulePreviewViewState, function1, z5, z3, composer, 0, 0);
                composer.U();
            }
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
    public static final Unit P0(long j3, ProfileType profileType, SchedulePreviewViewState schedulePreviewViewState, String str, String str2, String str3, int i3, boolean z2, List list, Function1 function1, Function2 function2, Function2 function22, boolean z3, boolean z4, boolean z5, int i4, int i5, int i6, Composer composer, int i7) {
        q0(j3, profileType, schedulePreviewViewState, str, str2, str3, i3, z2, list, function1, function2, function22, z3, z4, z5, composer, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), i6);
        return Unit.f139807a;
    }

    private static final void Q0(Composer composer, final int i3) {
        Composer composerK = composer.k(-1211284839);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1211284839, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePauseResumeInfo (SchedulePreviewScreen.kt:535)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(4));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalO, companion2.i(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95527j1, composerK, 6), null, RowScopeInstance.f7101a.d(SizeKt.v(companion, Dp.g(16)), companion2.l()), ComposeColorsKt.j(composerK, 0).q(), composerK, 48, 0);
            TextKt.c(StringResources_androidKt.b(R.string.Rt, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q(), TextUnitKt.i(11), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 3072, 0, 65522);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.a2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewScreenKt.R0(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(int i3, Composer composer, int i4) {
        Q0(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void S0(final ProfileViewDTO profileViewDTO, final boolean z2, final Function1 onEvent, final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(-1811411365);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(profileViewDTO) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onCloseClicked) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1811411365, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewHeader (SchedulePreviewScreen.kt:565)");
            }
            boolean z3 = (i4 & 7168) == 2048;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.l1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SchedulePreviewScreenKt.T0(onCloseClicked);
                    }
                };
                composerK.w(objG);
            }
            ToolbarKt.e(null, (Function0) objG, null, false, null, false, false, null, ComposableLambdaKt.e(-680936505, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.m1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SchedulePreviewScreenKt.U0(profileViewDTO, z2, onEvent, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 100859904, 221);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.n1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewScreenKt.V0(profileViewDTO, z2, onEvent, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void T(final androidx.compose.foundation.layout.RowScope r21, final cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r22, final int r23, boolean r24, final kotlin.jvm.functions.Function0 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.T(androidx.compose.foundation.layout.RowScope, cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration, int, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(ProfileViewDTO profileViewDTO, boolean z2, Function1 function1, RowScope AppBlockToolbar, Composer composer, int i3) throws XmlPullParserException, IOException {
        Composer composer2;
        Intrinsics.checkNotNullParameter(AppBlockToolbar, "$this$AppBlockToolbar");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-680936505, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewHeader.<anonymous> (SchedulePreviewScreen.kt:571)");
            }
            if (profileViewDTO.L()) {
                composer2 = composer;
                composer2.a0(-675803333);
            } else {
                composer.a0(-648812346);
                composer2 = composer;
                ProfileItemKt.t1(ScaffoldKt.g(null, null, composer, 0, 3), profileViewDTO, z2, function1, composer2, 0);
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
    public static final Unit V(ProfileWithConfiguration profileWithConfiguration, boolean z2, int i3, ColumnScope BorderedCard, Composer composer, int i4) {
        long jP;
        long jP2;
        Intrinsics.checkNotNullParameter(BorderedCard, "$this$BorderedCard");
        if (composer.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1638018153, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.BlockingModeCard.<anonymous> (SchedulePreviewScreen.kt:656)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(16));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
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
            boolean z3 = profileWithConfiguration.p().o() == Profile.BlockingMode.Blocklist;
            int i5 = z3 ? R.string.A4 : R.string.A0;
            int i6 = z3 ? R.drawable.X0 : R.drawable.f95573w0;
            String upperCase = StringResources_androidKt.b(i5, composer, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            int i7 = i6;
            TextKt.c(upperCase, null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).j(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            Alignment.Vertical verticalI = companion2.i();
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = arrangement.e();
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalE, verticalI, composer, 54);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA3, measurePolicyB2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            Painter painterC = PainterResources_androidKt.c(i7, composer, 0);
            if (z2) {
                composer.a0(1562301272);
                jP = ComposeColorsKt.j(composer, 0).q();
            } else {
                composer.a0(1562302103);
                jP = ComposeColorsKt.j(composer, 0).p();
            }
            composer.U();
            IconKt.c(painterC, null, SizeKt.v(companion, Dp.g(24)), jP, composer, 432, 0);
            SpacerKt.a(SizeKt.A(companion, Dp.g(4)), composer, 6);
            String strValueOf = String.valueOf(i3);
            TextStyle textStyleG = ComposeTypographyKt.g(composer, 0).g();
            if (z2) {
                composer.a0(1562313496);
                jP2 = ComposeColorsKt.j(composer, 0).q();
            } else {
                composer.a0(1562314327);
                jP2 = ComposeColorsKt.j(composer, 0).p();
            }
            composer.U();
            TextKt.c(strValueOf, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(textStyleG, jP2, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
            composer.y();
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95580y1, composer, 6), null, SizeKt.v(companion, Dp.g(20)), ComposeColorsKt.j(composer, 0).q(), composer, 432, 0);
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
    public static final Unit V0(ProfileViewDTO profileViewDTO, boolean z2, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        S0(profileViewDTO, z2, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(RowScope rowScope, ProfileWithConfiguration profileWithConfiguration, int i3, boolean z2, Function0 function0, int i4, int i5, Composer composer, int i6) {
        T(rowScope, profileWithConfiguration, i3, z2, function0, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    public static final void W0(final SchedulePreviewViewState viewState, final Function1 onEvent, final Function0 onCloseClicked, final Function0 onBlockingClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        float f3;
        int i5;
        Composer composer3;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Intrinsics.checkNotNullParameter(onBlockingClicked, "onBlockingClicked");
        Composer composerK = composer.k(586519094);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onCloseClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onBlockingClicked) ? 2048 : 1024;
        }
        int i6 = i4;
        if (composerK.r((i6 & 1171) != 1170, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(586519094, i6, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreen (SchedulePreviewScreen.kt:177)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final ProfileWithConfiguration profileWithConfigurationI = viewState.I();
            if (profileWithConfigurationI == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.d1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SchedulePreviewScreenKt.X0(viewState, onEvent, onCloseClicked, onBlockingClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                ProfileViewDTO profileViewDTOH = viewState.H();
                if (profileViewDTOH == null) {
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    scopeUpdateScopeN = composerK.n();
                    if (scopeUpdateScopeN == null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.e1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SchedulePreviewScreenKt.Y0(viewState, onEvent, onCloseClicked, onBlockingClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                } else {
                    boolean zF = composerK.f(viewState.w()) | composerK.b(viewState.N()) | composerK.b(viewState.A());
                    Object objG = composerK.G();
                    if (zF || objG == Composer.f23746a.a()) {
                        objG = Long.valueOf((viewState.N() || !viewState.A()) ? 0L : RangesKt.g(viewState.w() - TimeHelperExt.c(), 0L));
                        composerK.w(objG);
                    }
                    long jLongValue = ((Number) objG).longValue();
                    boolean zF2 = composerK.f(viewState.w());
                    Object objG2 = composerK.G();
                    if (zF2 || objG2 == Composer.f23746a.a()) {
                        objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(jLongValue > 0), null, 2, null);
                        composerK.w(objG2);
                    }
                    MutableState mutableState = (MutableState) objG2;
                    ScrollState scrollStateC = ScrollKt.c(0, composerK, 0, 1);
                    Modifier.Companion companion2 = Modifier.b8;
                    float f4 = 16;
                    Modifier modifierK = PaddingKt.k(BackgroundKt.b(WindowInsetsPaddingKt.d(SizeKt.h(companion2, 0.0f, 1, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6)), Brush.Companion.m(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(Color.r(viewState.x(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(ColorKt.b(0)), Color.n(ColorKt.b(0))}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), Dp.g(f4), 0.0f, 2, null);
                    Alignment.Companion companion3 = Alignment.f25072a;
                    Alignment.Horizontal horizontalG = companion3.g();
                    Arrangement arrangement = Arrangement.f6574a;
                    MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
                    int iA = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU = composerK.u();
                    Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
                    Updater.e(composerA, measurePolicyA, companion4.e());
                    Updater.e(composerA, compositionLocalMapU, companion4.g());
                    Function2 function2B = companion4.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion4.f());
                    Modifier modifierG = ScrollKt.g(ColumnScope.b(ColumnScopeInstance.f6666a, SizeKt.h(companion2, 0.0f, 1, null), 1.0f, false, 2, null), scrollStateC, false, null, false, 14, null);
                    MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion3.g(), composerK, 48);
                    int iA2 = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU2 = composerK.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierG);
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
                    Updater.e(composerA2, measurePolicyA2, companion4.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                    Function2 function2B2 = companion4.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF2, companion4.f());
                    int i7 = 6;
                    S0(profileViewDTOH, viewState.M(), onEvent, onCloseClicked, composerK, (i6 << 3) & 8064);
                    SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composerK, 6);
                    c1(profileWithConfigurationI, false, composerK, 0, 2);
                    SpacerKt.a(SizeKt.i(companion2, Dp.g(24)), composerK, 6);
                    f1(viewState, profileWithConfigurationI, false, onBlockingClicked, composerK, i6 & 7182, 4);
                    SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composerK, 6);
                    if (profileViewDTOH.x() || profileViewDTOH.z()) {
                        f3 = f4;
                        composerK.a0(-1023024712);
                        final SchedulePreviewViewState.MainCardPreviewData mainCardPreviewDataY = viewState.y(context);
                        i5 = i6;
                        q0(viewState.x(), viewState.z(), viewState, mainCardPreviewDataY.h(), mainCardPreviewDataY.f(), mainCardPreviewDataY.g(), mainCardPreviewDataY.e(), mainCardPreviewDataY.b(), mainCardPreviewDataY.c(), onEvent, ComposableLambdaKt.e(-1889523614, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.g1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SchedulePreviewScreenKt.a1(mainCardPreviewDataY, profileWithConfigurationI, viewState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerK, 54), null, ((Boolean) mutableState.getValue()).booleanValue(), false, false, composerK, ((i6 << 6) & 896) | ((i6 << 24) & 1879048192), 54, 24576);
                        composer3 = composerK;
                        if (viewState.G() && profileViewDTOH.z() && !profileViewDTOH.C()) {
                            composer3.a0(-1020732200);
                            companion = companion2;
                            i7 = 6;
                            SpacerKt.a(SizeKt.i(companion, Dp.g(12)), composer3, 6);
                            Q0(composer3, 0);
                        } else {
                            companion = companion2;
                            i7 = 6;
                            composer3.a0(-1034973352);
                        }
                        composer3.U();
                        composer3.U();
                    } else {
                        composerK.a0(-1024306438);
                        f3 = f4;
                        CardsKt.k(SizeKt.h(companion2, 0.0f, 1, null), 0L, 0.0f, null, null, ComposableLambdaKt.e(2127021900, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.f1
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return SchedulePreviewScreenKt.Z0(viewState, context, profileWithConfigurationI, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerK, 54), composerK, 196614, 30);
                        composer3 = composerK;
                        composer3.U();
                        i5 = i6;
                        companion = companion2;
                    }
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer3, i7);
                    composer3.y();
                    Composer composer4 = composer3;
                    X(viewState, onEvent, jLongValue, mutableState, composer4, i5 & 126);
                    composer2 = composer4;
                    SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, i7);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }
            scopeUpdateScopeN.a(function2);
        }
        composer2 = composerK;
        composer2.Q();
        scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.h1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewScreenKt.b1(viewState, onEvent, onCloseClicked, onBlockingClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(SchedulePreviewViewState schedulePreviewViewState, Function1 function1, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        W0(schedulePreviewViewState, function1, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(SchedulePreviewViewState schedulePreviewViewState, Function1 function1, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        W0(schedulePreviewViewState, function1, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(Function1 function1) {
        function1.invoke(SchedulePreviewViewEvent.OnEditScheduleClicked.f117398a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(SchedulePreviewViewState schedulePreviewViewState, Context context, ProfileWithConfiguration profileWithConfiguration, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2127021900, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreen.<anonymous>.<anonymous>.<anonymous> (SchedulePreviewScreen.kt:244)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            ProfileType profileTypeZ = schedulePreviewViewState.z();
            IconKt.c(PainterResources_androidKt.c(profileTypeZ != null ? profileTypeZ.getAlternativeScheduleIconResId() : R.drawable.n6, composer, 0), null, SizeKt.v(companion, Dp.g(32)), ComposeColorsKt.j(composer, 0).q0(), composer, 432, 0);
            SpacerKt.a(SizeKt.A(companion, Dp.g(f3)), composer, 6);
            TextKt.c(schedulePreviewViewState.B(context, profileWithConfiguration), null, ComposeColorsKt.j(composer, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
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
    public static final Unit a0(SchedulePreviewViewState schedulePreviewViewState, Function1 function1, long j3, MutableState mutableState, int i3, Composer composer, int i4) {
        X(schedulePreviewViewState, function1, j3, mutableState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(SchedulePreviewViewState.MainCardPreviewData mainCardPreviewData, ProfileWithConfiguration profileWithConfiguration, SchedulePreviewViewState schedulePreviewViewState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1889523614, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreen.<anonymous>.<anonymous>.<anonymous> (SchedulePreviewScreen.kt:278)");
            }
            if (mainCardPreviewData.i()) {
                composer.a0(-956511753);
                l0(schedulePreviewViewState, profileWithConfiguration, ProfileType.Companion.b(profileWithConfiguration.p().E()), schedulePreviewViewState.u(), true, false, false, false, composer, 24576, 224);
                composer.U();
            } else {
                composer.a0(-955833256);
                long jQ0 = ComposeColorsKt.j(composer, 0).q0();
                long jT = ComposeColorsKt.j(composer, 0).t();
                int iA = mainCardPreviewData.a();
                int iE = mainCardPreviewData.e();
                Float fD = mainCardPreviewData.d();
                j0(fD != null ? fD.floatValue() : 1.0f, iA, iE, jQ0, jT, composer, 0, 0);
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void b0(final int r19, boolean r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.b0(int, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(SchedulePreviewViewState schedulePreviewViewState, Function1 function1, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        W0(schedulePreviewViewState, function1, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(int i3, boolean z2, int i4, int i5, Composer composer, int i6) {
        b0(i3, z2, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c1(final cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r62, boolean r63, androidx.compose.runtime.Composer r64, final int r65, final int r66) {
        /*
            Method dump skipped, instruction units count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.c1(cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(Animatable animatable, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.c(1.0f - ((Number) animatable.n()).floatValue());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier d1(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return AlphaKt.a(applyIf, 0.6f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(Animatable animatable, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.c(((Number) animatable.n()).floatValue());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(ProfileWithConfiguration profileWithConfiguration, boolean z2, int i3, int i4, Composer composer, int i5) {
        c1(profileWithConfiguration, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(int i3, boolean z2, int i4, int i5, Composer composer, int i6) {
        b0(i3, z2, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f1(final cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState r14, final cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r15, boolean r16, final kotlin.jvm.functions.Function0 r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instruction units count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.f1(cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState, cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void g0(final androidx.compose.foundation.layout.RowScope r19, final int r20, boolean r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            r2 = r20
            r4 = r23
            r0 = 1927414557(0x72e2031d, float:8.953264E30)
            r1 = r22
            androidx.compose.runtime.Composer r1 = r1.k(r0)
            r3 = r4 & 6
            r5 = r19
            if (r3 != 0) goto L1e
            boolean r3 = r1.Z(r5)
            if (r3 == 0) goto L1b
            r3 = 4
            goto L1c
        L1b:
            r3 = 2
        L1c:
            r3 = r3 | r4
            goto L1f
        L1e:
            r3 = r4
        L1f:
            r6 = r4 & 48
            if (r6 != 0) goto L2f
            boolean r6 = r1.e(r2)
            if (r6 == 0) goto L2c
            r6 = 32
            goto L2e
        L2c:
            r6 = 16
        L2e:
            r3 = r3 | r6
        L2f:
            r6 = r24 & 2
            if (r6 == 0) goto L38
            r3 = r3 | 384(0x180, float:5.38E-43)
        L35:
            r7 = r21
            goto L4a
        L38:
            r7 = r4 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L35
            r7 = r21
            boolean r8 = r1.b(r7)
            if (r8 == 0) goto L47
            r8 = 256(0x100, float:3.59E-43)
            goto L49
        L47:
            r8 = 128(0x80, float:1.8E-43)
        L49:
            r3 = r3 | r8
        L4a:
            r8 = r3 & 147(0x93, float:2.06E-43)
            r9 = 146(0x92, float:2.05E-43)
            r11 = 0
            r12 = 1
            if (r8 == r9) goto L54
            r8 = r12
            goto L55
        L54:
            r8 = r11
        L55:
            r9 = r3 & 1
            boolean r8 = r1.r(r8, r9)
            if (r8 == 0) goto Lae
            if (r6 == 0) goto L61
            r13 = r11
            goto L62
        L61:
            r13 = r7
        L62:
            boolean r6 = androidx.compose.runtime.ComposerKt.M()
            if (r6 == 0) goto L6e
            r6 = -1
            java.lang.String r7 = "cz.mobilesoft.coreblock.scene.schedule.preview.PausedTodayCard (SchedulePreviewScreen.kt:709)"
            androidx.compose.runtime.ComposerKt.U(r0, r3, r6, r7)
        L6e:
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.b8
            r9 = 2
            r10 = 0
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.RowScope.c(r5, r6, r7, r8, r9, r10)
            r3 = 0
            r5 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.d(r0, r3, r12, r5)
            long r10 = androidx.compose.ui.graphics.ColorKt.b(r11)
            cz.mobilesoft.coreblock.scene.schedule.preview.o0 r0 = new cz.mobilesoft.coreblock.scene.schedule.preview.o0
            r0.<init>()
            r3 = 54
            r6 = -1294794627(0xffffffffb2d3007d, float:-2.4563855E-8)
            androidx.compose.runtime.internal.ComposableLambda r15 = androidx.compose.runtime.internal.ComposableLambdaKt.e(r6, r12, r0, r1, r3)
            r17 = 100687872(0x6006000, float:2.4144654E-35)
            r18 = 238(0xee, float:3.34E-43)
            r6 = 0
            r7 = 0
            r9 = 0
            r12 = 0
            r0 = r13
            r13 = 0
            r14 = 0
            r16 = r1
            cz.mobilesoft.coreblock.view.compose.material3.CardsKt.n(r5, r6, r7, r9, r10, r12, r13, r14, r15, r16, r17, r18)
            boolean r1 = androidx.compose.runtime.ComposerKt.M()
            if (r1 == 0) goto Lac
            androidx.compose.runtime.ComposerKt.T()
        Lac:
            r3 = r0
            goto Lb4
        Lae:
            r16 = r1
            r16.Q()
            r3 = r7
        Lb4:
            androidx.compose.runtime.ScopeUpdateScope r6 = r16.n()
            if (r6 == 0) goto Lc6
            cz.mobilesoft.coreblock.scene.schedule.preview.z0 r0 = new cz.mobilesoft.coreblock.scene.schedule.preview.z0
            r1 = r19
            r5 = r24
            r0.<init>()
            r6.a(r0)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.g0(androidx.compose.foundation.layout.RowScope, int, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(SchedulePreviewViewState schedulePreviewViewState, ProfileWithConfiguration profileWithConfiguration, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        f1(schedulePreviewViewState, profileWithConfiguration, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(int i3, boolean z2, ColumnScope BorderedCard, Composer composer, int i4) {
        long jP;
        Intrinsics.checkNotNullParameter(BorderedCard, "$this$BorderedCard");
        if (composer.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1294794627, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.PausedTodayCard.<anonymous> (SchedulePreviewScreen.kt:716)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(16));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
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
            String upperCase = StringResources_androidKt.b(R.string.Cn, composer, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.c(upperCase, null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).j(), composer, 0, 0, 65530);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            b0(i3, z2, composer, 0, 0);
            SpacerKt.a(SizeKt.A(companion, Dp.g(4)), composer, 6);
            String strP = StringHelperExtKt.p(String.valueOf(i3), "×", "");
            TextStyle textStyleG = ComposeTypographyKt.g(composer, 0).g();
            if (z2) {
                composer.a0(-1605640560);
                jP = ComposeColorsKt.j(composer, 0).q();
            } else {
                composer.a0(-1605639729);
                jP = ComposeColorsKt.j(composer, 0).p();
            }
            composer.U();
            TextKt.c(strP, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(textStyleG, jP, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null), composer, 0, 0, 65534);
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
    public static final Unit i0(RowScope rowScope, int i3, boolean z2, int i4, int i5, Composer composer, int i6) {
        g0(rowScope, i3, z2, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x016e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void j0(final float r22, final int r23, final int r24, long r25, long r27, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.j0(float, int, int, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(float f3, int i3, int i4, long j3, long j4, int i5, int i6, Composer composer, int i7) {
        j0(f3, i3, i4, j3, j4, composer, RecomposeScopeImplKt.a(i5 | 1), i6);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:259:0x055f  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:264:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l0(cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState r37, final cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r38, final java.util.List r39, java.util.List r40, boolean r41, boolean r42, boolean r43, boolean r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instruction units count: 1409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.l0(cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState, cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration, java.util.List, java.util.List, boolean, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(ScheduleViewState.MainCardSummaryData mainCardSummaryData, boolean z2, ProfileWithConfiguration profileWithConfiguration, boolean z3, boolean z4, Composer composer, int i3) {
        long jQ0;
        long jT;
        long jQ02;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(205734573, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.ScheduleCombineProfileCardContent.<anonymous>.<anonymous> (SchedulePreviewScreen.kt:361)");
            }
            ImmutableList immutableListG = mainCardSummaryData.g();
            if (immutableListG == null || immutableListG.isEmpty()) {
                composer.a0(103923189);
            } else {
                composer.a0(120468168);
                ImmutableList immutableListG2 = mainCardSummaryData.g();
                Modifier modifierK = PaddingKt.k(Modifier.b8, 0.0f, Dp.g(4), 1, null);
                boolean z5 = z2 || ProfileWithConfiguration.n(profileWithConfiguration, 0L, 1, null) != null;
                if (z3) {
                    composer.a0(120804456);
                    if (z4) {
                        composer.a0(142446202);
                        jQ0 = ComposeColorsKt.j(composer, 0).q();
                    } else {
                        composer.a0(142447033);
                        jQ0 = ComposeColorsKt.j(composer, 0).p();
                    }
                    composer.U();
                    composer.U();
                } else {
                    composer.a0(120948761);
                    jQ0 = ComposeColorsKt.j(composer, 0).q0();
                    composer.U();
                }
                if (z3) {
                    composer.a0(121117649);
                    jT = ComposeColorsKt.j(composer, 0).s();
                    composer.U();
                } else {
                    composer.a0(121223173);
                    jT = ComposeColorsKt.j(composer, 0).t();
                    composer.U();
                }
                if (z3) {
                    composer.a0(121416520);
                    if (z4) {
                        composer.a0(142465946);
                        jQ02 = ComposeColorsKt.j(composer, 0).q();
                    } else {
                        composer.a0(142466777);
                        jQ02 = ComposeColorsKt.j(composer, 0).p();
                    }
                    composer.U();
                    composer.U();
                } else {
                    composer.a0(121560825);
                    jQ02 = ComposeColorsKt.j(composer, 0).q0();
                    composer.U();
                }
                ScheduleSummaryScreenKt.y(immutableListG2, modifierK, jT, jQ0, jQ02, z5, composer, 48, 0);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(SchedulePreviewViewState.MainCardPreviewData mainCardPreviewData, ScheduleViewState.MainCardSummaryData mainCardSummaryData, boolean z2, float f3, Composer composer, int i3) {
        int iIntValue;
        long jR;
        long jR2;
        Float fD;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2106972252, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.ScheduleCombineProfileCardContent.<anonymous>.<anonymous> (SchedulePreviewScreen.kt:416)");
            }
            float fFloatValue = (mainCardPreviewData == null || (fD = mainCardPreviewData.d()) == null) ? 1.0f : fD.floatValue();
            if (mainCardPreviewData != null) {
                iIntValue = mainCardPreviewData.a();
            } else {
                Integer numC = mainCardSummaryData.c();
                iIntValue = numC != null ? numC.intValue() : mainCardSummaryData.j();
            }
            int iF = RangesKt.f(mainCardPreviewData != null ? mainCardPreviewData.e() : mainCardSummaryData.j(), 1);
            if (z2) {
                composer.a0(2137165199);
                jR = Color.r(ComposeColorsKt.j(composer, 0).p(), f3, 0.0f, 0.0f, 0.0f, 14, null);
                composer.U();
            } else {
                composer.a0(2137281046);
                jR = Color.r(ComposeColorsKt.j(composer, 0).q0(), f3, 0.0f, 0.0f, 0.0f, 14, null);
                composer.U();
            }
            if (z2) {
                composer.a0(2137462737);
                jR2 = Color.r(ComposeColorsKt.j(composer, 0).s(), Color.u(ComposeColorsKt.j(composer, 0).s()) * f3, 0.0f, 0.0f, 0.0f, 14, null);
                composer.U();
            } else {
                composer.a0(2137609305);
                jR2 = Color.r(ComposeColorsKt.j(composer, 0).t(), Color.u(ComposeColorsKt.j(composer, 0).t()) * f3, 0.0f, 0.0f, 0.0f, 14, null);
                composer.U();
            }
            j0(fFloatValue, iIntValue, iF, jR, jR2, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(SchedulePreviewViewState.MainCardPreviewData mainCardPreviewData, ScheduleViewState.MainCardSummaryData mainCardSummaryData, boolean z2, float f3, Composer composer, int i3) {
        int iIntValue;
        long jR;
        long jR2;
        Float fD;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(731581989, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.ScheduleCombineProfileCardContent.<anonymous>.<anonymous> (SchedulePreviewScreen.kt:464)");
            }
            float fFloatValue = (mainCardPreviewData == null || (fD = mainCardPreviewData.d()) == null) ? 1.0f : fD.floatValue();
            if (mainCardPreviewData != null) {
                iIntValue = mainCardPreviewData.a();
            } else {
                Integer numC = mainCardSummaryData.c();
                iIntValue = numC != null ? numC.intValue() : mainCardSummaryData.j();
            }
            int iF = RangesKt.f(mainCardPreviewData != null ? mainCardPreviewData.e() : mainCardSummaryData.j(), 1);
            if (z2) {
                composer.a0(1895473838);
                jR = Color.r(ComposeColorsKt.j(composer, 0).p(), f3, 0.0f, 0.0f, 0.0f, 14, null);
                composer.U();
            } else {
                composer.a0(1895589685);
                jR = Color.r(ComposeColorsKt.j(composer, 0).q0(), f3, 0.0f, 0.0f, 0.0f, 14, null);
                composer.U();
            }
            if (z2) {
                composer.a0(1895771376);
                jR2 = Color.r(ComposeColorsKt.j(composer, 0).s(), Color.u(ComposeColorsKt.j(composer, 0).s()) * f3, 0.0f, 0.0f, 0.0f, 14, null);
                composer.U();
            } else {
                composer.a0(1895917944);
                jR2 = Color.r(ComposeColorsKt.j(composer, 0).t(), Color.u(ComposeColorsKt.j(composer, 0).t()) * f3, 0.0f, 0.0f, 0.0f, 14, null);
                composer.U();
            }
            j0(fFloatValue, iIntValue, iF, jR, jR2, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(SchedulePreviewViewState schedulePreviewViewState, ProfileWithConfiguration profileWithConfiguration, List list, List list2, boolean z2, boolean z3, boolean z4, boolean z5, int i3, int i4, Composer composer, int i5) {
        l0(schedulePreviewViewState, profileWithConfiguration, list, list2, z2, z3, z4, z5, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void q0(final long r31, final cz.mobilesoft.coreblock.enums.ProfileType r33, cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState r34, final java.lang.String r35, final java.lang.String r36, java.lang.String r37, final int r38, final boolean r39, final java.util.List r40, final kotlin.jvm.functions.Function1 r41, kotlin.jvm.functions.Function2 r42, kotlin.jvm.functions.Function2 r43, boolean r44, boolean r45, boolean r46, androidx.compose.runtime.Composer r47, final int r48, final int r49, final int r50) {
        /*
            Method dump skipped, instruction units count: 693
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.q0(long, cz.mobilesoft.coreblock.enums.ProfileType, cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState, java.lang.String, java.lang.String, java.lang.String, int, boolean, java.util.List, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:274:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:279:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void r0(final cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState r33, final kotlin.jvm.functions.Function1 r34, final boolean r35, boolean r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 1892
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.r0(cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewState, kotlin.jvm.functions.Function1, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(SchedulePreviewViewState schedulePreviewViewState, Function1 function1, boolean z2, boolean z3, int i3, int i4, Composer composer, int i5) {
        r0(schedulePreviewViewState, function1, z2, z3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final float t0(State state) {
        return ((Dp) state.getValue()).l();
    }

    private static final float u0(State state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(Function1 function1) {
        function1.invoke(SchedulePreviewViewEvent.OnProfileResumed.f117403a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(Function1 function1) {
        function1.invoke(SchedulePreviewViewEvent.OnProfilePausedFromCard.f117402a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec y0(Transition.Segment animateColor, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animateColor, "$this$animateColor");
        composer.a0(85973551);
        if (ComposerKt.M()) {
            ComposerKt.U(85973551, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.preview.ScheduleMainCardActions.<anonymous> (SchedulePreviewScreen.kt:1153)");
        }
        TweenSpec tweenSpecN = AnimationSpecKt.n(1000, 0, null, 6, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return tweenSpecN;
    }

    private static final long z0(State state) {
        return ((Color) state.getValue()).B();
    }

    /* JADX WARN: Removed duplicated region for block: B:192:0x06ef  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x06fb  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void J0(final java.lang.String r76, final java.lang.String r77, final java.lang.String r78, final cz.mobilesoft.coreblock.enums.ProfileType r79, final boolean r80, androidx.compose.ui.graphics.Color r81, float r82, androidx.compose.runtime.Composer r83, final int r84, final int r85) {
        /*
            Method dump skipped, instruction units count: 1810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewScreenKt.J0(java.lang.String, java.lang.String, java.lang.String, cz.mobilesoft.coreblock.enums.ProfileType, boolean, androidx.compose.ui.graphics.Color, float, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void X(SchedulePreviewViewState schedulePreviewViewState, final Function1 function1, final long j3, final MutableState mutableState, Composer composer, final int i3) {
        SchedulePreviewViewState schedulePreviewViewState2;
        int i4;
        Composer composer2;
        Composer composer3;
        Integer num;
        boolean z2;
        long jE;
        long jP;
        Composer composerK = composer.k(-1247354394);
        if ((i3 & 6) == 0) {
            schedulePreviewViewState2 = schedulePreviewViewState;
            i4 = (composerK.Z(schedulePreviewViewState2) ? 4 : 2) | i3;
        } else {
            schedulePreviewViewState2 = schedulePreviewViewState;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.f(j3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(mutableState) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1247354394, i4, -1, pMpIcGE.lAdUNrFMgHDtC);
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            if (!schedulePreviewViewState2.N() && ((Boolean) mutableState.getValue()).booleanValue() && schedulePreviewViewState2.A()) {
                composerK.a0(122634774);
                num = null;
                z2 = true;
                TextKt.c(StringResources_androidKt.b(R.string.Nc, composerK, 0), SizeKt.h(companion, 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65020);
                composer3 = composerK;
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer3, 6);
            } else {
                composer3 = composerK;
                num = null;
                z2 = true;
                composer3.a0(71860060);
            }
            composer3.U();
            String strB = StringResources_androidKt.b(R.string.Kc, composer3, 0);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            if (schedulePreviewViewState2.N()) {
                composer3.a0(123145344);
                jE = ComposeColorsKt.j(composer3, 0).q0();
                composer3.U();
            } else {
                composer3.a0(123210971);
                jE = ComposeColorsKt.j(composer3, 0).e();
                composer3.U();
            }
            Color colorN = Color.n(jE);
            if (schedulePreviewViewState2.N()) {
                composer3.a0(123348735);
                jP = ComposeColorsKt.j(composer3, 0).a0();
                composer3.U();
            } else {
                composer3.a0(123415385);
                jP = ComposeColorsKt.j(composer3, 0).p();
                composer3.U();
            }
            FlatButtonColors flatButtonColorsA = primary.a(colorN, Color.n(jP));
            FlatButtonColors flatButtonColorsA2 = primary.a(Color.n(ComposeColorsKt.j(composer3, 0).p()), Color.n(ComposeColorsKt.j(composer3, 0).e0()));
            long jU = ComposeColorsKt.j(composer3, 0).u();
            Integer numValueOf = schedulePreviewViewState2.N() ? Integer.valueOf(R.drawable.U5) : num;
            boolean z3 = (i4 & 7168) == 2048 ? z2 : false;
            Object objG = composer3.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.u1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SchedulePreviewScreenKt.Y(mutableState);
                    }
                };
                composer3.w(objG);
            }
            Function0 function0 = (Function0) objG;
            boolean z4 = (i4 & 112) == 32 ? z2 : false;
            Object objG2 = composer3.G();
            if (z4 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.w1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SchedulePreviewScreenKt.Z(function1);
                    }
                };
                composer3.w(objG2);
            }
            composer2 = composer3;
            FlatButtonsKt.A(null, 0.0f, flatButtonColorsA2, flatButtonColorsA, jU, strB, null, numValueOf, null, j3, 10000L, function0, (Function0) objG2, composer2, (i4 << 21) & 1879048192, 6, 323);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final SchedulePreviewViewState schedulePreviewViewState3 = schedulePreviewViewState2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.x1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulePreviewScreenKt.a0(schedulePreviewViewState3, function1, j3, mutableState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
