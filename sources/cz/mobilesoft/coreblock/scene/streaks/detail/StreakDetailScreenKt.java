package cz.mobilesoft.coreblock.scene.streaks.detail;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.streaks.StreakStats;
import cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewEvent;
import cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewState;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.LabelsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class StreakDetailScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final DateTimeFormatter f120671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f120672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f120673c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class EntriesMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f120674a = EnumEntriesKt.a(DayOfWeek.values());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f120684a;

        static {
            int[] iArr = new int[StreakDetailViewState.DisplayStatus.values().length];
            try {
                iArr[StreakDetailViewState.DisplayStatus.Obtained.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StreakDetailViewState.DisplayStatus.Rest.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StreakDetailViewState.DisplayStatus.TodayLost.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StreakDetailViewState.DisplayStatus.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[StreakDetailViewState.DisplayStatus.Missing.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[StreakDetailViewState.DisplayStatus.TodayPossible.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[StreakDetailViewState.DisplayStatus.Future.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[StreakDetailViewState.DisplayStatus.Placeholder.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f120684a = iArr;
        }
    }

    static {
        DateTimeFormatter dateTimeFormatterOfLocalizedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatterOfLocalizedDate, "ofLocalizedDate(...)");
        f120671a = dateTimeFormatterOfLocalizedDate;
        f120672b = EntriesMappings.f120674a.size();
        f120673c = Dp.g(54);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakDetailViewState A0(StreakDetailViewState.SummaryState summaryState, StreakStats streakStats, boolean z2) {
        StreakDetailViewState.DisplayStatus displayStatus;
        boolean z3;
        boolean z4;
        StreakDetailViewState.DisplayStatus displayStatus2 = StreakDetailViewState.DisplayStatus.Obtained;
        List listListOf = CollectionsKt.listOf((Object[]) new StreakDetailViewState.DisplayStatus[]{displayStatus2, displayStatus2, StreakDetailViewState.DisplayStatus.Rest, displayStatus2, displayStatus2, StreakDetailViewState.DisplayStatus.Inactive, StreakDetailViewState.DisplayStatus.Missing});
        IntRange intRange = new IntRange(12, 21);
        Set of = SetsKt.setOf((Object[]) new Integer[]{12, 19});
        ArrayList arrayList = new ArrayList(3);
        for (int i3 = 0; i3 < 3; i3++) {
            arrayList.add(StreakDetailViewState.DayCell.f120725f.a(i3));
        }
        IntRange intRange2 = new IntRange(1, 28);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange2, 10));
        Iterator<Integer> it = intRange2.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            String str = String.format("2026-09-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iNextInt)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            LocalDate localDateOf = LocalDate.of(2026, 9, iNextInt);
            if (iNextInt == 22) {
                displayStatus = StreakDetailViewState.DisplayStatus.TodayLost;
            } else if (iNextInt == 23) {
                displayStatus = StreakDetailViewState.DisplayStatus.Inactive;
            } else if (iNextInt == 24) {
                displayStatus = StreakDetailViewState.DisplayStatus.TodayPossible;
            } else if (of.contains(Integer.valueOf(iNextInt))) {
                displayStatus = StreakDetailViewState.DisplayStatus.Rest;
            } else {
                displayStatus = (iNextInt > intRange.h() || intRange.g() > iNextInt) ? (25 > iNextInt || iNextInt >= 29) ? (StreakDetailViewState.DisplayStatus) listListOf.get(iNextInt % listListOf.size()) : StreakDetailViewState.DisplayStatus.Future : StreakDetailViewState.DisplayStatus.Obtained;
            }
            boolean z5 = iNextInt == 24;
            int iG = intRange.g();
            if ((iNextInt > intRange.h() || iG > iNextInt) && iNextInt != 24) {
                z3 = z5;
                z4 = false;
            } else {
                z3 = z5;
                z4 = true;
            }
            arrayList2.add(new StreakDetailViewState.DayCell(str, localDateOf, displayStatus, z3, z4));
        }
        return new StreakDetailViewState(false, summaryState, streakStats, CollectionsKt.listOf(new StreakDetailViewState.MonthPage("2026-09", "September 2026", CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2))), 0, CollectionsKt.listOf((Object[]) new String[]{"M", "T", "W", "T", "F", "S", "S"}), z2, 16, null);
    }

    static /* synthetic */ StreakDetailViewState B0(StreakDetailViewState.SummaryState summaryState, StreakStats streakStats, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return A0(summaryState, streakStats, z2);
    }

    private static final int C0(List list) {
        int size = list.size();
        int i3 = f120672b;
        return RangesKt.f(((size + i3) - 1) / i3, 1);
    }

    private static final void F(final StreakDetailViewState.DisplayStatus displayStatus, final String str, Composer composer, final int i3) {
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Pair pairA;
        Composer composerK = composer.k(283576514);
        int i4 = (i3 & 6) == 0 ? (composerK.e(displayStatus.ordinal()) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(283576514, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakDayBadge (StreakDetailScreen.kt:600)");
            }
            if (displayStatus == StreakDetailViewState.DisplayStatus.Rest) {
                composerK.a0(-172455813);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
                Updater.e(composerA, measurePolicyG, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion2.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                BoxKt.a(BackgroundKt.c(SizeKt.f(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).n(), RoundedCornerShapeKt.g()), composerK, 0);
                IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.S5, composerK, 6), str, SizeKt.f(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).q(), composerK, (i4 & 112) | 384, 0);
                composerK.y();
                composerK.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.j0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StreakDetailScreenKt.G(displayStatus, str, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                composerK.a0(-195313632);
                composerK.U();
                switch (WhenMappings.f120684a[displayStatus.ordinal()]) {
                    case 1:
                        composerK.a0(1934132213);
                        composerK.U();
                        pairA = TuplesKt.a(Integer.valueOf(R.drawable.L5), Color.n(Color.f25715b.k()));
                        break;
                    case 2:
                        composerK.a0(-171314982);
                        composerK.U();
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                        scopeUpdateScopeN = composerK.n();
                        if (scopeUpdateScopeN == null) {
                            return;
                        } else {
                            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.k0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return StreakDetailScreenKt.H(displayStatus, str, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                        }
                        break;
                    case 3:
                        composerK.a0(1934138878);
                        pairA = TuplesKt.a(Integer.valueOf(R.drawable.P5), Color.n(ComposeColorsKt.j(composerK, 0).q()));
                        composerK.U();
                        break;
                    case 4:
                    case 5:
                        composerK.a0(1934144734);
                        pairA = TuplesKt.a(Integer.valueOf(R.drawable.R5), Color.n(ComposeColorsKt.j(composerK, 0).u()));
                        composerK.U();
                        break;
                    case 6:
                        composerK.a0(1934151799);
                        pairA = TuplesKt.a(Integer.valueOf(R.drawable.Q5), Color.n(ComposeColorsKt.j(composerK, 0).V()));
                        composerK.U();
                        break;
                    case 7:
                        composerK.a0(1934155678);
                        pairA = TuplesKt.a(Integer.valueOf(R.drawable.Q5), Color.n(ComposeColorsKt.j(composerK, 0).q()));
                        composerK.U();
                        break;
                    case 8:
                        composerK.a0(-170597766);
                        composerK.U();
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                        scopeUpdateScopeN = composerK.n();
                        if (scopeUpdateScopeN == null) {
                            return;
                        } else {
                            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.l0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return StreakDetailScreenKt.I(displayStatus, str, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            };
                        }
                        break;
                    default:
                        composerK.a0(1934130424);
                        composerK.U();
                        throw new NoWhenBranchMatchedException();
                }
                IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, ((Number) pairA.a()).intValue(), composerK, 6), str, SizeKt.f(Modifier.b8, 0.0f, 1, null), ((Color) pairA.b()).B(), composerK, (i4 & 112) | 384, 0);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
            scopeUpdateScopeN.a(function2);
        }
        composerK.Q();
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakDetailScreenKt.J(displayStatus, str, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(StreakDetailViewState.DisplayStatus displayStatus, String str, int i3, Composer composer, int i4) {
        F(displayStatus, str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(StreakDetailViewState.DisplayStatus displayStatus, String str, int i3, Composer composer, int i4) {
        F(displayStatus, str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(StreakDetailViewState.DisplayStatus displayStatus, String str, int i3, Composer composer, int i4) {
        F(displayStatus, str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(StreakDetailViewState.DisplayStatus displayStatus, String str, int i3, Composer composer, int i4) {
        F(displayStatus, str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void K(final cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewState.DayCell r24, androidx.compose.ui.Modifier r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 660
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailScreenKt.K(cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailViewState$DayCell, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(StreakDetailViewState.DayCell dayCell, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        K(dayCell, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(String str, final CoroutineScope coroutineScope, final TooltipState tooltipState, StreakDetailViewState.DayCell dayCell, String str2, Composer composer, int i3) {
        String strP = str;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1861073638, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakDayCell.<anonymous>.<anonymous>.<anonymous> (StreakDetailScreen.kt:548)");
            }
            Modifier modifierA = ClipKt.a(SizeKt.f(Modifier.b8, 0.0f, 1, null), RoundedCornerShapeKt.g());
            boolean z2 = strP != null;
            boolean zI = composer.I(coroutineScope) | composer.I(tooltipState);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.i0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StreakDetailScreenKt.N(coroutineScope, tooltipState);
                    }
                };
                composer.w(objG);
            }
            Modifier modifierF = ClickableKt.f(modifierA, z2, null, null, (Function0) objG, 6, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            StreakDetailViewState.DisplayStatus displayStatusB = dayCell.b();
            if (str2 != null && strP != null) {
                strP = StringHelperExtKt.p(str2, strP, ", ");
            } else if (str2 != null) {
                strP = str2;
            }
            F(displayStatusB, strP, composer, 0);
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
    public static final Unit N(CoroutineScope coroutineScope, TooltipState tooltipState) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new StreakDetailScreenKt$StreakDayCell$2$1$1$1$1$1(tooltipState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(StreakDetailViewState.DayCell dayCell, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        K(dayCell, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void P(final PaddingValues paddingValues, final StreakDetailViewState viewState, final Function1 onEvent, final Function0 onCloseClick, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Composer composerK = composer.k(1544049410);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onCloseClick) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1544049410, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailScreen (StreakDetailScreen.kt:86)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, ComposeColorsKt.k(ComposeColorsKt.j(composerK, 0)), ComposableLambdaKt.e(-1308232524, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.q
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StreakDetailScreenKt.S(paddingValues, onCloseClick, onEvent, viewState, mutableState, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 63);
            composer2 = composerK;
            if (Q(mutableState)) {
                composer2.a0(-321625089);
                Object objG2 = composer2.G();
                if (objG2 == companion.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.b0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StreakDetailScreenKt.W(mutableState);
                        }
                    };
                    composer2.w(objG2);
                }
                StreakHelpSheetKt.h((Function0) objG2, composer2, 6);
            } else {
                composer2.a0(-327620768);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakDetailScreenKt.X(paddingValues, viewState, onEvent, onCloseClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean Q(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void R(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(PaddingValues paddingValues, Function0 function0, final Function1 function1, StreakDetailViewState streakDetailViewState, final MutableState mutableState, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1308232524, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailScreen.<anonymous> (StreakDetailScreen.kt:91)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = WindowInsetsPaddingKt.d(PaddingKt.h(SizeKt.f(companion, 0.0f, 1, null), paddingValues), WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
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
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.o0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StreakDetailScreenKt.T(function1);
                    }
                };
                composer.w(objG);
            }
            Function0 function02 = (Function0) objG;
            Object objG2 = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.p0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StreakDetailScreenKt.U(mutableState);
                    }
                };
                composer.w(objG2);
            }
            Y(function0, function02, (Function0) objG2, composer, 384);
            if (streakDetailViewState.l()) {
                composer.a0(-1628077228);
                Modifier modifierF2 = SizeKt.f(companion, 0.0f, 1, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.e(), false);
                int iA2 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU2 = composer.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer, modifierF2);
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
                Updater.e(composerA2, modifierF3, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                ProgressIndicatorKt.b(null, ComposeColorsKt.j(composer, 0).V(), 0.0f, 0L, 0, composer, 0, 29);
                composer.y();
                composer.U();
            } else {
                composer.a0(-1627854090);
                float f3 = 16;
                Modifier modifierK = PaddingKt.k(ScrollKt.g(SizeKt.f(companion, 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), Dp.g(f3), 0.0f, 2, null);
                MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.g(), composer, 48);
                int iA3 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU3 = composer.u();
                Modifier modifierF4 = ComposedModifierKt.f(composer, modifierK);
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
                boolean Z2 = composer.Z(function1);
                Object objG3 = composer.G();
                if (Z2 || objG3 == companion4.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.q0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StreakDetailScreenKt.V(function1);
                        }
                    };
                    composer.w(objG3);
                }
                a0(streakDetailViewState, (Function0) objG3, composer, 0);
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
                v0(streakDetailViewState, composer, 0);
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
                f0(streakDetailViewState, function1, composer, 0);
                SpacerKt.a(SizeKt.i(companion, Dp.g(32)), composer, 6);
                composer.y();
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
    public static final Unit T(Function1 function1) {
        function1.invoke(StreakDetailViewEvent.OnBetaBadgeClicked.f120687a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(MutableState mutableState) {
        R(mutableState, true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Function1 function1) {
        function1.invoke(StreakDetailViewEvent.OnCreateBlockingClicked.f120688a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(MutableState mutableState) {
        R(mutableState, false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(PaddingValues paddingValues, StreakDetailViewState streakDetailViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        P(paddingValues, streakDetailViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void Y(Function0 function0, final Function0 function02, Function0 function03, Composer composer, final int i3) {
        int i4;
        final Function0 function04;
        final Function0 function05;
        Composer composerK = composer.k(-746541830);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function0) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function02) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function03) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-746541830, i5, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailToolbar (StreakDetailScreen.kt:145)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion, 0.0f, 1, null), Dp.g(8), Dp.g(4));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion2.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
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
            ToolbarKt.h(null, R.drawable.G0, StringResources_androidKt.b(R.string.N7, composerK, 0), null, 0.0f, function0, composerK, (i5 << 15) & 458752, 25);
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
            Modifier modifierF2 = ClickableKt.f(ClipKt.a(companion, RoundedCornerShapeKt.a(50)), false, null, null, function02, 7, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierF2);
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
            Updater.e(composerA2, modifierF3, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            String upperCase = StringResources_androidKt.b(R.string.i3, composerK, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            LabelsKt.e(upperCase, ComposeColorsKt.j(composerK, 0).n(), ComposeColorsKt.j(composerK, 0).V(), Dp.g(10), 0.0f, RoundedCornerShapeKt.a(50), null, composerK, 3072, 80);
            composerK = composerK;
            composerK.y();
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
            function05 = function03;
            function04 = function0;
            ToolbarKt.h(null, R.drawable.M, StringResources_androidKt.b(R.string.Af, composerK, 0), null, 0.0f, function05, composerK, (i5 << 9) & 458752, 25);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function04 = function0;
            function05 = function03;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakDetailScreenKt.Z(function04, function02, function05, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(Function0 function0, Function0 function02, Function0 function03, int i3, Composer composer, int i4) {
        Y(function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void a0(final StreakDetailViewState streakDetailViewState, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1133224127);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(streakDetailViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1133224127, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakHeadline (StreakDetailScreen.kt:190)");
            }
            StreakDetailViewState.SummaryState summaryStateJ = streakDetailViewState.j();
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
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
            float f3 = 16;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composerK, 6);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion.i(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion2);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.L5, composerK, 6), null, SizeKt.v(companion2, Dp.g(50)), Color.f25715b.k(), composerK, 3504, 0);
            float f4 = 8;
            SpacerKt.a(SizeKt.v(companion2, Dp.g(f4)), composerK, 6);
            TextKt.c(String.valueOf(streakDetailViewState.i().b()), null, ComposeColorsKt.j(composerK, 0).p(), TextUnitKt.i(56), null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerK, 199680, 0, 131026);
            composerK.y();
            boolean z2 = summaryStateJ instanceof StreakDetailViewState.SummaryState.Active;
            String strB = StringResources_androidKt.b(z2 ? R.string.VA : R.string.MA, composerK, 0);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i5 = MaterialTheme.f13092b;
            TextStyle textStyleG = materialTheme.c(composerK, i5).g();
            long jV = ComposeColorsKt.j(composerK, 0).V();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, null, jV, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleG, composerK, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(z2 ? R.string.NA : R.string.OA, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composerK, i5).a(), composerK, 0, 0, 65018);
            composerK = composerK;
            if (streakDetailViewState.h()) {
                composerK.a0(1675262112);
                SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composerK, 6);
                FlatButtonsKt.s(null, StringResources_androidKt.b(R.string.F8, composerK, 0), null, null, null, false, function0, composerK, ((i4 << 15) & 3670016) | 196608, 29);
            } else {
                composerK.a0(1665648237);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakDetailScreenKt.b0(streakDetailViewState, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(StreakDetailViewState streakDetailViewState, Function0 function0, int i3, Composer composer, int i4) {
        a0(streakDetailViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void c0(final List list, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-45009787);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(list) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-45009787, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakLineTrack (StreakDetailScreen.kt:479)");
            }
            final long jR = Color.r(ComposeColorsKt.j(composerK, 0).V(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
            Modifier modifierI = SizeKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(50));
            boolean zI = composerK.I(list) | composerK.f(jR);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StreakDetailScreenKt.d0(list, jR, (DrawScope) obj);
                    }
                };
                composerK.w(objG);
            }
            CanvasKt.b(modifierI, (Function1) objG, composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakDetailScreenKt.e0(list, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(List list, long j3, DrawScope drawScope) {
        int i3;
        DrawScope Canvas = drawScope;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fIntBitsToFloat = Float.intBitsToFloat((int) (Canvas.b() >> 32)) / f120672b;
        int i4 = 0;
        Integer numValueOf = null;
        for (Object obj : list) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((StreakDetailViewState.DayCell) obj).c()) {
                int iIntValue = numValueOf != null ? numValueOf.intValue() : i4;
                if (i4 == CollectionsKt.getLastIndex(list) || !((StreakDetailViewState.DayCell) list.get(i5)).c()) {
                    float f3 = ((i4 - iIntValue) + 1) * fIntBitsToFloat;
                    long jE = Offset.e((((long) Float.floatToRawIntBits(iIntValue * fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
                    long jD = Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(f3)) << 32));
                    float fMin = Math.min(f3, Float.intBitsToFloat((int) (Canvas.b() & 4294967295L))) / 2.0f;
                    i3 = i5;
                    DrawScope.f2(Canvas, j3, jE, jD, CornerRadius.b((4294967295L & ((long) Float.floatToRawIntBits(fMin))) | (((long) Float.floatToRawIntBits(fMin)) << 32)), null, 0.0f, null, 0, 240, null);
                    numValueOf = null;
                } else {
                    numValueOf = Integer.valueOf(iIntValue);
                    i3 = i5;
                }
            } else {
                i3 = i5;
            }
            Canvas = drawScope;
            i4 = i3;
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(List list, int i3, Composer composer, int i4) {
        c0(list, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void f0(final StreakDetailViewState streakDetailViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Composer composerK = composer.k(620198188);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(streakDetailViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(620198188, i5, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakMonthCalendar (StreakDetailScreen.kt:317)");
            }
            final int size = streakDetailViewState.e().size();
            if (size == 0) {
                composerK.a0(-624891832);
                TextKt.c(StringResources_androidKt.b(R.string.LA, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composerK, MaterialTheme.f13092b).b(), composerK, 0, 0, 65530);
                composerK.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.s0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StreakDetailScreenKt.g0(streakDetailViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            composerK.a0(-636813130);
            composerK.U();
            int iG = streakDetailViewState.g();
            boolean zE = composerK.e(size);
            Object objG = composerK.G();
            if (zE || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.t0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(StreakDetailScreenKt.h0(size));
                    }
                };
                composerK.w(objG);
            }
            PagerState pagerStateL = PagerStateKt.l(iG, 0.0f, (Function0) objG, composerK, 0, 2);
            Integer numValueOf = Integer.valueOf(streakDetailViewState.g());
            boolean Z = composerK.Z(pagerStateL) | ((i5 & 14) == 4);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new StreakDetailScreenKt$StreakMonthCalendar$2$1(pagerStateL, streakDetailViewState, null);
                composerK.w(objG2);
            }
            EffectsKt.g(numValueOf, (Function2) objG2, composerK, 0);
            boolean Z2 = composerK.Z(pagerStateL) | ((i5 & 112) == 32);
            Object objG3 = composerK.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new StreakDetailScreenKt$StreakMonthCalendar$3$1(pagerStateL, function1, null);
                composerK.w(objG3);
            }
            EffectsKt.g(pagerStateL, (Function2) objG3, composerK, 0);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            n0(streakDetailViewState, function1, composerK, i5 & 126);
            float f3 = 8;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            x0(streakDetailViewState.k(), composerK, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            composer2 = composerK;
            PagerKt.a(pagerStateL, SizeKt.i(companion, i0(AnimateAsStateKt.c(Dp.g(f120673c * (((StreakDetailViewState.MonthPage) CollectionsKt.getOrNull(streakDetailViewState.e(), pagerStateL.U())) != null ? C0(r4.a()) : 6)), AnimationSpecKt.n(280, 0, EasingKt.d(), 2, null), "streakCalendarHeight", null, composerK, 384, 8))), null, null, 0, 0.0f, companion2.l(), null, false, false, null, null, null, null, ComposableLambdaKt.e(-967720235, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.u0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return StreakDetailScreenKt.j0(streakDetailViewState, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), composer2, 1572864, 24576, 16316);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakDetailScreenKt.k0(streakDetailViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(StreakDetailViewState streakDetailViewState, Function1 function1, int i3, Composer composer, int i4) {
        f0(streakDetailViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final float i0(State state) {
        return ((Dp) state.getValue()).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(StreakDetailViewState streakDetailViewState, PagerScope HorizontalPager, int i3, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.M()) {
            ComposerKt.U(-967720235, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakMonthCalendar.<anonymous>.<anonymous> (StreakDetailScreen.kt:379)");
        }
        l0(((StreakDetailViewState.MonthPage) streakDetailViewState.e().get(i3)).a(), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(StreakDetailViewState streakDetailViewState, Function1 function1, int i3, Composer composer, int i4) {
        f0(streakDetailViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void l0(final List list, Composer composer, final int i3) {
        Composer composerK = composer.k(-819062924);
        int i4 = (i3 & 6) == 0 ? (composerK.I(list) ? 4 : 2) | i3 : i3;
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-819062924, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakMonthGrid (StreakDetailScreen.kt:443)");
            }
            float f3 = 0.0f;
            Object obj = null;
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            composerK.a0(-57906605);
            for (List list2 : CollectionsKt.chunked(list, f120672b)) {
                Modifier.Companion companion2 = Modifier.b8;
                Modifier modifierH2 = SizeKt.h(companion2, f3, 1, obj);
                Alignment.Companion companion3 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion3.e(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH2);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
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
                Updater.e(composerA2, measurePolicyG, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion4.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                c0(list2, composerK, 0);
                Modifier modifierH3 = SizeKt.h(companion2, 0.0f, 1, null);
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion3.l(), composerK, 0);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierH3);
                Function0 function0A3 = companion4.a();
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
                Updater.e(composerA3, measurePolicyB, companion4.e());
                Updater.e(composerA3, compositionLocalMapU3, companion4.g());
                Function2 function2B3 = companion4.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion4.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                composerK.a0(991201335);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    K((StreakDetailViewState.DayCell) it.next(), RowScope.c(rowScopeInstance, Modifier.b8, 1.0f, false, 2, null), composerK, 0, 0);
                }
                composerK.U();
                composerK.a0(991208948);
                int size = f120672b - list2.size();
                for (int i5 = 0; i5 < size; i5++) {
                    SpacerKt.a(RowScope.c(rowScopeInstance, Modifier.b8, 1.0f, false, 2, null), composerK, 0);
                }
                composerK.U();
                composerK.y();
                composerK.y();
                obj = null;
                f3 = 0.0f;
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return StreakDetailScreenKt.m0(list, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(List list, int i3, Composer composer, int i4) {
        l0(list, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void n0(final StreakDetailViewState streakDetailViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-214593316);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(streakDetailViewState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-214593316, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakMonthPicker (StreakDetailScreen.kt:388)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            int i5 = i4 & 112;
            boolean z2 = i5 == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StreakDetailScreenKt.o0(function1);
                    }
                };
                composerK.w(objG);
            }
            IconButtonKt.a((Function0) objG, null, streakDetailViewState.c(), null, ComposableLambdaKt.e(2099451612, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakDetailScreenKt.p0(streakDetailViewState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 24576, 10);
            StreakDetailViewState.MonthPage monthPageF = streakDetailViewState.f();
            String strB = monthPageF != null ? monthPageF.b() : null;
            if (strB == null) {
                strB = "";
            }
            TextKt.c(strB, RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composerK, MaterialTheme.f13092b).i(), composerK, 0, 0, 65016);
            composerK = composerK;
            boolean z3 = i5 == 32;
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StreakDetailScreenKt.q0(function1);
                    }
                };
                composerK.w(objG2);
            }
            IconButtonKt.a((Function0) objG2, null, streakDetailViewState.d(), null, ComposableLambdaKt.e(150313669, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakDetailScreenKt.r0(streakDetailViewState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 24576, 10);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakDetailScreenKt.s0(streakDetailViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(Function1 function1) {
        function1.invoke(StreakDetailViewEvent.OnPreviousMonthClicked.f120691a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(StreakDetailViewState streakDetailViewState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2099451612, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakMonthPicker.<anonymous>.<anonymous> (StreakDetailScreen.kt:397)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95577x1, composer, 6), null, AlphaKt.a(Modifier.b8, streakDetailViewState.c() ? 1.0f : 0.25f), ComposeColorsKt.j(composer, 0).q(), composer, 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(Function1 function1) {
        function1.invoke(StreakDetailViewEvent.OnNextMonthClicked.f120690a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(StreakDetailViewState streakDetailViewState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(150313669, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakMonthPicker.<anonymous>.<anonymous> (StreakDetailScreen.kt:417)");
            }
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95580y1, composer, 6), null, AlphaKt.a(Modifier.b8, streakDetailViewState.d() ? 1.0f : 0.25f), ComposeColorsKt.j(composer, 0).q(), composer, 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(StreakDetailViewState streakDetailViewState, Function1 function1, int i3, Composer composer, int i4) {
        n0(streakDetailViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void t0(final java.lang.String r32, final int r33, androidx.compose.ui.Modifier r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.detail.StreakDetailScreenKt.t0(java.lang.String, int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(String str, int i3, Modifier modifier, int i4, int i5, Composer composer, int i6) {
        t0(str, i3, modifier, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    private static final void v0(final StreakDetailViewState streakDetailViewState, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1311576120);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(streakDetailViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1311576120, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakStatsCard (StreakDetailScreen.kt:255)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 1;
            Modifier modifierK = PaddingKt.k(BorderKt.f(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), ComposeColorsKt.j(composerK, 0).u(), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composerK, 0))), 0.0f, Dp.g(12), 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            t0(StringResources_androidKt.b(R.string.KA, composerK, 0), streakDetailViewState.i().a(), RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composerK, 0, 0);
            float f4 = 36;
            BoxKt.a(BackgroundKt.d(SizeKt.x(SizeKt.i(companion, Dp.g(f4)), Dp.g(f3), Dp.g(f4)), ComposeColorsKt.j(composerK, 0).u(), null, 2, null), composerK, 0);
            t0(StringResources_androidKt.b(R.string.PA, composerK, 0), streakDetailViewState.i().c(), RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composerK, 0, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakDetailScreenKt.w0(streakDetailViewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(StreakDetailViewState streakDetailViewState, int i3, Composer composer, int i4) {
        v0(streakDetailViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void x0(final List list, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(638866979);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(list) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        int i5 = 0;
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(638866979, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.detail.StreakWeekdayHeader (StreakDetailScreen.kt:428)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(-1705295313);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Composer composer3 = composerK;
                TextKt.c((String) it.next(), RowScope.c(rowScopeInstance, Modifier.b8, 1.0f, false, 2, null), ComposeColorsKt.j(composerK, i5).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composerK, MaterialTheme.f13092b).d(), composer3, 0, 0, 65016);
                composerK = composer3;
                rowScopeInstance = rowScopeInstance;
                i5 = i5;
            }
            composer2 = composerK;
            composer2.U();
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.detail.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakDetailScreenKt.y0(list, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(List list, int i3, Composer composer, int i4) {
        x0(list, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h0(int i3) {
        return i3;
    }
}
