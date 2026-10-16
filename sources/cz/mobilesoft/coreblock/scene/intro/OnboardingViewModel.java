package cz.mobilesoft.coreblock.scene.intro;

import android.app.Application;
import android.os.CountDownTimer;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.dto.AppWebWrapper;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.scene.intro.OnboardingViewEvent;
import cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt;
import cz.mobilesoft.statistics.api.Statistics;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import cz.mobilesoft.widgets.AppBlockWidgetState;
import cz.mobilesoft.widgets.quickblock.QuickBlockWidgetReceiver;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OnboardingViewModel extends BaseStatefulViewModel<OnboardingViewState, OnboardingViewEvent, OnboardingViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f104525o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f104526p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile CountDownTimer f104527q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final MutableLiveData f104528r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private float f104529s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f104530t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private double f104531u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f104532v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final MutableLiveData f104533w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final LiveData f104534x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final LiveData f104535y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Companion f104524z = new Companion(null);
    public static final int A = 8;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$1", f = "OnboardingViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function4<Boolean, Boolean, Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f104536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ boolean f104537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ boolean f104538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ boolean f104539d;

        AnonymousClass1(Continuation continuation) {
            super(4, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final OnboardingViewState y(boolean z2, boolean z3, boolean z4, OnboardingViewState onboardingViewState) {
            return OnboardingViewState.b(onboardingViewState, null, null, null, 0L, 0L, z2, z3 || !z4, z3, 31, null);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return q(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), (Continuation) obj4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            final boolean z2 = this.f104537b;
            final boolean z3 = this.f104538c;
            final boolean z4 = this.f104539d;
            IntrinsicsKt.f();
            if (this.f104536a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            OnboardingViewModel.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.m1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return OnboardingViewModel.AnonymousClass1.y(z2, z3, z4, (OnboardingViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        public final Object q(boolean z2, boolean z3, boolean z4, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = OnboardingViewModel.this.new AnonymousClass1(continuation);
            anonymousClass1.f104537b = z2;
            anonymousClass1.f104538c = z3;
            anonymousClass1.f104539d = z4;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OnboardingViewModel(Application application) {
        super(application, new OnboardingViewState(null, null, null, 0L, 0L, false, false, false, 255, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f104525o = LazyKt.a(lazyThreadSafetyModeB, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f104526p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr2, objArr3);
            }
        });
        this.f104528r = new MutableLiveData(Float.valueOf(0.0f));
        this.f104532v = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.j1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OnboardingViewModel.x1();
            }
        });
        MutableLiveData mutableLiveData = new MutableLiveData(null);
        this.f104533w = mutableLiveData;
        LiveData liveDataF = Transformations.f(mutableLiveData, new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.k1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OnboardingViewModel.y1(this.f104641a, (List) obj);
            }
        });
        this.f104534x = liveDataF;
        this.f104535y = LiveDataExtKt.e(liveDataF, C0(), new OnboardingViewModel$appsWebsList$1(this, null));
        FlowKt.Q(FlowKt.n(q1().M3(), FlowKt.K(Boolean.valueOf(SessionManager.f127910a.r())), q1().f3(), new AnonymousClass1(null)), C0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(OnboardingViewState onboardingViewState) {
        H0(new OnboardingViewModel$saveAnswers$1(this, onboardingViewState, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1() {
        PrefManager prefManager = PrefManager.f126839a;
        prefManager.Q2(true);
        prefManager.v1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object C1(Continuation continuation) throws Throwable {
        Object objA = QuickBlockWidgetReceiver.f134085h.a(A0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.l1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OnboardingViewModel.D1((AppBlockWidgetState) obj);
            }
        }, continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBlockWidgetState D1(AppBlockWidgetState updateWidget) {
        Intrinsics.checkNotNullParameter(updateWidget, "$this$updateWidget");
        return AppBlockWidgetState.e(updateWidget, AppBlockWidgetState.QuickBlockWidgetState.NotSetUp.INSTANCE, null, false, 0, 14, null);
    }

    public static final /* synthetic */ OnboardingViewState W0(OnboardingViewModel onboardingViewModel) {
        return (OnboardingViewState) onboardingViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1(final OnboardingHelpItem onboardingHelpItem) {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.i1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OnboardingViewModel.o1(this.f104634a, onboardingHelpItem, (OnboardingViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnboardingViewState o1(OnboardingViewModel onboardingViewModel, OnboardingHelpItem onboardingHelpItem, OnboardingViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Set mutableSet = CollectionsKt.toMutableSet(updateState.e());
        if (!mutableSet.remove(onboardingHelpItem)) {
            mutableSet.add(onboardingHelpItem);
        }
        OnboardingViewState onboardingViewStateB = OnboardingViewState.b(updateState, ExtensionsKt.j(mutableSet), null, null, 0L, 0L, false, false, false, 254, null);
        onboardingViewModel.A1(onboardingViewStateB);
        return onboardingViewStateB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore q1() {
        return (CoreDataStore) this.f104526p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao s1() {
        return (IgnoredStatisticsItemDao) this.f104525o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList u1() {
        List listTake;
        List list = (List) this.f104535y.f();
        if (list == null || (listTake = CollectionsKt.take(list, 5)) == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = listTake.iterator();
        while (it.hasNext()) {
            AggregatedItemRecord aggregatedItemRecordA = ((AppWebWrapper) it.next()).a();
            String strE = aggregatedItemRecordA != null ? aggregatedItemRecordA.e() : null;
            if (strE != null) {
                arrayList.add(strE);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(final float f3) {
        CountDownTimer countDownTimer = this.f104527q;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f104527q = new CountDownTimer() { // from class: cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$initCountDownTimer$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(5000L, 100L);
            }

            private final void a(float f4, float f5) {
                if (f4 <= f5 || this.f104529s == 1.0f) {
                    return;
                }
                this.w1(f5);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                this.f104527q = null;
                if (this.f104529s == 1.0f) {
                    this.p1().n(Float.valueOf(1.0f));
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                float f4 = (((long) 5000) - j3) / 5000.0f;
                float f5 = f3;
                if (f5 == 0.0f) {
                    this.p1().n(Float.valueOf(f4));
                    a(f4, 0.75f);
                } else if (f5 == 0.75f) {
                    float f6 = (f4 * 0.25f) + 0.75f;
                    this.p1().n(Float.valueOf(f6));
                    a(f6, 0.9f);
                } else if (f5 == 0.9f) {
                    this.p1().n(Float.valueOf(Math.min((f4 * 0.100000024f) + 0.9f, 0.99f)));
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair x1() {
        Calendar calendarJ = DateHelper.j();
        long timeInMillis = calendarJ.getTimeInMillis();
        calendarJ.add(3, -1);
        return new Pair(Long.valueOf(calendarJ.getTimeInMillis()), Long.valueOf(timeInMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData y1(OnboardingViewModel onboardingViewModel, List list) {
        LiveData liveDataE;
        return (list == null || (liveDataE = Statistics.e(SetsKt.setOf(Integer.valueOf(UsageAccess.Type.APPLICATION.getTypeId())), list, ((Number) onboardingViewModel.t1().e()).longValue(), ((Number) onboardingViewModel.t1().f()).longValue())) == null) ? new MutableLiveData(CollectionsKt.emptyList()) : liveDataE;
    }

    public final MutableLiveData p1() {
        return this.f104528r;
    }

    public final long r1() {
        return this.f104530t;
    }

    public final Pair t1() {
        return (Pair) this.f104532v.getValue();
    }

    public final double v1() {
        return this.f104531u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: z1, reason: merged with bridge method [inline-methods] */
    public void O0(OnboardingViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof OnboardingViewEvent.OnQuestion1Answer) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new OnboardingViewModel$onEvent$1(this, event, null), 3, null);
            return;
        }
        if (event instanceof OnboardingViewEvent.OnStatsQuestion1Answer) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new OnboardingViewModel$onEvent$2(this, event, null), 3, null);
            return;
        }
        if (event instanceof OnboardingViewEvent.OnStatsQuestion2Answer) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new OnboardingViewModel$onEvent$3(this, event, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, OnboardingViewEvent.OnQuickBlockSetUpClicked.f104519a)) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new OnboardingViewModel$onEvent$4(this, null), 3, null);
            return;
        }
        if (Intrinsics.areEqual(event, OnboardingViewEvent.OnSetUpSkipped.f104521a)) {
            G0(new OnboardingViewModel$onEvent$5(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, OnboardingViewEvent.OnQuickBlockSetUpSkipped.f104520a)) {
            G0(new OnboardingViewModel$onEvent$6(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, OnboardingViewEvent.OnDeveloperOnboardingSkipped.f104515a)) {
            G0(new OnboardingViewModel$onEvent$7(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, OnboardingViewEvent.OnAlreadyAMemberLoggedIn.f104514a)) {
            G0(new OnboardingViewModel$onEvent$8(this, null));
        } else if (Intrinsics.areEqual(event, OnboardingViewEvent.OnPrivacyExplanationClosed.f104517a)) {
            H0(new OnboardingViewModel$onEvent$9(this, null));
        } else {
            if (!Intrinsics.areEqual(event, OnboardingViewEvent.OnMultiSelectContinueClicked.f104516a)) {
                throw new NoWhenBranchMatchedException();
            }
            G0(new OnboardingViewModel$onEvent$10(this, null));
        }
    }
}
