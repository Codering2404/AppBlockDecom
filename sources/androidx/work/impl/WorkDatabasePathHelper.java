package androidx.work.impl;

import android.content.Context;
import androidx.work.Logger;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class WorkDatabasePathHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WorkDatabasePathHelper f54665a = new WorkDatabasePathHelper();

    private WorkDatabasePathHelper() {
    }

    private final File c(Context context) {
        return new File(Api21Impl.f54621a.a(context), "androidx.work.workdb");
    }

    public static final void d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WorkDatabasePathHelper workDatabasePathHelper = f54665a;
        if (workDatabasePathHelper.b(context).exists()) {
            Logger.e().a(WorkDatabasePathHelperKt.f54666a, "Migrating WorkDatabase to the no-backup directory");
            for (Map.Entry entry : workDatabasePathHelper.e(context).entrySet()) {
                File file = (File) entry.getKey();
                File file2 = (File) entry.getValue();
                if (file.exists()) {
                    if (file2.exists()) {
                        Logger.e().k(WorkDatabasePathHelperKt.f54666a, "Over-writing contents of " + file2);
                    }
                    Logger.e().a(WorkDatabasePathHelperKt.f54666a, file.renameTo(file2) ? "Migrated " + file + "to " + file2 : "Renaming " + file + " to " + file2 + " failed");
                }
            }
        }
    }

    public final File a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return c(context);
    }

    public final File b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File databasePath = context.getDatabasePath("androidx.work.workdb");
        Intrinsics.checkNotNullExpressionValue(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return databasePath;
    }

    public final Map e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File fileB = b(context);
        File fileA = a(context);
        String[] strArr = WorkDatabasePathHelperKt.f54667b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(strArr.length), 16));
        for (String str : strArr) {
            Pair pairA = TuplesKt.a(new File(fileB.getPath() + str), new File(fileA.getPath() + str));
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return MapsKt.plus(linkedHashMap, TuplesKt.a(fileB, fileA));
    }
}
