package androidx.work;

import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class WorkInfo {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f54562m = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UUID f54563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final State f54564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f54565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Data f54566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Data f54567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f54568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f54569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Constraints f54570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f54571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final PeriodicityInfo f54572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f54573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f54574l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PeriodicityInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f54575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f54576b;

        public PeriodicityInfo(long j3, long j4) {
            this.f54575a = j3;
            this.f54576b = j4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Intrinsics.areEqual(PeriodicityInfo.class, obj.getClass())) {
                PeriodicityInfo periodicityInfo = (PeriodicityInfo) obj;
                if (periodicityInfo.f54575a == this.f54575a && periodicityInfo.f54576b == this.f54576b) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (Long.hashCode(this.f54575a) * 31) + Long.hashCode(this.f54576b);
        }

        public String toString() {
            return "PeriodicityInfo{repeatIntervalMillis=" + this.f54575a + ", flexIntervalMillis=" + this.f54576b + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public final boolean b() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    public WorkInfo(UUID id, State state, Set tags, Data outputData, Data progress, int i3, int i4, Constraints constraints, long j3, PeriodicityInfo periodicityInfo, long j4, int i5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(constraints, "constraints");
        this.f54563a = id;
        this.f54564b = state;
        this.f54565c = tags;
        this.f54566d = outputData;
        this.f54567e = progress;
        this.f54568f = i3;
        this.f54569g = i4;
        this.f54570h = constraints;
        this.f54571i = j3;
        this.f54572j = periodicityInfo;
        this.f54573k = j4;
        this.f54574l = i5;
    }

    public final State a() {
        return this.f54564b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual(WorkInfo.class, obj.getClass())) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f54568f == workInfo.f54568f && this.f54569g == workInfo.f54569g && Intrinsics.areEqual(this.f54563a, workInfo.f54563a) && this.f54564b == workInfo.f54564b && Intrinsics.areEqual(this.f54566d, workInfo.f54566d) && Intrinsics.areEqual(this.f54570h, workInfo.f54570h) && this.f54571i == workInfo.f54571i && Intrinsics.areEqual(this.f54572j, workInfo.f54572j) && this.f54573k == workInfo.f54573k && this.f54574l == workInfo.f54574l && Intrinsics.areEqual(this.f54565c, workInfo.f54565c)) {
            return Intrinsics.areEqual(this.f54567e, workInfo.f54567e);
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.f54563a.hashCode() * 31) + this.f54564b.hashCode()) * 31) + this.f54566d.hashCode()) * 31) + this.f54565c.hashCode()) * 31) + this.f54567e.hashCode()) * 31) + this.f54568f) * 31) + this.f54569g) * 31) + this.f54570h.hashCode()) * 31) + Long.hashCode(this.f54571i)) * 31;
        PeriodicityInfo periodicityInfo = this.f54572j;
        return ((((iHashCode + (periodicityInfo != null ? periodicityInfo.hashCode() : 0)) * 31) + Long.hashCode(this.f54573k)) * 31) + Integer.hashCode(this.f54574l);
    }

    public String toString() {
        return "WorkInfo{id='" + this.f54563a + "', state=" + this.f54564b + ", outputData=" + this.f54566d + ", tags=" + this.f54565c + ", progress=" + this.f54567e + ", runAttemptCount=" + this.f54568f + ", generation=" + this.f54569g + ", constraints=" + this.f54570h + ", initialDelayMillis=" + this.f54571i + ", periodicityInfo=" + this.f54572j + ", nextScheduleTimeMillis=" + this.f54573k + "}, stopReason=" + this.f54574l;
    }
}
