package cz.mobilesoft.coreblock.service.receiver;

import android.content.Context;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$scheduleLocationCheckRetry$1", f = "LocationProviderChangedReceiver.kt", l = {115, 122, 123, 127, 133, 134}, m = "invokeSuspend", v = 1)
final class LocationProviderChangedReceiver$scheduleLocationCheckRetry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f123632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f123633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LocationProviderChangedReceiver f123634d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationProviderChangedReceiver$scheduleLocationCheckRetry$1(Context context, LocationProviderChangedReceiver locationProviderChangedReceiver, Continuation continuation) {
        super(2, continuation);
        this.f123633c = context;
        this.f123634d = locationProviderChangedReceiver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LocationProviderChangedReceiver$scheduleLocationCheckRetry$1(this.f123633c, this.f123634d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009d, code lost:
    
        if (r6.P0(false, r5) == r0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ed, code lost:
    
        if (r6.d(r3, true, r5) != r0) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.LocationProviderChangedReceiver$scheduleLocationCheckRetry$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LocationProviderChangedReceiver$scheduleLocationCheckRetry$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
