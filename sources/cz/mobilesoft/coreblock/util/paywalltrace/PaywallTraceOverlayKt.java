package cz.mobilesoft.coreblock.util.paywalltrace;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTrace;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTraceOverlayKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class PaywallTraceOverlayKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f128980a = new SimpleDateFormat("HH:mm:ss", Locale.US);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Boolean bool, int i3, Composer composer, int i4) {
        z(bool, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void B(final Map map, Composer composer, final int i3) {
        Composer composerK = composer.k(-2136276060);
        int i4 = (i3 & 6) == 0 ? (composerK.I(map) ? 4 : 2) | i3 : i3;
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2136276060, i4, -1, "cz.mobilesoft.coreblock.util.paywalltrace.ConfigSection (PaywallTraceOverlay.kt:384)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierM = PaddingKt.m(companion2, 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion3.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 1;
            BoxKt.a(SizeKt.x(BackgroundKt.c(PaddingKt.m(SizeKt.h(companion2, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.g(6), 7, null), ComposeColorsKt.j(composerK, 0).u(), RoundedCornerShapeKt.d(Dp.g(f3))), Dp.g(0), Dp.g(f3)), composerK, 0);
            String str = C(mutableState) ? "skrýt config" : "config (" + map.size() + ")";
            TextStyle textStyleD = ComposeTypographyKt.g(composerK, 0).d();
            long jI = TextUnitKt.i(11);
            FontWeight fontWeightB = FontWeight.f29233b.b();
            long jB = ComposeColorsKt.j(composerK, 0).b();
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: i2.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallTraceOverlayKt.E(mutableState);
                    }
                };
                composerK.w(objG2);
            }
            TextKt.c(str, PaddingKt.k(ClickableKt.f(companion2, false, null, null, (Function0) objG2, 7, null), 0.0f, Dp.g(2), 1, null), jB, jI, null, fontWeightB, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleD, composerK, 199680, 0, 65488);
            composerK = composerK;
            if (C(mutableState)) {
                composerK.a0(945033274);
                Modifier modifierM2 = PaddingKt.m(companion2, 0.0f, Dp.g(4), 0.0f, 0.0f, 13, null);
                MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.o(Dp.g(f3)), companion3.k(), composerK, 6);
                int i5 = 0;
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM2);
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
                composerK.a0(-688159133);
                for (Map.Entry entry : CollectionsKt.sortedWith(map.entrySet(), new Comparator() { // from class: cz.mobilesoft.coreblock.util.paywalltrace.PaywallTraceOverlayKt$ConfigSection$lambda$3$1$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ComparisonsKt.d((String) ((Map.Entry) obj).getKey(), (String) ((Map.Entry) obj2).getKey());
                    }
                })) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    if (StringsKt.p0(str3)) {
                        str3 = "<empty>";
                    }
                    Composer composer2 = composerK;
                    TextKt.c(str2 + " = " + ((Object) str3), null, ComposeColorsKt.j(composerK, i5).q(), TextUnitKt.i(10), null, null, FontFamily.f29155b.c(), 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, i5).d(), composer2, 3072, 0, 65458);
                    composerK = composer2;
                    i5 = i5;
                }
                composerK.U();
                composerK.y();
            } else {
                composerK.a0(929014644);
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
            scopeUpdateScopeN.a(new Function2() { // from class: i2.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.F(map, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean C(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void D(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(MutableState mutableState) {
        D(mutableState, !C(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Map map, int i3, Composer composer, int i4) {
        B(map, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void G(final String str, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(1025207636);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(str) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1025207636, i5, -1, "cz.mobilesoft.coreblock.util.paywalltrace.PanelAction (PaywallTraceOverlay.kt:186)");
            }
            composer2 = composerK;
            TextKt.c(str, PaddingKt.j(ClickableKt.f(Modifier.b8, false, null, null, function0, 7, null), Dp.g(8), Dp.g(6)), ComposeColorsKt.j(composerK, 0).b(), 0L, null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, (i5 & 14) | 196608, 0, 65496);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i2.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.H(str, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(String str, Function0 function0, int i3, Composer composer, int i4) {
        G(str, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void I(Modifier modifier, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Composer composerK = composer.k(-1450682083);
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
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1450682083, i5, -1, "cz.mobilesoft.coreblock.util.paywalltrace.PaywallTraceOverlay (PaywallTraceOverlay.kt:68)");
            }
            if (BuildConfig.f95357b.booleanValue()) {
                final State stateB = SnapshotStateKt.b(PaywallTraceStore.f128981a.b(), null, composerK, 0, 1);
                if (K(stateB).isEmpty()) {
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    scopeUpdateScopeN = composerK.n();
                    if (scopeUpdateScopeN == null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: i2.s
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PaywallTraceOverlayKt.L(modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                } else {
                    Object objG = composerK.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG == companion.a()) {
                        objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                        composerK.w(objG);
                    }
                    final MutableState mutableState = (MutableState) objG;
                    boolean Z = composerK.Z(K(stateB));
                    Object objG2 = composerK.G();
                    if (Z || objG2 == companion.a()) {
                        objG2 = PaywallTraceKt.b(K(stateB));
                        composerK.w(objG2);
                    }
                    final List list = (List) objG2;
                    float f3 = 8;
                    Modifier modifierM = PaddingKt.m(WindowInsetsPadding_androidKt.c(modifier3), 0.0f, Dp.g(f3), Dp.g(f3), 0.0f, 9, null);
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
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
                    Updater.e(composerA, measurePolicyG, companion2.e());
                    Updater.e(composerA, compositionLocalMapU, companion2.g());
                    Function2 function2B = companion2.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion2.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    TraceGroup traceGroup = (TraceGroup) CollectionsKt.first(list);
                    Object objG3 = composerK.G();
                    if (objG3 == companion.a()) {
                        objG3 = new Function0() { // from class: i2.y
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PaywallTraceOverlayKt.O(mutableState);
                            }
                        };
                        composerK.w(objG3);
                    }
                    e0(traceGroup, (Function0) objG3, composerK, 48);
                    if (M(mutableState)) {
                        composerK.a0(-838033903);
                        Object objG4 = composerK.G();
                        if (objG4 == companion.a()) {
                            objG4 = new Function0() { // from class: i2.z
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return PaywallTraceOverlayKt.P(mutableState);
                                }
                            };
                            composerK.w(objG4);
                        }
                        AndroidPopup_androidKt.c(null, 0L, (Function0) objG4, new PopupProperties(true, false, false, false, 14, (DefaultConstructorMarker) null), ComposableLambdaKt.e(2073039355, true, new Function2() { // from class: i2.a0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return PaywallTraceOverlayKt.Q(list, stateB, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerK, 54), composerK, 28032, 3);
                    } else {
                        composerK.a0(-842509249);
                    }
                    composerK.U();
                    composerK.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            } else {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: i2.h
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PaywallTraceOverlayKt.J(modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            }
            scopeUpdateScopeN.a(function2);
        }
        composerK.Q();
        modifier3 = modifier2;
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: i2.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.U(modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        I(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final List K(State state) {
        return (List) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        I(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final boolean M(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void N(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(MutableState mutableState) {
        N(mutableState, true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(MutableState mutableState) {
        N(mutableState, false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(List list, final State state, final MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2073039355, i3, -1, "cz.mobilesoft.coreblock.util.paywalltrace.PaywallTraceOverlay.<anonymous>.<anonymous> (PaywallTraceOverlay.kt:94)");
            }
            boolean Z = composer.Z(state);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: i2.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallTraceOverlayKt.R(state);
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: i2.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallTraceOverlayKt.T(mutableState);
                    }
                };
                composer.w(objG2);
            }
            h0(list, function0, (Function0) objG2, composer, 384);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String R(State state) {
        return CollectionsKt.joinToString$default(K(state), "\n", null, null, 0, null, new Function1() { // from class: i2.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PaywallTraceOverlayKt.S((PaywallTrace) obj);
            }
        }, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence S(PaywallTrace trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        return trace.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(MutableState mutableState) {
        N(mutableState, false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        I(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void V(final String str, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-940381221);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(str) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-940381221, i4, -1, "cz.mobilesoft.coreblock.util.paywalltrace.Pill (PaywallTraceOverlay.kt:260)");
            }
            composer2 = composerK;
            TextKt.c(str, PaddingKt.j(BackgroundKt.c(Modifier.b8, Color.r(ComposeColorsKt.j(composerK, 0).b(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.d(Dp.g(4))), Dp.g(5), Dp.g(1)), ComposeColorsKt.j(composerK, 0).b(), TextUnitKt.i(10), null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, (i4 & 14) | 199680, 0, 65488);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i2.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.W(str, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(String str, int i3, Composer composer, int i4) {
        V(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void X(final TraceGroup traceGroup, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(205245667);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(traceGroup) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(205245667, i4, -1, "cz.mobilesoft.coreblock.util.paywalltrace.PresentationCard (PaywallTraceOverlay.kt:204)");
            }
            SurfaceKt.a(null, RoundedCornerShapeKt.d(Dp.g(10)), ComposeColorsKt.j(composerK, 0).v(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.e(623268520, true, new Function2() { // from class: i2.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.Y(traceGroup, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 12582912, 121);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i2.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.Z(traceGroup, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(TraceGroup traceGroup, Composer composer, int i3) {
        Object next;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(623268520, i3, -1, "cz.mobilesoft.coreblock.util.paywalltrace.PresentationCard.<anonymous> (PaywallTraceOverlay.kt:209)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 10;
            Modifier modifierJ = PaddingKt.j(companion, Dp.g(12), Dp.g(f3));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            a0(traceGroup, composer, 0);
            Modifier modifierM = PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.o(Dp.g(f3)), companion2.k(), composer, 6);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierM);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            composer.a0(1613582521);
            Iterator it = traceGroup.c().iterator();
            while (it.hasNext()) {
                l0((CollapsedTrace) it.next(), composer, 0);
            }
            composer.U();
            composer.y();
            Iterator it2 = traceGroup.c().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (!((CollapsedTrace) next).d().c().isEmpty()) {
                    break;
                }
            }
            CollapsedTrace collapsedTrace = (CollapsedTrace) next;
            if (collapsedTrace == null) {
                composer.a0(120168757);
            } else {
                composer.a0(120168758);
                B(collapsedTrace.d().c(), composer, 0);
            }
            composer.U();
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
    public static final Unit Z(TraceGroup traceGroup, int i3, Composer composer, int i4) {
        X(traceGroup, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void a0(final TraceGroup traceGroup, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        String strD;
        String str;
        Composer composerK = composer.k(1318330400);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(traceGroup) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1318330400, i4, -1, "cz.mobilesoft.coreblock.util.paywalltrace.PresentationHeader (PaywallTraceOverlay.kt:229)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Modifier.Companion companion2 = Modifier.b8;
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composerK, 48);
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
            z(traceGroup.a(), composerK, 0);
            Modifier modifierC = RowScope.c(rowScopeInstance, PaddingKt.m(companion2, Dp.g(8), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion.k(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierC);
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
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion.i(), composerK, 48);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, companion2);
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
            Updater.e(composerA3, measurePolicyB2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            if (traceGroup.g()) {
                strD = "Background";
            } else {
                strD = traceGroup.d();
                if (strD == null) {
                    strD = "no placement";
                }
            }
            TextKt.c(strD, null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).m(), composerK, 196608, 0, 65498);
            String strB = traceGroup.b();
            if (strB == null) {
                composerK.a0(32167082);
            } else {
                composerK.a0(32167083);
                Modifier modifierM = PaddingKt.m(companion2, Dp.g(6), 0.0f, 0.0f, 0.0f, 14, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
                int iA4 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU4 = composerK.u();
                Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierM);
                Function0 function0A4 = companion3.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A4);
                } else {
                    composerK.v();
                }
                Composer composerA4 = Updater.a(composerK);
                Updater.e(composerA4, measurePolicyG, companion3.e());
                Updater.e(composerA4, compositionLocalMapU4, companion3.g());
                Function2 function2B4 = companion3.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF4, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                V(strB, composerK, 0);
                composerK.y();
                Unit unit = Unit.f139807a;
            }
            composerK.U();
            composerK.y();
            if (traceGroup.g()) {
                str = "mimo zobrazení paywallu";
            } else {
                str = "#" + traceGroup.e() + " · " + f128980a.format(new Date(traceGroup.f()));
            }
            composer2 = composerK;
            TextKt.c(str, null, ComposeColorsKt.j(composerK, 0).q(), TextUnitKt.i(11), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, 3072, 0, 65522);
            composer2.y();
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
            scopeUpdateScopeN.a(new Function2() { // from class: i2.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.b0(traceGroup, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(TraceGroup traceGroup, int i3, Composer composer, int i4) {
        a0(traceGroup, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void c0(final RuleOutcome ruleOutcome, final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        long jQ;
        Composer composerK = composer.k(-1181748699);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(ruleOutcome) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1181748699, i4, -1, "cz.mobilesoft.coreblock.util.paywalltrace.RuleLine (PaywallTraceOverlay.kt:357)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composerK, 0);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            String str = z2 ? "→" : "";
            TextStyle textStyleD = ComposeTypographyKt.g(composerK, 0).d();
            long jI = TextUnitKt.i(11);
            FontFamily.Companion companion3 = FontFamily.f29155b;
            TextKt.c(str, SizeKt.C(companion, Dp.g(14), 0.0f, 2, null), ComposeColorsKt.j(composerK, 0).b(), jI, null, null, companion3.c(), 0L, null, null, 0L, 0, false, 0, 0, null, textStyleD, composerK, 3120, 0, 65456);
            String str2 = ruleOutcome.e() + " = " + ruleOutcome.d();
            TextStyle textStyleD2 = ComposeTypographyKt.g(composerK, 0).d();
            long jI2 = TextUnitKt.i(11);
            GenericFontFamily genericFontFamilyC = companion3.c();
            FontWeight.Companion companion4 = FontWeight.f29233b;
            FontWeight fontWeightB = z2 ? companion4.b() : companion4.g();
            if (z2) {
                composerK.a0(1274842127);
                jQ = ComposeColorsKt.j(composerK, 0).b();
            } else {
                composerK.a0(1274842742);
                jQ = ComposeColorsKt.j(composerK, 0).q();
            }
            composerK.U();
            composer2 = composerK;
            TextKt.c(str2, null, jQ, jI2, null, fontWeightB, genericFontFamilyC, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleD2, composer2, 3072, 0, 65426);
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
            scopeUpdateScopeN.a(new Function2() { // from class: i2.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.d0(ruleOutcome, z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(RuleOutcome ruleOutcome, boolean z2, int i3, Composer composer, int i4) {
        c0(ruleOutcome, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void e0(final TraceGroup traceGroup, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(359099938);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(traceGroup) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(359099938, i4, -1, "cz.mobilesoft.coreblock.util.paywalltrace.TraceChip (PaywallTraceOverlay.kt:110)");
            }
            composer2 = composerK;
            SurfaceKt.a(ClickableKt.f(Modifier.b8, false, null, null, function0, 7, null), RoundedCornerShapeKt.d(Dp.g(7)), Color.r(ComposeColorsKt.j(composerK, 0).n(), 0.85f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.e(-1727244739, true, new Function2() { // from class: i2.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.f0(traceGroup, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composer2, 12582912, 120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i2.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.g0(traceGroup, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(TraceGroup traceGroup, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1727244739, i3, -1, "cz.mobilesoft.coreblock.util.paywalltrace.TraceChip.<anonymous> (PaywallTraceOverlay.kt:116)");
            }
            Modifier modifierJ = PaddingKt.j(Modifier.b8, Dp.g(9), Dp.g(5));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(6)), Alignment.f25072a.i(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            z(traceGroup.a(), composer, 0);
            String strB = traceGroup.b();
            if (strB == null && (strB = traceGroup.d()) == null) {
                strB = ((CollapsedTrace) CollectionsKt.first(traceGroup.c())).d().j().getLabel();
            }
            TextKt.c(strB, null, ComposeColorsKt.j(composer, 0).q0(), 0L, null, FontWeight.f29233b.h(), null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 196608, 0, 65498);
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
    public static final Unit g0(TraceGroup traceGroup, Function0 function0, int i3, Composer composer, int i4) {
        e0(traceGroup, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(final List list, final Function0 function0, final Function0 function02, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1968387548);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(list) ? 4 : 2) | i3;
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
                ComposerKt.U(1968387548, i4, -1, "cz.mobilesoft.coreblock.util.paywalltrace.TracePanel (PaywallTraceOverlay.kt:139)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            SurfaceKt.a(SizeKt.C(PaddingKt.i(Modifier.b8, Dp.g(12)), 0.0f, Dp.g(420), 1, null), RoundedCornerShapeKt.d(Dp.g(14)), ComposeColorsKt.j(composerK, 0).l0(), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.e(-1433262431, true, new Function2() { // from class: i2.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.i0(context, function0, function02, list, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 12582918, 120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i2.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.k0(list, function0, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(final Context context, final Function0 function0, Function0 function02, List list, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1433262431, i3, -1, "cz.mobilesoft.coreblock.util.paywalltrace.TracePanel.<anonymous> (PaywallTraceOverlay.kt:149)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 12;
            Modifier modifierJ = PaddingKt.j(companion, Dp.g(f3), Dp.g(f3));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            Alignment.Vertical verticalI = companion2.i();
            Modifier modifierM = PaddingKt.m(companion, Dp.g(4), 0.0f, 0.0f, Dp.g(10), 6, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierM);
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
            TextKt.c("Paywall trace", RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).j(), composer, 6, 0, 65528);
            boolean zI = composer.I(context) | composer.Z(function0);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: i2.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PaywallTraceOverlayKt.j0(context, function0);
                    }
                };
                composer.w(objG);
            }
            G("COPY", (Function0) objG, composer, 6);
            IconButtonKt.e(function02, SizeKt.v(companion, Dp.g(28)), false, null, null, ComposableSingletons$PaywallTraceOverlayKt.f128965a.e(), composer, 196656, 28);
            composer.y();
            Modifier modifierG = ScrollKt.g(SizeKt.k(companion, 0.0f, Dp.g(460), 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.o(Dp.g(8)), companion2.k(), composer, 6);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierG);
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
            Updater.e(composerA3, modifierF3, companion3.f());
            composer.a0(-715694695);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                X((TraceGroup) it.next(), composer, 0);
            }
            composer.U();
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
    public static final Unit k0(List list, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        h0(list, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void l0(final CollapsedTrace collapsedTrace, Composer composer, final int i3) {
        Object next;
        Modifier.Companion companion;
        int i4;
        int i5;
        int i6;
        ArrayList arrayList;
        Composer composerK = composer.k(328363770);
        int i7 = (i3 & 6) == 0 ? (composerK.I(collapsedTrace) ? 4 : 2) | i3 : i3;
        if (composerK.r((i7 & 3) != 2, i7 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(328363770, i7, -1, "cz.mobilesoft.coreblock.util.paywalltrace.TraceStep (PaywallTraceOverlay.kt:283)");
            }
            PaywallTrace paywallTraceD = collapsedTrace.d();
            boolean Z = composerK.Z(paywallTraceD);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            List listI = paywallTraceD.i();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listI) {
                if (((RuleOutcome) obj).c()) {
                    arrayList2.add(obj);
                }
            }
            List listI2 = paywallTraceD.i();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : listI2) {
                if (!((RuleOutcome) obj2).c()) {
                    arrayList3.add(obj2);
                }
            }
            Iterator it = paywallTraceD.i().iterator();
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    if (Intrinsics.areEqual(((RuleOutcome) next).e(), "requested from")) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            RuleOutcome ruleOutcome = (RuleOutcome) next;
            String strD = ruleOutcome != null ? ruleOutcome.d() : null;
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(3));
            Modifier.Companion companion2 = Modifier.b8;
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion3.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion3.i(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion2);
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
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            String upperCase = paywallTraceD.j().getLabel().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextStyle textStyleD = ComposeTypographyKt.g(composerK, 0).d();
            long jI = TextUnitKt.i(10);
            FontWeight.Companion companion5 = FontWeight.f29233b;
            String str = strD;
            TextKt.c(upperCase, rowScopeInstance.a(companion2, 1.0f, false), ComposeColorsKt.j(composerK, 0).q(), jI, null, companion5.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleD, composerK, 199680, 0, 65488);
            if (collapsedTrace.c() > 1) {
                composerK.a0(1093444834);
                i4 = 6;
                companion = companion2;
                Modifier modifierM = PaddingKt.m(companion, Dp.g(6), 0.0f, 0.0f, 0.0f, 14, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierM);
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
                Updater.e(composerA3, measurePolicyG, companion4.e());
                Updater.e(composerA3, compositionLocalMapU3, companion4.g());
                Function2 function2B3 = companion4.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion4.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                V("×" + collapsedTrace.c(), composerK, 0);
                composerK.y();
            } else {
                companion = companion2;
                i4 = 6;
                composerK.a0(1081385710);
            }
            composerK.U();
            if (str != null) {
                composerK.a0(1093828335);
                Modifier modifierM2 = PaddingKt.m(companion, Dp.g(i4), 0.0f, 0.0f, 0.0f, 14, null);
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
                int iA4 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU4 = composerK.u();
                Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierM2);
                Function0 function0A4 = companion4.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A4);
                } else {
                    composerK.v();
                }
                Composer composerA4 = Updater.a(composerK);
                Updater.e(composerA4, measurePolicyG2, companion4.e());
                Updater.e(composerA4, compositionLocalMapU4, companion4.g());
                Function2 function2B4 = companion4.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF4, companion4.f());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                i5 = 0;
                V(str, composerK, 0);
                composerK.y();
            } else {
                i5 = 0;
                composerK.a0(1081385710);
            }
            composerK.U();
            composerK.y();
            TextKt.c(paywallTraceD.k(), null, ComposeColorsKt.j(composerK, i5).p(), 0L, null, companion5.h(), null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, i5).b(), composerK, 196608, 0, 65498);
            composerK = composerK;
            composerK.a0(-1325180123);
            int size = arrayList2.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj3 = arrayList2.get(i8);
                i8++;
                c0((RuleOutcome) obj3, true, composerK, 48);
            }
            composerK.U();
            if (arrayList3.isEmpty()) {
                i6 = 1856326418;
                composerK.a0(1856326418);
            } else {
                composerK.a0(1869191604);
                if (m0(mutableState)) {
                    composerK.a0(1869202423);
                    int size2 = arrayList3.size();
                    int i9 = 0;
                    while (i9 < size2) {
                        Object obj4 = arrayList3.get(i9);
                        i9++;
                        c0((RuleOutcome) obj4, false, composerK, 48);
                    }
                    arrayList = arrayList3;
                } else {
                    arrayList = arrayList3;
                    composerK.a0(1856326418);
                }
                composerK.U();
                String str2 = m0(mutableState) ? "skrýt kroky" : "+ " + arrayList.size() + " " + r0(arrayList.size());
                TextStyle textStyleD2 = ComposeTypographyKt.g(composerK, 0).d();
                long jI2 = TextUnitKt.i(11);
                FontWeight fontWeightB = FontWeight.f29233b.b();
                long jB = ComposeColorsKt.j(composerK, 0).b();
                Modifier.Companion companion6 = Modifier.b8;
                boolean Z2 = composerK.Z(mutableState);
                Object objG2 = composerK.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: i2.u
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PaywallTraceOverlayKt.o0(mutableState);
                        }
                    };
                    composerK.w(objG2);
                }
                float f3 = 2;
                String str3 = str2;
                i6 = 1856326418;
                TextKt.c(str3, PaddingKt.m(ClickableKt.f(companion6, false, null, null, (Function0) objG2, 7, null), 0.0f, Dp.g(f3), 0.0f, Dp.g(f3), 5, null), jB, jI2, null, fontWeightB, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleD2, composerK, 199680, 0, 65488);
                composerK = composerK;
            }
            composerK.U();
            if (paywallTraceD.e().isEmpty()) {
                composerK.a0(i6);
            } else {
                composerK.a0(1869843782);
                Composer composer2 = composerK;
                TextKt.c("entitlements: " + CollectionsKt.joinToString$default(CollectionsKt.sorted(paywallTraceD.e()), null, null, null, 0, null, null, 63, null), null, ComposeColorsKt.j(composerK, 0).q(), TextUnitKt.i(11), null, null, FontFamily.f29155b.c(), 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, 3072, 0, 65458);
                composerK = composer2;
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
            scopeUpdateScopeN.a(new Function2() { // from class: i2.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    return PaywallTraceOverlayKt.p0(collapsedTrace, i3, (Composer) obj5, ((Integer) obj6).intValue());
                }
            });
        }
    }

    private static final boolean m0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void n0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(MutableState mutableState) {
        n0(mutableState, !m0(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(CollapsedTrace collapsedTrace, int i3, Composer composer, int i4) {
        l0(collapsedTrace, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final String r0(int i3) {
        return i3 == 1 ? "krok" : (2 > i3 || i3 >= 5) ? "kroků" : "kroky";
    }

    private static final void z(final Boolean bool, Composer composer, final int i3) {
        int i4;
        long jS;
        Composer composerK = composer.k(1413012821);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(bool) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1413012821, i4, -1, "cz.mobilesoft.coreblock.util.paywalltrace.AttributionDot (PaywallTraceOverlay.kt:430)");
            }
            Modifier modifierV = SizeKt.v(Modifier.b8, Dp.g(8));
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                composerK.a0(695663514);
                jS = ComposeColorsKt.j(composerK, 0).A();
                composerK.U();
            } else if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
                composerK.a0(695665240);
                jS = ComposeColorsKt.j(composerK, 0).c0();
                composerK.U();
            } else {
                if (bool != null) {
                    composerK.a0(695661580);
                    composerK.U();
                    throw new NoWhenBranchMatchedException();
                }
                composerK.a0(695666882);
                jS = ComposeColorsKt.j(composerK, 0).s();
                composerK.U();
            }
            BoxKt.a(BackgroundKt.c(modifierV, jS, RoundedCornerShapeKt.d(Dp.g(4))), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: i2.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PaywallTraceOverlayKt.A(bool, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(Context context, Function0 function0) {
        ContextExtKt.a(context, wgbAZXYjrv.fnNBcYTjuLOHrNm, (String) function0.invoke());
        return Unit.f139807a;
    }
}
