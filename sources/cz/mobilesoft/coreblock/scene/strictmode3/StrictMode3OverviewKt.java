package cz.mobilesoft.coreblock.scene.strictmode3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Window;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipKt;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeButtonState;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.dashboard.card.PermissionsCardKt;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorFeedbackActivity;
import cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlinx.collections.immutable.ImmutableList;
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
public final class StrictMode3OverviewKt {
    /* JADX WARN: Removed duplicated region for block: B:183:0x078d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0798  */
    /* JADX WARN: Removed duplicated region for block: B:190:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void A0(final cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState r70, final kotlin.jvm.functions.Function1 r71, boolean r72, kotlin.jvm.functions.Function0 r73, androidx.compose.runtime.Composer r74, final int r75, final int r76) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1957
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3OverviewKt.A0(cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Context context) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.STRICT_MODE_TIMER), "strict_mode_running", "unlimited_strict_mode", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(String str, Dp dp, Composer composer, int i3) {
        int i4;
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.c(dp.l()) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-584692595, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.Header.<anonymous>.<anonymous>.<anonymous> (StrictMode3Overview.kt:606)");
            }
            TextKt.c(StringHelperExtKt.p(StringResources_androidKt.b(R.string.ye, composer, 0), str, " "), SizeKt.A(PaddingKt.m(Modifier.b8, Dp.g(4), 0.0f, Dp.g(8), 0.0f, 10, null), dp.l()), ComposeColorsKt.j(composer, 0).Y(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composer, 0).j()), composer, 0, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier D0(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return SizeKt.f(applyIf, 0.0f, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(final Context context) {
        BackdoorCodeDialog.M(new BackdoorCodeDialog(context, null, 2, null), new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.d1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StrictMode3OverviewKt.F0(context);
            }
        }, null, 2, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(Context context) {
        context.startActivity(new Intent(context, (Class<?>) BackdoorFeedbackActivity.class));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(Function1 function1) {
        function1.invoke(StrictMode3ViewEvent.OnExtendTimerClicked.f121196a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(StrictMode3ViewState strictMode3ViewState, Function1 function1, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        A0(strictMode3ViewState, function1, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void I0(Composer composer, final int i3) {
        Composer composerK = composer.k(289032678);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(289032678, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.KeepScreenOn (StrictMode3Overview.kt:503)");
            }
            Activity activityB = ContextExtKt.b((Context) composerK.q(AndroidCompositionLocals_androidKt.g()));
            final Window window = activityB != null ? activityB.getWindow() : null;
            Unit unit = Unit.f139807a;
            boolean zI = composerK.I(window);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.b1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3OverviewKt.J0(window, (DisposableEffectScope) obj);
                    }
                };
                composerK.w(objG);
            }
            EffectsKt.c(unit, (Function1) objG, composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.c1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3OverviewKt.K0(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult J0(final Window window, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        if (window != null) {
            window.addFlags(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        }
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3OverviewKt$KeepScreenOn$lambda$0$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Window window2 = window;
                if (window2 != null) {
                    window2.clearFlags(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(int i3, Composer composer, int i4) {
        I0(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void L0(ImmutableList immutableList, boolean z2, final Function1 function1, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        final ImmutableList immutableList2;
        final boolean z3;
        Composer composerK = composer.k(1879197675);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(immutableList) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1879197675, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.PermissionsRow (StrictMode3Overview.kt:1014)");
            }
            float fG = (z2 || !immutableList.isEmpty()) ? Dp.g(16) : Dp.g(4);
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean z4 = (i4 & 896) == 256;
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.l1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3OverviewKt.M0(function1, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            Modifier modifierJ = PaddingKt.j(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), fG);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            immutableList2 = immutableList;
            z3 = z2;
            PermissionsCardKt.d(StringResources_androidKt.b(R.string.TB, composerK, 0), immutableList2, z3, managedActivityResultLauncherA, 0, null, composerK, ((i4 << 3) & 1008) | (ManagedActivityResultLauncher.f461c << 9), 48);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            immutableList2 = immutableList;
            z3 = z2;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.m1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3OverviewKt.N0(immutableList2, z3, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new StrictMode3ViewEvent.OnMissingPermissionsChanged(PermissionRequestReason.General));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(ImmutableList immutableList, boolean z2, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        L0(immutableList, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void O0(final cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState r21, androidx.compose.material.ScaffoldState r22, final kotlin.jvm.functions.Function1 r23, kotlin.jvm.functions.Function0 r24, boolean r25, final kotlin.jvm.functions.Function0 r26, kotlin.jvm.functions.Function0 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3OverviewKt.O0(cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(ScaffoldState scaffoldState, final boolean z2, final StrictMode3ViewState strictMode3ViewState, final Function1 function1, final Function0 function0, final Function0 function02, final Function0 function03, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1349425794, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3Overview.<anonymous> (StrictMode3Overview.kt:201)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.e(WindowInsets.f7172a, composer, 6)), scaffoldState, null, ComposableLambdaKt.e(-410422276, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.v1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3OverviewKt.Q0(z2, strictMode3ViewState, function1, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableSingletons$StrictMode3OverviewKt.f121092a.o(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(-1670558460, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.w1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictMode3OverviewKt.R0(z2, strictMode3ViewState, function1, function02, function03, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 27648, 12779520, 98276);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(boolean z2, StrictMode3ViewState strictMode3ViewState, Function1 function1, Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        Composer composer2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-410422276, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3Overview.<anonymous>.<anonymous> (StrictMode3Overview.kt:219)");
            }
            if (z2) {
                composer2 = composer;
                composer2.a0(871392870);
            } else {
                composer.a0(881924779);
                composer2 = composer;
                l0(strictMode3ViewState.g(), function1, strictMode3ViewState, function0, composer2, 0);
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
    public static final Unit R0(boolean z2, final StrictMode3ViewState strictMode3ViewState, final Function1 function1, final Function0 function0, final Function0 function02, final PaddingValues paddingValues, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1670558460, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3Overview.<anonymous>.<anonymous> (StrictMode3Overview.kt:210)");
            }
            if (z2) {
                composer.a0(-1820947590);
                ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-433746345, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.b0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return StrictMode3OverviewKt.S0(strictMode3ViewState, paddingValues, function1, function0, function02, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 12582912, 127);
                composer.U();
            } else {
                composer.a0(-1820749283);
                q0(strictMode3ViewState, paddingValues, function1, false, function0, function02, composer, ((i4 << 3) & 112) | 3072, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(StrictMode3ViewState strictMode3ViewState, PaddingValues paddingValues, Function1 function1, Function0 function0, Function0 function02, BoxScope GradientBox, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-433746345, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3Overview.<anonymous>.<anonymous>.<anonymous> (StrictMode3Overview.kt:212)");
            }
            q0(strictMode3ViewState, paddingValues, function1, true, function0, function02, composer, 3072, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(Function2 function2, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-798423994, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3Overview.<anonymous> (StrictMode3Overview.kt:228)");
            }
            function2.invoke(composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(StrictMode3ViewState strictMode3ViewState, ScaffoldState scaffoldState, Function1 function1, Function0 function0, boolean z2, Function0 function02, Function0 function03, int i3, int i4, Composer composer, int i5) {
        O0(strictMode3ViewState, scaffoldState, function1, function0, z2, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void V0(final Function1 onEvent, final Function0 onDismiss, final String str, Composer composer, final int i3, final int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(12451066);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(onEvent) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(onDismiss) ? 32 : 16;
        }
        int i6 = i4 & 4;
        if (i6 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.Z(str) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (i6 != 0) {
                str = "";
            }
            if (ComposerKt.M()) {
                ComposerKt.U(12451066, i5, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictModeApprovalSendRequestBottomSheet (StrictMode3Overview.kt:425)");
            }
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(-792304839, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.p1
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return StrictMode3OverviewKt.W0(str, onDismiss, onEvent, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54);
            boolean z2 = (i5 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.q1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3OverviewKt.Z0(onDismiss);
                    }
                };
                composerK.w(objG);
            }
            ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, (Function0) objG, composerK, 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        final String str2 = str;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.s1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3OverviewKt.a1(onEvent, onDismiss, str2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(String str, final Function0 function0, final Function1 function1, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-792304839, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictModeApprovalSendRequestBottomSheet.<anonymous> (StrictMode3Overview.kt:430)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), Dp.g(32));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composer, 0);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strB = StringResources_androidKt.b(R.string.oF, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            float f4 = 8;
            TextKt.c(strB, PaddingKt.m(columnScopeInstance.c(companion, companion2.g()), 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65016);
            float f5 = 20;
            TextKt.c(StringResources_androidKt.b(R.string.L1, composer, 0), PaddingKt.k(columnScopeInstance.c(companion, companion2.g()), Dp.g(f5), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65016);
            Composer composer2 = composer;
            if (str.length() > 0) {
                composer2.a0(1034240793);
                TextKt.c(StringResources_androidKt.c(R.string.xi, new Object[]{str}, composer2, 0), PaddingKt.m(columnScopeInstance.c(companion, companion2.g()), Dp.g(f5), Dp.g(f4), Dp.g(f5), 0.0f, 8, null), ComposeColorsKt.j(composer2, 0).s(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer, 0, 0, 65016);
                composer2 = composer;
            } else {
                composer2.a0(1014088933);
            }
            composer2.U();
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer2, 6);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.K1, composer2, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(true, null, false, null, 14, null);
            boolean Z = composer2.Z(function0) | composer2.Z(function1);
            Object objG = composer2.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3OverviewKt.X0(function0, function1);
                    }
                };
                composer2.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.O4, composer, 0), 0.0f, 11, null);
            ButtonColor.Light light = new ButtonColor.Light(false, null, false, null, null, 31, null);
            boolean Z2 = composer.Z(function0);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.k0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3OverviewKt.Y0(function0);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.i0(null, big2, light, (Function0) objG2, composer, 0, 1);
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
    public static final Unit X0(Function0 function0, Function1 function1) {
        function0.invoke();
        function1.invoke(StrictMode3ViewEvent.OnApprovalSendUnblockRequest.f121192a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(Function1 function1, Function0 function0, String str, int i3, int i4, Composer composer, int i5) {
        V0(function1, function0, str, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b0(androidx.compose.ui.Modifier r25, final java.util.List r26, long r27, kotlin.jvm.functions.Function0 r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3OverviewKt.b0(androidx.compose.ui.Modifier, java.util.List, long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(Modifier modifier, List list, long j3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        b0(modifier, list, j3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(String str, final Function1 function1, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(518949178, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictModeCooldownBottomSheet.<anonymous> (StrictMode3Overview.kt:367)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            float f4 = 32;
            Modifier modifierL = PaddingKt.l(BackgroundKt.d(SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).X(), null, 2, null), Dp.g(f3), Dp.g(24), Dp.g(f3), Dp.g(f4));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierL);
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
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composer, 0);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(R.string.i9, composer, 0), columnScopeInstance.c(companion, companion2.g()), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65528);
            TextStyle textStyleD = cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composer, 0).f());
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(str, PaddingKt.k(columnScopeInstance.c(companion, companion2.g()), 0.0f, Dp.g(8), 1, null), ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleD, composer, 0, 0, 65016);
            TextKt.c(StringResources_androidKt.b(R.string.cy, composer, 0), PaddingKt.k(columnScopeInstance.c(companion, companion2.g()), Dp.g(20), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).s(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Wx, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(true, null, false, null, 14, null);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.e1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3OverviewKt.d1(function1);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
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
    public static final int d0(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(Function1 function1) {
        function1.invoke(StrictMode3ViewEvent.OnDismissCooldownBottomSheet.f121194a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(Function1 function1) {
        function1.invoke(StrictMode3ViewEvent.OnDismissCooldownBottomSheet.f121194a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
            AnswersHelper.f128199a.U0();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(String str, Function1 function1, int i3, Composer composer, int i4) {
        b1(str, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform g0(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.f(EnterExitTransitionKt.E(AnimationSpecKt.l(1.0f, 50.0f, null, 4, null), new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.t1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(StrictMode3OverviewKt.h0(((Integer) obj).intValue()));
            }
        }), EnterExitTransitionKt.J(AnimationSpecKt.l(1.0f, 50.0f, null, 4, null), new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.u1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Integer.valueOf(StrictMode3OverviewKt.i0(((Integer) obj).intValue()));
            }
        }));
    }

    public static final void g1(final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-1083056558);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onEvent) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1083056558, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictModeResumeBottomSheet (StrictMode3Overview.kt:297)");
            }
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(-1163170607, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.l0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return StrictMode3OverviewKt.h1(onEvent, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54);
            boolean z2 = (i4 & 14) == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.m0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3OverviewKt.k1(onEvent);
                    }
                };
                composerK.w(objG);
            }
            ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, (Function0) objG, composerK, 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.n0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3OverviewKt.l1(onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h0(int i3) {
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(final Function1 function1, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1163170607, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.StrictModeResumeBottomSheet.<anonymous> (StrictMode3Overview.kt:302)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 24;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(BackgroundKt.d(SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).X(), null, 2, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), 0.0f, Dp.g(f3), 0.0f, Dp.g(32), 5, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
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
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composer, 48);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strB = StringResources_androidKt.b(R.string.Bz, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, null, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65018);
            float f4 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Az, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strB2 = StringResources_androidKt.b(R.string.yz, composer, 0);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.n1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3OverviewKt.i1(function1);
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, primary, null, strB2, null, 0L, null, null, false, false, (Function0) objG, composer, 24576, 0, 8111);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            String strB3 = StringResources_androidKt.b(R.string.zz, composer, 0);
            FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.o1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3OverviewKt.j1(function1);
                    }
                };
                composer.w(objG2);
            }
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, secondary, null, strB3, null, 0L, null, null, false, false, (Function0) objG2, composer, 24576, 0, 8111);
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
    public static final int i0(int i3) {
        return -i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(Function1 function1) {
        function1.invoke(StrictMode3ViewEvent.OnStrictModeResumed.f121209a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(long j3, List list, AnimatedContentScope AnimatedContent, int i3, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        if (ComposerKt.M()) {
            ComposerKt.U(-668831572, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.AutoAdvanceVerticalSMInfoPager.<anonymous> (StrictMode3Overview.kt:1085)");
        }
        Modifier.Companion companion = Modifier.b8;
        float f3 = 4;
        Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(f3), 1, null);
        Arrangement arrangement = Arrangement.f6574a;
        float fG = Dp.g(f3);
        Alignment.Companion companion2 = Alignment.f25072a;
        MeasurePolicy measurePolicyB = RowKt.b(arrangement.p(fG, companion2.g()), companion2.i(), composer, 54);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
        Updater.e(composerA, measurePolicyB, companion3.e());
        Updater.e(composerA, compositionLocalMapU, companion3.g());
        Function2 function2B = companion3.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF, companion3.f());
        RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
        IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.a6, composer, 6), null, SizeKt.v(companion, Dp.g(16)), j3, composer, 432, 0);
        TextKt.c((String) list.get(RangesKt.k(i3, list.size() - 1)), null, j3, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 0, 0, 65018);
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(Function1 function1) {
        function1.invoke(StrictMode3ViewEvent.OnDismissResumeBottomSheet.f121195a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(Modifier modifier, List list, long j3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        b0(modifier, list, j3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(Function1 function1) {
        function1.invoke(StrictMode3ViewEvent.OnDismissResumeBottomSheet.f121195a);
        return Unit.f139807a;
    }

    private static final void l0(final StrictMode3ViewState.ActiveState activeState, final Function1 function1, final StrictMode3ViewState strictMode3ViewState, final Function0 function0, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        Composer composerK = composer.k(1532066749);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(activeState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(strictMode3ViewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function0) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1532066749, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.BottomBar (StrictMode3Overview.kt:953)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            if (activeState.g()) {
                composerK.a0(-816603307);
                boolean zF = activeState.f();
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierD = BackgroundKt.d(companion, ComposeColorsKt.j(composerK, 0).e(), null, 2, null);
                int i5 = R.dimen.f95467a;
                Modifier modifierM = PaddingKt.m(modifierD, PrimitiveResources_androidKt.a(i5, composerK, 0), 0.0f, PrimitiveResources_androidKt.a(i5, composerK, 0), Dp.g(16), 2, null);
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
                final FlatButtonColors flatButtonColors = (activeState.e() == StrictModeState.Inactive || activeState.e() == StrictModeState.Paused) ? FlatButtonColors.Primary.f131166a : zF ? FlatButtonColors.Secondary.f131167a : FlatButtonColors.Disabled.f131162a;
                boolean z2 = (i4 & 7168) == 2048;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.x1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StrictMode3OverviewKt.m0(function0);
                        }
                    };
                    composerK.w(objG);
                }
                int i6 = i4;
                FlatButtonsKt.r(null, 0.0f, null, flatButtonColors, zF, false, (Function0) objG, ComposableLambdaKt.e(370796645, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.y1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return StrictMode3OverviewKt.n0(strictMode3ViewState, context, activeState, flatButtonColors, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerK, 54), composerK, 12582912, 39);
                if (strictMode3ViewState.g().e() == StrictModeState.Active && (strictMode3ViewState.d() instanceof AccessMethodConfiguration.Approval) && strictMode3ViewState.g().c() == StrictModeButtonState.ApprovalRequestSent) {
                    composerK.a0(852483952);
                    ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.J4, composerK, 6);
                    Modifier modifierM2 = PaddingKt.m(boxScopeInstance.f(companion, companion2.f()), 0.0f, 0.0f, Dp.g(6), 0.0f, 11, null);
                    boolean z3 = (i6 & 112) == 32;
                    Object objG2 = composerK.G();
                    if (z3 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.z1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return StrictMode3OverviewKt.o0(function1);
                            }
                        };
                        composerK.w(objG2);
                    }
                    ComposeButtonsKt.q0(modifierM2, imageVectorB, null, false, 0.0f, 0.0f, 0L, null, (Function0) objG2, composerK, 0, 252);
                    composerK = composerK;
                } else {
                    composerK.a0(808538724);
                }
                composerK.U();
                composerK.y();
            } else {
                composerK.a0(-858614011);
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3OverviewKt.p0(activeState, function1, strictMode3ViewState, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l1(Function1 function1, int i3, Composer composer, int i4) {
        g1(function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1(kotlin.jvm.functions.Function0 r36, kotlin.jvm.functions.Function0 r37, boolean r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 810
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3OverviewKt.m1(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(StrictMode3ViewState strictMode3ViewState, Context context, StrictMode3ViewState.ActiveState activeState, FlatButtonColors flatButtonColors, RowScope ButtonFlat, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(ButtonFlat, "$this$ButtonFlat");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(370796645, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.BottomBar.<anonymous>.<anonymous> (StrictMode3Overview.kt:977)");
            }
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(strictMode3ViewState.l(context, activeState.c()), null, flatButtonColors.d(composer, 0), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composer, 0).c()), composer, 0, 0, 65530);
            Composer composer2 = composer;
            if (activeState.e() == StrictModeState.Paused) {
                composer2.a0(688378377);
                TextKt.c(StringResources_androidKt.b(R.string.xy, composer2, 0), null, flatButtonColors.d(composer2, 0), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer, 0, 0, 65530);
                composer2 = composer;
            } else {
                composer2.a0(645023699);
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(Function1 function1) {
        function1.invoke(StrictMode3ViewEvent.OnRefreshClicked.f121203a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier o1(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return PaddingKt.m(applyIf, 0.0f, Dp.g(16), 0.0f, 0.0f, 13, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(StrictMode3ViewState.ActiveState activeState, Function1 function1, StrictMode3ViewState strictMode3ViewState, Function0 function0, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        l0(activeState, function1, strictMode3ViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier p1(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return PaddingKt.m(applyIf, 0.0f, Dp.g(16), 0.0f, 0.0f, 13, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void q0(final cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState r23, final androidx.compose.foundation.layout.PaddingValues r24, final kotlin.jvm.functions.Function1 r25, boolean r26, kotlin.jvm.functions.Function0 r27, kotlin.jvm.functions.Function0 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3OverviewKt.q0(cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier r0(ScrollState scrollState, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ScrollKt.g(applyIf, scrollState, false, null, false, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(Function0 function0, Function0 function02, boolean z2, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        m1(function0, function02, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(Function1 function1) {
        AnswersHelper.f128199a.v7();
        function1.invoke(StrictMode3ViewEvent.OnLearnMoreClicked.f121197a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(StrictMode3ViewState strictMode3ViewState, PaddingValues paddingValues, Function1 function1, boolean z2, Function0 function0, Function0 function02, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        q0(strictMode3ViewState, paddingValues, function1, z2, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void u0(final StrictMode3ViewState strictMode3ViewState, final Function1 function1, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        final Function1 function12;
        Composer composer2;
        int i5;
        long jQ;
        boolean z2;
        float f3;
        int i6;
        Composer composer3;
        boolean z3;
        int i7;
        float f4;
        final boolean z4;
        long jQ2;
        long j3;
        long jQ3;
        long jQ4;
        Composer composerK = composer.k(-1591231873);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(strictMode3ViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1591231873, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.Footer (StrictMode3Overview.kt:740)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            StrictModeState strictModeStateE = strictMode3ViewState.g().e();
            Modifier.Companion companion2 = Modifier.b8;
            float f5 = 16;
            Modifier modifierK = PaddingKt.k(PaddingKt.m(SizeKt.h(companion2, 0.0f, 1, null), 0.0f, Dp.g(f5), 0.0f, 0.0f, 13, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion3.k(), composerK, 0);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            boolean z5 = strictModeStateE == StrictModeState.Inactive || strictModeStateE == StrictModeState.Paused;
            if (z5) {
                composerK.a0(762264533);
                i5 = 0;
                jQ = ComposeColorsKt.j(composerK, 0).p();
            } else {
                i5 = 0;
                composerK.a0(762265334);
                jQ = ComposeColorsKt.j(composerK, 0).q();
            }
            composerK.U();
            long j4 = jQ;
            String upperCase = StringResources_androidKt.b(R.string.Oz, composerK, i5).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextStyle textStyleD = ComposeTypographyKt.g(composerK, i5).d();
            long jQ5 = ComposeColorsKt.j(composerK, i5).q();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            int i8 = i4;
            float f6 = 4;
            TextKt.c(upperCase, PaddingKt.m(SizeKt.h(companion2, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.g(f6), 7, null), jQ5, 0L, null, null, null, 0L, null, TextAlign.h(companion5.f()), 0L, 0, false, 0, 0, null, textStyleD, composerK, 48, 0, 65016);
            Composer composer4 = composerK;
            Alignment.Vertical verticalI = companion3.i();
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            boolean z6 = z5;
            long jL0 = ComposeColorsKt.j(composer4, 0).l0();
            int i9 = R.dimen.f95480n;
            Modifier modifierA = IntrinsicKt.a(ClipKt.a(BackgroundKt.c(modifierH, jL0, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i9, composer4, 0))), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i9, composer4, 0))), IntrinsicSize.f6986a);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer4, 48);
            int iA2 = ComposablesKt.a(composer4, 0);
            CompositionLocalMap compositionLocalMapU2 = composer4.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer4, modifierA);
            Function0 function0A2 = companion4.a();
            if (composer4.m() == null) {
                ComposablesKt.c();
            }
            composer4.L();
            if (composer4.i()) {
                composer4.P(function0A2);
            } else {
                composer4.v();
            }
            Composer composerA2 = Updater.a(composer4);
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Alignment.Vertical verticalI2 = companion3.i();
            float f7 = 56;
            RowScopeInstance rowScopeInstance2 = rowScopeInstance;
            Modifier modifierK2 = SizeKt.k(SizeKt.f(RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), 0.0f, 1, null), Dp.g(f7), 0.0f, 2, null);
            int i10 = i8 & 112;
            boolean zB = composer4.b(z6) | (i10 == 32);
            Object objG2 = composer4.G();
            if (zB || objG2 == companion.a()) {
                objG2 = new StrictMode3OverviewKt$Footer$1$1$1$1(z6, function1);
                composer4.w(objG2);
            }
            Modifier modifierF3 = ClickableKt.f(modifierK2, z6, null, null, (Function0) ((KFunction) objG2), 6, null);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), verticalI2, composer4, 48);
            int iA3 = ComposablesKt.a(composer4, 0);
            CompositionLocalMap compositionLocalMapU3 = composer4.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer4, modifierF3);
            Function0 function0A3 = companion4.a();
            if (composer4.m() == null) {
                ComposablesKt.c();
            }
            composer4.L();
            if (composer4.i()) {
                composer4.P(function0A3);
            } else {
                composer4.v();
            }
            Composer composerA3 = Updater.a(composer4);
            Updater.e(composerA3, measurePolicyB2, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion4.f());
            StrictModeAccessMethod strictModeAccessMethodC = strictMode3ViewState.c();
            if (strictModeAccessMethodC != null) {
                composer4.a0(-1150686067);
                Integer title = strictModeAccessMethodC.getTitle();
                if (title != null) {
                    composer4.a0(-1150641334);
                    Painter painterC = PainterResources_androidKt.c(strictModeAccessMethodC.getIcon(), composer4, 0);
                    if (strictModeStateE == StrictModeState.Active || strictModeStateE == StrictModeState.Standby) {
                        composer4.a0(-1150387227);
                        jQ4 = ComposeColorsKt.j(composer4, 0).q();
                        composer4.U();
                    } else {
                        composer4.a0(-1699674004);
                        composer4.U();
                        jQ4 = Color.f25715b.k();
                    }
                    f3 = f7;
                    IconKt.c(painterC, null, PaddingKt.m(companion2, Dp.g(12), 0.0f, Dp.g(8), 0.0f, 10, null), jQ4, composer4, 432, 0);
                    TextKt.c(StringResources_androidKt.b(title.intValue(), composer4, 0), RowScope.c(rowScopeInstance2, companion2, 1.0f, false, 2, null), j4, 0L, null, null, null, 0L, null, TextAlign.h(companion5.f()), 0L, TextOverflow.f29661b.b(), false, 1, 0, null, ComposeTypographyKt.g(composer4, 0).i(), composer4, 0, 3120, 54776);
                    j3 = j4;
                    composer4 = composer4;
                    composer4.U();
                    rowScopeInstance2 = rowScopeInstance2;
                } else {
                    f3 = f7;
                    j3 = j4;
                    composer4.a0(-1149573508);
                    Arrangement.Horizontal horizontalG = arrangement.g();
                    Modifier modifierC = RowScope.c(rowScopeInstance2, PaddingKt.m(companion2, Dp.g(12), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
                    rowScopeInstance2 = rowScopeInstance2;
                    MeasurePolicy measurePolicyB3 = RowKt.b(horizontalG, companion3.l(), composer4, 6);
                    int iA4 = ComposablesKt.a(composer4, 0);
                    CompositionLocalMap compositionLocalMapU4 = composer4.u();
                    Modifier modifierF5 = ComposedModifierKt.f(composer4, modifierC);
                    Function0 function0A4 = companion4.a();
                    if (composer4.m() == null) {
                        ComposablesKt.c();
                    }
                    composer4.L();
                    if (composer4.i()) {
                        composer4.P(function0A4);
                    } else {
                        composer4.v();
                    }
                    Composer composerA4 = Updater.a(composer4);
                    Updater.e(composerA4, measurePolicyB3, companion4.e());
                    Updater.e(composerA4, compositionLocalMapU4, companion4.g());
                    Function2 function2B4 = companion4.b();
                    if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                        composerA4.w(Integer.valueOf(iA4));
                        composerA4.p(Integer.valueOf(iA4), function2B4);
                    }
                    Updater.e(composerA4, modifierF5, companion4.f());
                    composer4.a0(373994364);
                    Iterator<E> it = strictMode3ViewState.e().iterator();
                    while (it.hasNext()) {
                        Painter painterC2 = PainterResources_androidKt.c(((StrictModeAccessMethod) it.next()).getIcon(), composer4, 0);
                        if (strictModeStateE == StrictModeState.Active || strictModeStateE == StrictModeState.Standby) {
                            composer4.a0(-1895707992);
                            jQ3 = ComposeColorsKt.j(composer4, 0).q();
                            composer4.U();
                        } else {
                            composer4.a0(770135865);
                            composer4.U();
                            jQ3 = Color.f25715b.k();
                        }
                        Composer composer5 = composer4;
                        IconKt.c(painterC2, null, PaddingKt.m(Modifier.b8, 0.0f, 0.0f, Dp.g(f6), 0.0f, 11, null), jQ3, composer5, 432, 0);
                        composer4 = composer5;
                    }
                    composer4.U();
                    composer4.y();
                    composer4.U();
                }
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95574w1, composer4, 6);
                Modifier modifierK3 = PaddingKt.k(Modifier.b8, 0.0f, Dp.g(f6), 1, null);
                boolean zB2 = composer4.b(z6) | (i10 == 32);
                Object objG3 = composer4.G();
                if (zB2 || objG3 == Composer.f23746a.a()) {
                    objG3 = new StrictMode3OverviewKt$Footer$1$1$2$2$1(z6, function1);
                    composer4.w(objG3);
                }
                Composer composer6 = composer4;
                ComposeButtonsKt.q0(modifierK3, imageVectorB, null, z6, 0.0f, 0.0f, j3, null, (Function0) ((KFunction) objG3), composer6, 6, SensibleDefaults.X_OFFSET);
                z2 = z6;
                composer4 = composer6;
            } else {
                z2 = z6;
                f3 = f7;
                composer4.a0(-1184652767);
            }
            composer4.U();
            composer4.y();
            if (strictMode3ViewState.c() == StrictModeAccessMethod.Charger || strictMode3ViewState.c() == StrictModeAccessMethod.PinCode) {
                i6 = 6;
                function12 = function1;
                composer3 = composer4;
                z3 = true;
                i7 = i10;
                composer3.a0(865980605);
            } else {
                composer4.a0(902687643);
                long jV = ComposeColorsKt.j(composer4, 0).v();
                Modifier.Companion companion6 = Modifier.b8;
                Composer composer7 = composer4;
                DividerKt.a(PaddingKt.k(SizeKt.A(SizeKt.k(companion6, Dp.g(50), 0.0f, 2, null), Dp.g(1)), 0.0f, Dp.g(f6), 1, null), jV, 0.0f, 0.0f, composer7, 6, 12);
                i7 = i10;
                final TooltipState tooltipStateM = TooltipKt.m(false, false, null, composer7, 0, 7);
                boolean z7 = z2 || (strictMode3ViewState.d() instanceof AccessMethodConfiguration.Schedules);
                final boolean z8 = strictMode3ViewState.d() instanceof AccessMethodConfiguration.Approval;
                if (z7 || z8) {
                    f4 = f3;
                    z4 = true;
                } else {
                    f4 = f3;
                    z4 = false;
                }
                if (z4) {
                    composer7.a0(-1217785071);
                    jQ2 = ComposeColorsKt.j(composer7, 0).p();
                } else {
                    composer7.a0(-1217784270);
                    jQ2 = ComposeColorsKt.j(composer7, 0).q();
                }
                composer7.U();
                Modifier modifierK4 = SizeKt.k(SizeKt.h(RowScope.c(rowScopeInstance2, companion6, 1.0f, false, 2, null), 0.0f, 1, null), Dp.g(f4), 0.0f, 2, null);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                int iA5 = ComposablesKt.a(composer7, 0);
                CompositionLocalMap compositionLocalMapU5 = composer7.u();
                Modifier modifierF6 = ComposedModifierKt.f(composer7, modifierK4);
                ComposeUiNode.Companion companion7 = ComposeUiNode.f8;
                Function0 function0A5 = companion7.a();
                if (composer7.m() == null) {
                    ComposablesKt.c();
                }
                composer7.L();
                if (composer7.i()) {
                    composer7.P(function0A5);
                } else {
                    composer7.v();
                }
                Composer composerA5 = Updater.a(composer7);
                Updater.e(composerA5, measurePolicyG, companion7.e());
                Updater.e(composerA5, compositionLocalMapU5, companion7.g());
                Function2 function2B5 = companion7.b();
                if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                    composerA5.w(Integer.valueOf(iA5));
                    composerA5.p(Integer.valueOf(iA5), function2B5);
                }
                Updater.e(composerA5, modifierF6, companion7.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                final String strA = strictMode3ViewState.d().a(context);
                Modifier modifierF7 = SizeKt.f(companion6, 0.0f, 1, null);
                final boolean z9 = z7;
                final long j5 = jQ2;
                i6 = 6;
                z3 = true;
                Function2 function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.o0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StrictMode3OverviewKt.v0(z4, z9, function1, z8, coroutineScope, tooltipStateM, strA, j5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                function12 = function1;
                composer3 = composer7;
                cz.mobilesoft.coreblock.view.compose.material3.TooltipKt.g(strA, modifierF7, tooltipStateM, ComposableLambdaKt.e(1264249947, true, function2, composer7, 54), composer3, 3120, 0);
                composer3.y();
            }
            composer3.U();
            composer3.y();
            Modifier.Companion companion8 = Modifier.b8;
            SpacerKt.a(SizeKt.v(companion8, Dp.g(f5)), composer3, i6);
            CardType.Custom custom = new CardType.Custom(ComposeColorsKt.j(composer3, 0).e(), Color.n(ComposeColorsKt.j(composer3, 0).u()), null, null, 12, null);
            Modifier modifierK5 = SizeKt.k(PaddingKt.m(companion8, 0.0f, 0.0f, 0.0f, Dp.g(f5), 7, null), Dp.g(40), 0.0f, 2, null);
            boolean z10 = i7 == 32 ? z3 : false;
            Object objG4 = composer3.G();
            if (z10 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.p0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3OverviewKt.x0(function12);
                    }
                };
                composer3.w(objG4);
            }
            ComposeCardsKt.m(modifierK5, custom, (Function0) objG4, ComposableSingletons$StrictMode3OverviewKt.f121092a.n(), composer3, 3078, 0);
            composer2 = composer3;
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function12 = function1;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3OverviewKt.z0(strictMode3ViewState, function12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(boolean z2, boolean z3, Function1 function1, boolean z4, CoroutineScope coroutineScope, TooltipState tooltipState, String str, long j3, Composer composer, int i3) throws XmlPullParserException, IOException {
        Composer composer2 = composer;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1264249947, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.Footer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictMode3Overview.kt:877)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            boolean zB = composer2.b(z3) | composer2.Z(function1) | composer2.b(z4) | composer2.I(coroutineScope) | composer2.I(tooltipState);
            Object objG = composer2.G();
            if (zB || objG == Composer.f23746a.a()) {
                StrictMode3OverviewKt$Footer$1$1$3$1$1$1 strictMode3OverviewKt$Footer$1$1$3$1$1$1 = new StrictMode3OverviewKt$Footer$1$1$3$1$1$1(z3, function1, z4, coroutineScope, tooltipState);
                composer2.w(strictMode3OverviewKt$Footer$1$1$3$1$1$1);
                objG = strictMode3OverviewKt$Footer$1$1$3$1$1$1;
            }
            Modifier modifierF2 = ClickableKt.f(modifierF, z2, null, null, (Function0) ((KFunction) objG), 6, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composer2, 48);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierF2);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF3, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (str == null) {
                composer2.a0(901876863);
            } else {
                composer2.a0(901876864);
                TextKt.c(str, PaddingKt.m(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.g(12), 0.0f, Dp.g(8), 0.0f, 10, null), j3, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, TextOverflow.f29661b.b(), false, 1, 0, null, ComposeTypographyKt.g(composer2, 0).i(), composer, 0, 3120, 54776);
                composer2 = composer;
            }
            composer2.U();
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95574w1, composer2, 6);
            boolean zB2 = composer2.b(z3) | composer2.Z(function1) | composer2.b(z4) | composer2.I(coroutineScope) | composer2.I(tooltipState);
            Object objG2 = composer2.G();
            if (zB2 || objG2 == Composer.f23746a.a()) {
                StrictMode3OverviewKt$Footer$1$1$3$1$2$2$1 strictMode3OverviewKt$Footer$1$1$3$1$2$2$1 = new StrictMode3OverviewKt$Footer$1$1$3$1$2$2$1(z3, function1, z4, coroutineScope, tooltipState);
                composer2.w(strictMode3OverviewKt$Footer$1$1$3$1$2$2$1);
                objG2 = strictMode3OverviewKt$Footer$1$1$3$1$2$2$1;
            }
            ComposeButtonsKt.q0(null, imageVectorB, null, z2, 0.0f, 0.0f, j3, null, (Function0) ((KFunction) objG2), composer2, 0, 181);
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
    public static final void w0(boolean z2, Function1 function1, boolean z3, CoroutineScope coroutineScope, TooltipState tooltipState) {
        if (z2) {
            function1.invoke(StrictMode3ViewEvent.OnSelectedAccessMethodClicked.f121207a);
        } else if (z3) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new StrictMode3OverviewKt$Footer$1$1$handleSelectedAccessMethodActionClick$1(tooltipState, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(Function1 function1) {
        function1.invoke(StrictMode3ViewEvent.OnOptionsClicked.f121199a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(boolean z2, Function1 function1) {
        if (z2) {
            function1.invoke(StrictMode3ViewEvent.OnAccessMethodsClicked.f121188a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(StrictMode3ViewState strictMode3ViewState, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        u0(strictMode3ViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void b1(final String cooldownTimerTime, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(cooldownTimerTime, "cooldownTimerTime");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-1663485735);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(cooldownTimerTime) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1663485735, i4, -1, YgVrd.ovlDxodmxkAAtg);
            }
            I0(composerK, 0);
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(518949178, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.r0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return StrictMode3OverviewKt.c1(cooldownTimerTime, onEvent, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54);
            boolean z2 = (i4 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.s0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictMode3OverviewKt.e1(onEvent);
                    }
                };
                composerK.w(objG);
            }
            ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, (Function0) objG, composerK, 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.t0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3OverviewKt.f1(cooldownTimerTime, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
