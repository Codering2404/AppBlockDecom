package cz.mobilesoft.coreblock.scene.premium.superwall;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.facebook.ads.AdError;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity;
import cz.mobilesoft.coreblock.activity.rating.RatingTriggerSource;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareFlowScenario;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewEvent;
import cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewModel;
import cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewState;
import cz.mobilesoft.coreblock.scene.premium.trial_notifications.TrialRemindersActivity;
import cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivity;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
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
public final class SuperwallPlacementActivity extends ComponentActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f113783h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f113784i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f113785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ActivityResultLauncher f113786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ActivityResultLauncher f113787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ActivityResultLauncher f113788d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ActivityResultLauncher f113789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ActivityResultLauncher f113790g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, String placement, Bundle params, boolean z2, Intent intent, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(placement, "placement");
            Intrinsics.checkNotNullParameter(params, "params");
            Intent intent2 = new Intent(context, (Class<?>) SuperwallPlacementActivity.class);
            intent2.putExtra("EXTRA_SUPERWALL_PLACEMENT", placement);
            intent2.putExtra("EXTRA_SUPERWALL_PARAMS", params);
            intent2.putExtra("EXTRA_SUPERWALL_IS_HARD_PAYWALL", z2);
            intent2.putExtra("EXTRA_SUPERWALL_FALLBACK_INTENT", intent);
            intent2.putExtra("EXTRA_SUPERWALL_ANALYTICS", bundle);
            return intent2;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f113791a;

        static {
            int[] iArr = new int[SuperwallPlacementViewState.Step.values().length];
            try {
                iArr[SuperwallPlacementViewState.Step.Paywall.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SuperwallPlacementViewState.Step.SignIn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SuperwallPlacementViewState.Step.TrialReminders.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SuperwallPlacementViewState.Step.SubscriptionOnboarding.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SuperwallPlacementViewState.Step.GuestPassShare.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SuperwallPlacementViewState.Step.Fallback.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SuperwallPlacementViewState.Step.FinishSuccess.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[SuperwallPlacementViewState.Step.FinishCanceled.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f113791a = iArr;
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementActivity$onCreate$2", f = "SuperwallPlacementActivity.kt", l = {137}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f113793a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementActivity$onCreate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementActivity$onCreate$2$1", f = "SuperwallPlacementActivity.kt", l = {138}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f113795a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SuperwallPlacementActivity f113796b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SuperwallPlacementActivity superwallPlacementActivity, Continuation continuation) {
                super(2, continuation);
                this.f113796b = superwallPlacementActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass1(this.f113796b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f113795a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Flow flowM0 = this.f113796b.U().M0();
                    final SuperwallPlacementActivity superwallPlacementActivity = this.f113796b;
                    FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementActivity.onCreate.2.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public final Object emit(SuperwallPlacementViewState superwallPlacementViewState, Continuation continuation) {
                            superwallPlacementActivity.W(superwallPlacementViewState);
                            return Unit.f139807a;
                        }
                    };
                    this.f113795a = 1;
                    if (flowM0.collect(flowCollector, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return SuperwallPlacementActivity.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f113793a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SuperwallPlacementActivity superwallPlacementActivity = SuperwallPlacementActivity.this;
                Lifecycle.State state = Lifecycle.State.f39950d;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(superwallPlacementActivity, null);
                this.f113793a = 1;
                if (RepeatOnLifecycleKt.b(superwallPlacementActivity, state, anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SuperwallPlacementActivity() {
        final Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SuperwallPlacementActivity.c0(this.f113861a);
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139763c;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f113785a = LazyKt.a(lazyThreadSafetyMode, new Function0<SuperwallPlacementViewModel>() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementActivity$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ComponentActivity componentActivity = this;
                Qualifier qualifier2 = qualifier;
                Function0 function02 = objArr;
                Function0 function03 = function0;
                ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                if (function02 == null || (defaultViewModelCreationExtras = (CreationExtras) function02.invoke()) == null) {
                    defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope scopeA = AndroidKoinScopeExtKt.a(componentActivity);
                KClass kClassB = Reflection.b(SuperwallPlacementViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return GetViewModelKt.b(kClassB, viewModelStore, null, creationExtras, qualifier2, scopeA, function03, 4, null);
            }
        });
        this.f113786b = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.b
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SuperwallPlacementActivity.T(this.f113862a, (ActivityResult) obj);
            }
        });
        this.f113787c = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.c
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SuperwallPlacementActivity.Z(this.f113863a, (ActivityResult) obj);
            }
        });
        this.f113788d = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.d
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SuperwallPlacementActivity.b0(this.f113864a, (ActivityResult) obj);
            }
        });
        this.f113789f = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.e
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SuperwallPlacementActivity.a0(this.f113865a, (ActivityResult) obj);
            }
        });
        this.f113790g = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.f
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SuperwallPlacementActivity.V(this.f113866a, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(SuperwallPlacementActivity superwallPlacementActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        superwallPlacementActivity.setResult(result.d(), result.c());
        superwallPlacementActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SuperwallPlacementViewModel U() {
        return (SuperwallPlacementViewModel) this.f113785a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(SuperwallPlacementActivity superwallPlacementActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        superwallPlacementActivity.U().K0().h(new SuperwallPlacementViewEvent.OnStepFinished(SuperwallPlacementViewState.Step.GuestPassShare));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(SuperwallPlacementViewState superwallPlacementViewState) {
        if (superwallPlacementViewState.k()) {
            return;
        }
        switch (WhenMappings.f113791a[superwallPlacementViewState.j().ordinal()]) {
            case 1:
                return;
            case 2:
                this.f113787c.b(SignInActivity.f110366h.a(this, new SignInConfig(SignInEntryPoint.PREMIUM, null, false, superwallPlacementViewState.i(), false, false, false, true, false, false, null, 1910, null)));
                break;
            case 3:
                this.f113788d.b(TrialRemindersActivity.Companion.b(TrialRemindersActivity.f113891h, this, superwallPlacementViewState.l(), false, 4, null));
                break;
            case 4:
                if (superwallPlacementViewState.h()) {
                    RatingDialogActivity.f95979p.i(this, true, RatingTriggerSource.SuperwallOnboarding, null);
                }
                this.f113789f.b(SubscriptionOnboardingActivity.f122709g.a(this, superwallPlacementViewState.n(), superwallPlacementViewState.l()));
                break;
            case 5:
                this.f113790g.b(GuestPassShareActivity.f107428g.a(this, GuestPassShareFlowScenario.OnboardingShareOnly));
                break;
            case 6:
                Y();
                break;
            case 7:
                if (superwallPlacementViewState.h()) {
                    RatingDialogActivity.f95979p.i(this, true, RatingTriggerSource.SuperwallFinish, null);
                }
                setResult(-1);
                finish();
                break;
            case 8:
                finish();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        U().K0().h(new SuperwallPlacementViewEvent.OnStepLaunched(superwallPlacementViewState.j()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean X() {
        return getIntent().getBooleanExtra("EXTRA_SUPERWALL_IS_HARD_PAYWALL", false);
    }

    private final void Y() {
        Parcelable parcelable;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) intent.getParcelableExtra("EXTRA_SUPERWALL_FALLBACK_INTENT", Intent.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra("EXTRA_SUPERWALL_FALLBACK_INTENT");
            if (!(parcelableExtra instanceof Intent)) {
                parcelableExtra = null;
            }
            parcelable = (Intent) parcelableExtra;
        }
        Intent intent2 = (Intent) parcelable;
        if (intent2 != null) {
            this.f113786b.b(intent2);
            return;
        }
        Log.d("SuperwallPaywall", "No fallback intent, returning to the caller to render its own paywall");
        setResult(AdError.NO_FILL_ERROR_CODE);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(SuperwallPlacementActivity superwallPlacementActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        superwallPlacementActivity.U().K0().h(new SuperwallPlacementViewEvent.OnStepFinished(SuperwallPlacementViewState.Step.SignIn));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(SuperwallPlacementActivity superwallPlacementActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        superwallPlacementActivity.U().K0().h(new SuperwallPlacementViewEvent.OnStepFinished(SuperwallPlacementViewState.Step.SubscriptionOnboarding));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(SuperwallPlacementActivity superwallPlacementActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        superwallPlacementActivity.U().K0().h(new SuperwallPlacementViewEvent.OnStepFinished(SuperwallPlacementViewState.Step.TrialReminders));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder c0(SuperwallPlacementActivity superwallPlacementActivity) {
        Map mapEmptyMap;
        Parcelable parcelable;
        String stringExtra = superwallPlacementActivity.getIntent().getStringExtra("EXTRA_SUPERWALL_PLACEMENT");
        Bundle bundleExtra = superwallPlacementActivity.getIntent().getBundleExtra("EXTRA_SUPERWALL_PARAMS");
        if (bundleExtra != null) {
            Set<String> setKeySet = bundleExtra.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "keySet(...)");
            ArrayList arrayList = new ArrayList();
            for (String str : setKeySet) {
                Object obj = bundleExtra.get(str);
                Pair pairA = obj != null ? TuplesKt.a(str, obj) : null;
                if (pairA != null) {
                    arrayList.add(pairA);
                }
            }
            mapEmptyMap = MapsKt.toMap(arrayList);
        } else {
            mapEmptyMap = null;
        }
        if (mapEmptyMap == null) {
            mapEmptyMap = MapsKt.emptyMap();
        }
        Map map = mapEmptyMap;
        boolean zX = superwallPlacementActivity.X();
        Intent intent = superwallPlacementActivity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) intent.getParcelableExtra("EXTRA_SUPERWALL_FALLBACK_INTENT", Intent.class);
        } else {
            Parcelable parcelableExtra = intent.getParcelableExtra("EXTRA_SUPERWALL_FALLBACK_INTENT");
            parcelable = (Intent) (parcelableExtra instanceof Intent ? parcelableExtra : null);
        }
        return ParametersHolderKt.b(new SuperwallPlacementViewModel.Param(stringExtra, map, zX, parcelable != null, superwallPlacementActivity.getIntent().getBundleExtra("EXTRA_SUPERWALL_ANALYTICS")));
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getOnBackPressedDispatcher().i(this, new OnBackPressedCallback() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementActivity.onCreate.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (SuperwallPlacementActivity.this.X()) {
                    return;
                }
                SuperwallPlacementActivity.this.finish();
            }
        });
        BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(this), null, null, new AnonymousClass2(null), 3, null);
    }
}
