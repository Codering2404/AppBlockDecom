package cz.mobilesoft.coreblock.util.location;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.location.GeofenceHelper", f = "GeofenceHelper.kt", l = {124, 125, 129}, m = "removeGeofenceForProfile", v = 1)
final class GeofenceHelper$removeGeofenceForProfile$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f128753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f128754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f128755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f128756d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f128757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    /* synthetic */ Object f128758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ GeofenceHelper f128759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f128760i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GeofenceHelper$removeGeofenceForProfile$1(GeofenceHelper geofenceHelper, Continuation continuation) {
        super(continuation);
        this.f128759h = geofenceHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f128758g = obj;
        this.f128760i |= Integer.MIN_VALUE;
        return this.f128759h.z(null, 0L, null, this);
    }
}
