package cz.mobilesoft.coreblock.service.receiver;

import android.content.Context;
import android.content.Intent;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver$onReceive$1$1", f = "NetworkStateChangedReceiver.kt", l = {53, 69, 76, 85, 102}, m = "invokeSuspend", v = 1)
final class NetworkStateChangedReceiver$onReceive$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f123694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f123695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f123696d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f123697f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f123698g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Intent f123699h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f123700i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ NetworkStateChangedReceiver f123701j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkStateChangedReceiver$onReceive$1$1(Intent intent, Context context, NetworkStateChangedReceiver networkStateChangedReceiver, Continuation continuation) {
        super(2, continuation);
        this.f123699h = intent;
        this.f123700i = context;
        this.f123701j = networkStateChangedReceiver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NetworkStateChangedReceiver$onReceive$1$1(this.f123699h, this.f123700i, this.f123701j, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
    
        if (r0.equals("android.net.wifi.STATE_CHANGE") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bb, code lost:
    
        if (r0 == r9) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00db, code lost:
    
        if (r0.equals("android.net.wifi.WIFI_STATE_CHANGED") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00df, code lost:
    
        r8 = (android.net.NetworkInfo) r16.f123699h.getParcelableExtra("networkInfo");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ea, code lost:
    
        if (r8 == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f0, code lost:
    
        if (1 != r8.getType()) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f2, code lost:
    
        r14 = r16.f123699h.getIntExtra("wifi_state", 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fa, code lost:
    
        if (r8 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0100, code lost:
    
        if (r8.isConnected() != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0102, code lost:
    
        if (r14 != 3) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0104, code lost:
    
        r0 = cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver.f123659g;
        r1 = r16.f123700i;
        r3 = r16.f123701j.u();
        r4 = r16.f123701j.t();
        r7 = r16.f123701j.s();
        r16.f123693a = kotlin.coroutines.jvm.internal.SpillingKt.a(r8);
        r16.f123696d = r14;
        r16.f123698g = 2;
        r0 = r0.a(r1, r3, r4, r7, r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x012b, code lost:
    
        if (r0 != r9) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012f, code lost:
    
        r1 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x014c, code lost:
    
        if (r2.r(r3, r16) == r9) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0150, code lost:
    
        if (r8 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0156, code lost:
    
        if (r8.isConnectedOrConnecting() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0158, code lost:
    
        if (r14 != 1) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0160, code lost:
    
        if (cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver.f123663k == 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x016d, code lost:
    
        if ((java.lang.System.currentTimeMillis() - cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver.f123663k) > 500) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0171, code lost:
    
        return kotlin.Unit.f139807a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0172, code lost:
    
        cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver.f123663k = java.lang.System.currentTimeMillis();
        cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver.f123662j = "";
        r0 = cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver.f123659g;
        r1 = r16.f123701j.u();
        r2 = r16.f123701j.t();
        r4 = r16.f123701j.f123667a;
        r6 = r16.f123701j.s();
        r16.f123693a = kotlin.coroutines.jvm.internal.SpillingKt.a(r8);
        r16.f123696d = r14;
        r16.f123698g = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01ad, code lost:
    
        if (cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver.Companion.e(r0, r1, r2, null, r4, r6, r16, 4, null) != r9) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x021c, code lost:
    
        if (r0.d(r6, r7, r3, r8, r10, r16) == r9) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x021e, code lost:
    
        return r9;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.NetworkStateChangedReceiver$onReceive$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NetworkStateChangedReceiver$onReceive$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
