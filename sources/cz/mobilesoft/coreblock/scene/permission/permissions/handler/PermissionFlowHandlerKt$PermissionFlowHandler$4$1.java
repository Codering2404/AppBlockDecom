package cz.mobilesoft.coreblock.scene.permission.permissions.handler;

import android.app.Activity;
import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.navigation.NavHostController;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeCommand;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionFlowHandlerKt$PermissionFlowHandler$4$1", f = "PermissionFlowHandler.kt", l = {77, 87}, m = "invokeSuspend", v = 1)
final class PermissionFlowHandlerKt$PermissionFlowHandler$4$1 extends SuspendLambda implements Function2<PermissionComposeCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f112162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f112163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Activity f112164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ NavHostController f112165d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ PermissionsHandler f112166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f112167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ManagedActivityResultLauncher f112168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function0 f112169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ Context f112170j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionFlowHandlerKt$PermissionFlowHandler$4$1(Activity activity, NavHostController navHostController, PermissionsHandler permissionsHandler, ManagedActivityResultLauncher managedActivityResultLauncher, ManagedActivityResultLauncher managedActivityResultLauncher2, Function0 function0, Context context, Continuation continuation) {
        super(2, continuation);
        this.f112164c = activity;
        this.f112165d = navHostController;
        this.f112166f = permissionsHandler;
        this.f112167g = managedActivityResultLauncher;
        this.f112168h = managedActivityResultLauncher2;
        this.f112169i = function0;
        this.f112170j = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PermissionFlowHandlerKt$PermissionFlowHandler$4$1 permissionFlowHandlerKt$PermissionFlowHandler$4$1 = new PermissionFlowHandlerKt$PermissionFlowHandler$4$1(this.f112164c, this.f112165d, this.f112166f, this.f112167g, this.f112168h, this.f112169i, this.f112170j, continuation);
        permissionFlowHandlerKt$PermissionFlowHandler$4$1.f112163b = obj;
        return permissionFlowHandlerKt$PermissionFlowHandler$4$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(PermissionComposeCommand permissionComposeCommand, Continuation continuation) {
        return ((PermissionFlowHandlerKt$PermissionFlowHandler$4$1) create(permissionComposeCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0097, code lost:
    
        if (cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionFlowHandlerKt.B(r5, r6, r7, r8, r9, r10, r11, r13) == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        if (cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionFlowHandlerKt.I(r5, r6, r7, r8, r9, r10, r13) == r1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b3, code lost:
    
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.handler.PermissionFlowHandlerKt$PermissionFlowHandler$4$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
