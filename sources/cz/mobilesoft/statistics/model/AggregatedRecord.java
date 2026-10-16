package cz.mobilesoft.statistics.model;

import com.facebook.AccessTokenManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class AggregatedRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f133705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f133706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f133707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f133708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f133709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f133710f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f133711a;

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
            f133711a = iArr;
        }
    }

    public AggregatedRecord(String date, int i3, Integer num, int i4, String str, String str2) {
        Intrinsics.checkNotNullParameter(date, "date");
        this.f133705a = date;
        this.f133706b = i3;
        this.f133707c = num;
        this.f133708d = i4;
        this.f133709e = str;
        this.f133710f = str2;
    }

    public final String a() {
        return this.f133709e;
    }

    public final int b() {
        Integer num = this.f133707c;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final String c() {
        return this.f133705a;
    }

    public final int d() {
        return this.f133706b;
    }

    public final float e() {
        return this.f133706b / AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AggregatedRecord)) {
            return false;
        }
        AggregatedRecord aggregatedRecord = (AggregatedRecord) obj;
        return Intrinsics.areEqual(this.f133705a, aggregatedRecord.f133705a) && this.f133706b == aggregatedRecord.f133706b && Intrinsics.areEqual(this.f133707c, aggregatedRecord.f133707c) && this.f133708d == aggregatedRecord.f133708d && Intrinsics.areEqual(this.f133709e, aggregatedRecord.f133709e) && Intrinsics.areEqual(this.f133710f, aggregatedRecord.f133710f);
    }

    public final Integer f() {
        return this.f133707c;
    }

    public final int g() {
        return this.f133708d;
    }

    public final float h(RecordType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = WhenMappings.f133711a[type.ordinal()];
        if (i3 == 1) {
            return e();
        }
        if (i3 == 2) {
            return b();
        }
        throw new NoWhenBranchMatchedException();
    }

    public int hashCode() {
        int iHashCode = ((this.f133705a.hashCode() * 31) + Integer.hashCode(this.f133706b)) * 31;
        Integer num = this.f133707c;
        int iHashCode2 = (((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.f133708d)) * 31;
        String str = this.f133709e;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f133710f;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AggregatedRecord(date=" + this.f133705a + ", duration=" + this.f133706b + ", launchCount=" + this.f133707c + ", typeId=" + this.f133708d + ", appDistractionType=" + this.f133709e + ", category=" + this.f133710f + ")";
    }
}
