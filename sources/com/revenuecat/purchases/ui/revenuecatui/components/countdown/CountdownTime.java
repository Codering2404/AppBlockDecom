package com.revenuecat.purchases.ui.revenuecatui.components.countdown;

import com.facebook.AccessTokenManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CountdownTime {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final CountdownTime ZERO = new CountdownTime(0, 0, 0, 0);
    private final int days;
    private final int hours;
    private final int minutes;
    private final int seconds;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CountdownTime fromInterval(long j3) {
            long jMax = Math.max(0L, j3 / ((long) 1000));
            long j4 = AccessTokenManager.TOKEN_EXTEND_THRESHOLD_SECONDS;
            long j5 = AccessTokenManager.TOKEN_EXTEND_RETRY_SECONDS;
            long j6 = 60;
            return new CountdownTime((int) (jMax / j4), (int) ((jMax % j4) / j5), (int) ((jMax % j5) / j6), (int) (jMax % j6));
        }

        public final CountdownTime getZERO() {
            return CountdownTime.ZERO;
        }

        private Companion() {
        }
    }

    public CountdownTime(int i3, int i4, int i5, int i6) {
        this.days = i3;
        this.hours = i4;
        this.minutes = i5;
        this.seconds = i6;
    }

    public static /* synthetic */ CountdownTime copy$default(CountdownTime countdownTime, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i3 = countdownTime.days;
        }
        if ((i7 & 2) != 0) {
            i4 = countdownTime.hours;
        }
        if ((i7 & 4) != 0) {
            i5 = countdownTime.minutes;
        }
        if ((i7 & 8) != 0) {
            i6 = countdownTime.seconds;
        }
        return countdownTime.copy(i3, i4, i5, i6);
    }

    public final int component1() {
        return this.days;
    }

    public final int component2() {
        return this.hours;
    }

    public final int component3() {
        return this.minutes;
    }

    public final int component4() {
        return this.seconds;
    }

    public final CountdownTime copy(int i3, int i4, int i5, int i6) {
        return new CountdownTime(i3, i4, i5, i6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountdownTime)) {
            return false;
        }
        CountdownTime countdownTime = (CountdownTime) obj;
        return this.days == countdownTime.days && this.hours == countdownTime.hours && this.minutes == countdownTime.minutes && this.seconds == countdownTime.seconds;
    }

    public final int getDays() {
        return this.days;
    }

    public final int getHours() {
        return this.hours;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public final int getTotalHours() {
        return (this.days * 24) + this.hours;
    }

    public final int getTotalMinutes() {
        return (this.days * 1440) + (this.hours * 60) + this.minutes;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.days) * 31) + Integer.hashCode(this.hours)) * 31) + Integer.hashCode(this.minutes)) * 31) + Integer.hashCode(this.seconds);
    }

    public String toString() {
        return "CountdownTime(days=" + this.days + ", hours=" + this.hours + ", minutes=" + this.minutes + ", seconds=" + this.seconds + ')';
    }

    public static /* synthetic */ void getTotalHours$annotations() {
    }

    public static /* synthetic */ void getTotalMinutes$annotations() {
    }
}
