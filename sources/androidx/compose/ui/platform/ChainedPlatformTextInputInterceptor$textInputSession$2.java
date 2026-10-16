package androidx.compose.ui.platform;

import androidx.compose.ui.SessionMutex;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.ui.platform.ChainedPlatformTextInputInterceptor$textInputSession$2", f = "PlatformTextInputModifierNode.kt", l = {248}, m = "invokeSuspend")
final class ChainedPlatformTextInputInterceptor$textInputSession$2 extends SuspendLambda implements Function2<PlatformTextInputSessionScope, Continuation<?>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f27937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f27938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f27939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ChainedPlatformTextInputInterceptor f27940d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChainedPlatformTextInputInterceptor$textInputSession$2(Function2 function2, ChainedPlatformTextInputInterceptor chainedPlatformTextInputInterceptor, Continuation continuation) {
        super(2, continuation);
        this.f27939c = function2;
        this.f27940d = chainedPlatformTextInputInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ChainedPlatformTextInputInterceptor$textInputSession$2 chainedPlatformTextInputInterceptor$textInputSession$2 = new ChainedPlatformTextInputInterceptor$textInputSession$2(this.f27939c, this.f27940d, continuation);
        chainedPlatformTextInputInterceptor$textInputSession$2.f27938b = obj;
        return chainedPlatformTextInputInterceptor$textInputSession$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(PlatformTextInputSessionScope platformTextInputSessionScope, Continuation continuation) {
        return ((ChainedPlatformTextInputInterceptor$textInputSession$2) create(platformTextInputSessionScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f27937a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1 chainedPlatformTextInputInterceptor$textInputSession$2$scope$1 = new ChainedPlatformTextInputInterceptor$textInputSession$2$scope$1((PlatformTextInputSessionScope) this.f27938b, SessionMutex.a(), this.f27940d);
            Function2 function2 = this.f27939c;
            this.f27937a = 1;
            if (function2.invoke(chainedPlatformTextInputInterceptor$textInputSession$2$scope$1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
