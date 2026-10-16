package cz.mobilesoft.coreblock.service.receiver;

import android.content.Context;
import android.location.LocationManager;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$onReceive$1$1", f = "LocationProviderChangedReceiver.kt", l = {75, 78, 84, 87, 88, 95, 96, 97, 100, 101}, m = "invokeSuspend", v = 1)
final class LocationProviderChangedReceiver$onReceive$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f123621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f123622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f123623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LocationProviderChangedReceiver f123624d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LocationManager f123625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Context f123626g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationProviderChangedReceiver$onReceive$1$1(LocationProviderChangedReceiver locationProviderChangedReceiver, LocationManager locationManager, Context context, Continuation continuation) {
        super(2, continuation);
        this.f123624d = locationProviderChangedReceiver;
        this.f123625f = locationManager;
        this.f123626g = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LocationProviderChangedReceiver$onReceive$1$1(this.f123624d, this.f123625f, this.f123626g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ef, code lost:
    
        if (r8.P0(false, r7) == r0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x013d, code lost:
    
        if (r8.e(r4, true, r7) != r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x017b, code lost:
    
        if (r8.P0(true, r7) != r0) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d6 A[PHI: r1 r4 r8
      0x00d6: PHI (r1v10 boolean) = (r1v8 boolean), (r1v12 boolean) binds: [B:31:0x00d2, B:12:0x003d] A[DONT_GENERATE, DONT_INLINE]
      0x00d6: PHI (r4v6 boolean) = (r4v4 boolean), (r4v7 boolean) binds: [B:31:0x00d2, B:12:0x003d] A[DONT_GENERATE, DONT_INLINE]
      0x00d6: PHI (r8v18 java.lang.Object) = (r8v17 java.lang.Object), (r8v0 java.lang.Object) binds: [B:31:0x00d2, B:12:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a A[PHI: r1 r2
      0x012a: PHI (r1v15 boolean) = (r1v13 boolean), (r1v17 boolean) binds: [B:46:0x0127, B:9:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x012a: PHI (r2v9 boolean) = (r2v7 boolean), (r2v10 boolean) binds: [B:46:0x0127, B:9:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$onReceive$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LocationProviderChangedReceiver$onReceive$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
