package cz.mobilesoft.coreblock.scene.more.referral;

import android.app.Application;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.StoreProduct;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.more.referral.ReferralViewEvent;
import cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumDTOsKt;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.usecase.FetchRevenueCatOfferingUseCase;
import cz.mobilesoft.coreblock.util.DataState;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
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
public final class ReferralViewModel extends BaseStatefulViewModel<ReferralViewState, ReferralViewEvent, ReferralViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f107975o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f107976p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f107977q;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel$1", f = "ReferralViewModel.kt", l = {32}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107978a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02861<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ReferralViewModel f107980a;

            C02861(ReferralViewModel referralViewModel) {
                this.f107980a = referralViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ReferralViewState f(Integer num, ReferralViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return ReferralViewState.b(updateState, num, null, 2, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(DataState dataState, Continuation continuation) {
                PremiumOptionDTO premiumOptionDTOD;
                if (dataState instanceof DataState.Success) {
                    Offering offering = (Offering) ((DataState.Success) dataState).a();
                    Package annual = offering.getAnnual();
                    final Integer numB = null;
                    StoreProduct product = annual != null ? annual.getProduct() : null;
                    GoogleStoreProduct googleStoreProduct = product instanceof GoogleStoreProduct ? (GoogleStoreProduct) product : null;
                    if (googleStoreProduct != null && (premiumOptionDTOD = PremiumDTOsKt.d(googleStoreProduct, false, false, false, offering.getMetadata(), 7, null)) != null) {
                        numB = premiumOptionDTOD.b();
                    }
                    this.f107980a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.referral.k
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ReferralViewModel.AnonymousClass1.C02861.f(numB, (ReferralViewState) obj);
                        }
                    });
                }
                return Unit.f139807a;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ReferralViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107978a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowO = ReferralViewModel.this.Y0().o(new FetchRevenueCatOfferingUseCase.Params(RevenueCatPlacement.ReferralSent, FetchRevenueCatOfferingUseCase.FetchOfferingsSource.ReferralScreen));
                C02861 c02861 = new C02861(ReferralViewModel.this);
                this.f107978a = 1;
                if (flowO.collect(c02861, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel$2", f = "ReferralViewModel.kt", l = {47}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f107981a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ReferralViewModel f107983a;

            AnonymousClass1(ReferralViewModel referralViewModel) {
                this.f107983a = referralViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ReferralViewState f(PremiumState premiumState, ReferralViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return ReferralViewState.b(updateState, null, Boolean.valueOf(premiumState.g()), 1, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final PremiumState premiumState, Continuation continuation) {
                this.f107983a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.referral.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ReferralViewModel.AnonymousClass2.AnonymousClass1.f(premiumState, (ReferralViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ReferralViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f107981a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowK = ReferralViewModel.this.Z0().K();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ReferralViewModel.this);
                this.f107981a = 1;
                if (stateFlowK.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReferralViewModel(Application application) {
        super(application, new ReferralViewState(null, null, 3, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f107975o = LazyKt.a(lazyThreadSafetyModeB, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f107976p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<FetchRevenueCatOfferingUseCase>() { // from class: cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchRevenueCatOfferingUseCase.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f107977q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr4, objArr5);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
    }

    public static final /* synthetic */ ReferralViewState R0(ReferralViewModel referralViewModel) {
        return (ReferralViewState) referralViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore X0() {
        return (DiscountDataStore) this.f107975o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FetchRevenueCatOfferingUseCase Y0() {
        return (FetchRevenueCatOfferingUseCase) this.f107976p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 Z0() {
        return (PremiumRepositoryV2) this.f107977q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public void O0(ReferralViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ReferralViewEvent.OnShareClicked) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new ReferralViewModel$onEvent$1(this, null), 3, null);
        } else {
            if (!Intrinsics.areEqual(event, ReferralViewEvent.OnShared.f107974a)) {
                throw new NoWhenBranchMatchedException();
            }
            if (Intrinsics.areEqual(((ReferralViewState) I0()).d(), Boolean.FALSE)) {
                BuildersKt__Builders_commonKt.d(C0(), null, null, new ReferralViewModel$onEvent$2(this, null), 3, null);
            }
        }
    }
}
