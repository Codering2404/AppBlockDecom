package androidx.compose.material3.internal;

import kotlin.Metadata;
import kotlin.ranges.IntRange;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CalendarMonth {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f21997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f21998f;

    public CalendarMonth(int i3, int i4, int i5, int i6, long j3) {
        this.f21993a = i3;
        this.f21994b = i4;
        this.f21995c = i5;
        this.f21996d = i6;
        this.f21997e = j3;
        this.f21998f = (j3 + (((long) i5) * 86400000)) - 1;
    }

    public final int a() {
        return this.f21996d;
    }

    public final long b() {
        return this.f21998f;
    }

    public final int c() {
        return this.f21994b;
    }

    public final int d() {
        return this.f21995c;
    }

    public final long e() {
        return this.f21997e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarMonth)) {
            return false;
        }
        CalendarMonth calendarMonth = (CalendarMonth) obj;
        return this.f21993a == calendarMonth.f21993a && this.f21994b == calendarMonth.f21994b && this.f21995c == calendarMonth.f21995c && this.f21996d == calendarMonth.f21996d && this.f21997e == calendarMonth.f21997e;
    }

    public final int f() {
        return this.f21993a;
    }

    public final int g(IntRange intRange) {
        return (((this.f21993a - intRange.g()) * 12) + this.f21994b) - 1;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.f21993a) * 31) + Integer.hashCode(this.f21994b)) * 31) + Integer.hashCode(this.f21995c)) * 31) + Integer.hashCode(this.f21996d)) * 31) + Long.hashCode(this.f21997e);
    }

    public String toString() {
        return "CalendarMonth(year=" + this.f21993a + ", month=" + this.f21994b + ", numberOfDays=" + this.f21995c + ", daysFromStartOfWeekToFirstOfMonth=" + this.f21996d + ", startUtcTimeMillis=" + this.f21997e + ')';
    }
}
