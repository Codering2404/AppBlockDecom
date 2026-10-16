package com.google.maps.android.compose;

import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Objects;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class MapProperties {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f90920j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f90921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f90922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f90923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f90924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LatLngBounds f90925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MapStyleOptions f90926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MapType f90927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f90928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f90929i;

    public MapProperties(boolean z2, boolean z3, boolean z4, boolean z5, LatLngBounds latLngBounds, MapStyleOptions mapStyleOptions, MapType mapType, float f3, float f4) {
        Intrinsics.checkNotNullParameter(mapType, "mapType");
        this.f90921a = z2;
        this.f90922b = z3;
        this.f90923c = z4;
        this.f90924d = z5;
        this.f90925e = latLngBounds;
        this.f90926f = mapStyleOptions;
        this.f90927g = mapType;
        this.f90928h = f3;
        this.f90929i = f4;
    }

    public final LatLngBounds a() {
        return this.f90925e;
    }

    public final MapStyleOptions b() {
        return this.f90926f;
    }

    public final MapType c() {
        return this.f90927g;
    }

    public final float d() {
        return this.f90928h;
    }

    public final float e() {
        return this.f90929i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MapProperties)) {
            return false;
        }
        MapProperties mapProperties = (MapProperties) obj;
        return this.f90921a == mapProperties.f90921a && this.f90922b == mapProperties.f90922b && this.f90923c == mapProperties.f90923c && this.f90924d == mapProperties.f90924d && Intrinsics.areEqual(this.f90925e, mapProperties.f90925e) && Intrinsics.areEqual(this.f90926f, mapProperties.f90926f) && this.f90927g == mapProperties.f90927g && this.f90928h == mapProperties.f90928h && this.f90929i == mapProperties.f90929i;
    }

    public final boolean f() {
        return this.f90921a;
    }

    public final boolean g() {
        return this.f90922b;
    }

    public final boolean h() {
        return this.f90923c;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f90921a), Boolean.valueOf(this.f90922b), Boolean.valueOf(this.f90923c), Boolean.valueOf(this.f90924d), this.f90925e, this.f90926f, this.f90927g, Float.valueOf(this.f90928h), Float.valueOf(this.f90929i));
    }

    public final boolean i() {
        return this.f90924d;
    }

    public String toString() {
        return "MapProperties(isBuildingEnabled=" + this.f90921a + ", isIndoorEnabled=" + this.f90922b + ", isMyLocationEnabled=" + this.f90923c + ", isTrafficEnabled=" + this.f90924d + ", latLngBoundsForCameraTarget=" + this.f90925e + ", mapStyleOptions=" + this.f90926f + ", mapType=" + this.f90927g + ", maxZoomPreference=" + this.f90928h + ", minZoomPreference=" + this.f90929i + ')';
    }

    public /* synthetic */ MapProperties(boolean z2, boolean z3, boolean z4, boolean z5, LatLngBounds latLngBounds, MapStyleOptions mapStyleOptions, MapType mapType, float f3, float f4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? false : z4, (i3 & 8) != 0 ? false : z5, (i3 & 16) != 0 ? null : latLngBounds, (i3 & 32) != 0 ? null : mapStyleOptions, (i3 & 64) != 0 ? MapType.NORMAL : mapType, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 21.0f : f3, (i3 & Function.MAX_NARGS) != 0 ? 3.0f : f4);
    }
}
