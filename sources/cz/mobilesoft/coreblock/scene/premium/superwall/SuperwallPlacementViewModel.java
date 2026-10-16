package cz.mobilesoft.coreblock.scene.premium.superwall;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.SavedStateHandle;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.presentation.PaywallPresentationHandler;
import com.superwall.sdk.paywall.presentation.PublicPresentationKt;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallSkippedReason;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel;
import cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewEvent;
import cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewState;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.analytics.FacebookLogger;
import cz.mobilesoft.coreblock.util.monetization.PostPurchaseChain;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTrace;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTraceAttachment;
import cz.mobilesoft.coreblock.util.paywalltrace.PaywallTraceStore;
import cz.mobilesoft.coreblock.util.paywalltrace.RuleOutcome;
import cz.mobilesoft.coreblock.util.superwall.SuperwallInitializer;
import cz.mobilesoft.coreblock.util.superwall.SuperwallPurchaseController;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SuperwallPlacementViewModel extends BaseStatefulViewModel<SuperwallPlacementViewState, SuperwallPlacementViewEvent, ViewCommand> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Companion f113807u = new Companion(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f113808v = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final SavedStateHandle f113809o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Param f113810p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f113811q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f113812r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f113813s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f113814t;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewModel$1", f = "SuperwallPlacementViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<SuperwallPlacementViewState, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f113815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f113816b;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = SuperwallPlacementViewModel.this.new AnonymousClass1(continuation);
            anonymousClass1.f113816b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SuperwallPlacementViewState superwallPlacementViewState, Continuation continuation) {
            return ((AnonymousClass1) create(superwallPlacementViewState, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            SuperwallPlacementViewState superwallPlacementViewState = (SuperwallPlacementViewState) this.f113816b;
            IntrinsicsKt.f();
            if (this.f113815a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            SuperwallPlacementViewModel.this.f113809o.e("SUPERWALL_PLACEMENT_VIEW_STATE", superwallPlacementViewState);
            return Unit.f139807a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(Bundle bundle, FacebookLogger facebookLogger) {
            if (bundle == null) {
                return;
            }
            Bundle bundle2 = new Bundle(bundle);
            bundle2.putString("renderer", "superwall");
            AnswersHelper.f128199a.b4(new PremiumScreenViewModel.AnalyticsData(bundle2));
            String string = bundle.getString("premium_screen_type", "premium");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            facebookLogger.d(string);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(String str, String str2, Pair... pairArr) {
            PaywallTraceStore paywallTraceStore = PaywallTraceStore.f128981a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            PaywallTrace.Stage stage = PaywallTrace.Stage.SuperwallPresentation;
            ArrayList arrayList = new ArrayList(pairArr.length);
            for (Pair pair : pairArr) {
                arrayList.add(new RuleOutcome((String) pair.e(), (String) pair.f(), true));
            }
            paywallTraceStore.c(new PaywallTrace(jCurrentTimeMillis, stage, str2, str, "Superwall", null, null, arrayList, null, null, 0, 1888, null));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Param {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f113818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map f113819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f113820c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f113821d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Bundle f113822e;

        public Param(String str, Map params, boolean z2, boolean z3, Bundle bundle) {
            Intrinsics.checkNotNullParameter(params, "params");
            this.f113818a = str;
            this.f113819b = params;
            this.f113820c = z2;
            this.f113821d = z3;
            this.f113822e = bundle;
        }

        public final Bundle a() {
            return this.f113822e;
        }

        public final boolean b() {
            return this.f113821d;
        }

        public final Map c() {
            return this.f113819b;
        }

        public final String d() {
            return this.f113818a;
        }

        public final boolean e() {
            return this.f113820c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Param)) {
                return false;
            }
            Param param = (Param) obj;
            return Intrinsics.areEqual(this.f113818a, param.f113818a) && Intrinsics.areEqual(this.f113819b, param.f113819b) && this.f113820c == param.f113820c && this.f113821d == param.f113821d && Intrinsics.areEqual(this.f113822e, param.f113822e);
        }

        public int hashCode() {
            String str = this.f113818a;
            int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.f113819b.hashCode()) * 31) + Boolean.hashCode(this.f113820c)) * 31) + Boolean.hashCode(this.f113821d)) * 31;
            Bundle bundle = this.f113822e;
            return iHashCode + (bundle != null ? bundle.hashCode() : 0);
        }

        public String toString() {
            return "Param(placement=" + this.f113818a + ", params=" + this.f113819b + ", isHardPaywall=" + this.f113820c + ", hasFallback=" + this.f113821d + ", analytics=" + this.f113822e + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f113823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f113824b;

        static {
            int[] iArr = new int[SuperwallPlacementViewState.Step.values().length];
            try {
                iArr[SuperwallPlacementViewState.Step.SignIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SuperwallPlacementViewState.Step.TrialReminders.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SuperwallPlacementViewState.Step.SubscriptionOnboarding.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SuperwallPlacementViewState.Step.GuestPassShare.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SuperwallPlacementViewState.Step.Paywall.ordinal()] = 5;
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
            f113823a = iArr;
            int[] iArr2 = new int[PostPurchaseChain.Step.values().length];
            try {
                iArr2[PostPurchaseChain.Step.SignIn.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[PostPurchaseChain.Step.TrialReminders.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[PostPurchaseChain.Step.SubscriptionOnboarding.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[PostPurchaseChain.Step.GuestPassShare.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[PostPurchaseChain.Step.Done.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            f113824b = iArr2;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public SuperwallPlacementViewModel(Application application, SavedStateHandle savedStateHandle, Param param) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(param, "param");
        SuperwallPlacementViewState superwallPlacementViewState = (SuperwallPlacementViewState) savedStateHandle.c("SUPERWALL_PLACEMENT_VIEW_STATE");
        super(application, superwallPlacementViewState == null ? new SuperwallPlacementViewState(null, false, false, 0, false, false, false, false, false, null, false, 2047, null) : superwallPlacementViewState);
        this.f113809o = savedStateHandle;
        this.f113810p = param;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f113811q = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f113812r = LazyKt.a(lazyThreadSafetyModeB2, new Function0<RatingDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RatingDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f113813s = LazyKt.a(lazyThreadSafetyModeB3, new Function0<SuperwallPurchaseController>() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SuperwallPurchaseController.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f113814t = LazyKt.a(lazyThreadSafetyModeB4, new Function0<FacebookLogger>() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.SuperwallPlacementViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FacebookLogger.class), objArr6, objArr7);
            }
        });
        boolean zB = savedStateHandle.b("SUPERWALL_PLACEMENT_VIEW_STATE");
        FlowKt.Q(FlowKt.V(M0(), new AnonymousClass1(null)), F0());
        if (zB) {
            if (((SuperwallPlacementViewState) I0()).j() == SuperwallPlacementViewState.Step.Paywall) {
                k1((param.e() || !param.b()) ? SuperwallPlacementViewState.Step.Fallback : SuperwallPlacementViewState.Step.FinishCanceled);
            }
        } else if (param.d() == null || !SuperwallInitializer.f129740a.c()) {
            k1(SuperwallPlacementViewState.Step.Fallback);
        } else {
            q1(param.d(), param.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1(PostPurchaseChain.Step step) {
        PostPurchaseChain.Step stepA = step == null ? PostPurchaseChain.f128896a.a(v1((SuperwallPlacementViewState) I0())) : PostPurchaseChain.f128896a.b(step, v1((SuperwallPlacementViewState) I0()));
        if ((step == null || step == PostPurchaseChain.Step.SignIn || step == PostPurchaseChain.Step.TrialReminders) && stepA != PostPurchaseChain.Step.SignIn && stepA != PostPurchaseChain.Step.TrialReminders && ((SuperwallPlacementViewState) I0()).g()) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SuperwallPlacementViewModel.f1((SuperwallPlacementViewState) obj);
                }
            });
        }
        k1(x1(stepA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SuperwallPlacementViewState f1(SuperwallPlacementViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SuperwallPlacementViewState.c(updateState, null, false, false, 0, false, false, false, false, false, null, true, 1023, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore g1() {
        return (CoreDataStore) this.f113811q.getValue();
    }

    private final FacebookLogger h1() {
        return (FacebookLogger) this.f113814t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SuperwallPurchaseController i1() {
        return (SuperwallPurchaseController) this.f113813s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RatingDataStore j1() {
        return (RatingDataStore) this.f113812r.getValue();
    }

    private final void k1(final SuperwallPlacementViewState.Step step) {
        if (step == SuperwallPlacementViewState.Step.Fallback) {
            f113807u.d(this.f113810p.d(), "falling back to legacy paywall", TuplesKt.a("isHardPaywall", String.valueOf(this.f113810p.e())));
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SuperwallPlacementViewModel.l1(step, (SuperwallPlacementViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SuperwallPlacementViewState l1(SuperwallPlacementViewState.Step step, SuperwallPlacementViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SuperwallPlacementViewState.c(updateState, step, false, false, 0, false, false, false, false, false, null, false, 2044, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SuperwallPlacementViewState n1(SuperwallPlacementViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return SuperwallPlacementViewState.c(updateState, null, true, false, 0, false, false, false, false, false, null, false, 1021, null);
    }

    private final void o1(boolean z2) {
        G0(new SuperwallPlacementViewModel$onPurchased$1(this, z2, null));
    }

    private final void p1(SuperwallPlacementViewState.Step step) {
        PostPurchaseChain.Step stepW1 = w1(step);
        if (stepW1 == null) {
            return;
        }
        e1(stepW1);
    }

    private final void q1(final String str, Map map) {
        final Channel channelK0 = K0();
        final Bundle bundleA = this.f113810p.a();
        final FacebookLogger facebookLoggerH1 = h1();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final Job jobD = BuildersKt__Builders_commonKt.d(F0(), null, null, new SuperwallPlacementViewModel$registerPlacement$presentationTimeout$1(atomicBoolean, str, channelK0, null), 3, null);
        PaywallPresentationHandler paywallPresentationHandler = new PaywallPresentationHandler();
        paywallPresentationHandler.onPresent(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SuperwallPlacementViewModel.r1(jobD, atomicBoolean, str, bundleA, facebookLoggerH1, (PaywallInfo) obj);
            }
        });
        paywallPresentationHandler.onDismiss(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SuperwallPlacementViewModel.s1(jobD, str, channelK0, (PaywallInfo) obj, (PaywallResult) obj2);
            }
        });
        paywallPresentationHandler.onError(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SuperwallPlacementViewModel.t1(jobD, str, channelK0, (Throwable) obj);
            }
        });
        paywallPresentationHandler.onSkip(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.m
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SuperwallPlacementViewModel.u1(jobD, str, channelK0, (PaywallSkippedReason) obj);
            }
        });
        PublicPresentationKt.register$default(Superwall.Companion.getInstance(), str, map, paywallPresentationHandler, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(Job job, AtomicBoolean atomicBoolean, String str, Bundle bundle, FacebookLogger facebookLogger, PaywallInfo paywallInfo) {
        Intrinsics.checkNotNullParameter(paywallInfo, "paywallInfo");
        Job.DefaultImpls.b(job, null, 1, null);
        if (atomicBoolean.getAndSet(false)) {
            Log.w("SuperwallPaywall", "Superwall presented after the fallback took over, dismissing it");
            f113807u.d(str, "presented after the fallback, dismissing", new Pair[0]);
            CoroutineScope applicationScope = LockieApplication.f95365k;
            Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
            BuildersKt__Builders_commonKt.d(applicationScope, Dispatchers.c(), null, new SuperwallPlacementViewModel$registerPlacement$handler$1$1$1(null), 2, null);
            return Unit.f139807a;
        }
        Log.d("SuperwallPaywall", "Superwall paywall presented: " + paywallInfo.getName());
        Companion companion = f113807u;
        companion.d(str, "presented \"" + paywallInfo.getName() + "\"", new Pair[0]);
        companion.c(bundle, facebookLogger);
        PaywallTraceAttachment.f128979a.b();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(Job job, String str, Channel channel, PaywallInfo paywallInfo, PaywallResult paywallResult) {
        Intrinsics.checkNotNullParameter(paywallInfo, "<unused var>");
        Intrinsics.checkNotNullParameter(paywallResult, "paywallResult");
        Job.DefaultImpls.b(job, null, 1, null);
        if (paywallResult instanceof PaywallResult.Purchased) {
            f113807u.d(str, "purchased", new Pair[0]);
            channel.h(new SuperwallPlacementViewEvent.OnPaywallPurchased(false));
        } else if (paywallResult instanceof PaywallResult.Restored) {
            f113807u.d(str, "restored", new Pair[0]);
            channel.h(new SuperwallPlacementViewEvent.OnPaywallPurchased(true));
        } else {
            f113807u.d(str, "dismissed without purchase", new Pair[0]);
            channel.h(SuperwallPlacementViewEvent.OnPaywallDismissed.f113802a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(Job job, String str, Channel channel, Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        Job.DefaultImpls.b(job, null, 1, null);
        Log.e("SuperwallPaywall", "Superwall paywall error, falling back to legacy paywall", error);
        CrashHelper.f127788a.i(error);
        Companion companion = f113807u;
        String message = error.getMessage();
        if (message == null) {
            message = error.toString();
        }
        companion.d(str, "error, falling back", TuplesKt.a("error", message));
        channel.h(SuperwallPlacementViewEvent.OnPaywallFailed.f113803a);
        return Unit.f139807a;
    }

    private final PostPurchaseChain.Inputs v1(SuperwallPlacementViewState superwallPlacementViewState) {
        return new PostPurchaseChain.Inputs(superwallPlacementViewState.e(), SessionManager.f127910a.r(), superwallPlacementViewState.n(), superwallPlacementViewState.m(), superwallPlacementViewState.d(), superwallPlacementViewState.f());
    }

    private final PostPurchaseChain.Step w1(SuperwallPlacementViewState.Step step) {
        switch (WhenMappings.f113823a[step.ordinal()]) {
            case 1:
                return PostPurchaseChain.Step.SignIn;
            case 2:
                return PostPurchaseChain.Step.TrialReminders;
            case 3:
                return PostPurchaseChain.Step.SubscriptionOnboarding;
            case 4:
                return PostPurchaseChain.Step.GuestPassShare;
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final SuperwallPlacementViewState.Step x1(PostPurchaseChain.Step step) {
        int i3 = WhenMappings.f113824b[step.ordinal()];
        if (i3 == 1) {
            return SuperwallPlacementViewState.Step.SignIn;
        }
        if (i3 == 2) {
            return SuperwallPlacementViewState.Step.TrialReminders;
        }
        if (i3 == 3) {
            return SuperwallPlacementViewState.Step.SubscriptionOnboarding;
        }
        if (i3 == 4) {
            return SuperwallPlacementViewState.Step.GuestPassShare;
        }
        if (i3 == 5) {
            return SuperwallPlacementViewState.Step.FinishSuccess;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void O0(SuperwallPlacementViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof SuperwallPlacementViewEvent.OnStepLaunched) {
            if (((SuperwallPlacementViewEvent.OnStepLaunched) event).a() == ((SuperwallPlacementViewState) I0()).j()) {
                Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.superwall.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SuperwallPlacementViewModel.n1((SuperwallPlacementViewState) obj);
                    }
                });
                return;
            }
            return;
        }
        if (event instanceof SuperwallPlacementViewEvent.OnStepFinished) {
            p1(((SuperwallPlacementViewEvent.OnStepFinished) event).a());
            return;
        }
        if (event instanceof SuperwallPlacementViewEvent.OnPaywallPurchased) {
            if (((SuperwallPlacementViewState) I0()).j() == SuperwallPlacementViewState.Step.Paywall) {
                o1(((SuperwallPlacementViewEvent.OnPaywallPurchased) event).a());
                return;
            } else {
                Log.w("SuperwallPaywall", "Superwall purchase arrived after the fallback took over, not running the chain");
                f113807u.d(this.f113810p.d(), "purchase after the fallback, chain not started", new Pair[0]);
                return;
            }
        }
        if (!Intrinsics.areEqual(event, SuperwallPlacementViewEvent.OnPaywallDismissed.f113802a)) {
            if (!Intrinsics.areEqual(event, SuperwallPlacementViewEvent.OnPaywallFailed.f113803a)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((SuperwallPlacementViewState) I0()).j() == SuperwallPlacementViewState.Step.Paywall) {
                k1(SuperwallPlacementViewState.Step.Fallback);
                return;
            }
            return;
        }
        if (((SuperwallPlacementViewState) I0()).j() != SuperwallPlacementViewState.Step.Paywall) {
            f113807u.d(this.f113810p.d(), "dismissal after the fallback, ignored", new Pair[0]);
        } else if (!this.f113810p.e()) {
            k1(SuperwallPlacementViewState.Step.FinishCanceled);
        } else {
            Log.w("SuperwallPaywall", "Hard paywall dismissed without purchase, falling back to legacy hard paywall");
            k1(SuperwallPlacementViewState.Step.Fallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(Job job, String str, Channel channel, PaywallSkippedReason reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Job.DefaultImpls.b(job, null, 1, null);
        Log.d("SuperwallPaywall", "Superwall paywall skipped (" + reason + tDEtWsFLJfe.pGEkBjh);
        f113807u.d(str, "skipped, falling back", TuplesKt.a("skip reason", reason.toString()));
        channel.h(SuperwallPlacementViewEvent.OnPaywallFailed.f113803a);
        return Unit.f139807a;
    }
}
