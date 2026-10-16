package androidx.work.impl.utils;

import androidx.work.Configuration;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkSpec;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.experimental.kJ.HcgZcEUYo;
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
public final class EnqueueUtilsKt {
    public static final WorkSpec b(List schedulers, WorkSpec workSpec) {
        Intrinsics.checkNotNullParameter(schedulers, "schedulers");
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        return workSpec;
    }

    public static final void a(WorkDatabase workDatabase, Configuration configuration, WorkContinuationImpl continuation) {
        int i3;
        Intrinsics.checkNotNullParameter(workDatabase, "workDatabase");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        List listMutableListOf = CollectionsKt.mutableListOf(continuation);
        int i4 = 0;
        while (!listMutableListOf.isEmpty()) {
            WorkContinuationImpl workContinuationImpl = (WorkContinuationImpl) CollectionsKt.removeLast(listMutableListOf);
            List listF = workContinuationImpl.f();
            Intrinsics.checkNotNullExpressionValue(listF, "current.work");
            List list = listF;
            if ((list instanceof Collection) && list.isEmpty()) {
                i3 = 0;
            } else {
                Iterator it = list.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    if (((WorkRequest) it.next()).d().f55022j.e() && (i3 = i3 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            i4 += i3;
            List listE = workContinuationImpl.e();
            if (listE != null) {
                listMutableListOf.addAll(listE);
            }
        }
        if (i4 == 0) {
            return;
        }
        int iG = workDatabase.t().G();
        int iB = configuration.b();
        if (iG + i4 <= iB) {
            return;
        }
        throw new IllegalArgumentException("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: " + iB + HcgZcEUYo.bQwVh + iG + ";\ncurrent enqueue operation count: " + i4 + ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed.");
    }
}
