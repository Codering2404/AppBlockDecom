package cz.mobilesoft.coreblock.service.job;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob$onRunJob$1", f = "GeofenceRecreationJob.kt", l = {38, 40}, m = "invokeSuspend", v = 1)
final class GeofenceRecreationJob$onRunJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f123288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GeofenceRecreationJob f123289c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GeofenceRecreationJob$onRunJob$1(GeofenceRecreationJob geofenceRecreationJob, Continuation continuation) {
        super(2, continuation);
        this.f123289c = geofenceRecreationJob;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GeofenceRecreationJob$onRunJob$1(this.f123289c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0091, code lost:
    
        if (r9.t(r4, r2, r8) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f123288b
            java.lang.String r2 = "access$getContext(...)"
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L29
            if (r1 == r4) goto L21
            if (r1 != r3) goto L19
            java.lang.Object r0 = r8.f123287a
            android.location.LocationManager r0 = (android.location.LocationManager) r0
            kotlin.ResultKt.b(r9)
            goto L94
        L19:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L21:
            java.lang.Object r1 = r8.f123287a
            android.location.LocationManager r1 = (android.location.LocationManager) r1
            kotlin.ResultKt.b(r9)
            goto L75
        L29:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob r9 = r8.f123289c
            android.content.Context r9 = cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob.x(r9)
            java.lang.String r1 = "location"
            java.lang.Object r9 = r9.getSystemService(r1)
            r1 = r9
            android.location.LocationManager r1 = (android.location.LocationManager) r1
            if (r1 == 0) goto L75
            cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob r9 = r8.f123289c
            android.content.Context r9 = cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob.x(r9)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            boolean r9 = cz.mobilesoft.coreblock.util.permissions.PermissionHelperExtKt.b(r1, r9)
            if (r9 == 0) goto L75
            java.lang.Class<cz.mobilesoft.coreblock.util.location.GeofenceHelper> r9 = cz.mobilesoft.coreblock.util.location.GeofenceHelper.class
            java.lang.String r9 = r9.getSimpleName()
            java.lang.String r5 = "GPS location enabled"
            android.util.Log.d(r9, r5)
            cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver$Companion r9 = cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver.f123562h
            cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob r5 = r8.f123289c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r5 = cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob.z(r5)
            cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob r6 = r8.f123289c
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r6 = cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob.y(r6)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r8.f123287a = r7
            r8.f123288b = r4
            r4 = 0
            java.lang.Object r9 = r9.d(r5, r4, r6, r8)
            if (r9 != r0) goto L75
            goto L93
        L75:
            cz.mobilesoft.coreblock.util.location.GeofenceHelper r9 = cz.mobilesoft.coreblock.util.location.GeofenceHelper.f128735a
            cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob r4 = r8.f123289c
            android.content.Context r4 = cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob.x(r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback r2 = new cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback
            r2.<init>()
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r8.f123287a = r1
            r8.f123288b = r3
            java.lang.Object r9 = r9.t(r4, r2, r8)
            if (r9 != r0) goto L94
        L93:
            return r0
        L94:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.GeofenceRecreationJob$onRunJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GeofenceRecreationJob$onRunJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
