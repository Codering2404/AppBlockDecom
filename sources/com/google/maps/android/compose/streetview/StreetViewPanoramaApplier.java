package com.google.maps.android.compose.streetview;

import androidx.compose.runtime.AbstractApplier;
import com.google.android.gms.maps.StreetViewPanorama;
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
public final class StreetViewPanoramaApplier extends AbstractApplier<MapNode> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreetViewPanorama f91371d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreetViewPanoramaApplier(StreetViewPanorama streetViewPanorama) {
        super(StreetViewPanoramaNodeRoot.f91376a);
        Intrinsics.checkNotNullParameter(streetViewPanorama, "streetViewPanorama");
        this.f91371d = streetViewPanorama;
    }

    public final StreetViewPanorama q() {
        return this.f91371d;
    }

    @Override // androidx.compose.runtime.Applier
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public void g(int i3, MapNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        instance.a();
    }

    @Override // androidx.compose.runtime.Applier
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void e(int i3, MapNode instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    @Override // androidx.compose.runtime.AbstractApplier
    protected void n() {
    }

    @Override // androidx.compose.runtime.Applier
    public void a(int i3, int i4) {
    }

    @Override // androidx.compose.runtime.Applier
    public void c(int i3, int i4, int i5) {
    }
}
