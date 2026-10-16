package com.google.maps.android.compose.streetview;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class StreetViewPanoramaEventListeners {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f91372a = SnapshotStateKt__SnapshotStateKt.e(new Function1<StreetViewPanoramaOrientation, Unit>() { // from class: com.google.maps.android.compose.streetview.StreetViewPanoramaEventListeners$onClick$2
        public final void c(StreetViewPanoramaOrientation it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((StreetViewPanoramaOrientation) obj);
            return Unit.f139807a;
        }
    }, null, 2, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f91373b = SnapshotStateKt__SnapshotStateKt.e(new Function1<StreetViewPanoramaOrientation, Unit>() { // from class: com.google.maps.android.compose.streetview.StreetViewPanoramaEventListeners$onLongClick$2
        public final void c(StreetViewPanoramaOrientation it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((StreetViewPanoramaOrientation) obj);
            return Unit.f139807a;
        }
    }, null, 2, null);

    public final Function1 a() {
        return (Function1) this.f91372a.getValue();
    }

    public final Function1 b() {
        return (Function1) this.f91373b.getValue();
    }

    public final void c(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f91372a.setValue(function1);
    }

    public final void d(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.f91373b.setValue(function1);
    }
}
