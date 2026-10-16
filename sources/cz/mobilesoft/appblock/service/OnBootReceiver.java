package cz.mobilesoft.appblock.service;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OnBootReceiver extends cz.mobilesoft.coreblock.service.receiver.OnBootReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f94606b = cz.mobilesoft.coreblock.service.receiver.OnBootReceiver.f123711a;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // cz.mobilesoft.coreblock.service.receiver.OnBootReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(android.content.Context r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.appblock.service.OnBootReceiver$onInitialized$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.appblock.service.OnBootReceiver$onInitialized$1 r0 = (cz.mobilesoft.appblock.service.OnBootReceiver$onInitialized$1) r0
            int r1 = r0.f94610d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f94610d = r1
            goto L18
        L13:
            cz.mobilesoft.appblock.service.OnBootReceiver$onInitialized$1 r0 = new cz.mobilesoft.appblock.service.OnBootReceiver$onInitialized$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f94608b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f94610d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f94607a
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.b(r6)
            goto L45
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.appblock.service.LockServiceReasonsHelper r6 = cz.mobilesoft.appblock.service.LockServiceReasonsHelper.f94527a
            r0.f94607a = r5
            r0.f94610d = r3
            java.lang.Object r6 = r6.a(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L52
            cz.mobilesoft.appblock.util.ServiceHelper r6 = cz.mobilesoft.appblock.util.ServiceHelper.f95139a
            r6.f(r5)
        L52:
            cz.mobilesoft.coreblock.util.runnability.JobHelper.A()
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.OnBootReceiver.b(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
