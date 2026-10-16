package cz.mobilesoft.coreblock.storage.datastore.entity;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

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
public final class DiscountNotificationSettings {
    public static final int $stable = 0;
    private final long firstAfterHours;
    private final String firstText;
    private final String firstTitle;
    private final long repeatAfterDays;
    private final String repeatedText;
    private final String repeatedTitle;
    private final long secondAfterHours;
    private final String secondText;
    private final String secondTitle;

    public DiscountNotificationSettings() {
        this(0L, 0L, 0L, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ DiscountNotificationSettings copy$default(DiscountNotificationSettings discountNotificationSettings, long j3, long j4, long j5, String str, String str2, String str3, String str4, String str5, String str6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = discountNotificationSettings.firstAfterHours;
        }
        return discountNotificationSettings.copy(j3, (i3 & 2) != 0 ? discountNotificationSettings.secondAfterHours : j4, (i3 & 4) != 0 ? discountNotificationSettings.repeatAfterDays : j5, (i3 & 8) != 0 ? discountNotificationSettings.firstTitle : str, (i3 & 16) != 0 ? discountNotificationSettings.firstText : str2, (i3 & 32) != 0 ? discountNotificationSettings.secondTitle : str3, (i3 & 64) != 0 ? discountNotificationSettings.secondText : str4, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? discountNotificationSettings.repeatedTitle : str5, (i3 & Function.MAX_NARGS) != 0 ? discountNotificationSettings.repeatedText : str6);
    }

    public final long component1() {
        return this.firstAfterHours;
    }

    public final long component2() {
        return this.secondAfterHours;
    }

    public final long component3() {
        return this.repeatAfterDays;
    }

    public final String component4() {
        return this.firstTitle;
    }

    public final String component5() {
        return this.firstText;
    }

    public final String component6() {
        return this.secondTitle;
    }

    public final String component7() {
        return this.secondText;
    }

    public final String component8() {
        return this.repeatedTitle;
    }

    public final String component9() {
        return this.repeatedText;
    }

    public final DiscountNotificationSettings copy(long j3, long j4, long j5, String str, String str2, String str3, String str4, String str5, String str6) {
        return new DiscountNotificationSettings(j3, j4, j5, str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiscountNotificationSettings)) {
            return false;
        }
        DiscountNotificationSettings discountNotificationSettings = (DiscountNotificationSettings) obj;
        return this.firstAfterHours == discountNotificationSettings.firstAfterHours && this.secondAfterHours == discountNotificationSettings.secondAfterHours && this.repeatAfterDays == discountNotificationSettings.repeatAfterDays && Intrinsics.areEqual(this.firstTitle, discountNotificationSettings.firstTitle) && Intrinsics.areEqual(this.firstText, discountNotificationSettings.firstText) && Intrinsics.areEqual(this.secondTitle, discountNotificationSettings.secondTitle) && Intrinsics.areEqual(this.secondText, discountNotificationSettings.secondText) && Intrinsics.areEqual(this.repeatedTitle, discountNotificationSettings.repeatedTitle) && Intrinsics.areEqual(this.repeatedText, discountNotificationSettings.repeatedText);
    }

    public final long getFirstAfterHours() {
        return this.firstAfterHours;
    }

    public final String getFirstText() {
        return this.firstText;
    }

    public final String getFirstTitle() {
        return this.firstTitle;
    }

    public final String getFormattedText(int i3, int i4) {
        String str = i3 == 0 ? this.firstText : i3 == 1 ? this.secondText : i3 >= 2 ? this.repeatedText : null;
        if (str == null) {
            return null;
        }
        if (!StringsKt.a0(str, "%d", false, 2, null)) {
            return str;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str2 = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(i4)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public final long getRepeatAfterDays() {
        return this.repeatAfterDays;
    }

    public final String getRepeatedText() {
        return this.repeatedText;
    }

    public final String getRepeatedTitle() {
        return this.repeatedTitle;
    }

    public final long getSecondAfterHours() {
        return this.secondAfterHours;
    }

    public final String getSecondText() {
        return this.secondText;
    }

    public final String getSecondTitle() {
        return this.secondTitle;
    }

    public final String getTitle(int i3) {
        if (i3 == 0) {
            return this.firstTitle;
        }
        if (i3 == 1) {
            return this.secondTitle;
        }
        if (i3 >= 2) {
            return this.repeatedTitle;
        }
        return null;
    }

    public int hashCode() {
        int iHashCode = ((((Long.hashCode(this.firstAfterHours) * 31) + Long.hashCode(this.secondAfterHours)) * 31) + Long.hashCode(this.repeatAfterDays)) * 31;
        String str = this.firstTitle;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.firstText;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.secondTitle;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.secondText;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.repeatedTitle;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.repeatedText;
        return iHashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "DiscountNotificationSettings(firstAfterHours=" + this.firstAfterHours + ", secondAfterHours=" + this.secondAfterHours + ", repeatAfterDays=" + this.repeatAfterDays + ", firstTitle=" + this.firstTitle + ", firstText=" + this.firstText + ", secondTitle=" + this.secondTitle + ", secondText=" + this.secondText + ", repeatedTitle=" + this.repeatedTitle + ", repeatedText=" + this.repeatedText + ")";
    }

    public DiscountNotificationSettings(long j3, long j4, long j5, String str, String str2, String str3, String str4, String str5, String str6) {
        this.firstAfterHours = j3;
        this.secondAfterHours = j4;
        this.repeatAfterDays = j5;
        this.firstTitle = str;
        this.firstText = str2;
        this.secondTitle = str3;
        this.secondText = str4;
        this.repeatedTitle = str5;
        this.repeatedText = str6;
    }

    public /* synthetic */ DiscountNotificationSettings(long j3, long j4, long j5, String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 24L : j3, (i3 & 2) != 0 ? 48L : j4, (i3 & 4) != 0 ? 14L : j5, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? null : str4, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str5, (i3 & Function.MAX_NARGS) != 0 ? null : str6);
    }
}
