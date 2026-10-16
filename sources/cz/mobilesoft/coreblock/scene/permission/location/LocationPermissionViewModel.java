package cz.mobilesoft.coreblock.scene.permission.location;

import android.app.Application;
import android.content.ComponentName;
import android.location.LocationManager;
import androidx.lifecycle.ViewModelKt;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionEvent;
import cz.mobilesoft.coreblock.service.CheckGrantedPermissionService;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelperExtKt;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LocationPermissionViewModel extends BaseStatefulViewModel<LocationPermissionViewState, LocationPermissionEvent, LocationPermissionCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f111858o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f111859p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final LocationManager f111860q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationPermissionViewModel(boolean z2, boolean z3, Application application, LocationManager locationManager) {
        super(application, new LocationPermissionViewState(false, false, false, false, false, false, false, 127, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        this.f111858o = z2;
        this.f111859p = z3;
        this.f111860q = locationManager;
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.location.x0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocationPermissionViewModel.T0(this.f111949a, (LocationPermissionViewState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationPermissionViewState T0(LocationPermissionViewModel locationPermissionViewModel, LocationPermissionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        boolean z2 = locationPermissionViewModel.f111858o;
        boolean z3 = locationPermissionViewModel.f111859p;
        return LocationPermissionViewState.c(updateState, PermissionHelper.h(locationPermissionViewModel.A0()), RunnabilityHelper.f129617a.r() ? PermissionHelper.f(locationPermissionViewModel.A0()) : updateState.h(), PermissionHelperExtKt.b(locationPermissionViewModel.f111860q, locationPermissionViewModel.A0()), PrefManager.f126839a.h1(), z2, z3, false, 64, null);
    }

    private final void V0() {
        AnswersHelper.f128199a.B2();
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new LocationPermissionViewModel$onAllPermissionsGranted$1(this, null), 3, null);
    }

    private final void X0(ComponentName componentName) {
        AnswersHelper.f128199a.C2();
        if (componentName != null) {
            CheckGrantedPermissionService.f123093j.c(A0(), Permission.LOCATION.f96999d, null, componentName);
        }
    }

    private final void Y0() {
        final boolean zB = PermissionHelperExtKt.b(this.f111860q, A0());
        final boolean zH = PermissionHelper.h(A0());
        final boolean zH1 = PrefManager.f126839a.h1();
        final boolean zF = RunnabilityHelper.f129617a.r() ? PermissionHelper.f(A0()) : zH;
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.location.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocationPermissionViewModel.Z0(zH, zF, zB, zH1, (LocationPermissionViewState) obj);
            }
        });
        if (zH) {
            AnswersHelper.f128199a.D2();
        }
        if (zH && zF && zB) {
            V0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocationPermissionViewState Z0(boolean z2, boolean z3, boolean z4, boolean z5, LocationPermissionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return LocationPermissionViewState.c(updateState, z2, z3, z4, z5, false, false, false, 112, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public void O0(LocationPermissionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, LocationPermissionEvent.OnUpdatePermissionState.f111848a)) {
            Y0();
        } else if (Intrinsics.areEqual(event, LocationPermissionEvent.OnAllPermissionsGranted.f111846a)) {
            V0();
        } else {
            if (!(event instanceof LocationPermissionEvent.OnGoToSettingsClick)) {
                throw new NoWhenBranchMatchedException();
            }
            X0(((LocationPermissionEvent.OnGoToSettingsClick) event).a());
        }
    }
}
