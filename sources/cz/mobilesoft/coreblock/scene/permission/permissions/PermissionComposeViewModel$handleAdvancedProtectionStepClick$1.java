package cz.mobilesoft.coreblock.scene.permission.permissions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$handleAdvancedProtectionStepClick$1", f = "PermissionViewModel.kt", l = {146, 147, 148, 150}, m = "invokeSuspend", v = 1)
final class PermissionComposeViewModel$handleAdvancedProtectionStepClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f112076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PermissionComposeViewModel f112077b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionComposeViewModel$handleAdvancedProtectionStepClick$1(PermissionComposeViewModel permissionComposeViewModel, Continuation continuation) {
        super(2, continuation);
        this.f112077b = permissionComposeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PermissionComposeViewModel$handleAdvancedProtectionStepClick$1(this.f112077b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
    
        if (r10.P0(r1, r9) != r0) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f112076a
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2c
            if (r1 == r5) goto L28
            if (r1 == r4) goto L24
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            kotlin.ResultKt.b(r10)
            goto L7e
        L18:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L20:
            kotlin.ResultKt.b(r10)
            goto L71
        L24:
            kotlin.ResultKt.b(r10)
            goto L61
        L28:
            kotlin.ResultKt.b(r10)
            goto L42
        L2c:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel r10 = r9.f112077b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r10 = cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.c1(r10)
            kotlinx.coroutines.flow.Flow r10 = r10.b2()
            r9.f112076a = r5
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.D(r10, r9)
            if (r10 != r0) goto L42
            goto L7d
        L42:
            java.lang.Number r10 = (java.lang.Number) r10
            long r5 = r10.longValue()
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 != 0) goto L71
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel r10 = r9.f112077b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r10 = cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.c1(r10)
            long r5 = java.lang.System.currentTimeMillis()
            r9.f112076a = r4
            java.lang.Object r10 = r10.z4(r5, r9)
            if (r10 != r0) goto L61
            goto L7d
        L61:
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel r10 = r9.f112077b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r10 = cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.c1(r10)
            r9.f112076a = r3
            r1 = 0
            java.lang.Object r10 = r10.y4(r1, r9)
            if (r10 != r0) goto L71
            goto L7d
        L71:
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel r10 = r9.f112077b
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeCommand$OpenAdvancedProtectionSettings r1 = cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeCommand.OpenAdvancedProtectionSettings.f111999a
            r9.f112076a = r2
            java.lang.Object r10 = cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.n1(r10, r1, r9)
            if (r10 != r0) goto L7e
        L7d:
            return r0
        L7e:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$handleAdvancedProtectionStepClick$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PermissionComposeViewModel$handleAdvancedProtectionStepClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
