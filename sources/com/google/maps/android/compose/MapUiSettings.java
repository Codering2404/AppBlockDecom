package com.google.maps.android.compose;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class MapUiSettings {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f90945k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f90946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f90947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f90948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f90949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f90950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f90951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f90952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f90953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f90954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f90955j;

    public MapUiSettings(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        this.f90946a = z2;
        this.f90947b = z3;
        this.f90948c = z4;
        this.f90949d = z5;
        this.f90950e = z6;
        this.f90951f = z7;
        this.f90952g = z8;
        this.f90953h = z9;
        this.f90954i = z10;
        this.f90955j = z11;
    }

    public final boolean a() {
        return this.f90946a;
    }

    public final boolean b() {
        return this.f90947b;
    }

    public final boolean c() {
        return this.f90948c;
    }

    public final boolean d() {
        return this.f90949d;
    }

    public final boolean e() {
        return this.f90950e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MapUiSettings)) {
            return false;
        }
        MapUiSettings mapUiSettings = (MapUiSettings) obj;
        return this.f90946a == mapUiSettings.f90946a && this.f90947b == mapUiSettings.f90947b && this.f90948c == mapUiSettings.f90948c && this.f90949d == mapUiSettings.f90949d && this.f90950e == mapUiSettings.f90950e && this.f90951f == mapUiSettings.f90951f && this.f90952g == mapUiSettings.f90952g && this.f90953h == mapUiSettings.f90953h && this.f90954i == mapUiSettings.f90954i && this.f90955j == mapUiSettings.f90955j;
    }

    public final boolean f() {
        return this.f90951f;
    }

    public final boolean g() {
        return this.f90952g;
    }

    public final boolean h() {
        return this.f90953h;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f90946a), Boolean.valueOf(this.f90947b), Boolean.valueOf(this.f90948c), Boolean.valueOf(this.f90949d), Boolean.valueOf(this.f90950e), Boolean.valueOf(this.f90951f), Boolean.valueOf(this.f90952g), Boolean.valueOf(this.f90953h), Boolean.valueOf(this.f90954i), Boolean.valueOf(this.f90955j));
    }

    public final boolean i() {
        return this.f90954i;
    }

    public final boolean j() {
        return this.f90955j;
    }

    public String toString() {
        return "MapUiSettings(compassEnabled=" + this.f90946a + ", indoorLevelPickerEnabled=" + this.f90947b + ", mapToolbarEnabled=" + this.f90948c + YvFRmou.ggCoCItcNKvecq + this.f90949d + ", rotationGesturesEnabled=" + this.f90950e + ", scrollGesturesEnabled=" + this.f90951f + ", scrollGesturesEnabledDuringRotateOrZoom=" + this.f90952g + ", tiltGesturesEnabled=" + this.f90953h + ", zoomControlsEnabled=" + this.f90954i + ", zoomGesturesEnabled=" + this.f90955j + ')';
    }

    public /* synthetic */ MapUiSettings(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? true : z3, (i3 & 4) != 0 ? true : z4, (i3 & 8) != 0 ? true : z5, (i3 & 16) != 0 ? true : z6, (i3 & 32) != 0 ? true : z7, (i3 & 64) != 0 ? true : z8, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? true : z9, (i3 & Function.MAX_NARGS) != 0 ? true : z10, (i3 & 512) != 0 ? true : z11);
    }
}
