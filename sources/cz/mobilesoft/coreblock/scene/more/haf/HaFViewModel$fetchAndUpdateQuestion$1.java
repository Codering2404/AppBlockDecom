package cz.mobilesoft.coreblock.scene.more.haf;

import cz.mobilesoft.coreblock.dto.QuestionDTO;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.haf.HaFViewModel$fetchAndUpdateQuestion$1", f = "HaFViewModel.kt", l = {152}, m = "invokeSuspend", v = 1)
final class HaFViewModel$fetchAndUpdateQuestion$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ HaFViewModel f107616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ QuestionDTO f107617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ QuestionDTO f107618d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HaFViewModel$fetchAndUpdateQuestion$1(HaFViewModel haFViewModel, QuestionDTO questionDTO, QuestionDTO questionDTO2, Continuation continuation) {
        super(2, continuation);
        this.f107616b = haFViewModel;
        this.f107617c = questionDTO;
        this.f107618d = questionDTO2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HaFViewState q(QuestionDTO questionDTO, HaFViewState haFViewState) {
        return HaFViewState.b(haFViewState, null, null, null, null, questionDTO, false, null, null, null, null, false, false, 4079, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HaFViewModel$fetchAndUpdateQuestion$1(this.f107616b, this.f107617c, this.f107618d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f107615a;
        if (i3 == 0) {
            ResultKt.b(obj);
            HaFViewModel haFViewModel = this.f107616b;
            final QuestionDTO questionDTO = this.f107618d;
            haFViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.haf.f1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return HaFViewModel$fetchAndUpdateQuestion$1.q(questionDTO, (HaFViewState) obj2);
                }
            });
            HaFRequestHelper haFRequestHelper = HaFRequestHelper.f107559a;
            QuestionDTO questionDTO2 = this.f107617c;
            Integer numD = questionDTO2 != null ? Boxing.d(questionDTO2.a()) : null;
            this.f107615a = 1;
            if (HaFRequestHelper.g(haFRequestHelper, numD, false, this, 2, null) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((HaFViewModel$fetchAndUpdateQuestion$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
