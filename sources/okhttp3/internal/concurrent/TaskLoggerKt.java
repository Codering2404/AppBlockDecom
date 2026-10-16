package okhttp3.internal.concurrent;

import coil.target.Yb.oUcQRqOVfOC;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class TaskLoggerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Task task, TaskQueue taskQueue, String str) {
        Logger loggerA = TaskRunner.f144397h.a();
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.f());
        sb.append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(task.b());
        loggerA.fine(sb.toString());
    }

    public static final String b(long j3) {
        String str;
        if (j3 <= -999500000) {
            str = ((j3 - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j3 <= -999500) {
            str = ((j3 - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j3 <= 0) {
            str = ((j3 - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j3 < 999500) {
            str = ((j3 + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j3 < 999500000) {
            str = ((j3 + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j3 + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, oUcQRqOVfOC.TutyRhrNAWKqJ);
        return str2;
    }
}
