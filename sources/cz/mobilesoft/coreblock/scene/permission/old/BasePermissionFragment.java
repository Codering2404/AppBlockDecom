package cz.mobilesoft.coreblock.scene.permission.old;

import android.content.DialogInterface;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.base.fragment.BaseFragment;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelperExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelperV2;
import cz.mobilesoft.coreblock.util.permissions.PermissionsManager;
import cz.mobilesoft.coreblock.util.runnability.DeviceAdminHelper;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public abstract class BasePermissionFragment<Binding extends ViewBinding> extends BaseFragment<Binding> implements KoinComponent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f111962b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f111963c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f111964d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ActivityResultLauncher f111965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ActivityResultLauncher f111966g;

    /* JADX WARN: Multi-variable type inference failed */
    public BasePermissionFragment() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f111964d = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.permission.old.BasePermissionFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        ActivityResultLauncher<I> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.permission.old.d
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BasePermissionFragment.E((ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.f111965f = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<I> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: cz.mobilesoft.coreblock.scene.permission.old.e
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BasePermissionFragment.M((Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResult(...)");
        this.f111966g = activityResultLauncherRegisterForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            DeviceAdminHelper.f129458a.j(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(BasePermissionFragment basePermissionFragment, Permission permission, DialogInterface dialogInterface, int i3) {
        basePermissionFragment.L(permission);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Boolean result) {
        Intrinsics.checkNotNullParameter(result, "result");
    }

    private final void N(PermissionDTO permissionDTO) {
        startActivity(PermissionActivity.Companion.b(PermissionActivity.f111772j, requireContext(), CollectionsKt.listOf(permissionDTO), F(), false, false, null, null, 104, null));
    }

    public boolean F() {
        return this.f111963c;
    }

    protected final CoreDataStore G() {
        return (CoreDataStore) this.f111964d.getValue();
    }

    public boolean H() {
        return this.f111962b;
    }

    public final boolean I(PermissionDTO permissionDTO) {
        Intrinsics.checkNotNullParameter(permissionDTO, "permissionDTO");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        final Permission permissionE = permissionDTO.e();
        if (permissionE instanceof Permission.USAGE_ACCESS) {
            try {
                PermissionHelperV2.f129006a.h(activity, permissionE.g(activity), activity.getComponentName(), true);
            } catch (Exception e3) {
                CrashHelper.j(e3);
                L(permissionE);
                return false;
            }
        } else if (Intrinsics.areEqual(permissionE, Permission.NOTIFICATION_ACCESS.f97001d)) {
            if (!PermissionHelperV2.f129006a.g(activity, permissionE.g(activity), activity.getComponentName())) {
                DialogHelper.m(activity, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.permission.old.f
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        BasePermissionFragment.J(this.f111983a, permissionE, dialogInterface, i3);
                    }
                });
                return false;
            }
        } else if (Intrinsics.areEqual(permissionE, Permission.SYSTEM_OVERLAY.f97003d)) {
            try {
                PermissionHelperV2.f129006a.f(activity, permissionE.g(activity), activity.getComponentName());
            } catch (Exception e4) {
                CrashHelper.j(e4);
                return false;
            }
        } else if (permissionE instanceof Permission.ACCESSIBILITY) {
            if (H()) {
                N(permissionDTO);
                return false;
            }
            if (PrefManager.f126839a.m1()) {
                try {
                    PermissionHelperV2.f129006a.c(activity, permissionE.g(activity), activity.getComponentName(), false);
                } catch (Exception e5) {
                    CrashHelper.j(e5);
                    return false;
                }
            } else {
                PermissionHelperExtKt.d(activity, permissionE.g(activity), false, null, 8, null);
            }
        } else {
            if (Intrinsics.areEqual(permissionE, Permission.MIUI_11_POP_UP.f97000d)) {
                boolean zR = RunnabilityHelper.R(activity);
                PrefManager.f126839a.P2(true);
                return zR;
            }
            if (Intrinsics.areEqual(permissionE, Permission.LOCATION.f96999d)) {
                N(permissionDTO);
                return false;
            }
            if (Intrinsics.areEqual(permissionE, Permission.DEVICE_ADMIN.f96998d)) {
                ActivityResultLauncher activityResultLauncher = this.f111965f;
                FragmentActivity fragmentActivityRequireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                DeviceAdminHelper.g(activityResultLauncher, fragmentActivityRequireActivity);
            } else {
                if (!Intrinsics.areEqual(permissionE, Permission.ALARM_EXACT.f96997d)) {
                    if (!(permissionE instanceof Permission.POST_NOTIFICATIONS)) {
                        activity.finish();
                        return false;
                    }
                    if (!PermissionHelper.n()) {
                        return false;
                    }
                    CoroutinesHelperExtKt.e(activity, new BasePermissionFragment$onPermissionClicked$1$2(this, activity, null));
                    return false;
                }
                if (!PermissionsManager.f129021a.B()) {
                    return false;
                }
                try {
                    PermissionHelperV2.f129006a.e(activity, permissionE.g(activity), activity.getComponentName());
                } catch (Exception e6) {
                    e6.printStackTrace();
                    CrashHelper.j(e6);
                    return false;
                }
            }
        }
        return true;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public void L(Permission permission) {
    }
}
