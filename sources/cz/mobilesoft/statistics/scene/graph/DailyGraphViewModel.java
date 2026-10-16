package cz.mobilesoft.statistics.scene.graph;

import android.app.Application;
import cz.mobilesoft.statistics.di.Repository;
import cz.mobilesoft.statistics.model.AggregatedRecordsWithAverage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DailyGraphViewModel extends GraphViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyGraphViewModel(Repository repo, Application application) {
        super(repo, application);
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(application, "application");
    }

    @Override // cz.mobilesoft.statistics.scene.graph.GraphViewModel
    public TreeMap F0() {
        TreeMap treeMap = new TreeMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH", G0());
        Calendar calendar = Calendar.getInstance(G0());
        calendar.setTimeInMillis(L0());
        while (calendar.getTimeInMillis() < D0()) {
            treeMap.put(simpleDateFormat.format(calendar.getTime()), new ArrayList());
            calendar.add(11, 1);
        }
        return treeMap;
    }

    @Override // cz.mobilesoft.statistics.scene.graph.GraphViewModel
    public AggregatedRecordsWithAverage J0() {
        return K0().p(M0(), H0(), E0(), L0(), D0());
    }
}
