package androidx.work.impl;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
final class WorkManagerImplExtKt$schedulers$1 extends Lambda implements Function6<Context, Configuration, TaskExecutor, WorkDatabase, Trackers, Processor, List<? extends Scheduler>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Scheduler[] f54700a;

    @Override // kotlin.jvm.functions.Function6
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final List k(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, Trackers trackers, Processor processor) {
        Intrinsics.checkNotNullParameter(context, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(configuration, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(taskExecutor, "<anonymous parameter 2>");
        Intrinsics.checkNotNullParameter(workDatabase, "<anonymous parameter 3>");
        Intrinsics.checkNotNullParameter(trackers, "<anonymous parameter 4>");
        Intrinsics.checkNotNullParameter(processor, "<anonymous parameter 5>");
        return ArraysKt.toList(this.f54700a);
    }
}
