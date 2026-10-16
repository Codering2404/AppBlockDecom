package cz.mobilesoft.coreblock.scene.more.referral;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt;
import cz.mobilesoft.coreblock.scene.more.referral.ReferralViewEvent;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class ReferralActivityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function1 function1, MutableState mutableState, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(ReferralViewEvent.OnShared.f107974a);
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Activity activity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (activity != null) {
            activity.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(ReferralViewModel referralViewModel, Function1 function1, int i3, Composer composer, int i4) {
        g(referralViewModel, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final ReferralViewState referralViewState, final Function1 function1, final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        String strB;
        Composer composerK = composer.k(-2108411543);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(referralViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(paddingValues) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 131) != 130, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2108411543, i4, -1, "cz.mobilesoft.coreblock.scene.more.referral.Content (ReferralActivity.kt:186)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(PaddingKt.k(PaddingKt.h(companion, paddingValues), PrimitiveResources_androidKt.a(R.dimen.f95486t, composerK, 0), 0.0f, 2, null), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
            Updater.e(composerA, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            final Activity activityB = ContextExtKt.b((Context) composerK.q(AndroidCompositionLocals_androidKt.g()));
            boolean zI = composerK.I(activityB);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.referral.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ReferralActivityKt.l(activityB);
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 0, 1);
            boolean zI2 = composerK.I(activityB);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.referral.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ReferralActivityKt.m(activityB);
                    }
                };
                composerK.w(objG2);
            }
            composer2 = composerK;
            ComposeButtonsKt.o0(null, null, 0, (Function0) objG2, composer2, 0, 7);
            float f3 = 32;
            Modifier modifierK = PaddingKt.k(PaddingKt.m(ScrollKt.g(SizeKt.f(companion, 0.0f, 1, null), ScrollKt.c(0, composer2, 0, 1), false, null, false, 14, null), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer2, 0), 0.0f, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composer2, 0);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierK);
            Function0 function0A2 = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A2);
            } else {
                composer2.v();
            }
            Composer composerA2 = Updater.a(composer2);
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            if (referralViewState.c() == null || referralViewState.d() == null) {
                composer2.a0(-1544002565);
                SchedulesSectionKt.D(0.0f, 0, composer2, 0, 3);
                composer2.U();
            } else {
                composer2.a0(-1543893538);
                ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.L7, composer2, 6), null, SizeKt.h(companion, 0.0f, 1, null), null, null, 0.0f, null, composer2, 432, 120);
                String strX = StringHelperExtKt.x(referralViewState.c().intValue());
                if (referralViewState.d().booleanValue()) {
                    composer2.a0(-1543547268);
                    strB = StringResources_androidKt.c(R.string.ls, new Object[]{strX}, composer2, 0);
                    composer2.U();
                } else {
                    composer2.a0(-1543429933);
                    strB = StringResources_androidKt.b(R.string.ns, composer2, 0);
                    composer2.U();
                }
                TextStyle textStyleF = ComposeTypographyKt.g(composer2, 0).f();
                TextAlign.Companion companion4 = TextAlign.f29616b;
                TextKt.c(strB, SizeKt.h(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), 0.0f, 1, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer2, 48, 0, 65020);
                String strC = StringResources_androidKt.c(R.string.js, new Object[]{strX}, composer2, 0);
                if (referralViewState.d().booleanValue()) {
                    composer2.a0(-1542842731);
                    composer2.U();
                } else {
                    composer2.a0(-1542776639);
                    strC = StringHelperExtKt.q(strC, StringResources_androidKt.b(R.string.ks, composer2, 0), null, 2, null);
                    composer2.U();
                }
                TextKt.c(strC, SizeKt.h(PaddingKt.m(companion, 0.0f, Dp.g(16), 0.0f, 0.0f, 13, null), 0.0f, 1, null), ComposeColorsKt.j(composer2, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).i(), composer2, 48, 0, 65016);
                composer2 = composer2;
                composer2.U();
            }
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.referral.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReferralActivityKt.n(referralViewState, function1, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Activity activity) {
        AnswersHelper.f128199a.C4();
        if (activity != null) {
            activity.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Activity activity) {
        AnswersHelper.f128199a.C4();
        if (activity != null) {
            activity.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(ReferralViewState referralViewState, Function1 function1, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        k(referralViewState, function1, paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final ReferralViewModel referralViewModel, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1123245980);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(referralViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1123245980, i4, -1, muQRKXGtpOhe.xhJeoKlizylS);
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new BroadcastReceiver() { // from class: cz.mobilesoft.coreblock.scene.more.referral.ReferralActivityKt$CommandProcessor$applicationSelectedBroadcastReceiver$1$1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context2, Intent intent) {
                        if (context2 != null) {
                            context2.unregisterReceiver(this);
                        }
                        mutableState.setValue(Boolean.TRUE);
                    }
                };
                composerK.w(objG2);
            }
            ReferralActivityKt$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 referralActivityKt$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 = (ReferralActivityKt$CommandProcessor$applicationSelectedBroadcastReceiver$1$1) objG2;
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean z2 = (i4 & 112) == 32;
            Object objG3 = composerK.G();
            if (z2 || objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.referral.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ReferralActivityKt.h(function1, mutableState, (ActivityResult) obj);
                    }
                };
                composerK.w(objG3);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG3, composerK, 0);
            final Activity activityB = ContextExtKt.b((Context) composerK.q(AndroidCompositionLocals_androidKt.g()));
            ActivityResultContracts.StartActivityForResult startActivityForResult2 = new ActivityResultContracts.StartActivityForResult();
            boolean zI = composerK.I(activityB);
            Object objG4 = composerK.G();
            if (zI || objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.referral.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ReferralActivityKt.i(activityB, (ActivityResult) obj);
                    }
                };
                composerK.w(objG4);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA2 = ActivityResultRegistryKt.a(startActivityForResult2, (Function1) objG4, composerK, 0);
            boolean zI2 = composerK.I(context) | composerK.I(referralActivityKt$CommandProcessor$applicationSelectedBroadcastReceiver$1$1) | composerK.I(managedActivityResultLauncherA) | composerK.I(managedActivityResultLauncherA2);
            Object objG5 = composerK.G();
            if (zI2 || objG5 == companion.a()) {
                ReferralActivityKt$CommandProcessor$1$1 referralActivityKt$CommandProcessor$1$1 = new ReferralActivityKt$CommandProcessor$1$1(context, referralActivityKt$CommandProcessor$applicationSelectedBroadcastReceiver$1$1, managedActivityResultLauncherA, managedActivityResultLauncherA2, null);
                composerK.w(referralActivityKt$CommandProcessor$1$1);
                objG5 = referralActivityKt$CommandProcessor$1$1;
            }
            FlowExtKt.g(referralViewModel, null, (Function2) objG5, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.referral.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ReferralActivityKt.j(referralViewModel, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
