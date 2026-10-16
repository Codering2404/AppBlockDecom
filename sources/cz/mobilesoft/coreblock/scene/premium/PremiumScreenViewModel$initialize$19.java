package cz.mobilesoft.coreblock.scene.premium;

import cz.mobilesoft.coreblock.storage.datastore.entity.IntroTrialToggleScreenType;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$initialize$19", f = "PremiumScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class PremiumScreenViewModel$initialize$19 extends SuspendLambda implements Function2<IntroTrialToggleScreenType, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f112404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f112405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewModel f112406c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumScreenViewModel$initialize$19(PremiumScreenViewModel premiumScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f112406c = premiumScreenViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState y(IntroTrialToggleScreenType introTrialToggleScreenType, PremiumScreenViewState premiumScreenViewState) {
        return PremiumScreenViewState.b(premiumScreenViewState, null, null, null, null, null, null, null, null, null, false, false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, introTrialToggleScreenType, null, null, null, null, false, false, false, -33554433, 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PremiumScreenViewModel$initialize$19 premiumScreenViewModel$initialize$19 = new PremiumScreenViewModel$initialize$19(this.f112406c, continuation);
        premiumScreenViewModel$initialize$19.f112405b = obj;
        return premiumScreenViewModel$initialize$19;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final IntroTrialToggleScreenType introTrialToggleScreenType = (IntroTrialToggleScreenType) this.f112405b;
        IntrinsicsKt.f();
        if (this.f112404a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.f112406c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return PremiumScreenViewModel$initialize$19.y(introTrialToggleScreenType, (PremiumScreenViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(IntroTrialToggleScreenType introTrialToggleScreenType, Continuation continuation) {
        return ((PremiumScreenViewModel$initialize$19) create(introTrialToggleScreenType, continuation)).invokeSuspend(Unit.f139807a);
    }
}
