package androidx.glance.session;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TimeoutOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f39671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f39672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f39673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TimeSource f39674d;

    public /* synthetic */ TimeoutOptions(long j3, long j4, long j5, TimeSource timeSource, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, timeSource);
    }

    public final long a() {
        return this.f39672b;
    }

    public final long b() {
        return this.f39673c;
    }

    public final long c() {
        return this.f39671a;
    }

    public final TimeSource d() {
        return this.f39674d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeoutOptions)) {
            return false;
        }
        TimeoutOptions timeoutOptions = (TimeoutOptions) obj;
        return Duration.k(this.f39671a, timeoutOptions.f39671a) && Duration.k(this.f39672b, timeoutOptions.f39672b) && Duration.k(this.f39673c, timeoutOptions.f39673c) && Intrinsics.areEqual(this.f39674d, timeoutOptions.f39674d);
    }

    public int hashCode() {
        return (((((Duration.y(this.f39671a) * 31) + Duration.y(this.f39672b)) * 31) + Duration.y(this.f39673c)) * 31) + this.f39674d.hashCode();
    }

    public String toString() {
        return "TimeoutOptions(initialTimeout=" + ((Object) Duration.Q(this.f39671a)) + ", additionalTime=" + ((Object) Duration.Q(this.f39672b)) + ", idleTimeout=" + ((Object) Duration.Q(this.f39673c)) + ", timeSource=" + this.f39674d + ')';
    }

    private TimeoutOptions(long j3, long j4, long j5, TimeSource timeSource) {
        this.f39671a = j3;
        this.f39672b = j4;
        this.f39673c = j5;
        this.f39674d = timeSource;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TimeoutOptions(long j3, long j4, long j5, TimeSource timeSource, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        long jS;
        long jS2;
        long jS3;
        if ((i3 & 1) != 0) {
            Duration.Companion companion = Duration.f140631b;
            jS = DurationKt.s(45, DurationUnit.f140641f);
        } else {
            jS = j3;
        }
        if ((i3 & 2) != 0) {
            Duration.Companion companion2 = Duration.f140631b;
            jS2 = DurationKt.s(5, DurationUnit.f140641f);
        } else {
            jS2 = j4;
        }
        if ((i3 & 4) != 0) {
            Duration.Companion companion3 = Duration.f140631b;
            jS3 = DurationKt.s(5, DurationUnit.f140641f);
        } else {
            jS3 = j5;
        }
        this(jS, jS2, jS3, (i3 & 8) != 0 ? TimeSource.f39665a.a() : timeSource, null);
    }
}
