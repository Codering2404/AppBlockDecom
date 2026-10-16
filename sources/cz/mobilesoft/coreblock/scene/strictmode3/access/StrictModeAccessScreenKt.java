package cz.mobilesoft.coreblock.scene.strictmode3.access;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeEmailInputBottomSheetKt;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import cz.mobilesoft.coreblock.view.compose.LabelsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StrictModeAccessScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f121517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f121518b;

        static {
            int[] iArr = new int[StrictModeAccessMethod.values().length];
            try {
                iArr[StrictModeAccessMethod.FollowSchedules.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StrictModeAccessMethod.Approval.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f121517a = iArr;
            int[] iArr2 = new int[StrictModeAccessExtraBadge.values().length];
            try {
                iArr2[StrictModeAccessExtraBadge.Premium.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[StrictModeAccessExtraBadge.TrialBenefit.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f121518b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean A(StrictModeAccessViewState strictModeAccessViewState) {
        return strictModeAccessViewState.g().f(Product.STRICT_MODE);
    }

    private static final boolean B(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Function1 function1, ActivityResult activityResult) {
        Object next;
        Intrinsics.checkNotNullParameter(activityResult, "activityResult");
        if (activityResult.d() == -1) {
            Iterator it = StrictModeAccessMethod.Companion.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((StrictModeAccessMethod) next) == StrictModeAccessMethod.Approval) {
                    break;
                }
            }
            StrictModeAccessMethod strictModeAccessMethod = (StrictModeAccessMethod) next;
            if (strictModeAccessMethod != null) {
                function1.invoke(new StrictModeAccessViewEvent.OnAccessMethodClicked(strictModeAccessMethod));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Context context, ManagedActivityResultLauncher managedActivityResultLauncher, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            managedActivityResultLauncher.b(SignInActivity.f110366h.a(context, new SignInConfig(SignInEntryPoint.SM_APPROVAL, null, false, false, false, false, true, false, false, false, null, 1982, null)));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Context context, PremiumFeature premiumFeature, StrictModeAccessMethod strictModeAccessMethod, ManagedActivityResultLauncher managedActivityResultLauncher) {
        Paywall paywall = Paywall.f113165a;
        PaywallTarget.LimitScreen limitScreen = new PaywallTarget.LimitScreen(premiumFeature);
        StrictModeAccessMethod strictModeAccessMethod2 = StrictModeAccessMethod.Approval;
        Intent intentC = Paywall.c(paywall, context, limitScreen, "strict_mode_setup", strictModeAccessMethod == strictModeAccessMethod2 ? "by_approval_button" : "by_schedule_button", false, false, false, null, 240, null);
        if (strictModeAccessMethod == strictModeAccessMethod2) {
            managedActivityResultLauncher.b(intentC);
        } else {
            context.startActivity(intentC);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Context context, ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.b(SignInActivity.f110366h.a(context, new SignInConfig(SignInEntryPoint.SM_APPROVAL, null, false, false, false, false, true, false, false, false, null, 1982, null)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1, StrictModeAccessMethod strictModeAccessMethod) {
        function1.invoke(new StrictModeAccessViewEvent.OnAccessMethodClicked(strictModeAccessMethod));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(MutableState mutableState) {
        mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(Context context, StrictModeAccessMethod strictModeAccessMethod) {
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.STRICT_MODE_PROFILES), "strict_mode_setup", strictModeAccessMethod == StrictModeAccessMethod.SchedulesAndPin ? "by_schedule_and_pin_button" : "by_schedule_and_charger_button", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Function1 function1, StrictModeAccessMethod strictModeAccessMethod) {
        function1.invoke(new StrictModeAccessViewEvent.OnAccessMethodClicked(strictModeAccessMethod));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(StrictModeAccessViewState strictModeAccessViewState, PaddingValues paddingValues, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        z(strictModeAccessViewState, paddingValues, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void L(final String str, final long j3, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-2043053389);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(str) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2043053389, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessBadge (StrictModeAccessScreen.kt:379)");
            }
            composer2 = composerK;
            TextKt.c(str, PaddingKt.j(BorderKt.f(Modifier.b8, Dp.g(1), ComposeColorsKt.j(composerK, 0).u(), RoundedCornerShapeKt.d(Dp.g(3))), Dp.g(4), Dp.g(2)), j3, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).d(), 0L, TextUnitKt.i(11), FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(18), null, null, null, 0, 0, null, 16646137, null), composer2, (i4 & 14) | ((i4 << 3) & 896), 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.t0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeAccessScreenKt.M(str, j3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(String str, long j3, int i3, Composer composer, int i4) {
        L(str, j3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void N(final StrictModeAccessMethod accessMethod, Function0 onCardClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(accessMethod, "accessMethod");
        Intrinsics.checkNotNullParameter(onCardClicked, "onCardClicked");
        Composer composerK = composer.k(894795783);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(accessMethod.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onCardClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(894795783, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessCard (StrictModeAccessScreen.kt:399)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            function0 = onCardClicked;
            ComposeCardsKt.m(SizeKt.h(Modifier.b8, 0.0f, 1, null), new CardType.Surface(null, null, null, 7, null), function0, ComposableLambdaKt.e(2094813868, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeAccessScreenKt.O(accessMethod, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 3) & 896) | 3078, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onCardClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeAccessScreenKt.S(accessMethod, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(final StrictModeAccessMethod strictModeAccessMethod, final Context context, Composer composer, int i3) {
        Modifier.Companion companion;
        RowScopeInstance rowScopeInstance;
        final RowScopeInstance rowScopeInstance2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2094813868, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessCard.<anonymous> (StrictModeAccessScreen.kt:406)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierK = SizeKt.k(PaddingKt.i(companion2, Dp.g(16)), Dp.g(32), 0.0f, 2, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Horizontal horizontalG = arrangement.g();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalG, companion3.l(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyB, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            RowScopeInstance rowScopeInstance3 = RowScopeInstance.f7101a;
            IconKt.a(PainterResources_androidKt.c(strictModeAccessMethod.getIcon(), composer, 0), null, PaddingKt.m(rowScopeInstance3.d(companion2, companion3.i()), 0.0f, 0.0f, Dp.g(12), 0.0f, 11, null), strictModeAccessMethod.getTag().getColor(composer, 0), composer, 48, 0);
            Modifier modifierC = RowScope.c(rowScopeInstance3, rowScopeInstance3.d(companion2, companion3.i()), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion3.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierC);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyA, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            FlowLayoutKt.d(null, null, null, null, 0, 0, ComposableLambdaKt.e(-605922803, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.p0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeAccessScreenKt.P(strictModeAccessMethod, context, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572864, 63);
            Composer composer2 = composer;
            Integer subtitle = strictModeAccessMethod.getSubtitle();
            if (subtitle == null) {
                composer2.a0(-1837511535);
                composer2.U();
                companion = companion2;
                rowScopeInstance = rowScopeInstance3;
            } else {
                composer2.a0(-1837511534);
                companion = companion2;
                rowScopeInstance = rowScopeInstance3;
                TextKt.c(StringResources_androidKt.b(subtitle.intValue(), composer2, 0), PaddingKt.m(companion2, 0.0f, Dp.g(4), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer2, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer, 48, 0, 65528);
                composer2 = composer;
                Unit unit = Unit.f139807a;
                composer2.U();
            }
            composer2.y();
            long color = strictModeAccessMethod.getTag().getColor(composer2, 0);
            TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composer2, 0).d(), 0L, TextUnitKt.i(11), new FontWeight(600), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null);
            String upperCase = StringResources_androidKt.b(strictModeAccessMethod.getTag().getTitle(), composer2, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            Modifier modifierF3 = BorderKt.f(companion, Dp.g(1), ComposeColorsKt.j(composer2, 0).N(), RoundedCornerShapeKt.d(Dp.g(3)));
            boolean z2 = strictModeAccessMethod.getSubtitle() == null;
            Object objG = composer2.G();
            Composer.Companion companion5 = Composer.f23746a;
            if (objG == companion5.a()) {
                rowScopeInstance2 = rowScopeInstance;
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.q0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeAccessScreenKt.Q(rowScopeInstance2, (Modifier) obj);
                    }
                };
                composer2.w(objG);
            } else {
                rowScopeInstance2 = rowScopeInstance;
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composer2.G();
            if (objG2 == companion5.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.r0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeAccessScreenKt.R(rowScopeInstance2, (Modifier) obj);
                    }
                };
                composer2.w(objG2);
            }
            TextKt.c(upperCase, PaddingKt.i(ComposableExtKt.s(modifierF3, z2, function1, (Function1) objG2), Dp.g(4)), color, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleE, composer, 0, 0, 65528);
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
    public static final Unit P(StrictModeAccessMethod strictModeAccessMethod, Context context, FlowRowScope FlowRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-605922803, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeAccessScreen.kt:425)");
            }
            TextKt.c(strictModeAccessMethod.getTitle(context), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.A(Modifier.b8, Dp.g(8)), composer, 6);
            if (strictModeAccessMethod.isNew()) {
                composer.a0(701658507);
                String upperCase = StringResources_androidKt.b(R.string.b7, composer, 0).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                LabelsKt.e(upperCase, ComposeColorsKt.j(composer, 0).q0(), strictModeAccessMethod.getTag().getColor(composer, 0), 0.0f, 0.0f, null, null, composer, 0, 120);
            } else {
                composer.a0(683387541);
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
    public static final Modifier Q(RowScope rowScope, Modifier applyIfElse) {
        Intrinsics.checkNotNullParameter(applyIfElse, "$this$applyIfElse");
        return rowScope.d(applyIfElse, Alignment.f25072a.i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier R(RowScope rowScope, Modifier applyIfElse) {
        Intrinsics.checkNotNullParameter(applyIfElse, "$this$applyIfElse");
        return rowScope.d(applyIfElse, Alignment.f25072a.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(StrictModeAccessMethod strictModeAccessMethod, Function0 function0, int i3, Composer composer, int i4) {
        N(strictModeAccessMethod, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void T(final StrictModeAccessMethod strictModeAccessMethod, final StrictModeAccessExtraBadge strictModeAccessExtraBadge, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-978221363);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(strictModeAccessMethod.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.e(strictModeAccessExtraBadge == null ? -1 : strictModeAccessExtraBadge.ordinal()) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-978221363, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessMethodCard (StrictModeAccessScreen.kt:284)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            CardsKt.j(SizeKt.h(Modifier.b8, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).l0(), 0.0f, false, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composerK, 0)), function0, ComposableLambdaKt.e(1575993073, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.j0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeAccessScreenKt.U(strictModeAccessMethod, context, strictModeAccessExtraBadge, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 9) & 458752) | 1572870, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeAccessScreenKt.W(strictModeAccessMethod, strictModeAccessExtraBadge, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(final StrictModeAccessMethod strictModeAccessMethod, Context context, final StrictModeAccessExtraBadge strictModeAccessExtraBadge, ColumnScope BaseCard, Composer composer, int i3) {
        Modifier.Companion companion;
        Composer composer2;
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1575993073, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessMethodCard.<anonymous> (StrictModeAccessScreen.kt:295)");
            }
            Arrangement arrangement = Arrangement.f6574a;
            float f3 = 16;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(f3));
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierI = PaddingKt.i(companion2, Dp.g(f3));
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion3.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(f3)), companion3.l(), composer, 54);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            float f4 = 4;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO2 = arrangement.o(Dp.g(f4));
            Modifier modifierC = RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(horizontalOrVerticalO2, companion3.k(), composer, 6);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierC);
            Function0 function0A3 = companion4.a();
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
            Updater.e(composerA3, measurePolicyA2, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion4.f());
            TextKt.c(strictModeAccessMethod.getTitle(context), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
            Integer subtitle = strictModeAccessMethod.getSubtitle();
            if (subtitle == null) {
                composer.a0(1921627405);
                composer.U();
                composer2 = composer;
                companion = companion2;
            } else {
                composer.a0(1921627406);
                companion = companion2;
                TextKt.c(StringResources_androidKt.b(subtitle.intValue(), composer, 0), PaddingKt.m(companion2, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65528);
                composer2 = composer;
                Unit unit = Unit.f139807a;
                composer2.U();
            }
            composer2.y();
            float f5 = 64;
            Modifier.Companion companion5 = companion;
            Modifier modifierV = SizeKt.v(companion5, Dp.g(f5));
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA4 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU4 = composer2.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierV);
            Function0 function0A4 = companion4.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A4);
            } else {
                composer2.v();
            }
            Composer composerA4 = Updater.a(composer2);
            Updater.e(composerA4, measurePolicyG, companion4.e());
            Updater.e(composerA4, compositionLocalMapU4, companion4.g());
            Function2 function2B4 = companion4.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            IconKt.a(PainterResources_androidKt.c(strictModeAccessMethod.getGradientIcon(), composer2, 0), null, SizeKt.v(companion5, Dp.g(f5)), Color.f25715b.k(), composer2, 3504, 0);
            composer2.y();
            composer2.y();
            FlowLayoutKt.d(SizeKt.h(companion5, 0.0f, 1, null), arrangement.o(Dp.g(8)), arrangement.o(Dp.g(f4)), null, 0, 1, ComposableLambdaKt.e(-1496642612, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.n0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeAccessScreenKt.V(strictModeAccessMethod, strictModeAccessExtraBadge, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer, 1769910, 24);
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
    public static final Unit V(StrictModeAccessMethod strictModeAccessMethod, StrictModeAccessExtraBadge strictModeAccessExtraBadge, FlowRowScope FlowRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1496642612, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessMethodCard.<anonymous>.<anonymous>.<anonymous> (StrictModeAccessScreen.kt:338)");
            }
            String strB = StringResources_androidKt.b(strictModeAccessMethod.getTag().getTitle(), composer, 0);
            Locale locale = Locale.ROOT;
            String upperCase = strB.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            L(upperCase, strictModeAccessMethod.getTag().getColor(composer, 0), composer, 0);
            int i4 = strictModeAccessExtraBadge == null ? -1 : WhenMappings.f121518b[strictModeAccessExtraBadge.ordinal()];
            if (i4 == -1) {
                composer.a0(540513808);
                composer.U();
            } else if (i4 == 1) {
                composer.a0(540503917);
                String upperCase2 = StringResources_androidKt.b(R.string.JD, composer, 0).toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                L(upperCase2, ComposeColorsKt.j(composer, 0).V(), composer, 0);
                composer.U();
            } else {
                if (i4 != 2) {
                    composer.a0(540501643);
                    composer.U();
                    throw new NoWhenBranchMatchedException();
                }
                composer.a0(540511977);
                d0(composer, 0);
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
    public static final Unit W(StrictModeAccessMethod strictModeAccessMethod, StrictModeAccessExtraBadge strictModeAccessExtraBadge, Function0 function0, int i3, Composer composer, int i4) {
        T(strictModeAccessMethod, strictModeAccessExtraBadge, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void X(final StrictModeAccessViewState viewState, final Function1 onEvent, final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(1600606695);
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
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1600606695, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessScreen (StrictModeAccessScreen.kt:101)");
            }
            int i5 = i4;
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(-1995038548, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeAccessScreenKt.Y(onCloseClicked, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(1266970277, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.o0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeAccessScreenKt.Z(viewState, onEvent, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 384, 12582912, 131067);
            composerK = composerK;
            if (viewState.f()) {
                composerK.a0(947643357);
                int i6 = i5 & 112;
                boolean z2 = i6 == 32;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.u0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StrictModeAccessScreenKt.a0(onEvent, (String) obj);
                        }
                    };
                    composerK.w(objG);
                }
                Function1 function1 = (Function1) objG;
                boolean z3 = i6 == 32;
                Object objG2 = composerK.G();
                if (z3 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.v0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StrictModeAccessScreenKt.b0(onEvent);
                        }
                    };
                    composerK.w(objG2);
                }
                StrictModeEmailInputBottomSheetKt.t(function1, (Function0) objG2, viewState.d(), composerK, 0, 0);
            } else {
                composerK.a0(943067323);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.w0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeAccessScreenKt.c0(viewState, onEvent, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1995038548, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessScreen.<anonymous> (StrictModeAccessScreen.kt:104)");
            }
            ComposeCommonsKt.n(StringResources_androidKt.b(R.string.Oz, composer, 0), function0, null, composer, 0, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(StrictModeAccessViewState strictModeAccessViewState, Function1 function1, PaddingValues it, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1266970277, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessScreen.<anonymous> (StrictModeAccessScreen.kt:110)");
            }
            z(strictModeAccessViewState, it, function1, composer, (i3 << 3) & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Function1 function1, String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        function1.invoke(new StrictModeAccessViewEvent.OnEmailSet(email));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Function1 function1) {
        function1.invoke(StrictModeAccessViewEvent.OnEmailDismiss.f121527a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(StrictModeAccessViewState strictModeAccessViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        X(strictModeAccessViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void d0(Composer composer, final int i3) {
        Composer composerK = composer.k(870841310);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(870841310, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeTrialBenefitBadge (StrictModeAccessScreen.kt:356)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(4));
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalO, verticalI, composerK, 54);
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
            IconKt.a(PainterResources_androidKt.c(R.drawable.E6, composerK, 0), null, SizeKt.v(companion, Dp.g(16)), Color.f25715b.k(), composerK, 3504, 0);
            TextKt.c(StringResources_androidKt.b(R.string.eE, composerK, 0), null, ComposeColorsKt.j(composerK, 0).V(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).d(), 0L, TextUnitKt.i(13), FontWeight.f29233b.h(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(18), null, null, null, 0, 0, null, 16646137, null), composerK, 0, 0, 65530);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.s0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeAccessScreenKt.e0(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(int i3, Composer composer, int i4) {
        d0(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final PremiumFeature f0(StrictModeAccessMethod strictModeAccessMethod) {
        int i3 = WhenMappings.f121517a[strictModeAccessMethod.ordinal()];
        if (i3 == 1) {
            return PremiumFeature.STRICT_MODE_PROFILES;
        }
        if (i3 != 2) {
            return null;
        }
        return PremiumFeature.STRICT_MODE_APPROVAL;
    }

    private static final void z(final StrictModeAccessViewState strictModeAccessViewState, final PaddingValues paddingValues, final Function1 function1, Composer composer, final int i3) throws XmlPullParserException, IOException {
        Iterator it;
        Composer composerK = composer.k(-206911701);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(strictModeAccessViewState) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(paddingValues) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-206911701, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.access.Content (StrictModeAccessScreen.kt:129)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            boolean Z = composerK.Z(strictModeAccessViewState.g());
            Object objG2 = composerK.G();
            if (Z || objG2 == companion.a()) {
                objG2 = SnapshotStateKt.e(new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.x0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(StrictModeAccessScreenKt.A(strictModeAccessViewState));
                    }
                });
                composerK.w(objG2);
            }
            State state = (State) objG2;
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            int i5 = i4 & 896;
            boolean z2 = i5 == 256;
            Object objG3 = composerK.G();
            if (z2 || objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.y0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeAccessScreenKt.C(function1, (ActivityResult) obj);
                    }
                };
                composerK.w(objG3);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG3, composerK, 0);
            ActivityResultContracts.StartActivityForResult startActivityForResult2 = new ActivityResultContracts.StartActivityForResult();
            boolean zI = composerK.I(context) | composerK.I(managedActivityResultLauncherA);
            Object objG4 = composerK.G();
            if (zI || objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.z0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeAccessScreenKt.D(context, managedActivityResultLauncherA, (ActivityResult) obj);
                    }
                };
                composerK.w(objG4);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA2 = ActivityResultRegistryKt.a(startActivityForResult2, (Function1) objG4, composerK, 0);
            Modifier modifierK = PaddingKt.k(PaddingKt.h(ScrollKt.g(SizeKt.f(Modifier.b8, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), paddingValues), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(16)), Alignment.f25072a.k(), composerK, 6);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composerK.a0(1867700440);
            for (Iterator it2 = StrictModeAccessMethod.Companion.a().iterator(); it2.hasNext(); it2 = it) {
                final StrictModeAccessMethod strictModeAccessMethod = (StrictModeAccessMethod) it2.next();
                final PremiumFeature premiumFeatureF0 = f0(strictModeAccessMethod);
                boolean z3 = (premiumFeatureF0 == null || B(state)) ? false : true;
                boolean z4 = premiumFeatureF0 != null && B(state) && strictModeAccessViewState.i();
                if (z3) {
                    composerK.a0(490113915);
                    StrictModeAccessExtraBadge strictModeAccessExtraBadge = StrictModeAccessExtraBadge.Premium;
                    it = it2;
                    boolean zE = composerK.e(strictModeAccessMethod.ordinal()) | composerK.I(context) | composerK.e(premiumFeatureF0 == null ? -1 : premiumFeatureF0.ordinal()) | composerK.I(managedActivityResultLauncherA2);
                    Object objG5 = composerK.G();
                    if (zE || objG5 == Composer.f23746a.a()) {
                        objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.a1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return StrictModeAccessScreenKt.E(context, premiumFeatureF0, strictModeAccessMethod, managedActivityResultLauncherA2);
                            }
                        };
                        composerK.w(objG5);
                    }
                    T(strictModeAccessMethod, strictModeAccessExtraBadge, (Function0) objG5, composerK, 48);
                    composerK.U();
                } else {
                    it = it2;
                    if (strictModeAccessMethod != StrictModeAccessMethod.Approval || strictModeAccessViewState.h()) {
                        composerK.a0(491872049);
                        StrictModeAccessExtraBadge strictModeAccessExtraBadge2 = z4 ? StrictModeAccessExtraBadge.TrialBenefit : null;
                        boolean zE2 = (i5 == 256) | composerK.e(strictModeAccessMethod.ordinal());
                        Object objG6 = composerK.G();
                        if (zE2 || objG6 == Composer.f23746a.a()) {
                            objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.e0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return StrictModeAccessScreenKt.G(function1, strictModeAccessMethod);
                                }
                            };
                            composerK.w(objG6);
                        }
                        T(strictModeAccessMethod, strictModeAccessExtraBadge2, (Function0) objG6, composerK, 0);
                        composerK.U();
                    } else {
                        composerK.a0(491295821);
                        StrictModeAccessExtraBadge strictModeAccessExtraBadge3 = z4 ? StrictModeAccessExtraBadge.TrialBenefit : null;
                        boolean zI2 = composerK.I(context) | composerK.I(managedActivityResultLauncherA);
                        Object objG7 = composerK.G();
                        if (zI2 || objG7 == Composer.f23746a.a()) {
                            objG7 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.b1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return StrictModeAccessScreenKt.F(context, managedActivityResultLauncherA);
                                }
                            };
                            composerK.w(objG7);
                        }
                        T(strictModeAccessMethod, strictModeAccessExtraBadge3, (Function0) objG7, composerK, 0);
                        composerK.U();
                    }
                }
            }
            composerK.U();
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composerK.a0(2067546655);
                TextKt.c(StringResources_androidKt.b(R.string.W7, composerK, 0), PaddingKt.m(Modifier.b8, 0.0f, Dp.g(20), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 48, 0, 65528);
                composerK = composerK;
                for (final StrictModeAccessMethod strictModeAccessMethod2 : StrictModeAccessMethod.Companion.d()) {
                    if ((strictModeAccessMethod2 == StrictModeAccessMethod.SchedulesAndPin || strictModeAccessMethod2 == StrictModeAccessMethod.SchedulesAndCharger) && !B(state)) {
                        composerK.a0(2065560762);
                        String title = strictModeAccessMethod2.getTitle(context);
                        ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, strictModeAccessMethod2.getIcon(), composerK, 6);
                        PremiumFeature premiumFeature = PremiumFeature.STRICT_MODE_PROFILES;
                        long color = strictModeAccessMethod2.getTag().getColor(composerK, 0);
                        RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composerK, 0));
                        boolean zI3 = composerK.I(context) | composerK.e(strictModeAccessMethod2.ordinal());
                        Object objG8 = composerK.G();
                        if (zI3 || objG8 == Composer.f23746a.a()) {
                            objG8 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.g0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return StrictModeAccessScreenKt.I(context, strictModeAccessMethod2);
                                }
                            };
                            composerK.w(objG8);
                        }
                        Composer composer2 = composerK;
                        ComposeCardsKt.s(null, premiumFeature, true, roundedCornerShapeD, color, 0L, false, true, true, imageVectorB, title, null, false, null, false, (Function0) objG8, composer2, 113246640, 0, 30817);
                        composerK = composer2;
                        composerK.U();
                    } else {
                        composerK.a0(2066861956);
                        boolean zE3 = (i5 == 256) | composerK.e(strictModeAccessMethod2.ordinal());
                        Object objG9 = composerK.G();
                        if (zE3 || objG9 == Composer.f23746a.a()) {
                            objG9 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.h0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return StrictModeAccessScreenKt.J(function1, strictModeAccessMethod2);
                                }
                            };
                            composerK.w(objG9);
                        }
                        N(strictModeAccessMethod2, (Function0) objG9, composerK, 0);
                        composerK.U();
                    }
                }
                composerK.U();
            } else {
                composerK.a0(2066688606);
                Modifier.Companion companion3 = Modifier.b8;
                Alignment.Companion companion4 = Alignment.f25072a;
                Modifier modifierC = columnScopeInstance.c(companion3, companion4.g());
                Object objG10 = composerK.G();
                if (objG10 == Composer.f23746a.a()) {
                    objG10 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.f0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StrictModeAccessScreenKt.H(mutableState);
                        }
                    };
                    composerK.w(objG10);
                }
                Modifier modifierF2 = ClickableKt.f(modifierC, false, null, null, (Function0) objG10, 7, null);
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion4.i(), composerK, 48);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierF2);
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
                Updater.e(composerA2, measurePolicyB, companion5.e());
                Updater.e(composerA2, compositionLocalMapU2, companion5.g());
                Function2 function2B2 = companion5.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF3, companion5.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                TextKt.c(StringResources_androidKt.b(R.string.mk, composerK, 0), PaddingKt.m(companion3, 0.0f, 0.0f, Dp.g(4), 0.0f, 11, null), ComposeColorsKt.j(composerK, 0).M(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 48, 0, 65528);
                composerK = composerK;
                IconKt.a(PainterResources_androidKt.c(R.drawable.R2, composerK, 0), null, null, ComposeColorsKt.j(composerK, 0).M(), composerK, 48, 4);
                composerK.y();
                composerK.U();
            }
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.access.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeAccessScreenKt.K(strictModeAccessViewState, paddingValues, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
