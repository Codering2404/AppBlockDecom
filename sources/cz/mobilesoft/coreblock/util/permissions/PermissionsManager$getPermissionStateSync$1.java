package cz.mobilesoft.coreblock.util.permissions;

import cz.mobilesoft.coreblock.enums.Permission;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.permissions.PermissionsManager$getPermissionStateSync$1", f = "PermissionsManager.kt", l = {594, 596}, m = "invokeSuspend", v = 1)
final class PermissionsManager$getPermissionStateSync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PermissionStateDTO>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f129152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Permission f129153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f129154c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionsManager$getPermissionStateSync$1(Permission permission, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f129153b = permission;
        this.f129154c = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PermissionsManager$getPermissionStateSync$1(this.f129153b, this.f129154c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r5 == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
    
        if (r5 == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f129152a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L44
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)
            goto L34
        L1e:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.enums.Permission r5 = r4.f129153b
            boolean r1 = r5 instanceof cz.mobilesoft.coreblock.enums.Permission.ACCESSIBILITY
            if (r1 == 0) goto L37
            cz.mobilesoft.coreblock.util.permissions.PermissionsManager r5 = cz.mobilesoft.coreblock.util.permissions.PermissionsManager.f129021a
            boolean r1 = r4.f129154c
            r4.f129152a = r3
            java.lang.Object r5 = cz.mobilesoft.coreblock.util.permissions.PermissionsManager.b(r5, r1, r4)
            if (r5 != r0) goto L34
            goto L43
        L34:
            cz.mobilesoft.coreblock.util.permissions.PermissionStateDTO r5 = (cz.mobilesoft.coreblock.util.permissions.PermissionStateDTO) r5
            return r5
        L37:
            cz.mobilesoft.coreblock.util.permissions.PermissionsManager r1 = cz.mobilesoft.coreblock.util.permissions.PermissionsManager.f129021a
            boolean r3 = r4.f129154c
            r4.f129152a = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.util.permissions.PermissionsManager.d(r1, r5, r3, r4)
            if (r5 != r0) goto L44
        L43:
            return r0
        L44:
            cz.mobilesoft.coreblock.util.permissions.PermissionStateDTO r5 = (cz.mobilesoft.coreblock.util.permissions.PermissionStateDTO) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.permissions.PermissionsManager$getPermissionStateSync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PermissionsManager$getPermissionStateSync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
