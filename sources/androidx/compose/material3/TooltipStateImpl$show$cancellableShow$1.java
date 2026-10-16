package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "androidx.compose.material3.TooltipStateImpl$show$cancellableShow$1", f = "Tooltip.kt", l = {646}, m = "invokeSuspend")
final class TooltipStateImpl$show$cancellableShow$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f21495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f21496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TooltipStateImpl f21497c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TooltipStateImpl$show$cancellableShow$1(TooltipStateImpl tooltipStateImpl, Continuation continuation) {
        super(1, continuation);
        this.f21497c = tooltipStateImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new TooltipStateImpl$show$cancellableShow$1(this.f21497c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f21496b;
        if (i3 == 0) {
            ResultKt.b(obj);
            TooltipStateImpl tooltipStateImpl = this.f21497c;
            this.f21495a = tooltipStateImpl;
            this.f21496b = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(this), 1);
            cancellableContinuationImpl.C();
            tooltipStateImpl.b().h(Boxing.a(true));
            tooltipStateImpl.f21488d = cancellableContinuationImpl;
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
        return ((TooltipStateImpl$show$cancellableShow$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
