package cz.mobilesoft.coreblock.util.notifications;

import android.app.Notification;
import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import com.google.firebase.messaging.RemoteMessage;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.notifications.NotificationHelper$showNotificationFromFCM$1$1", f = "NotificationHelper.kt", l = {346}, m = "invokeSuspend", v = 1)
final class NotificationHelper$showNotificationFromFCM$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f128942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f128943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f128944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f128945d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f128946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f128947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f128948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f128949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f128950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f128951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f128952l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f128953m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ RemoteMessage f128954n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ Context f128955o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ RemoteMessage.Notification f128956p;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.notifications.NotificationHelper$showNotificationFromFCM$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.notifications.NotificationHelper$showNotificationFromFCM$1$1$1", f = "NotificationHelper.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NotificationManagerCompat f128958b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Notification f128959c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NotificationManagerCompat notificationManagerCompat, Notification notification, Continuation continuation) {
            super(2, continuation);
            this.f128958b = notificationManagerCompat;
            this.f128959c = notification;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f128958b, this.f128959c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f128957a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f128958b.f(10004, this.f128959c);
            AnswersHelper.f128199a.P1();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NotificationHelper$showNotificationFromFCM$1$1(RemoteMessage remoteMessage, Context context, RemoteMessage.Notification notification, Continuation continuation) {
        super(1, continuation);
        this.f128954n = remoteMessage;
        this.f128955o = context;
        this.f128956p = notification;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new NotificationHelper$showNotificationFromFCM$1$1(this.f128954n, this.f128955o, this.f128956p, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x01c0 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 452
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.notifications.NotificationHelper$showNotificationFromFCM$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((NotificationHelper$showNotificationFromFCM$1$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
