package cz.mobilesoft.coreblock.scene.premium;

import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.ViewModelState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$initialize$6", f = "PremiumScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class PremiumScreenViewModel$initialize$6 extends SuspendLambda implements Function2<ViewModelState, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f112426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f112427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PremiumScreenViewModel f112428c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumScreenViewModel$initialize$6(PremiumScreenViewModel premiumScreenViewModel, Continuation continuation) {
        super(2, continuation);
        this.f112428c = premiumScreenViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PremiumScreenViewState y(ViewModelState viewModelState, PremiumScreenViewState premiumScreenViewState) {
        return PremiumScreenViewState.b(premiumScreenViewState, null, viewModelState, null, null, null, null, null, null, null, Intrinsics.areEqual(viewModelState, Loading.f127895a), false, null, false, false, false, false, false, false, null, null, null, null, false, false, false, null, null, null, null, null, false, false, false, -515, 1, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PremiumScreenViewModel$initialize$6 premiumScreenViewModel$initialize$6 = new PremiumScreenViewModel$initialize$6(this.f112428c, continuation);
        premiumScreenViewModel$initialize$6.f112427b = obj;
        return premiumScreenViewModel$initialize$6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final ViewModelState viewModelState = (ViewModelState) this.f112427b;
        IntrinsicsKt.f();
        if (this.f112426a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.f112428c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.o0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return PremiumScreenViewModel$initialize$6.y(viewModelState, (PremiumScreenViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ViewModelState viewModelState, Continuation continuation) {
        return ((PremiumScreenViewModel$initialize$6) create(viewModelState, continuation)).invokeSuspend(Unit.f139807a);
    }
}
