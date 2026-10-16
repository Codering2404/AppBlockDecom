package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.util.CrashHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2Kt$premiumExpiringCardFlow$1", f = "PremiumRepositoryV2.kt", l = {696}, m = "invokeSuspend", v = 1)
final class PremiumRepositoryV2Kt$premiumExpiringCardFlow$1 extends SuspendLambda implements Function3<FlowCollector<? super Boolean>, Throwable, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f97854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f97855c;

    PremiumRepositoryV2Kt$premiumExpiringCardFlow$1(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        FlowCollector flowCollector = (FlowCollector) this.f97854b;
        Throwable th = (Throwable) this.f97855c;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f97853a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CrashHelper.j(th);
            Boolean boolA = Boxing.a(true);
            this.f97854b = SpillingKt.a(flowCollector);
            this.f97855c = SpillingKt.a(th);
            this.f97853a = 1;
            if (flowCollector.emit(boolA, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector flowCollector, Throwable th, Continuation continuation) {
        PremiumRepositoryV2Kt$premiumExpiringCardFlow$1 premiumRepositoryV2Kt$premiumExpiringCardFlow$1 = new PremiumRepositoryV2Kt$premiumExpiringCardFlow$1(continuation);
        premiumRepositoryV2Kt$premiumExpiringCardFlow$1.f97854b = flowCollector;
        premiumRepositoryV2Kt$premiumExpiringCardFlow$1.f97855c = th;
        return premiumRepositoryV2Kt$premiumExpiringCardFlow$1.invokeSuspend(Unit.f139807a);
    }
}
