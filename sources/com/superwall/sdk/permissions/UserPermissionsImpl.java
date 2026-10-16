package com.superwall.sdk.permissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuationImpl;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class UserPermissionsImpl implements UserPermissions {
    public static final Companion Companion = new Companion(null);
    private static final int PERMISSION_REQUEST_CODE = 10001;
    private final Context context;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PermissionType.values().length];
            try {
                iArr[PermissionType.NOTIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionType.LOCATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PermissionType.READ_IMAGES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PermissionType.CONTACTS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PermissionType.READ_VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PermissionType.CAMERA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PermissionType.MICROPHONE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PermissionType.BACKGROUND_LOCATION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.permissions.UserPermissionsImpl$requestBackgroundLocationPermission$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.permissions.UserPermissionsImpl", f = "UserPermissionsImpl.kt", l = {166, 177}, m = "requestBackgroundLocationPermission")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UserPermissionsImpl.this.requestBackgroundLocationPermission(null, this);
        }
    }

    public UserPermissionsImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final PermissionStatus checkBackgroundLocationPermission() {
        return Build.VERSION.SDK_INT < 29 ? PermissionStatus.UNSUPPORTED : ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_FINE_LOCATION") == 0 ? ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_BACKGROUND_LOCATION") == 0 ? PermissionStatus.GRANTED : PermissionStatus.DENIED : PermissionStatus.DENIED;
    }

    private final PermissionStatus checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 33) {
            return ContextCompat.checkSelfPermission(this.context, "android.permission.POST_NOTIFICATIONS") == 0 ? PermissionStatus.GRANTED : PermissionStatus.DENIED;
        }
        NotificationManagerCompat notificationManagerCompatD = NotificationManagerCompat.d(this.context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatD, "from(...)");
        return notificationManagerCompatD.a() ? PermissionStatus.GRANTED : PermissionStatus.DENIED;
    }

    private final PermissionStatus checkRuntimePermission(PermissionType permissionType) {
        String manifestPermission = permissionType.toManifestPermission();
        return manifestPermission == null ? PermissionStatus.UNSUPPORTED : ContextCompat.checkSelfPermission(this.context, manifestPermission) == 0 ? PermissionStatus.GRANTED : PermissionStatus.DENIED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object requestBackgroundLocationPermission(android.app.Activity r7, kotlin.coroutines.Continuation<? super com.superwall.sdk.permissions.PermissionStatus> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.superwall.sdk.permissions.UserPermissionsImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            com.superwall.sdk.permissions.UserPermissionsImpl$requestBackgroundLocationPermission$1 r0 = (com.superwall.sdk.permissions.UserPermissionsImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.permissions.UserPermissionsImpl$requestBackgroundLocationPermission$1 r0 = new com.superwall.sdk.permissions.UserPermissionsImpl$requestBackgroundLocationPermission$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            return r8
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            java.lang.Object r7 = r0.L$1
            android.app.Activity r7 = (android.app.Activity) r7
            java.lang.Object r2 = r0.L$0
            com.superwall.sdk.permissions.UserPermissionsImpl r2 = (com.superwall.sdk.permissions.UserPermissionsImpl) r2
            kotlin.ResultKt.b(r8)
            goto L6d
        L40:
            kotlin.ResultKt.b(r8)
            int r8 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r8 >= r2) goto L4c
            com.superwall.sdk.permissions.PermissionStatus r7 = com.superwall.sdk.permissions.PermissionStatus.UNSUPPORTED
            return r7
        L4c:
            com.superwall.sdk.permissions.PermissionType r8 = com.superwall.sdk.permissions.PermissionType.BACKGROUND_LOCATION
            com.superwall.sdk.permissions.PermissionStatus r8 = r6.hasPermission(r8)
            com.superwall.sdk.permissions.PermissionStatus r2 = com.superwall.sdk.permissions.PermissionStatus.GRANTED
            if (r8 != r2) goto L57
            return r2
        L57:
            com.superwall.sdk.permissions.PermissionType r8 = com.superwall.sdk.permissions.PermissionType.LOCATION
            com.superwall.sdk.permissions.PermissionStatus r5 = r6.hasPermission(r8)
            if (r5 == r2) goto L76
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r6.requestStandardPermission(r7, r8, r0)
            if (r8 != r1) goto L6c
            goto L8f
        L6c:
            r2 = r6
        L6d:
            com.superwall.sdk.permissions.PermissionStatus r8 = (com.superwall.sdk.permissions.PermissionStatus) r8
            com.superwall.sdk.permissions.PermissionStatus r4 = com.superwall.sdk.permissions.PermissionStatus.GRANTED
            if (r8 == r4) goto L77
            com.superwall.sdk.permissions.PermissionStatus r7 = com.superwall.sdk.permissions.PermissionStatus.DENIED
            return r7
        L76:
            r2 = r6
        L77:
            com.superwall.sdk.permissions.PermissionType r8 = com.superwall.sdk.permissions.PermissionType.BACKGROUND_LOCATION
            java.lang.String r8 = r8.toManifestPermission()
            if (r8 != 0) goto L82
            com.superwall.sdk.permissions.PermissionStatus r7 = com.superwall.sdk.permissions.PermissionStatus.UNSUPPORTED
            return r7
        L82:
            r4 = 0
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r7 = r2.requestRuntimePermission(r7, r8, r0)
            if (r7 != r1) goto L90
        L8f:
            return r1
        L90:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.permissions.UserPermissionsImpl.requestBackgroundLocationPermission(android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestNotificationPermission(Activity activity, Continuation<? super PermissionStatus> continuation) {
        PermissionType permissionType = PermissionType.NOTIFICATION;
        PermissionStatus permissionStatusHasPermission = hasPermission(permissionType);
        PermissionStatus permissionStatus = PermissionStatus.GRANTED;
        if (permissionStatusHasPermission == permissionStatus) {
            return permissionStatus;
        }
        if (Build.VERSION.SDK_INT < 33) {
            return permissionStatusHasPermission;
        }
        String manifestPermission = permissionType.toManifestPermission();
        return manifestPermission == null ? PermissionStatus.UNSUPPORTED : requestRuntimePermission(activity, manifestPermission, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestStandardPermission(Activity activity, PermissionType permissionType, Continuation<? super PermissionStatus> continuation) {
        PermissionStatus permissionStatusHasPermission = hasPermission(permissionType);
        PermissionStatus permissionStatus = PermissionStatus.GRANTED;
        if (permissionStatusHasPermission == permissionStatus) {
            return permissionStatus;
        }
        String manifestPermission = permissionType.toManifestPermission();
        return manifestPermission == null ? PermissionStatus.UNSUPPORTED : requestRuntimePermission(activity, manifestPermission, continuation);
    }

    @Override // com.superwall.sdk.permissions.UserPermissions
    public PermissionStatus hasPermission(PermissionType permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        switch (WhenMappings.$EnumSwitchMapping$0[permission.ordinal()]) {
            case 1:
                return checkNotificationPermission();
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return checkRuntimePermission(permission);
            case 8:
                return checkBackgroundLocationPermission();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.superwall.sdk.permissions.UserPermissions
    public Object requestPermission(Activity activity, PermissionType permissionType, Continuation<? super PermissionStatus> continuation) {
        switch (WhenMappings.$EnumSwitchMapping$0[permissionType.ordinal()]) {
            case 1:
                return requestNotificationPermission(activity, continuation);
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return requestStandardPermission(activity, permissionType, continuation);
            case 8:
                return requestBackgroundLocationPermission(activity, continuation);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestRuntimePermission(Activity activity, String str, Continuation<? super PermissionStatus> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        if (activity instanceof ComponentActivity) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f140144a = ((ComponentActivity) activity).getActivityResultRegistry().l(QaXmqxvjHhxVy.PmZ + System.currentTimeMillis(), new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.superwall.sdk.permissions.UserPermissionsImpl$requestRuntimePermission$2$1
                @Override // androidx.activity.result.ActivityResultCallback
                public /* bridge */ /* synthetic */ void onActivityResult(Object obj) {
                    onActivityResult(((Boolean) obj).booleanValue());
                }

                public final void onActivityResult(boolean z2) {
                    ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) objectRef.f140144a;
                    if (activityResultLauncher != null) {
                        activityResultLauncher.d();
                    }
                    PermissionStatus permissionStatus = z2 ? PermissionStatus.GRANTED : PermissionStatus.DENIED;
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resumeWith(Result.b(permissionStatus));
                    }
                }
            });
            cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: com.superwall.sdk.permissions.UserPermissionsImpl$requestRuntimePermission$2$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Throwable th) {
                    ((ActivityResultLauncher) objectRef.f140144a).d();
                }
            });
            ((ActivityResultLauncher) objectRef.f140144a).b(str);
        } else {
            ActivityCompat.e(activity, new String[]{str}, PERMISSION_REQUEST_CODE);
            boolean z2 = ContextCompat.checkSelfPermission(activity, str) == 0;
            if (cancellableContinuationImpl.isActive()) {
                Result.Companion companion = Result.f139772b;
                cancellableContinuationImpl.resumeWith(Result.b(z2 ? PermissionStatus.GRANTED : PermissionStatus.DENIED));
            }
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }
}
