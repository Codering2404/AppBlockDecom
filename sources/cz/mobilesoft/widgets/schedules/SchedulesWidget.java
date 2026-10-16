package cz.mobilesoft.widgets.schedules;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceTheme;
import androidx.glance.GlanceThemeKt;
import androidx.glance.action.ActionKt;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.SizeMode;
import androidx.glance.appwidget.action.StartActivityIntentActionKt;
import androidx.glance.color.ColorProviders;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.ColumnKt;
import androidx.glance.layout.ColumnScope;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
import androidx.glance.layout.SpacerKt;
import androidx.glance.state.GlanceStateDefinition;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import cz.mobilesoft.widgets.AppBlockWidgetStateDefinition;
import cz.mobilesoft.widgets.WidgetApplication;
import cz.mobilesoft.widgets.WidgetDataProvider;
import cz.mobilesoft.widgets.ui.AppBlockWidgetViewsKt;
import cz.mobilesoft.widgets.ui.AppBlockWidgetsColorScheme;
import cz.mobilesoft.widgets.ui.RoundedCornersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SchedulesWidget extends GlanceAppWidget {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f134124h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f134125i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f134126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f134127k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f134128l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SizeMode.Responsive f134129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GlanceStateDefinition f134130g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        float f3 = 200;
        f134126j = DpKt.b(Dp.g(ModuleDescriptor.MODULE_VERSION), Dp.g(f3));
        float f4 = 250;
        f134127k = DpKt.b(Dp.g(f4), Dp.g(f3));
        f134128l = DpKt.b(Dp.g(f4), Dp.g(280));
    }

    public SchedulesWidget() {
        super(0, 1, null);
        this.f134129f = new SizeMode.Responsive(SetsKt.setOf((Object[]) new DpSize[]{DpSize.c(f134126j), DpSize.c(f134127k), DpSize.c(f134128l)}));
        this.f134130g = AppBlockWidgetStateDefinition.f133930a;
    }

    private final void B(final Context context, final WidgetDataProvider widgetDataProvider, final int i3, Composer composer, final int i4) {
        int i5;
        Composer composerK = composer.k(45897241);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(context) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            int i6 = i4 & 64;
            i5 |= composerK.Z(widgetDataProvider) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.e(i3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(45897241, i5, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.AddScheduleButton (SchedulesWidget.kt:240)");
            }
            AppBlockWidgetViewsKt.X(RoundedCornersKt.d(GlanceModifier.f37605a, false, composerK, 54, 0), widgetDataProvider.l(WidgetDataProvider.WidgetIcon.f134033g), widgetDataProvider.k(WidgetDataProvider.WidgetString.Add.f134053a), GlanceTheme.f37608a.a(composerK, GlanceTheme.f37609b).g(), Dp.g(20), StartActivityIntentActionKt.b(widgetDataProvider.a(i3) ? WidgetDataProvider.b(widgetDataProvider, context, null, false, 6, null) : widgetDataProvider.m(context, WidgetDataProvider.WidgetPremiumFeature.f134040b), null, 2, null), composerK, 24576, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.schedules.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesWidget.C(this.f134159a, context, widgetDataProvider, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(SchedulesWidget schedulesWidget, Context context, WidgetDataProvider widgetDataProvider, int i3, int i4, Composer composer, int i5) {
        schedulesWidget.B(context, widgetDataProvider, i3, composer, i4 | 1);
        return Unit.f139807a;
    }

    private final void D(final Context context, final AppBlockWidgetState appBlockWidgetState, final WidgetDataProvider widgetDataProvider, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1958493998);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(context) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(appBlockWidgetState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            int i5 = i3 & 512;
            i4 |= composerK.Z(widgetDataProvider) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(this) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1958493998, i4, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.RootComposeLarge (SchedulesWidget.kt:187)");
            }
            ColumnKt.a(null, 0, 0, ComposableLambdaKt.b(composerK, 1429247096, true, new Function3() { // from class: cz.mobilesoft.widgets.schedules.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SchedulesWidget.E(appBlockWidgetState, context, widgetDataProvider, this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), composerK, 3072, 7);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.schedules.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesWidget.G(this.f134177a, context, appBlockWidgetState, widgetDataProvider, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(final AppBlockWidgetState appBlockWidgetState, final Context context, final WidgetDataProvider widgetDataProvider, final SchedulesWidget schedulesWidget, ColumnScope Column, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Column, "$this$Column");
        if (ComposerKt.M()) {
            ComposerKt.U(1429247096, i3, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.RootComposeLarge.<anonymous> (SchedulesWidget.kt:189)");
        }
        GlanceModifier.Companion companion = GlanceModifier.f37605a;
        RowKt.a(SizeModifiersKt.c(companion), 0, 0, ComposableLambdaKt.b(composer, -817225068, true, new Function3() { // from class: cz.mobilesoft.widgets.schedules.e
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SchedulesWidget.F(widgetDataProvider, schedulesWidget, context, appBlockWidgetState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), composer, 3072, 6);
        if (appBlockWidgetState.g().e().isEmpty()) {
            composer.F(-1604527486);
            AppBlockWidgetViewsKt.m0(SizeModifiersKt.d(PaddingKt.f(SizeModifiersKt.c(companion), Dp.g(16), 0.0f, 0.0f, 0.0f, 14, null), Dp.g(1)), GlanceTheme.f37608a.a(composer, GlanceTheme.f37609b).j(), composer, 0, 0);
            BoxKt.a(SizeModifiersKt.b(companion), Alignment.f39415c.b(), ComposableSingletons$SchedulesWidgetKt.f134122a.b(), composer, (Alignment.f39416d << 3) | 384, 0);
            composer.Y();
        } else {
            composer.F(-1604848987);
            AppBlockWidgetViewsKt.M0(context, Column.a(companion), appBlockWidgetState.g().e(), widgetDataProvider, false, null, composer, 0, 48);
            composer.Y();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(WidgetDataProvider widgetDataProvider, SchedulesWidget schedulesWidget, Context context, AppBlockWidgetState appBlockWidgetState, RowScope Row, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Row, "$this$Row");
        if (ComposerKt.M()) {
            ComposerKt.U(-817225068, i3, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.RootComposeLarge.<anonymous>.<anonymous> (SchedulesWidget.kt:193)");
        }
        AppBlockWidgetViewsKt.j1(widgetDataProvider, WidgetDataProvider.WidgetString.Schedules.f134062a, null, composer, 48, 4);
        SpacerKt.a(Row.a(GlanceModifier.f37605a), composer, 0, 0);
        schedulesWidget.B(context, widgetDataProvider, appBlockWidgetState.g().e().size(), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(SchedulesWidget schedulesWidget, Context context, AppBlockWidgetState appBlockWidgetState, WidgetDataProvider widgetDataProvider, int i3, Composer composer, int i4) {
        schedulesWidget.D(context, appBlockWidgetState, widgetDataProvider, composer, i3 | 1);
        return Unit.f139807a;
    }

    private final void H(final Context context, final AppBlockWidgetState appBlockWidgetState, final WidgetDataProvider widgetDataProvider, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(793135692);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(context) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(appBlockWidgetState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            int i5 = i3 & 512;
            i4 |= composerK.Z(widgetDataProvider) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(this) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(793135692, i4, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.RootComposeMiddle (SchedulesWidget.kt:144)");
            }
            RowKt.a(null, 0, 0, ComposableLambdaKt.b(composerK, 1402120624, true, new Function3() { // from class: cz.mobilesoft.widgets.schedules.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SchedulesWidget.I(widgetDataProvider, this, context, appBlockWidgetState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), composerK, 3072, 7);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.schedules.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesWidget.L(this.f134195a, context, appBlockWidgetState, widgetDataProvider, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(final WidgetDataProvider widgetDataProvider, final SchedulesWidget schedulesWidget, final Context context, final AppBlockWidgetState appBlockWidgetState, RowScope Row, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Row, "$this$Row");
        if (ComposerKt.M()) {
            ComposerKt.U(1402120624, i3, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.RootComposeMiddle.<anonymous> (SchedulesWidget.kt:146)");
        }
        GlanceModifier.Companion companion = GlanceModifier.f37605a;
        ColumnKt.a(PaddingKt.f(SizeModifiersKt.a(companion), 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null), 0, 0, ComposableLambdaKt.b(composer, -923762906, true, new Function3() { // from class: cz.mobilesoft.widgets.schedules.c
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SchedulesWidget.J(widgetDataProvider, schedulesWidget, context, appBlockWidgetState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), composer, 3072, 6);
        BoxKt.a(Row.a(companion), null, ComposableLambdaKt.b(composer, 1456417550, true, new Function2() { // from class: cz.mobilesoft.widgets.schedules.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SchedulesWidget.K(appBlockWidgetState, context, widgetDataProvider, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), composer, 384, 2);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(WidgetDataProvider widgetDataProvider, SchedulesWidget schedulesWidget, Context context, AppBlockWidgetState appBlockWidgetState, ColumnScope Column, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Column, "$this$Column");
        if (ComposerKt.M()) {
            ComposerKt.U(-923762906, i3, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.RootComposeMiddle.<anonymous>.<anonymous> (SchedulesWidget.kt:151)");
        }
        AppBlockWidgetViewsKt.j1(widgetDataProvider, WidgetDataProvider.WidgetString.Schedules.f134062a, null, composer, 48, 4);
        SpacerKt.a(Column.a(GlanceModifier.f37605a), composer, 0, 0);
        schedulesWidget.B(context, widgetDataProvider, appBlockWidgetState.g().e().size(), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(AppBlockWidgetState appBlockWidgetState, Context context, WidgetDataProvider widgetDataProvider, Composer composer, int i3) {
        Composer composer2;
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1456417550, i3, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.RootComposeMiddle.<anonymous>.<anonymous> (SchedulesWidget.kt:171)");
            }
            if (appBlockWidgetState.g().e().isEmpty()) {
                composer2 = composer;
                composer2.F(369279892);
            } else {
                composer.F(375708610);
                composer2 = composer;
                AppBlockWidgetViewsKt.M0(context, null, appBlockWidgetState.g().e(), widgetDataProvider, false, null, composer2, 0, 50);
            }
            composer2.Y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(SchedulesWidget schedulesWidget, Context context, AppBlockWidgetState appBlockWidgetState, WidgetDataProvider widgetDataProvider, int i3, Composer composer, int i4) {
        schedulesWidget.H(context, appBlockWidgetState, widgetDataProvider, composer, i3 | 1);
        return Unit.f139807a;
    }

    private final void M(final Context context, final AppBlockWidgetState appBlockWidgetState, final WidgetDataProvider widgetDataProvider, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1119604730);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(context) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(appBlockWidgetState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            int i5 = i3 & 512;
            i4 |= composerK.Z(widgetDataProvider) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(this) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1119604730, i4, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.RootComposeSmall (SchedulesWidget.kt:116)");
            }
            ColumnKt.a(SizeModifiersKt.b(GlanceModifier.f37605a), 0, 0, ComposableLambdaKt.b(composerK, 590357828, true, new Function3() { // from class: cz.mobilesoft.widgets.schedules.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SchedulesWidget.N(widgetDataProvider, appBlockWidgetState, context, this, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), composerK, 3072, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.schedules.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesWidget.P(this.f134186a, context, appBlockWidgetState, widgetDataProvider, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(final WidgetDataProvider widgetDataProvider, final AppBlockWidgetState appBlockWidgetState, final Context context, final SchedulesWidget schedulesWidget, ColumnScope Column, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Column, "$this$Column");
        if (ComposerKt.M()) {
            ComposerKt.U(590357828, i3, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.RootComposeSmall.<anonymous> (SchedulesWidget.kt:121)");
        }
        AppBlockWidgetViewsKt.j1(widgetDataProvider, WidgetDataProvider.WidgetString.Schedules.f134062a, null, composer, 48, 4);
        if (appBlockWidgetState.g().e().isEmpty()) {
            composer.F(-545695490);
        } else {
            composer.F(-540774736);
            AppBlockWidgetViewsKt.M0(context, null, appBlockWidgetState.g().e(), widgetDataProvider, false, ComposableLambdaKt.b(composer, -1360911521, true, new Function2() { // from class: cz.mobilesoft.widgets.schedules.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesWidget.O(this.f134200a, context, widgetDataProvider, appBlockWidgetState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }), composer, 196608, 18);
        }
        composer.Y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(SchedulesWidget schedulesWidget, Context context, WidgetDataProvider widgetDataProvider, AppBlockWidgetState appBlockWidgetState, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1360911521, i3, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.RootComposeSmall.<anonymous>.<anonymous> (SchedulesWidget.kt:128)");
            }
            schedulesWidget.B(context, widgetDataProvider, appBlockWidgetState.g().e().size(), composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(SchedulesWidget schedulesWidget, Context context, AppBlockWidgetState appBlockWidgetState, WidgetDataProvider widgetDataProvider, int i3, Composer composer, int i4) {
        schedulesWidget.M(context, appBlockWidgetState, widgetDataProvider, composer, i3 | 1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(final Context context, final SchedulesWidget schedulesWidget, Composer composer, int i3) {
        final WidgetDataProvider widgetDataProviderA;
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-984836740, i3, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.provideGlance.<anonymous> (SchedulesWidget.kt:63)");
            }
            Object applicationContext = context.getApplicationContext();
            WidgetApplication widgetApplication = applicationContext instanceof WidgetApplication ? (WidgetApplication) applicationContext : null;
            if (widgetApplication == null || (widgetDataProviderA = widgetApplication.a()) == null) {
                throw new IllegalStateException("Application must implement WidgetDataProvider");
            }
            composer.F(-534706435);
            Object objQ = composer.q(CompositionLocalsKt.e());
            if (objQ == null) {
                throw new NullPointerException("null cannot be cast to non-null type cz.mobilesoft.widgets.AppBlockWidgetState");
            }
            final AppBlockWidgetState appBlockWidgetState = (AppBlockWidgetState) objQ;
            composer.Y();
            GlanceThemeKt.a(AppBlockWidgetsColorScheme.f134214a.a(widgetDataProviderA), ComposableLambdaKt.b(composer, -627588699, true, new Function2() { // from class: cz.mobilesoft.widgets.schedules.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesWidget.S(widgetDataProviderA, context, appBlockWidgetState, schedulesWidget, (Composer) obj, ((Integer) obj2).intValue());
                }
            }), composer, ColorProviders.A | 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(final WidgetDataProvider widgetDataProvider, final Context context, final AppBlockWidgetState appBlockWidgetState, final SchedulesWidget schedulesWidget, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-627588699, i3, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.provideGlance.<anonymous>.<anonymous> (SchedulesWidget.kt:69)");
            }
            final long jM = ((DpSize) composer.q(CompositionLocalsKt.d())).m();
            BoxKt.a(ActionKt.a(RoundedCornersKt.c(SizeModifiersKt.b(GlanceModifier.f37605a), false, composer, 48, 0), StartActivityIntentActionKt.b(widgetDataProvider.f(context), null, 2, null)), null, ComposableLambdaKt.b(composer, -1427838713, true, new Function2() { // from class: cz.mobilesoft.widgets.schedules.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SchedulesWidget.T(appBlockWidgetState, widgetDataProvider, context, jM, schedulesWidget, (Composer) obj, ((Integer) obj2).intValue());
                }
            }), composer, 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(AppBlockWidgetState appBlockWidgetState, WidgetDataProvider widgetDataProvider, Context context, long j3, SchedulesWidget schedulesWidget, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1427838713, i3, -1, "cz.mobilesoft.widgets.schedules.SchedulesWidget.provideGlance.<anonymous>.<anonymous>.<anonymous> (SchedulesWidget.kt:77)");
            }
            if (appBlockWidgetState.h()) {
                float fJ = DpSize.j(j3);
                long j4 = f134128l;
                if (Dp.f(fJ, DpSize.j(j4)) < 0 || Dp.f(DpSize.i(j3), DpSize.i(j4)) < 0) {
                    float fJ2 = DpSize.j(j3);
                    long j5 = f134127k;
                    if (Dp.f(fJ2, DpSize.j(j5)) < 0 || Dp.f(DpSize.i(j3), DpSize.i(j5)) < 0) {
                        composer.F(614021650);
                        schedulesWidget.M(context, appBlockWidgetState, widgetDataProvider, composer, 0);
                        composer.Y();
                    } else {
                        composer.F(613725073);
                        schedulesWidget.H(context, appBlockWidgetState, widgetDataProvider, composer, 0);
                        composer.Y();
                    }
                } else {
                    composer.F(613375858);
                    schedulesWidget.D(context, appBlockWidgetState, widgetDataProvider, composer, 0);
                    composer.Y();
                }
            } else {
                composer.F(613079591);
                AppBlockWidgetViewsKt.r0(widgetDataProvider, context, composer, 0);
                composer.Y();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    @Override // androidx.glance.appwidget.GlanceAppWidget
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public SizeMode.Responsive c() {
        return this.f134129f;
    }

    @Override // androidx.glance.appwidget.GlanceAppWidget
    public GlanceStateDefinition d() {
        return this.f134130g;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.glance.appwidget.GlanceAppWidget
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object g(final android.content.Context r5, androidx.glance.GlanceId r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.widgets.schedules.SchedulesWidget$provideGlance$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.widgets.schedules.SchedulesWidget$provideGlance$1 r0 = (cz.mobilesoft.widgets.schedules.SchedulesWidget$provideGlance$1) r0
            int r1 = r0.f134135f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f134135f = r1
            goto L18
        L13:
            cz.mobilesoft.widgets.schedules.SchedulesWidget$provideGlance$1 r0 = new cz.mobilesoft.widgets.schedules.SchedulesWidget$provideGlance$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f134133c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f134135f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            java.lang.Object r5 = r0.f134132b
            androidx.glance.GlanceId r5 = (androidx.glance.GlanceId) r5
            java.lang.Object r5 = r0.f134131a
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.b(r7)
            goto L5d
        L39:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.widgets.schedules.b r7 = new cz.mobilesoft.widgets.schedules.b
            r7.<init>()
            r2 = -984836740(0xffffffffc54c957c, float:-3273.3428)
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.c(r2, r3, r7)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f134131a = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f134132b = r5
            r0.f134135f = r3
            java.lang.Object r5 = androidx.glance.appwidget.GlanceAppWidgetKt.a(r4, r7, r0)
            if (r5 != r1) goto L5d
            return r1
        L5d:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.widgets.schedules.SchedulesWidget.g(android.content.Context, androidx.glance.GlanceId, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
