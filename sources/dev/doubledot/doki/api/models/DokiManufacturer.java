package dev.doubledot.doki.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.animation.core.Xrg.muQRKXGtpOhe;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
public final class DokiManufacturer implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private final int award;
    private final String dev_solution;
    private final String explanation;
    private final String[] manufacturer;
    private final String name;
    private final int position;
    private final String url;
    private final String user_solution;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CREATOR implements Parcelable.Creator<DokiManufacturer> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DokiManufacturer createFromParcel(Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "parcel");
            return new DokiManufacturer(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DokiManufacturer[] newArray(int i3) {
            return new DokiManufacturer[i3];
        }
    }

    public DokiManufacturer(String name, String[] manufacturer, String url, int i3, int i4, String explanation, String user_solution, String str) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(manufacturer, "manufacturer");
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(explanation, "explanation");
        Intrinsics.checkParameterIsNotNull(user_solution, "user_solution");
        this.name = name;
        this.manufacturer = manufacturer;
        this.url = url;
        this.award = i3;
        this.position = i4;
        this.explanation = explanation;
        this.user_solution = user_solution;
        this.dev_solution = str;
    }

    public static /* synthetic */ DokiManufacturer copy$default(DokiManufacturer dokiManufacturer, String str, String[] strArr, String str2, int i3, int i4, String str3, String str4, String str5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = dokiManufacturer.name;
        }
        if ((i5 & 2) != 0) {
            strArr = dokiManufacturer.manufacturer;
        }
        if ((i5 & 4) != 0) {
            str2 = dokiManufacturer.url;
        }
        if ((i5 & 8) != 0) {
            i3 = dokiManufacturer.award;
        }
        if ((i5 & 16) != 0) {
            i4 = dokiManufacturer.position;
        }
        if ((i5 & 32) != 0) {
            str3 = dokiManufacturer.explanation;
        }
        if ((i5 & 64) != 0) {
            str4 = dokiManufacturer.user_solution;
        }
        if ((i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            str5 = dokiManufacturer.dev_solution;
        }
        String str6 = str4;
        String str7 = str5;
        int i6 = i4;
        String str8 = str3;
        return dokiManufacturer.copy(str, strArr, str2, i3, i6, str8, str6, str7);
    }

    public final String component1() {
        return this.name;
    }

    public final String[] component2() {
        return this.manufacturer;
    }

    public final String component3() {
        return this.url;
    }

    public final int component4() {
        return this.award;
    }

    public final int component5() {
        return this.position;
    }

    public final String component6() {
        return this.explanation;
    }

    public final String component7() {
        return this.user_solution;
    }

    public final String component8() {
        return this.dev_solution;
    }

    public final DokiManufacturer copy(String name, String[] manufacturer, String url, int i3, int i4, String explanation, String user_solution, String str) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(manufacturer, "manufacturer");
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(explanation, "explanation");
        Intrinsics.checkParameterIsNotNull(user_solution, "user_solution");
        return new DokiManufacturer(name, manufacturer, url, i3, i4, explanation, user_solution, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof DokiManufacturer) {
            return Intrinsics.areEqual(((DokiManufacturer) obj).name, this.name);
        }
        return false;
    }

    public final int getAward() {
        return this.award;
    }

    public final String getDev_solution() {
        return this.dev_solution;
    }

    public final String getExplanation() {
        return this.explanation;
    }

    public final String[] getManufacturer() {
        return this.manufacturer;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUser_solution() {
        return this.user_solution;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = (String) ArraysKt.firstOrNull(this.manufacturer);
        return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.url.hashCode()) * 31) + Integer.valueOf(this.award).hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeStringArray(this.manufacturer);
        parcel.writeString(this.url);
        parcel.writeInt(this.award);
        parcel.writeInt(this.position);
        parcel.writeString(this.explanation);
        parcel.writeString(this.user_solution);
        parcel.writeString(this.dev_solution);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DokiManufacturer(Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        String string = parcel.readString();
        String str = string != null ? string : "";
        String[] strArrCreateStringArray = parcel.createStringArray();
        String[] strArr = strArrCreateStringArray == null ? new String[0] : strArrCreateStringArray;
        String string2 = parcel.readString();
        String str2 = string2 != null ? string2 : "";
        int i3 = parcel.readInt();
        int i4 = parcel.readInt();
        String string3 = parcel.readString();
        String str3 = string3 != null ? string3 : "";
        String string4 = parcel.readString();
        String str4 = string4 != null ? string4 : "";
        String string5 = parcel.readString();
        this(str, strArr, str2, i3, i4, str3, str4, string5 != null ? string5 : "");
    }

    public String toString() {
        return "DokiManufacturer(name=" + this.name + ", manufacturer=" + Arrays.toString(this.manufacturer) + ", url=" + this.url + ", award=" + this.award + muQRKXGtpOhe.bxLuwMK + this.position + ", explanation=" + this.explanation + ", user_solution=" + this.user_solution + ", dev_solution=" + this.dev_solution + ")";
    }
}
