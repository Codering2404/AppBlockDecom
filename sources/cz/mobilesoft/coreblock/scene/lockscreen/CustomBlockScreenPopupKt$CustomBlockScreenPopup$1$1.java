package cz.mobilesoft.coreblock.scene.lockscreen;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.CustomBlockScreenPopupKt$CustomBlockScreenPopup$1$1", f = "CustomBlockScreenPopup.kt", l = {54}, m = "invokeSuspend", v = 1)
final class CustomBlockScreenPopupKt$CustomBlockScreenPopup$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f105335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f105336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f105337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f105338d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomBlockScreenPopupKt$CustomBlockScreenPopup$1$1(Animatable animatable, int i3, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f105336b = animatable;
        this.f105337c = i3;
        this.f105338d = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CustomBlockScreenPopupKt$CustomBlockScreenPopup$1$1(this.f105336b, this.f105337c, this.f105338d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CustomBlockScreenPopupKt$CustomBlockScreenPopup$1$1 customBlockScreenPopupKt$CustomBlockScreenPopup$1$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f105335a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Animatable animatable = this.f105336b;
            Float fC = Boxing.c(0.0f);
            TweenSpec tweenSpecN = AnimationSpecKt.n(this.f105337c, 0, EasingKt.e(), 2, null);
            this.f105335a = 1;
            customBlockScreenPopupKt$CustomBlockScreenPopup$1$1 = this;
            if (Animatable.f(animatable, fC, tweenSpecN, null, null, customBlockScreenPopupKt$CustomBlockScreenPopup$1$1, 12, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            customBlockScreenPopupKt$CustomBlockScreenPopup$1$1 = this;
        }
        customBlockScreenPopupKt$CustomBlockScreenPopup$1$1.f105338d.invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CustomBlockScreenPopupKt$CustomBlockScreenPopup$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
