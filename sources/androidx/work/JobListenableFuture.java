package androidx.work;

import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class JobListenableFuture<R> implements ListenableFuture<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Job f54530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SettableFuture f54531b;

    public JobListenableFuture(Job job, SettableFuture underlying) {
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(underlying, "underlying");
        this.f54530a = job;
        this.f54531b = underlying;
        job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.work.JobListenableFuture.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                if (th == null) {
                    if (!JobListenableFuture.this.f54531b.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                } else {
                    if (th instanceof CancellationException) {
                        JobListenableFuture.this.f54531b.cancel(true);
                        return;
                    }
                    SettableFuture settableFuture = JobListenableFuture.this.f54531b;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    settableFuture.p(th);
                }
            }
        });
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.f54531b.addListener(runnable, executor);
    }

    public final void b(Object obj) {
        this.f54531b.o(obj);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        return this.f54531b.cancel(z2);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return this.f54531b.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f54531b.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f54531b.isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) {
        return this.f54531b.get(j3, timeUnit);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ JobListenableFuture(Job job, SettableFuture settableFuture, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 2) != 0) {
            settableFuture = SettableFuture.s();
            Intrinsics.checkNotNullExpressionValue(settableFuture, "create()");
        }
        this(job, settableFuture);
    }
}
