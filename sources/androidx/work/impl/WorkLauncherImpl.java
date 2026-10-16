package androidx.work.impl;

import androidx.work.WorkerParameters;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
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
public final class WorkLauncherImpl implements WorkLauncher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Processor f54680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TaskExecutor f54681b;

    public WorkLauncherImpl(Processor processor, TaskExecutor workTaskExecutor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(workTaskExecutor, "workTaskExecutor");
        this.f54680a = processor;
        this.f54681b = workTaskExecutor;
    }

    @Override // androidx.work.impl.WorkLauncher
    public void a(StartStopToken workSpecId, WorkerParameters.RuntimeExtras runtimeExtras) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f54681b.d(new StartWorkRunnable(this.f54680a, workSpecId, runtimeExtras));
    }

    @Override // androidx.work.impl.WorkLauncher
    public void d(StartStopToken workSpecId, int i3) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f54681b.d(new StopWorkRunnable(this.f54680a, workSpecId, false, i3));
    }
}
