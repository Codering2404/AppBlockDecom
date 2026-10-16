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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$initialize$11", f = "PremiumScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class PremiumScreenViewModel$initialize$11 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f112381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ boolean f112382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewModel f112383c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumScreenViewModel$initialize$11(PremiumScreenViewModel premiumScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f112383c = premiumScreenViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState q(boolean z2, PremiumScreenViewState premiumScreenViewState) {
        return PremiumScreenViewState.b(premiumScreenViewState, null, null, null, null, null, null, null, null, null, false, false, null, false, false, false, z2, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -32769, 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PremiumScreenViewModel$initialize$11 premiumScreenViewModel$initialize$11 = new PremiumScreenViewModel$initialize$11(this.f112383c, continuation);
        premiumScreenViewModel$initialize$11.f112382b = ((Boolean) obj).booleanValue();
        return premiumScreenViewModel$initialize$11;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final boolean z2 = this.f112382b;
        IntrinsicsKt.f();
        if (this.f112381a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.f112383c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return PremiumScreenViewModel$initialize$11.q(z2, (PremiumScreenViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    public final Object invoke(boolean z2, Continuation continuation) {
        return ((PremiumScreenViewModel$initialize$11) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
    }
}
