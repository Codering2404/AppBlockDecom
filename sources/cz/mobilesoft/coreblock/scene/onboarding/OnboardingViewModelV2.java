package cz.mobilesoft.coreblock.scene.onboarding;

import android.app.Application;
import androidx.legacy.content.Werj.QgXempTBEfV;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.dto.AppWebWrapper;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.DynamicShortcutsManager;
import cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchAppDataUseCase;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchGraphDataUseCase;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewEventV2;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewStateV2;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.usecase.CheckGuestPassEligibilityUseCase;
import cz.mobilesoft.coreblock.util.DeeplinkRouter;
import cz.mobilesoft.coreblock.util.RemoteConfigSignal;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.UsageAccessHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.statistics.api.Statistics;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
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
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
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
public final class OnboardingViewModelV2 extends BaseStatefulViewModel<OnboardingViewStateV2, OnboardingViewEventV2, OnboardingViewCommandV2> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f110943o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f110944p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f110945q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f110946r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f110947s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f110948t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f110949u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f110950v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private double f110951w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f110952x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final MutableLiveData f110953y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Companion f110942z = new Companion(null);
    public static final int A = 8;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$1", f = "OnboardingViewModelV2.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function5<Boolean, Boolean, Boolean, OnboardingViewStateV2.OnboardingVariant, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ boolean f110955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ boolean f110956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ boolean f110957d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f110958f;

        AnonymousClass1(Continuation continuation) {
            super(5, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final OnboardingViewStateV2 y(boolean z2, boolean z3, boolean z4, OnboardingViewStateV2.OnboardingVariant onboardingVariant, OnboardingViewStateV2 onboardingViewStateV2) {
            return OnboardingViewStateV2.b(onboardingViewStateV2, null, z2 || !z3, z2, z4, null, null, 0L, 0L, null, onboardingVariant, null, null, null, null, false, false, null, false, 261617, null);
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return q(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), (OnboardingViewStateV2.OnboardingVariant) obj4, (Continuation) obj5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            final boolean z2 = this.f110955b;
            final boolean z3 = this.f110956c;
            final boolean z4 = this.f110957d;
            final OnboardingViewStateV2.OnboardingVariant onboardingVariant = (OnboardingViewStateV2.OnboardingVariant) this.f110958f;
            IntrinsicsKt.f();
            if (this.f110954a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            OnboardingViewModelV2.this.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.i2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return OnboardingViewModelV2.AnonymousClass1.y(z2, z3, z4, onboardingVariant, (OnboardingViewStateV2) obj2);
                }
            });
            return Unit.f139807a;
        }

        public final Object q(boolean z2, boolean z3, boolean z4, OnboardingViewStateV2.OnboardingVariant onboardingVariant, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = OnboardingViewModelV2.this.new AnonymousClass1(continuation);
            anonymousClass1.f110955b = z2;
            anonymousClass1.f110956c = z3;
            anonymousClass1.f110957d = z4;
            anonymousClass1.f110958f = onboardingVariant;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$2", f = "OnboardingViewModelV2.kt", l = {99}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110960a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OnboardingViewModelV2 f110962a;

            AnonymousClass1(OnboardingViewModelV2 onboardingViewModelV2) {
                this.f110962a = onboardingViewModelV2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final OnboardingViewStateV2 f(List list, OnboardingViewModelV2 onboardingViewModelV2, OnboardingViewStateV2 updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                List list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(new AppWebWrapper((AggregatedItemRecord) it.next(), null, null, 6, null));
                }
                return OnboardingViewStateV2.b(updateState, null, false, false, false, null, null, 0L, 0L, onboardingViewModelV2.v1(), null, null, CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$2$1$emit$lambda$0$$inlined$sortedByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ComparisonsKt.d(Integer.valueOf(((AppWebWrapper) obj2).e()), Integer.valueOf(((AppWebWrapper) obj).e()));
                    }
                }), null, null, false, false, null, false, 259839, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final List list, Continuation continuation) {
                final OnboardingViewModelV2 onboardingViewModelV2 = this.f110962a;
                onboardingViewModelV2.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.j2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingViewModelV2.AnonymousClass2.AnonymousClass1.f(list, onboardingViewModelV2, (OnboardingViewStateV2) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return OnboardingViewModelV2.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f110960a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowH = Statistics.f133571a.h(SetsKt.setOf(Boxing.d(UsageAccess.Type.APPLICATION.getTypeId())), (List) OnboardingViewModelV2.this.s1().f(), ((Number) OnboardingViewModelV2.this.u1().e()).longValue(), ((Number) OnboardingViewModelV2.this.u1().f()).longValue());
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(OnboardingViewModelV2.this);
                this.f110960a = 1;
                if (flowH.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$3", f = "OnboardingViewModelV2.kt", l = {114}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110963a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OnboardingViewModelV2 f110965a;

            AnonymousClass1(OnboardingViewModelV2 onboardingViewModelV2) {
                this.f110965a = onboardingViewModelV2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final OnboardingViewStateV2 f(boolean z2, OnboardingViewStateV2 updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return OnboardingViewStateV2.b(updateState, null, false, false, false, null, null, 0L, 0L, null, null, null, null, null, null, z2, false, null, false, 245759, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f110965a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.k2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingViewModelV2.AnonymousClass3.AnonymousClass1.f(z2, (OnboardingViewStateV2) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass3(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return OnboardingViewModelV2.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f110963a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowG3 = OnboardingViewModelV2.this.n1().g3();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(OnboardingViewModelV2.this);
                this.f110963a = 1;
                if (flowG3.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$4", f = "OnboardingViewModelV2.kt", l = {120}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110966a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ OnboardingViewModelV2 f110968a;

            AnonymousClass1(OnboardingViewModelV2 onboardingViewModelV2) {
                this.f110968a = onboardingViewModelV2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final OnboardingViewStateV2 f(boolean z2, OnboardingViewStateV2 updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return OnboardingViewStateV2.b(updateState, null, false, false, false, null, null, 0L, 0L, null, null, null, null, null, null, false, z2, null, false, 229375, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f110968a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.l2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingViewModelV2.AnonymousClass4.AnonymousClass1.f(z2, (OnboardingViewStateV2) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass4(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return OnboardingViewModelV2.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f110966a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ3 = OnboardingViewModelV2.this.n1().j3();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(OnboardingViewModelV2.this);
                this.f110966a = 1;
                if (flowJ3.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$5", f = "OnboardingViewModelV2.kt", l = {126, 129}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110969a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$5$1", f = "OnboardingViewModelV2.kt", l = {127}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f110971a;

            /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$5$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$5$1$1", f = "OnboardingViewModelV2.kt", l = {}, m = "invokeSuspend", v = 1)
            static final class C02931 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f110972a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                /* synthetic */ boolean f110973b;

                C02931(Continuation continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    C02931 c02931 = new C02931(continuation);
                    c02931.f110973b = ((Boolean) obj).booleanValue();
                    return c02931;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    boolean z2 = this.f110973b;
                    IntrinsicsKt.f();
                    if (this.f110972a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Boxing.a(z2);
                }

                public final Object invoke(boolean z2, Continuation continuation) {
                    return ((C02931) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            AnonymousClass1(Continuation continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new AnonymousClass1(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f110971a;
                if (i3 != 0) {
                    if (i3 == 1) {
                        ResultKt.b(obj);
                        return obj;
                    }
                    throw new IllegalStateException(QgXempTBEfV.vvIdZJBr);
                }
                ResultKt.b(obj);
                StateFlow stateFlowA = RemoteConfigSignal.f127906a.a();
                C02931 c02931 = new C02931(null);
                this.f110971a = 1;
                Object objE = FlowKt.E(stateFlowA, c02931, this);
                if (objE == objF) {
                    return objF;
                }
                return objE;
            }
        }

        AnonymousClass5(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final OnboardingViewStateV2 q(OnboardingFlowVariant onboardingFlowVariant, OnboardingViewStateV2 onboardingViewStateV2) {
            return OnboardingViewStateV2.b(onboardingViewStateV2, null, false, false, false, null, null, 0L, 0L, null, null, null, null, null, null, false, false, onboardingFlowVariant, true, 65535, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return OnboardingViewModelV2.this.new AnonymousClass5(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
        
            if (r6 == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r5.f110969a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r6)
                goto L45
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                kotlin.ResultKt.b(r6)
                goto L32
            L1e:
                kotlin.ResultKt.b(r6)
                cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$5$1 r6 = new cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$5$1
                r1 = 0
                r6.<init>(r1)
                r5.f110969a = r3
                r3 = 3000(0xbb8, double:1.482E-320)
                java.lang.Object r6 = kotlinx.coroutines.TimeoutKt.e(r3, r6, r5)
                if (r6 != r0) goto L32
                goto L44
            L32:
                cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2 r6 = cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2.this
                cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r6 = cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2.W0(r6)
                kotlinx.coroutines.flow.Flow r6 = r6.K2()
                r5.f110969a = r2
                java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r5)
                if (r6 != r0) goto L45
            L44:
                return r0
            L45:
                cz.mobilesoft.coreblock.scene.onboarding.OnboardingFlowVariant r6 = (cz.mobilesoft.coreblock.scene.onboarding.OnboardingFlowVariant) r6
                cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2 r0 = cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2.this
                cz.mobilesoft.coreblock.scene.onboarding.m2 r1 = new cz.mobilesoft.coreblock.scene.onboarding.m2
                r1.<init>()
                cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2.i1(r0, r1)
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
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
    public OnboardingViewModelV2(Application application, PremiumRepositoryV2 premiumRepository) {
        super(application, new OnboardingViewStateV2(premiumRepository.J(), false, false, false, null, null, 0L, 0L, null, null, null, null, null, null, false, false, null, false, 262142, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f110943o = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$special$$inlined$inject$default$1
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
        this.f110944p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f110945q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<FetchGraphDataUseCase>() { // from class: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchGraphDataUseCase.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f110946r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<FetchAppDataUseCase>() { // from class: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchAppDataUseCase.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f110947s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<ConsentHelper>() { // from class: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ConsentHelper.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f110948t = LazyKt.a(lazyThreadSafetyModeB6, new Function0<CheckGuestPassEligibilityUseCase>() { // from class: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CheckGuestPassEligibilityUseCase.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f110949u = LazyKt.a(lazyThreadSafetyModeB7, new Function0<DeeplinkRouter>() { // from class: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DeeplinkRouter.class), objArr12, objArr13);
            }
        });
        this.f110952x = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.h2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OnboardingViewModelV2.A1();
            }
        });
        this.f110953y = new MutableLiveData(null);
        FlowKt.Q(FlowKt.o(FlowKt.K(Boolean.valueOf(SessionManager.f127910a.r())), n1().f3(), n1().e3(), n1().L2(), new AnonymousClass1(null)), C0());
        G0(new AnonymousClass2(null));
        G0(new AnonymousClass3(null));
        G0(new AnonymousClass4(null));
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass5(null), 3, null);
        j1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair A1() {
        Calendar calendarJ = DateHelper.j();
        long timeInMillis = calendarJ.getTimeInMillis();
        calendarJ.add(3, -1);
        return new Pair(Long.valueOf(calendarJ.getTimeInMillis()), Long.valueOf(timeInMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C1(OnboardingViewStateV2 onboardingViewStateV2) {
        H0(new OnboardingViewModelV2$saveAnswers$1(this, onboardingViewStateV2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1() {
        PrefManager prefManager = PrefManager.f126839a;
        prefManager.Q2(true);
        prefManager.v1();
        DynamicShortcutsManager.l(DynamicShortcutsManager.f101460a, A0(), null, 2, null);
        G0(new OnboardingViewModelV2$setupPreferences$1(this, null));
    }

    private final void j1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new OnboardingViewModelV2$checkPendingDeeplink$1(this, null), 3, null);
    }

    private final void k1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new OnboardingViewModelV2$getApplicationAccess$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckGuestPassEligibilityUseCase l1() {
        return (CheckGuestPassEligibilityUseCase) this.f110948t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConsentHelper m1() {
        return (ConsentHelper) this.f110947s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore n1() {
        return (CoreDataStore) this.f110943o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DeeplinkRouter p1() {
        return (DeeplinkRouter) this.f110949u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FetchAppDataUseCase q1() {
        return (FetchAppDataUseCase) this.f110946r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FetchGraphDataUseCase r1() {
        return (FetchGraphDataUseCase) this.f110945q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao t1() {
        return (IgnoredStatisticsItemDao) this.f110944p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList v1() {
        List listF = ((OnboardingViewStateV2) I0()).f();
        ArrayList arrayList = new ArrayList();
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            AggregatedItemRecord aggregatedItemRecordA = ((AppWebWrapper) it.next()).a();
            String strE = aggregatedItemRecordA != null ? aggregatedItemRecordA.e() : null;
            if (strE != null) {
                arrayList.add(strE);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            if (!StringsKt.F((String) obj, "cz.mobilesoft.appblock", true)) {
                arrayList2.add(obj);
            }
        }
        return new ArrayList(CollectionsKt.take(CollectionsKt.take(arrayList2, 6), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(OnboardingViewModelV2 onboardingViewModelV2, boolean z2) {
        onboardingViewModelV2.k1();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(float f3) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void O0(OnboardingViewEventV2 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, OnboardingViewEventV2.OnOnboardingSkipped.f110939a)) {
            G0(new OnboardingViewModelV2$onEvent$1(this, null));
            Unit unit = Unit.f139807a;
        } else if (event instanceof OnboardingViewEventV2.OnTimeOnPhoneAnswered) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new OnboardingViewModelV2$onEvent$2(this, event, null), 3, null);
        } else {
            if (!(event instanceof OnboardingViewEventV2.OnPhonePickUpAnswered)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(B0(), null, null, new OnboardingViewModelV2$onEvent$3(this, event, null), 3, null);
        }
    }

    public final long o1() {
        return this.f110950v;
    }

    public final LiveData s1() {
        return this.f110953y;
    }

    public final Pair u1() {
        return (Pair) this.f110952x.getValue();
    }

    public final double w1() {
        return this.f110951w;
    }

    public final void x1() {
        UsageAccessHelper.r(y0(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.f2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OnboardingViewModelV2.y1(this.f111200a, ((Boolean) obj).booleanValue());
            }
        }, new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.g2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OnboardingViewModelV2.z1(((Float) obj).floatValue());
            }
        });
    }
}
