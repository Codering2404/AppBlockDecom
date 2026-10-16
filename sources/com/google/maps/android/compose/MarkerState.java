package com.google.maps.android.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class MarkerState {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f91142d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Saver f91143e = SaverKt.a(new Function2<SaverScope, MarkerState, LatLng>() { // from class: com.google.maps.android.compose.MarkerState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final LatLng invoke(SaverScope Saver, MarkerState it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return it.b();
        }
    }, new Function1<LatLng, MarkerState>() { // from class: com.google.maps.android.compose.MarkerState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final MarkerState invoke(LatLng it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new MarkerState(it);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f91144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f91145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f91146c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return MarkerState.f91143e;
        }

        private Companion() {
        }
    }

    public MarkerState(LatLng position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.f91144a = SnapshotStateKt__SnapshotStateKt.e(position, null, 2, null);
        this.f91145b = SnapshotStateKt__SnapshotStateKt.e(DragState.END, null, 2, null);
        this.f91146c = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
    }

    public final LatLng b() {
        return (LatLng) this.f91144a.getValue();
    }

    public final void c(DragState dragState) {
        Intrinsics.checkNotNullParameter(dragState, "<set-?>");
        this.f91145b.setValue(dragState);
    }

    public final void d(Marker marker) {
        if (this.f91146c.getValue() == null && marker == null) {
            return;
        }
        if (this.f91146c.getValue() != null && marker != null) {
            throw new IllegalStateException("MarkerState may only be associated with one Marker at a time.");
        }
        this.f91146c.setValue(marker);
    }

    public final void e(LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "<set-?>");
        this.f91144a.setValue(latLng);
    }
}
