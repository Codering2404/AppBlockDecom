package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material3.SliderState$drag$2", f = "Slider.kt", l = {1972}, m = "invokeSuspend")
final class SliderState$drag$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f20201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SliderState f20202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutatePriority f20203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function2 f20204d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderState$drag$2(SliderState sliderState, MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f20202b = sliderState;
        this.f20203c = mutatePriority;
        this.f20204d = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SliderState$drag$2(this.f20202b, this.f20203c, this.f20204d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f20201a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f20202b.z(true);
            MutatorMutex mutatorMutex = this.f20202b.f20200p;
            DragScope dragScope = this.f20202b.f20199o;
            MutatePriority mutatePriority = this.f20203c;
            Function2 function2 = this.f20204d;
            this.f20201a = 1;
            if (mutatorMutex.f(dragScope, mutatePriority, function2, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f20202b.z(false);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SliderState$drag$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
