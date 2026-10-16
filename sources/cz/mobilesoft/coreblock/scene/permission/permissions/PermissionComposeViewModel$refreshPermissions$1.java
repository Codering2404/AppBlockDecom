package cz.mobilesoft.coreblock.scene.permission.permissions;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$refreshPermissions$1", f = "PermissionViewModel.kt", l = {172, 173, 175, SensibleDefaults.X_OFFSET, RCHTTPStatusCodes.CREATED, 214}, m = "invokeSuspend", v = 1)
final class PermissionComposeViewModel$refreshPermissions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f112099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f112100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f112101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f112102d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f112103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f112104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f112105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ PermissionComposeViewModel f112106i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionComposeViewModel$refreshPermissions$1(PermissionComposeViewModel permissionComposeViewModel, Continuation continuation) {
        super(2, continuation);
        this.f112106i = permissionComposeViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionComposeState y(List list, PermissionComposeState permissionComposeState) {
        return PermissionComposeState.b(permissionComposeState, list, false, false, false, false, false, false, null, false, false, 1022, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionComposeState z(List list, PermissionComposeState permissionComposeState) {
        return PermissionComposeState.b(permissionComposeState, list, false, false, false, false, false, false, null, false, false, 1022, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PermissionComposeViewModel$refreshPermissions$1(this.f112106i, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b9, code lost:
    
        if (r2.I1(r18) != r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f5, code lost:
    
        if (r9 == r1) goto L116;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0200 A[PHI: r2 r7 r8 r9
      0x0200: PHI (r2v41 int) = (r2v30 int), (r2v30 int), (r2v30 int), (r2v44 int) binds: [B:86:0x01d0, B:87:0x01d2, B:89:0x01de, B:94:0x01ff] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r7v6 java.util.List) = (r7v2 java.util.List), (r7v2 java.util.List), (r7v2 java.util.List), (r7v7 java.util.List) binds: [B:86:0x01d0, B:87:0x01d2, B:89:0x01de, B:94:0x01ff] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r8v6 java.util.List) = (r8v2 java.util.List), (r8v2 java.util.List), (r8v2 java.util.List), (r8v7 java.util.List) binds: [B:86:0x01d0, B:87:0x01d2, B:89:0x01de, B:94:0x01ff] A[DONT_GENERATE, DONT_INLINE]
      0x0200: PHI (r9v12 int) = (r9v2 int), (r9v2 int), (r9v2 int), (r9v13 int) binds: [B:86:0x01d0, B:87:0x01d2, B:89:0x01de, B:94:0x01ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0218  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00f5 -> B:9:0x004d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 712
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$refreshPermissions$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PermissionComposeViewModel$refreshPermissions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
