package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import java.util.concurrent.Callable;
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
public final class IdGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WorkDatabase f55152a;

    public IdGenerator(WorkDatabase workDatabase) {
        Intrinsics.checkNotNullParameter(workDatabase, "workDatabase");
        this.f55152a = workDatabase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer d(IdGenerator this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return Integer.valueOf(IdGeneratorKt.d(this$0.f55152a, "next_alarm_manager_id"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer f(IdGenerator this$0, int i3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int iD = IdGeneratorKt.d(this$0.f55152a, "next_job_scheduler_id");
        if (i3 > iD || iD > i4) {
            IdGeneratorKt.e(this$0.f55152a, "next_job_scheduler_id", i3 + 1);
        } else {
            i3 = iD;
        }
        return Integer.valueOf(i3);
    }

    public final int c() {
        Object objRunInTransaction = this.f55152a.runInTransaction((Callable<Object>) new Callable() { // from class: androidx.work.impl.utils.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return IdGenerator.d(this.f55224a);
            }
        });
        Intrinsics.checkNotNullExpressionValue(objRunInTransaction, "workDatabase.runInTransa…ANAGER_ID_KEY)\n        })");
        return ((Number) objRunInTransaction).intValue();
    }

    public final int e(final int i3, final int i4) {
        Object objRunInTransaction = this.f55152a.runInTransaction((Callable<Object>) new Callable() { // from class: androidx.work.impl.utils.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return IdGenerator.f(this.f55225a, i3, i4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(objRunInTransaction, "workDatabase.runInTransa…            id\n        })");
        return ((Number) objRunInTransaction).intValue();
    }
}
