package cz.mobilesoft.coreblock.util.permissions;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.service.CheckGrantedPermissionService;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class PermissionHelperV2 implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PermissionHelperV2 f129006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f129007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CoroutineScope f129008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f129009d;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final PermissionHelperV2 permissionHelperV2 = new PermissionHelperV2();
        f129006a = permissionHelperV2;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f129007b = LazyKt.a(lazyThreadSafetyModeB, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.util.permissions.PermissionHelperV2$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = permissionHelperV2;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), qualifier, objArr);
            }
        });
        f129008c = CoroutineScopeKt.a(Dispatchers.a().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        f129009d = 8;
    }

    private PermissionHelperV2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore b() {
        return (EventDataStore) f129007b.getValue();
    }

    public final void c(Activity activity, String str, ComponentName componentName, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BuildersKt__Builders_commonKt.d(f129008c, null, null, new PermissionHelperV2$requestAccessibility$1(null), 3, null);
        activity.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
        if (str != null && componentName != null) {
            CheckGrantedPermissionService.f123093j.c(activity, new Permission.ACCESSIBILITY(null, false, 3, null), str, componentName);
        }
        if (z2) {
            PermissionHelper.r(activity);
        }
    }

    public final void d(Activity activity, String str, ComponentName componentName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BuildersKt__Builders_commonKt.d(f129008c, null, null, new PermissionHelperV2$requestAdvancedProtectionOff$1(null), 3, null);
        AdvancedProtectionHelper.f128991a.d(activity);
        if (str == null || componentName == null) {
            return;
        }
        CheckGrantedPermissionService.f123093j.c(activity, new Permission.ACCESSIBILITY(null, true, 1, null), str, componentName);
    }

    public final void e(Activity activity, String str, ComponentName componentName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BuildersKt__Builders_commonKt.d(f129008c, null, null, new PermissionHelperV2$requestAlarmExactPermission$1(null), 3, null);
        activity.startActivityForResult(new Intent("android.settings.REQUEST_SCHEDULE_EXACT_ALARM", Uri.parse("package:" + activity.getPackageName())), 949);
        if (str == null || componentName == null) {
            return;
        }
        CheckGrantedPermissionService.f123093j.c(activity, Permission.ALARM_EXACT.f96997d, str, componentName);
    }

    public final void f(Activity activity, String str, ComponentName componentName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BuildersKt__Builders_commonKt.d(f129008c, null, null, new PermissionHelperV2$requestDrawOverlayPermission$1(null), 3, null);
        activity.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + activity.getPackageName())), 921);
        if (str == null || componentName == null) {
            return;
        }
        CheckGrantedPermissionService.f123093j.c(activity, Permission.SYSTEM_OVERLAY.f97003d, str, componentName);
    }

    public final boolean g(Context context, String str, ComponentName componentName) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.d(f129008c, null, null, new PermissionHelperV2$requestNotificationAccess$1(null), 3, null);
        try {
            context.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
            if (str == null || componentName == null) {
                return true;
            }
            CheckGrantedPermissionService.f123093j.c(context, Permission.NOTIFICATION_ACCESS.f97001d, str, componentName);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public final void h(Activity activity, String str, ComponentName componentName, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BuildersKt__Builders_commonKt.d(f129008c, null, null, new PermissionHelperV2$requestUsageAccess$1(null), 3, null);
        activity.startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
        if (str == null || componentName == null) {
            return;
        }
        CheckGrantedPermissionService.f123093j.c(activity, new Permission.USAGE_ACCESS(null, 1, null), str, componentName);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
