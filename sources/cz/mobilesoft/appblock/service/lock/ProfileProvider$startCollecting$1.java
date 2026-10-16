package cz.mobilesoft.appblock.service.lock;

import android.util.Log;
import cz.mobilesoft.coreblock.rest.exception.CustomDatabaseLockedException;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1", f = "ProfileProvider.kt", l = {138}, m = "invokeSuspend", v = 1)
final class ProfileProvider$startCollecting$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f94898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f94899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f94900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f94901d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ProfileProvider f94902f;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProfileProvider f94903a;

        /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$2$2", f = "ProfileProvider.kt", l = {148}, m = "invokeSuspend", v = 1)
        static final class C02622 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f94904a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ProfileProvider f94905b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02622(ProfileProvider profileProvider, Continuation continuation) {
                super(1, continuation);
                this.f94905b = profileProvider;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation) {
                return new C02622(this.f94905b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f94904a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    EventDataStore eventDataStoreK = this.f94905b.k();
                    long jF = TimeHelperExt.f128663a.f();
                    this.f94904a = 1;
                    if (eventDataStoreK.e2(jF, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                Log.d("ProfileProvider", "LockService ready event sent");
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation continuation) {
                return ((C02622) create(continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass2(ProfileProvider profileProvider) {
            this.f94903a = profileProvider;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(java.util.List r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$2$emit$1
                if (r0 == 0) goto L13
                r0 = r8
                cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$2$emit$1 r0 = (cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$2$emit$1) r0
                int r1 = r0.f94909d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f94909d = r1
                goto L18
            L13:
                cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$2$emit$1 r0 = new cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$2$emit$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f94907b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f94909d
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r7 = r0.f94906a
                java.util.List r7 = (java.util.List) r7
                kotlin.ResultKt.b(r8)
                goto L4d
            L2d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L35:
                kotlin.ResultKt.b(r8)
                cz.mobilesoft.appblock.service.lock.ProfileProvider r8 = r6.f94903a
                cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r8 = cz.mobilesoft.appblock.service.lock.ProfileProvider.b(r8)
                long r4 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.c()
                r0.f94906a = r7
                r0.f94909d = r3
                java.lang.Object r8 = r8.M0(r4, r0)
                if (r8 != r1) goto L4d
                return r1
            L4d:
                cz.mobilesoft.appblock.service.lock.ProfileProvider r8 = r6.f94903a
                boolean r8 = r8.p()
                cz.mobilesoft.appblock.service.lock.ProfileProvider r0 = r6.f94903a
                cz.mobilesoft.appblock.service.lock.ProfileProvider.g(r0, r3)
                r0 = r7
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r1 = new java.util.ArrayList
                r2 = 10
                int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
                r1.<init>(r2)
                java.util.Iterator r0 = r0.iterator()
            L6a:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L8b
                java.lang.Object r2 = r0.next()
                cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r2 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration) r2
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                java.lang.String r2 = "\n"
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r1.add(r2)
                goto L6a
            L8b:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Profiles updated: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "ProfileProvider"
                android.util.Log.d(r1, r0)
                cz.mobilesoft.appblock.service.lock.ProfileProvider r0 = r6.f94903a
                cz.mobilesoft.appblock.service.lock.ProfileProvider.h(r0, r7)
                if (r8 != 0) goto Lb3
                cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$2$2 r7 = new cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$2$2
                cz.mobilesoft.appblock.service.lock.ProfileProvider r8 = r6.f94903a
                r0 = 0
                r7.<init>(r8, r0)
                cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt.d(r7)
            Lb3:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1.AnonymousClass2.emit(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileProvider$startCollecting$1(ProfileProvider profileProvider, Continuation continuation) {
        super(2, continuation);
        this.f94902f = profileProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow y(final ProfileProvider profileProvider, Flow flow) {
        return DatabaseExtKt.d(flow, 20, 1000L, new Function1() { // from class: cz.mobilesoft.appblock.service.lock.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ProfileProvider$startCollecting$1.z(profileProvider, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(ProfileProvider profileProvider, Throwable th) {
        CrashHelper crashHelper = CrashHelper.f127788a;
        String message = th.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        crashHelper.h("Error loading profiles in ProfileProvider", new CustomDatabaseLockedException(message));
        BuildersKt__Builders_commonKt.d(profileProvider.f94839a, null, null, new ProfileProvider$startCollecting$1$withDbLockHandling$1$1$1(profileProvider, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ProfileProvider$startCollecting$1(this.f94902f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94901d;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ProfileProvider profileProvider = this.f94902f;
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.appblock.service.lock.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ProfileProvider$startCollecting$1.y(profileProvider, (Flow) obj2);
                }
            };
            Flow flow = (Flow) function1.invoke(this.f94902f.l().Q0());
            final Flow flow2 = this.f94902f.f94848k;
            final ProfileProvider profileProvider2 = this.f94902f;
            Flow flow3 = (Flow) function1.invoke(new Flow<List<? extends ProfileWithConfiguration>>() { // from class: cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1

                /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class AnonymousClass2<T> implements FlowCollector {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f94912a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ ProfileProvider f94913b;

                    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    @Metadata
                    @DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1$2", f = "ProfileProvider.kt", l = {51, 50}, m = "emit", v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        /* synthetic */ Object f94914a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f94915b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        Object f94916c;

                        /* JADX INFO: renamed from: f, reason: collision with root package name */
                        Object f94918f;

                        /* JADX INFO: renamed from: g, reason: collision with root package name */
                        Object f94919g;

                        /* JADX INFO: renamed from: h, reason: collision with root package name */
                        Object f94920h;

                        /* JADX INFO: renamed from: i, reason: collision with root package name */
                        Object f94921i;

                        /* JADX INFO: renamed from: j, reason: collision with root package name */
                        Object f94922j;

                        /* JADX INFO: renamed from: k, reason: collision with root package name */
                        Object f94923k;

                        /* JADX INFO: renamed from: l, reason: collision with root package name */
                        int f94924l;

                        /* JADX INFO: renamed from: m, reason: collision with root package name */
                        int f94925m;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f94914a = obj;
                            this.f94915b |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, ProfileProvider profileProvider) {
                        this.f94912a = flowCollector;
                        this.f94913b = profileProvider;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a9, code lost:
                    
                        if (r2.emit(r4, r0) == r1) goto L22;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
                        /*
                            r9 = this;
                            boolean r0 = r11 instanceof cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r11
                            cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1$2$1 r0 = (cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f94915b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f94915b = r1
                            goto L18
                        L13:
                            cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1$2$1 r0 = new cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r11)
                        L18:
                            java.lang.Object r11 = r0.f94914a
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r2 = r0.f94915b
                            r3 = 2
                            r4 = 1
                            if (r2 == 0) goto L61
                            if (r2 == r4) goto L3d
                            if (r2 != r3) goto L35
                            java.lang.Object r10 = r0.f94920h
                            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                            java.lang.Object r10 = r0.f94918f
                            cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1$2$1 r10 = (cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r10
                            kotlin.ResultKt.b(r11)
                            goto Lac
                        L35:
                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                            r10.<init>(r11)
                            throw r10
                        L3d:
                            int r10 = r0.f94924l
                            java.lang.Object r2 = r0.f94923k
                            kotlin.Unit r2 = (kotlin.Unit) r2
                            java.lang.Object r2 = r0.f94922j
                            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                            java.lang.Object r2 = r0.f94921i
                            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                            java.lang.Object r4 = r0.f94920h
                            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                            java.lang.Object r5 = r0.f94919g
                            java.lang.Object r6 = r0.f94918f
                            cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1$2$1 r6 = (cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r6
                            java.lang.Object r7 = r0.f94916c
                            kotlin.ResultKt.b(r11)
                            r8 = r11
                            r11 = r10
                            r10 = r7
                            r7 = r6
                            r6 = r4
                            r4 = r8
                            goto L92
                        L61:
                            kotlin.ResultKt.b(r11)
                            kotlinx.coroutines.flow.FlowCollector r2 = r9.f94912a
                            r11 = r10
                            kotlin.Unit r11 = (kotlin.Unit) r11
                            cz.mobilesoft.appblock.service.lock.ProfileProvider r5 = r9.f94913b
                            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r5 = cz.mobilesoft.appblock.service.lock.ProfileProvider.e(r5)
                            kotlinx.coroutines.flow.Flow r5 = r5.Q0()
                            r0.f94916c = r10
                            r0.f94918f = r0
                            r0.f94919g = r10
                            r0.f94920h = r2
                            r0.f94921i = r2
                            r0.f94922j = r0
                            r0.f94923k = r11
                            r11 = 0
                            r0.f94924l = r11
                            r0.f94925m = r11
                            r0.f94915b = r4
                            java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.D(r5, r0)
                            if (r4 != r1) goto L8f
                            goto Lab
                        L8f:
                            r5 = r10
                            r7 = r0
                            r6 = r2
                        L92:
                            r0.f94916c = r10
                            r0.f94918f = r7
                            r0.f94919g = r5
                            r0.f94920h = r6
                            r10 = 0
                            r0.f94921i = r10
                            r0.f94922j = r10
                            r0.f94923k = r10
                            r0.f94924l = r11
                            r0.f94915b = r3
                            java.lang.Object r10 = r2.emit(r4, r0)
                            if (r10 != r1) goto Lac
                        Lab:
                            return r1
                        Lac:
                            kotlin.Unit r10 = kotlin.Unit.f139807a
                            return r10
                        */
                        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector flowCollector, Continuation continuation) {
                    Object objCollect = flow2.collect(new AnonymousClass2(flowCollector, profileProvider2), continuation);
                    return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
                }
            });
            final Flow flowT = FlowKt.T(flow, flow3);
            Flow flowU = FlowKt.u(new Flow<List<? extends ProfileWithConfiguration>>() { // from class: cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2

                /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2$2, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public static final class AnonymousClass2<T> implements FlowCollector {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f94927a;

                    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2$2$1, reason: invalid class name */
                    @Metadata
                    @DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2$2", f = "ProfileProvider.kt", l = {50}, m = "emit", v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        /* synthetic */ Object f94928a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        int f94929b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        Object f94930c;

                        /* JADX INFO: renamed from: f, reason: collision with root package name */
                        Object f94932f;

                        /* JADX INFO: renamed from: g, reason: collision with root package name */
                        Object f94933g;

                        /* JADX INFO: renamed from: h, reason: collision with root package name */
                        Object f94934h;

                        /* JADX INFO: renamed from: i, reason: collision with root package name */
                        int f94935i;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.f94928a = obj;
                            this.f94929b |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.f94927a = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
                        /*
                            r5 = this;
                            boolean r0 = r7 instanceof cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r7
                            cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2$2$1 r0 = (cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.f94929b
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f94929b = r1
                            goto L18
                        L13:
                            cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2$2$1 r0 = new cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2$2$1
                            r0.<init>(r7)
                        L18:
                            java.lang.Object r7 = r0.f94928a
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                            int r2 = r0.f94929b
                            r3 = 1
                            if (r2 == 0) goto L39
                            if (r2 != r3) goto L31
                            java.lang.Object r6 = r0.f94934h
                            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
                            java.lang.Object r6 = r0.f94932f
                            cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2$2$1 r6 = (cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2.AnonymousClass2.AnonymousClass1) r6
                            kotlin.ResultKt.b(r7)
                            goto L60
                        L31:
                            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                            r6.<init>(r7)
                            throw r6
                        L39:
                            kotlin.ResultKt.b(r7)
                            kotlinx.coroutines.flow.FlowCollector r7 = r5.f94927a
                            r2 = r6
                            java.util.List r2 = (java.util.List) r2
                            java.lang.Iterable r2 = (java.lang.Iterable) r2
                            cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$lambda$2$$inlined$sortedBy$1 r4 = new cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$lambda$2$$inlined$sortedBy$1
                            r4.<init>()
                            java.util.List r2 = kotlin.collections.CollectionsKt.sortedWith(r2, r4)
                            r0.f94930c = r6
                            r0.f94932f = r0
                            r0.f94933g = r6
                            r0.f94934h = r7
                            r6 = 0
                            r0.f94935i = r6
                            r0.f94929b = r3
                            java.lang.Object r6 = r7.emit(r2, r0)
                            if (r6 != r1) goto L60
                            return r1
                        L60:
                            kotlin.Unit r6 = kotlin.Unit.f139807a
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$invokeSuspend$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector flowCollector, Continuation continuation) {
                    Object objCollect = flowT.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
                }
            });
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f94902f);
            this.f94898a = function1;
            this.f94899b = flow;
            this.f94900c = flow3;
            this.f94901d = 1;
            if (flowU.collect(anonymousClass2, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ProfileProvider$startCollecting$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
