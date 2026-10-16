package com.google.maps.android.compose;

import androidx.compose.runtime.CompositionContext;
import com.google.android.gms.maps.model.Marker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
public final class MarkerNode implements MapNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompositionContext f91133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Marker f91134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MarkerState f91135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function1 f91136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Function1 f91137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function1 f91138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Function1 f91139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Function3 f91140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Function3 f91141i;

    public MarkerNode(CompositionContext compositionContext, Marker marker, MarkerState markerState, Function1 onMarkerClick, Function1 onInfoWindowClick, Function1 onInfoWindowClose, Function1 onInfoWindowLongClick, Function3 function3, Function3 function32) {
        Intrinsics.checkNotNullParameter(compositionContext, "compositionContext");
        Intrinsics.checkNotNullParameter(marker, "marker");
        Intrinsics.checkNotNullParameter(markerState, "markerState");
        Intrinsics.checkNotNullParameter(onMarkerClick, "onMarkerClick");
        Intrinsics.checkNotNullParameter(onInfoWindowClick, "onInfoWindowClick");
        Intrinsics.checkNotNullParameter(onInfoWindowClose, "onInfoWindowClose");
        Intrinsics.checkNotNullParameter(onInfoWindowLongClick, "onInfoWindowLongClick");
        this.f91133a = compositionContext;
        this.f91134b = marker;
        this.f91135c = markerState;
        this.f91136d = onMarkerClick;
        this.f91137e = onInfoWindowClick;
        this.f91138f = onInfoWindowClose;
        this.f91139g = onInfoWindowLongClick;
        this.f91140h = function3;
        this.f91141i = function32;
    }

    @Override // com.google.maps.android.compose.MapNode
    public void a() {
        this.f91135c.d(this.f91134b);
    }

    @Override // com.google.maps.android.compose.MapNode
    public void b() {
        this.f91135c.d(null);
        this.f91134b.c();
    }

    @Override // com.google.maps.android.compose.MapNode
    public void c() {
        this.f91135c.d(null);
        this.f91134b.c();
    }

    public final CompositionContext d() {
        return this.f91133a;
    }

    public final Function3 e() {
        return this.f91141i;
    }

    public final Function3 f() {
        return this.f91140h;
    }

    public final Marker g() {
        return this.f91134b;
    }

    public final MarkerState h() {
        return this.f91135c;
    }

    public final Function1 i() {
        return this.f91137e;
    }

    public final Function1 j() {
        return this.f91138f;
    }

    public final Function1 k() {
        return this.f91139g;
    }

    public final Function1 l() {
        return this.f91136d;
    }

    public final void m(Function3 function3) {
        this.f91141i = function3;
    }

    public final void n(Function3 function3) {
        this.f91140h = function3;
    }

    public final void o(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f91137e = function1;
    }

    public final void p(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f91138f = function1;
    }

    public final void q(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f91139g = function1;
    }

    public final void r(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f91136d = function1;
    }
}
