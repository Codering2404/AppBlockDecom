package cz.mobilesoft.coreblock.scene.permission.permissions;

import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeCommand;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$onEvent$3", f = "PermissionViewModel.kt", l = {119}, m = "invokeSuspend", v = 1)
final class PermissionComposeViewModel$onEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f112095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f112096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f112097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PermissionComposeViewModel f112098d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionComposeViewModel$onEvent$3(PermissionComposeViewModel permissionComposeViewModel, Continuation continuation) {
        super(2, continuation);
        this.f112098d = permissionComposeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PermissionComposeViewModel$onEvent$3(this.f112098d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object next;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f112097c;
        if (i3 == 0) {
            ResultKt.b(obj);
            Iterator it = this.f112098d.f112026q.e().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((PermissionDTO) next).e() instanceof Permission.ACCESSIBILITY) {
                    break;
                }
            }
            PermissionDTO permissionDTO = (PermissionDTO) next;
            if (permissionDTO != null) {
                PermissionComposeViewModel permissionComposeViewModel = this.f112098d;
                PermissionComposeCommand.HandlePermissionAction handlePermissionAction = new PermissionComposeCommand.HandlePermissionAction(permissionDTO, permissionComposeViewModel.f112026q.c(), false);
                this.f112095a = SpillingKt.a(permissionDTO);
                this.f112096b = 0;
                this.f112097c = 1;
                if (permissionComposeViewModel.P0(handlePermissionAction, this) == objF) {
                    return objF;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PermissionComposeViewModel$onEvent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
