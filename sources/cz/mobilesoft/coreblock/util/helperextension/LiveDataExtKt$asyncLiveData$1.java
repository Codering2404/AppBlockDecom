package cz.mobilesoft.coreblock.util.helperextension;

import androidx.lifecycle.LiveDataScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.LiveDataExtKt$asyncLiveData$1", f = "LiveDataExt.kt", l = {41}, m = "invokeSuspend", v = 1)
final class LiveDataExtKt$asyncLiveData$1 extends SuspendLambda implements Function2<LiveDataScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f128636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f128637c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LiveDataExtKt$asyncLiveData$1(Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f128637c = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LiveDataExtKt$asyncLiveData$1 liveDataExtKt$asyncLiveData$1 = new LiveDataExtKt$asyncLiveData$1(this.f128637c, continuation);
        liveDataExtKt$asyncLiveData$1.f128636b = obj;
        return liveDataExtKt$asyncLiveData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(LiveDataScope liveDataScope, Continuation continuation) {
        return ((LiveDataExtKt$asyncLiveData$1) create(liveDataScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LiveDataScope liveDataScope = (LiveDataScope) this.f128636b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f128635a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Object objInvoke = this.f128637c.invoke();
            this.f128636b = SpillingKt.a(liveDataScope);
            this.f128635a = 1;
            if (liveDataScope.emit(objInvoke, this) == objF) {
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
