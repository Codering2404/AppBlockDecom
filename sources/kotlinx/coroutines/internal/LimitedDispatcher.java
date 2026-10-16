package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class LimitedDispatcher extends CoroutineDispatcher implements Delay {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f142446i = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Delay f142447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineDispatcher f142448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f142449d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f142450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LockFreeTaskQueue f142451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f142452h;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class Worker implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Runnable f142453a;

        public Worker(Runnable runnable) {
            this.f142453a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3 = 0;
            while (true) {
                try {
                    this.f142453a.run();
                } catch (Throwable th) {
                    CoroutineExceptionHandlerKt.a(EmptyCoroutineContext.f139889a, th);
                }
                Runnable runnableR0 = LimitedDispatcher.this.R0();
                if (runnableR0 == null) {
                    return;
                }
                this.f142453a = runnableR0;
                i3++;
                if (i3 >= 16 && LimitedDispatcher.this.f142448c.e0(LimitedDispatcher.this)) {
                    LimitedDispatcher.this.f142448c.M(LimitedDispatcher.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int i3, String str) {
        Delay delay = coroutineDispatcher instanceof Delay ? (Delay) coroutineDispatcher : null;
        this.f142447b = delay == null ? DefaultExecutorKt.a() : delay;
        this.f142448c = coroutineDispatcher;
        this.f142449d = i3;
        this.f142450f = str;
        this.f142451g = new LockFreeTaskQueue(false);
        this.f142452h = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable R0() {
        while (true) {
            Runnable runnable = (Runnable) this.f142451g.e();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f142452h) {
                f142446i.decrementAndGet(this);
                if (this.f142451g.c() == 0) {
                    return null;
                }
                f142446i.incrementAndGet(this);
            }
        }
    }

    private final boolean X0() {
        synchronized (this.f142452h) {
            if (f142446i.get(this) >= this.f142449d) {
                return false;
            }
            f142446i.incrementAndGet(this);
            return true;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void M(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableR0;
        this.f142451g.a(runnable);
        if (f142446i.get(this) >= this.f142449d || !X0() || (runnableR0 = R0()) == null) {
            return;
        }
        this.f142448c.M(this, new Worker(runnableR0));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void O(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableR0;
        this.f142451g.a(runnable);
        if (f142446i.get(this) >= this.f142449d || !X0() || (runnableR0 = R0()) == null) {
            return;
        }
        this.f142448c.O(this, new Worker(runnableR0));
    }

    @Override // kotlinx.coroutines.Delay
    public void i(long j3, CancellableContinuation cancellableContinuation) {
        this.f142447b.i(j3, cancellableContinuation);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher j0(int i3, String str) {
        LimitedDispatcherKt.a(i3);
        return i3 >= this.f142449d ? LimitedDispatcherKt.b(this, str) : super.j0(i3, str);
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle m(long j3, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f142447b.m(j3, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str = this.f142450f;
        if (str != null) {
            return str;
        }
        return this.f142448c + ".limitedParallelism(" + this.f142449d + ')';
    }
}
