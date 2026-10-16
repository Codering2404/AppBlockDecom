package cz.mobilesoft.appblock.service;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2", f = "BeforeProfilePauseEndNotificationService.kt", l = {84, 87, 93, 99}, m = "invokeSuspend", v = 1)
final class BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f94046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f94047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f94048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BeforeProfilePauseEndNotificationService f94049d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f94050f;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2$1", f = "BeforeProfilePauseEndNotificationService.kt", l = {141}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f94052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Profile f94053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ BeforeProfilePauseEndNotificationService f94054d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f94055f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ NotificationCompat.Builder f94056g;

        /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2$1$1", f = "BeforeProfilePauseEndNotificationService.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class C02571 extends SuspendLambda implements Function2<Long, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f94057a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ BeforeProfilePauseEndNotificationService f94058b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f94059c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02571(BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService, long j3, Continuation continuation) {
                super(2, continuation);
                this.f94058b = beforeProfilePauseEndNotificationService;
                this.f94059c = j3;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C02571(this.f94058b, this.f94059c, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Long l3, Continuation continuation) {
                return ((C02571) create(l3, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.f94057a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Boxing.a(this.f94058b.f94040c.contains(Boxing.e(this.f94059c)));
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2$1$2", f = "BeforeProfilePauseEndNotificationService.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f94060a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f94061b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ BeforeProfilePauseEndNotificationService f94062c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f94063d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ CoroutineScope f94064f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ NotificationCompat.Builder f94065g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService, long j3, CoroutineScope coroutineScope, NotificationCompat.Builder builder, Continuation continuation) {
                super(2, continuation);
                this.f94062c = beforeProfilePauseEndNotificationService;
                this.f94063d = j3;
                this.f94064f = coroutineScope;
                this.f94065g = builder;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f94062c, this.f94063d, this.f94064f, this.f94065g, continuation);
                anonymousClass2.f94061b = obj;
                return anonymousClass2;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Long l3, Continuation continuation) {
                return ((AnonymousClass2) create(l3, continuation)).invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Long l3 = (Long) this.f94061b;
                IntrinsicsKt.f();
                if (this.f94060a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                if (l3 == null || l3.longValue() == 0) {
                    this.f94062c.f94040c.remove(Boxing.e(this.f94063d));
                    if (this.f94062c.f94040c.isEmpty()) {
                        CoroutineScopeKt.e(this.f94064f, null, 1, null);
                        this.f94062c.E();
                    }
                } else if (!this.f94062c.f94040c.isEmpty() && ((Number) this.f94062c.f94040c.get(0)).longValue() == this.f94063d && ContextCompat.checkSelfPermission(this.f94062c.getApplicationContext(), "android.permission.POST_NOTIFICATIONS") == 0) {
                    this.f94065g.m(this.f94062c.getApplicationContext().getResources().getString(R.string.schedule_pause_end_notification_text, DateHelper.e(l3.longValue() / ((long) 1000))));
                    this.f94062c.w().f(this.f94062c.g(), this.f94065g.c());
                }
                return Unit.f139807a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Profile profile, BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService, long j3, NotificationCompat.Builder builder, Continuation continuation) {
            super(2, continuation);
            this.f94053c = profile;
            this.f94054d = beforeProfilePauseEndNotificationService;
            this.f94055f = j3;
            this.f94056g = builder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit q(BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService, NotificationCompat.Builder builder, Throwable th) {
            if (beforeProfilePauseEndNotificationService.f94040c.size() > 0) {
                BuildersKt__Builders_commonKt.d(beforeProfilePauseEndNotificationService.f94041d, null, null, new BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2$1$3$1(beforeProfilePauseEndNotificationService, builder, null), 3, null);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f94053c, this.f94054d, this.f94055f, this.f94056g, continuation);
            anonymousClass1.f94052b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope = (CoroutineScope) this.f94052b;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94051a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Job jobQ = FlowKt.Q(FlowKt.V(FlowKt.j0(FlowKt.g(TimeHelperExt.f128663a.a(this.f94053c.y().a(), 1000L)), new C02571(this.f94054d, this.f94055f, null)), new AnonymousClass2(this.f94054d, this.f94055f, coroutineScope, this.f94056g, null)), coroutineScope);
                final BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService = this.f94054d;
                final NotificationCompat.Builder builder = this.f94056g;
                jobQ.invokeOnCompletion(new Function1() { // from class: cz.mobilesoft.appblock.service.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2.AnonymousClass1.q(beforeProfilePauseEndNotificationService, builder, (Throwable) obj2);
                    }
                });
                BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService2 = this.f94054d;
                long j3 = this.f94055f;
                NotificationCompat.Builder builder2 = this.f94056g;
                this.f94052b = coroutineScope;
                this.f94051a = 1;
                if (beforeProfilePauseEndNotificationService2.C(j3, builder2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            AnswersHelper.f128199a.R0();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2(BeforeProfilePauseEndNotificationService beforeProfilePauseEndNotificationService, long j3, Continuation continuation) {
        super(2, continuation);
        this.f94049d = beforeProfilePauseEndNotificationService;
        this.f94050f = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2(this.f94049d, this.f94050f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009e, code lost:
    
        if (cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService.D(r7, r8, null, r14, 2, null) == r0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d4, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r15, r5, r14) == r0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00fa, code lost:
    
        if (cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService.D(r1, r2, null, r14, 2, null) == r0) goto L40;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BeforeProfilePauseEndNotificationService$onStartCommand$onInitializedListener$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
