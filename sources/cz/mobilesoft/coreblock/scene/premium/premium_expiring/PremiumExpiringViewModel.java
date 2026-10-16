package cz.mobilesoft.coreblock.scene.premium.premium_expiring;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.dto.TrialSummaryData;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchTrialSummaryUseCase;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewState;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class PremiumExpiringViewModel extends BaseStatefulViewModel<PremiumExpiringViewState, PremiumExpiringViewEvent, PremiumExpiringViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f113568o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f113569p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f113570q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f113571r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f113572s;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewModel$1", f = "PremiumExpiringViewModel.kt", l = {35, 42, 45, 49}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f113573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f113574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f113575c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f113576d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f113577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f113578g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Application f113580i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Application application, Continuation continuation) {
            super(1, continuation);
            this.f113580i = application;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PremiumExpiringViewState y(PremiumExpiringViewState.ScreenType screenType, PremiumExpiringViewState premiumExpiringViewState) {
            return PremiumExpiringViewState.b(premiumExpiringViewState, null, screenType, null, null, null, 29, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PremiumExpiringViewState z(List list, TrialSummaryData trialSummaryData, PremiumExpiringViewModel premiumExpiringViewModel, PremiumExpiringViewState premiumExpiringViewState) {
            Long lH = premiumExpiringViewModel.Z0().I().h();
            String strN = null;
            if (lH != null) {
                if (!TimeHelperExt.f128663a.y(lH.longValue())) {
                    lH = null;
                }
                if (lH != null) {
                    strN = DateHelperExtKt.n(lH.longValue());
                }
            }
            return PremiumExpiringViewState.b(premiumExpiringViewState, list, null, trialSummaryData, strN, premiumExpiringViewModel.Z0().I().e(), 2, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return PremiumExpiringViewModel.this.new AnonymousClass1(this.f113580i, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00f0  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0148 A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 365
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PremiumExpiringViewModel(Application application) {
        super(application, new PremiumExpiringViewState(null, null, null, null, null, 31, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f113568o = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f113569p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f113570q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewModel$special$$inlined$inject$default$3
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
        this.f113571r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<FetchTrialSummaryUseCase>() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchTrialSummaryUseCase.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f113572s = LazyKt.a(lazyThreadSafetyModeB5, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr8, objArr9);
            }
        });
        AnswersHelper.f128199a.U3(Z0().I().e() != null);
        G0(new AnonymousClass1(application, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore X0() {
        return (CoreDataStore) this.f113570q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FetchTrialSummaryUseCase Y0() {
        return (FetchTrialSummaryUseCase) this.f113571r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 Z0() {
        return (PremiumRepositoryV2) this.f113572s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao a1() {
        return (ProfileDao) this.f113568o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository b1() {
        return (QuickBlockRepository) this.f113569p.getValue();
    }
}
