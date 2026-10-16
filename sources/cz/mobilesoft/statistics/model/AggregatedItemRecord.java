package cz.mobilesoft.statistics.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AggregatedItemRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f133697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f133698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f133699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f133700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f133701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f133702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f133703g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f133704a;

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
            f133704a = iArr;
        }
    }

    public AggregatedItemRecord(int i3, String name, String str, Integer num, int i4, String str2, String str3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133697a = i3;
        this.f133698b = name;
        this.f133699c = str;
        this.f133700d = num;
        this.f133701e = i4;
        this.f133702f = str2;
        this.f133703g = str3;
    }

    public final String a() {
        return this.f133702f;
    }

    public final String b() {
        return this.f133703g;
    }

    public final int c() {
        return this.f133697a;
    }

    public final Integer d() {
        return this.f133700d;
    }

    public final String e() {
        return this.f133698b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AggregatedItemRecord)) {
            return false;
        }
        AggregatedItemRecord aggregatedItemRecord = (AggregatedItemRecord) obj;
        return this.f133697a == aggregatedItemRecord.f133697a && Intrinsics.areEqual(this.f133698b, aggregatedItemRecord.f133698b) && Intrinsics.areEqual(this.f133699c, aggregatedItemRecord.f133699c) && Intrinsics.areEqual(this.f133700d, aggregatedItemRecord.f133700d) && this.f133701e == aggregatedItemRecord.f133701e && Intrinsics.areEqual(this.f133702f, aggregatedItemRecord.f133702f) && Intrinsics.areEqual(this.f133703g, aggregatedItemRecord.f133703g);
    }

    public final String f() {
        return this.f133699c;
    }

    public final int g() {
        return this.f133701e;
    }

    public final Integer h(RecordType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = WhenMappings.f133704a[type.ordinal()];
        if (i3 == 1) {
            return Integer.valueOf(this.f133697a);
        }
        if (i3 == 2) {
            return this.f133700d;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.f133697a) * 31) + this.f133698b.hashCode()) * 31;
        String str = this.f133699c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.f133700d;
        int iHashCode3 = (((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.f133701e)) * 31;
        String str2 = this.f133702f;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f133703g;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return this.f133698b + ": " + this.f133697a + " s";
    }

    public /* synthetic */ AggregatedItemRecord(int i3, String str, String str2, Integer num, int i4, String str3, String str4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i5 & 4) != 0 ? null : str2, (i5 & 8) != 0 ? null : num, i4, (i5 & 32) != 0 ? null : str3, (i5 & 64) != 0 ? null : str4);
    }
}
