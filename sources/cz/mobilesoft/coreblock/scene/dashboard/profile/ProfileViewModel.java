package cz.mobilesoft.coreblock.scene.dashboard.profile;

import android.app.Application;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.Entitlement;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel;
import cz.mobilesoft.coreblock.scene.dashboard.profile.type.ProfileSectionItemType;
import cz.mobilesoft.coreblock.scene.more.haf.HaFRequestHelper;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.datastore.entity.AutoTrialVariant;
import cz.mobilesoft.coreblock.usecase.AverageStatisticsUseCase;
import cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase;
import cz.mobilesoft.coreblock.usecase.CheckGuestPassEligibilityUseCase;
import cz.mobilesoft.coreblock.usecase.StatisticsPermissionsUseCase;
import cz.mobilesoft.coreblock.usecase.YearlySavingsData;
import cz.mobilesoft.coreblock.util.AdsUtils;
import cz.mobilesoft.coreblock.util.AnswersSenderHelper;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.UsageAccessHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.RevenueCatExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.monetization.AccessPolicyKt;
import cz.mobilesoft.coreblock.util.monetization.Capability;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
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
public final class ProfileViewModel extends BaseStatefulViewModel<ProfileViewState, ProfileViewEvent, ProfileViewCommand> implements UsageAccessHelper.UsageAccessListener {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f100936o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f100937p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f100938q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f100939r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f100940s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f100941t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f100942u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f100943v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f100944w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f100945x;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$1", f = "ProfileViewModel.kt", l = {67}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100946a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02731<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ProfileViewModel f100948a;

            C02731(ProfileViewModel profileViewModel) {
                this.f100948a = profileViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ProfileViewState f(SessionManager.SignInState signInState, ProfileViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return ProfileViewState.b(updateState, signInState, null, null, false, false, null, null, null, null, null, false, false, false, null, null, false, null, null, null, false, 1048574, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final SessionManager.SignInState signInState, Continuation continuation) {
                this.f100948a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.r1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileViewModel.AnonymousClass1.C02731.f(signInState, (ProfileViewState) obj);
                    }
                });
                ProfileViewModel.l1(this.f100948a, null, 1, null);
                return Unit.f139807a;
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ProfileViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f100946a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowL = SessionManager.f127910a.l();
                C02731 c02731 = new C02731(ProfileViewModel.this);
                this.f100946a = 1;
                if (stateFlowL.collect(c02731, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$10", f = "ProfileViewModel.kt", l = {177}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100949a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$10$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$10$1", f = "ProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<CustomerInfo, Boolean, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f100951a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f100952b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ boolean f100953c;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            public final Object h(CustomerInfo customerInfo, boolean z2, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f100952b = customerInfo;
                anonymousClass1.f100953c = z2;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return h((CustomerInfo) obj, ((Boolean) obj2).booleanValue(), (Continuation) obj3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                EntitlementInfos entitlements;
                Map<String, EntitlementInfo> all;
                EntitlementInfo entitlementInfo;
                Date expirationDate;
                CustomerInfo customerInfo = (CustomerInfo) this.f100952b;
                boolean z2 = this.f100953c;
                IntrinsicsKt.f();
                if (this.f100951a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                if (z2) {
                    return Boxing.a(true);
                }
                long jF = TimeHelperExt.f128663a.f();
                Long lE = (customerInfo == null || (entitlements = customerInfo.getEntitlements()) == null || (all = entitlements.getAll()) == null || (entitlementInfo = all.get(Entitlement.FreeMonthPremium.getId())) == null || (expirationDate = entitlementInfo.getExpirationDate()) == null) ? null : Boxing.e(expirationDate.getTime());
                return Boxing.a(lE != null && lE.longValue() <= jF && lE.longValue() > jF - TimeUnit.DAYS.toMillis(30L) && !RevenueCatExtKt.a(customerInfo).contains(Entitlement.Premium));
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$10$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ProfileViewModel f100954a;

            AnonymousClass2(ProfileViewModel profileViewModel) {
                this.f100954a = profileViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ProfileViewState f(boolean z2, ProfileViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return ProfileViewState.b(updateState, null, null, null, false, false, null, null, null, null, null, false, false, false, null, null, false, null, null, null, z2, 524287, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f100954a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.s1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileViewModel.AnonymousClass10.AnonymousClass2.f(z2, (ProfileViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass10(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ProfileViewModel.this.new AnonymousClass10(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f100949a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowM = FlowKt.m(ProfileViewModel.this.v1().C(), BuildConfig.f95357b.booleanValue() ? ProfileViewModel.this.s1().D0() : FlowKt.K(Boxing.a(false)), new AnonymousClass1(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(ProfileViewModel.this);
                this.f100949a = 1;
                if (flowM.collect(anonymousClass2, this) == objF) {
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
            return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$2", f = "ProfileViewModel.kt", l = {82}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100955a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$2$1", f = "ProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<PremiumState, CustomerInfo, Continuation<? super Pair<? extends PremiumState, ? extends CustomerInfo>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f100957a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f100958b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f100959c;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PremiumState premiumState, CustomerInfo customerInfo, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f100958b = premiumState;
                anonymousClass1.f100959c = customerInfo;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                PremiumState premiumState = (PremiumState) this.f100958b;
                CustomerInfo customerInfo = (CustomerInfo) this.f100959c;
                IntrinsicsKt.f();
                if (this.f100957a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return TuplesKt.a(premiumState, customerInfo);
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C02742<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ProfileViewModel f100960a;

            C02742(ProfileViewModel profileViewModel) {
                this.f100960a = profileViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ProfileViewState f(ProfileViewModel profileViewModel, PremiumState premiumState, ProfileViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                Integer numE = profileViewModel.v1().I().e();
                Long lH = profileViewModel.v1().I().h();
                return ProfileViewState.b(updateState, null, premiumState, null, false, false, null, null, null, null, null, false, false, false, lH != null ? DateHelperExtKt.n(lH.longValue()) : null, numE, false, null, null, null, false, 1023997, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(Pair pair, Continuation continuation) throws Throwable {
                final PremiumState premiumState = (PremiumState) pair.a();
                CustomerInfo customerInfo = (CustomerInfo) pair.b();
                final ProfileViewModel profileViewModel = this.f100960a;
                profileViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.t1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileViewModel.AnonymousClass2.C02742.f(profileViewModel, premiumState, (ProfileViewState) obj);
                    }
                });
                this.f100960a.k1(customerInfo);
                Object objF1 = this.f100960a.F1(continuation);
                return objF1 == IntrinsicsKt.f() ? objF1 : Unit.f139807a;
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ProfileViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f100955a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowM = FlowKt.m(ProfileViewModel.this.v1().K(), ProfileViewModel.this.v1().C(), new AnonymousClass1(null));
                C02742 c02742 = new C02742(ProfileViewModel.this);
                this.f100955a = 1;
                if (flowM.collect(c02742, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$3", f = "ProfileViewModel.kt", l = {97}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100961a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ProfileViewModel f100963a;

            AnonymousClass1(ProfileViewModel profileViewModel) {
                this.f100963a = profileViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ProfileViewState f(boolean z2, ProfileViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return ProfileViewState.b(updateState, null, null, null, false, false, null, null, null, null, null, false, false, z2, null, null, false, null, null, null, false, 1044479, null);
            }

            public final Object b(long j3, Continuation continuation) {
                final boolean z2 = TimeHelperExt.f128663a.z(j3);
                this.f100963a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.u1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileViewModel.AnonymousClass3.AnonymousClass1.f(z2, (ProfileViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Number) obj).longValue(), continuation);
            }
        }

        AnonymousClass3(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ProfileViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f100961a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowD0 = ProfileViewModel.this.w1().d0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ProfileViewModel.this);
                this.f100961a = 1;
                if (flowD0.collect(anonymousClass1, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$4", f = "ProfileViewModel.kt", l = {108}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100964a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ProfileViewModel f100966a;

            AnonymousClass1(ProfileViewModel profileViewModel) {
                this.f100966a = profileViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ProfileViewState f(boolean z2, ProfileViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return ProfileViewState.b(updateState, null, null, null, z2, false, null, null, null, null, null, false, false, false, null, null, false, null, null, null, false, 1048567, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, Continuation continuation) {
                final boolean z2 = str.length() > 0;
                this.f100966a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.v1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileViewModel.AnonymousClass4.AnonymousClass1.f(z2, (ProfileViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass4(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ProfileViewModel.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f100964a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ0 = ProfileViewModel.this.t1().J0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ProfileViewModel.this);
                this.f100964a = 1;
                if (flowJ0.collect(anonymousClass1, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$5", f = "ProfileViewModel.kt", l = {115}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100967a;

        AnonymousClass5(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return ProfileViewModel.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f100967a;
            if (i3 == 0) {
                ResultKt.b(obj);
                ProfileViewModel profileViewModel = ProfileViewModel.this;
                this.f100967a = 1;
                if (profileViewModel.n1(this) == objF) {
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
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$6", f = "ProfileViewModel.kt", l = {119}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100969a;

        AnonymousClass6(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass6(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f100969a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SessionManager sessionManager = SessionManager.f127910a;
                this.f100969a = 1;
                if (sessionManager.D(this) == objF) {
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
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$7", f = "ProfileViewModel.kt", l = {123}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100970a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$7$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ProfileViewModel f100972a;

            AnonymousClass1(ProfileViewModel profileViewModel) {
                this.f100972a = profileViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ProfileViewState f(boolean z2, ProfileViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return ProfileViewState.b(updateState, null, null, null, false, false, null, null, null, null, null, z2, false, false, null, null, false, null, null, null, false, 1047551, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f100972a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.w1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileViewModel.AnonymousClass7.AnonymousClass1.f(z2, (ProfileViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass7(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ProfileViewModel.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f100970a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowJ = ProfileViewModel.this.v1().I().j(false);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(ProfileViewModel.this);
                this.f100970a = 1;
                if (stateFlowJ.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$8", f = "ProfileViewModel.kt", l = {135}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100973a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$8$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$8$1", f = "ProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<AutoTrialVariant, Boolean, Continuation<? super AutoTrialVariant>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f100975a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f100976b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ boolean f100977c;

            AnonymousClass1(Continuation continuation) {
                super(3, continuation);
            }

            public final Object h(AutoTrialVariant autoTrialVariant, boolean z2, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.f100976b = autoTrialVariant;
                anonymousClass1.f100977c = z2;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return h((AutoTrialVariant) obj, ((Boolean) obj2).booleanValue(), (Continuation) obj3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                AutoTrialVariant autoTrialVariant = (AutoTrialVariant) this.f100976b;
                boolean z2 = this.f100977c;
                IntrinsicsKt.f();
                if (this.f100975a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return z2 ? AutoTrialVariant.CardWithRetentionFlow : autoTrialVariant;
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$8$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ProfileViewModel f100978a;

            AnonymousClass2(ProfileViewModel profileViewModel) {
                this.f100978a = profileViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ProfileViewState f(AutoTrialVariant autoTrialVariant, ProfileViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return ProfileViewState.b(updateState, null, null, null, false, false, null, null, null, null, null, false, false, false, null, null, false, null, null, autoTrialVariant, false, 786431, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final AutoTrialVariant autoTrialVariant, Continuation continuation) {
                this.f100978a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.x1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileViewModel.AnonymousClass8.AnonymousClass2.f(autoTrialVariant, (ProfileViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass8(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ProfileViewModel.this.new AnonymousClass8(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f100973a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowM = FlowKt.m(ProfileViewModel.this.r1().h2(), BuildConfig.f95357b.booleanValue() ? ProfileViewModel.this.s1().D0() : FlowKt.K(Boxing.a(false)), new AnonymousClass1(null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(ProfileViewModel.this);
                this.f100973a = 1;
                if (flowM.collect(anonymousClass2, this) == objF) {
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
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9", f = "ProfileViewModel.kt", l = {158}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f100979a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass3<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ProfileViewModel f100981a;

            AnonymousClass3(ProfileViewModel profileViewModel) {
                this.f100981a = profileViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final ProfileViewState f(Long l3, ProfileViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return ProfileViewState.b(updateState, null, null, null, false, false, null, null, null, null, null, false, false, false, null, null, false, null, l3, null, false, 917503, null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final Long l3, Continuation continuation) {
                this.f100981a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.y1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileViewModel.AnonymousClass9.AnonymousClass3.f(l3, (ProfileViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass9(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ProfileViewModel.this.new AnonymousClass9(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f100979a;
            if (i3 == 0) {
                ResultKt.b(obj);
                final StateFlow stateFlowC = ProfileViewModel.this.v1().C();
                Flow flowM0 = FlowKt.m0(FlowKt.u(new Flow<Long>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public static final class AnonymousClass2<T> implements FlowCollector {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        final /* synthetic */ FlowCollector f100986a;

                        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata
                        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1$2", f = "ProfileViewModel.kt", l = {50}, m = "emit", v = 1)
                        public static final class AnonymousClass1 extends ContinuationImpl {

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            /* synthetic */ Object f100987a;

                            /* JADX INFO: renamed from: b, reason: collision with root package name */
                            int f100988b;

                            /* JADX INFO: renamed from: c, reason: collision with root package name */
                            Object f100989c;

                            /* JADX INFO: renamed from: f, reason: collision with root package name */
                            Object f100991f;

                            /* JADX INFO: renamed from: g, reason: collision with root package name */
                            Object f100992g;

                            /* JADX INFO: renamed from: h, reason: collision with root package name */
                            Object f100993h;

                            /* JADX INFO: renamed from: i, reason: collision with root package name */
                            int f100994i;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.f100987a = obj;
                                this.f100988b |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.f100986a = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
                            /*
                                r6 = this;
                                boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r8
                                cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1$2$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.f100988b
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.f100988b = r1
                                goto L18
                            L13:
                                cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1$2$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r8)
                            L18:
                                java.lang.Object r8 = r0.f100987a
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                                int r2 = r0.f100988b
                                r3 = 1
                                if (r2 == 0) goto L39
                                if (r2 != r3) goto L31
                                java.lang.Object r7 = r0.f100993h
                                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                                java.lang.Object r7 = r0.f100991f
                                cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1$2$1 r7 = (cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                                kotlin.ResultKt.b(r8)
                                goto L9a
                            L31:
                                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                                r7.<init>(r8)
                                throw r7
                            L39:
                                kotlin.ResultKt.b(r8)
                                kotlinx.coroutines.flow.FlowCollector r8 = r6.f100986a
                                r2 = r7
                                com.revenuecat.purchases.CustomerInfo r2 = (com.revenuecat.purchases.CustomerInfo) r2
                                r4 = 0
                                if (r2 == 0) goto L76
                                boolean r5 = cz.mobilesoft.coreblock.util.helperextension.RevenueCatExtKt.b(r2)
                                if (r5 == 0) goto L4b
                                goto L4c
                            L4b:
                                r2 = r4
                            L4c:
                                if (r2 == 0) goto L76
                                com.revenuecat.purchases.EntitlementInfos r2 = r2.getEntitlements()
                                if (r2 == 0) goto L76
                                java.util.Map r2 = r2.getAll()
                                if (r2 == 0) goto L76
                                cz.mobilesoft.coreblock.enums.Entitlement r5 = cz.mobilesoft.coreblock.enums.Entitlement.FreeMonthPremium
                                java.lang.String r5 = r5.getId()
                                java.lang.Object r2 = r2.get(r5)
                                com.revenuecat.purchases.EntitlementInfo r2 = (com.revenuecat.purchases.EntitlementInfo) r2
                                if (r2 == 0) goto L76
                                java.util.Date r2 = r2.getExpirationDate()
                                if (r2 == 0) goto L76
                                long r4 = r2.getTime()
                                java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.e(r4)
                            L76:
                                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                                r0.f100989c = r2
                                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                                r0.f100991f = r2
                                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                                r0.f100992g = r7
                                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                                r0.f100993h = r7
                                r7 = 0
                                r0.f100994i = r7
                                r0.f100988b = r3
                                java.lang.Object r7 = r8.emit(r4, r0)
                                if (r7 != r1) goto L9a
                                return r1
                            L9a:
                                kotlin.Unit r7 = kotlin.Unit.f139807a
                                return r7
                            */
                            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$9$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector flowCollector, Continuation continuation) {
                        Object objCollect = stateFlowC.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
                    }
                }), new ProfileViewModel$9$invokeSuspend$$inlined$flatMapLatest$1(null));
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(ProfileViewModel.this);
                this.f100979a = 1;
                if (flowM0.collect(anonymousClass3, this) == objF) {
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
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ProfileViewModel(Application application) {
        super(application, new ProfileViewState(null, null, null, false, AnswersSenderHelper.f127775a.d(), null, null, null, null, null, false, false, false, null, null, false, null, null, null, false, 1048559, null));
        Intrinsics.checkNotNullParameter(application, "application");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        final Object[] objArr2 = 0 == true ? 1 : 0;
        this.f100936o = LazyKt.a(lazyThreadSafetyModeB, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr, objArr2);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr3 = 0 == true ? 1 : 0;
        final Object[] objArr4 = 0 == true ? 1 : 0;
        this.f100937p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr3, objArr4);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr5 = 0 == true ? 1 : 0;
        final Object[] objArr6 = 0 == true ? 1 : 0;
        this.f100938q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr5, objArr6);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr7 = 0 == true ? 1 : 0;
        final Object[] objArr8 = 0 == true ? 1 : 0;
        this.f100939r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr7, objArr8);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr9 = 0 == true ? 1 : 0;
        final Object[] objArr10 = 0 == true ? 1 : 0;
        this.f100940s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr9, objArr10);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr11 = 0 == true ? 1 : 0;
        final Object[] objArr12 = 0 == true ? 1 : 0;
        this.f100941t = LazyKt.a(lazyThreadSafetyModeB6, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr11, objArr12);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr13 = 0 == true ? 1 : 0;
        final Object[] objArr14 = 0 == true ? 1 : 0;
        this.f100942u = LazyKt.a(lazyThreadSafetyModeB7, new Function0<StatisticsPermissionsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsPermissionsUseCase.class), objArr13, objArr14);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr15 = 0 == true ? 1 : 0;
        final Object[] objArr16 = 0 == true ? 1 : 0;
        this.f100943v = LazyKt.a(lazyThreadSafetyModeB8, new Function0<AverageStatisticsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AverageStatisticsUseCase.class), objArr15, objArr16);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr17 = 0 == true ? 1 : 0;
        final Object[] objArr18 = 0 == true ? 1 : 0;
        this.f100944w = LazyKt.a(lazyThreadSafetyModeB9, new Function0<CheckGuestPassEligibilityUseCase>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CheckGuestPassEligibilityUseCase.class), objArr17, objArr18);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr19 = 0 == true ? 1 : 0;
        final Object[] objArr20 = 0 == true ? 1 : 0;
        this.f100945x = LazyKt.a(lazyThreadSafetyModeB10, new Function0<CalculateYearlySavingsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CalculateYearlySavingsUseCase.class), objArr19, objArr20);
            }
        });
        G0(new AnonymousClass1(null));
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
        G0(new AnonymousClass3(null));
        G0(new AnonymousClass4(null));
        G0(new AnonymousClass5(null));
        G0(new AnonymousClass6(null));
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass7(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass8(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass9(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass10(null), 3, null);
        E1();
        j1();
        y1();
        UsageAccessHelper.f128032a.h(this);
    }

    public static /* synthetic */ void B1(ProfileViewModel profileViewModel, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        profileViewModel.A1(z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object C1(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateStatistics$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateStatistics$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateStatistics$1) r0
            int r1 = r0.f101055c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f101055c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateStatistics$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateStatistics$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f101053a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f101055c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L47
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.usecase.AverageStatisticsUseCase r5 = r4.o1()
            cz.mobilesoft.coreblock.usecase.AverageStatisticsUseCase$Params r2 = cz.mobilesoft.coreblock.usecase.AverageStatisticsUseCase.Params.f126930a
            kotlinx.coroutines.flow.Flow r5 = r5.c(r2)
            r0.f101055c = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
            if (r5 != r1) goto L47
            return r1
        L47:
            cz.mobilesoft.coreblock.usecase.AverageStatisticsUseCase$AverageStatistics r5 = (cz.mobilesoft.coreblock.usecase.AverageStatisticsUseCase.AverageStatistics) r5
            cz.mobilesoft.coreblock.scene.dashboard.profile.p1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.profile.p1
            r0.<init>()
            r4.Q0(r0)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel.C1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProfileViewState D1(AverageStatisticsUseCase.AverageStatistics averageStatistics, ProfileViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return ProfileViewState.b(updateState, null, null, null, false, false, null, null, averageStatistics.a(), averageStatistics.b(), averageStatistics.c(), false, false, false, null, null, false, null, null, null, false, 1047679, null);
    }

    private final void E1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new ProfileViewModel$updateTrialEligibility$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object F1(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateYearlySavings$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateYearlySavings$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateYearlySavings$1) r0
            int r1 = r0.f101066c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f101066c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateYearlySavings$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateYearlySavings$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f101064a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f101066c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase r5 = r4.p1()
            cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase$Params r2 = cz.mobilesoft.coreblock.usecase.CalculateYearlySavingsUseCase.Params.f126957a
            r0.f101066c = r3
            java.lang.Object r5 = r5.d(r2, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            cz.mobilesoft.coreblock.usecase.YearlySavingsData r5 = (cz.mobilesoft.coreblock.usecase.YearlySavingsData) r5
            cz.mobilesoft.coreblock.scene.dashboard.profile.o1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.profile.o1
            r0.<init>()
            r4.Q0(r0)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel.F1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProfileViewState G1(YearlySavingsData yearlySavingsData, ProfileViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return ProfileViewState.b(updateState, null, null, null, false, false, null, null, null, null, null, false, false, false, null, null, false, yearlySavingsData != null ? yearlySavingsData.d() : null, null, null, false, 983039, null);
    }

    public static final /* synthetic */ ProfileViewState V0(ProfileViewModel profileViewModel) {
        return (ProfileViewState) profileViewModel.I0();
    }

    private final void j1() {
        G0(new ProfileViewModel$checkPermissions$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(CustomerInfo customerInfo) {
        ProfileViewState profileViewState = (ProfileViewState) I0();
        boolean z2 = false;
        if (customerInfo != null && RevenueCatExtKt.b(customerInfo)) {
            z2 = true;
        }
        ProfileSectionItemType profileSectionItemType = profileViewState.m() instanceof PremiumState.None ? ProfileSectionItemType.Premium : z2 ? ProfileSectionItemType.MonthlyTrial : profileViewState.m() instanceof PremiumState.Subscription.External ? ProfileSectionItemType.MyProductPlan : profileViewState.m() instanceof PremiumState.Subscription ? ProfileSectionItemType.MySubscription : (!(profileViewState.m() instanceof PremiumState.Lifetime) && AccessPolicyKt.a(profileViewState.m(), Capability.SubscriptionFeatures)) ? null : ProfileSectionItemType.MyPremium;
        boolean z3 = profileViewState.t() instanceof SessionManager.SignedIn;
        final ArrayList arrayList = new ArrayList();
        if (z3) {
            arrayList.add(ProfileSectionItemType.Account);
        }
        if (profileSectionItemType != null) {
            arrayList.add(profileSectionItemType);
        }
        arrayList.add(ProfileSectionItemType.Backup);
        final ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ProfileSectionItemType.GeneralSettings);
        arrayList2.add(ProfileSectionItemType.CustomBlockingScreen);
        arrayList2.add(ProfileSectionItemType.AppIcon);
        arrayList2.add(ProfileSectionItemType.Notifications);
        arrayList2.add(ProfileSectionItemType.TimeNudge);
        arrayList2.add(ProfileSectionItemType.BlockingPreferences);
        arrayList2.add(ProfileSectionItemType.Statistics);
        final List listListOf = CollectionsKt.listOf((Object[]) new ProfileSectionItemType[]{ProfileSectionItemType.Help, ProfileSectionItemType.Troubleshooting});
        final ArrayList arrayList3 = new ArrayList();
        arrayList3.add(ProfileSectionItemType.RateUsOnGooglePlay);
        arrayList3.add(ProfileSectionItemType.News);
        arrayList3.add(ProfileSectionItemType.BlockedNotifications);
        if (profileViewState.r()) {
            arrayList3.add(ProfileSectionItemType.AdsRelevance);
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.q1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileViewModel.m1(arrayList, arrayList2, listListOf, arrayList3, (ProfileViewState) obj);
            }
        });
    }

    static /* synthetic */ void l1(ProfileViewModel profileViewModel, CustomerInfo customerInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            customerInfo = (CustomerInfo) profileViewModel.v1().C().getValue();
        }
        profileViewModel.k1(customerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProfileViewState m1(List list, List list2, List list3, List list4, ProfileViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return ProfileViewState.b(updateState, null, null, null, false, false, CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.a(Integer.valueOf(R.string.f95834q), list), TuplesKt.a(Integer.valueOf(R.string.rw), list2), TuplesKt.a(Integer.valueOf(R.string.Af), list3), TuplesKt.a(Integer.valueOf(R.string.mk), list4)}), null, null, null, null, false, false, false, null, null, false, null, null, null, false, 1048543, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n1(Continuation continuation) {
        Object objE = HaFRequestHelper.f107559a.e(continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    private final AverageStatisticsUseCase o1() {
        return (AverageStatisticsUseCase) this.f100943v.getValue();
    }

    private final CalculateYearlySavingsUseCase p1() {
        return (CalculateYearlySavingsUseCase) this.f100945x.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckGuestPassEligibilityUseCase q1() {
        return (CheckGuestPassEligibilityUseCase) this.f100944w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore r1() {
        return (CoreDataStore) this.f100940s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore s1() {
        return (DevDataStore) this.f100941t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore t1() {
        return (DiscountDataStore) this.f100936o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore u1() {
        return (EventDataStore) this.f100937p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 v1() {
        return (PremiumRepositoryV2) this.f100939r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsDataStore w1() {
        return (StatisticsDataStore) this.f100938q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsPermissionsUseCase x1() {
        return (StatisticsPermissionsUseCase) this.f100942u.getValue();
    }

    private final void y1() {
        AdsUtils.f127678i.v(A0(), new ProfileViewModel$initAdsRelevance$1(this));
    }

    public final void A1(boolean z2) {
        G0(new ProfileViewModel$signOut$1(z2, null));
    }

    @Override // cz.mobilesoft.coreblock.util.UsageAccessHelper.UsageAccessListener
    public void v0(boolean z2) {
        if (z2) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new ProfileViewModel$onApplicationAccessUpdateProgress$1(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: z1, reason: merged with bridge method [inline-methods] */
    public void O0(ProfileViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof ProfileViewEvent.SignOut) {
            B1(this, false, 1, null);
            return;
        }
        if (Intrinsics.areEqual(event, ProfileViewEvent.RequestSignUpLoginEvent.f100932a)) {
            G0(new ProfileViewModel$onEvent$1(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, ProfileViewEvent.ShowStatisticsPageEvent.f100933a)) {
            G0(new ProfileViewModel$onEvent$2(this, null));
            return;
        }
        if (event instanceof ProfileViewEvent.OnProfileSectionItemClicked) {
            G0(new ProfileViewModel$onEvent$3(this, event, null));
            return;
        }
        if (event instanceof ProfileViewEvent.OnSocialMediaItemClicked) {
            G0(new ProfileViewModel$onEvent$4(this, event, null));
            return;
        }
        if (Intrinsics.areEqual(event, ProfileViewEvent.OnBackupClicked.f100927a)) {
            G0(new ProfileViewModel$onEvent$5(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, ProfileViewEvent.OnPermissionsGranted.f100928a)) {
            j1();
            return;
        }
        if (Intrinsics.areEqual(event, ProfileViewEvent.DeleteAccount.f100924a)) {
            A1(true);
            return;
        }
        if (Intrinsics.areEqual(event, ProfileViewEvent.ShowWeeklyInsights.f100934a)) {
            G0(new ProfileViewModel$onEvent$6(this, null));
        } else if (event instanceof ProfileViewEvent.OnAdsConsentUpdated) {
            BuildersKt__Builders_commonKt.d(B0(), null, null, new ProfileViewModel$onEvent$7(this, event, null), 3, null);
        } else {
            if (!Intrinsics.areEqual(event, ProfileViewEvent.OnResume.f100930a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new ProfileViewModel$onEvent$8(this, null), 3, null);
        }
    }
}
