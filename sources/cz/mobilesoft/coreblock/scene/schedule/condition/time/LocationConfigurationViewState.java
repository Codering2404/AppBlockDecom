package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.dto.GeoAddressDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class LocationConfigurationViewState implements ConditionConfiguration<ConditionDTO.LocationDTO> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f115689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LatLng f115690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f115691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Long f115692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f115693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f115694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f115695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f115696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f115697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f115698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f115699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f115700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f115701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f115702n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f115703o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f115704p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f115705q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f115706r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Boolean f115707s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ViewModelState f115708t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final CameraCenterMoveDTO f115709u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final LatLng f115710v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final LatLngBounds f115711w;

    public LocationConfigurationViewState(int i3, LatLng latLng, boolean z2, Long l3, Long l4, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool, ViewModelState viewModelState, CameraCenterMoveDTO cameraCenterMoveDTO, LatLng latLng2, LatLngBounds latLngBounds) {
        this.f115689a = i3;
        this.f115690b = latLng;
        this.f115691c = z2;
        this.f115692d = l3;
        this.f115693e = l4;
        this.f115694f = str;
        this.f115695g = str2;
        this.f115696h = str3;
        this.f115697i = str4;
        this.f115698j = str5;
        this.f115699k = str6;
        this.f115700l = str7;
        this.f115701m = str8;
        this.f115702n = str9;
        this.f115703o = str10;
        this.f115704p = str11;
        this.f115705q = str12;
        this.f115706r = str13;
        this.f115707s = bool;
        this.f115708t = viewModelState;
        this.f115709u = cameraCenterMoveDTO;
        this.f115710v = latLng2;
        this.f115711w = latLngBounds;
    }

    public static /* synthetic */ LocationConfigurationViewState d(LocationConfigurationViewState locationConfigurationViewState, int i3, LatLng latLng, boolean z2, Long l3, Long l4, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool, ViewModelState viewModelState, CameraCenterMoveDTO cameraCenterMoveDTO, LatLng latLng2, LatLngBounds latLngBounds, int i4, Object obj) {
        LatLngBounds latLngBounds2;
        LatLng latLng3;
        int i5 = (i4 & 1) != 0 ? locationConfigurationViewState.f115689a : i3;
        LatLng latLng4 = (i4 & 2) != 0 ? locationConfigurationViewState.f115690b : latLng;
        boolean z3 = (i4 & 4) != 0 ? locationConfigurationViewState.f115691c : z2;
        Long l5 = (i4 & 8) != 0 ? locationConfigurationViewState.f115692d : l3;
        Long l6 = (i4 & 16) != 0 ? locationConfigurationViewState.f115693e : l4;
        String str14 = (i4 & 32) != 0 ? locationConfigurationViewState.f115694f : str;
        String str15 = (i4 & 64) != 0 ? locationConfigurationViewState.f115695g : str2;
        String str16 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? locationConfigurationViewState.f115696h : str3;
        String str17 = (i4 & Function.MAX_NARGS) != 0 ? locationConfigurationViewState.f115697i : str4;
        String str18 = (i4 & 512) != 0 ? locationConfigurationViewState.f115698j : str5;
        String str19 = (i4 & 1024) != 0 ? locationConfigurationViewState.f115699k : str6;
        String str20 = (i4 & 2048) != 0 ? locationConfigurationViewState.f115700l : str7;
        String str21 = (i4 & 4096) != 0 ? locationConfigurationViewState.f115701m : str8;
        String str22 = (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? locationConfigurationViewState.f115702n : str9;
        int i6 = i5;
        String str23 = (i4 & 16384) != 0 ? locationConfigurationViewState.f115703o : str10;
        String str24 = (i4 & 32768) != 0 ? locationConfigurationViewState.f115704p : str11;
        String str25 = (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? locationConfigurationViewState.f115705q : str12;
        String str26 = (i4 & 131072) != 0 ? locationConfigurationViewState.f115706r : str13;
        Boolean bool2 = (i4 & 262144) != 0 ? locationConfigurationViewState.f115707s : bool;
        ViewModelState viewModelState2 = (i4 & 524288) != 0 ? locationConfigurationViewState.f115708t : viewModelState;
        CameraCenterMoveDTO cameraCenterMoveDTO2 = (i4 & 1048576) != 0 ? locationConfigurationViewState.f115709u : cameraCenterMoveDTO;
        LatLng latLng5 = (i4 & 2097152) != 0 ? locationConfigurationViewState.f115710v : latLng2;
        if ((i4 & 4194304) != 0) {
            latLng3 = latLng5;
            latLngBounds2 = locationConfigurationViewState.f115711w;
        } else {
            latLngBounds2 = latLngBounds;
            latLng3 = latLng5;
        }
        return locationConfigurationViewState.c(i6, latLng4, z3, l5, l6, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, bool2, viewModelState2, cameraCenterMoveDTO2, latLng3, latLngBounds2);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration
    public boolean a() {
        return this.f115690b != null && this.f115689a > 0;
    }

    public final LocationConfigurationViewState c(int i3, LatLng latLng, boolean z2, Long l3, Long l4, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool, ViewModelState viewModelState, CameraCenterMoveDTO cameraCenterMoveDTO, LatLng latLng2, LatLngBounds latLngBounds) {
        return new LocationConfigurationViewState(i3, latLng, z2, l3, l4, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, bool, viewModelState, cameraCenterMoveDTO, latLng2, latLngBounds);
    }

    public final CameraCenterMoveDTO e() {
        return this.f115709u;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationConfigurationViewState)) {
            return false;
        }
        LocationConfigurationViewState locationConfigurationViewState = (LocationConfigurationViewState) obj;
        return this.f115689a == locationConfigurationViewState.f115689a && Intrinsics.areEqual(this.f115690b, locationConfigurationViewState.f115690b) && this.f115691c == locationConfigurationViewState.f115691c && Intrinsics.areEqual(this.f115692d, locationConfigurationViewState.f115692d) && Intrinsics.areEqual(this.f115693e, locationConfigurationViewState.f115693e) && Intrinsics.areEqual(this.f115694f, locationConfigurationViewState.f115694f) && Intrinsics.areEqual(this.f115695g, locationConfigurationViewState.f115695g) && Intrinsics.areEqual(this.f115696h, locationConfigurationViewState.f115696h) && Intrinsics.areEqual(this.f115697i, locationConfigurationViewState.f115697i) && Intrinsics.areEqual(this.f115698j, locationConfigurationViewState.f115698j) && Intrinsics.areEqual(this.f115699k, locationConfigurationViewState.f115699k) && Intrinsics.areEqual(this.f115700l, locationConfigurationViewState.f115700l) && Intrinsics.areEqual(this.f115701m, locationConfigurationViewState.f115701m) && Intrinsics.areEqual(this.f115702n, locationConfigurationViewState.f115702n) && Intrinsics.areEqual(this.f115703o, locationConfigurationViewState.f115703o) && Intrinsics.areEqual(this.f115704p, locationConfigurationViewState.f115704p) && Intrinsics.areEqual(this.f115705q, locationConfigurationViewState.f115705q) && Intrinsics.areEqual(this.f115706r, locationConfigurationViewState.f115706r) && Intrinsics.areEqual(this.f115707s, locationConfigurationViewState.f115707s) && Intrinsics.areEqual(this.f115708t, locationConfigurationViewState.f115708t) && Intrinsics.areEqual(this.f115709u, locationConfigurationViewState.f115709u) && Intrinsics.areEqual(this.f115710v, locationConfigurationViewState.f115710v) && Intrinsics.areEqual(this.f115711w, locationConfigurationViewState.f115711w);
    }

    public final LatLngBounds f() {
        return this.f115711w;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ConditionDTO.LocationDTO b() {
        if (this.f115690b == null) {
            return null;
        }
        Long l3 = this.f115692d;
        Long l4 = this.f115693e;
        String str = this.f115694f;
        int i3 = this.f115689a;
        LatLng latLng = this.f115690b;
        return new ConditionDTO.LocationDTO(new GeoAddressDTO(l3, l4, str, i3, latLng.f73163a, latLng.f73164b, this.f115691c, this.f115695g, this.f115696h, this.f115697i, this.f115698j, this.f115699k, this.f115700l, this.f115701m, this.f115702n, this.f115703o, this.f115704p, this.f115705q, this.f115706r), null, 2, null);
    }

    public final String h() {
        String str = this.f115701m;
        if (str != null) {
            String str2 = this.f115702n;
            if (str2 != null) {
                str = str + " " + str2;
            }
        } else {
            str = null;
        }
        String str3 = this.f115699k;
        if (str3 == null) {
            str3 = this.f115698j;
        }
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{str, str3, this.f115697i, this.f115706r}), ", ", null, null, 0, null, null, 62, null);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f115689a) * 31;
        LatLng latLng = this.f115690b;
        int iHashCode2 = (((iHashCode + (latLng == null ? 0 : latLng.hashCode())) * 31) + Boolean.hashCode(this.f115691c)) * 31;
        Long l3 = this.f115692d;
        int iHashCode3 = (iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.f115693e;
        int iHashCode4 = (iHashCode3 + (l4 == null ? 0 : l4.hashCode())) * 31;
        String str = this.f115694f;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f115695g;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f115696h;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f115697i;
        int iHashCode8 = (iHashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f115698j;
        int iHashCode9 = (iHashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f115699k;
        int iHashCode10 = (iHashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f115700l;
        int iHashCode11 = (iHashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.f115701m;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f115702n;
        int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.f115703o;
        int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.f115704p;
        int iHashCode15 = (iHashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.f115705q;
        int iHashCode16 = (iHashCode15 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.f115706r;
        int iHashCode17 = (iHashCode16 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Boolean bool = this.f115707s;
        int iHashCode18 = (iHashCode17 + (bool == null ? 0 : bool.hashCode())) * 31;
        ViewModelState viewModelState = this.f115708t;
        int iHashCode19 = (iHashCode18 + (viewModelState == null ? 0 : viewModelState.hashCode())) * 31;
        CameraCenterMoveDTO cameraCenterMoveDTO = this.f115709u;
        int iHashCode20 = (iHashCode19 + (cameraCenterMoveDTO == null ? 0 : cameraCenterMoveDTO.hashCode())) * 31;
        LatLng latLng2 = this.f115710v;
        int iHashCode21 = (iHashCode20 + (latLng2 == null ? 0 : latLng2.hashCode())) * 31;
        LatLngBounds latLngBounds = this.f115711w;
        return iHashCode21 + (latLngBounds != null ? latLngBounds.hashCode() : 0);
    }

    public final ViewModelState i() {
        return this.f115708t;
    }

    public final int j() {
        return this.f115689a;
    }

    public final LatLng k() {
        return this.f115710v;
    }

    public final Boolean l() {
        return this.f115707s;
    }

    public final LatLng m() {
        return this.f115690b;
    }

    public final boolean n() {
        return this.f115691c;
    }

    public String toString() {
        return "LocationConfigurationViewState(geofenceRadius=" + this.f115689a + ", selectedLatLng=" + this.f115690b + ", isInverted=" + this.f115691c + ", geoAddressId=" + this.f115692d + ", geoAddressProfileId=" + this.f115693e + ", geofenceId=" + this.f115694f + ", locale=" + this.f115695g + ", featureName=" + this.f115696h + ", adminArea=" + this.f115697i + ", subAdminArea=" + this.f115698j + ", locality=" + this.f115699k + ", subLocality=" + this.f115700l + ", thoroughfare=" + this.f115701m + ", subThoroughfare=" + this.f115702n + ", premises=" + this.f115703o + ", postalCode=" + this.f115704p + ", countryCode=" + this.f115705q + ", countryName=" + this.f115706r + ", missingPermission=" + this.f115707s + ", geocodingState=" + this.f115708t + ", cameraCenterMoveDTO=" + this.f115709u + ", latLngCurrentPosition=" + this.f115710v + ", circleBounds=" + this.f115711w + ")";
    }

    public /* synthetic */ LocationConfigurationViewState(int i3, LatLng latLng, boolean z2, Long l3, Long l4, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Boolean bool, ViewModelState viewModelState, CameraCenterMoveDTO cameraCenterMoveDTO, LatLng latLng2, LatLngBounds latLngBounds, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 250 : i3, (i4 & 2) != 0 ? null : latLng, (i4 & 4) != 0 ? false : z2, (i4 & 8) != 0 ? null : l3, (i4 & 16) != 0 ? null : l4, (i4 & 32) != 0 ? null : str, (i4 & 64) != 0 ? null : str2, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : str3, (i4 & Function.MAX_NARGS) != 0 ? null : str4, (i4 & 512) != 0 ? null : str5, (i4 & 1024) != 0 ? null : str6, (i4 & 2048) != 0 ? null : str7, (i4 & 4096) != 0 ? null : str8, (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : str9, (i4 & 16384) != 0 ? null : str10, (i4 & 32768) != 0 ? null : str11, (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? null : str12, (i4 & 131072) != 0 ? null : str13, (i4 & 262144) != 0 ? null : bool, (i4 & 524288) != 0 ? null : viewModelState, (i4 & 1048576) != 0 ? null : cameraCenterMoveDTO, (i4 & 2097152) != 0 ? null : latLng2, (i4 & 4194304) != 0 ? null : latLngBounds);
    }

    public LocationConfigurationViewState(GeoAddressDTO geoAddressDTO) {
        this(geoAddressDTO != null ? geoAddressDTO.i() : 250, geoAddressDTO != null ? new LatLng(geoAddressDTO.b(), geoAddressDTO.f()) : null, geoAddressDTO != null ? geoAddressDTO.v() : false, geoAddressDTO != null ? geoAddressDTO.p() : null, geoAddressDTO != null ? geoAddressDTO.t() : null, geoAddressDTO != null ? geoAddressDTO.a() : null, geoAddressDTO != null ? geoAddressDTO.r() : null, geoAddressDTO != null ? geoAddressDTO.h() : null, geoAddressDTO != null ? geoAddressDTO.m() : null, geoAddressDTO != null ? geoAddressDTO.c() : null, geoAddressDTO != null ? geoAddressDTO.g() : null, geoAddressDTO != null ? geoAddressDTO.e() : null, geoAddressDTO != null ? geoAddressDTO.j() : null, geoAddressDTO != null ? geoAddressDTO.u() : null, geoAddressDTO != null ? geoAddressDTO.d() : null, geoAddressDTO != null ? geoAddressDTO.s() : null, geoAddressDTO != null ? geoAddressDTO.n() : null, geoAddressDTO != null ? geoAddressDTO.o() : null, null, geoAddressDTO != null ? Success.f128020a : null, geoAddressDTO != null ? new CameraCenterMoveDTO(geoAddressDTO.q(), 0L, 2, null) : null, null, null, 6553600, null);
    }
}
