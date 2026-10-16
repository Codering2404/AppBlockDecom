package com.superwall.sdk.analytics.internal;

import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.trackable.Trackable;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.models.events.EventData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

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
public final class TrackingKt {

    /* JADX INFO: renamed from: com.superwall.sdk.analytics.internal.TrackingKt$handleImplicitTrigger$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.analytics.internal.TrackingKt$handleImplicitTrigger$2", f = "Tracking.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Trackable $event;
        final /* synthetic */ EventData $eventData;
        final /* synthetic */ Superwall $this_handleImplicitTrigger;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.analytics.internal.TrackingKt$handleImplicitTrigger$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.analytics.internal.TrackingKt$handleImplicitTrigger$2$1", f = "Tracking.kt", l = {138}, m = "invokeSuspend")
        static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ Trackable $event;
            final /* synthetic */ EventData $eventData;
            final /* synthetic */ Superwall $this_handleImplicitTrigger;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Superwall superwall, Trackable trackable, EventData eventData, Continuation<? super AnonymousClass1> continuation) {
                super(1, continuation);
                this.$this_handleImplicitTrigger = superwall;
                this.$event = trackable;
                this.$eventData = eventData;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new AnonymousClass1(this.$this_handleImplicitTrigger, this.$event, this.$eventData, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Superwall superwall = this.$this_handleImplicitTrigger;
                    Trackable trackable = this.$event;
                    EventData eventData = this.$eventData;
                    this.label = 1;
                    if (TrackingKt.internallyHandleImplicitTrigger(superwall, trackable, eventData, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Superwall superwall, Trackable trackable, EventData eventData, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_handleImplicitTrigger = superwall;
            this.$event = trackable;
            this.$eventData = eventData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_handleImplicitTrigger, this.$event, this.$eventData, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.$this_handleImplicitTrigger.getSerialTaskManager$superwall_release().addTask(new AnonymousClass1(this.$this_handleImplicitTrigger, this.$event, this.$eventData, null));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.analytics.internal.TrackingKt$internallyHandleImplicitTrigger$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.analytics.internal.TrackingKt$internallyHandleImplicitTrigger$2", f = "Tracking.kt", l = {173, 175, 191, 196, 198, 215}, m = "invokeSuspend")
    static final class C27752 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Unit, Throwable>>, Object> {
        final /* synthetic */ Trackable $event;
        final /* synthetic */ EventData $eventData;
        final /* synthetic */ Superwall $this_internallyHandleImplicitTrigger;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27752(EventData eventData, Superwall superwall, Trackable trackable, Continuation<? super C27752> continuation) {
            super(2, continuation);
            this.$eventData = eventData;
            this.$this_internallyHandleImplicitTrigger = superwall;
            this.$event = trackable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C27752(this.$eventData, this.$this_internallyHandleImplicitTrigger, this.$event, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:69:0x01a3, code lost:
        
            if (com.superwall.sdk.paywall.presentation.internal.operators.LogErrorsKt.logErrors(r6, r5, r0, r17) == r2) goto L70;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x010e A[Catch: all -> 0x001a, TryCatch #2 {all -> 0x001a, blocks: (B:6:0x0015, B:71:0x01a6, B:11:0x0029, B:57:0x0163, B:63:0x0179, B:14:0x003a, B:51:0x014c, B:53:0x0152, B:17:0x004e, B:34:0x00e0, B:36:0x010e, B:42:0x0126, B:44:0x012e, B:47:0x013a, B:58:0x0168, B:60:0x0170, B:68:0x0196, B:25:0x0071, B:27:0x00a0), top: B:84:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0126 A[Catch: all -> 0x001a, TryCatch #2 {all -> 0x001a, blocks: (B:6:0x0015, B:71:0x01a6, B:11:0x0029, B:57:0x0163, B:63:0x0179, B:14:0x003a, B:51:0x014c, B:53:0x0152, B:17:0x004e, B:34:0x00e0, B:36:0x010e, B:42:0x0126, B:44:0x012e, B:47:0x013a, B:58:0x0168, B:60:0x0170, B:68:0x0196, B:25:0x0071, B:27:0x00a0), top: B:84:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0152 A[Catch: all -> 0x001a, TryCatch #2 {all -> 0x001a, blocks: (B:6:0x0015, B:71:0x01a6, B:11:0x0029, B:57:0x0163, B:63:0x0179, B:14:0x003a, B:51:0x014c, B:53:0x0152, B:17:0x004e, B:34:0x00e0, B:36:0x010e, B:42:0x0126, B:44:0x012e, B:47:0x013a, B:58:0x0168, B:60:0x0170, B:68:0x0196, B:25:0x0071, B:27:0x00a0), top: B:84:0x000a }] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0193  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 476
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.analytics.internal.TrackingKt.C27752.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<Unit, Throwable>> continuation) {
            return ((C27752) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.analytics.internal.TrackingKt$track$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.analytics.internal.TrackingKt", f = "Tracking.kt", l = {41, 47, 102}, m = "track")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object objTrack = TrackingKt.track(null, null, this);
            return objTrack == IntrinsicsKt.f() ? objTrack : Result.a(objTrack);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.analytics.internal.TrackingKt$trackSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.analytics.internal.TrackingKt$trackSync$1", f = "Tracking.kt", l = {123}, m = "invokeSuspend")
    static final class C27761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends TrackingResult>>, Object> {
        final /* synthetic */ Trackable $event;
        final /* synthetic */ Superwall $this_trackSync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C27761(Superwall superwall, Trackable trackable, Continuation<? super C27761> continuation) {
            super(2, continuation);
            this.$this_trackSync = superwall;
            this.$event = trackable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C27761(this.$this_trackSync, this.$event, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objTrack;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Superwall superwall = this.$this_trackSync;
                Trackable trackable = this.$event;
                this.label = 1;
                objTrack = TrackingKt.track(superwall, trackable, this);
                if (objTrack == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                objTrack = ((Result) obj).j();
            }
            return Result.a(objTrack);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<TrackingResult>> continuation) {
            return ((C27761) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public static final Object handleImplicitTrigger(Superwall superwall, Trackable trackable, EventData eventData, Continuation<? super Unit> continuation) {
        Object objG = BuildersKt.g(Dispatchers.c(), new AnonymousClass2(superwall, trackable, eventData, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object internallyHandleImplicitTrigger(Superwall superwall, Trackable trackable, EventData eventData, Continuation<? super Either<Unit, Throwable>> continuation) {
        return BuildersKt.g(Dispatchers.c(), new C27752(eventData, superwall, trackable, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad A[Catch: all -> 0x0176, TryCatch #0 {all -> 0x0176, blocks: (B:14:0x0035, B:54:0x016b, B:19:0x004e, B:32:0x00a7, B:34:0x00ad, B:35:0x00e0, B:37:0x00ff, B:39:0x0105, B:41:0x010f, B:44:0x0122, B:46:0x0132, B:47:0x013d, B:49:0x0152, B:22:0x005c, B:28:0x007d, B:25:0x0065), top: B:72:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0132 A[Catch: all -> 0x0176, TryCatch #0 {all -> 0x0176, blocks: (B:14:0x0035, B:54:0x016b, B:19:0x004e, B:32:0x00a7, B:34:0x00ad, B:35:0x00e0, B:37:0x00ff, B:39:0x0105, B:41:0x010f, B:44:0x0122, B:46:0x0132, B:47:0x013d, B:49:0x0152, B:22:0x005c, B:28:0x007d, B:25:0x0065), top: B:72:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0152 A[Catch: all -> 0x0176, TryCatch #0 {all -> 0x0176, blocks: (B:14:0x0035, B:54:0x016b, B:19:0x004e, B:32:0x00a7, B:34:0x00ad, B:35:0x00e0, B:37:0x00ff, B:39:0x0105, B:41:0x010f, B:44:0x0122, B:46:0x0132, B:47:0x013d, B:49:0x0152, B:22:0x005c, B:28:0x007d, B:25:0x0065), top: B:72:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object track(com.superwall.sdk.Superwall r20, com.superwall.sdk.analytics.internal.trackable.Trackable r21, kotlin.coroutines.Continuation<? super kotlin.Result<com.superwall.sdk.analytics.internal.TrackingResult>> r22) {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.analytics.internal.TrackingKt.track(com.superwall.sdk.Superwall, com.superwall.sdk.analytics.internal.trackable.Trackable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object trackSync(Superwall superwall, Trackable event) {
        Intrinsics.checkNotNullParameter(superwall, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        return ((Result) BuildersKt__BuildersKt.b(null, new C27761(superwall, event, null), 1, null)).j();
    }
}
