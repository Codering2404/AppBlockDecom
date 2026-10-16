package com.google.maps.android.compose.streetview;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.maps.android.compose.MapNode;
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
public final class StreetViewPanoramaPropertiesNode implements MapNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreetViewCameraPositionState f91377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreetViewPanorama f91378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private StreetViewPanoramaEventListeners f91379c;

    public StreetViewPanoramaPropertiesNode(StreetViewCameraPositionState cameraPositionState, StreetViewPanorama panorama, StreetViewPanoramaEventListeners eventListeners) {
        Intrinsics.checkNotNullParameter(cameraPositionState, "cameraPositionState");
        Intrinsics.checkNotNullParameter(panorama, "panorama");
        Intrinsics.checkNotNullParameter(eventListeners, "eventListeners");
        this.f91377a = cameraPositionState;
        this.f91378b = panorama;
        this.f91379c = eventListeners;
        cameraPositionState.a(panorama);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(StreetViewPanoramaPropertiesNode this$0, StreetViewPanoramaOrientation it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f91379c.a().invoke(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(StreetViewPanoramaPropertiesNode this$0, StreetViewPanoramaOrientation it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f91379c.b().invoke(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(StreetViewPanoramaPropertiesNode this$0, StreetViewPanoramaCamera it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f91377a.c(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(StreetViewPanoramaPropertiesNode this$0, StreetViewPanoramaLocation it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f91377a.b(it);
    }

    @Override // com.google.maps.android.compose.MapNode
    public void a() {
        MapNode.DefaultImpls.a(this);
        this.f91378b.d(new StreetViewPanorama.OnStreetViewPanoramaClickListener() { // from class: com.google.maps.android.compose.streetview.b
            @Override // com.google.android.gms.maps.StreetViewPanorama.OnStreetViewPanoramaClickListener
            public final void a(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
                StreetViewPanoramaPropertiesNode.i(this.f91391a, streetViewPanoramaOrientation);
            }
        });
        this.f91378b.e(new StreetViewPanorama.OnStreetViewPanoramaLongClickListener() { // from class: com.google.maps.android.compose.streetview.c
            @Override // com.google.android.gms.maps.StreetViewPanorama.OnStreetViewPanoramaLongClickListener
            public final void a(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
                StreetViewPanoramaPropertiesNode.j(this.f91392a, streetViewPanoramaOrientation);
            }
        });
        this.f91378b.b(new StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener() { // from class: com.google.maps.android.compose.streetview.d
            @Override // com.google.android.gms.maps.StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener
            public final void a(StreetViewPanoramaCamera streetViewPanoramaCamera) {
                StreetViewPanoramaPropertiesNode.k(this.f91393a, streetViewPanoramaCamera);
            }
        });
        this.f91378b.c(new StreetViewPanorama.OnStreetViewPanoramaChangeListener() { // from class: com.google.maps.android.compose.streetview.e
            @Override // com.google.android.gms.maps.StreetViewPanorama.OnStreetViewPanoramaChangeListener
            public final void a(StreetViewPanoramaLocation streetViewPanoramaLocation) {
                StreetViewPanoramaPropertiesNode.l(this.f91394a, streetViewPanoramaLocation);
            }
        });
    }

    @Override // com.google.maps.android.compose.MapNode
    public void b() {
        this.f91377a.a(null);
    }

    @Override // com.google.maps.android.compose.MapNode
    public void c() {
        this.f91377a.a(null);
    }

    public final StreetViewPanorama h() {
        return this.f91378b;
    }

    public final void m(StreetViewPanoramaEventListeners streetViewPanoramaEventListeners) {
        Intrinsics.checkNotNullParameter(streetViewPanoramaEventListeners, "<set-?>");
        this.f91379c = streetViewPanoramaEventListeners;
    }
}
