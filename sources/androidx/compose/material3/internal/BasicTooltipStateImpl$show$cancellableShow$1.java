package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

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
@DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipStateImpl$show$cancellableShow$1", f = "BasicTooltip.kt", l = {189}, m = "invokeSuspend")
final class BasicTooltipStateImpl$show$cancellableShow$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f21904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f21905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BasicTooltipStateImpl f21906c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasicTooltipStateImpl$show$cancellableShow$1(BasicTooltipStateImpl basicTooltipStateImpl, Continuation continuation) {
        super(1, continuation);
        this.f21906c = basicTooltipStateImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BasicTooltipStateImpl$show$cancellableShow$1(this.f21906c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f21905b;
        if (i3 == 0) {
            ResultKt.b(obj);
            BasicTooltipStateImpl basicTooltipStateImpl = this.f21906c;
            this.f21904a = basicTooltipStateImpl;
            this.f21905b = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(this), 1);
            cancellableContinuationImpl.C();
            basicTooltipStateImpl.g(true);
            basicTooltipStateImpl.f21898e = cancellableContinuationImpl;
            Object objV = cancellableContinuationImpl.v();
            if (objV == IntrinsicsKt.f()) {
                DebugProbesKt.c(this);
            }
            if (objV == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BasicTooltipStateImpl$show$cancellableShow$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
