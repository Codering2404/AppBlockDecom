package com.google.maps.android.compose;

import com.google.android.gms.maps.model.TileOverlay;
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
final class TileOverlayNode implements MapNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TileOverlay f91295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TileOverlayState f91296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function1 f91297c;

    public TileOverlayNode(TileOverlay tileOverlay, TileOverlayState tileOverlayState, Function1 onTileOverlayClick) {
        Intrinsics.checkNotNullParameter(tileOverlay, "tileOverlay");
        Intrinsics.checkNotNullParameter(tileOverlayState, "tileOverlayState");
        Intrinsics.checkNotNullParameter(onTileOverlayClick, "onTileOverlayClick");
        this.f91295a = tileOverlay;
        this.f91296b = tileOverlayState;
        this.f91297c = onTileOverlayClick;
    }

    @Override // com.google.maps.android.compose.MapNode
    public void a() {
        this.f91296b.a(this.f91295a);
    }

    @Override // com.google.maps.android.compose.MapNode
    public void b() {
        MapNode.DefaultImpls.b(this);
    }

    @Override // com.google.maps.android.compose.MapNode
    public void c() {
        this.f91295a.a();
    }

    public final TileOverlay d() {
        return this.f91295a;
    }

    public final void e(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f91297c = function1;
    }

    public final void f(TileOverlay tileOverlay) {
        Intrinsics.checkNotNullParameter(tileOverlay, "<set-?>");
        this.f91295a = tileOverlay;
    }
}
