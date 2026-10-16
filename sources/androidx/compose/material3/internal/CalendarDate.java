package androidx.compose.material3.internal;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CalendarDate implements Comparable<CalendarDate> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f21985d;

    public CalendarDate(int i3, int i4, int i5, long j3) {
        this.f21982a = i3;
        this.f21983b = i4;
        this.f21984c = i5;
        this.f21985d = j3;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(CalendarDate calendarDate) {
        return Intrinsics.compare(this.f21985d, calendarDate.f21985d);
    }

    public final int b() {
        return this.f21984c;
    }

    public final int c() {
        return this.f21983b;
    }

    public final long d() {
        return this.f21985d;
    }

    public final int e() {
        return this.f21982a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarDate)) {
            return false;
        }
        CalendarDate calendarDate = (CalendarDate) obj;
        return this.f21982a == calendarDate.f21982a && this.f21983b == calendarDate.f21983b && this.f21984c == calendarDate.f21984c && this.f21985d == calendarDate.f21985d;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.f21982a) * 31) + Integer.hashCode(this.f21983b)) * 31) + Integer.hashCode(this.f21984c)) * 31) + Long.hashCode(this.f21985d);
    }

    public String toString() {
        return "CalendarDate(year=" + this.f21982a + bfIdKSjLOVjG.jmlm + this.f21983b + ", dayOfMonth=" + this.f21984c + ", utcTimeMillis=" + this.f21985d + ')';
    }
}
