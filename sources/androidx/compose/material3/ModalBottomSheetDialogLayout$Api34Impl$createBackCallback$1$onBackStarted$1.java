package androidx.compose.material3;

import android.window.BackEvent;
import androidx.compose.animation.core.Animatable;
import androidx.compose.material3.internal.PredictiveBack;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "androidx.compose.material3.ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackStarted$1", f = "ModalBottomSheet.android.kt", l = {404}, m = "invokeSuspend")
final class ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f18220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f18221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BackEvent f18222c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackStarted$1(Animatable animatable, BackEvent backEvent, Continuation continuation) {
        super(2, continuation);
        this.f18221b = animatable;
        this.f18222c = backEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackStarted$1(this.f18221b, this.f18222c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f18220a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Animatable animatable = this.f18221b;
            Float fC = Boxing.c(PredictiveBack.f22096a.a(this.f18222c.getProgress()));
            this.f18220a = 1;
            if (animatable.u(fC, this) == objF) {
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
        return ((ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
