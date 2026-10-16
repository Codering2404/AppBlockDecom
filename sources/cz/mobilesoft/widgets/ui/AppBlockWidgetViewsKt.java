package cz.mobilesoft.widgets.ui;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.glance.BackgroundKt;
import androidx.glance.ColorFilter;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.ImageKt;
import androidx.glance.ImageProvider;
import androidx.glance.action.Action;
import androidx.glance.action.ActionKt;
import androidx.glance.action.LambdaActionKt;
import androidx.glance.appwidget.AndroidRemoteViewsKt;
import androidx.glance.appwidget.CornerRadiusKt;
import androidx.glance.appwidget.action.StartActivityIntentActionKt;
import androidx.glance.appwidget.lazy.LazyItemScope;
import androidx.glance.appwidget.lazy.LazyListScope;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.text.FontWeight;
import androidx.glance.text.TextAlign;
import androidx.glance.text.TextKt;
import androidx.glance.text.TextStyle;
import androidx.glance.unit.ColorProvider;
import com.facebook.internal.Utility;
import com.google.common.cache.LSNn.vfptEEmYY;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import cz.mobilesoft.widgets.R;
import cz.mobilesoft.widgets.WidgetDataProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AppBlockWidgetViewsKt {
    public static final void A0(final RowScope rowScope, final int i3, final String text, final Action onClick, Composer composer, final int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerK = composer.k(1436903489);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(rowScope) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.Z(text) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.Z(onClick) ? 2048 : 1024;
        }
        if ((i5 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1436903489, i5, -1, "cz.mobilesoft.widgets.ui.QuickButton (AppBlockWidgetViews.kt:417)");
            }
            float f3 = 8;
            GlanceModifier glanceModifierA = ActionKt.a(rowScope.a(PaddingKt.f(SizeModifiersKt.d(CornerRadiusKt.a(RoundedCornersKt.d(BackgroundKt.a(GlanceModifier.f37605a, GlanceTheme.f37608a.a(composerK, GlanceTheme.f37609b).i()), false, composerK, 0, 1), Dp.g(20)), Dp.g(40)), Dp.g(f3), 0.0f, Dp.g(f3), 0.0f, 10, null)), onClick);
            Alignment.Companion companion = Alignment.f39415c;
            RowKt.a(glanceModifierA, companion.c(), companion.e(), ComposableLambdaKt.b(composerK, -1560999075, true, new Function3() { // from class: cz.mobilesoft.widgets.ui.p0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppBlockWidgetViewsKt.B0(i3, text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), composerK, 3072, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.C0(rowScope, i3, text, onClick, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(int i3, String str, RowScope Row, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(Row, "$this$Row");
        if (ComposerKt.M()) {
            ComposerKt.U(-1560999075, i4, -1, "cz.mobilesoft.widgets.ui.QuickButton.<anonymous> (AppBlockWidgetViews.kt:430)");
        }
        GlanceModifier glanceModifierF = PaddingKt.f(SizeModifiersKt.e(GlanceModifier.f37605a, Dp.g(32)), 0.0f, 0.0f, Dp.g(8), 0.0f, 11, null);
        ImageProvider imageProviderB = ImageKt.b(i3);
        ColorFilter.Companion companion = ColorFilter.f37575b;
        GlanceTheme glanceTheme = GlanceTheme.f37608a;
        int i5 = GlanceTheme.f37609b;
        ImageKt.a(imageProviderB, null, glanceModifierF, 0, companion.a(glanceTheme.a(composer, i5).d()), composer, (ColorFilter.f37576c << 12) | 48, 8);
        TextKt.a(str, null, new TextStyle(glanceTheme.a(composer, i5).d(), TextUnit.b(TextUnitKt.i(14)), FontWeight.d(FontWeight.f39746b.a()), null, null, null, null, 120, null), 1, composer, 3072, 2);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(RowScope rowScope, int i3, String str, Action action, int i4, Composer composer, int i5) {
        A0(rowScope, i3, str, action, composer, i4 | 1);
        return Unit.f139807a;
    }

    public static final void D0(final WidgetDataProvider provider, final Context context, final AppBlockWidgetState.QuickBlockWidgetState state, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerK = composer.k(1184277125);
        if ((i3 & 6) == 0) {
            int i5 = i3 & 8;
            i4 = (composerK.Z(provider) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(context) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(state) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1184277125, i4, -1, "cz.mobilesoft.widgets.ui.QuickButtons (AppBlockWidgetViews.kt:375)");
            }
            GlanceModifier glanceModifierC = SizeModifiersKt.c(GlanceModifier.f37605a);
            Alignment.Companion companion = Alignment.f39415c;
            RowKt.a(glanceModifierC, companion.c(), companion.e(), ComposableLambdaKt.b(composerK, -24428567, true, new Function3() { // from class: cz.mobilesoft.widgets.ui.j
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppBlockWidgetViewsKt.E0(provider, state, context, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), composerK, 3072, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.H0(provider, context, state, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(final WidgetDataProvider widgetDataProvider, AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, Context context, RowScope Row, Composer composer, int i3) {
        Action actionA;
        Action actionA2;
        Intrinsics.checkNotNullParameter(Row, "$this$Row");
        if (ComposerKt.M()) {
            ComposerKt.U(-24428567, i3, -1, "cz.mobilesoft.widgets.ui.QuickButtons.<anonymous> (AppBlockWidgetViews.kt:382)");
        }
        int iL = widgetDataProvider.l(WidgetDataProvider.WidgetIcon.f134030c);
        String strK = widgetDataProvider.k(WidgetDataProvider.WidgetString.Timer.f134069a);
        boolean z2 = quickBlockWidgetState instanceof AppBlockWidgetState.QuickBlockWidgetState.OnboardingNotFinished;
        if (z2) {
            composer.F(-2001007963);
            composer.Y();
            actionA = StartActivityIntentActionKt.b(widgetDataProvider.f(context), null, 2, null);
        } else if (quickBlockWidgetState instanceof AppBlockWidgetState.QuickBlockWidgetState.NotSetUp) {
            composer.F(-2001004133);
            composer.Y();
            actionA = StartActivityIntentActionKt.b(widgetDataProvider.g(context, WidgetDataProvider.WidgetQuickTimer.f134047g), null, 2, null);
        } else {
            composer.F(-2000999567);
            composer.F(5004770);
            boolean Z = composer.Z(widgetDataProvider);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.widgets.ui.m0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppBlockWidgetViewsKt.F0(widgetDataProvider);
                    }
                };
                composer.w(objG);
            }
            composer.Y();
            actionA = LambdaActionKt.a(null, (Function0) objG, composer, 0, 1);
            composer.Y();
        }
        int i4 = i3 & 14;
        A0(Row, iL, strK, actionA, composer, i4);
        SpacerKt.a(SizeModifiersKt.f(GlanceModifier.f37605a, Dp.g(16)), composer, 0, 0);
        int iL2 = widgetDataProvider.l(WidgetDataProvider.WidgetIcon.f134036j);
        String strK2 = widgetDataProvider.k(WidgetDataProvider.WidgetString.Pomodoro.f134055a);
        if (z2) {
            composer.F(-2000984027);
            composer.Y();
            actionA2 = StartActivityIntentActionKt.b(widgetDataProvider.f(context), null, 2, null);
        } else if (quickBlockWidgetState instanceof AppBlockWidgetState.QuickBlockWidgetState.NotSetUp) {
            composer.F(-2000980197);
            composer.Y();
            actionA2 = StartActivityIntentActionKt.b(widgetDataProvider.g(context, WidgetDataProvider.WidgetQuickTimer.f134047g), null, 2, null);
        } else {
            composer.F(-2000975629);
            composer.F(5004770);
            boolean Z2 = composer.Z(widgetDataProvider);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.widgets.ui.n0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppBlockWidgetViewsKt.G0(widgetDataProvider);
                    }
                };
                composer.w(objG2);
            }
            composer.Y();
            actionA2 = LambdaActionKt.a(null, (Function0) objG2, composer, 0, 1);
            composer.Y();
        }
        A0(Row, iL2, strK2, actionA2, composer, i4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(WidgetDataProvider widgetDataProvider) {
        widgetDataProvider.e(WidgetDataProvider.WidgetQuickTimer.f134047g);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(WidgetDataProvider widgetDataProvider) {
        widgetDataProvider.e(WidgetDataProvider.WidgetQuickTimer.f134048h);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(WidgetDataProvider widgetDataProvider, Context context, AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, int i3, Composer composer, int i4) {
        D0(widgetDataProvider, context, quickBlockWidgetState, composer, i3 | 1);
        return Unit.f139807a;
    }

    public static final void I0(final AppBlockWidgetState.SchedulesWidgetState.Schedule schedule, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        Composer composerK = composer.k(-1413477053);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(schedule) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1413477053, i4, -1, "cz.mobilesoft.widgets.ui.ScheduleItem (AppBlockWidgetViews.kt:662)");
            }
            GlanceModifier glanceModifierD = PaddingKt.d(SizeModifiersKt.c(GlanceModifier.f37605a), 0.0f, Dp.g(12), 1, null);
            Alignment.Companion companion = Alignment.f39415c;
            RowKt.a(glanceModifierD, companion.f(), companion.e(), ComposableLambdaKt.b(composerK, -1710694745, true, new Function3() { // from class: cz.mobilesoft.widgets.ui.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppBlockWidgetViewsKt.J0(schedule, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), composerK, 3072, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.L0(schedule, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(final AppBlockWidgetState.SchedulesWidgetState.Schedule schedule, RowScope Row, Composer composer, int i3) {
        Unit unit;
        Intrinsics.checkNotNullParameter(Row, "$this$Row");
        if (ComposerKt.M()) {
            ComposerKt.U(-1710694745, i3, -1, "cz.mobilesoft.widgets.ui.ScheduleItem.<anonymous> (AppBlockWidgetViews.kt:670)");
        }
        Integer numB = schedule.b();
        if (numB == null) {
            composer.F(774829814);
            composer.Y();
            unit = null;
        } else {
            composer.F(774829815);
            ImageKt.a(ImageKt.b(numB.intValue()), null, SizeModifiersKt.e(GlanceModifier.f37605a, Dp.g(32)), 0, null, composer, 48, 24);
            composer.Y();
            unit = Unit.f139807a;
        }
        if (unit == null) {
            composer.F(775116689);
            SpacerKt.a(SizeModifiersKt.f(GlanceModifier.f37605a, Dp.g(32)), composer, 0, 0);
            composer.Y();
        } else {
            composer.F(994825138);
            composer.Y();
        }
        ColumnKt.a(PaddingKt.d(SizeModifiersKt.c(GlanceModifier.f37605a), Dp.g(16), 0.0f, 2, null), 0, 0, ComposableLambdaKt.b(composer, 1067880221, true, new Function3() { // from class: cz.mobilesoft.widgets.ui.w
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AppBlockWidgetViewsKt.K0(schedule, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), composer, 3072, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(AppBlockWidgetState.SchedulesWidgetState.Schedule schedule, ColumnScope Column, Composer composer, int i3) {
        ColorProvider colorProviderL;
        Intrinsics.checkNotNullParameter(Column, "$this$Column");
        if (ComposerKt.M()) {
            ComposerKt.U(1067880221, i3, -1, "cz.mobilesoft.widgets.ui.ScheduleItem.<anonymous>.<anonymous> (AppBlockWidgetViews.kt:688)");
        }
        String strD = schedule.d();
        GlanceTheme glanceTheme = GlanceTheme.f37608a;
        int i4 = GlanceTheme.f37609b;
        ColorProvider colorProviderB = glanceTheme.a(composer, i4).b();
        TextUnit textUnitB = TextUnit.b(TextUnitKt.i(15));
        FontWeight.Companion companion = FontWeight.f39746b;
        TextKt.a(strD, null, new TextStyle(colorProviderB, textUnitB, FontWeight.d(companion.a()), null, null, null, null, 120, null), 1, composer, 3072, 2);
        String strC = schedule.c();
        if (schedule.e()) {
            composer.F(-264274396);
            colorProviderL = glanceTheme.a(composer, i4).g();
        } else {
            composer.F(-264273371);
            colorProviderL = glanceTheme.a(composer, i4).l();
        }
        composer.Y();
        TextKt.a(strC, null, new TextStyle(colorProviderL, TextUnit.b(TextUnitKt.i(12)), FontWeight.d(companion.c()), null, null, null, null, 120, null), 1, composer, 3072, 2);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(AppBlockWidgetState.SchedulesWidgetState.Schedule schedule, int i3, Composer composer, int i4) {
        I0(schedule, composer, i3 | 1);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void M0(final android.content.Context r14, androidx.glance.GlanceModifier r15, final java.util.List r16, final cz.mobilesoft.widgets.WidgetDataProvider r17, boolean r18, kotlin.jvm.functions.Function2 r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.widgets.ui.AppBlockWidgetViewsKt.M0(android.content.Context, androidx.glance.GlanceModifier, java.util.List, cz.mobilesoft.widgets.WidgetDataProvider, boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(final List list, final WidgetDataProvider widgetDataProvider, final Context context, final boolean z2, final Function2 function2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyColumn.a(list.size(), new Function1<Integer, Long>() { // from class: cz.mobilesoft.widgets.ui.AppBlockWidgetViewsKt$SchedulesList$lambda$0$0$$inlined$itemsIndexed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Long c(int i3) {
                return Long.valueOf(((AppBlockWidgetState.SchedulesWidgetState.Schedule) list.get(i3)).a());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).intValue());
            }
        }, ComposableLambdaKt.c(-1405343893, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.widgets.ui.AppBlockWidgetViewsKt$SchedulesList$lambda$0$0$$inlined$itemsIndexed$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            public final void c(LazyItemScope lazyItemScope, final int i3, Composer composer, int i4) {
                int i5;
                if ((i4 & 14) == 0) {
                    i5 = i4 | (composer.Z(lazyItemScope) ? 4 : 2);
                } else {
                    i5 = i4;
                }
                if ((i4 & 112) == 0) {
                    i5 |= composer.e(i3) ? 32 : 16;
                }
                if ((i5 & 731) == 146 && composer.l()) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-1405343893, i5, -1, "androidx.glance.appwidget.lazy.itemsIndexed.<anonymous> (LazyList.kt:240)");
                }
                final AppBlockWidgetState.SchedulesWidgetState.Schedule schedule = (AppBlockWidgetState.SchedulesWidgetState.Schedule) list.get(i3);
                composer.F(-2005243974);
                GlanceModifier glanceModifierF = PaddingKt.f(ActionKt.a(SizeModifiersKt.c(GlanceModifier.f37605a), StartActivityIntentActionKt.b(widgetDataProvider.p(context, Long.valueOf(schedule.a()), schedule.e()), null, 2, null)), Dp.g(16), 0.0f, 0.0f, 0.0f, 14, null);
                final boolean z3 = z2;
                final List list2 = list;
                ColumnKt.a(glanceModifierF, 0, 0, ComposableLambdaKt.b(composer, -1556338546, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: cz.mobilesoft.widgets.ui.AppBlockWidgetViewsKt$SchedulesList$1$1$2$1
                    public final void c(ColumnScope Column, Composer composer2, int i6) {
                        Intrinsics.checkNotNullParameter(Column, "$this$Column");
                        if (ComposerKt.M()) {
                            ComposerKt.U(-1556338546, i6, -1, "cz.mobilesoft.widgets.ui.SchedulesList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AppBlockWidgetViews.kt:627)");
                        }
                        if (z3 && i3 == 0) {
                            composer2.F(-709602649);
                            SpacerKt.a(BackgroundKt.a(SizeModifiersKt.d(SizeModifiersKt.c(GlanceModifier.f37605a), Dp.g(1)), GlanceTheme.f37608a.a(composer2, GlanceTheme.f37609b).j()), composer2, 0, 0);
                        } else {
                            composer2.F(-730580876);
                        }
                        composer2.Y();
                        AppBlockWidgetViewsKt.I0(schedule, composer2, 0);
                        GlanceModifier.Companion companion = GlanceModifier.f37605a;
                        SpacerKt.a(BackgroundKt.a(SizeModifiersKt.d(SizeModifiersKt.c(companion), Dp.g(1)), GlanceTheme.f37608a.a(composer2, GlanceTheme.f37609b).j()), composer2, 0, 0);
                        if (i3 == list2.size() - 1) {
                            composer2.F(-708909954);
                            SpacerKt.a(SizeModifiersKt.d(companion, Dp.g(8)), composer2, 0, 0);
                        } else {
                            composer2.F(-730580876);
                        }
                        composer2.Y();
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        c((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.f139807a;
                    }
                }), composer, 3072, 6);
                composer.Y();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                c((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }
        }));
        LazyListScope.b(LazyColumn, 0L, ComposableLambdaKt.c(1570549551, true, new Function3() { // from class: cz.mobilesoft.widgets.ui.f0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return AppBlockWidgetViewsKt.O0(function2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 1, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(Function2 function2, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (ComposerKt.M()) {
            ComposerKt.U(1570549551, i3, -1, "cz.mobilesoft.widgets.ui.SchedulesList.<anonymous>.<anonymous>.<anonymous> (AppBlockWidgetViews.kt:654)");
        }
        function2.invoke(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(Context context, GlanceModifier glanceModifier, List list, WidgetDataProvider widgetDataProvider, boolean z2, Function2 function2, int i3, int i4, Composer composer, int i5) {
        M0(context, glanceModifier, list, widgetDataProvider, z2, function2, composer, i3 | 1, i4);
        return Unit.f139807a;
    }

    public static final void Q0(final WidgetDataProvider provider, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Composer composerK = composer.k(-1567327004);
        if ((i3 & 6) == 0) {
            int i5 = i3 & 8;
            i4 = (composerK.Z(provider) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1567327004, i4, -1, "cz.mobilesoft.widgets.ui.SkipButton (AppBlockWidgetViews.kt:234)");
            }
            GlanceModifier glanceModifierB = RoundedCornersKt.b(GlanceModifier.f37605a, false, composerK, 6, 1);
            int iL = provider.l(WidgetDataProvider.WidgetIcon.f134031d);
            String strK = provider.k(WidgetDataProvider.WidgetString.Skip.f134063a);
            composerK.F(5004770);
            boolean Z = composerK.Z(provider);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.widgets.ui.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppBlockWidgetViewsKt.R0(provider);
                    }
                };
                composerK.w(objG);
            }
            composerK.Y();
            X(glanceModifierB, iL, strK, null, 0.0f, LambdaActionKt.a(null, (Function0) objG, composerK, 0, 1), composerK, 0, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.S0(provider, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(WidgetDataProvider widgetDataProvider) {
        widgetDataProvider.i();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(WidgetDataProvider widgetDataProvider, int i3, Composer composer, int i4) {
        Q0(widgetDataProvider, composer, i3 | 1);
        return Unit.f139807a;
    }

    public static final void T0(final WidgetDataProvider provider, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Composer composerK = composer.k(1796323719);
        if ((i3 & 6) == 0) {
            int i5 = i3 & 8;
            i4 = (composerK.Z(provider) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1796323719, i4, -1, "cz.mobilesoft.widgets.ui.SkipButtonLarge (AppBlockWidgetViews.kt:247)");
            }
            GlanceModifier glanceModifierB = RoundedCornersKt.b(GlanceModifier.f37605a, false, composerK, 6, 1);
            int iL = provider.l(WidgetDataProvider.WidgetIcon.f134031d);
            composerK.F(5004770);
            boolean Z = composerK.Z(provider);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.widgets.ui.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppBlockWidgetViewsKt.U0(provider);
                    }
                };
                composerK.w(objG);
            }
            composerK.Y();
            e0(glanceModifierB, iL, null, 0.0f, LambdaActionKt.a(null, (Function0) objG, composerK, 0, 1), composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.V0(provider, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(WidgetDataProvider widgetDataProvider) {
        widgetDataProvider.i();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(WidgetDataProvider widgetDataProvider, int i3, Composer composer, int i4) {
        T0(widgetDataProvider, composer, i3 | 1);
        return Unit.f139807a;
    }

    public static final void W0(final WidgetDataProvider provider, final AppBlockWidgetState.QuickBlockWidgetState state, final Context context, Composer composer, final int i3) {
        int i4;
        Action actionA;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(context, "context");
        Composer composerK = composer.k(745727233);
        if ((i3 & 6) == 0) {
            int i5 = i3 & 8;
            i4 = (composerK.Z(provider) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(state) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(context) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(745727233, i4, -1, "cz.mobilesoft.widgets.ui.StartButton (AppBlockWidgetViews.kt:195)");
            }
            GlanceModifier glanceModifierB = RoundedCornersKt.b(GlanceModifier.f37605a, false, composerK, 6, 1);
            int iL = provider.l(WidgetDataProvider.WidgetIcon.f134031d);
            String strK = provider.k(WidgetDataProvider.WidgetString.Start.f134064a);
            if (state instanceof AppBlockWidgetState.QuickBlockWidgetState.OnboardingNotFinished) {
                composerK.F(-615653699);
                composerK.Y();
                actionA = StartActivityIntentActionKt.b(provider.f(context), null, 2, null);
            } else if (state instanceof AppBlockWidgetState.QuickBlockWidgetState.NotSetUp) {
                composerK.F(-615650030);
                composerK.Y();
                actionA = StartActivityIntentActionKt.b(WidgetDataProvider.h(provider, context, null, 2, null), null, 2, null);
            } else {
                composerK.F(-615646617);
                composerK.F(5004770);
                boolean Z = composerK.Z(provider);
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.widgets.ui.m
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AppBlockWidgetViewsKt.X0(provider);
                        }
                    };
                    composerK.w(objG);
                }
                composerK.Y();
                actionA = LambdaActionKt.a(null, (Function0) objG, composerK, 0, 1);
                composerK.Y();
            }
            X(glanceModifierB, iL, strK, null, 0.0f, actionA, composerK, 0, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.Y0(provider, state, context, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void X(androidx.glance.GlanceModifier r14, final int r15, final java.lang.String r16, androidx.glance.unit.ColorProvider r17, float r18, final androidx.glance.action.Action r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.widgets.ui.AppBlockWidgetViewsKt.X(androidx.glance.GlanceModifier, int, java.lang.String, androidx.glance.unit.ColorProvider, float, androidx.glance.action.Action, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(WidgetDataProvider widgetDataProvider) {
        widgetDataProvider.e(WidgetDataProvider.WidgetQuickTimer.f134046f);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Y(androidx.glance.layout.Alignment r12, final cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState r13, final cz.mobilesoft.widgets.WidgetDataProvider r14, final android.content.Context r15, androidx.compose.runtime.Composer r16, final int r17, final int r18) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.widgets.ui.AppBlockWidgetViewsKt.Y(androidx.glance.layout.Alignment, cz.mobilesoft.widgets.AppBlockWidgetState$QuickBlockWidgetState, cz.mobilesoft.widgets.WidgetDataProvider, android.content.Context, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(WidgetDataProvider widgetDataProvider, AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, Context context, int i3, Composer composer, int i4) {
        W0(widgetDataProvider, quickBlockWidgetState, context, composer, i3 | 1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, WidgetDataProvider widgetDataProvider, Context context, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1632862925, i3, -1, "cz.mobilesoft.widgets.ui.ActionButtonContent.<anonymous> (AppBlockWidgetViews.kt:133)");
            }
            if (quickBlockWidgetState.e()) {
                composer.F(-180151272);
                if ((quickBlockWidgetState instanceof AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro) && ((AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro) quickBlockWidgetState).j().c()) {
                    composer.F(-180057621);
                    Q0(widgetDataProvider, composer, 0);
                    composer.Y();
                } else {
                    composer.F(-179944006);
                    c1(widgetDataProvider, quickBlockWidgetState, context, composer, 0);
                    composer.Y();
                }
                composer.Y();
            } else {
                composer.F(-179743343);
                W0(widgetDataProvider, quickBlockWidgetState, context, composer, 0);
                composer.Y();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    public static final void Z0(final WidgetDataProvider provider, final AppBlockWidgetState.QuickBlockWidgetState state, final Context context, Composer composer, final int i3) {
        int i4;
        Action actionA;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(context, "context");
        Composer composerK = composer.k(1763944402);
        if ((i3 & 6) == 0) {
            int i5 = i3 & 8;
            i4 = (composerK.Z(provider) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(state) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(context) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1763944402, i4, -1, "cz.mobilesoft.widgets.ui.StartButtonLarge (AppBlockWidgetViews.kt:216)");
            }
            GlanceModifier glanceModifierB = RoundedCornersKt.b(GlanceModifier.f37605a, false, composerK, 6, 1);
            int iL = provider.l(WidgetDataProvider.WidgetIcon.f134031d);
            if (state instanceof AppBlockWidgetState.QuickBlockWidgetState.OnboardingNotFinished) {
                composerK.F(-1361498962);
                composerK.Y();
                actionA = StartActivityIntentActionKt.b(provider.f(context), null, 2, null);
            } else if (state instanceof AppBlockWidgetState.QuickBlockWidgetState.NotSetUp) {
                composerK.F(-1361495293);
                composerK.Y();
                actionA = StartActivityIntentActionKt.b(WidgetDataProvider.h(provider, context, null, 2, null), null, 2, null);
            } else {
                composerK.F(-1361491880);
                composerK.F(5004770);
                boolean Z = composerK.Z(provider);
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.widgets.ui.b0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AppBlockWidgetViewsKt.a1(provider);
                        }
                    };
                    composerK.w(objG);
                }
                composerK.Y();
                actionA = LambdaActionKt.a(null, (Function0) objG, composerK, 0, 1);
                composerK.Y();
            }
            e0(glanceModifierB, iL, null, 0.0f, actionA, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.b1(provider, state, context, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Alignment alignment, AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, WidgetDataProvider widgetDataProvider, Context context, int i3, int i4, Composer composer, int i5) {
        Y(alignment, quickBlockWidgetState, widgetDataProvider, context, composer, i3 | 1, i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(WidgetDataProvider widgetDataProvider) {
        widgetDataProvider.e(WidgetDataProvider.WidgetQuickTimer.f134046f);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b0(androidx.glance.layout.Alignment r12, final cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState r13, final cz.mobilesoft.widgets.WidgetDataProvider r14, final android.content.Context r15, androidx.compose.runtime.Composer r16, final int r17, final int r18) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.widgets.ui.AppBlockWidgetViewsKt.b0(androidx.glance.layout.Alignment, cz.mobilesoft.widgets.AppBlockWidgetState$QuickBlockWidgetState, cz.mobilesoft.widgets.WidgetDataProvider, android.content.Context, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(WidgetDataProvider widgetDataProvider, AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, Context context, int i3, Composer composer, int i4) {
        Z0(widgetDataProvider, quickBlockWidgetState, context, composer, i3 | 1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, WidgetDataProvider widgetDataProvider, Context context, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-682983244, i3, -1, "cz.mobilesoft.widgets.ui.ActionButtonContentLarge.<anonymous> (AppBlockWidgetViews.kt:168)");
            }
            if (quickBlockWidgetState.e()) {
                composer.F(-1493695993);
                if ((quickBlockWidgetState instanceof AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro) && ((AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro) quickBlockWidgetState).j().c()) {
                    composer.F(-1493602497);
                    T0(widgetDataProvider, composer, 0);
                    composer.Y();
                } else {
                    composer.F(-1493483922);
                    f1(widgetDataProvider, quickBlockWidgetState, context, composer, 0);
                    composer.Y();
                }
                composer.Y();
            } else {
                composer.F(-1493278299);
                Z0(widgetDataProvider, quickBlockWidgetState, context, composer, 0);
                composer.Y();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    public static final void c1(final WidgetDataProvider provider, final AppBlockWidgetState.QuickBlockWidgetState state, final Context context, Composer composer, final int i3) {
        int i4;
        Action actionA;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(context, "context");
        Composer composerK = composer.k(1663305029);
        if ((i3 & 6) == 0) {
            int i5 = i3 & 8;
            i4 = (composerK.Z(provider) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(state) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(context) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1663305029, i4, -1, "cz.mobilesoft.widgets.ui.StopButton (AppBlockWidgetViews.kt:261)");
            }
            GlanceModifier glanceModifierD = RoundedCornersKt.d(GlanceModifier.f37605a, false, composerK, 6, 1);
            int iL = provider.l(WidgetDataProvider.WidgetIcon.f134032f);
            String strK = provider.k(WidgetDataProvider.WidgetString.Stop.f134065a);
            if (state instanceof AppBlockWidgetState.QuickBlockWidgetState.OnboardingNotFinished) {
                composerK.F(708312481);
                composerK.Y();
                actionA = StartActivityIntentActionKt.b(provider.f(context), null, 2, null);
            } else if (state instanceof AppBlockWidgetState.QuickBlockWidgetState.NotSetUp) {
                composerK.F(708316150);
                composerK.Y();
                actionA = StartActivityIntentActionKt.b(WidgetDataProvider.h(provider, context, null, 2, null), null, 2, null);
            } else {
                composerK.F(708319533);
                composerK.F(5004770);
                boolean Z = composerK.Z(provider);
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.widgets.ui.z
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AppBlockWidgetViewsKt.d1(provider);
                        }
                    };
                    composerK.w(objG);
                }
                composerK.Y();
                actionA = LambdaActionKt.a(null, (Function0) objG, composerK, 0, 1);
                composerK.Y();
            }
            X(glanceModifierD, iL, strK, null, 0.0f, actionA, composerK, 0, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.e1(provider, state, context, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(Alignment alignment, AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, WidgetDataProvider widgetDataProvider, Context context, int i3, int i4, Composer composer, int i5) {
        b0(alignment, quickBlockWidgetState, widgetDataProvider, context, composer, i3 | 1, i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(WidgetDataProvider widgetDataProvider) {
        widgetDataProvider.j();
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e0(androidx.glance.GlanceModifier r13, final int r14, androidx.glance.unit.ColorProvider r15, float r16, final androidx.glance.action.Action r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.widgets.ui.AppBlockWidgetViewsKt.e0(androidx.glance.GlanceModifier, int, androidx.glance.unit.ColorProvider, float, androidx.glance.action.Action, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(WidgetDataProvider widgetDataProvider, AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, Context context, int i3, Composer composer, int i4) {
        c1(widgetDataProvider, quickBlockWidgetState, context, composer, i3 | 1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(float f3, int i3, ColorProvider colorProvider, Composer composer, int i4) {
        if ((i4 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(80081505, i4, -1, "cz.mobilesoft.widgets.ui.ActionButtonLarge.<anonymous> (AppBlockWidgetViews.kt:358)");
            }
            ImageKt.a(ImageKt.b(i3), null, SizeModifiersKt.e(GlanceModifier.f37605a, f3), 0, ColorFilter.f37575b.a(colorProvider), composer, (ColorFilter.f37576c << 12) | 48, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    public static final void f1(final WidgetDataProvider provider, final AppBlockWidgetState.QuickBlockWidgetState state, final Context context, Composer composer, final int i3) {
        int i4;
        Action actionA;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(context, "context");
        Composer composerK = composer.k(-936373746);
        if ((i3 & 6) == 0) {
            int i5 = i3 & 8;
            i4 = (composerK.Z(provider) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(state) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(context) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-936373746, i4, -1, "cz.mobilesoft.widgets.ui.StopButtonLarge (AppBlockWidgetViews.kt:282)");
            }
            GlanceModifier glanceModifierD = RoundedCornersKt.d(GlanceModifier.f37605a, false, composerK, 6, 1);
            int iL = provider.l(WidgetDataProvider.WidgetIcon.f134032f);
            if (state instanceof AppBlockWidgetState.QuickBlockWidgetState.OnboardingNotFinished) {
                composerK.F(2087974826);
                composerK.Y();
                actionA = StartActivityIntentActionKt.b(provider.f(context), null, 2, null);
            } else if (state instanceof AppBlockWidgetState.QuickBlockWidgetState.NotSetUp) {
                composerK.F(2087978495);
                composerK.Y();
                actionA = StartActivityIntentActionKt.b(WidgetDataProvider.h(provider, context, null, 2, null), null, 2, null);
            } else {
                composerK.F(2087981878);
                composerK.F(5004770);
                boolean Z = composerK.Z(provider);
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.widgets.ui.v
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AppBlockWidgetViewsKt.g1(provider);
                        }
                    };
                    composerK.w(objG);
                }
                composerK.Y();
                actionA = LambdaActionKt.a(null, (Function0) objG, composerK, 0, 1);
                composerK.Y();
            }
            e0(glanceModifierD, iL, null, 0.0f, actionA, composerK, 0, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.h1(provider, state, context, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(GlanceModifier glanceModifier, int i3, ColorProvider colorProvider, float f3, Action action, int i4, int i5, Composer composer, int i6) {
        e0(glanceModifier, i3, colorProvider, f3, action, composer, i4 | 1, i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(WidgetDataProvider widgetDataProvider) {
        widgetDataProvider.j();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(GlanceModifier glanceModifier, Action action, final float f3, final int i3, final ColorProvider colorProvider, final String str, Composer composer, int i4) {
        if ((i4 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1855189453, i4, -1, "cz.mobilesoft.widgets.ui.ActionButton.<anonymous> (AppBlockWidgetViews.kt:310)");
            }
            GlanceModifier glanceModifierD = SizeModifiersKt.d(glanceModifier, Dp.g(32));
            float f4 = 16;
            GlanceModifier glanceModifierA = ActionKt.a(CornerRadiusKt.a(PaddingKt.f(glanceModifierD, Dp.g(8), 0.0f, Dp.g(f4), 0.0f, 10, null), Dp.g(f4)), action);
            Alignment.Companion companion = Alignment.f39415c;
            RowKt.a(glanceModifierA, companion.c(), companion.e(), ComposableLambdaKt.b(composer, -1416928207, true, new Function3() { // from class: cz.mobilesoft.widgets.ui.o0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppBlockWidgetViewsKt.i0(f3, i3, colorProvider, str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), composer, 3072, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(WidgetDataProvider widgetDataProvider, AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, Context context, int i3, Composer composer, int i4) {
        f1(widgetDataProvider, quickBlockWidgetState, context, composer, i3 | 1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(float f3, int i3, ColorProvider colorProvider, String str, RowScope Row, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(Row, "$this$Row");
        if (ComposerKt.M()) {
            ComposerKt.U(-1416928207, i4, -1, "cz.mobilesoft.widgets.ui.ActionButton.<anonymous>.<anonymous> (AppBlockWidgetViews.kt:319)");
        }
        GlanceModifier.Companion companion = GlanceModifier.f37605a;
        ImageKt.a(ImageKt.b(i3), null, SizeModifiersKt.e(companion, f3), 0, ColorFilter.f37575b.a(colorProvider), composer, (ColorFilter.f37576c << 12) | 48, 8);
        TextKt.a(str, PaddingKt.f(companion, Dp.g(8), 0.0f, 0.0f, 0.0f, 14, null), new TextStyle(colorProvider, TextUnit.b(TextUnitKt.i(15)), FontWeight.d(FontWeight.f39746b.a()), null, null, null, null, 120, null), 1, composer, 3072, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    public static final void i1(final AppBlockWidgetState.QuickBlockWidgetState state, boolean z2, final WidgetDataProvider provider, final WidgetDataProvider.WidgetString titleString, final Context context, Composer composer, final int i3, final int i4) {
        int i5;
        final boolean z3;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(titleString, "titleString");
        Intrinsics.checkNotNullParameter(context, "context");
        Composer composerK = composer.k(501392032);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(state) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            int i7 = i3 & 512;
            i5 |= composerK.Z(provider) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.Z(titleString) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.Z(context) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i5 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
            z3 = z2;
        } else {
            final boolean z4 = i6 != 0 ? false : z2;
            if (ComposerKt.M()) {
                ComposerKt.U(501392032, i5, -1, "cz.mobilesoft.widgets.ui.Title (AppBlockWidgetViews.kt:110)");
            }
            int i8 = i5 >> 6;
            j1(provider, titleString, ComposableLambdaKt.b(composerK, -916246965, true, new Function2() { // from class: cz.mobilesoft.widgets.ui.s0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.n1(z4, state, provider, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }), composerK, (i8 & 112) | (i8 & 14) | 384, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z3 = z4;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.t0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.o1(state, z3, provider, titleString, context, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(GlanceModifier glanceModifier, int i3, String str, ColorProvider colorProvider, float f3, Action action, int i4, int i5, Composer composer, int i6) {
        X(glanceModifier, i3, str, colorProvider, f3, action, composer, i4 | 1, i5);
        return Unit.f139807a;
    }

    public static final void j1(final WidgetDataProvider provider, final WidgetDataProvider.WidgetString titleString, final Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(titleString, "titleString");
        Composer composerK = composer.k(1869345919);
        if ((i3 & 6) == 0) {
            int i6 = i3 & 8;
            i5 = (composerK.Z(provider) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(titleString) ? 32 : 16;
        }
        int i7 = i4 & 4;
        if (i7 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.Z(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (i7 != 0) {
                function2 = ComposableSingletons$AppBlockWidgetViewsKt.f134215a.d();
            }
            if (ComposerKt.M()) {
                ComposerKt.U(1869345919, i5, -1, "cz.mobilesoft.widgets.ui.Title (AppBlockWidgetViews.kt:68)");
            }
            BoxKt.a(PaddingKt.b(RoundedCornersKt.c(GlanceModifier.f37605a, false, composerK, 54, 0), Dp.g(16)), Alignment.f39415c.i(), ComposableLambdaKt.b(composerK, 284623453, true, new Function2() { // from class: cz.mobilesoft.widgets.ui.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.k1(provider, titleString, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }), composerK, (Alignment.f39416d << 3) | 384, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final Function2 function22 = function2;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.m1(provider, titleString, function22, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void k0(AppBlockWidgetState.QuickBlockWidgetState state, WidgetDataProvider provider, Context context, Composer composer, final int i3) {
        int i4;
        final AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState;
        final WidgetDataProvider widgetDataProvider;
        final Context context2;
        Composer composer2;
        String strK;
        ColorProvider colorProviderL;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(context, "context");
        Composer composerK = composer.k(1842650068);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(state) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            int i5 = i3 & 64;
            i4 |= composerK.Z(provider) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(context) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
            quickBlockWidgetState = state;
            widgetDataProvider = provider;
            context2 = context;
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1842650068, i4, -1, "cz.mobilesoft.widgets.ui.ActiveTimer (AppBlockWidgetViews.kt:458)");
            }
            Long lD = state.d();
            if (lD != null) {
                composerK.F(411347026);
                Log.d("QBWidget", "ActiveTimer: " + lD);
                long jLongValue = lD.longValue();
                int i6 = ((i4 << 3) & 112) | 6;
                int i7 = i4 << 6;
                p0(true, state, jLongValue, provider, context, composerK, i6 | (i7 & 7168) | (i7 & 57344));
                quickBlockWidgetState = state;
                widgetDataProvider = provider;
                context2 = context;
                composer2 = composerK;
                composer2.Y();
            } else {
                quickBlockWidgetState = state;
                widgetDataProvider = provider;
                context2 = context;
                composer2 = composerK;
                composer2.F(411618927);
                boolean z2 = true;
                if (quickBlockWidgetState instanceof AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro) {
                    AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro pomodoro = (AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro) quickBlockWidgetState;
                    if (pomodoro.j().c()) {
                        strK = widgetDataProvider.k(WidgetDataProvider.WidgetString.PomodoroBreak.f134056a);
                        z2 = false;
                    } else {
                        strK = widgetDataProvider.k(new WidgetDataProvider.WidgetString.PomodoroFocus(pomodoro.j().b()));
                    }
                } else {
                    strK = widgetDataProvider.k(WidgetDataProvider.WidgetString.Active.f134052a);
                }
                if (z2) {
                    composer2.F(1260222363);
                    colorProviderL = GlanceTheme.f37608a.a(composer2, GlanceTheme.f37609b).g();
                } else {
                    composer2.F(1260223388);
                    colorProviderL = GlanceTheme.f37608a.a(composer2, GlanceTheme.f37609b).l();
                }
                composer2.Y();
                TextKt.a(strK, null, new TextStyle(colorProviderL, TextUnit.b(TextUnitKt.i(14)), FontWeight.d(FontWeight.f39746b.a()), null, null, null, null, 120, null), 0, composer2, 0, 10);
                composer2.Y();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.l0(quickBlockWidgetState, widgetDataProvider, context2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(final WidgetDataProvider widgetDataProvider, final WidgetDataProvider.WidgetString widgetString, final Function2 function2, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(284623453, i3, -1, "cz.mobilesoft.widgets.ui.Title.<anonymous> (AppBlockWidgetViews.kt:75)");
            }
            GlanceModifier.Companion companion = GlanceModifier.f37605a;
            Alignment.Companion companion2 = Alignment.f39415c;
            ColumnKt.a(companion, companion2.g(), companion2.f(), ComposableLambdaKt.b(composer, -2036025305, true, new Function3() { // from class: cz.mobilesoft.widgets.ui.j0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppBlockWidgetViewsKt.l1(widgetDataProvider, widgetString, function2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), composer, 3078, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, WidgetDataProvider widgetDataProvider, Context context, int i3, Composer composer, int i4) {
        k0(quickBlockWidgetState, widgetDataProvider, context, composer, i3 | 1);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m0(final androidx.glance.GlanceModifier r8, final androidx.glance.unit.ColorProvider r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            r0 = -1682283988(0xffffffff9bba622c, float:-3.083456E-22)
            androidx.compose.runtime.Composer r4 = r10.k(r0)
            r10 = r12 & 1
            if (r10 == 0) goto Le
            r1 = r11 | 6
            goto L1e
        Le:
            r1 = r11 & 6
            if (r1 != 0) goto L1d
            boolean r1 = r4.Z(r8)
            if (r1 == 0) goto L1a
            r1 = 4
            goto L1b
        L1a:
            r1 = 2
        L1b:
            r1 = r1 | r11
            goto L1e
        L1d:
            r1 = r11
        L1e:
            r2 = r11 & 48
            if (r2 != 0) goto L32
            r2 = r12 & 2
            if (r2 != 0) goto L2f
            boolean r2 = r4.Z(r9)
            if (r2 == 0) goto L2f
            r2 = 32
            goto L31
        L2f:
            r2 = 16
        L31:
            r1 = r1 | r2
        L32:
            r2 = r1 & 19
            r3 = 18
            if (r2 != r3) goto L43
            boolean r2 = r4.l()
            if (r2 != 0) goto L3f
            goto L43
        L3f:
            r4.Q()
            goto La2
        L43:
            r4.J()
            r2 = r11 & 1
            if (r2 == 0) goto L5e
            boolean r2 = r4.S()
            if (r2 == 0) goto L51
            goto L5e
        L51:
            r4.Q()
            r10 = r12 & 2
            if (r10 == 0) goto L5a
        L58:
            r1 = r1 & (-113(0xffffffffffffff8f, float:NaN))
        L5a:
            r7 = r1
            r1 = r8
            r8 = r7
            goto L73
        L5e:
            if (r10 == 0) goto L62
            androidx.glance.GlanceModifier$Companion r8 = androidx.glance.GlanceModifier.f37605a
        L62:
            r10 = r12 & 2
            if (r10 == 0) goto L5a
            androidx.glance.GlanceTheme r9 = androidx.glance.GlanceTheme.f37608a
            int r10 = androidx.glance.GlanceTheme.f37609b
            androidx.glance.color.ColorProviders r9 = r9.a(r4, r10)
            androidx.glance.unit.ColorProvider r9 = r9.j()
            goto L58
        L73:
            r4.z()
            boolean r10 = androidx.compose.runtime.ComposerKt.M()
            if (r10 == 0) goto L82
            r10 = -1
            java.lang.String r2 = "cz.mobilesoft.widgets.ui.Divider (AppBlockWidgetViews.kt:714)"
            androidx.compose.runtime.ComposerKt.U(r0, r8, r10, r2)
        L82:
            cz.mobilesoft.widgets.ui.t r10 = new cz.mobilesoft.widgets.ui.t
            r10.<init>()
            r0 = -1409768050(0xffffffffabf8a58e, float:-1.766741E-12)
            r2 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.b(r4, r0, r2, r10)
            r8 = r8 & 14
            r5 = r8 | 384(0x180, float:5.38E-43)
            r6 = 2
            r2 = 0
            androidx.glance.layout.BoxKt.a(r1, r2, r3, r4, r5, r6)
            boolean r8 = androidx.compose.runtime.ComposerKt.M()
            if (r8 == 0) goto La1
            androidx.compose.runtime.ComposerKt.T()
        La1:
            r8 = r1
        La2:
            androidx.compose.runtime.ScopeUpdateScope r10 = r4.n()
            if (r10 == 0) goto Lb0
            cz.mobilesoft.widgets.ui.u r0 = new cz.mobilesoft.widgets.ui.u
            r0.<init>()
            r10.a(r0)
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.widgets.ui.AppBlockWidgetViewsKt.m0(androidx.glance.GlanceModifier, androidx.glance.unit.ColorProvider, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(WidgetDataProvider widgetDataProvider, WidgetDataProvider.WidgetString widgetString, Function2 function2, int i3, int i4, Composer composer, int i5) {
        j1(widgetDataProvider, widgetString, function2, composer, i3 | 1, i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(ColorProvider colorProvider, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1409768050, i3, -1, "cz.mobilesoft.widgets.ui.Divider.<anonymous> (AppBlockWidgetViews.kt:718)");
            }
            SpacerKt.a(BackgroundKt.a(SizeModifiersKt.b(GlanceModifier.f37605a), colorProvider), composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(boolean z2, AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, WidgetDataProvider widgetDataProvider, Context context, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-916246965, i3, -1, "cz.mobilesoft.widgets.ui.Title.<anonymous> (AppBlockWidgetViews.kt:115)");
            }
            if (z2 && quickBlockWidgetState.e()) {
                composer.F(-1396120803);
                k0(quickBlockWidgetState, widgetDataProvider, context, composer, 0);
            } else {
                composer.F(-1400430857);
            }
            composer.Y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(GlanceModifier glanceModifier, ColorProvider colorProvider, int i3, int i4, Composer composer, int i5) {
        m0(glanceModifier, colorProvider, composer, i3 | 1, i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, boolean z2, WidgetDataProvider widgetDataProvider, WidgetDataProvider.WidgetString widgetString, Context context, int i3, int i4, Composer composer, int i5) {
        i1(quickBlockWidgetState, z2, widgetDataProvider, widgetString, context, composer, i3 | 1, i4);
        return Unit.f139807a;
    }

    public static final void p0(final boolean z2, final AppBlockWidgetState.QuickBlockWidgetState state, final long j3, final WidgetDataProvider provider, final Context context, Composer composer, final int i3) {
        int i4;
        String strK;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(context, "context");
        Composer composerK = composer.k(1240674790);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(state) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.f(j3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            int i5 = i3 & 4096;
            i4 |= composerK.Z(provider) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(context) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i4 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1240674790, i4, -1, "cz.mobilesoft.widgets.ui.GlanceTimer (AppBlockWidgetViews.kt:500)");
            }
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.f133941a);
            int i6 = R.id.f133940a;
            remoteViews.setTextColor(i6, -13658369);
            if (state instanceof AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro) {
                AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro pomodoro = (AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro) state;
                if (pomodoro.j().c()) {
                    remoteViews.setTextColor(i6, -1711276033);
                    strK = provider.k(WidgetDataProvider.WidgetString.PomodoroBreakWithCountdown.f134057a);
                } else {
                    strK = provider.k(new WidgetDataProvider.WidgetString.PomodoroFocusWithCountdown(pomodoro.j().b()));
                }
            } else {
                strK = provider.k(WidgetDataProvider.WidgetString.TimerFormatCountDown.f134071a);
            }
            String str = strK;
            Log.d("QBWidget", "ActiveTimer: " + j3 + " with text: " + str);
            long jCurrentTimeMillis = j3 - System.currentTimeMillis();
            remoteViews.setChronometerCountDown(i6, true);
            remoteViews.setChronometer(i6, SystemClock.elapsedRealtime() + jCurrentTimeMillis, str, z2);
            AndroidRemoteViewsKt.b(remoteViews, null, composerK, 0, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.q0(z2, state, j3, provider, context, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(boolean z2, AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, long j3, WidgetDataProvider widgetDataProvider, Context context, int i3, Composer composer, int i4) {
        p0(z2, quickBlockWidgetState, j3, widgetDataProvider, context, composer, i3 | 1);
        return Unit.f139807a;
    }

    public static final void r0(final WidgetDataProvider provider, final Context context, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(context, "context");
        Composer composerK = composer.k(-1896423146);
        if ((i3 & 6) == 0) {
            int i5 = i3 & 8;
            i4 = (composerK.Z(provider) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(context) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1896423146, i4, -1, "cz.mobilesoft.widgets.ui.PremiumContent (AppBlockWidgetViews.kt:730)");
            }
            BoxKt.a(ActionKt.a(PaddingKt.d(SizeModifiersKt.b(GlanceModifier.f37605a), Dp.g(16), 0.0f, 2, null), StartActivityIntentActionKt.b(provider.m(context, WidgetDataProvider.WidgetPremiumFeature.f134040b), null, 2, null)), Alignment.f39415c.b(), ComposableLambdaKt.b(composerK, -245011724, true, new Function2() { // from class: cz.mobilesoft.widgets.ui.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.s0(provider, (Composer) obj, ((Integer) obj2).intValue());
                }
            }), composerK, (Alignment.f39416d << 3) | 384, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.w0(provider, context, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(final WidgetDataProvider widgetDataProvider, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-245011724, i3, -1, "cz.mobilesoft.widgets.ui.PremiumContent.<anonymous> (AppBlockWidgetViews.kt:738)");
            }
            ColumnKt.a(null, 0, 0, ComposableLambdaKt.b(composer, 1161557182, true, new Function3() { // from class: cz.mobilesoft.widgets.ui.w0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppBlockWidgetViewsKt.t0(widgetDataProvider, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), composer, 3072, 7);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(final WidgetDataProvider widgetDataProvider, ColumnScope Column, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Column, "$this$Column");
        if (ComposerKt.M()) {
            ComposerKt.U(1161557182, i3, -1, "cz.mobilesoft.widgets.ui.PremiumContent.<anonymous>.<anonymous> (AppBlockWidgetViews.kt:739)");
        }
        TextKt.a(widgetDataProvider.k(WidgetDataProvider.WidgetString.WidgetOnlyForPremium.f134072a), null, new TextStyle(GlanceTheme.f37608a.a(composer, GlanceTheme.f37609b).l(), TextUnit.b(TextUnitKt.i(15)), FontWeight.d(FontWeight.f39746b.c()), null, TextAlign.f(TextAlign.f39751b.a()), null, null, 104, null), 0, composer, 0, 10);
        GlanceModifier.Companion companion = GlanceModifier.f37605a;
        SpacerKt.a(SizeModifiersKt.d(companion, Dp.g(18)), composer, 0, 0);
        BoxKt.a(SizeModifiersKt.c(companion), Alignment.f39415c.b(), ComposableLambdaKt.b(composer, -1297117024, true, new Function2() { // from class: cz.mobilesoft.widgets.ui.y
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return AppBlockWidgetViewsKt.u0(widgetDataProvider, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), composer, (Alignment.f39416d << 3) | 384, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(final WidgetDataProvider widgetDataProvider, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1297117024, i3, -1, "cz.mobilesoft.widgets.ui.PremiumContent.<anonymous>.<anonymous>.<anonymous> (AppBlockWidgetViews.kt:757)");
            }
            GlanceModifier glanceModifierF = PaddingKt.f(SizeModifiersKt.d(RoundedCornersKt.d(GlanceModifier.f37605a, false, composer, 6, 1), Dp.g(32)), Dp.g(8), 0.0f, Dp.g(16), 0.0f, 10, null);
            Alignment.Companion companion = Alignment.f39415c;
            RowKt.a(glanceModifierF, companion.c(), companion.e(), ComposableLambdaKt.b(composer, -102100732, true, new Function3() { // from class: cz.mobilesoft.widgets.ui.g0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppBlockWidgetViewsKt.v0(widgetDataProvider, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), composer, 3072, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(WidgetDataProvider widgetDataProvider, RowScope Row, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Row, "$this$Row");
        if (ComposerKt.M()) {
            ComposerKt.U(-102100732, i3, -1, "cz.mobilesoft.widgets.ui.PremiumContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AppBlockWidgetViews.kt:765)");
        }
        GlanceModifier.Companion companion = GlanceModifier.f37605a;
        ImageKt.a(ImageKt.b(widgetDataProvider.l(WidgetDataProvider.WidgetIcon.f134028a)), null, SizeModifiersKt.e(companion, Dp.g(16)), 0, null, composer, 48, 24);
        TextKt.a(widgetDataProvider.k(WidgetDataProvider.WidgetString.Premium.f134060a), PaddingKt.f(companion, Dp.g(8), 0.0f, 0.0f, 0.0f, 14, null), new TextStyle(GlanceTheme.f37608a.a(composer, GlanceTheme.f37609b).h(), TextUnit.b(TextUnitKt.i(15)), FontWeight.d(FontWeight.f39746b.a()), null, null, null, null, 120, null), 0, composer, 0, 8);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(WidgetDataProvider widgetDataProvider, Context context, int i3, Composer composer, int i4) {
        r0(widgetDataProvider, context, composer, i3 | 1);
        return Unit.f139807a;
    }

    public static final void x0(final Context context, final AppBlockWidgetState.QuickBlockWidgetState state, final WidgetDataProvider provider, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(provider, "provider");
        Composer composerK = composer.k(1991059797);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(context) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(state) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            int i5 = i3 & 512;
            i4 |= composerK.Z(provider) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1991059797, i4, -1, "cz.mobilesoft.widgets.ui.PremiumNotActiveRow (AppBlockWidgetViews.kt:550)");
            }
            GlanceModifier glanceModifierA = ActionKt.a(PaddingKt.f(SizeModifiersKt.d(SizeModifiersKt.c(RoundedCornersKt.d(GlanceModifier.f37605a, false, composerK, 6, 1)), Dp.g(40)), Dp.g(8), 0.0f, Dp.g(16), 0.0f, 10, null), state instanceof AppBlockWidgetState.QuickBlockWidgetState.OnboardingNotFinished ? StartActivityIntentActionKt.b(provider.f(context), null, 2, null) : state instanceof AppBlockWidgetState.QuickBlockWidgetState.NotSetUp ? StartActivityIntentActionKt.b(WidgetDataProvider.h(provider, context, null, 2, null), null, 2, null) : StartActivityIntentActionKt.b(provider.m(context, WidgetDataProvider.WidgetPremiumFeature.f134039a), null, 2, null));
            Alignment.Companion companion = Alignment.f39415c;
            RowKt.a(glanceModifierA, companion.c(), companion.e(), ComposableLambdaKt.b(composerK, 1353937777, true, new Function3() { // from class: cz.mobilesoft.widgets.ui.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppBlockWidgetViewsKt.y0(provider, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), composerK, 3072, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.ui.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBlockWidgetViewsKt.z0(context, state, provider, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(WidgetDataProvider widgetDataProvider, RowScope Row, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Row, "$this$Row");
        if (ComposerKt.M()) {
            ComposerKt.U(1353937777, i3, -1, "cz.mobilesoft.widgets.ui.PremiumNotActiveRow.<anonymous> (AppBlockWidgetViews.kt:567)");
        }
        GlanceModifier.Companion companion = GlanceModifier.f37605a;
        float f3 = 16;
        GlanceModifier glanceModifierE = SizeModifiersKt.e(companion, Dp.g(f3));
        ImageProvider imageProviderB = ImageKt.b(widgetDataProvider.l(WidgetDataProvider.WidgetIcon.f134030c));
        ColorFilter.Companion companion2 = ColorFilter.f37575b;
        GlanceTheme glanceTheme = GlanceTheme.f37608a;
        int i4 = GlanceTheme.f37609b;
        ImageKt.a(imageProviderB, null, glanceModifierE, 0, companion2.a(glanceTheme.a(composer, i4).d()), composer, (ColorFilter.f37576c << 12) | 48, 8);
        TextKt.a(widgetDataProvider.k(WidgetDataProvider.WidgetString.TimerAndPomodoro.f134070a), PaddingKt.f(companion, Dp.g(8), 0.0f, 0.0f, 0.0f, 14, null), new TextStyle(glanceTheme.a(composer, i4).b(), TextUnit.b(TextUnitKt.i(15)), FontWeight.d(FontWeight.f39746b.a()), null, null, null, null, 120, null), 0, composer, 0, 8);
        SpacerKt.a(Row.a(companion), composer, 0, 0);
        ImageKt.a(ImageKt.b(widgetDataProvider.l(WidgetDataProvider.WidgetIcon.f134028a)), null, SizeModifiersKt.e(companion, Dp.g(f3)), 0, null, composer, 48, 24);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(Context context, AppBlockWidgetState.QuickBlockWidgetState quickBlockWidgetState, WidgetDataProvider widgetDataProvider, int i3, Composer composer, int i4) {
        x0(context, quickBlockWidgetState, widgetDataProvider, composer, i3 | 1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(WidgetDataProvider widgetDataProvider, WidgetDataProvider.WidgetString widgetString, Function2 function2, ColumnScope Column, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Column, "$this$Column");
        if (ComposerKt.M()) {
            ComposerKt.U(-2036025305, i3, -1, vfptEEmYY.mBILvHeXimvO);
        }
        String strK = widgetDataProvider.k(WidgetDataProvider.WidgetString.ApplicationName.f134054a);
        GlanceTheme glanceTheme = GlanceTheme.f37608a;
        int i4 = GlanceTheme.f37609b;
        ColorProvider colorProviderG = glanceTheme.a(composer, i4).g();
        TextUnit textUnitB = TextUnit.b(TextUnitKt.i(14));
        FontWeight.Companion companion = FontWeight.f39746b;
        TextKt.a(strK, null, new TextStyle(colorProviderG, textUnitB, FontWeight.d(companion.a()), null, null, null, null, 120, null), 0, composer, 0, 10);
        TextKt.a(widgetDataProvider.k(widgetString), null, new TextStyle(glanceTheme.a(composer, i4).d(), TextUnit.b(TextUnitKt.i(20)), FontWeight.d(companion.a()), null, null, null, null, 120, null), 0, composer, 0, 10);
        function2.invoke(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }
}
