package com.google.maps.android.compose;

import com.google.android.gms.maps.model.GroundOverlay;
import com.google.maps.android.compose.MapNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class GroundOverlayNode implements MapNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GroundOverlay f90808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function1 f90809b;

    public GroundOverlayNode(GroundOverlay groundOverlay, Function1 onGroundOverlayClick) {
        Intrinsics.checkNotNullParameter(groundOverlay, "groundOverlay");
        Intrinsics.checkNotNullParameter(onGroundOverlayClick, "onGroundOverlayClick");
        this.f90808a = groundOverlay;
        this.f90809b = onGroundOverlayClick;
    }

    @Override // com.google.maps.android.compose.MapNode
    public void a() {
        MapNode.DefaultImpls.a(this);
    }

    @Override // com.google.maps.android.compose.MapNode
    public void b() {
        MapNode.DefaultImpls.b(this);
    }

    @Override // com.google.maps.android.compose.MapNode
    public void c() {
        this.f90808a.a();
    }

    public final GroundOverlay d() {
        return this.f90808a;
    }

    public final Function1 e() {
        return this.f90809b;
    }

    public final void f(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f90809b = function1;
    }
}
