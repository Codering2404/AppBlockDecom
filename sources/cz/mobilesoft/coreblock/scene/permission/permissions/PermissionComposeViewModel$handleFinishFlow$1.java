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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$handleFinishFlow$1", f = "PermissionViewModel.kt", l = {318, 322}, m = "invokeSuspend", v = 1)
final class PermissionComposeViewModel$handleFinishFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f112078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f112079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f112080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PermissionComposeViewModel f112081d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f112082f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PermissionComposeViewModel$handleFinishFlow$1(PermissionComposeViewModel permissionComposeViewModel, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f112081d = permissionComposeViewModel;
        this.f112082f = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PermissionComposeViewModel$handleFinishFlow$1(this.f112081d, this.f112082f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
    
        if (r1.w1(r6) == r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a6, code lost:
    
        if (r1.u1(r3, r4, r6) == r0) goto L26;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f112080c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2f
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r0 = r6.f112079b
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r6.f112078a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r7)
            goto La9
        L1b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L23:
            java.lang.Object r0 = r6.f112079b
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r6.f112078a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r7)
            goto L8d
        L2f:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel r7 = r6.f112081d
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeState r7 = cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.Z0(r7)
            java.util.List r7 = r7.d()
            boolean r1 = r6.f112082f
            if (r1 == 0) goto L66
            r1 = r7
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r5)
            r4.<init>(r5)
            java.util.Iterator r1 = r1.iterator()
        L52:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L6a
            java.lang.Object r5 = r1.next()
            cz.mobilesoft.coreblock.util.permissions.PermissionDTO r5 = (cz.mobilesoft.coreblock.util.permissions.PermissionDTO) r5
            cz.mobilesoft.coreblock.enums.Permission r5 = r5.e()
            r4.add(r5)
            goto L52
        L66:
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L6a:
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel r1 = r6.f112081d
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionsDTO r1 = cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.f1(r1)
            boolean r1 = r1.j()
            if (r1 == 0) goto L90
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel r1 = r6.f112081d
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f112078a = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r6.f112079b = r7
            r6.f112080c = r3
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.b1(r1, r6)
            if (r7 != r0) goto L8d
            goto La8
        L8d:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L90:
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel r1 = r6.f112081d
            boolean r3 = r6.f112082f
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f112078a = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r6.f112079b = r7
            r6.f112080c = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.a1(r1, r3, r4, r6)
            if (r7 != r0) goto La9
        La8:
            return r0
        La9:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$handleFinishFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PermissionComposeViewModel$handleFinishFlow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
