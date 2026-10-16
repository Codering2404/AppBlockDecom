package com.google.android.libraries.places.widget;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzni;
import com.google.android.libraries.places.widget.internal.autocomplete.ui.BaseAutocompleteImplFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import kotlin.Metadata;
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
public final class BasicPlaceAutocompleteActivity extends zzni implements PlaceSelectionListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f78860h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Status f78862d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f78858f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f78859g = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f78861i = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Override // com.google.android.libraries.places.widget.listener.PlaceSelectionListener
    public final void a(Status status) throws Throwable {
        Intrinsics.checkNotNullParameter(status, "status");
        if (!status.C()) {
            this.f78862d = status;
            V(f78859g, status);
            return;
        }
        Status status2 = this.f78862d;
        if (status2 == null) {
            T(f78860h, null, status);
        } else {
            T(f78859g, null, status2);
            this.f78862d = null;
        }
    }

    @Override // com.google.android.libraries.places.widget.listener.PlaceSelectionListener
    public final void c(Place place) throws Throwable {
        Intrinsics.checkNotNullParameter(place, "place");
        T(f78861i, place, Status.f71537g);
    }

    @Override // com.google.android.libraries.places.internal.zzni, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        BaseAutocompleteImplFragment baseAutocompleteImplFragment = this.f78249c;
        if (baseAutocompleteImplFragment != null) {
            Intrinsics.checkNotNull(baseAutocompleteImplFragment, "null cannot be cast to non-null type com.google.android.libraries.places.widget.internal.autocomplete.ui.BaseAutocompleteImplFragment");
            baseAutocompleteImplFragment.x(this);
        }
    }
}
