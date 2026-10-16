package cz.mobilesoft.appblock.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
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
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.appblock.util.ServiceHelper;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreenKt;
import cz.mobilesoft.coreblock.scene.lockscreen.LockOverlayIntentState;
import cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewModel;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.IntentExtensionsKt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.context.GlobalContext;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

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
public final class OverlayServiceV2 extends LifecycleService implements SavedStateRegistryOwner, ViewModelStoreOwner, KoinComponent {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Companion f94628v = new Companion(null);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f94629w = 8;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static volatile WeakReference f94630x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f94631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SavedStateRegistryController f94632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ViewModelStore f94633d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f94634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f94635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WindowManager f94636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f94637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LockScreenProviderV2 f94638j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f94639k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f94640l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private UrlDto f94641m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Long f94642n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ProfileWithConfiguration f94643o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private UsageLimit.PeriodType f94644p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f94645q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private StrictModeOption f94646r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f94647s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f94648t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f94649u;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Context context, String str, UrlDto urlDto, Long l3, ProfileWithConfiguration profileWithConfiguration, UsageLimit.PeriodType periodType, String str2, StrictModeOption strictModeOption, boolean z2, Boolean bool, boolean z3, int i3, Object obj) {
            if ((i3 & 64) != 0) {
                str2 = null;
            }
            if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                strictModeOption = null;
            }
            if ((i3 & Function.MAX_NARGS) != 0) {
                z2 = false;
            }
            if ((i3 & 512) != 0) {
                bool = Boolean.FALSE;
            }
            if ((i3 & 1024) != 0) {
                z3 = false;
            }
            companion.a(context, str, urlDto, l3, profileWithConfiguration, periodType, str2, strictModeOption, z2, bool, z3);
        }

        public final void a(Context context, String packageName, UrlDto urlDto, Long l3, ProfileWithConfiguration profile, UsageLimit.PeriodType periodType, String str, StrictModeOption strictModeOption, boolean z2, Boolean bool, boolean z3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            Intrinsics.checkNotNullParameter(profile, "profile");
            Log.d(OverlayServiceV2.class.getName(), "show() called for package: " + packageName + ", url: " + (urlDto != null ? urlDto.getUrl() : null));
            Intent intent = new Intent(context, (Class<?>) OverlayServiceV2.class);
            try {
                context.stopService(intent);
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
            intent.putExtra("PACKAGE_NAME", packageName);
            if (urlDto != null) {
                IntentExtensionsKt.b(intent, "URL", urlDto);
            }
            if (l3 != null) {
                intent.putExtra("BLOCK_UNTIL", l3.longValue());
            }
            intent.putExtra("PROFILE", profile);
            if (periodType != null) {
                IntentExtensionsKt.b(intent, "USAGE_PERIOD_TYPE", periodType);
            }
            intent.putExtra("BLOCKING_SCREEN_CUSTOM_TITLE", str);
            if (strictModeOption != null) {
                IntentExtensionsKt.b(intent, "STRICT_MODE_OPTION", strictModeOption);
            }
            intent.putExtra("IS_UNSUPPORTED_BROWSER", z2);
            intent.putExtra("IS_USAGE_LIMIT_RAN_OUT", bool);
            intent.putExtra("IS_POPUP", z3);
            try {
                context.startService(intent);
            } catch (Exception e4) {
                CrashHelper.j(e4);
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OverlayServiceV2() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94631b = LazyKt.a(lazyThreadSafetyModeB, new Function0<EventDataStore>() { // from class: cz.mobilesoft.appblock.service.OverlayServiceV2$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), qualifier, objArr);
            }
        });
        this.f94632c = SavedStateRegistryController.f53001c.b(this);
        this.f94633d = new ViewModelStore();
    }

    private final void C() {
        Log.d(OverlayServiceV2.class.getName(), "addOverlayView() called");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, 67328, -3);
        layoutParams.gravity = 8388627;
        layoutParams.x = 0;
        layoutParams.y = 0;
        if ((getResources().getConfiguration().screenLayout & 15) < 3) {
            layoutParams.screenOrientation = 1;
        }
        final Function0 function0 = new Function0() { // from class: cz.mobilesoft.appblock.service.k1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OverlayServiceV2.D(this.f94754a);
            }
        };
        final Function1 function1 = new Function1() { // from class: cz.mobilesoft.appblock.service.l1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OverlayServiceV2.E(this.f94757a, (LockScreenProviderV2) obj);
            }
        };
        ComposeView composeView = new ComposeView(this, null, 0, 6, null);
        if (Build.VERSION.SDK_INT >= 29) {
            composeView.setForceDarkAllowed(false);
        }
        ViewTreeSavedStateRegistryOwner.b(composeView, this);
        ViewTreeLifecycleOwner.b(composeView, this);
        ViewTreeViewModelStoreOwner.b(composeView, this);
        composeView.setContent(ComposableLambdaKt.c(35385912, true, new Function2() { // from class: cz.mobilesoft.appblock.service.m1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return OverlayServiceV2.F(this.f95053a, function0, function1, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        try {
            WindowManager windowManager = this.f94636h;
            if (windowManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                windowManager = null;
            }
            windowManager.addView(composeView, layoutParams);
            this.f94637i = composeView;
            f94630x = new WeakReference(composeView);
            Log.d(OverlayServiceV2.class.getName(), "Overlay view successfully added to window manager");
        } catch (IllegalStateException e3) {
            Log.e(OverlayServiceV2.class.getName(), "Failed to add overlay view: IllegalStateException", e3);
            CrashHelper.j(e3);
            this.f94637i = null;
            WeakReference weakReference = f94630x;
            if (weakReference != null) {
                weakReference.clear();
            }
            K(this, this.f94638j, false, null, false, false, false, 60, null);
        } catch (Exception e4) {
            Log.e(OverlayServiceV2.class.getName(), "Failed to add overlay view: " + e4.getClass().getSimpleName(), e4);
            CrashHelper.j(e4);
            this.f94637i = null;
            WeakReference weakReference2 = f94630x;
            if (weakReference2 != null) {
                weakReference2.clear();
            }
            stopSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockOverlayIntentState D(OverlayServiceV2 overlayServiceV2) {
        Profile profileP;
        String name = OverlayServiceV2.class.getName();
        String str = overlayServiceV2.f94640l;
        UrlDto urlDto = overlayServiceV2.f94641m;
        String strA = null;
        String url = urlDto != null ? urlDto.getUrl() : null;
        ProfileWithConfiguration profileWithConfiguration = overlayServiceV2.f94643o;
        if (profileWithConfiguration != null && (profileP = profileWithConfiguration.p()) != null) {
            strA = profileP.A();
        }
        Log.d(name, "Creating LockOverlayIntentState with package=" + str + ", url=" + url + ", profile=" + strA);
        return new LockOverlayIntentState(overlayServiceV2.f94640l, overlayServiceV2.f94641m, overlayServiceV2.f94642n, overlayServiceV2.f94644p, overlayServiceV2.f94643o, overlayServiceV2.f94645q, overlayServiceV2.f94646r, overlayServiceV2.f94647s, overlayServiceV2.f94648t, overlayServiceV2.f94649u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(OverlayServiceV2 overlayServiceV2, LockScreenProviderV2 lockScreenProviderV2) {
        overlayServiceV2.f94638j = lockScreenProviderV2;
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(final OverlayServiceV2 overlayServiceV2, final Function0 function0, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(35385912, i3, -1, "cz.mobilesoft.appblock.service.OverlayServiceV2.addOverlayView.<anonymous>.<anonymous> (OverlayServiceV2.kt:398)");
            }
            ComposableExtKt.n(null, ComposableLambdaKt.e(-1249613521, true, new Function2() { // from class: cz.mobilesoft.appblock.service.n1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OverlayServiceV2.G(this.f95056a, function0, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(final OverlayServiceV2 overlayServiceV2, final Function0 function0, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1249613521, i3, -1, "cz.mobilesoft.appblock.service.OverlayServiceV2.addOverlayView.<anonymous>.<anonymous>.<anonymous> (OverlayServiceV2.kt:399)");
            }
            ComposeThemesKt.b(null, ComposableLambdaKt.e(1504260512, true, new Function2() { // from class: cz.mobilesoft.appblock.service.o1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OverlayServiceV2.H(this.f95061a, function0, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(OverlayServiceV2 overlayServiceV2, Function0 function0, Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1504260512, i3, -1, "cz.mobilesoft.appblock.service.OverlayServiceV2.addOverlayView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (OverlayServiceV2.kt:400)");
            }
            composer.F(-101221098);
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(overlayServiceV2, composer, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composer.F(-1072256281);
            KClass kClassB = Reflection.b(LockViewModel.class);
            ViewModelStore viewModelStore = overlayServiceV2.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA, null, scopeD, null);
            composer.Y();
            composer.Y();
            overlayServiceV2.s((LockViewModel) viewModelA, function0, function1, composer, LockViewModel.f105476u);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private final void I(View view) {
        if (Build.VERSION.SDK_INT <= 28) {
            view.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c8 A[PHI: r6
      0x00c8: PHI (r6v17 java.lang.ref.WeakReference) = (r6v19 java.lang.ref.WeakReference), (r6v23 java.lang.ref.WeakReference) binds: [B:58:0x00d7, B:53:0x00c6] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void J(cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2 r6, boolean r7, cz.mobilesoft.coreblock.enums.ContactReason r8, boolean r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.OverlayServiceV2.J(cz.mobilesoft.coreblock.scene.lockscreen.provider.LockScreenProviderV2, boolean, cz.mobilesoft.coreblock.enums.ContactReason, boolean, boolean, boolean):void");
    }

    static /* synthetic */ void K(OverlayServiceV2 overlayServiceV2, LockScreenProviderV2 lockScreenProviderV2, boolean z2, ContactReason contactReason, boolean z3, boolean z4, boolean z5, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            contactReason = null;
        }
        overlayServiceV2.J(lockScreenProviderV2, z2, contactReason, (i3 & 8) != 0 ? false : z3, (i3 & 16) != 0 ? false : z4, (i3 & 32) != 0 ? false : z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore L() {
        return (EventDataStore) this.f94631b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(OverlayServiceV2 overlayServiceV2) {
        CoroutinesHelperExtKt.d(new OverlayServiceV2$onStartCommand$2$1(overlayServiceV2, null));
    }

    private final void q(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final LockViewModel lockViewModel, final ScaffoldState scaffoldState, Composer composer, final int i3) {
        MutableState mutableState4;
        int i4;
        MutableState mutableState5;
        ScaffoldState scaffoldState2;
        Composer composer2;
        Composer composerK = composer.k(566103960);
        if ((i3 & 6) == 0) {
            mutableState4 = mutableState;
            i4 = (composerK.Z(mutableState4) ? 4 : 2) | i3;
        } else {
            mutableState4 = mutableState;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            mutableState5 = mutableState2;
            i4 |= composerK.Z(mutableState5) ? 32 : 16;
        } else {
            mutableState5 = mutableState2;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(mutableState3) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= (i3 & 4096) == 0 ? composerK.Z(lockViewModel) : composerK.I(lockViewModel) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            scaffoldState2 = scaffoldState;
            i4 |= composerK.Z(scaffoldState2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            scaffoldState2 = scaffoldState;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(this) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i5 = i4;
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(566103960, i5, -1, "cz.mobilesoft.appblock.service.OverlayServiceV2.CommandProcessor (OverlayServiceV2.kt:544)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            boolean zI = ((i5 & 14) == 4) | ((i5 & 7168) == 2048 || ((i5 & 4096) != 0 && composerK.I(lockViewModel))) | composerK.I(this) | ((i5 & 896) == 256) | ((i5 & 112) == 32) | composerK.I(coroutineScope) | ((57344 & i5) == 16384);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                OverlayServiceV2$CommandProcessor$1$1 overlayServiceV2$CommandProcessor$1$1 = new OverlayServiceV2$CommandProcessor$1$1(this, lockViewModel, mutableState4, mutableState3, mutableState5, coroutineScope, scaffoldState2, null);
                composerK.w(overlayServiceV2$CommandProcessor$1$1);
                objG2 = overlayServiceV2$CommandProcessor$1$1;
            }
            composer2 = composerK;
            FlowExtKt.g(lockViewModel, this, (Function2) objG2, composer2, LockViewModel.f105476u | ((i5 >> 9) & 14) | ((i5 >> 12) & 112), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.appblock.service.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OverlayServiceV2.r(this.f94732a, mutableState, mutableState2, mutableState3, lockViewModel, scaffoldState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(OverlayServiceV2 overlayServiceV2, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, LockViewModel lockViewModel, ScaffoldState scaffoldState, int i3, Composer composer, int i4) {
        overlayServiceV2.q(mutableState, mutableState2, mutableState3, lockViewModel, scaffoldState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void s(final LockViewModel lockViewModel, final Function0 function0, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Function0 function02;
        Function1 function12;
        final OverlayServiceV2 overlayServiceV2;
        Composer composer2;
        int i5;
        Unit unit;
        final LockViewState lockViewState;
        Function1 function13;
        Composer composerK = composer.k(1341382221);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(lockViewModel) : composerK.I(lockViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            function02 = function0;
            i4 |= composerK.I(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        if ((i3 & 384) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function12 = function1;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(this) ? 2048 : 1024;
        }
        int i6 = i4;
        if (composerK.r((i6 & 1171) != 1170, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1341382221, i6, -1, "cz.mobilesoft.appblock.service.OverlayServiceV2.LockScreen (OverlayServiceV2.kt:436)");
            }
            int i7 = LockViewModel.f105476u;
            int i8 = i6 & 14;
            LockViewState lockViewState2 = (LockViewState) FlowExtKt.m(lockViewModel, composerK, i7 | i8);
            Function1 function1N = FlowExtKt.n(lockViewModel, composerK, i7 | i8);
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                MutableState mutableStateE = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(mutableStateE);
                objG2 = mutableStateE;
            }
            MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState3 = (MutableState) objG3;
            Unit unit2 = Unit.f139807a;
            boolean Z = ((i6 & 112) == 32) | composerK.Z(function1N) | ((i6 & 896) == 256) | (i8 == 4 || ((i6 & 8) != 0 && composerK.I(lockViewModel)));
            Object objG4 = composerK.G();
            if (Z || objG4 == companion.a()) {
                Function1 function14 = function12;
                i5 = i8;
                unit = unit2;
                lockViewState = lockViewState2;
                function13 = function1N;
                OverlayServiceV2$LockScreen$1$1 overlayServiceV2$LockScreen$1$1 = new OverlayServiceV2$LockScreen$1$1(function13, function02, function14, lockViewModel, null);
                composerK.w(overlayServiceV2$LockScreen$1$1);
                objG4 = overlayServiceV2$LockScreen$1$1;
            } else {
                lockViewState = lockViewState2;
                function13 = function1N;
                i5 = i8;
                unit = unit2;
            }
            EffectsKt.g(unit, (Function2) objG4, composerK, 6);
            final Function1 function15 = function13;
            q(mutableState, mutableState2, mutableState3, lockViewModel, scaffoldStateG, composerK, (i7 << 9) | 438 | ((i6 << 9) & 7168) | ((i6 << 6) & 458752));
            boolean Z2 = composerK.Z(lockViewState) | composerK.I(this);
            Object objG5 = composerK.G();
            if (Z2 || objG5 == companion.a()) {
                objG5 = new Function2() { // from class: cz.mobilesoft.appblock.service.p1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OverlayServiceV2.t(lockViewState, this, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composerK.w(objG5);
            }
            ComposableExtKt.j(null, (Function2) objG5, composerK, 0, 1);
            LockViewState lockViewState3 = lockViewState;
            int i9 = i5;
            ScaffoldKt.a(null, scaffoldStateG, null, null, ComposableSingletons$OverlayServiceV2Kt.f94133a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-2032855089, true, new Function3() { // from class: cz.mobilesoft.appblock.service.q1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OverlayServiceV2.u(this.f95068a, lockViewState, function15, mutableState3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 24576, 12582912, 131053);
            composer2 = composerK;
            Object value = mutableState.getValue();
            boolean zI = composer2.I(this) | composer2.Z(lockViewState3) | (i9 == 4 || ((i6 & 8) != 0 && composer2.I(lockViewModel)));
            Object objG6 = composer2.G();
            if (zI || objG6 == companion.a()) {
                OverlayServiceV2$LockScreen$4$1 overlayServiceV2$LockScreen$4$1 = new OverlayServiceV2$LockScreen$4$1(mutableState, this, lockViewState3, lockViewModel, null);
                overlayServiceV2 = this;
                composer2.w(overlayServiceV2$LockScreen$4$1);
                objG6 = overlayServiceV2$LockScreen$4$1;
            } else {
                overlayServiceV2 = this;
            }
            EffectsKt.g(value, (Function2) objG6, composer2, 0);
            Object value2 = mutableState2.getValue();
            boolean zI2 = composer2.I(overlayServiceV2) | composer2.Z(function15);
            Object objG7 = composer2.G();
            if (zI2 || objG7 == companion.a()) {
                objG7 = new OverlayServiceV2$LockScreen$5$1(mutableState2, overlayServiceV2, function15, null);
                composer2.w(objG7);
            }
            EffectsKt.g(value2, (Function2) objG7, composer2, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            overlayServiceV2 = this;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.appblock.service.r1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OverlayServiceV2.x(this.f95074a, lockViewModel, function0, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(LockViewState lockViewState, OverlayServiceV2 overlayServiceV2, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME && lockViewState.m()) {
            ServiceHelper.f95139a.b(overlayServiceV2);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(OverlayServiceV2 overlayServiceV2, final LockViewState lockViewState, final Function1 function1, final MutableState mutableState, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = (composer.Z(it) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2032855089, i4, -1, "cz.mobilesoft.appblock.service.OverlayServiceV2.LockScreen.<anonymous> (OverlayServiceV2.kt:474)");
            }
            if (overlayServiceV2.f94646r != null || overlayServiceV2.f94647s || overlayServiceV2.f94649u) {
                composer.a0(-1746932075);
                ExplanationLockScreenKt.q(lockViewState, function1, overlayServiceV2.f94646r != null, overlayServiceV2.f94649u, RunnabilityHelper.f129617a.x(), composer, 0, 0);
                if (((Boolean) mutableState.getValue()).booleanValue()) {
                    composer.a0(-1746437005);
                    Object objG = composer.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG == companion.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.appblock.service.h1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OverlayServiceV2.v(mutableState);
                            }
                        };
                        composer.w(objG);
                    }
                    Function0 function0 = (Function0) objG;
                    boolean Z = composer.Z(function1) | composer.Z(lockViewState);
                    Object objG2 = composer.G();
                    if (Z || objG2 == companion.a()) {
                        objG2 = new Function0() { // from class: cz.mobilesoft.appblock.service.i1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return OverlayServiceV2.w(function1, lockViewState, mutableState);
                            }
                        };
                        composer.w(objG2);
                    }
                    ComposeDialogsKt.j0(function0, (Function0) objG2, composer, 6);
                } else {
                    composer.a0(-1767603309);
                }
                composer.U();
                composer.U();
            } else {
                composer.a0(-1745790221);
                LockScreenKt.D(lockViewState, function1, false, false, it, composer, (i4 << 12) & 57344, 12);
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
    public static final Unit v(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function1 function1, LockViewState lockViewState, MutableState mutableState) {
        function1.invoke(new LockViewEvent.LockScreenExcludeBrowserClickEvent(lockViewState.h()));
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(OverlayServiceV2 overlayServiceV2, LockViewModel lockViewModel, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        overlayServiceV2.s(lockViewModel, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.f94632c.b();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return this.f94633d;
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(OverlayServiceV2.class.getName(), "onCreate was invoked");
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f94636h = (WindowManager) systemService;
        this.f94632c.c();
        this.f94632c.d(null);
        getLifecycle().addObserver(new LifecycleEventObserver() { // from class: cz.mobilesoft.appblock.service.OverlayServiceV2.onCreate.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void j(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    OverlayServiceV2.this.getViewModelStore().a();
                    source.getLifecycle().removeObserver(this);
                }
            }
        });
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        Log.d(OverlayServiceV2.class.getName(), "onDestroy was invoked");
        View view = this.f94637i;
        if (view != null) {
            try {
                I(view);
                ComposeView composeView = view instanceof ComposeView ? (ComposeView) view : null;
                if (composeView != null) {
                    composeView.disposeComposition();
                }
                WindowManager windowManager = this.f94636h;
                if (windowManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                    windowManager = null;
                }
                windowManager.removeView(view);
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
            this.f94637i = null;
        }
        WeakReference weakReference = f94630x;
        if (weakReference != null) {
            weakReference.clear();
        }
        super.onDestroy();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        OverlayServiceV2 overlayServiceV2;
        Parcelable parcelable;
        Parcelable parcelable2;
        Parcelable parcelable3;
        super.onStartCommand(intent, i3, i4);
        Log.d(OverlayServiceV2.class.getName(), "onStartCommand was invoked");
        if ((intent != null ? intent.getExtras() : null) != null) {
            String stringExtra = intent.getStringExtra("PACKAGE_NAME");
            this.f94640l = stringExtra;
            if (stringExtra == null) {
                K(this, this.f94638j, true, null, false, false, false, 60, null);
                return 2;
            }
            overlayServiceV2 = this;
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 33) {
                parcelable = (Parcelable) intent.getParcelableExtra("URL", UrlDto.class);
            } else {
                Parcelable parcelableExtra = intent.getParcelableExtra("URL");
                if (!(parcelableExtra instanceof UrlDto)) {
                    parcelableExtra = null;
                }
                parcelable = (UrlDto) parcelableExtra;
            }
            overlayServiceV2.f94641m = (UrlDto) parcelable;
            Long lValueOf = Long.valueOf(intent.getLongExtra("BLOCK_UNTIL", -1L));
            if (lValueOf.longValue() == -1) {
                lValueOf = null;
            }
            overlayServiceV2.f94642n = lValueOf;
            Serializable serializableExtra = intent.getSerializableExtra("PROFILE");
            overlayServiceV2.f94643o = serializableExtra instanceof ProfileWithConfiguration ? (ProfileWithConfiguration) serializableExtra : null;
            if (i5 >= 33) {
                parcelable2 = (Parcelable) intent.getParcelableExtra("USAGE_PERIOD_TYPE", UsageLimit.PeriodType.class);
            } else {
                Parcelable parcelableExtra2 = intent.getParcelableExtra("USAGE_PERIOD_TYPE");
                if (!(parcelableExtra2 instanceof UsageLimit.PeriodType)) {
                    parcelableExtra2 = null;
                }
                parcelable2 = (UsageLimit.PeriodType) parcelableExtra2;
            }
            overlayServiceV2.f94644p = (UsageLimit.PeriodType) parcelable2;
            overlayServiceV2.f94645q = intent.getStringExtra("BLOCKING_SCREEN_CUSTOM_TITLE");
            if (i5 >= 33) {
                parcelable3 = (Parcelable) intent.getParcelableExtra("STRICT_MODE_OPTION", StrictModeOption.class);
            } else {
                Parcelable parcelableExtra3 = intent.getParcelableExtra("STRICT_MODE_OPTION");
                if (!(parcelableExtra3 instanceof StrictModeOption)) {
                    parcelableExtra3 = null;
                }
                parcelable3 = (StrictModeOption) parcelableExtra3;
            }
            overlayServiceV2.f94646r = (StrictModeOption) parcelable3;
            overlayServiceV2.f94647s = intent.getBooleanExtra("IS_UNSUPPORTED_BROWSER", false);
            overlayServiceV2.f94648t = intent.getBooleanExtra("IS_USAGE_LIMIT_RAN_OUT", false);
            overlayServiceV2.f94649u = intent.getBooleanExtra("IS_POPUP", false);
            overlayServiceV2.f94639k = overlayServiceV2.f94641m != null;
            InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.appblock.service.j1
                @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
                public final void onInitialized() {
                    OverlayServiceV2.M(this.f94751a);
                }
            });
        } else {
            overlayServiceV2 = this;
        }
        WeakReference weakReference = f94630x;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null && !Intrinsics.areEqual(view, overlayServiceV2.f94637i)) {
            Log.d(OverlayServiceV2.class.getName(), "Old overlay view from previous instance found, removing it");
            try {
                I(view);
                ComposeView composeView = view instanceof ComposeView ? (ComposeView) view : null;
                if (composeView != null) {
                    composeView.disposeComposition();
                }
                WindowManager windowManager = overlayServiceV2.f94636h;
                if (windowManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                    windowManager = null;
                }
                windowManager.removeView(view);
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
            WeakReference weakReference2 = f94630x;
            if (weakReference2 != null) {
                weakReference2.clear();
            }
        }
        View view2 = overlayServiceV2.f94637i;
        if (view2 != null) {
            Log.d(OverlayServiceV2.class.getName(), "Cleaning up existing overlay view from current instance");
            try {
                I(view2);
                ComposeView composeView2 = view2 instanceof ComposeView ? (ComposeView) view2 : null;
                if (composeView2 != null) {
                    composeView2.disposeComposition();
                }
                WindowManager windowManager2 = overlayServiceV2.f94636h;
                if (windowManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                    windowManager2 = null;
                }
                windowManager2.removeView(view2);
            } catch (Exception e4) {
                CrashHelper.j(e4);
            }
            overlayServiceV2.f94637i = null;
        }
        try {
            C();
        } catch (WindowManager.BadTokenException e5) {
            CrashHelper.j(e5);
            stopSelf();
        }
        return 2;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
