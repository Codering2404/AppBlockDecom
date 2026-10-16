package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "androidx.compose.material3.SnackbarHostKt$animatedOpacity$2$1", f = "SnackbarHost.kt", l = {422}, m = "invokeSuspend")
final class SnackbarHostKt$animatedOpacity$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f20238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f20239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f20240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AnimationSpec f20241d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f20242f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarHostKt$animatedOpacity$2$1(Animatable animatable, boolean z2, AnimationSpec animationSpec, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f20239b = animatable;
        this.f20240c = z2;
        this.f20241d = animationSpec;
        this.f20242f = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SnackbarHostKt$animatedOpacity$2$1(this.f20239b, this.f20240c, this.f20241d, this.f20242f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SnackbarHostKt$animatedOpacity$2$1 snackbarHostKt$animatedOpacity$2$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f20238a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Animatable animatable = this.f20239b;
            Float fC = Boxing.c(this.f20240c ? 1.0f : 0.0f);
            AnimationSpec animationSpec = this.f20241d;
            this.f20238a = 1;
            snackbarHostKt$animatedOpacity$2$1 = this;
            if (Animatable.f(animatable, fC, animationSpec, null, null, snackbarHostKt$animatedOpacity$2$1, 12, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            snackbarHostKt$animatedOpacity$2$1 = this;
        }
        snackbarHostKt$animatedOpacity$2$1.f20242f.invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SnackbarHostKt$animatedOpacity$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
