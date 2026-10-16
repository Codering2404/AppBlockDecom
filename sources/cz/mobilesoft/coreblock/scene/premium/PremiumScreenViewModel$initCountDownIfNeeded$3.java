package cz.mobilesoft.coreblock.scene.premium;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$initCountDownIfNeeded$3", f = "PremiumScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class PremiumScreenViewModel$initCountDownIfNeeded$3 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f112372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f112373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewModel f112374c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumScreenViewModel$initCountDownIfNeeded$3(PremiumScreenViewModel premiumScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f112374c = premiumScreenViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState y(Long l3, PremiumScreenViewState premiumScreenViewState) {
        return PremiumScreenViewState.b(premiumScreenViewState, null, null, null, null, null, null, null, null, l3, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -257, 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PremiumScreenViewModel$initCountDownIfNeeded$3 premiumScreenViewModel$initCountDownIfNeeded$3 = new PremiumScreenViewModel$initCountDownIfNeeded$3(this.f112374c, continuation);
        premiumScreenViewModel$initCountDownIfNeeded$3.f112373b = obj;
        return premiumScreenViewModel$initCountDownIfNeeded$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final Long l3 = (Long) this.f112373b;
        IntrinsicsKt.f();
        if (this.f112372a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.f112374c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return PremiumScreenViewModel$initCountDownIfNeeded$3.y(l3, (PremiumScreenViewState) obj2);
            }
        });
        if (l3 != null && l3.longValue() == 0) {
            this.f112374c.n1();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Long l3, Continuation continuation) {
        return ((PremiumScreenViewModel$initCountDownIfNeeded$3) create(l3, continuation)).invokeSuspend(Unit.f139807a);
    }
}
