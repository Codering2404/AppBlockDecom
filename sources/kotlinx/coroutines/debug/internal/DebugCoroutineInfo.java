package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

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
public final class DebugCoroutineInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineContext f141413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineStackFrame f141414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f141415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f141416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f141417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Thread f141418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoroutineStackFrame f141419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f141420h;

    public DebugCoroutineInfo(DebugCoroutineInfoImpl debugCoroutineInfoImpl, CoroutineContext coroutineContext) {
        this.f141413a = coroutineContext;
        this.f141414b = debugCoroutineInfoImpl.d();
        this.f141415c = debugCoroutineInfoImpl.f141422b;
        this.f141416d = debugCoroutineInfoImpl.e();
        this.f141417e = debugCoroutineInfoImpl.g();
        this.f141418f = debugCoroutineInfoImpl.lastObservedThread;
        this.f141419g = debugCoroutineInfoImpl.f();
        this.f141420h = debugCoroutineInfoImpl.h();
    }
}
