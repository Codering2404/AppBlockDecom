package cz.mobilesoft.coreblock.storage.room.entity.core;

import cz.mobilesoft.coreblock.enums.MoodType;
import java.time.LocalDate;
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
public final class MoodCheckInEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MoodType f126569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f126570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LocalDate f126571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f126572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f126573f;

    public MoodCheckInEntity(long j3, MoodType mood, int i3, LocalDate day, long j4, String str) {
        Intrinsics.checkNotNullParameter(mood, "mood");
        Intrinsics.checkNotNullParameter(day, "day");
        this.f126568a = j3;
        this.f126569b = mood;
        this.f126570c = i3;
        this.f126571d = day;
        this.f126572e = j4;
        this.f126573f = str;
    }

    public final long a() {
        return this.f126572e;
    }

    public final LocalDate b() {
        return this.f126571d;
    }

    public final long c() {
        return this.f126568a;
    }

    public final MoodType d() {
        return this.f126569b;
    }

    public final int e() {
        return this.f126570c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MoodCheckInEntity)) {
            return false;
        }
        MoodCheckInEntity moodCheckInEntity = (MoodCheckInEntity) obj;
        return this.f126568a == moodCheckInEntity.f126568a && this.f126569b == moodCheckInEntity.f126569b && this.f126570c == moodCheckInEntity.f126570c && Intrinsics.areEqual(this.f126571d, moodCheckInEntity.f126571d) && this.f126572e == moodCheckInEntity.f126572e && Intrinsics.areEqual(this.f126573f, moodCheckInEntity.f126573f);
    }

    public final String f() {
        return this.f126573f;
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.f126568a) * 31) + this.f126569b.hashCode()) * 31) + Integer.hashCode(this.f126570c)) * 31) + this.f126571d.hashCode()) * 31) + Long.hashCode(this.f126572e)) * 31;
        String str = this.f126573f;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "MoodCheckInEntity(id=" + this.f126568a + ", mood=" + this.f126569b + ", moodRawValue=" + this.f126570c + ", day=" + this.f126571d + ", createdAt=" + this.f126572e + ", note=" + this.f126573f + ")";
    }

    public /* synthetic */ MoodCheckInEntity(long j3, MoodType moodType, int i3, LocalDate localDate, long j4, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j3, moodType, i3, localDate, j4, str);
    }
}
