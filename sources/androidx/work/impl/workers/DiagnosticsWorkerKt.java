package androidx.work.impl.workers;

import androidx.work.Logger;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.model.WorkTagDao;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class DiagnosticsWorkerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f55270a;

    static {
        String strI = Logger.i("DiagnosticsWrkr");
        Intrinsics.checkNotNullExpressionValue(strI, "tagWithPrefix(\"DiagnosticsWrkr\")");
        f55270a = strI;
    }

    private static final String c(WorkSpec workSpec, String str, Integer num, String str2) {
        return '\n' + workSpec.f55013a + "\t " + workSpec.f55015c + "\t " + num + "\t " + workSpec.f55014b.name() + "\t " + str + "\t " + str2 + '\t';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, List list) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            WorkSpec workSpec = (WorkSpec) it.next();
            SystemIdInfo systemIdInfoB = systemIdInfoDao.b(WorkSpecKt.a(workSpec));
            sb.append(c(workSpec, CollectionsKt.joinToString$default(workNameDao.b(workSpec.f55013a), pMpIcGE.OgGGozTBqmn, null, null, 0, null, null, 62, null), systemIdInfoB != null ? Integer.valueOf(systemIdInfoB.f54986c) : null, CollectionsKt.joinToString$default(workTagDao.a(workSpec.f55013a), pMpIcGE.OgGGozTBqmn, null, null, 0, null, null, 62, null)));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
