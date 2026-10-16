package cz.mobilesoft.statistics.model;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Record {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f133725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f133726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f133727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f133728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f133729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f133730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f133731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f133732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f133733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f133734j;

    public Record(long j3, long j4, String name, String str, int i3, int i4, boolean z2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f133725a = j3;
        this.f133726b = j4;
        this.f133727c = name;
        this.f133728d = str;
        this.f133729e = i3;
        this.f133730f = i4;
        this.f133731g = z2;
        this.f133732h = str2;
        this.f133733i = str3;
    }

    public final String a() {
        return this.f133732h;
    }

    public final String b() {
        return this.f133733i;
    }

    public final int c() {
        return this.f133730f;
    }

    public final long d() {
        return this.f133734j;
    }

    public final String e() {
        return this.f133727c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Record)) {
            return false;
        }
        Record record = (Record) obj;
        return this.f133725a == record.f133725a && this.f133726b == record.f133726b && Intrinsics.areEqual(this.f133727c, record.f133727c) && Intrinsics.areEqual(this.f133728d, record.f133728d) && this.f133729e == record.f133729e && this.f133730f == record.f133730f && this.f133731g == record.f133731g && Intrinsics.areEqual(this.f133732h, record.f133732h) && Intrinsics.areEqual(this.f133733i, record.f133733i);
    }

    public final long f() {
        return this.f133726b;
    }

    public final String g() {
        return this.f133728d;
    }

    public final long h() {
        return this.f133725a;
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.f133725a) * 31) + Long.hashCode(this.f133726b)) * 31) + this.f133727c.hashCode()) * 31;
        String str = this.f133728d;
        int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.f133729e)) * 31) + Integer.hashCode(this.f133730f)) * 31) + Boolean.hashCode(this.f133731g)) * 31;
        String str2 = this.f133732h;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f133733i;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final int i() {
        return this.f133729e;
    }

    public final boolean j() {
        return this.f133731g;
    }

    public String toString() {
        return this.f133727c + ": " + this.f133725a;
    }

    public /* synthetic */ Record(long j3, long j4, String str, String str2, int i3, int i4, boolean z2, String str3, String str4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, str, (i5 & 8) != 0 ? null : str2, i3, (i5 & 32) != 0 ? 60 : i4, (i5 & 64) != 0 ? false : z2, (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str3, (i5 & Function.MAX_NARGS) != 0 ? null : str4);
    }
}
