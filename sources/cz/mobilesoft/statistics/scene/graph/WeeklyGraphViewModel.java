package cz.mobilesoft.statistics.scene.graph;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import cz.mobilesoft.statistics.di.Repository;
import cz.mobilesoft.statistics.model.AggregatedRecord;
import cz.mobilesoft.statistics.model.AggregatedRecordsWithAverage;
import cz.mobilesoft.statistics.model.RecordType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WeeklyGraphViewModel extends GraphViewModel {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f133840p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f133841q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f133842a;

        static {
            int[] iArr = new int[RecordType.values().length];
            try {
                iArr[RecordType.f133740a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RecordType.f133741b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f133842a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeeklyGraphViewModel(Repository repo, Application application) {
        super(repo, application);
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(application, "application");
        this.f133840p = LazyKt.b(new Function0() { // from class: cz.mobilesoft.statistics.scene.graph.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WeeklyGraphViewModel.Z0(this.f133844a);
            }
        });
        this.f133841q = LazyKt.b(new Function0() { // from class: cz.mobilesoft.statistics.scene.graph.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WeeklyGraphViewModel.X0(this.f133845a);
            }
        });
    }

    private final Pair W0(RecordType recordType, TreeMap treeMap) throws ParseException {
        int iD;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", G0());
        Set setKeySet = treeMap.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        Set set = setKeySet;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator it = set.iterator();
        while (true) {
            Object next = null;
            Long lValueOf = null;
            if (!it.hasNext()) {
                Iterator it2 = arrayList.iterator();
                if (it2.hasNext()) {
                    next = it2.next();
                    if (it2.hasNext()) {
                        long jLongValue = ((Number) ((Pair) next).f()).longValue();
                        do {
                            Object next2 = it2.next();
                            long jLongValue2 = ((Number) ((Pair) next2).f()).longValue();
                            if (jLongValue < jLongValue2) {
                                next = next2;
                                jLongValue = jLongValue2;
                            }
                        } while (it2.hasNext());
                    }
                }
                return (Pair) next;
            }
            String str = (String) it.next();
            List<AggregatedRecord> list = (List) treeMap.get(str);
            long jLongValue3 = 0;
            if (list != null) {
                lValueOf = 0L;
                for (AggregatedRecord aggregatedRecord : list) {
                    long jLongValue4 = lValueOf.longValue();
                    int i3 = WhenMappings.f133842a[recordType.ordinal()];
                    if (i3 == 1) {
                        iD = aggregatedRecord.d();
                    } else {
                        if (i3 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Integer numF = aggregatedRecord.f();
                        iD = numF != null ? numF.intValue() : 0;
                    }
                    lValueOf = Long.valueOf(jLongValue4 + ((long) iD));
                }
            }
            Date date = simpleDateFormat.parse(str);
            Long lValueOf2 = Long.valueOf(date != null ? date.getTime() : 0L);
            if (lValueOf != null) {
                jLongValue3 = lValueOf.longValue();
            }
            arrayList.add(new Pair(lValueOf2, Long.valueOf(jLongValue3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData X0(final WeeklyGraphViewModel weeklyGraphViewModel) {
        return Transformations.f(weeklyGraphViewModel.N0(), new Function1() { // from class: cz.mobilesoft.statistics.scene.graph.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WeeklyGraphViewModel.Y0(this.f133846a, (TreeMap) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData Y0(WeeklyGraphViewModel weeklyGraphViewModel, TreeMap treeMap) {
        RecordType recordType = RecordType.f133741b;
        Intrinsics.checkNotNull(treeMap);
        return new MutableLiveData(weeklyGraphViewModel.W0(recordType, treeMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData Z0(final WeeklyGraphViewModel weeklyGraphViewModel) {
        return Transformations.f(weeklyGraphViewModel.N0(), new Function1() { // from class: cz.mobilesoft.statistics.scene.graph.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WeeklyGraphViewModel.a1(this.f133847a, (TreeMap) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData a1(WeeklyGraphViewModel weeklyGraphViewModel, TreeMap treeMap) {
        RecordType recordType = RecordType.f133740a;
        Intrinsics.checkNotNull(treeMap);
        return new MutableLiveData(weeklyGraphViewModel.W0(recordType, treeMap));
    }

    @Override // cz.mobilesoft.statistics.scene.graph.GraphViewModel
    public AggregatedRecordsWithAverage J0() {
        return K0().M(M0(), H0(), E0(), L0(), D0());
    }

    @Override // cz.mobilesoft.statistics.scene.graph.GraphViewModel
    public TreeMap F0() {
        TreeMap treeMap = new TreeMap();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(jTYhJgqLBN.fdIYcq, G0());
        Calendar calendar = Calendar.getInstance(G0());
        calendar.setTimeInMillis(L0());
        while (calendar.getTimeInMillis() < D0()) {
            treeMap.put(simpleDateFormat.format(calendar.getTime()), new ArrayList());
            calendar.add(6, 1);
        }
        return treeMap;
    }
}
