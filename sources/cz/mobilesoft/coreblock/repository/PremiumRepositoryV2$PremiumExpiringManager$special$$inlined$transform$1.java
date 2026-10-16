package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1", f = "PremiumRepositoryV2.kt", l = {36}, m = "invokeSuspend", v = 1)
public final class PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f97720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f97721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PremiumRepositoryV2.PremiumExpiringManager f97722d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FlowCollector f97723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PremiumRepositoryV2.PremiumExpiringManager f97724b;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1$1", f = "PremiumRepositoryV2.kt", l = {39}, m = "emit", v = 1)
        public static final class C02651 extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            /* synthetic */ Object f97725a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f97726b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            Object f97728d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            Object f97729f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f97730g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f97731h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            int f97732i;

            public C02651(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f97725a = obj;
                this.f97726b |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, PremiumRepositoryV2.PremiumExpiringManager premiumExpiringManager) {
            this.f97724b = premiumExpiringManager;
            this.f97723a = flowCollector;
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
                boolean r0 = r8 instanceof cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1.AnonymousClass1.C02651
                if (r0 == 0) goto L13
                r0 = r8
                cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1$1$1 r0 = (cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1.AnonymousClass1.C02651) r0
                int r1 = r0.f97726b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f97726b = r1
                goto L18
            L13:
                cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1$1$1 r0 = new cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1$1$1
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f97725a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f97726b
                r3 = 1
                if (r2 == 0) goto L3d
                if (r2 != r3) goto L35
                java.lang.Object r7 = r0.f97731h
                kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                java.lang.Object r7 = r0.f97730g
                com.revenuecat.purchases.CustomerInfo r7 = (com.revenuecat.purchases.CustomerInfo) r7
                java.lang.Object r7 = r0.f97729f
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                kotlin.ResultKt.b(r8)
                goto L81
            L35:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3d:
                kotlin.ResultKt.b(r8)
                kotlinx.coroutines.flow.FlowCollector r8 = r6.f97723a
                r2 = r7
                com.revenuecat.purchases.CustomerInfo r2 = (com.revenuecat.purchases.CustomerInfo) r2
                cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager r4 = r6.f97724b
                boolean r4 = cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.PremiumExpiringManager.d(r4)
                r5 = 0
                if (r4 != 0) goto L59
                cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager r4 = r6.f97724b
                boolean r4 = cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.PremiumExpiringManager.c(r4)
                if (r4 == 0) goto L57
                goto L59
            L57:
                r4 = r5
                goto L5a
            L59:
                r4 = r3
            L5a:
                java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                r0.f97728d = r7
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
                r0.f97729f = r7
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
                r0.f97730g = r7
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
                r0.f97731h = r7
                r0.f97732i = r5
                r0.f97726b = r3
                java.lang.Object r7 = r8.emit(r4, r0)
                if (r7 != r1) goto L81
                return r1
            L81:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1(Flow flow, Continuation continuation, PremiumRepositoryV2.PremiumExpiringManager premiumExpiringManager) {
        super(2, continuation);
        this.f97721c = flow;
        this.f97722d = premiumExpiringManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1 premiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1 = new PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1(this.f97721c, continuation, this.f97722d);
        premiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1.f97720b = obj;
        return premiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f97719a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f97720b;
            Flow flow = this.f97721c;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(flowCollector, this.f97722d);
            this.f97720b = SpillingKt.a(flowCollector);
            this.f97719a = 1;
            if (flow.collect(anonymousClass1, this) == objF) {
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
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((PremiumRepositoryV2$PremiumExpiringManager$special$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
