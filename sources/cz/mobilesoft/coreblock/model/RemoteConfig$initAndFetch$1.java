package cz.mobilesoft.coreblock.model;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.model.RemoteConfig$initAndFetch$1", f = "RemoteConfig.kt", l = {108, 110}, m = "invokeSuspend", v = 1)
final class RemoteConfig$initAndFetch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f97090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f97091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f97092c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfig$initAndFetch$1(boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f97092c = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RemoteConfig$initAndFetch$1(this.f97092c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        if (r1.n(r3, r4) == r0) goto L27;
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
            int r1 = r4.f97091b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L12
            goto L5c
        L12:
            r5 = move-exception
            goto L64
        L14:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1c:
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L12
            goto L45
        L20:
            kotlin.ResultKt.b(r5)
            android.content.Context r5 = cz.mobilesoft.coreblock.LockieApplication.g()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)     // Catch: java.lang.Throwable -> L12
            boolean r5 = cz.mobilesoft.coreblock.util.NetworkHelperKt.b(r5)     // Catch: java.lang.Throwable -> L12
            if (r5 != 0) goto L3a
            kotlin.Unit r5 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L12
            cz.mobilesoft.coreblock.util.RemoteConfigSignal r0 = cz.mobilesoft.coreblock.util.RemoteConfigSignal.f127906a
            r0.b()
            return r5
        L3a:
            cz.mobilesoft.coreblock.model.RemoteConfig r5 = cz.mobilesoft.coreblock.model.RemoteConfig.f97054c     // Catch: java.lang.Throwable -> L12
            r4.f97091b = r3     // Catch: java.lang.Throwable -> L12
            java.lang.Object r5 = cz.mobilesoft.coreblock.model.RemoteConfig.e(r5, r4)     // Catch: java.lang.Throwable -> L12
            if (r5 != r0) goto L45
            goto L5b
        L45:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L12
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L12
            if (r5 == 0) goto L5c
            cz.mobilesoft.coreblock.model.RemoteConfig r1 = cz.mobilesoft.coreblock.model.RemoteConfig.f97054c     // Catch: java.lang.Throwable -> L12
            boolean r3 = r4.f97092c     // Catch: java.lang.Throwable -> L12
            r4.f97090a = r5     // Catch: java.lang.Throwable -> L12
            r4.f97091b = r2     // Catch: java.lang.Throwable -> L12
            java.lang.Object r5 = cz.mobilesoft.coreblock.model.RemoteConfig.b(r1, r3, r4)     // Catch: java.lang.Throwable -> L12
            if (r5 != r0) goto L5c
        L5b:
            return r0
        L5c:
            cz.mobilesoft.coreblock.util.RemoteConfigSignal r5 = cz.mobilesoft.coreblock.util.RemoteConfigSignal.f127906a
            r5.b()
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L64:
            cz.mobilesoft.coreblock.util.RemoteConfigSignal r0 = cz.mobilesoft.coreblock.util.RemoteConfigSignal.f127906a
            r0.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.model.RemoteConfig$initAndFetch$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RemoteConfig$initAndFetch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
