package androidx.glance.session;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.session.InteractiveFrameClock$startInteractive$2", f = "InteractiveFrameClock.kt", l = {136}, m = "invokeSuspend")
final class InteractiveFrameClock$startInteractive$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f39570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f39571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ InteractiveFrameClock f39572c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InteractiveFrameClock$startInteractive$2(InteractiveFrameClock interactiveFrameClock, Continuation continuation) {
        super(2, continuation);
        this.f39572c = interactiveFrameClock;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InteractiveFrameClock$startInteractive$2(this.f39572c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f39571b;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f39572c.s();
            final InteractiveFrameClock interactiveFrameClock = this.f39572c;
            this.f39570a = interactiveFrameClock;
            this.f39571b = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(this), 1);
            cancellableContinuationImpl.C();
            synchronized (interactiveFrameClock.f39559h) {
                interactiveFrameClock.f39560i = interactiveFrameClock.f39555c;
                interactiveFrameClock.f39562k = cancellableContinuationImpl;
                Unit unit = Unit.f139807a;
            }
            cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: androidx.glance.session.InteractiveFrameClock$startInteractive$2$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Throwable) obj2);
                    return Unit.f139807a;
                }

                public final void invoke(Throwable th) {
                    Object obj2 = interactiveFrameClock.f39559h;
                    InteractiveFrameClock interactiveFrameClock2 = interactiveFrameClock;
                    synchronized (obj2) {
                        interactiveFrameClock2.f39560i = interactiveFrameClock2.f39554b;
                        interactiveFrameClock2.f39562k = null;
                        Unit unit2 = Unit.f139807a;
                    }
                }
            });
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InteractiveFrameClock$startInteractive$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
