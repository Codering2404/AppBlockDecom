package cz.mobilesoft.coreblock.util.compose;

import cz.mobilesoft.coreblock.base.ViewEvent;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.compose.FlowExtKt$getOnEvent$1$1$1", f = "FlowExt.kt", l = {46}, m = "invokeSuspend", v = 1)
final class FlowExtKt$getOnEvent$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseStatefulViewModel f128244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ViewEvent f128245c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowExtKt$getOnEvent$1$1$1(BaseStatefulViewModel baseStatefulViewModel, ViewEvent viewEvent, Continuation continuation) {
        super(2, continuation);
        this.f128244b = baseStatefulViewModel;
        this.f128245c = viewEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FlowExtKt$getOnEvent$1$1$1(this.f128244b, this.f128245c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f128243a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Channel channelK0 = this.f128244b.K0();
            ViewEvent viewEvent = this.f128245c;
            this.f128243a = 1;
            if (channelK0.y(viewEvent, this) == objF) {
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
        return ((FlowExtKt$getOnEvent$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
