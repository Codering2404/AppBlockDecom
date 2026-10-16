package androidx.lifecycle;

import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

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
public final class DispatchQueue {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f39910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f39911c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f39909a = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue f39912d = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DispatchQueue dispatchQueue, Runnable runnable) {
        dispatchQueue.f(runnable);
    }

    private final void f(Runnable runnable) {
        if (!this.f39912d.offer(runnable)) {
            throw new IllegalStateException("cannot enqueue any more runnables");
        }
        e();
    }

    public final boolean b() {
        return this.f39910b || !this.f39909a;
    }

    public final void c(CoroutineContext context, final Runnable runnable) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        MainCoroutineDispatcher mainCoroutineDispatcherW0 = Dispatchers.c().w0();
        if (mainCoroutineDispatcherW0.e0(context) || b()) {
            mainCoroutineDispatcherW0.M(context, new Runnable() { // from class: androidx.lifecycle.c
                @Override // java.lang.Runnable
                public final void run() {
                    DispatchQueue.d(this.f40148a, runnable);
                }
            });
        } else {
            f(runnable);
        }
    }

    public final void e() {
        if (this.f39911c) {
            return;
        }
        try {
            this.f39911c = true;
            while (!this.f39912d.isEmpty() && b()) {
                Runnable runnable = (Runnable) this.f39912d.poll();
                if (runnable != null) {
                    runnable.run();
                }
            }
        } finally {
            this.f39911c = false;
        }
    }

    public final void g() {
        this.f39910b = true;
        e();
    }

    public final void h() {
        this.f39909a = true;
    }

    public final void i() {
        if (this.f39909a) {
            if (this.f39910b) {
                throw new IllegalStateException("Cannot resume a finished dispatcher");
            }
            this.f39909a = false;
            e();
        }
    }
}
