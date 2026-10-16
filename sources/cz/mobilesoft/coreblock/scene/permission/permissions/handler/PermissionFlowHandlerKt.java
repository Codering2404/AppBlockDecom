package cz.mobilesoft.coreblock.scene.permission.permissions.handler;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.PermissionKt;
import cz.mobilesoft.coreblock.scene.permission.NavLocationPermission;
import cz.mobilesoft.coreblock.scene.permission.NavSinglePermission;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeCommand;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.runnability.DeviceAdminHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

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
public final class PermissionFlowHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object B(PermissionComposeCommand.HandlePermissionAction handlePermissionAction, NavHostController navHostController, PermissionsHandler permissionsHandler, final Activity activity, final ActivityResultLauncher activityResultLauncher, final ActivityResultLauncher activityResultLauncher2, final Function0 function0, Continuation continuation) throws Throwable {
        Permission permissionE = handlePermissionAction.a().e();
        if (permissionE instanceof Permission.ACCESSIBILITY) {
            if (navHostController != null) {
                NavController.O(navHostController, new NavSinglePermission(PermissionKt.a(permissionE)), null, null, 6, null);
            }
        } else {
            if (!(permissionE instanceof Permission.LOCATION)) {
                Object objG = permissionsHandler.g(activity, handlePermissionAction.a(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PermissionFlowHandlerKt.C(function0, (Permission.ACCESSIBILITY) obj);
                    }
                }, new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PermissionFlowHandlerKt.D(activityResultLauncher2, activity);
                    }
                }, new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PermissionFlowHandlerKt.E(activity);
                    }
                }, new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PermissionFlowHandlerKt.G(activity);
                    }
                }, new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PermissionFlowHandlerKt.H(activityResultLauncher);
                    }
                }, continuation);
                return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
            }
            if (navHostController != null) {
                NavController.O(navHostController, NavLocationPermission.INSTANCE, null, null, 6, null);
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Function0 function0, Permission.ACCESSIBILITY it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(ActivityResultLauncher activityResultLauncher, Activity activity) {
        DeviceAdminHelper.g(activityResultLauncher, activity);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(final Activity activity) {
        DialogHelper.m(activity, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PermissionFlowHandlerKt.F(activity, dialogInterface, i3);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Activity activity, DialogInterface dialogInterface, int i3) {
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Activity activity) {
        activity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(ActivityResultLauncher activityResultLauncher) {
        if (PermissionHelper.n()) {
            activityResultLauncher.b("android.permission.POST_NOTIFICATIONS");
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object I(PermissionComposeCommand.HandlePermissionAction handlePermissionAction, PermissionsHandler permissionsHandler, final Activity activity, final ActivityResultLauncher activityResultLauncher, final ActivityResultLauncher activityResultLauncher2, final Function0 function0, Continuation continuation) throws Throwable {
        Object objG = permissionsHandler.g(activity, handlePermissionAction.a(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PermissionFlowHandlerKt.J(function0, (Permission.ACCESSIBILITY) obj);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PermissionFlowHandlerKt.K(activityResultLauncher2, activity);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PermissionFlowHandlerKt.L(activity);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PermissionFlowHandlerKt.N(activity);
            }
        }, new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PermissionFlowHandlerKt.O(activityResultLauncher);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(ActivityResultLauncher activityResultLauncher, Activity activity) {
        DeviceAdminHelper.g(activityResultLauncher, activity);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(final Activity activity) {
        DialogHelper.m(activity, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.handler.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                PermissionFlowHandlerKt.M(activity, dialogInterface, i3);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Activity activity, DialogInterface dialogInterface, int i3) {
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Activity activity) {
        activity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(ActivityResultLauncher activityResultLauncher) {
        activityResultLauncher.b("android.permission.POST_NOTIFICATIONS");
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void s(final kotlinx.coroutines.flow.Flow r18, final cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler r19, final androidx.navigation.NavHostController r20, kotlin.jvm.functions.Function0 r21, kotlin.jvm.functions.Function0 r22, kotlin.jvm.functions.Function0 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionFlowHandlerKt.s(kotlinx.coroutines.flow.Flow, cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler, androidx.navigation.NavHostController, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function0 function0, boolean z2) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function0 function0, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Flow flow, PermissionsHandler permissionsHandler, NavHostController navHostController, Function0 function0, Function0 function02, Function0 function03, int i3, int i4, Composer composer, int i5) {
        s(flow, permissionsHandler, navHostController, function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Function0 function0, Permission.ACCESSIBILITY accessibility) {
        Intrinsics.checkNotNullParameter(accessibility, vgWWUoTKYyuC.UbvjI);
        function0.invoke();
        return Unit.f139807a;
    }
}
