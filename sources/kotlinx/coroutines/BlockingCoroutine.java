package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

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
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Thread f140888d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EventLoop f140889f;

    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.f140888d = thread;
        this.f140889f = eventLoop;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void S(Object obj) {
        if (Intrinsics.areEqual(Thread.currentThread(), this.f140888d)) {
            return;
        }
        Thread thread = this.f140888d;
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.f140870a;
        if (abstractTimeSource != null) {
            abstractTimeSource.f(thread);
        } else {
            LockSupport.unpark(thread);
        }
    }

    public final Object f1() throws Throwable {
        AbstractTimeSource abstractTimeSource = AbstractTimeSourceKt.f140870a;
        if (abstractTimeSource != null) {
            abstractTimeSource.c();
        }
        try {
            EventLoop eventLoop = this.f140889f;
            if (eventLoop != null) {
                EventLoop.h1(eventLoop, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    EventLoop eventLoop2 = this.f140889f;
                    long jT1 = eventLoop2 != null ? eventLoop2.t1() : Long.MAX_VALUE;
                    if (isCompleted()) {
                        EventLoop eventLoop3 = this.f140889f;
                        if (eventLoop3 != null) {
                            EventLoop.z0(eventLoop3, false, 1, null);
                        }
                        Object objH = JobSupportKt.h(q0());
                        CompletedExceptionally completedExceptionally = objH instanceof CompletedExceptionally ? (CompletedExceptionally) objH : null;
                        if (completedExceptionally == null) {
                            return objH;
                        }
                        throw completedExceptionally.f140908a;
                    }
                    AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.f140870a;
                    if (abstractTimeSource2 != null) {
                        abstractTimeSource2.b(this, jT1);
                    } else {
                        LockSupport.parkNanos(this, jT1);
                    }
                } catch (Throwable th) {
                    EventLoop eventLoop4 = this.f140889f;
                    if (eventLoop4 != null) {
                        EventLoop.z0(eventLoop4, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            W(interruptedException);
            throw interruptedException;
        } finally {
            AbstractTimeSource abstractTimeSource3 = AbstractTimeSourceKt.f140870a;
            if (abstractTimeSource3 != null) {
                abstractTimeSource3.g();
            }
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean x0() {
        return true;
    }
}
