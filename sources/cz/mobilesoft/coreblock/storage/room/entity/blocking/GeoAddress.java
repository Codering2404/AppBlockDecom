package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import com.google.android.gms.maps.model.LatLng;
import cz.mobilesoft.coreblock.dto.AddressHolder;
import cz.mobilesoft.coreblock.dto.GeofenceHolder;
import java.io.Serializable;
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
public final class GeoAddress implements AddressHolder, GeofenceHolder, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f126407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f126409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f126410d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final double f126411f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final double f126412g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f126413h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f126414i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f126415j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f126416k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f126417l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f126418m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f126419n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f126420o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f126421p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f126422q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f126423r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f126424s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f126425t;

    public GeoAddress(long j3, long j4, String geofenceId, int i3, double d3, double d4, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        Intrinsics.checkNotNullParameter(geofenceId, "geofenceId");
        this.f126407a = j3;
        this.f126408b = j4;
        this.f126409c = geofenceId;
        this.f126410d = i3;
        this.f126411f = d3;
        this.f126412g = d4;
        this.f126413h = z2;
        this.f126414i = str;
        this.f126415j = str2;
        this.f126416k = str3;
        this.f126417l = str4;
        this.f126418m = str5;
        this.f126419n = str6;
        this.f126420o = str7;
        this.f126421p = str8;
        this.f126422q = str9;
        this.f126423r = str10;
        this.f126424s = str11;
        this.f126425t = str12;
    }

    @Override // cz.mobilesoft.coreblock.dto.GeofenceHolder
    public String a() {
        return this.f126409c;
    }

    @Override // cz.mobilesoft.coreblock.dto.GeofenceHolder
    public double b() {
        return this.f126411f;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String c() {
        return this.f126417l;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String d() {
        return this.f126422q;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String e() {
        return this.f126419n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeoAddress)) {
            return false;
        }
        GeoAddress geoAddress = (GeoAddress) obj;
        return this.f126407a == geoAddress.f126407a && this.f126408b == geoAddress.f126408b && Intrinsics.areEqual(this.f126409c, geoAddress.f126409c) && this.f126410d == geoAddress.f126410d && Double.compare(this.f126411f, geoAddress.f126411f) == 0 && Double.compare(this.f126412g, geoAddress.f126412g) == 0 && this.f126413h == geoAddress.f126413h && Intrinsics.areEqual(this.f126414i, geoAddress.f126414i) && Intrinsics.areEqual(this.f126415j, geoAddress.f126415j) && Intrinsics.areEqual(this.f126416k, geoAddress.f126416k) && Intrinsics.areEqual(this.f126417l, geoAddress.f126417l) && Intrinsics.areEqual(this.f126418m, geoAddress.f126418m) && Intrinsics.areEqual(this.f126419n, geoAddress.f126419n) && Intrinsics.areEqual(this.f126420o, geoAddress.f126420o) && Intrinsics.areEqual(this.f126421p, geoAddress.f126421p) && Intrinsics.areEqual(this.f126422q, geoAddress.f126422q) && Intrinsics.areEqual(this.f126423r, geoAddress.f126423r) && Intrinsics.areEqual(this.f126424s, geoAddress.f126424s) && Intrinsics.areEqual(this.f126425t, geoAddress.f126425t);
    }

    @Override // cz.mobilesoft.coreblock.dto.GeofenceHolder
    public double f() {
        return this.f126412g;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String g() {
        return this.f126418m;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String h() {
        return this.f126415j;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((Long.hashCode(this.f126407a) * 31) + Long.hashCode(this.f126408b)) * 31) + this.f126409c.hashCode()) * 31) + Integer.hashCode(this.f126410d)) * 31) + Double.hashCode(this.f126411f)) * 31) + Double.hashCode(this.f126412g)) * 31) + Boolean.hashCode(this.f126413h)) * 31;
        String str = this.f126414i;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f126415j;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f126416k;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f126417l;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f126418m;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f126419n;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f126420o;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f126421p;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f126422q;
        int iHashCode10 = (iHashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.f126423r;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.f126424s;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.f126425t;
        return iHashCode12 + (str12 != null ? str12.hashCode() : 0);
    }

    @Override // cz.mobilesoft.coreblock.dto.GeofenceHolder
    public int i() {
        return this.f126410d;
    }

    @Override // cz.mobilesoft.coreblock.dto.AddressHolder
    public String j() {
        return this.f126420o;
    }

    public final String k() {
        return this.f126416k;
    }

    public final String l() {
        return this.f126424s;
    }

    public final String m() {
        return this.f126425t;
    }

    public final long n() {
        return this.f126407a;
    }

    public final String o() {
        return this.f126414i;
    }

    public final LatLng p() {
        return new LatLng(b(), f());
    }

    public final String q() {
        return this.f126423r;
    }

    public final long r() {
        return this.f126408b;
    }

    public final String s() {
        return this.f126421p;
    }

    public boolean t() {
        return this.f126413h;
    }

    public String toString() {
        return "GeoAddress(id=" + this.f126407a + ", profileId=" + this.f126408b + ", geofenceId=" + this.f126409c + ", geofenceRadius=" + this.f126410d + ", latitude=" + this.f126411f + ", longitude=" + this.f126412g + ", isInverted=" + this.f126413h + ", locale=" + this.f126414i + ", featureName=" + this.f126415j + ", adminArea=" + this.f126416k + ", subAdminArea=" + this.f126417l + ", locality=" + this.f126418m + ", subLocality=" + this.f126419n + ", thoroughfare=" + this.f126420o + ", subThoroughfare=" + this.f126421p + ", premises=" + this.f126422q + ", postalCode=" + this.f126423r + ", countryCode=" + this.f126424s + ", countryName=" + this.f126425t + ")";
    }
}
