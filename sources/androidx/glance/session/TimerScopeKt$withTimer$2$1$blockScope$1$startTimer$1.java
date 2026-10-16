package androidx.glance.session;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "androidx.glance.session.TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1", f = "TimerScope.kt", l = {115}, m = "invokeSuspend")
final class TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TimerScopeKt$withTimer$2$1$blockScope$1 f39693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TimeSource f39694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f39695d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f39696f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1(TimerScopeKt$withTimer$2$1$blockScope$1 timerScopeKt$withTimer$2$1$blockScope$1, TimeSource timeSource, CoroutineScope coroutineScope, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f39693b = timerScopeKt$withTimer$2$1$blockScope$1;
        this.f39694c = timeSource;
        this.f39695d = coroutineScope;
        this.f39696f = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1(this.f39693b, this.f39694c, this.f39695d, this.f39696f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long jE0;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f39692a;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        do {
            Object obj2 = this.f39693b.f39686b.get();
            Intrinsics.checkNotNull(obj2);
            if (((Number) obj2).longValue() <= this.f39694c.a()) {
                CoroutineScopeKt.d(this.f39695d, new TimeoutCancellationException("Timed out of executing block.", this.f39696f.hashCode()));
                return Unit.f139807a;
            }
            jE0 = this.f39693b.e0();
            this.f39692a = 1;
        } while (DelayKt.c(jE0, this) != objF);
        return objF;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TimerScopeKt$withTimer$2$1$blockScope$1$startTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
