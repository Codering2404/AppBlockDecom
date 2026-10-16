package cz.mobilesoft.coreblock.repository;

import com.revenuecat.purchases.CustomerInfo;
import cz.mobilesoft.coreblock.enums.PremiumState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2Kt$premiumExpiringCardFlow$2", f = "PremiumRepositoryV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class PremiumRepositoryV2Kt$premiumExpiringCardFlow$2 extends SuspendLambda implements Function6<CustomerInfo, PremiumState, Boolean, Boolean, Boolean, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f97857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f97858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ boolean f97859d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ boolean f97860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    /* synthetic */ boolean f97861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f97862h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumRepositoryV2Kt$premiumExpiringCardFlow$2(boolean z2, Continuation continuation) {
        super(6, continuation);
        this.f97862h = z2;
    }

    public final Object h(CustomerInfo customerInfo, PremiumState premiumState, boolean z2, boolean z3, boolean z4, Continuation continuation) {
        PremiumRepositoryV2Kt$premiumExpiringCardFlow$2 premiumRepositoryV2Kt$premiumExpiringCardFlow$2 = new PremiumRepositoryV2Kt$premiumExpiringCardFlow$2(this.f97862h, continuation);
        premiumRepositoryV2Kt$premiumExpiringCardFlow$2.f97857b = customerInfo;
        premiumRepositoryV2Kt$premiumExpiringCardFlow$2.f97858c = premiumState;
        premiumRepositoryV2Kt$premiumExpiringCardFlow$2.f97859d = z2;
        premiumRepositoryV2Kt$premiumExpiringCardFlow$2.f97860f = z3;
        premiumRepositoryV2Kt$premiumExpiringCardFlow$2.f97861g = z4;
        return premiumRepositoryV2Kt$premiumExpiringCardFlow$2.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CustomerInfo customerInfo = (CustomerInfo) this.f97857b;
        PremiumState premiumState = (PremiumState) this.f97858c;
        boolean z2 = this.f97859d;
        boolean z3 = this.f97860f;
        boolean z4 = this.f97861g;
        IntrinsicsKt.f();
        if (this.f97856a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return Boxing.a(z3 ? true : PremiumRepositoryV2Kt.b(customerInfo, premiumState, this.f97862h, z2, z4));
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Object k(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return h((CustomerInfo) obj, (PremiumState) obj2, ((Boolean) obj3).booleanValue(), ((Boolean) obj4).booleanValue(), ((Boolean) obj5).booleanValue(), (Continuation) obj6);
    }
}
