package cz.mobilesoft.appblock.util;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.util.NotificationHelper$showProfileEndNotification$1", f = "NotificationHelper.kt", l = {47, 48}, m = "invokeSuspend", v = 1)
final class NotificationHelper$showProfileEndNotification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f95110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f95111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f95112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f95113d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f95114f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f95115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ long f95116h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Context f95117i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationHelper$showProfileEndNotification$1(long j3, Context context, Continuation continuation) {
        super(2, continuation);
        this.f95116h = j3;
        this.f95117i = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NotificationHelper$showProfileEndNotification$1(this.f95116h, this.f95117i, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f95115g
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L30
            if (r2 != r3) goto L28
            java.lang.Object r1 = r0.f95113d
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r1 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval) r1
            java.lang.Object r2 = r0.f95112c
            android.content.Context r2 = (android.content.Context) r2
            java.lang.Object r3 = r0.f95111b
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r3 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao) r3
            java.lang.Object r3 = r0.f95110a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r3 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao) r3
            kotlin.ResultKt.b(r18)
            r7 = r2
            r2 = r18
            goto L86
        L28:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L30:
            java.lang.Object r2 = r0.f95111b
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r2 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao) r2
            java.lang.Object r4 = r0.f95110a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r4 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao) r4
            kotlin.ResultKt.b(r18)
            r6 = r4
            r4 = r18
            goto L67
        L3f:
            kotlin.ResultKt.b(r18)
            java.lang.Class<cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao> r2 = cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.class
            r6 = 6
            java.lang.Object r2 = org.koin.java.KoinJavaComponent.c(r2, r5, r5, r6, r5)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r2 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao) r2
            java.lang.Class<cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao> r7 = cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao.class
            java.lang.Object r6 = org.koin.java.KoinJavaComponent.c(r7, r5, r5, r6, r5)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao) r6
            long r7 = r0.f95116h
            r0.f95110a = r2
            r0.f95111b = r6
            r0.f95115g = r4
            java.lang.Object r4 = r6.e(r7, r0)
            if (r4 != r1) goto L62
            goto L84
        L62:
            r16 = r6
            r6 = r2
            r2 = r16
        L67:
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r4 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval) r4
            if (r4 == 0) goto L9d
            android.content.Context r7 = r0.f95117i
            long r8 = r4.g()
            r0.f95110a = r6
            r0.f95111b = r2
            r0.f95112c = r7
            r0.f95113d = r4
            r2 = 0
            r0.f95114f = r2
            r0.f95115g = r3
            java.lang.Object r2 = r6.e(r8, r0)
            if (r2 != r1) goto L85
        L84:
            return r1
        L85:
            r1 = r4
        L86:
            r8 = r2
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r8 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r8
            if (r8 == 0) goto L9d
            cz.mobilesoft.appblock.util.NotificationHelper r6 = cz.mobilesoft.appblock.util.NotificationHelper.f95109a
            long r9 = cz.mobilesoft.coreblock.util.helperextension.DateHelper.f(r1)
            r14 = 40
            r15 = 0
            r11 = 0
            r12 = 1
            r13 = 0
            cz.mobilesoft.appblock.util.NotificationHelper.f(r6, r7, r8, r9, r11, r12, r13, r14, r15)
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        L9d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.util.NotificationHelper$showProfileEndNotification$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NotificationHelper$showProfileEndNotification$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
