package com.google.maps.android.compose;

import android.location.Location;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PointOfInterest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class MapClickListeners {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f90872a = SnapshotStateKt__SnapshotStateKt.e(DefaultIndoorStateChangeListener.f90676a, null, 2, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f90873b = SnapshotStateKt__SnapshotStateKt.e(new Function1<LatLng, Unit>() { // from class: com.google.maps.android.compose.MapClickListeners$onMapClick$2
        public final void c(LatLng it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((LatLng) obj);
            return Unit.f139807a;
        }
    }, null, 2, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f90874c = SnapshotStateKt__SnapshotStateKt.e(new Function1<LatLng, Unit>() { // from class: com.google.maps.android.compose.MapClickListeners$onMapLongClick$2
        public final void c(LatLng it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((LatLng) obj);
            return Unit.f139807a;
        }
    }, null, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f90875d = SnapshotStateKt__SnapshotStateKt.e(new Function0<Unit>() { // from class: com.google.maps.android.compose.MapClickListeners$onMapLoaded$2
        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m379invoke() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m379invoke();
            return Unit.f139807a;
        }
    }, null, 2, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f90876e = SnapshotStateKt__SnapshotStateKt.e(new Function0<Boolean>() { // from class: com.google.maps.android.compose.MapClickListeners$onMyLocationButtonClick$2
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }, null, 2, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f90877f = SnapshotStateKt__SnapshotStateKt.e(new Function1<Location, Unit>() { // from class: com.google.maps.android.compose.MapClickListeners$onMyLocationClick$2
        public final void c(Location it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((Location) obj);
            return Unit.f139807a;
        }
    }, null, 2, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f90878g = SnapshotStateKt__SnapshotStateKt.e(new Function1<PointOfInterest, Unit>() { // from class: com.google.maps.android.compose.MapClickListeners$onPOIClick$2
        public final void c(PointOfInterest it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((PointOfInterest) obj);
            return Unit.f139807a;
        }
    }, null, 2, null);

    public final IndoorStateChangeListener a() {
        return (IndoorStateChangeListener) this.f90872a.getValue();
    }

    public final Function1 b() {
        return (Function1) this.f90873b.getValue();
    }

    public final Function0 c() {
        return (Function0) this.f90875d.getValue();
    }

    public final Function1 d() {
        return (Function1) this.f90874c.getValue();
    }

    public final Function0 e() {
        return (Function0) this.f90876e.getValue();
    }

    public final Function1 f() {
        return (Function1) this.f90877f.getValue();
    }

    public final Function1 g() {
        return (Function1) this.f90878g.getValue();
    }

    public final void h(IndoorStateChangeListener indoorStateChangeListener) {
        Intrinsics.checkNotNullParameter(indoorStateChangeListener, "<set-?>");
        this.f90872a.setValue(indoorStateChangeListener);
    }

    public final void i(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f90873b.setValue(function1);
    }

    public final void j(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.f90875d.setValue(function0);
    }

    public final void k(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f90874c.setValue(function1);
    }

    public final void l(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.f90876e.setValue(function0);
    }

    public final void m(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f90877f.setValue(function1);
    }

    public final void n(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f90878g.setValue(function1);
    }
}
