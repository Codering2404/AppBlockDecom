package androidx.compose.ui.platform;

import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AndroidUiFrameClock implements MonotonicFrameClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Choreographer f27904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AndroidUiDispatcher f27905b;

    public AndroidUiFrameClock(Choreographer choreographer, AndroidUiDispatcher androidUiDispatcher) {
        this.f27904a = choreographer;
        this.f27905b = androidUiDispatcher;
    }

    public final Choreographer d() {
        return this.f27904a;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return MonotonicFrameClock.DefaultImpls.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return MonotonicFrameClock.DefaultImpls.b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return MonotonicFrameClock.DefaultImpls.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return MonotonicFrameClock.DefaultImpls.d(this, coroutineContext);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public Object z(final Function1 function1, Continuation continuation) {
        final AndroidUiDispatcher androidUiDispatcher = this.f27905b;
        if (androidUiDispatcher == null) {
            CoroutineContext.Element element = continuation.getContext().get(ContinuationInterceptor.t8);
            androidUiDispatcher = element instanceof AndroidUiDispatcher ? (AndroidUiDispatcher) element : null;
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        final Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$callback$1
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j3) {
                Object objB;
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                Function1 function12 = function1;
                try {
                    Result.Companion companion = Result.f139772b;
                    objB = Result.b(function12.invoke(Long.valueOf(j3)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.f139772b;
                    objB = Result.b(ResultKt.a(th));
                }
                cancellableContinuation.resumeWith(objB);
            }
        };
        if (androidUiDispatcher == null || !Intrinsics.areEqual(androidUiDispatcher.o1(), d())) {
            d().postFrameCallback(frameCallback);
            cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Throwable th) {
                    this.f27908a.d().removeFrameCallback(frameCallback);
                }
            });
        } else {
            androidUiDispatcher.B1(frameCallback);
            cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.platform.AndroidUiFrameClock$withFrameNanos$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Throwable th) {
                    androidUiDispatcher.I1(frameCallback);
                }
            });
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }
}
