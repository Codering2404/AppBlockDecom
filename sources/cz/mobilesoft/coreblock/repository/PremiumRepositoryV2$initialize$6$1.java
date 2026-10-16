package cz.mobilesoft.coreblock.repository;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$initialize$6$1", f = "PremiumRepositoryV2.kt", l = {247}, m = "invokeSuspend", v = 1)
final class PremiumRepositoryV2$initialize$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PremiumRepositoryV2 f97769b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumRepositoryV2$initialize$6$1(PremiumRepositoryV2 premiumRepositoryV2, Continuation continuation) {
        super(2, continuation);
        this.f97769b = premiumRepositoryV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(PremiumRepositoryV2 premiumRepositoryV2) {
        BuildersKt__Builders_commonKt.d(premiumRepositoryV2.f97695a, null, null, new PremiumRepositoryV2$initialize$6$1$1$1(premiumRepositoryV2, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PremiumRepositoryV2$initialize$6$1(this.f97769b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f97768a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowZ2 = this.f97769b.A().Z2();
            this.f97768a = 1;
            obj = FlowKt.D(flowZ2, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        if (((Boolean) obj).booleanValue()) {
            final PremiumRepositoryV2 premiumRepositoryV2 = this.f97769b;
            premiumRepositoryV2.a0(new Function0() { // from class: cz.mobilesoft.coreblock.repository.p
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PremiumRepositoryV2$initialize$6$1.q(premiumRepositoryV2);
                }
            });
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PremiumRepositoryV2$initialize$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
