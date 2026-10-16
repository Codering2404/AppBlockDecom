package cz.mobilesoft.coreblock.scene.streaks;

import com.facebook.ads.AdError;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StreakDates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StreakDates f120261a = new StreakDates();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final DateTimeFormatter f120262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LocalDate f120263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f120264d;

    static {
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatterOfPattern, "ofPattern(...)");
        f120262b = dateTimeFormatterOfPattern;
        LocalDate localDateOf = LocalDate.of(AdError.SERVER_ERROR_CODE, 1, 1);
        Intrinsics.checkNotNullExpressionValue(localDateOf, "of(...)");
        f120263c = localDateOf;
        f120264d = 8;
    }

    private StreakDates() {
    }

    public static /* synthetic */ LocalDate g(StreakDates streakDates, long j3, ZoneId zoneId, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakDates.f(j3, zoneId);
    }

    public final long a(LocalDate date, ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        LocalDate localDatePlusDays = date.plusDays(1L);
        Intrinsics.checkNotNullExpressionValue(localDatePlusDays, "plusDays(...)");
        return d(localDatePlusDays, zoneId);
    }

    public final String b(long j3, ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        return c(f(j3, zoneId));
    }

    public final String c(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String str = date.format(f120262b);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final long d(LocalDate date, ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        return date.atStartOfDay(zoneId).toInstant().toEpochMilli();
    }

    public final LocalDate e() {
        return f120263c;
    }

    public final LocalDate f(long j3, ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        LocalDate localDate = Instant.ofEpochMilli(j3).atZone(zoneId).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
        return localDate;
    }

    public final LocalDate h(String dayKey) {
        Intrinsics.checkNotNullParameter(dayKey, "dayKey");
        try {
            return LocalDate.parse(dayKey, f120262b);
        } catch (Exception unused) {
            return null;
        }
    }
}
