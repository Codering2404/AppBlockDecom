package cz.mobilesoft.coreblock.service.receiver;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver$onReceive$1$1", f = "GeofenceTransitionReceiver.kt", l = {47, 48, 58, 59, 72}, m = "invokeSuspend", v = 1)
final class GeofenceTransitionReceiver$onReceive$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f123579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f123580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f123581d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f123582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f123583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ GeofenceTransitionReceiver f123584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Intent f123585i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GeofenceTransitionReceiver$onReceive$1$1(GeofenceTransitionReceiver geofenceTransitionReceiver, Intent intent, Continuation continuation) {
        super(2, continuation);
        this.f123584h = geofenceTransitionReceiver;
        this.f123585i = intent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GeofenceTransitionReceiver$onReceive$1$1(this.f123584h, this.f123585i, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f3, code lost:
    
        if (r3.d(r4, r11, r6, r10) != r0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x015b, code lost:
    
        if (r7.o(r3, r6, r10) == r0) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0103  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.GeofenceTransitionReceiver$onReceive$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GeofenceTransitionReceiver$onReceive$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
