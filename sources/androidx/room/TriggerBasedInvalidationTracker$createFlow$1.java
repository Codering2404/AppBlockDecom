package androidx.room;

import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1", f = "InvalidationTracker.kt", l = {238, 238, 242}, m = "invokeSuspend")
final class TriggerBasedInvalidationTracker$createFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super Set<? extends String>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f52411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f52412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TriggerBasedInvalidationTracker f52413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int[] f52414d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f52415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String[] f52416g;

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1", f = "InvalidationTracker.kt", l = {238}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f52417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ TriggerBasedInvalidationTracker f52418b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Continuation continuation) {
            super(2, continuation);
            this.f52418b = triggerBasedInvalidationTracker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f52418b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f52417a;
            if (i3 == 0) {
                ResultKt.b(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.f52418b;
                this.f52417a = 1;
                if (triggerBasedInvalidationTracker.y(this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f52419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f52420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FlowCollector f52421c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String[] f52422d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int[] f52423f;

        AnonymousClass2(Ref.ObjectRef objectRef, boolean z2, FlowCollector flowCollector, String[] strArr, int[] iArr) {
            this.f52419a = objectRef;
            this.f52420b = z2;
            this.f52421c = flowCollector;
            this.f52422d = strArr;
            this.f52423f = iArr;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        
            if (r14.emit(r2, r0) == r1) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x009c, code lost:
        
            if (r14.emit(r2, r0) == r1) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x009e, code lost:
        
            return r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(int[] r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
            /*
                r12 = this;
                boolean r0 = r14 instanceof androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1
                if (r0 == 0) goto L13
                r0 = r14
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1) r0
                int r1 = r0.f52427d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f52427d = r1
                goto L18
            L13:
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1
                r0.<init>(r12, r14)
            L18:
                java.lang.Object r14 = r0.f52425b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f52427d
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L39
                if (r2 == r4) goto L31
                if (r2 != r3) goto L29
                goto L31
            L29:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r14)
                throw r13
            L31:
                java.lang.Object r13 = r0.f52424a
                int[] r13 = (int[]) r13
                kotlin.ResultKt.b(r14)
                goto L9f
            L39:
                kotlin.ResultKt.b(r14)
                kotlin.jvm.internal.Ref$ObjectRef r14 = r12.f52419a
                java.lang.Object r2 = r14.f140144a
                if (r2 != 0) goto L59
                boolean r14 = r12.f52420b
                if (r14 == 0) goto L9f
                kotlinx.coroutines.flow.FlowCollector r14 = r12.f52421c
                java.lang.String[] r2 = r12.f52422d
                java.util.Set r2 = kotlin.collections.ArraysKt.toSet(r2)
                r0.f52424a = r13
                r0.f52427d = r4
                java.lang.Object r14 = r14.emit(r2, r0)
                if (r14 != r1) goto L9f
                goto L9e
            L59:
                java.lang.String[] r2 = r12.f52422d
                int[] r4 = r12.f52423f
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                int r6 = r2.length
                r7 = 0
                r8 = r7
            L65:
                if (r7 >= r6) goto L88
                r9 = r2[r7]
                int r10 = r8 + 1
                java.lang.Object r11 = r14.f140144a
                if (r11 == 0) goto L80
                int[] r11 = (int[]) r11
                r8 = r4[r8]
                r11 = r11[r8]
                r8 = r13[r8]
                if (r11 == r8) goto L7c
                r5.add(r9)
            L7c:
                int r7 = r7 + 1
                r8 = r10
                goto L65
            L80:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r14 = "Required value was null."
                r13.<init>(r14)
                throw r13
            L88:
                boolean r14 = r5.isEmpty()
                if (r14 != 0) goto L9f
                kotlinx.coroutines.flow.FlowCollector r14 = r12.f52421c
                java.util.Set r2 = kotlin.collections.CollectionsKt.toSet(r5)
                r0.f52424a = r13
                r0.f52427d = r3
                java.lang.Object r14 = r14.emit(r2, r0)
                if (r14 != r1) goto L9f
            L9e:
                return r1
            L9f:
                kotlin.jvm.internal.Ref$ObjectRef r14 = r12.f52419a
                r14.f140144a = r13
                kotlin.Unit r13 = kotlin.Unit.f139807a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$createFlow$1.AnonymousClass2.emit(int[], kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TriggerBasedInvalidationTracker$createFlow$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, int[] iArr, boolean z2, String[] strArr, Continuation continuation) {
        super(2, continuation);
        this.f52413c = triggerBasedInvalidationTracker;
        this.f52414d = iArr;
        this.f52415f = z2;
        this.f52416g = strArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TriggerBasedInvalidationTracker$createFlow$1 triggerBasedInvalidationTracker$createFlow$1 = new TriggerBasedInvalidationTracker$createFlow$1(this.f52413c, this.f52414d, this.f52415f, this.f52416g, continuation);
        triggerBasedInvalidationTracker$createFlow$1.f52412b = obj;
        return triggerBasedInvalidationTracker$createFlow$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006e, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g((kotlin.coroutines.CoroutineContext) r12, r5, r11) == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0092, code lost:
    
        if (r12.a(r4, r11) != r0) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f52411a
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L33
            if (r1 == r5) goto L2b
            if (r1 == r4) goto L23
            if (r1 == r3) goto L1a
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1a:
            kotlin.ResultKt.b(r12)     // Catch: java.lang.Throwable -> L1f
            goto L95
        L1f:
            r0 = move-exception
            r12 = r0
            goto L9b
        L23:
            java.lang.Object r1 = r11.f52412b
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.b(r12)
            goto L71
        L2b:
            java.lang.Object r1 = r11.f52412b
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.b(r12)
            goto L5d
        L33:
            kotlin.ResultKt.b(r12)
            java.lang.Object r12 = r11.f52412b
            kotlinx.coroutines.flow.FlowCollector r12 = (kotlinx.coroutines.flow.FlowCollector) r12
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.f52413c
            androidx.room.ObservedTableStates r1 = androidx.room.TriggerBasedInvalidationTracker.e(r1)
            int[] r6 = r11.f52414d
            boolean r1 = r1.g(r6)
            if (r1 == 0) goto L73
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.f52413c
            androidx.room.RoomDatabase r1 = androidx.room.TriggerBasedInvalidationTracker.d(r1)
            r11.f52412b = r12
            r11.f52411a = r5
            r5 = 0
            java.lang.Object r1 = androidx.room.util.DBUtil.d(r1, r5, r11)
            if (r1 != r0) goto L5a
            goto L94
        L5a:
            r10 = r1
            r1 = r12
            r12 = r10
        L5d:
            kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1 r5 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1
            androidx.room.TriggerBasedInvalidationTracker r6 = r11.f52413c
            r5.<init>(r6, r2)
            r11.f52412b = r1
            r11.f52411a = r4
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.g(r12, r5, r11)
            if (r12 != r0) goto L71
            goto L94
        L71:
            r7 = r1
            goto L74
        L73:
            r7 = r12
        L74:
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> L1f
            r5.<init>()     // Catch: java.lang.Throwable -> L1f
            androidx.room.TriggerBasedInvalidationTracker r12 = r11.f52413c     // Catch: java.lang.Throwable -> L1f
            androidx.room.ObservedTableVersions r12 = androidx.room.TriggerBasedInvalidationTracker.f(r12)     // Catch: java.lang.Throwable -> L1f
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2 r4 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2     // Catch: java.lang.Throwable -> L1f
            boolean r6 = r11.f52415f     // Catch: java.lang.Throwable -> L1f
            java.lang.String[] r8 = r11.f52416g     // Catch: java.lang.Throwable -> L1f
            int[] r9 = r11.f52414d     // Catch: java.lang.Throwable -> L1f
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L1f
            r11.f52412b = r2     // Catch: java.lang.Throwable -> L1f
            r11.f52411a = r3     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r12 = r12.a(r4, r11)     // Catch: java.lang.Throwable -> L1f
            if (r12 != r0) goto L95
        L94:
            return r0
        L95:
            kotlin.KotlinNothingValueException r12 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L1f
            r12.<init>()     // Catch: java.lang.Throwable -> L1f
            throw r12     // Catch: java.lang.Throwable -> L1f
        L9b:
            androidx.room.TriggerBasedInvalidationTracker r0 = r11.f52413c
            androidx.room.ObservedTableStates r0 = androidx.room.TriggerBasedInvalidationTracker.e(r0)
            int[] r1 = r11.f52414d
            r0.h(r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$createFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((TriggerBasedInvalidationTracker$createFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
