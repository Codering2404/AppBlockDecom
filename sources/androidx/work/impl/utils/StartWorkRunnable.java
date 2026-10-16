package androidx.work.impl.utils;

import androidx.work.WorkerParameters;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class StartWorkRunnable implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Processor f55171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StartStopToken f55172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WorkerParameters.RuntimeExtras f55173c;

    public StartWorkRunnable(Processor processor, StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(startStopToken, "startStopToken");
        this.f55171a = processor;
        this.f55172b = startStopToken;
        this.f55173c = runtimeExtras;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        this.f55171a.p(this.f55172b, this.f55173c);
    }
}
