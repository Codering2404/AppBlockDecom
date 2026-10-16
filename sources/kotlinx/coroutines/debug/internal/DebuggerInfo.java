package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;

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
public final class DebuggerInfo implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Long f141449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f141450b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f141451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f141452d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f141453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f141454g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f141455h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f141456i;

    public DebuggerInfo(DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineContext coroutineContext) {
        Thread.State state;
        CoroutineId coroutineId = (CoroutineId) coroutineContext.get(CoroutineId.f140912b);
        this.f141449a = coroutineId != null ? Long.valueOf(coroutineId.M()) : null;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.t8);
        this.f141450b = continuationInterceptor != null ? continuationInterceptor.toString() : null;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.f140914b);
        this.f141451c = coroutineName != null ? coroutineName.M() : null;
        this.f141452d = debugCoroutineInfoImpl.g();
        Thread thread = debugCoroutineInfoImpl.lastObservedThread;
        this.f141453f = (thread == null || (state = thread.getState()) == null) ? null : state.toString();
        Thread thread2 = debugCoroutineInfoImpl.lastObservedThread;
        this.f141454g = thread2 != null ? thread2.getName() : null;
        this.f141455h = debugCoroutineInfoImpl.h();
        this.f141456i = debugCoroutineInfoImpl.f141422b;
    }
}
