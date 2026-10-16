package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.android.HandlerContext;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class HandlerContext extends HandlerDispatcher implements Delay {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f141029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f141030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f141031d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HandlerContext f141032f;

    private HandlerContext(Handler handler, String str, boolean z2) {
        super(null);
        this.f141029b = handler;
        this.f141030c = str;
        this.f141031d = z2;
        this.f141032f = z2 ? this : new HandlerContext(handler, str, true);
    }

    private final void a1(CoroutineContext coroutineContext, Runnable runnable) {
        JobKt.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.b().M(coroutineContext, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.f141029b.removeCallbacks(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(HandlerContext handlerContext, Runnable runnable, Throwable th) {
        handlerContext.f141029b.removeCallbacks(runnable);
        return Unit.f139807a;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void M(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.f141029b.post(runnable)) {
            return;
        }
        a1(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean e0(CoroutineContext coroutineContext) {
        return (this.f141031d && Intrinsics.areEqual(Looper.myLooper(), this.f141029b.getLooper())) ? false : true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HandlerContext)) {
            return false;
        }
        HandlerContext handlerContext = (HandlerContext) obj;
        return handlerContext.f141029b == this.f141029b && handlerContext.f141031d == this.f141031d;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    /* JADX INFO: renamed from: h1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public HandlerContext w0() {
        return this.f141032f;
    }

    public int hashCode() {
        return System.identityHashCode(this.f141029b) ^ (this.f141031d ? 1231 : 1237);
    }

    @Override // kotlinx.coroutines.Delay
    public void i(long j3, final CancellableContinuation cancellableContinuation) {
        final Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                cancellableContinuation.I(this, Unit.f139807a);
            }
        };
        if (this.f141029b.postDelayed(runnable, RangesKt.l(j3, 4611686018427387903L))) {
            cancellableContinuation.m(new Function1() { // from class: p2.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HandlerContext.o1(this.f146660a, runnable, (Throwable) obj);
                }
            });
        } else {
            a1(cancellableContinuation.getContext(), runnable);
        }
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    public DisposableHandle m(long j3, final Runnable runnable, CoroutineContext coroutineContext) {
        if (this.f141029b.postDelayed(runnable, RangesKt.l(j3, 4611686018427387903L))) {
            return new DisposableHandle() { // from class: p2.a
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    HandlerContext.i1(this.f146658a, runnable);
                }
            };
        }
        a1(coroutineContext, runnable);
        return NonDisposableHandle.f141004a;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strZ0 = z0();
        if (strZ0 != null) {
            return strZ0;
        }
        String string = this.f141030c;
        if (string == null) {
            string = this.f141029b.toString();
        }
        if (!this.f141031d) {
            return string;
        }
        return string + ".immediate";
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i3 & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }
}
