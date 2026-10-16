package cz.mobilesoft.statistics.scene.graph;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.facebook.AccessTokenManager;
import cz.mobilesoft.statistics.di.BaseViewModel;
import cz.mobilesoft.statistics.di.Repository;
import cz.mobilesoft.statistics.model.AggregatedRecord;
import cz.mobilesoft.statistics.model.AggregatedRecordsWithAverage;
import cz.mobilesoft.statistics.model.RecordType;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
public abstract class GraphViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Repository f133812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableLiveData f133813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableLiveData f133814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f133815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f133816j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Integer[] f133817k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private RecordType f133818l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String[] f133819m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String[] f133820n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Locale f133821o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f133822a;

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
            f133822a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GraphViewModel(Repository repo, Application application) {
        Locale locale;
        super(application);
        Intrinsics.checkNotNullParameter(repo, "repo");
        Intrinsics.checkNotNullParameter(application, "application");
        this.f133812f = repo;
        this.f133813g = new MutableLiveData();
        this.f133814h = new MutableLiveData();
        this.f133818l = RecordType.f133740a;
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), "ar")) {
            locale = Locale.US;
            Intrinsics.checkNotNull(locale);
        } else {
            locale = Locale.getDefault();
            Intrinsics.checkNotNull(locale);
        }
        this.f133821o = locale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C0() {
        float fA;
        AggregatedRecordsWithAverage aggregatedRecordsWithAverageJ0 = J0();
        TreeMap treeMapF0 = F0();
        for (AggregatedRecord aggregatedRecord : aggregatedRecordsWithAverageJ0.d()) {
            List list = (List) treeMapF0.get(aggregatedRecord.c());
            if (list != null) {
                list.add(aggregatedRecord);
            }
        }
        MutableLiveData mutableLiveData = this.f133814h;
        int i3 = WhenMappings.f133822a[this.f133818l.ordinal()];
        if (i3 == 1) {
            fA = aggregatedRecordsWithAverageJ0.c().a() / AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS;
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            fA = aggregatedRecordsWithAverageJ0.c().b();
        }
        mutableLiveData.n(Float.valueOf(fA));
        this.f133813g.n(treeMapF0);
    }

    public final MutableLiveData B0() {
        return this.f133814h;
    }

    public final long D0() {
        return this.f133816j;
    }

    public final String[] E0() {
        return this.f133820n;
    }

    public abstract TreeMap F0();

    public final Locale G0() {
        return this.f133821o;
    }

    public final String[] H0() {
        return this.f133819m;
    }

    public final RecordType I0() {
        return this.f133818l;
    }

    public abstract AggregatedRecordsWithAverage J0();

    protected final Repository K0() {
        return this.f133812f;
    }

    public final long L0() {
        return this.f133815i;
    }

    public final Integer[] M0() {
        return this.f133817k;
    }

    public final MutableLiveData N0() {
        return this.f133813g;
    }

    public final void O0(Integer[] numArr, String[] strArr, String[] strArr2, long j3, long j4, RecordType recordType) {
        this.f133815i = j3;
        this.f133816j = j4;
        this.f133817k = numArr;
        this.f133819m = strArr;
        this.f133820n = strArr2;
        if (recordType != null) {
            this.f133818l = recordType;
        }
        BuildersKt__Builders_commonKt.d(z0(), null, null, new GraphViewModel$initData$2(this, null), 3, null);
    }

    public final void P0() {
        BuildersKt__Builders_commonKt.d(z0(), null, null, new GraphViewModel$update$1(this, null), 3, null);
    }

    public final void Q0(Integer[] numArr, RecordType recordType) {
        Integer[] numArr2;
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        if (numArr == null && this.f133817k == null && recordType == this.f133818l) {
            return;
        }
        if (numArr == null || (numArr2 = this.f133817k) == null || numArr2 == null || !Arrays.equals(numArr2, numArr) || recordType != this.f133818l) {
            this.f133817k = numArr;
            this.f133818l = recordType;
            BuildersKt__Builders_commonKt.d(z0(), null, null, new GraphViewModel$updateFilter$1(this, null), 3, null);
        }
    }

    public final void R0(String[] strArr) {
        this.f133820n = strArr;
        BuildersKt__Builders_commonKt.d(z0(), null, null, new GraphViewModel$updateIgnoredItems$1(this, null), 3, null);
    }
}
