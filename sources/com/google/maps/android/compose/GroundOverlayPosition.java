package com.google.maps.android.compose;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class GroundOverlayPosition {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f90810e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f90811f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LatLngBounds f90812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LatLng f90813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Float f90814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Float f90815d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Float a() {
        return this.f90815d;
    }

    public final LatLngBounds b() {
        return this.f90812a;
    }

    public final LatLng c() {
        return this.f90813b;
    }

    public final Float d() {
        return this.f90814c;
    }
}
