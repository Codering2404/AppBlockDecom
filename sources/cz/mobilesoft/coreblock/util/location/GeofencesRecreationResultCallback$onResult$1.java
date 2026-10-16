package cz.mobilesoft.coreblock.util.location;

import com.google.android.gms.common.api.Status;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback$onResult$1", f = "GeofencesRecreationResultCallback.kt", l = {21, 22}, m = "invokeSuspend", v = 1)
final class GeofencesRecreationResultCallback$onResult$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Status f128770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GeofencesRecreationResultCallback f128771c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GeofencesRecreationResultCallback$onResult$1(Status status, GeofencesRecreationResultCallback geofencesRecreationResultCallback, Continuation continuation) {
        super(1, continuation);
        this.f128770b = status;
        this.f128771c = geofencesRecreationResultCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new GeofencesRecreationResultCallback$onResult$1(this.f128770b, this.f128771c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
    
        if (r6.L0(r3, r5) == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f128769a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L56
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)
            goto L43
        L1e:
            kotlin.ResultKt.b(r6)
            com.google.android.gms.common.api.Status r6 = r5.f128770b
            int r6 = r6.O()
            r1 = -1
            if (r6 == r1) goto L66
            com.google.android.gms.common.api.Status r6 = r5.f128770b
            boolean r6 = r6.w0()
            if (r6 != 0) goto L33
            goto L66
        L33:
            cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback r6 = r5.f128771c
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r6 = cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback.d(r6)
            r5.f128769a = r3
            r1 = 0
            java.lang.Object r6 = r6.P0(r1, r5)
            if (r6 != r0) goto L43
            goto L55
        L43:
            cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback r6 = r5.f128771c
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r6 = cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback.d(r6)
            long r3 = java.lang.System.currentTimeMillis()
            r5.f128769a = r2
            java.lang.Object r6 = r6.L0(r3, r5)
            if (r6 != r0) goto L56
        L55:
            return r0
        L56:
            java.lang.Class<cz.mobilesoft.coreblock.util.location.GeofenceHelper> r6 = cz.mobilesoft.coreblock.util.location.GeofenceHelper.class
            java.lang.String r6 = r6.getSimpleName()
            java.lang.String r0 = "All geofences successfully recreated"
            int r6 = android.util.Log.d(r6, r0)
            kotlin.coroutines.jvm.internal.Boxing.d(r6)
            goto L69
        L66:
            cz.mobilesoft.coreblock.util.runnability.JobHelper.x()
        L69:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback$onResult$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((GeofencesRecreationResultCallback$onResult$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
