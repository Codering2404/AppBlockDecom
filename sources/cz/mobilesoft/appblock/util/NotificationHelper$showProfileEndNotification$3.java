package cz.mobilesoft.appblock.util;

import android.content.Context;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.util.NotificationHelper$showProfileEndNotification$3", f = "NotificationHelper.kt", l = {103, 105, 114, 116, 132}, m = "invokeSuspend", v = 1)
final class NotificationHelper$showProfileEndNotification$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f95126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f95127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f95128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f95129d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f95130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f95131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f95132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Profile f95133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ long f95134j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ boolean f95135k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ boolean f95136l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ Context f95137m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ boolean f95138n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationHelper$showProfileEndNotification$3(Profile profile, long j3, boolean z2, boolean z3, Context context, boolean z4, Continuation continuation) {
        super(1, continuation);
        this.f95133i = profile;
        this.f95134j = j3;
        this.f95135k = z2;
        this.f95136l = z3;
        this.f95137m = context;
        this.f95138n = z4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new NotificationHelper$showProfileEndNotification$3(this.f95133i, this.f95134j, this.f95135k, this.f95136l, this.f95137m, this.f95138n, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b8, code lost:
    
        if (r13 == r6) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d7, code lost:
    
        if (r13 == r6) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0171, code lost:
    
        if (r0 == r6) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x024d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.util.NotificationHelper$showProfileEndNotification$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((NotificationHelper$showProfileEndNotification$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
