package cz.mobilesoft.coreblock.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.SingularCallbackHandler$onDeeplinkReceived$1", f = "SingularCallbackHandler.kt", l = {32, 32}, m = "invokeSuspend", v = 1)
final class SingularCallbackHandler$onDeeplinkReceived$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f128007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f128008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f128009c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SingularCallbackHandler$onDeeplinkReceived$1(boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f128009c = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SingularCallbackHandler$onDeeplinkReceived$1(this.f128009c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
    
        if (r1.L5(r3, r4) == r0) goto L21;
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
            int r1 = r4.f128008b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L58
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            java.lang.Object r1 = r4.f128007a
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r1 = (cz.mobilesoft.coreblock.storage.datastore.CoreDataStore) r1
            kotlin.ResultKt.b(r5)
            goto L3e
        L22:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.util.SingularCallbackHandler r5 = cz.mobilesoft.coreblock.util.SingularCallbackHandler.f127992a
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r1 = cz.mobilesoft.coreblock.util.SingularCallbackHandler.a(r5)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r5 = cz.mobilesoft.coreblock.util.SingularCallbackHandler.a(r5)
            kotlinx.coroutines.flow.Flow r5 = r5.K3()
            r4.f128007a = r1
            r4.f128008b = r3
            java.lang.Object r5 = kotlinx.coroutines.flow.FlowKt.D(r5, r4)
            if (r5 != r0) goto L3e
            goto L57
        L3e:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L4b
            boolean r5 = r4.f128009c
            if (r5 != 0) goto L4b
            goto L4c
        L4b:
            r3 = 0
        L4c:
            r5 = 0
            r4.f128007a = r5
            r4.f128008b = r2
            java.lang.Object r5 = r1.L5(r3, r4)
            if (r5 != r0) goto L58
        L57:
            return r0
        L58:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.SingularCallbackHandler$onDeeplinkReceived$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SingularCallbackHandler$onDeeplinkReceived$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
