package cz.mobilesoft.coreblock.scene.more.guestpassshare;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.GuestPassBaseScreenKt;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.GuestPassShareContentComponentsKt;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.dto.PurchaseSuccessDTO;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;

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
public final class GuestPassShareActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f107428g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f107429h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f107430f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, GuestPassShareFlowScenario flowScenario) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(flowScenario, "flowScenario");
            Intent intentPutExtra = new Intent(context, (Class<?>) GuestPassShareActivity.class).putExtra("extra_flow_scenario", flowScenario.name());
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
            return intentPutExtra;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f107457a;

        static {
            int[] iArr = new int[GuestPassShareFlowStep.values().length];
            try {
                iArr[GuestPassShareFlowStep.GuestPassEligibleShare.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuestPassShareFlowStep.ActivateSharedGuestPass.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuestPassShareFlowStep.ShareWithActivePremium.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GuestPassShareFlowStep.OnboardingShare.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[GuestPassShareFlowStep.ActivateReceivedGuestPass.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[GuestPassShareFlowStep.ThanksForSharing.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[GuestPassShareFlowStep.GuestPassActivated.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f107457a = iArr;
        }
    }

    private final void D0(final GuestPassShareViewModel guestPassShareViewModel, final NavHostController navHostController, final List list, final Function1 function1, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Function1 function12;
        Composer composer2;
        MutableState mutableState;
        ActivityResultContracts.StartActivityForResult startActivityForResult;
        final MutableState mutableState2;
        final Context context;
        final GuestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1;
        GuestPassShareActivity guestPassShareActivity = this;
        final NavHostController navHostController2 = navHostController;
        final List list2 = list;
        Composer composerK = composer.k(1607881173);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(guestPassShareViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(navHostController2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(list2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 2048 : 1024;
        } else {
            function12 = function1;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(guestPassShareActivity) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i5 = i4;
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1607881173, i5, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity.CommandProcessor (GuestPassShareActivity.kt:268)");
            }
            final Context context2 = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState3 = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                final Function1 function13 = function12;
                BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context3, Intent intent) {
                        Unit unit;
                        ComponentName componentName;
                        ComponentName componentName2;
                        String packageName = null;
                        if (((Boolean) mutableState3.getValue()).booleanValue()) {
                            try {
                                Result.Companion companion2 = Result.f139772b;
                                if (context3 != null) {
                                    context3.unregisterReceiver(this);
                                    unit = Unit.f139807a;
                                } else {
                                    unit = null;
                                }
                                Result.b(unit);
                            } catch (Throwable th) {
                                Result.Companion companion3 = Result.f139772b;
                                Result.b(ResultKt.a(th));
                            }
                            mutableState3.setValue(Boolean.FALSE);
                        }
                        if (Build.VERSION.SDK_INT >= 33) {
                            if (intent != null && (componentName2 = (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT", ComponentName.class)) != null) {
                                packageName = componentName2.getPackageName();
                            }
                        } else if (intent != null && (componentName = (ComponentName) intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT")) != null) {
                            packageName = componentName.getPackageName();
                        }
                        if (packageName == null || Intrinsics.areEqual(packageName, "android")) {
                            packageName = "clipboard";
                        }
                        AnswersHelper.f128199a.W1(packageName);
                        function13.invoke(PremiumScreenViewEvent.OnShared.f112361a);
                        this.Z0(navHostController2, list2, function13);
                    }
                };
                mutableState = mutableState3;
                guestPassShareActivity = this;
                navHostController2 = navHostController2;
                list2 = list2;
                composerK.w(broadcastReceiver);
                objG2 = broadcastReceiver;
            } else {
                mutableState = mutableState3;
            }
            final GuestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$12 = (GuestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1) objG2;
            ActivityResultContracts.StartActivityForResult startActivityForResult2 = new ActivityResultContracts.StartActivityForResult();
            boolean zI = composerK.I(guestPassShareActivity) | composerK.I(context2) | composerK.I(guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$12) | ((i5 & 7168) == 2048) | composerK.I(navHostController2) | composerK.I(list2);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                startActivityForResult = startActivityForResult2;
                final GuestPassShareActivity guestPassShareActivity2 = guestPassShareActivity;
                final List list3 = list2;
                final MutableState mutableState4 = mutableState;
                final NavHostController navHostController3 = navHostController2;
                Function1 function14 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GuestPassShareActivity.E0(mutableState4, guestPassShareActivity2, context2, function1, navHostController3, list3, guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$12, (ActivityResult) obj);
                    }
                };
                mutableState2 = mutableState4;
                guestPassShareActivity = guestPassShareActivity2;
                context = context2;
                guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 = guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$12;
                composerK.w(function14);
                objG3 = function14;
            } else {
                startActivityForResult = startActivityForResult2;
                mutableState2 = mutableState;
                guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 = guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$12;
                context = context2;
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG3, composerK, 0);
            Unit unit = Unit.f139807a;
            boolean zI2 = composerK.I(context) | composerK.I(guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1);
            Object objG4 = composerK.G();
            if (zI2 || objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GuestPassShareActivity.F0(mutableState2, context, guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1, (DisposableEffectScope) obj);
                    }
                };
                composerK.w(objG4);
            }
            EffectsKt.c(unit, (Function1) objG4, composerK, 6);
            String strC = StringResources_androidKt.c(R.string.Ze, new Object[]{14, "https://appblock.sng.link/Excv6/h4ml/tapd"}, composerK, 0);
            boolean Z = composerK.Z(strC) | ((57344 & i5) == 16384) | composerK.I(context) | composerK.I(guestPassShareActivity) | composerK.I(guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1) | composerK.I(managedActivityResultLauncherA);
            Object objG5 = composerK.G();
            if (Z || objG5 == companion.a()) {
                GuestPassShareActivity$CommandProcessor$2$1 guestPassShareActivity$CommandProcessor$2$1 = new GuestPassShareActivity$CommandProcessor$2$1(function0, context, mutableState2, guestPassShareActivity, guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1, managedActivityResultLauncherA, strC, null);
                composerK.w(guestPassShareActivity$CommandProcessor$2$1);
                objG5 = guestPassShareActivity$CommandProcessor$2$1;
            }
            composer2 = composerK;
            FlowExtKt.g(guestPassShareViewModel, null, (Function2) objG5, composer2, i5 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GuestPassShareActivity.G0(this.f107473a, guestPassShareViewModel, navHostController, list, function1, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(MutableState mutableState, GuestPassShareActivity guestPassShareActivity, Context context, Function1 function1, NavHostController navHostController, List list, GuestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1, ActivityResult it) {
        ClipData primaryClip;
        ClipData.Item itemAt;
        CharSequence text;
        Intrinsics.checkNotNullParameter(it, "it");
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            try {
                Result.Companion companion = Result.f139772b;
                context.unregisterReceiver(guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1);
                Result.b(Unit.f139807a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f139772b;
                Result.b(ResultKt.a(th));
            }
            mutableState.setValue(Boolean.FALSE);
            Object systemService = context.getSystemService("clipboard");
            ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
            String string = (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || (itemAt = primaryClip.getItemAt(0)) == null || (text = itemAt.getText()) == null) ? null : text.toString();
            if (string == null) {
                string = "";
            }
            if (StringsKt.a0(string, "https://appblock.sng.link/Excv6/h4ml/tapd", false, 2, null)) {
                AnswersHelper.f128199a.W1("clipboard");
                function1.invoke(PremiumScreenViewEvent.OnShared.f112361a);
                guestPassShareActivity.Z0(navHostController, list, function1);
            } else {
                AnswersHelper.f128199a.T1();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult F0(final MutableState mutableState, final Context context, final GuestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1 guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1, final DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity$CommandProcessor$lambda$3$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    try {
                        Result.Companion companion = Result.f139772b;
                        context.unregisterReceiver(guestPassShareActivity$CommandProcessor$applicationSelectedBroadcastReceiver$1$1);
                        Result.b(Unit.f139807a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.f139772b;
                        Result.b(ResultKt.a(th));
                    }
                    mutableState.setValue(Boolean.FALSE);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(GuestPassShareActivity guestPassShareActivity, GuestPassShareViewModel guestPassShareViewModel, NavHostController navHostController, List list, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        guestPassShareActivity.D0(guestPassShareViewModel, navHostController, list, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void H0(final androidx.navigation.NavHostController r22, final java.util.List r23, androidx.compose.ui.Modifier r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity.H0(androidx.navigation.NavHostController, java.util.List, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(List list, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final GuestPassShareFlowStep guestPassShareFlowStep = (GuestPassShareFlowStep) it.next();
            NavGraphBuilderKt.c(NavHost, guestPassShareFlowStep.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-2000051593, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.v
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return GuestPassShareActivity.J0(guestPassShareFlowStep, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }), 254, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(GuestPassShareFlowStep guestPassShareFlowStep, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(578746896, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity.GuestPassFlowHost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GuestPassShareActivity.kt:245)");
            }
            switch (WhenMappings.f107457a[guestPassShareFlowStep.ordinal()]) {
                case 1:
                    composer.a0(2124990146);
                    GuestPassShareContentComponentsKt.k(composer, 0);
                    composer.U();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    composer.a0(2125003815);
                    GuestPassShareContentComponentsKt.t(composer, 0);
                    composer.U();
                    break;
                case 7:
                    composer.a0(2125007173);
                    GuestPassShareContentComponentsKt.p(composer, 0);
                    composer.U();
                    break;
                default:
                    composer.a0(2124987646);
                    composer.U();
                    throw new NoWhenBranchMatchedException();
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
    public static final Unit L0(GuestPassShareActivity guestPassShareActivity, NavHostController navHostController, List list, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        guestPassShareActivity.H0(navHostController, list, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder M0(GuestPassShareFlowScenario guestPassShareFlowScenario) {
        return ParametersHolderKt.b(Boolean.valueOf(guestPassShareFlowScenario.getSteps().contains(GuestPassShareFlowStep.ActivateReceivedGuestPass)));
    }

    private static final NavBackStackEntry N0(State state) {
        return (NavBackStackEntry) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(final Function1 function1, final GuestPassShareFlowStep guestPassShareFlowStep, final Context context, final GuestPassShareActivity guestPassShareActivity, final NavHostController navHostController, final List list, final PremiumScreenViewState premiumScreenViewState, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-599170653, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity.RootCompose.<anonymous> (GuestPassShareActivity.kt:112)");
            }
            ScaffoldKt.a(null, ComposableLambdaKt.e(-325301921, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GuestPassShareActivity.P0(function1, guestPassShareFlowStep, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.e(268186750, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.f0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GuestPassShareActivity.R0(guestPassShareFlowStep, context, function1, guestPassShareActivity, navHostController, list, premiumScreenViewState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, Color.f25715b.j(), 0L, null, ComposableLambdaKt.e(-1561282828, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GuestPassShareActivity.U0(this.f107501a, navHostController, list, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 806879664, 441);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(final Function1 function1, GuestPassShareFlowStep guestPassShareFlowStep, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-325301921, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity.RootCompose.<anonymous>.<anonymous> (GuestPassShareActivity.kt:115)");
            }
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GuestPassShareActivity.Q0(function1);
                    }
                };
                composer.w(objG);
            }
            ToolbarKt.e(null, (Function0) objG, null, guestPassShareFlowStep.getShowCloseButton(), ToolbarButtonType.Close, false, false, null, null, composer, 24576, 485);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(Function1 function1) {
        function1.invoke(PremiumScreenViewEvent.OnFinishClicked.f112352a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(final GuestPassShareFlowStep guestPassShareFlowStep, final Context context, final Function1 function1, final GuestPassShareActivity guestPassShareActivity, final NavHostController navHostController, final List list, PremiumScreenViewState premiumScreenViewState, Composer composer, int i3) {
        Composer composer2 = composer;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(268186750, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity.RootCompose.<anonymous>.<anonymous> (GuestPassShareActivity.kt:124)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 24;
            Modifier modifierK = PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierK);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            String strB = StringResources_androidKt.b(guestPassShareFlowStep.getBottomButtonState().getText(), composer2, 0);
            Integer iconRes = guestPassShareFlowStep.getBottomButtonState().getIconRes();
            boolean zI = composer2.I(context) | composer2.Z(function1) | composer2.e(guestPassShareFlowStep.ordinal()) | composer2.I(guestPassShareActivity) | composer2.I(navHostController) | composer2.I(list);
            Object objG = composer2.G();
            if (zI || objG == Composer.f23746a.a()) {
                Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GuestPassShareActivity.S0(context, guestPassShareFlowStep, guestPassShareActivity, navHostController, list, function1);
                    }
                };
                composer2.w(function0);
                objG = function0;
            }
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, primary, null, strB, null, 0L, iconRes, null, false, false, (Function0) objG, composer2, 24576, 0, 7599);
            Modifier.Companion companion3 = companion;
            char c3 = 6;
            SpacerKt.a(SizeKt.v(companion3, Dp.g(f3)), composer2, 6);
            Integer secondaryButtonText = guestPassShareFlowStep.getSecondaryButtonText();
            if (secondaryButtonText == null) {
                composer2.a0(-1724994360);
            } else {
                composer2.a0(-1724994359);
                int iIntValue = secondaryButtonText.intValue();
                FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
                String strB2 = StringResources_androidKt.b(iIntValue, composer2, 0);
                boolean Z = composer2.Z(function1);
                Object objG2 = composer2.G();
                if (Z || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.r
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return GuestPassShareActivity.T0(function1);
                        }
                    };
                    composer2.w(objG2);
                }
                FlatButtonsKt.u(null, 0.0f, 0.0f, null, secondary, null, strB2, null, 0L, null, null, false, false, (Function0) objG2, composer2, 805330944, 0, 7599);
                companion3 = companion3;
                c3 = 6;
                SpacerKt.a(SizeKt.v(companion3, Dp.g(f3)), composer2, 6);
            }
            composer2.U();
            if (guestPassShareFlowStep.getBottomButtonState() == GuestPassShareBottomButtonState.ActivateGuestPass) {
                composer2.a0(360022440);
                PremiumOptionDTO premiumOptionDTOD = premiumScreenViewState.D();
                String strA = premiumOptionDTOD != null ? premiumOptionDTOD.a() : null;
                if (strA == null) {
                    composer2.a0(-1724206247);
                } else {
                    composer2.a0(-1724206246);
                    TextKt.c(StringHelperExtKt.p(StringHelperExtKt.q(StringResources_androidKt.c(R.string.Ae, new Object[]{Integer.valueOf(premiumScreenViewState.Q())}, composer2, 0), StringResources_androidKt.c(R.string.lq, new Object[]{strA}, composer2, 0), null, 2, null), StringResources_androidKt.b(R.string.P4, composer2, 0), ". "), SizeKt.h(companion3, 0.0f, 1, null), ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer, 48, 0, 65016);
                    composer2 = composer;
                    SpacerKt.a(SizeKt.v(companion3, Dp.g(f3)), composer2, 6);
                }
                composer2.U();
            } else {
                composer2.a0(-1732040070);
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(Context context, GuestPassShareFlowStep guestPassShareFlowStep, GuestPassShareActivity guestPassShareActivity, NavHostController navHostController, List list, Function1 function1) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            function1.invoke(guestPassShareFlowStep.getPrimaryActionEvent().invoke(activityB));
        }
        if (guestPassShareFlowStep.getNavigatesImmediately()) {
            guestPassShareActivity.Z0(navHostController, list, function1);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(Function1 function1) {
        function1.invoke(PremiumScreenViewEvent.OnFinishClicked.f112352a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(GuestPassShareActivity guestPassShareActivity, NavHostController navHostController, List list, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1561282828, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity.RootCompose.<anonymous>.<anonymous> (GuestPassShareActivity.kt:171)");
            }
            guestPassShareActivity.H0(navHostController, list, PaddingKt.h(Modifier.b8, it), composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(GuestPassShareActivity guestPassShareActivity, NavHostController navHostController, List list, Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        guestPassShareActivity.Z0(navHostController, list, function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(GuestPassShareActivity guestPassShareActivity) {
        guestPassShareActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(GuestPassShareActivity guestPassShareActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        guestPassShareActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(NavHostController navHostController, List list, Function1 function1) {
        NavDestination navDestinationD;
        NavBackStackEntry navBackStackEntryT = navHostController.t();
        String strT = (navBackStackEntryT == null || (navDestinationD = navBackStackEntryT.d()) == null) ? null : navDestinationD.t();
        Iterator it = list.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(((GuestPassShareFlowStep) it.next()).getRoute(), strT)) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 < 0 || i3 >= list.size() || i3 >= CollectionsKt.getLastIndex(list)) {
            function1.invoke(PremiumScreenViewEvent.OnFinishClicked.f112352a);
        } else {
            NavController.P(navHostController, ((GuestPassShareFlowStep) list.get(i3 + 1)).getRoute(), null, null, 6, null);
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Object obj;
        Object guestPassShareActivity$RootCompose$2$1;
        int i5;
        NavDestination navDestinationD;
        Bundle bundleB;
        final GuestPassShareActivity guestPassShareActivity = this;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(1817372693);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(guestPassShareActivity) ? 32 : 16;
        }
        int i6 = i4;
        if (composerK.r((i6 & 19) != 18, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1817372693, i6, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity.RootCompose (GuestPassShareActivity.kt:88)");
            }
            final GuestPassShareFlowScenario guestPassShareFlowScenarioA = GuestPassShareFlowScenario.Companion.a(guestPassShareActivity.getIntent().getStringExtra("extra_flow_scenario"));
            boolean zE = composerK.e(guestPassShareFlowScenarioA.ordinal());
            Object objG = composerK.G();
            if (zE || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GuestPassShareActivity.M0(guestPassShareFlowScenarioA);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(GuestPassShareViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            GuestPassShareViewModel guestPassShareViewModel = (GuestPassShareViewModel) viewModelA;
            final PremiumScreenViewState premiumScreenViewState = (PremiumScreenViewState) FlowExtKt.m(guestPassShareViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(guestPassShareViewModel, composerK, 0);
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final List<GuestPassShareFlowStep> steps = guestPassShareFlowScenarioA.getSteps();
            GuestPassShareFlowStep guestPassShareFlowStep = (GuestPassShareFlowStep) CollectionsKt.first((List) steps);
            NavBackStackEntry navBackStackEntryN0 = N0(NavHostControllerKt.a(navHostControllerB, composerK, 0));
            String strT = (navBackStackEntryN0 == null || (navDestinationD = navBackStackEntryN0.d()) == null) ? null : navDestinationD.t();
            Iterator<T> it = steps.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((GuestPassShareFlowStep) next).getRoute(), strT)) {
                    obj = next;
                    break;
                }
            }
            GuestPassShareFlowStep guestPassShareFlowStep2 = (GuestPassShareFlowStep) obj;
            if (guestPassShareFlowStep2 != null) {
                guestPassShareFlowStep = guestPassShareFlowStep2;
            }
            final GuestPassShareFlowStep guestPassShareFlowStep3 = guestPassShareFlowStep;
            ComposeBackgroundKt.m(WindowInsetsPaddingKt.d(PaddingKt.h(Modifier.b8, paddingValues), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6)), false, false, false, null, 0L, null, ComposableLambdaKt.e(-599170653, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.x
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return GuestPassShareActivity.O0(function1N, guestPassShareFlowStep3, context, guestPassShareActivity, navHostControllerB, steps, premiumScreenViewState, (BoxScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), composerK, 12582912, 126);
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean zI = composerK.I(guestPassShareActivity) | composerK.I(navHostControllerB) | composerK.I(steps) | composerK.Z(function1N);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return GuestPassShareActivity.V0(this.f107533a, navHostControllerB, steps, function1N, (ActivityResult) obj2);
                    }
                };
                composerK.w(objG2);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG2, composerK, 0);
            PurchaseSuccessDTO purchaseSuccessDTOY = premiumScreenViewState.y();
            boolean Z = composerK.Z(premiumScreenViewState) | composerK.I(context) | composerK.I(managedActivityResultLauncherA) | composerK.I(guestPassShareActivity) | composerK.I(navHostControllerB) | composerK.I(steps) | composerK.Z(function1N);
            Object objG3 = composerK.G();
            if (Z || objG3 == Composer.f23746a.a()) {
                i5 = 0;
                guestPassShareActivity$RootCompose$2$1 = new GuestPassShareActivity$RootCompose$2$1(premiumScreenViewState, context, managedActivityResultLauncherA, guestPassShareActivity, navHostControllerB, steps, function1N, null);
                composerK.w(guestPassShareActivity$RootCompose$2$1);
            } else {
                i5 = 0;
                guestPassShareActivity$RootCompose$2$1 = objG3;
            }
            EffectsKt.g(purchaseSuccessDTOY, (Function2) guestPassShareActivity$RootCompose$2$1, composerK, i5);
            boolean zI2 = composerK.I(guestPassShareActivity);
            Object objG4 = composerK.G();
            if (zI2 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GuestPassShareActivity.W0(this.f107537a);
                    }
                };
                composerK.w(objG4);
            }
            guestPassShareActivity.D0(guestPassShareViewModel, navHostControllerB, steps, function1N, (Function0) objG4, composerK, (i6 << 12) & 458752);
            guestPassShareActivity = guestPassShareActivity;
            composer2 = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return GuestPassShareActivity.X0(this.f107460a, paddingValues, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    protected boolean f0() {
        return this.f107430f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(final GuestPassShareFlowStep guestPassShareFlowStep, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-2000051593, i3, -1, KLAQHFCRAUejH.CqbwHhwkbSf);
        }
        GuestPassBaseScreenKt.b(guestPassShareFlowStep.getTitle(), guestPassShareFlowStep.getSubtitle(), ComposableLambdaKt.e(578746896, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.guestpassshare.w
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return GuestPassShareActivity.K0(guestPassShareFlowStep, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, 384);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }
}
