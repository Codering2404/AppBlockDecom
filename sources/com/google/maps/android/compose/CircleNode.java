package com.google.maps.android.compose;

import com.google.android.gms.maps.model.Circle;
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
public final class CircleNode implements MapNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Circle f90668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function1 f90669b;

    public CircleNode(Circle circle, Function1 onCircleClick) {
        Intrinsics.checkNotNullParameter(circle, "circle");
        Intrinsics.checkNotNullParameter(onCircleClick, "onCircleClick");
        this.f90668a = circle;
        this.f90669b = onCircleClick;
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
        this.f90668a.a();
    }

    public final Circle d() {
        return this.f90668a;
    }

    public final Function1 e() {
        return this.f90669b;
    }

    public final void f(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f90669b = function1;
    }
}
