package cz.mobilesoft.coreblock.scene.premium.premium_expiring;

import android.app.Application;
import android.content.Context;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringActivity;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
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
public final class PremiumExpiringPurchaseViewModel extends PremiumScreenViewModel {
    private final String Q;
    private final String R;
    private final PremiumExpiringActivity.PremiumExpiringTrialType S;
    private final Lazy T;
    private final Lazy U;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseViewModel$2", f = "PremiumExpiringPurchaseViewModel.kt", l = {36}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f113556a;

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return PremiumExpiringPurchaseViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f113556a;
            if (i3 == 0) {
                ResultKt.b(obj);
                CoreDataStore coreDataStoreR1 = PremiumExpiringPurchaseViewModel.this.R1();
                PremiumRepositoryV2.PremiumExpiringFlowState premiumExpiringFlowState = PremiumRepositoryV2.PremiumExpiringFlowState.DoNotShow;
                this.f113556a = 1;
                if (coreDataStoreR1.O5(premiumExpiringFlowState, this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseViewModel$3", f = "PremiumExpiringPurchaseViewModel.kt", l = {37}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f113558a;

        AnonymousClass3(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return PremiumExpiringPurchaseViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f113558a;
            if (i3 == 0) {
                ResultKt.b(obj);
                DevDataStore devDataStoreC1 = PremiumExpiringPurchaseViewModel.this.c1();
                this.f113558a = 1;
                if (devDataStoreC1.m2(false, this) == objF) {
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

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f113560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f113561b;

        static {
            int[] iArr = new int[PremiumExpiringActivity.PremiumExpiringTrialType.values().length];
            try {
                iArr[PremiumExpiringActivity.PremiumExpiringTrialType.Monthly.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PremiumExpiringActivity.PremiumExpiringTrialType.Weekly.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f113560a = iArr;
            int[] iArr2 = new int[PremiumOptionPeriod.values().length];
            try {
                iArr2[PremiumOptionPeriod.Monthly.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[PremiumOptionPeriod.Yearly.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            f113561b = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PremiumExpiringPurchaseViewModel(Application application, String str, String str2, PremiumExpiringActivity.PremiumExpiringTrialType trialType) {
        super(application, new PremiumScreenViewState.PremiumScreenTypeViewState() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseViewModel.1
        });
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(trialType, "trialType");
        this.Q = str;
        this.R = str2;
        this.S = trialType;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.T = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseViewModel$special$$inlined$inject$default$1
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
        this.U = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr2, objArr3);
            }
        });
        G0(new AnonymousClass2(null));
        G0(new AnonymousClass3(null));
        f2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore R1() {
        return (CoreDataStore) this.T.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore c1() {
        return (DevDataStore) this.U.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel.AnalyticsData Q1() {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringPurchaseViewModel.Q1():cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$AnalyticsData");
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected String a2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    protected String c2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    public Object h2(Continuation continuation) {
        int i3 = WhenMappings.f113560a[this.S.ordinal()];
        if (i3 == 1) {
            return RevenueCatPlacement.PromoTrialUpgrade;
        }
        if (i3 == 2) {
            return RevenueCatPlacement.PremiumRetention;
        }
        throw new NoWhenBranchMatchedException();
    }
}
