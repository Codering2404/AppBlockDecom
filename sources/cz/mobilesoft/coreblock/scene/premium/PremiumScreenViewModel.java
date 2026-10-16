package cz.mobilesoft.coreblock.scene.premium;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreTransaction;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewEvent;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumDTOsKt;
import cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO;
import cz.mobilesoft.coreblock.scene.premium.dto.PurchaseSuccessDTO;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.PaywallDataStore;
import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.analytics.FacebookLogger;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.subscription.DiscountRepository;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
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
public abstract class PremiumScreenViewModel extends BaseBillingViewModel<PremiumScreenViewState, PremiumScreenViewEvent, PremiumScreenViewCommand> {
    private final Lazy C;
    private final Lazy D;
    private final Lazy E;
    private final Lazy F;
    private final Lazy G;
    private final Lazy H;
    private final Lazy I;
    private boolean J;
    private final boolean K;
    private final Long L;
    private final boolean M;
    private final boolean N;
    private Job O;
    private PremiumOptionDTO P;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnalyticsData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bundle f112364a;

        public AnalyticsData(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            this.f112364a = bundle;
        }

        public final Bundle a() {
            return this.f112364a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AnalyticsData) && Intrinsics.areEqual(this.f112364a, ((AnalyticsData) obj).f112364a);
        }

        public int hashCode() {
            return this.f112364a.hashCode();
        }

        public String toString() {
            return "AnalyticsData(bundle=" + this.f112364a + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PremiumScreenViewModel(Application application, PremiumScreenViewState.PremiumScreenTypeViewState premiumScreenTypeViewState) {
        super(application, new PremiumScreenViewState(premiumScreenTypeViewState, null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -2, 1, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(premiumScreenTypeViewState, "premiumScreenTypeViewState");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.C = LazyKt.a(lazyThreadSafetyModeB, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$special$$inlined$inject$default$1
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
        this.D = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PaywallDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PaywallDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.E = LazyKt.a(lazyThreadSafetyModeB3, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.F = LazyKt.a(lazyThreadSafetyModeB4, new Function0<RatingDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RatingDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.G = LazyKt.a(lazyThreadSafetyModeB5, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.H = LazyKt.a(lazyThreadSafetyModeB6, new Function0<DiscountRepository>() { // from class: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountRepository.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.I = LazyKt.a(lazyThreadSafetyModeB7, new Function0<FacebookLogger>() { // from class: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FacebookLogger.class), objArr12, objArr13);
            }
        });
        this.K = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0160 A[LOOP:0: B:44:0x015a->B:46:0x0160, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object A2(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel r30, com.revenuecat.purchases.Offering r31, kotlin.coroutines.Continuation r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel.A2(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel, com.revenuecat.purchases.Offering, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final /* synthetic */ PremiumScreenViewState G1(PremiumScreenViewModel premiumScreenViewModel) {
        return (PremiumScreenViewState) premiumScreenViewModel.I0();
    }

    static /* synthetic */ Object P1(PremiumScreenViewModel premiumScreenViewModel, Continuation continuation) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore R1() {
        return (CoreDataStore) this.E.getValue();
    }

    private final RatingDataStore X1() {
        return (RatingDataStore) this.F.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore c1() {
        return (DevDataStore) this.G.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010b, code lost:
    
        if (cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore.D1(r3, r6, r5, null, r8, 4, null) == r2) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x015d, code lost:
    
        if (r1 == r2) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e2(cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel.e2(cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState g2(PremiumScreenViewModel premiumScreenViewModel, PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, premiumScreenViewModel.c2(premiumScreenViewModel.A0()), premiumScreenViewModel.a2(premiumScreenViewModel.A0()), premiumScreenViewModel.Z1(premiumScreenViewModel.A0()), premiumScreenViewModel.Y1(premiumScreenViewModel.A0()), false, false, false, -1006632961, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState k2(PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, false, true, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -1025, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState l2(PremiumScreenViewEvent premiumScreenViewEvent, PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, ((PremiumScreenViewEvent.OnOptionSelected) premiumScreenViewEvent).a(), null, null, null, false, false, false, null, null, null, null, null, false, false, false, -262145, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState m2(PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, false, false, new PurchaseSuccessDTO(System.currentTimeMillis(), false, false), false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -2049, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState n2(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState r38) {
        /*
            java.lang.String r0 = "$this$updateState"
            r1 = r38
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r0 = r1.D()
            if (r0 == 0) goto L1f
            kotlinx.collections.immutable.ImmutableList r2 = r1.w()
            boolean r2 = r2.contains(r0)
            if (r2 == 0) goto L18
            goto L19
        L18:
            r0 = 0
        L19:
            if (r0 != 0) goto L1c
            goto L1f
        L1c:
            r20 = r0
            goto L30
        L1f:
            kotlinx.collections.immutable.ImmutableList r0 = r1.w()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r0 = (cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO) r0
            if (r0 != 0) goto L1c
            cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r0 = r1.D()
            goto L1c
        L30:
            r36 = 1
            r37 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = -262145(0xfffffffffffbffff, float:NaN)
            cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState r0 = cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.b(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel.n2(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState):cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState o2(PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        PremiumOptionDTO premiumOptionDTOH = updateState.h();
        if (premiumOptionDTOH == null) {
            premiumOptionDTOH = updateState.D();
        }
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, premiumOptionDTOH, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -262145, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState p2(PremiumScreenViewEvent premiumScreenViewEvent, PremiumScreenViewState updateState) {
        Object next;
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        Iterator<E> it = updateState.u().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((PremiumOptionDTO) next).h() == ((PremiumScreenViewEvent.OnTrialToggleClicked) premiumScreenViewEvent).a()) {
                break;
            }
        }
        PremiumOptionDTO premiumOptionDTO = (PremiumOptionDTO) next;
        if (premiumOptionDTO == null) {
            premiumOptionDTO = (PremiumOptionDTO) CollectionsKt.firstOrNull((List) updateState.u());
        }
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, premiumOptionDTO, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -262145, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState q2(PremiumScreenViewModel premiumScreenViewModel, PremiumOptionDTO premiumOptionDTO, boolean z2, PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        premiumScreenViewModel.G0(new PremiumScreenViewModel$onPurchasedOrAlreadyOwned$2$1(premiumScreenViewModel, null));
        boolean z3 = false;
        if (premiumOptionDTO != null && premiumOptionDTO.h()) {
            z3 = true;
        }
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, false, false, new PurchaseSuccessDTO(System.currentTimeMillis(), z3, z2), false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -2049, 1, null);
    }

    private final void r2(Activity activity, PremiumOptionDTO premiumOptionDTO) {
        if (!Intrinsics.areEqual(b1().getValue(), Success.f128020a) || premiumOptionDTO == null) {
            this.P = null;
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.t
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PremiumScreenViewModel.t2((PremiumScreenViewState) obj);
                }
            });
            return;
        }
        this.P = premiumOptionDTO;
        if (BuildConfig.f95357b.booleanValue()) {
            AnswersHelper.f128199a.x8(false);
        }
        q1(activity, premiumOptionDTO.k(), premiumOptionDTO.l());
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PremiumScreenViewModel.s2((PremiumScreenViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState s2(PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -513, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState t2(PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, true, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -513, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState v2(PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, null, null, new FailedWithError(null, null, null, null, 15, null), null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -5, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState w2(java.util.List r38, cz.mobilesoft.coreblock.enums.PremiumDevState r39, cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel r40, com.revenuecat.purchases.Offering r41, boolean r42, cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState r43) {
        /*
            java.lang.String r0 = "$this$updateState"
            r1 = r43
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = r38
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r2 = r0.iterator()
        Lf:
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 == 0) goto L26
            java.lang.Object r3 = r2.next()
            r5 = r3
            cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r5 = (cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO) r5
            cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod r5 = r5.j()
            cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod r6 = cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod.Yearly
            if (r5 != r6) goto Lf
            goto L27
        L26:
            r3 = r4
        L27:
            r21 = r3
            cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r21 = (cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO) r21
            cz.mobilesoft.coreblock.enums.PremiumState r2 = r39.getState()
            if (r2 == 0) goto L3a
            boolean r2 = r2.g()
            if (r2 != 0) goto L3a
            r22 = r4
            goto L57
        L3a:
            java.util.Iterator r2 = r0.iterator()
        L3e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L52
            java.lang.Object r3 = r2.next()
            r5 = r3
            cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r5 = (cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO) r5
            boolean r5 = r5.o()
            if (r5 == 0) goto L3e
            goto L53
        L52:
            r3 = r4
        L53:
            cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r3 = (cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO) r3
            r22 = r3
        L57:
            boolean r2 = r40.W1()
            if (r2 == 0) goto L60
            if (r22 == 0) goto L60
            goto L6a
        L60:
            if (r22 == 0) goto L66
            cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod r4 = r22.j()
        L66:
            cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod r2 = cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod.Lifetime
            if (r4 != r2) goto L6d
        L6a:
            r20 = r22
            goto L78
        L6d:
            if (r21 != 0) goto L76
            cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO r2 = r1.D()
            r20 = r2
            goto L78
        L76:
            r20 = r21
        L78:
            kotlinx.collections.immutable.ImmutableList r9 = kotlinx.collections.immutable.ExtensionsKt.h(r0)
            cz.mobilesoft.coreblock.util.Success r3 = cz.mobilesoft.coreblock.util.Success.f128020a
            r36 = 1
            r37 = 0
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = -1966791(0xffffffffffe1fd39, float:NaN)
            r4 = r3
            r8 = r41
            r19 = r42
            cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState r0 = cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState.b(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel.w2(java.util.List, cz.mobilesoft.coreblock.enums.PremiumDevState, cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel, com.revenuecat.purchases.Offering, boolean, cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState):cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState x2(PremiumScreenViewModel premiumScreenViewModel, PremiumScreenViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PremiumScreenViewState.b(updateState, null, null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, premiumScreenViewModel.c2(premiumScreenViewModel.A0()), premiumScreenViewModel.a2(premiumScreenViewModel.A0()), premiumScreenViewModel.Z1(premiumScreenViewModel.A0()), premiumScreenViewModel.Y1(premiumScreenViewModel.A0()), false, false, false, -1006632961, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object y2(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel r10, com.revenuecat.purchases.CustomerInfo r11, java.util.List r12, com.revenuecat.purchases.Offering r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel.y2(cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel, com.revenuecat.purchases.CustomerInfo, java.util.List, com.revenuecat.purchases.Offering, kotlin.coroutines.Continuation):java.lang.Object");
    }

    protected Object O1(Continuation continuation) {
        return P1(this, continuation);
    }

    public abstract AnalyticsData Q1();

    protected final DiscountDataStore S1() {
        return (DiscountDataStore) this.C.getValue();
    }

    protected final DiscountRepository T1() {
        return (DiscountRepository) this.H.getValue();
    }

    public Long U1() {
        return this.L;
    }

    protected final PaywallDataStore V1() {
        return (PaywallDataStore) this.D.getValue();
    }

    protected boolean W1() {
        return this.N;
    }

    protected String Y1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    protected String Z1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    protected abstract String a2(Context context);

    public boolean b2() {
        return this.K;
    }

    protected abstract String c2(Context context);

    protected final FacebookLogger d1() {
        return (FacebookLogger) this.I.getValue();
    }

    protected boolean d2() {
        return this.M;
    }

    public final void f2() {
        this.J = true;
        G0(new PremiumScreenViewModel$initialize$1(this, null));
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PremiumScreenViewModel.g2(this.f114021a, (PremiumScreenViewState) obj);
            }
        });
        FlowExtKt.i(FlowKt.m(i1().C(), j1(), new PremiumScreenViewModel$initialize$3(null)), C0(), new PremiumScreenViewModel$initialize$4(this));
        FlowKt.Q(FlowKt.V(R1().P2(), new PremiumScreenViewModel$initialize$5(this, null)), B0());
        FlowKt.Q(FlowKt.V(b1(), new PremiumScreenViewModel$initialize$6(this, null)), B0());
        FlowKt.Q(FlowKt.V(FlowKt.h0(k1(), B0(), SharingStarted.Companion.b(SharingStarted.f142210a, 0L, 0L, 3, null), null), new PremiumScreenViewModel$initialize$7(this, null)), B0());
        FlowKt.Q(FlowKt.V(S1().j1(), new PremiumScreenViewModel$initialize$8(this, null)), B0());
        FlowKt.Q(FlowKt.V(X1().Z(), new PremiumScreenViewModel$initialize$9(this, null)), B0());
        FlowKt.Q(FlowKt.V(X1().Y(), new PremiumScreenViewModel$initialize$10(this, null)), B0());
        FlowKt.Q(FlowKt.V(R1().Q2(), new PremiumScreenViewModel$initialize$11(this, null)), B0());
        FlowKt.Q(FlowKt.V(R1().A2(), new PremiumScreenViewModel$initialize$12(this, null)), B0());
        FlowKt.Q(FlowKt.V(R1().V2(), new PremiumScreenViewModel$initialize$13(this, null)), B0());
        FlowKt.Q(FlowKt.V(R1().C3(), new PremiumScreenViewModel$initialize$14(this, null)), B0());
        FlowKt.Q(FlowKt.V(R1().i3(), new PremiumScreenViewModel$initialize$15(this, null)), B0());
        FlowKt.Q(FlowKt.V(R1().j3(), new PremiumScreenViewModel$initialize$16(this, null)), B0());
        FlowKt.Q(FlowKt.V(S1().e1(), new PremiumScreenViewModel$initialize$17(this, null)), B0());
        BuildersKt__Builders_commonKt.d(B0(), null, null, new PremiumScreenViewModel$initialize$18(this, null), 3, null);
        FlowKt.Q(FlowKt.V(R1().C2(), new PremiumScreenViewModel$initialize$19(this, null)), B0());
    }

    public abstract Object h2(Continuation continuation);

    protected void i2() {
        AnswersHelper.f128199a.b4(Q1());
        FacebookLogger facebookLoggerD1 = d1();
        String string = Q1().a().getString("premium_screen_type", "premium");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        facebookLoggerD1.d(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: j2, reason: merged with bridge method [inline-methods] */
    public void O0(final PremiumScreenViewEvent event) throws NotInitializedException {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.J && BuildConfig.f95357b.booleanValue() && b2()) {
            throw new NotInitializedException();
        }
        if (Intrinsics.areEqual(event, PremiumScreenViewEvent.OnTryAgain.f112363a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.y
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PremiumScreenViewModel.k2((PremiumScreenViewState) obj);
                }
            });
            n1();
            return;
        }
        if (event instanceof PremiumScreenViewEvent.OnReloadProducts) {
            n1();
            return;
        }
        if (event instanceof PremiumScreenViewEvent.OnOptionSelected) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.z
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PremiumScreenViewModel.l2(event, (PremiumScreenViewState) obj);
                }
            });
            return;
        }
        if (event instanceof PremiumScreenViewEvent.OnPurchase) {
            PremiumScreenViewState premiumScreenViewState = (PremiumScreenViewState) I0();
            AnswersHelper.f128199a.a4(Q1());
            PremiumScreenViewEvent.OnPurchase onPurchase = (PremiumScreenViewEvent.OnPurchase) event;
            PremiumOptionDTO premiumOptionDTOB = onPurchase.b();
            if (premiumOptionDTOB == null) {
                premiumOptionDTOB = premiumScreenViewState.D();
            }
            r2(onPurchase.a(), premiumOptionDTOB);
            return;
        }
        if (Intrinsics.areEqual(event, PremiumScreenViewEvent.OnPremiumCodeRedeemed.f112356a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.a0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PremiumScreenViewModel.m2((PremiumScreenViewState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, PremiumScreenViewEvent.OnOtherOptionsClicked.f112355a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.b0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PremiumScreenViewModel.n2((PremiumScreenViewState) obj);
                }
            });
            G0(new PremiumScreenViewModel$onEvent$6(this, null));
            return;
        }
        if (Intrinsics.areEqual(event, PremiumScreenViewEvent.OnOtherOptionsBottomSheetHidden.f112354a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.c0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PremiumScreenViewModel.o2((PremiumScreenViewState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, PremiumScreenViewEvent.ManageSubscriptionClicked.f112350a)) {
            return;
        }
        if (Intrinsics.areEqual(event, PremiumScreenViewEvent.OnExitPaywallDialogDismissed.f112351a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new PremiumScreenViewModel$onEvent$8(this, null), 3, null);
            return;
        }
        if (event instanceof PremiumScreenViewEvent.OnTrialToggleClicked) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PremiumScreenViewModel.p2(event, (PremiumScreenViewState) obj);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(event, PremiumScreenViewEvent.OnFinishClicked.f112352a)) {
            G0(new PremiumScreenViewModel$onEvent$10(this, null));
        } else if (Intrinsics.areEqual(event, PremiumScreenViewEvent.OnShareReferralLinkClicked.f112360a)) {
            G0(new PremiumScreenViewModel$onEvent$11(this, null));
        } else if (!Intrinsics.areEqual(event, PremiumScreenViewEvent.OnShared.f112361a)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel
    public void o1(PurchaseResult purchaseResult, final boolean z2) {
        PricingPhase introPhase;
        Long lU1;
        StoreTransaction storeTransaction;
        List<String> productIds;
        String str;
        super.o1(purchaseResult, false);
        final PremiumOptionDTO premiumOptionDTO = this.P;
        if (premiumOptionDTO == null) {
            premiumOptionDTO = null;
            Object obj = null;
            premiumOptionDTO = null;
            premiumOptionDTO = null;
            premiumOptionDTO = null;
            if (purchaseResult != null && (storeTransaction = purchaseResult.getStoreTransaction()) != null && (productIds = storeTransaction.getProductIds()) != null && (str = (String) CollectionsKt.firstOrNull((List) productIds)) != null) {
                Iterator<E> it = ((PremiumScreenViewState) I0()).u().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((PremiumOptionDTO) next).k(), str)) {
                        obj = next;
                        break;
                    }
                }
                premiumOptionDTO = (PremiumOptionDTO) obj;
            }
        }
        if (!z2 && premiumOptionDTO != null) {
            AnswersHelper answersHelper = AnswersHelper.f128199a;
            answersHelper.N3(Q1());
            GoogleSubscriptionOption googleSubscriptionOptionL = premiumOptionDTO.l();
            if (googleSubscriptionOptionL != null && (introPhase = googleSubscriptionOptionL.getIntroPhase()) != null && (lU1 = U1()) != null) {
                answersHelper.G1(lU1.longValue(), premiumOptionDTO.l().getOfferId(), PremiumDTOsKt.b(introPhase.getPrice()), introPhase.getPrice().getCurrencyCode());
            }
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return PremiumScreenViewModel.q2(this.f113774a, premiumOptionDTO, z2, (PremiumScreenViewState) obj2);
            }
        });
        if (BuildConfig.f95357b.booleanValue()) {
            AnswersHelper.f128199a.x8(true);
        }
    }

    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel
    public void p1() {
        G0(new PremiumScreenViewModel$onUserCancelledPurchase$1(this, null));
    }

    public Object u2(CustomerInfo customerInfo, List list, Offering offering, Continuation continuation) {
        return y2(this, customerInfo, list, offering, continuation);
    }

    public Object z2(Offering offering, Continuation continuation) {
        return A2(this, offering, continuation);
    }
}
