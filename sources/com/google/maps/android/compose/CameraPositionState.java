package com.google.maps.android.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.compose.CameraPositionState;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

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
public final class CameraPositionState {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f90598i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f90600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f90601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f90602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Unit f90603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f90604e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f90605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f90606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f90597h = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Saver f90599j = SaverKt.a(new Function2<SaverScope, CameraPositionState, CameraPosition>() { // from class: com.google.maps.android.compose.CameraPositionState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final CameraPosition invoke(SaverScope Saver, CameraPositionState it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return it.n();
        }
    }, new Function1<CameraPosition, CameraPositionState>() { // from class: com.google.maps.android.compose.CameraPositionState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final CameraPositionState invoke(CameraPosition it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new CameraPositionState(it);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return CameraPositionState.f90599j;
        }

        private Companion() {
        }
    }

    public CameraPositionState(CameraPosition position) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.f90600a = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
        this.f90601b = SnapshotStateKt__SnapshotStateKt.e(CameraMoveStartedReason.NO_MOVEMENT_YET, null, 2, null);
        this.f90602c = SnapshotStateKt__SnapshotStateKt.e(position, null, 2, null);
        this.f90603d = Unit.f139807a;
        this.f90604e = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f90605f = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f90606g = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(OnMapChangedCallback onMapChangedCallback) {
        OnMapChangedCallback onMapChangedCallbackM = m();
        if (onMapChangedCallbackM != null) {
            onMapChangedCallbackM.a();
        }
        x(onMapChangedCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GoogleMap k() {
        return (GoogleMap) this.f90604e.getValue();
    }

    private final Object l() {
        return this.f90606g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OnMapChangedCallback m() {
        return (OnMapChangedCallback) this.f90605f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(final GoogleMap googleMap, CameraUpdate cameraUpdate, int i3, final CancellableContinuation cancellableContinuation) {
        GoogleMap.CancelableCallback cancelableCallback = new GoogleMap.CancelableCallback() { // from class: com.google.maps.android.compose.CameraPositionState$performAnimateCameraLocked$cancelableCallback$1
            @Override // com.google.android.gms.maps.GoogleMap.CancelableCallback
            public void a() {
                CancellableContinuation cancellableContinuation2 = cancellableContinuation;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation2.resumeWith(Result.b(Unit.f139807a));
            }

            @Override // com.google.android.gms.maps.GoogleMap.CancelableCallback
            public void onCancel() {
                CancellableContinuation cancellableContinuation2 = cancellableContinuation;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation2.resumeWith(Result.b(ResultKt.a(new CancellationException("Animation cancelled"))));
            }
        };
        if (i3 == Integer.MAX_VALUE) {
            googleMap.h(cameraUpdate, cancelableCallback);
        } else {
            googleMap.g(cameraUpdate, i3, cancelableCallback);
        }
        j(new OnMapChangedCallback() { // from class: com.google.maps.android.compose.CameraPositionState$performAnimateCameraLocked$1
            @Override // com.google.maps.android.compose.CameraPositionState.OnMapChangedCallback
            public void a() {
                CameraPositionState.OnMapChangedCallback.DefaultImpls.a(this);
            }

            @Override // com.google.maps.android.compose.CameraPositionState.OnMapChangedCallback
            public final void b(GoogleMap googleMap2) {
                if (googleMap2 != null) {
                    throw new IllegalStateException("New GoogleMap unexpectedly set while an animation was still running");
                }
                googleMap.U();
            }
        });
    }

    private final void t(GoogleMap googleMap) {
        this.f90604e.setValue(googleMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(Object obj) {
        this.f90606g.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(OnMapChangedCallback onMapChangedCallback) {
        this.f90605f.setValue(onMapChangedCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.google.maps.android.compose.CameraPositionState$OnMapChangedCallback, com.google.maps.android.compose.CameraPositionState$animate$2$1$animateOnMapAvailable$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(final com.google.android.gms.maps.CameraUpdate r7, final int r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.compose.CameraPositionState.i(com.google.android.gms.maps.CameraUpdate, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CameraPosition n() {
        return p();
    }

    public final Projection o() {
        GoogleMap googleMapK = k();
        if (googleMapK != null) {
            return googleMapK.k();
        }
        return null;
    }

    public final CameraPosition p() {
        return (CameraPosition) this.f90602c.getValue();
    }

    public final void q(final CameraUpdate update) {
        Intrinsics.checkNotNullParameter(update, "update");
        synchronized (this.f90603d) {
            try {
                GoogleMap googleMapK = k();
                v(null);
                if (googleMapK == null) {
                    j(new OnMapChangedCallback() { // from class: com.google.maps.android.compose.CameraPositionState$move$1$1
                        @Override // com.google.maps.android.compose.CameraPositionState.OnMapChangedCallback
                        public void a() {
                            CameraPositionState.OnMapChangedCallback.DefaultImpls.a(this);
                        }

                        @Override // com.google.maps.android.compose.CameraPositionState.OnMapChangedCallback
                        public final void b(GoogleMap googleMap) {
                            if (googleMap != null) {
                                googleMap.m(update);
                            }
                        }
                    });
                } else {
                    googleMapK.m(update);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void s(CameraMoveStartedReason cameraMoveStartedReason) {
        Intrinsics.checkNotNullParameter(cameraMoveStartedReason, "<set-?>");
        this.f90601b.setValue(cameraMoveStartedReason);
    }

    public final void u(GoogleMap googleMap) {
        synchronized (this.f90603d) {
            try {
                if (k() == null && googleMap == null) {
                    return;
                }
                if (k() != null && googleMap != null) {
                    throw new IllegalStateException("CameraPositionState may only be associated with one GoogleMap at a time");
                }
                t(googleMap);
                if (googleMap == null) {
                    w(false);
                } else {
                    googleMap.m(CameraUpdateFactory.a(n()));
                }
                OnMapChangedCallback onMapChangedCallbackM = m();
                if (onMapChangedCallbackM != null) {
                    x(null);
                    onMapChangedCallbackM.b(googleMap);
                    Unit unit = Unit.f139807a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(boolean z2) {
        this.f90600a.setValue(Boolean.valueOf(z2));
    }

    public final void y(CameraPosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.f90603d) {
            try {
                GoogleMap googleMapK = k();
                if (googleMapK == null) {
                    z(value);
                } else {
                    googleMapK.m(CameraUpdateFactory.a(value));
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void z(CameraPosition cameraPosition) {
        Intrinsics.checkNotNullParameter(cameraPosition, "<set-?>");
        this.f90602c.setValue(cameraPosition);
    }

    public /* synthetic */ CameraPositionState(CameraPosition cameraPosition, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new CameraPosition(new LatLng(0.0d, 0.0d), 0.0f, 0.0f, 0.0f) : cameraPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    interface OnMapChangedCallback {
        void a();

        void b(GoogleMap googleMap);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
            public static void a(OnMapChangedCallback onMapChangedCallback) {
            }
        }
    }
}
