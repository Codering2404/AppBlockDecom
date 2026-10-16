package cz.mobilesoft.coreblock.dto;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress;
import java.io.Serializable;
import java.util.UUID;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class GeoAddressDTO implements Serializable, AddressHolder, GeofenceHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Long f96927a;

    @SerializedName("adminArea")
    private final String adminArea;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Long f96928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f96929c;

    @SerializedName("countryCode")
    private final String countryCode;

    @SerializedName("countryName")
    private final String countryName;

    @SerializedName("featureName")
    private final String featureName;

    @SerializedName("geofenceRadius")
    private final int geofenceRadius;

    @SerializedName("inverted")
    private final boolean isInverted;

    @SerializedName("latitude")
    private final double latitude;

    @SerializedName("locale")
    private final String locale;

    @SerializedName("locality")
    private final String locality;

    @SerializedName("longitude")
    private final double longitude;

    @SerializedName("postalCode")
    private final String postalCode;

    @SerializedName("premises")
    private final String premises;

    @SerializedName("subAdminArea")
    private final String subAdminArea;

    @SerializedName("subLocality")
    private final String subLocality;

    @SerializedName("subThoroughfare")
    private final String subThoroughfare;

    @SerializedName("thoroughfare")
    private final String thoroughfare;

    public GeoAddressDTO(Long l3, Long l4, String str, int i3, double d3, double d4, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        this.f96927a = l3;
        this.f96928b = l4;
        this.f96929c = str;
        this.geofenceRadius = i3;
        this.latitude = d3;
        this.longitude = d4;
        this.isInverted = z2;
        this.locale = str2;
        this.featureName = str3;
        this.adminArea = str4;
        this.subAdminArea = str5;
        this.locality = str6;
        this.subLocality = str7;
        this.thoroughfare = str8;
        this.subThoroughfare = str9;
        this.premises = str10;
        this.postalCode = str11;
        this.countryCode = str12;
        this.countryName = str13;
    }

    public static /* synthetic */ GeoAddressDTO l(GeoAddressDTO geoAddressDTO, Long l3, Long l4, String str, int i3, double d3, double d4, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i4, Object obj) {
        String str14;
        String str15;
        Long l5 = (i4 & 1) != 0 ? geoAddressDTO.f96927a : l3;
        Long l6 = (i4 & 2) != 0 ? geoAddressDTO.f96928b : l4;
        String str16 = (i4 & 4) != 0 ? geoAddressDTO.f96929c : str;
        int i5 = (i4 & 8) != 0 ? geoAddressDTO.geofenceRadius : i3;
        double d5 = (i4 & 16) != 0 ? geoAddressDTO.latitude : d3;
        double d6 = (i4 & 32) != 0 ? geoAddressDTO.longitude : d4;
        boolean z3 = (i4 & 64) != 0 ? geoAddressDTO.isInverted : z2;
        String str17 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? geoAddressDTO.locale : str2;
        String str18 = (i4 & Function.MAX_NARGS) != 0 ? geoAddressDTO.featureName : str3;
        String str19 = (i4 & 512) != 0 ? geoAddressDTO.adminArea : str4;
        String str20 = (i4 & 1024) != 0 ? geoAddressDTO.subAdminArea : str5;
        String str21 = (i4 & 2048) != 0 ? geoAddressDTO.locality : str6;
        Long l7 = l5;
        String str22 = (i4 & 4096) != 0 ? geoAddressDTO.subLocality : str7;
        String str23 = (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? geoAddressDTO.thoroughfare : str8;
        String str24 = (i4 & 16384) != 0 ? geoAddressDTO.subThoroughfare : str9;
        String str25 = (i4 & 32768) != 0 ? geoAddressDTO.premises : str10;
        String str26 = (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? geoAddressDTO.postalCode : str11;
        String str27 = (i4 & 131072) != 0 ? geoAddressDTO.countryCode : str12;
        if ((i4 & 262144) != 0) {
            str15 = str27;
            str14 = geoAddressDTO.countryName;
        } else {
            str14 = str13;
            str15 = str27;
        }
        return geoAddressDTO.k(l7, l6, str16, i5, d5, d6, z3, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str15, str14);
    }

    @Override // cz.mobilesoft.coreblock.dto.GeofenceHolder
    public String a() {
        return this.f96929c;
    }

    @Override // cz.mobilesoft.coreblock.dto.GeofenceHolder
    public double b() {
        return this.latitude;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String c() {
        return this.subAdminArea;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String d() {
        return this.premises;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String e() {
        return this.subLocality;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeoAddressDTO)) {
            return false;
        }
        GeoAddressDTO geoAddressDTO = (GeoAddressDTO) obj;
        return Intrinsics.areEqual(this.f96927a, geoAddressDTO.f96927a) && Intrinsics.areEqual(this.f96928b, geoAddressDTO.f96928b) && Intrinsics.areEqual(this.f96929c, geoAddressDTO.f96929c) && this.geofenceRadius == geoAddressDTO.geofenceRadius && Double.compare(this.latitude, geoAddressDTO.latitude) == 0 && Double.compare(this.longitude, geoAddressDTO.longitude) == 0 && this.isInverted == geoAddressDTO.isInverted && Intrinsics.areEqual(this.locale, geoAddressDTO.locale) && Intrinsics.areEqual(this.featureName, geoAddressDTO.featureName) && Intrinsics.areEqual(this.adminArea, geoAddressDTO.adminArea) && Intrinsics.areEqual(this.subAdminArea, geoAddressDTO.subAdminArea) && Intrinsics.areEqual(this.locality, geoAddressDTO.locality) && Intrinsics.areEqual(this.subLocality, geoAddressDTO.subLocality) && Intrinsics.areEqual(this.thoroughfare, geoAddressDTO.thoroughfare) && Intrinsics.areEqual(this.subThoroughfare, geoAddressDTO.subThoroughfare) && Intrinsics.areEqual(this.premises, geoAddressDTO.premises) && Intrinsics.areEqual(this.postalCode, geoAddressDTO.postalCode) && Intrinsics.areEqual(this.countryCode, geoAddressDTO.countryCode) && Intrinsics.areEqual(this.countryName, geoAddressDTO.countryName);
    }

    @Override // cz.mobilesoft.coreblock.dto.GeofenceHolder
    public double f() {
        return this.longitude;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String g() {
        return this.locality;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String h() {
        return this.featureName;
    }

    public int hashCode() {
        Long l3 = this.f96927a;
        int iHashCode = (l3 == null ? 0 : l3.hashCode()) * 31;
        Long l4 = this.f96928b;
        int iHashCode2 = (iHashCode + (l4 == null ? 0 : l4.hashCode())) * 31;
        String str = this.f96929c;
        int iHashCode3 = (((((((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.geofenceRadius)) * 31) + Double.hashCode(this.latitude)) * 31) + Double.hashCode(this.longitude)) * 31) + Boolean.hashCode(this.isInverted)) * 31;
        String str2 = this.locale;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.featureName;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.adminArea;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.subAdminArea;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.locality;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.subLocality;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.thoroughfare;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.subThoroughfare;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.premises;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.postalCode;
        int iHashCode13 = (iHashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.countryCode;
        int iHashCode14 = (iHashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.countryName;
        return iHashCode14 + (str13 != null ? str13.hashCode() : 0);
    }

    @Override // cz.mobilesoft.coreblock.dto.GeofenceHolder
    public int i() {
        return this.geofenceRadius;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String j() {
        return this.thoroughfare;
    }

    public final GeoAddressDTO k(Long l3, Long l4, String str, int i3, double d3, double d4, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        return new GeoAddressDTO(l3, l4, str, i3, d3, d4, z2, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    public final String m() {
        return this.adminArea;
    }

    public final String n() {
        return this.countryCode;
    }

    public final String o() {
        return this.countryName;
    }

    public final Long p() {
        return this.f96927a;
    }

    public final LatLng q() {
        return new LatLng(b(), f());
    }

    public final String r() {
        return this.locale;
    }

    public final String s() {
        return this.postalCode;
    }

    public final Long t() {
        return this.f96928b;
    }

    public String toString() {
        return "GeoAddressDTO(id=" + this.f96927a + ", profileId=" + this.f96928b + ", geofenceId=" + this.f96929c + ", geofenceRadius=" + this.geofenceRadius + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", isInverted=" + this.isInverted + ", locale=" + this.locale + ", featureName=" + this.featureName + ", adminArea=" + this.adminArea + ", subAdminArea=" + this.subAdminArea + ", locality=" + this.locality + ", subLocality=" + this.subLocality + ", thoroughfare=" + this.thoroughfare + ", subThoroughfare=" + this.subThoroughfare + ", premises=" + this.premises + ", postalCode=" + this.postalCode + ", countryCode=" + this.countryCode + ", countryName=" + this.countryName + ")";
    }

    public final String u() {
        return this.subThoroughfare;
    }

    public boolean v() {
        return this.isInverted;
    }

    public void w(String str) {
        this.f96929c = str;
    }

    public final GeoAddress x(Long l3, String str) {
        String strA;
        Long l4 = this.f96927a;
        long jLongValue = 0;
        long jLongValue2 = l4 != null ? l4.longValue() : 0L;
        if (l3 != null) {
            jLongValue = l3.longValue();
        } else {
            Long l5 = this.f96928b;
            if (l5 != null) {
                jLongValue = l5.longValue();
            }
        }
        if (str == null) {
            strA = a();
            if (strA == null) {
                strA = "";
            }
        } else {
            strA = str;
        }
        return new GeoAddress(jLongValue2, jLongValue, strA, i(), b(), f(), v(), this.locale, h(), this.adminArea, c(), g(), e(), j(), this.subThoroughfare, d(), this.postalCode, this.countryCode, this.countryName);
    }

    public /* synthetic */ GeoAddressDTO(Long l3, Long l4, String str, int i3, double d3, double d4, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : l3, (i4 & 2) != 0 ? null : l4, (i4 & 4) != 0 ? null : str, i3, d3, d4, z2, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GeoAddressDTO(GeoAddress geoAddress, boolean z2) {
        this(null, null, null, geoAddress.i(), geoAddress.b(), geoAddress.f(), geoAddress.t(), geoAddress.o(), geoAddress.h(), geoAddress.k(), geoAddress.c(), geoAddress.g(), geoAddress.e(), geoAddress.j(), geoAddress.s(), geoAddress.d(), geoAddress.q(), geoAddress.l(), geoAddress.m(), 7, null);
        Intrinsics.checkNotNullParameter(geoAddress, "geoAddress");
        if (z2) {
            this.f96927a = Long.valueOf(geoAddress.n());
            this.f96928b = Long.valueOf(geoAddress.r());
            w(geoAddress.a());
            return;
        }
        w(UUID.randomUUID().toString());
    }
}
