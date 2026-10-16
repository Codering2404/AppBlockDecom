package cz.mobilesoft.widgets.quickblock;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.glance.CompositionLocalsKt;
import androidx.glance.GlanceModifier;
import androidx.glance.GlanceThemeKt;
import androidx.glance.ImageKt;
import androidx.glance.action.ActionKt;
import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.SizeMode;
import androidx.glance.appwidget.action.StartActivityIntentActionKt;
import androidx.glance.color.ColorProviders;
import androidx.glance.layout.Alignment;
import androidx.glance.layout.BoxKt;
import androidx.glance.layout.PaddingKt;
import androidx.glance.layout.RowKt;
import androidx.glance.layout.RowScope;
import androidx.glance.layout.SizeModifiersKt;
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
public final class QuickBlockWidget extends GlanceAppWidget {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f134074h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f134075i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f134076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f134077k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SizeMode.Responsive f134078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final GlanceStateDefinition f134079g;

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
        float f3 = ModuleDescriptor.MODULE_VERSION;
        f134076j = DpKt.b(Dp.g(f3), Dp.g(f3));
        f134077k = DpKt.b(Dp.g(300), Dp.g(f3));
    }

    public QuickBlockWidget() {
        super(0, 1, null);
        this.f134078f = new SizeMode.Responsive(SetsKt.setOf((Object[]) new DpSize[]{DpSize.c(f134076j), DpSize.c(f134077k)}));
        this.f134079g = AppBlockWidgetStateDefinition.f133930a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(final Context context, final QuickBlockWidget quickBlockWidget, Composer composer, int i3) {
        final WidgetDataProvider widgetDataProviderA;
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(336124186, i3, -1, "cz.mobilesoft.widgets.quickblock.QuickBlockWidget.provideGlance.<anonymous> (QuickBlockWidget.kt:56)");
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
            GlanceThemeKt.a(AppBlockWidgetsColorScheme.f134214a.a(widgetDataProviderA), ComposableLambdaKt.b(composer, 183554129, true, new Function2() { // from class: cz.mobilesoft.widgets.quickblock.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockWidget.C(widgetDataProviderA, context, quickBlockWidget, appBlockWidgetState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }), composer, ColorProviders.A | 48, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(final WidgetDataProvider widgetDataProvider, final Context context, final QuickBlockWidget quickBlockWidget, final AppBlockWidgetState appBlockWidgetState, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(183554129, i3, -1, "cz.mobilesoft.widgets.quickblock.QuickBlockWidget.provideGlance.<anonymous>.<anonymous> (QuickBlockWidget.kt:62)");
            }
            final long jM = ((DpSize) composer.q(CompositionLocalsKt.d())).m();
            BoxKt.a(ActionKt.a(SizeModifiersKt.b(RoundedCornersKt.c(GlanceModifier.f37605a, false, composer, 54, 0)), StartActivityIntentActionKt.b(widgetDataProvider.f(context), null, 2, null)), null, ComposableLambdaKt.b(composer, 1298847151, true, new Function2() { // from class: cz.mobilesoft.widgets.quickblock.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockWidget.D(jM, quickBlockWidget, appBlockWidgetState, widgetDataProvider, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }), composer, 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(long j3, QuickBlockWidget quickBlockWidget, AppBlockWidgetState appBlockWidgetState, WidgetDataProvider widgetDataProvider, Context context, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1298847151, i3, -1, "cz.mobilesoft.widgets.quickblock.QuickBlockWidget.provideGlance.<anonymous>.<anonymous>.<anonymous> (QuickBlockWidget.kt:70)");
            }
            if (Dp.f(DpSize.j(j3), DpSize.j(f134077k)) < 0) {
                composer.F(595164834);
                quickBlockWidget.y(appBlockWidgetState, widgetDataProvider, context, composer, 0);
                composer.Y();
            } else {
                composer.F(595409858);
                quickBlockWidget.u(appBlockWidgetState, widgetDataProvider, context, composer, 0);
                composer.Y();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    private final void u(final AppBlockWidgetState appBlockWidgetState, final WidgetDataProvider widgetDataProvider, final Context context, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1928822322);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(appBlockWidgetState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            int i5 = i3 & 64;
            i4 |= composerK.Z(widgetDataProvider) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(context) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1928822322, i4, -1, "cz.mobilesoft.widgets.quickblock.QuickBlockWidget.RootComposeLarge (QuickBlockWidget.kt:115)");
            }
            GlanceModifier glanceModifierB = PaddingKt.b(SizeModifiersKt.b(GlanceModifier.f37605a), Dp.g(16));
            Alignment.Companion companion = Alignment.f39415c;
            Alignment alignmentA = companion.a();
            ComposableLambda composableLambdaB = ComposableLambdaKt.b(composerK, 1032230956, true, new Function2() { // from class: cz.mobilesoft.widgets.quickblock.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockWidget.v(appBlockWidgetState, widgetDataProvider, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
            int i6 = Alignment.f39416d;
            BoxKt.a(glanceModifierB, alignmentA, composableLambdaB, composerK, (i6 << 3) | 384, 0);
            int i7 = i4;
            int i8 = i7 << 3;
            int i9 = i8 & 896;
            AppBlockWidgetViewsKt.i1(appBlockWidgetState.f(), false, widgetDataProvider, appBlockWidgetState.f() instanceof AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro ? WidgetDataProvider.WidgetString.Pomodoro.f134055a : WidgetDataProvider.WidgetString.QuickBlockName.f134061a, context, composerK, i9 | 48 | ((i7 << 6) & 57344), 0);
            composerK = composerK;
            AppBlockWidgetViewsKt.b0(companion.h(), appBlockWidgetState.f(), widgetDataProvider, context, composerK, i6 | i9 | (i8 & 7168), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.quickblock.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockWidget.x(this.f134114a, appBlockWidgetState, widgetDataProvider, context, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(final AppBlockWidgetState appBlockWidgetState, final WidgetDataProvider widgetDataProvider, final Context context, Composer composer, int i3) {
        if ((i3 & 3) == 2 && composer.l()) {
            composer.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1032230956, i3, -1, "cz.mobilesoft.widgets.quickblock.QuickBlockWidget.RootComposeLarge.<anonymous> (QuickBlockWidget.kt:124)");
            }
            if (appBlockWidgetState.f().e()) {
                composer.F(-773329311);
                RowKt.a(SizeModifiersKt.d(GlanceModifier.f37605a, Dp.g(32)), 0, Alignment.f39415c.e(), ComposableLambdaKt.b(composer, -89890611, true, new Function3() { // from class: cz.mobilesoft.widgets.quickblock.g
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return QuickBlockWidget.w(appBlockWidgetState, widgetDataProvider, context, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }), composer, 3072, 2);
                composer.Y();
            } else if (appBlockWidgetState.h()) {
                composer.F(-771967326);
                AppBlockWidgetViewsKt.D0(widgetDataProvider, context, appBlockWidgetState.f(), composer, 0);
                composer.Y();
            } else {
                composer.F(-771750884);
                AppBlockWidgetViewsKt.x0(context, appBlockWidgetState.f(), widgetDataProvider, composer, 0);
                composer.Y();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(AppBlockWidgetState appBlockWidgetState, WidgetDataProvider widgetDataProvider, Context context, RowScope Row, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(Row, "$this$Row");
        if (ComposerKt.M()) {
            ComposerKt.U(-89890611, i3, -1, "cz.mobilesoft.widgets.quickblock.QuickBlockWidget.RootComposeLarge.<anonymous>.<anonymous> (QuickBlockWidget.kt:130)");
        }
        composer.F(-485515000);
        ImageKt.a(ImageKt.b(appBlockWidgetState.f().d() == null ? widgetDataProvider.l(WidgetDataProvider.WidgetIcon.f134029b) : (!(appBlockWidgetState.f() instanceof AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro) || ((AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro) appBlockWidgetState.f()).j().c()) ? widgetDataProvider.l(WidgetDataProvider.WidgetIcon.f134034h) : widgetDataProvider.l(WidgetDataProvider.WidgetIcon.f134035i)), null, PaddingKt.f(SizeModifiersKt.d(GlanceModifier.f37605a, Dp.g(32)), 0.0f, 0.0f, Dp.g(12), 0.0f, 11, null), 0, null, composer, 48, 24);
        composer.Y();
        AppBlockWidgetViewsKt.k0(appBlockWidgetState.f(), widgetDataProvider, context, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(QuickBlockWidget quickBlockWidget, AppBlockWidgetState appBlockWidgetState, WidgetDataProvider widgetDataProvider, Context context, int i3, Composer composer, int i4) {
        quickBlockWidget.u(appBlockWidgetState, widgetDataProvider, context, composer, i3 | 1);
        return Unit.f139807a;
    }

    private final void y(final AppBlockWidgetState appBlockWidgetState, final WidgetDataProvider widgetDataProvider, final Context context, Composer composer, final int i3) {
        int i4;
        Context context2;
        Composer composerK = composer.k(-864309886);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(appBlockWidgetState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            int i5 = i3 & 64;
            i4 |= composerK.Z(widgetDataProvider) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            context2 = context;
            i4 |= composerK.Z(context) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            context2 = context;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-864309886, i4, -1, "cz.mobilesoft.widgets.quickblock.QuickBlockWidget.RootComposeSmall (QuickBlockWidget.kt:93)");
            }
            int i6 = i4 << 3;
            int i7 = i6 & 896;
            AppBlockWidgetViewsKt.i1(appBlockWidgetState.f(), true, widgetDataProvider, appBlockWidgetState.f() instanceof AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro ? WidgetDataProvider.WidgetString.Pomodoro.f134055a : WidgetDataProvider.WidgetString.QuickBlockName.f134061a, context2, composerK, i7 | 48 | ((i4 << 6) & 57344), 0);
            composerK = composerK;
            AppBlockWidgetViewsKt.Y(Alignment.f39415c.a(), appBlockWidgetState.f(), widgetDataProvider, context, composerK, Alignment.f39416d | i7 | (i6 & 7168), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.widgets.quickblock.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockWidget.z(this.f134106a, appBlockWidgetState, widgetDataProvider, context, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(QuickBlockWidget quickBlockWidget, AppBlockWidgetState appBlockWidgetState, WidgetDataProvider widgetDataProvider, Context context, int i3, Composer composer, int i4) {
        quickBlockWidget.y(appBlockWidgetState, widgetDataProvider, context, composer, i3 | 1);
        return Unit.f139807a;
    }

    @Override // androidx.glance.appwidget.GlanceAppWidget
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public SizeMode.Responsive c() {
        return this.f134078f;
    }

    @Override // androidx.glance.appwidget.GlanceAppWidget
    public GlanceStateDefinition d() {
        return this.f134079g;
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
            boolean r0 = r7 instanceof cz.mobilesoft.widgets.quickblock.QuickBlockWidget$provideGlance$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.widgets.quickblock.QuickBlockWidget$provideGlance$1 r0 = (cz.mobilesoft.widgets.quickblock.QuickBlockWidget$provideGlance$1) r0
            int r1 = r0.f134084f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f134084f = r1
            goto L18
        L13:
            cz.mobilesoft.widgets.quickblock.QuickBlockWidget$provideGlance$1 r0 = new cz.mobilesoft.widgets.quickblock.QuickBlockWidget$provideGlance$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f134082c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f134084f
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            java.lang.Object r5 = r0.f134081b
            androidx.glance.GlanceId r5 = (androidx.glance.GlanceId) r5
            java.lang.Object r5 = r0.f134080a
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.b(r7)
            goto L5d
        L39:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.widgets.quickblock.a r7 = new cz.mobilesoft.widgets.quickblock.a
            r7.<init>()
            r2 = 336124186(0x1408d91a, float:6.909061E-27)
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.c(r2, r3, r7)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f134080a = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f134081b = r5
            r0.f134084f = r3
            java.lang.Object r5 = androidx.glance.appwidget.GlanceAppWidgetKt.a(r4, r7, r0)
            if (r5 != r1) goto L5d
            return r1
        L5d:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.widgets.quickblock.QuickBlockWidget.g(android.content.Context, androidx.glance.GlanceId, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
