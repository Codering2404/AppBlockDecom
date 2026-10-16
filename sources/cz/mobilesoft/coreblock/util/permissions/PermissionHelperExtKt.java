package cz.mobilesoft.coreblock.util.permissions;

import android.content.ComponentName;
import android.content.Context;
import android.location.LocationManager;
import androidx.fragment.app.FragmentActivity;
import cz.mobilesoft.coreblock.scene.permission.old.AccessibilityPrivacyBottomSheet;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PermissionHelperExtKt {
    public static final boolean b(LocationManager locationManager, Context context) {
        Intrinsics.checkNotNullParameter(locationManager, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (locationManager.isProviderEnabled("gps")) {
            return true;
        }
        RunnabilityHelper runnabilityHelper = RunnabilityHelper.f129617a;
        if (!runnabilityHelper.L(context)) {
            return false;
        }
        if (runnabilityHelper.P() || runnabilityHelper.A() || runnabilityHelper.z()) {
            return locationManager.isProviderEnabled("network");
        }
        return false;
    }

    public static final void c(final FragmentActivity activity, final String str, final boolean z2, final ComponentName componentName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AccessibilityPrivacyBottomSheet accessibilityPrivacyBottomSheetA = AccessibilityPrivacyBottomSheet.f111958d.a();
        accessibilityPrivacyBottomSheetA.show(activity.getSupportFragmentManager(), "AccessibilityPrivacyBottomSheet");
        accessibilityPrivacyBottomSheetA.G(new Function0() { // from class: cz.mobilesoft.coreblock.util.permissions.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PermissionHelperExtKt.e(activity, str, componentName, z2);
            }
        });
    }

    public static /* synthetic */ void d(FragmentActivity fragmentActivity, String str, boolean z2, ComponentName componentName, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            componentName = null;
        }
        c(fragmentActivity, str, z2, componentName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(FragmentActivity fragmentActivity, String str, ComponentName componentName, boolean z2) {
        PermissionHelperV2 permissionHelperV2 = PermissionHelperV2.f129006a;
        if (componentName == null) {
            componentName = fragmentActivity.getComponentName();
        }
        permissionHelperV2.c(fragmentActivity, str, componentName, z2);
        return Unit.f139807a;
    }
}
