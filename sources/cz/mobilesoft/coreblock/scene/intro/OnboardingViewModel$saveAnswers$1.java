package cz.mobilesoft.coreblock.scene.intro;

import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.OnboardingViewModel$saveAnswers$1", f = "OnboardingViewModel.kt", l = {189}, m = "invokeSuspend", v = 1)
final class OnboardingViewModel$saveAnswers$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f104580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModel f104581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnboardingViewState f104582c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingViewModel$saveAnswers$1(OnboardingViewModel onboardingViewModel, OnboardingViewState onboardingViewState, Continuation continuation) {
        super(1, continuation);
        this.f104581b = onboardingViewModel;
        this.f104582c = onboardingViewState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new OnboardingViewModel$saveAnswers$1(this.f104581b, this.f104582c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f104580a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoreDataStore coreDataStoreQ1 = this.f104581b.q1();
            OnboardingAnswersDTO onboardingAnswersDTOI = this.f104582c.i();
            this.f104580a = 1;
            if (coreDataStoreQ1.g5(onboardingAnswersDTOI, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((OnboardingViewModel$saveAnswers$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
