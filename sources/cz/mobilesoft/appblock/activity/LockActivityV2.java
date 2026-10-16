package cz.mobilesoft.appblock.activity;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.ShareConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.appblock.util.ServiceHelper;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorFeedbackActivity;
import cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.IntentExtensionsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.context.GlobalContext;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LockActivityV2 extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f93943g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f93944h = BaseComposeActivity.f96312d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function0 f93945f = new Function0() { // from class: cz.mobilesoft.appblock.activity.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return LockActivityV2.D0(this.f93963a);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, String packageName, Long l3, ProfileType profileType, String profileTitle, UsageLimit.PeriodType periodType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(profileType, "profileType");
            Intrinsics.checkNotNullParameter(profileTitle, "profileTitle");
            Intent intent = new Intent(context, (Class<?>) LockActivityV2.class);
            intent.setFlags(268468224);
            intent.putExtra("PACKAGE_NAME", packageName);
            intent.putExtra("BLOCK_UNTIL", l3 != null ? l3.longValue() : -1L);
            intent.putExtra(ShareConstants.TITLE, profileTitle);
            IntentExtensionsKt.b(intent, "PROFILE_TYPE", profileType);
            if (periodType != null) {
                IntentExtensionsKt.b(intent, "USAGE_PERIOD_TYPE", periodType);
            }
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(MutableState mutableState, Function1 function1, Context context, LockViewModel lockViewModel, Intent settingIntent) {
        Intrinsics.checkNotNullParameter(settingIntent, "settingIntent");
        mutableState.setValue(Boolean.FALSE);
        function1.invoke(LockViewEvent.LockScreenRequestCloseEvent.f105474a);
        context.startActivity(SystemSettingsActivity.f105722p.a(context, settingIntent, (String[]) lockViewModel.X0().toArray(new String[0])));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(MutableState mutableState, Function1 function1, Context context) {
        mutableState.setValue(Boolean.FALSE);
        function1.invoke(LockViewEvent.OnBackdoorDialogSuccess.f105475a);
        Intent intent = new Intent(context, (Class<?>) BackdoorFeedbackActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(LockActivityV2 lockActivityV2, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        lockActivityV2.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(LockActivityV2 lockActivityV2) {
        ServiceHelper.f95139a.c(lockActivityV2);
        return Unit.f139807a;
    }

    private final void u0(final LockViewModel lockViewModel, final MutableState mutableState, final MutableState mutableState2, final Function0 function0, final ScaffoldState scaffoldState, Composer composer, final int i3) {
        int i4;
        MutableState mutableState3;
        Function0 function02;
        ScaffoldState scaffoldState2;
        Composer composer2;
        Composer composerK = composer.k(-1697483749);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(lockViewModel) : composerK.I(lockViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(mutableState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            mutableState3 = mutableState2;
            i4 |= composerK.Z(mutableState3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            mutableState3 = mutableState2;
        }
        if ((i3 & 3072) == 0) {
            function02 = function0;
            i4 |= composerK.I(function02) ? 2048 : 1024;
        } else {
            function02 = function0;
        }
        if ((i3 & 24576) == 0) {
            scaffoldState2 = scaffoldState;
            i4 |= composerK.Z(scaffoldState2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            scaffoldState2 = scaffoldState;
        }
        if ((196608 & i3) == 0) {
            i4 |= (i3 & 262144) == 0 ? composerK.Z(this) : composerK.I(this) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i5 = i4;
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1697483749, i5, -1, "cz.mobilesoft.appblock.activity.LockActivityV2.CommandProcessor (LockActivityV2.kt:174)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            boolean zI = ((458752 & i5) == 131072 || ((i5 & 262144) != 0 && composerK.I(this))) | ((i5 & 7168) == 2048) | ((i5 & 112) == 32) | composerK.I(context) | ((i5 & 896) == 256) | composerK.I(coroutineScope) | ((57344 & i5) == 16384);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                LockActivityV2$CommandProcessor$1$1 lockActivityV2$CommandProcessor$1$1 = new LockActivityV2$CommandProcessor$1$1(this, mutableState, context, function02, mutableState3, coroutineScope, scaffoldState2, null);
                composerK.w(lockActivityV2$CommandProcessor$1$1);
                objG2 = lockActivityV2$CommandProcessor$1$1;
            }
            composer2 = composerK;
            FlowExtKt.g(lockViewModel, null, (Function2) objG2, composer2, LockViewModel.f105476u | (i5 & 14), 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.appblock.activity.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LockActivityV2.v0(this.f93980a, lockViewModel, mutableState, mutableState2, function0, scaffoldState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(LockActivityV2 lockActivityV2, LockViewModel lockViewModel, MutableState mutableState, MutableState mutableState2, Function0 function0, ScaffoldState scaffoldState, int i3, Composer composer, int i4) {
        lockActivityV2.u0(lockViewModel, mutableState, mutableState2, function0, scaffoldState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(final LockActivityV2 lockActivityV2, Composer composer, int i3) {
        final Context context;
        final Function1 function1;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1316999430, i3, -1, "cz.mobilesoft.appblock.activity.LockActivityV2.RootCompose.<anonymous> (LockActivityV2.kt:88)");
            }
            Context context2 = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            int i4 = BaseComposeActivity.f96312d;
            composer.F(-101221098);
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(lockActivityV2, composer, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composer.F(-1072256281);
            KClass kClassB = Reflection.b(LockViewModel.class);
            ViewModelStore viewModelStore = lockActivityV2.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA, null, scopeD, null);
            composer.Y();
            composer.Y();
            final LockViewModel lockViewModel = (LockViewModel) viewModelA;
            int i5 = LockViewModel.f105476u;
            final LockViewState lockViewState = (LockViewState) FlowExtKt.m(lockViewModel, composer, i5);
            final Function1 function1N = FlowExtKt.n(lockViewModel, composer, i5);
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composer.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composer.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            Unit unit = Unit.f139807a;
            boolean Z = composer.Z(function1N) | composer.I(lockActivityV2);
            Object objG3 = composer.G();
            if (Z || objG3 == companion.a()) {
                objG3 = new LockActivityV2$RootCompose$1$1$1(function1N, lockActivityV2, null);
                composer.w(objG3);
            }
            EffectsKt.g(unit, (Function2) objG3, composer, 6);
            boolean Z2 = composer.Z(function1N);
            Object objG4 = composer.G();
            if (Z2 || objG4 == companion.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.appblock.activity.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LockActivityV2.x0(function1N);
                    }
                };
                composer.w(objG4);
            }
            BackHandlerKt.a(false, (Function0) objG4, composer, 0, 1);
            lockActivityV2.u0(lockViewModel, mutableState, mutableState2, lockActivityV2.f93945f, scaffoldStateG, composer, (i4 << 15) | i5 | 432);
            boolean Z3 = composer.Z(lockViewState) | composer.I(lockActivityV2);
            Object objG5 = composer.G();
            if (Z3 || objG5 == companion.a()) {
                objG5 = new Function2() { // from class: cz.mobilesoft.appblock.activity.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LockActivityV2.y0(lockViewState, lockActivityV2, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composer.w(objG5);
            }
            ComposableExtKt.j(null, (Function2) objG5, composer, 0, 1);
            ScaffoldKt.a(null, scaffoldStateG, null, null, ComposableSingletons$LockActivityV2Kt.f93935a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-5859260, true, new Function3() { // from class: cz.mobilesoft.appblock.activity.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LockActivityV2.z0(lockViewState, function1N, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 24576, 12582912, 131053);
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composer.a0(205528120);
                Set setS = lockViewState.s();
                function1 = function1N;
                context = context2;
                boolean Z4 = composer.Z(function1) | composer.I(context) | composer.I(lockViewModel);
                Object objG6 = composer.G();
                if (Z4 || objG6 == companion.a()) {
                    objG6 = new Function1() { // from class: cz.mobilesoft.appblock.activity.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return LockActivityV2.A0(mutableState, function1, context, lockViewModel, (Intent) obj);
                        }
                    };
                    composer.w(objG6);
                }
                ComposeDialogsKt.g1(setS, (Function1) objG6, composer, 0);
            } else {
                context = context2;
                function1 = function1N;
                composer.a0(199528380);
            }
            composer.U();
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                composer.a0(206298594);
                BackdoorCodeDialog backdoorCodeDialog = new BackdoorCodeDialog(lockActivityV2, null, 2, null);
                boolean Z5 = composer.Z(function1) | composer.I(context);
                Object objG7 = composer.G();
                if (Z5 || objG7 == companion.a()) {
                    objG7 = new Function0() { // from class: cz.mobilesoft.appblock.activity.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LockActivityV2.B0(mutableState2, function1, context);
                        }
                    };
                    composer.w(objG7);
                }
                BackdoorCodeDialog.M(backdoorCodeDialog, (Function0) objG7, null, 2, null);
            } else {
                composer.a0(199528380);
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
    public static final Unit x0(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenBackToAppClickEvent.f105464a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(LockViewState lockViewState, LockActivityV2 lockActivityV2, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME && lockViewState.m()) {
            lockActivityV2.f93945f.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(LockViewState lockViewState, Function1 function1, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-5859260, i3, -1, "cz.mobilesoft.appblock.activity.LockActivityV2.RootCompose.<anonymous>.<anonymous> (LockActivityV2.kt:133)");
            }
            LockScreenKt.D(lockViewState, function1, false, false, it, composer, (i3 << 12) & 57344, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finishAndRemoveTask();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, KLAQHFCRAUejH.SgFAP);
        Composer composerK = composer.k(-1584369009);
        if ((i3 & 48) == 0) {
            i4 = ((i3 & 64) == 0 ? composerK.Z(this) : composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1584369009, i4, -1, "cz.mobilesoft.appblock.activity.LockActivityV2.RootCompose (LockActivityV2.kt:86)");
            }
            ComposableExtKt.n(null, ComposableLambdaKt.e(1316999430, true, new Function2() { // from class: cz.mobilesoft.appblock.activity.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LockActivityV2.w0(this.f93964a, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.appblock.activity.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LockActivityV2.C0(this.f93965a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
