package cz.mobilesoft.coreblock.scene.permission.permissions.handler;

import android.app.Activity;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelperV2;
import cz.mobilesoft.coreblock.util.permissions.PermissionsManager;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PermissionsHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoreDataStore f112171a;

    public PermissionsHandler(CoreDataStore coreDataStore) {
        Intrinsics.checkNotNullParameter(coreDataStore, "coreDataStore");
        this.f112171a = coreDataStore;
    }

    private final void c(Activity activity, PermissionDTO permissionDTO) {
        if (PermissionsManager.f129021a.B()) {
            try {
                PermissionHelperV2.f129006a.e(activity, permissionDTO.e().g(activity), activity.getComponentName());
            } catch (Exception e3) {
                e3.printStackTrace();
                CrashHelper.j(e3);
            }
        }
    }

    private final void d(Function0 function0) {
        function0.invoke();
    }

    private final void e(Activity activity) {
        RunnabilityHelper.R(activity);
        PrefManager.f126839a.P2(true);
    }

    private final void f(Activity activity, PermissionDTO permissionDTO, Function0 function0) {
        if (PermissionHelperV2.f129006a.g(activity, permissionDTO.e().g(activity), activity.getComponentName())) {
            return;
        }
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(android.app.Activity r6, kotlin.jvm.functions.Function0 r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler$handlePostNotifications$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler$handlePostNotifications$1 r0 = (cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler$handlePostNotifications$1) r0
            int r1 = r0.f112177g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f112177g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler$handlePostNotifications$1 r0 = new cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler$handlePostNotifications$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f112175d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f112177g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4b
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            boolean r6 = r0.f112174c
            java.lang.Object r7 = r0.f112173b
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            java.lang.Object r0 = r0.f112172a
            android.app.Activity r0 = (android.app.Activity) r0
            kotlin.ResultKt.b(r8)
            goto L80
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            java.lang.Object r6 = r0.f112173b
            r7 = r6
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            java.lang.Object r6 = r0.f112172a
            android.app.Activity r6 = (android.app.Activity) r6
            kotlin.ResultKt.b(r8)
            goto L67
        L4b:
            kotlin.ResultKt.b(r8)
            boolean r8 = cz.mobilesoft.coreblock.util.permissions.PermissionHelper.n()
            if (r8 == 0) goto L9a
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r8 = r5.f112171a
            kotlinx.coroutines.flow.Flow r8 = r8.D3()
            r0.f112172a = r6
            r0.f112173b = r7
            r0.f112177g = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r0)
            if (r8 != r1) goto L67
            goto L7d
        L67:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r2 = r5.f112171a
            r0.f112172a = r6
            r0.f112173b = r7
            r0.f112174c = r8
            r0.f112177g = r3
            java.lang.Object r0 = r2.n5(r4, r0)
            if (r0 != r1) goto L7e
        L7d:
            return r1
        L7e:
            r0 = r6
            r6 = r8
        L80:
            java.lang.String r8 = "android.permission.POST_NOTIFICATIONS"
            boolean r8 = androidx.core.app.ActivityCompat.h(r0, r8)
            if (r6 == 0) goto L97
            if (r8 == 0) goto L8b
            goto L97
        L8b:
            android.content.ComponentName r6 = r0.getComponentName()
            boolean r6 = cz.mobilesoft.coreblock.util.permissions.PermissionHelper.q(r0, r6)
            kotlin.coroutines.jvm.internal.Boxing.a(r6)
            goto L9a
        L97:
            r7.invoke()
        L9a:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionsHandler.h(android.app.Activity, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void i(Activity activity, PermissionDTO permissionDTO) {
        try {
            PermissionHelperV2.f129006a.f(activity, permissionDTO.e().g(activity), activity.getComponentName());
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }

    private final void j(Activity activity, PermissionDTO permissionDTO, Function0 function0) {
        try {
            PermissionHelperV2.f129006a.h(activity, permissionDTO.e().g(activity), activity.getComponentName(), true);
        } catch (Exception e3) {
            CrashHelper.j(e3);
            function0.invoke();
        }
    }

    public final Object g(Activity activity, PermissionDTO permissionDTO, Function1 function1, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Continuation continuation) throws Throwable {
        Permission permissionE = permissionDTO.e();
        if (permissionE instanceof Permission.ACCESSIBILITY) {
            b(activity, permissionDTO, function1);
        } else if (Intrinsics.areEqual(permissionE, Permission.ALARM_EXACT.f96997d)) {
            c(activity, permissionDTO);
        } else if (Intrinsics.areEqual(permissionE, Permission.DEVICE_ADMIN.f96998d)) {
            d(function0);
        } else if (!Intrinsics.areEqual(permissionE, Permission.LOCATION.f96999d)) {
            if (Intrinsics.areEqual(permissionE, Permission.MIUI_11_POP_UP.f97000d)) {
                e(activity);
            } else if (Intrinsics.areEqual(permissionE, Permission.NOTIFICATION_ACCESS.f97001d)) {
                f(activity, permissionDTO, function02);
            } else {
                if (permissionE instanceof Permission.POST_NOTIFICATIONS) {
                    Object objH = h(activity, function04, continuation);
                    return objH == IntrinsicsKt.f() ? objH : Unit.f139807a;
                }
                if (Intrinsics.areEqual(permissionE, Permission.SYSTEM_OVERLAY.f97003d)) {
                    i(activity, permissionDTO);
                } else {
                    if (!(permissionE instanceof Permission.USAGE_ACCESS)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    j(activity, permissionDTO, function03);
                }
            }
        }
        return Unit.f139807a;
    }

    private final void b(Activity activity, PermissionDTO permissionDTO, Function1 function1) {
        if (!PrefManager.f126839a.m1()) {
            Permission permissionE = permissionDTO.e();
            Intrinsics.checkNotNull(permissionE, wgbAZXYjrv.DQviFaJldHS);
            function1.invoke((Permission.ACCESSIBILITY) permissionE);
        } else {
            try {
                PermissionHelperV2.f129006a.c(activity, permissionDTO.e().g(activity), activity.getComponentName(), false);
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
        }
    }
}
