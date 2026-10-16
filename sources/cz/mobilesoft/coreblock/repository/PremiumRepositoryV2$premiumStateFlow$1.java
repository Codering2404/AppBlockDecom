package cz.mobilesoft.coreblock.repository;

import com.revenuecat.purchases.CustomerInfo;
import cz.mobilesoft.coreblock.enums.PremiumDevState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$premiumStateFlow$1", f = "PremiumRepositoryV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class PremiumRepositoryV2$premiumStateFlow$1 extends SuspendLambda implements Function4<Boolean, CustomerInfo, PremiumDevState, Continuation<? super Triple<? extends Boolean, ? extends CustomerInfo, ? extends PremiumDevState>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ boolean f97806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f97807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f97808d;

    PremiumRepositoryV2$premiumStateFlow$1(Continuation continuation) {
        super(4, continuation);
    }

    public final Object h(boolean z2, CustomerInfo customerInfo, PremiumDevState premiumDevState, Continuation continuation) {
        PremiumRepositoryV2$premiumStateFlow$1 premiumRepositoryV2$premiumStateFlow$1 = new PremiumRepositoryV2$premiumStateFlow$1(continuation);
        premiumRepositoryV2$premiumStateFlow$1.f97806b = z2;
        premiumRepositoryV2$premiumStateFlow$1.f97807c = customerInfo;
        premiumRepositoryV2$premiumStateFlow$1.f97808d = premiumDevState;
        return premiumRepositoryV2$premiumStateFlow$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return h(((Boolean) obj).booleanValue(), (CustomerInfo) obj2, (PremiumDevState) obj3, (Continuation) obj4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean z2 = this.f97806b;
        CustomerInfo customerInfo = (CustomerInfo) this.f97807c;
        PremiumDevState premiumDevState = (PremiumDevState) this.f97808d;
        IntrinsicsKt.f();
        if (this.f97805a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return new Triple(Boxing.a(z2), customerInfo, premiumDevState);
    }
}
