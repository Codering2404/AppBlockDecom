package com.google.maps.android.compose.streetview;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLink;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class StreetViewCameraPositionState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f91318a = SnapshotStateKt__SnapshotStateKt.e(new StreetViewPanoramaLocation(new StreetViewPanoramaLink[0], new LatLng(0.0d, 0.0d), ""), null, 2, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f91319b = SnapshotStateKt__SnapshotStateKt.e(new StreetViewPanoramaCamera(0.0f, 0.0f, 0.0f), null, 2, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StreetViewPanorama f91320c;

    public final void a(StreetViewPanorama streetViewPanorama) {
        StreetViewPanorama streetViewPanorama2 = this.f91320c;
        if (streetViewPanorama2 == null && streetViewPanorama == null) {
            return;
        }
        if (streetViewPanorama2 != null && streetViewPanorama != null) {
            throw new IllegalStateException("StreetViewCameraPositionState may only be associated with one StreetView at a time.");
        }
        this.f91320c = streetViewPanorama;
    }

    public final void b(StreetViewPanoramaLocation streetViewPanoramaLocation) {
        Intrinsics.checkNotNullParameter(streetViewPanoramaLocation, "<set-?>");
        this.f91318a.setValue(streetViewPanoramaLocation);
    }

    public final void c(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        Intrinsics.checkNotNullParameter(streetViewPanoramaCamera, "<set-?>");
        this.f91319b.setValue(streetViewPanoramaCamera);
    }
}
