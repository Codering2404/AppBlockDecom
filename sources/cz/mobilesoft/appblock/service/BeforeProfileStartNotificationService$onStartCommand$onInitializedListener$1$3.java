package cz.mobilesoft.appblock.service;

import android.content.IntentFilter;
import android.os.CountDownTimer;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService.NotificationDismissed;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3", f = "BeforeProfileStartNotificationService.kt", l = {116, 119, 123, 126, 130, 138, 143, 145}, m = "invokeSuspend", v = 1)
final class BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f94096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f94097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f94098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f94099d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f94100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f94101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f94102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f94103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f94104j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ BeforeProfileStartNotificationService f94105k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ long f94106l;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3$1", f = "BeforeProfileStartNotificationService.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BeforeProfileStartNotificationService f94108b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BeforeProfileStartNotificationService beforeProfileStartNotificationService, Continuation continuation) {
            super(2, continuation);
            this.f94108b = beforeProfileStartNotificationService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f94108b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f94107a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f94108b.H();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3$2", f = "BeforeProfileStartNotificationService.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BeforeProfileStartNotificationService f94110b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BeforeProfileStartNotificationService beforeProfileStartNotificationService, Continuation continuation) {
            super(2, continuation);
            this.f94110b = beforeProfileStartNotificationService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f94110b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f94109a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f94110b.H();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3$3", f = "BeforeProfileStartNotificationService.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BeforeProfileStartNotificationService f94112b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(BeforeProfileStartNotificationService beforeProfileStartNotificationService, Continuation continuation) {
            super(2, continuation);
            this.f94112b = beforeProfileStartNotificationService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.f94112b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f94111a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f94112b.H();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3$4", f = "BeforeProfileStartNotificationService.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NotificationCompat.Builder f94114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BeforeProfileStartNotificationService f94115c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f94116d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f94117f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(NotificationCompat.Builder builder, BeforeProfileStartNotificationService beforeProfileStartNotificationService, long j3, long j4, Continuation continuation) {
            super(2, continuation);
            this.f94114b = builder;
            this.f94115c = beforeProfileStartNotificationService;
            this.f94116d = j3;
            this.f94117f = j4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass4(this.f94114b, this.f94115c, this.f94116d, this.f94117f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f94113a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f94114b.m(this.f94115c.getApplicationContext().getResources().getString(R.string.time_to_activation, DateHelper.e(this.f94116d / ((long) 1000))));
            if (ContextCompat.checkSelfPermission(this.f94115c.getApplicationContext(), "android.permission.POST_NOTIFICATIONS") == 0) {
                this.f94115c.B().f(10002, this.f94114b.c());
                AnswersHelper.f128199a.S0();
            }
            BeforeProfileStartNotificationService beforeProfileStartNotificationService = this.f94115c;
            long j3 = this.f94116d;
            final BeforeProfileStartNotificationService beforeProfileStartNotificationService2 = this.f94115c;
            final long j4 = this.f94117f;
            final NotificationCompat.Builder builder = this.f94114b;
            CountDownTimer countDownTimer = new CountDownTimer(j3) { // from class: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService.onStartCommand.onInitializedListener.1.3.4.1
                @Override // android.os.CountDownTimer
                public void onFinish() {
                    beforeProfileStartNotificationService2.f94084d.remove(Long.valueOf(j4));
                    if (beforeProfileStartNotificationService2.f94084d.isEmpty()) {
                        beforeProfileStartNotificationService2.H();
                    }
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j5) {
                    if (!beforeProfileStartNotificationService2.f94084d.isEmpty() && ((Number) beforeProfileStartNotificationService2.f94084d.get(0)).longValue() == j4 && ContextCompat.checkSelfPermission(beforeProfileStartNotificationService2.getApplicationContext(), "android.permission.POST_NOTIFICATIONS") == 0) {
                        builder.m(beforeProfileStartNotificationService2.getApplicationContext().getResources().getString(R.string.time_to_activation, DateHelper.e(j5 / ((long) 1000))));
                        beforeProfileStartNotificationService2.B().f(10002, builder.c());
                    }
                }
            };
            countDownTimer.start();
            beforeProfileStartNotificationService.f94090k = countDownTimer;
            if (this.f94115c.f94082b == null) {
                this.f94115c.f94082b = this.f94115c.new NotificationDismissed();
                BeforeProfileStartNotificationService beforeProfileStartNotificationService3 = this.f94115c;
                ContextCompat.registerReceiver(beforeProfileStartNotificationService3, beforeProfileStartNotificationService3.f94082b, new IntentFilter("cz.mobilesoft.NOTIFICATION_DISMISSED"), 4);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3(BeforeProfileStartNotificationService beforeProfileStartNotificationService, long j3, Continuation continuation) {
        super(2, continuation);
        this.f94105k = beforeProfileStartNotificationService;
        this.f94106l = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3(this.f94105k, this.f94106l, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00cd, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r3, r5, r19) == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0112, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r3, r6, r19) == r1) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0177, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r7, r10, r19) == r1) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BeforeProfileStartNotificationService$onStartCommand$onInitializedListener$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
