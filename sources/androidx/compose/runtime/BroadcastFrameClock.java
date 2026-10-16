package androidx.compose.runtime;

import androidx.compose.runtime.BroadcastFrameClock;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.internal.AtomicInt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuationImpl;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class BroadcastFrameClock implements MonotonicFrameClock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f23722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f23723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Throwable f23724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f23725d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f23726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInt f23727g;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class FrameAwaiter<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function1 f23728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Continuation f23729b;

        public FrameAwaiter(Function1 function1, Continuation continuation) {
            this.f23728a = function1;
            this.f23729b = continuation;
        }

        public final Continuation a() {
            return this.f23729b;
        }

        public final void b(long j3) {
            Object objB;
            Continuation continuation = this.f23729b;
            try {
                Result.Companion companion = Result.f139772b;
                objB = Result.b(this.f23728a.invoke(Long.valueOf(j3)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f139772b;
                objB = Result.b(ResultKt.a(th));
            }
            continuation.resumeWith(objB);
        }
    }

    public BroadcastFrameClock(Function0 function0) {
        this.f23722a = function0;
        this.f23723b = new Object();
        this.f23725d = new ArrayList();
        this.f23726f = new ArrayList();
        this.f23727g = new AtomicInt(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Throwable th) {
        synchronized (this.f23723b) {
            try {
                if (this.f23724c != null) {
                    return;
                }
                this.f23724c = th;
                List list = this.f23725d;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Continuation continuationA = ((FrameAwaiter) list.get(i3)).a();
                    Result.Companion companion = Result.f139772b;
                    continuationA.resumeWith(Result.b(ResultKt.a(th)));
                }
                this.f23725d.clear();
                this.f23727g.set(0);
                Unit unit = Unit.f139807a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
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

    public final boolean o() {
        return this.f23727g.get() != 0;
    }

    public final void p(long j3) {
        synchronized (this.f23723b) {
            try {
                List list = this.f23725d;
                this.f23725d = this.f23726f;
                this.f23726f = list;
                this.f23727g.set(0);
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((FrameAwaiter) list.get(i3)).b(j3);
                }
                list.clear();
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return MonotonicFrameClock.DefaultImpls.d(this, coroutineContext);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public Object z(Function1 function1, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        final FrameAwaiter frameAwaiter = new FrameAwaiter(function1, cancellableContinuationImpl);
        synchronized (this.f23723b) {
            Throwable th = this.f23724c;
            if (th != null) {
                Result.Companion companion = Result.f139772b;
                cancellableContinuationImpl.resumeWith(Result.b(ResultKt.a(th)));
            } else {
                boolean zIsEmpty = this.f23725d.isEmpty();
                this.f23725d.add(frameAwaiter);
                if (zIsEmpty) {
                    this.f23727g.set(1);
                }
                cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.BroadcastFrameClock$withFrameNanos$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(Throwable th2) {
                        Object obj = this.f23730a.f23723b;
                        BroadcastFrameClock broadcastFrameClock = this.f23730a;
                        BroadcastFrameClock.FrameAwaiter frameAwaiter2 = frameAwaiter;
                        synchronized (obj) {
                            try {
                                broadcastFrameClock.f23725d.remove(frameAwaiter2);
                                if (broadcastFrameClock.f23725d.isEmpty()) {
                                    broadcastFrameClock.f23727g.set(0);
                                }
                                Unit unit = Unit.f139807a;
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                    }
                });
                if (zIsEmpty && this.f23722a != null) {
                    try {
                        this.f23722a.invoke();
                    } catch (Throwable th2) {
                        n(th2);
                    }
                }
            }
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public /* synthetic */ BroadcastFrameClock(Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function0);
    }
}
