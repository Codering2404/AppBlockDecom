package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringManager$showPremiumExpiringScreenStateFlow$1", f = "PremiumRepositoryV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class PremiumRepositoryV2$PremiumExpiringManager$showPremiumExpiringScreenStateFlow$1 extends SuspendLambda implements Function4<Boolean, PremiumRepositoryV2.PremiumExpiringFlowState, Boolean, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ boolean f97716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f97717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ boolean f97718d;

    PremiumRepositoryV2$PremiumExpiringManager$showPremiumExpiringScreenStateFlow$1(Continuation continuation) {
        super(4, continuation);
    }

    public final Object h(boolean z2, PremiumRepositoryV2.PremiumExpiringFlowState premiumExpiringFlowState, boolean z3, Continuation continuation) {
        PremiumRepositoryV2$PremiumExpiringManager$showPremiumExpiringScreenStateFlow$1 premiumRepositoryV2$PremiumExpiringManager$showPremiumExpiringScreenStateFlow$1 = new PremiumRepositoryV2$PremiumExpiringManager$showPremiumExpiringScreenStateFlow$1(continuation);
        premiumRepositoryV2$PremiumExpiringManager$showPremiumExpiringScreenStateFlow$1.f97716b = z2;
        premiumRepositoryV2$PremiumExpiringManager$showPremiumExpiringScreenStateFlow$1.f97717c = premiumExpiringFlowState;
        premiumRepositoryV2$PremiumExpiringManager$showPremiumExpiringScreenStateFlow$1.f97718d = z3;
        return premiumRepositoryV2$PremiumExpiringManager$showPremiumExpiringScreenStateFlow$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return h(((Boolean) obj).booleanValue(), (PremiumRepositoryV2.PremiumExpiringFlowState) obj2, ((Boolean) obj3).booleanValue(), (Continuation) obj4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean z2 = this.f97716b;
        PremiumRepositoryV2.PremiumExpiringFlowState premiumExpiringFlowState = (PremiumRepositoryV2.PremiumExpiringFlowState) this.f97717c;
        boolean z3 = this.f97718d;
        IntrinsicsKt.f();
        if (this.f97715a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        boolean z4 = true;
        if (!z2 && (premiumExpiringFlowState != PremiumRepositoryV2.PremiumExpiringFlowState.Show || !z3)) {
            z4 = false;
        }
        return Boxing.a(z4);
    }
}
