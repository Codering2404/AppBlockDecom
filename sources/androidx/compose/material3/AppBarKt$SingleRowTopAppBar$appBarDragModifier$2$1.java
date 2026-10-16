package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
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
@DebugMetadata(c = "androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1", f = "AppBar.kt", l = {1911}, m = "invokeSuspend")
final class AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f15776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ float f15777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TopAppBarScrollBehavior f15778c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1(TopAppBarScrollBehavior topAppBarScrollBehavior, Continuation continuation) {
        super(3, continuation);
        this.f15778c = topAppBarScrollBehavior;
    }

    public final Object h(CoroutineScope coroutineScope, float f3, Continuation continuation) {
        AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1 appBarKt$SingleRowTopAppBar$appBarDragModifier$2$1 = new AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1(this.f15778c, continuation);
        appBarKt$SingleRowTopAppBar$appBarDragModifier$2$1.f15777b = f3;
        return appBarKt$SingleRowTopAppBar$appBarDragModifier$2$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return h((CoroutineScope) obj, ((Number) obj2).floatValue(), (Continuation) obj3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f15776a;
        if (i3 == 0) {
            ResultKt.b(obj);
            float f3 = this.f15777b;
            TopAppBarState state = this.f15778c.getState();
            DecayAnimationSpec decayAnimationSpecB = this.f15778c.b();
            AnimationSpec animationSpecC = this.f15778c.c();
            this.f15776a = 1;
            if (AppBarKt.D(state, f3, decayAnimationSpecB, animationSpecC, this) == objF) {
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
}
