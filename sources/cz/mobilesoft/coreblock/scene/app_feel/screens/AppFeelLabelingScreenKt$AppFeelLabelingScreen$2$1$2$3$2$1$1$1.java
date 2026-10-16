package cz.mobilesoft.coreblock.scene.app_feel.screens;

import androidx.compose.animation.core.Animatable;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$2$3$2$1$1$1", f = "AppFeelLabelingScreen.kt", l = {328}, m = "invokeSuspend", v = 1)
final class AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$2$3$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwipeCardState f98682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f98683c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$2$3$2$1$1$1(SwipeCardState swipeCardState, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f98682b = swipeCardState;
        this.f98683c = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$2$3$2$1$1$1(this.f98682b, this.f98683c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98681a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Animatable animatableB = this.f98682b.b();
            Float fC = Boxing.c(0.0f);
            this.f98681a = 1;
            if (animatableB.u(fC, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f98683c.invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$2$3$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
