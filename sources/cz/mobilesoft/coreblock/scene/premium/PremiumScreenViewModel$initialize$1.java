package cz.mobilesoft.coreblock.scene.premium;

import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$initialize$1", f = "PremiumScreenViewModel.kt", l = {148}, m = "invokeSuspend", v = 1)
final class PremiumScreenViewModel$initialize$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f112375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f112376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewModel f112377c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumScreenViewModel$initialize$1(PremiumScreenViewModel premiumScreenViewModel, Continuation continuation) {
        super(1, continuation);
        this.f112377c = premiumScreenViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PremiumScreenViewModel$initialize$1(this.f112377c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PremiumScreenViewModel premiumScreenViewModel;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f112376b;
        if (i3 == 0) {
            ResultKt.b(obj);
            PremiumScreenViewModel premiumScreenViewModel2 = this.f112377c;
            this.f112375a = premiumScreenViewModel2;
            this.f112376b = 1;
            Object objH2 = premiumScreenViewModel2.h2(this);
            if (objH2 == objF) {
                return objF;
            }
            premiumScreenViewModel = premiumScreenViewModel2;
            obj = objH2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            premiumScreenViewModel = (PremiumScreenViewModel) this.f112375a;
            ResultKt.b(obj);
        }
        premiumScreenViewModel.s1((RevenueCatPlacement) obj);
        this.f112377c.n1();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PremiumScreenViewModel$initialize$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
