package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class JobKt {
    public static final CompletableJob a(Job job) {
        return JobKt__JobKt.a(job);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.c(coroutineContext, cancellationException);
    }

    public static final void d(Job job, String str, Throwable th) {
        JobKt__JobKt.d(job, str, th);
    }

    public static final Object g(Job job, Continuation continuation) {
        return JobKt__JobKt.g(job, continuation);
    }

    public static final void h(CoroutineContext coroutineContext, CancellationException cancellationException) {
        JobKt__JobKt.h(coroutineContext, cancellationException);
    }

    public static final DisposableHandle j(Job job, DisposableHandle disposableHandle) {
        return JobKt__JobKt.j(job, disposableHandle);
    }

    public static final void k(CoroutineContext coroutineContext) {
        JobKt__JobKt.k(coroutineContext);
    }

    public static final void l(Job job) {
        JobKt__JobKt.l(job);
    }

    public static final Job m(CoroutineContext coroutineContext) {
        return JobKt__JobKt.m(coroutineContext);
    }

    public static final DisposableHandle n(Job job, boolean z2, JobNode jobNode) {
        return JobKt__JobKt.n(job, z2, jobNode);
    }

    public static final boolean p(CoroutineContext coroutineContext) {
        return JobKt__JobKt.p(coroutineContext);
    }
}
