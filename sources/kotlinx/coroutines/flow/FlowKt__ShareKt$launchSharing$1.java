package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", l = {210, 214, 215, 221}, m = "invokeSuspend")
final class FlowKt__ShareKt$launchSharing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f141909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SharingStarted f141910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f141911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableSharedFlow f141912d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Object f141913f;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f141914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ int f141915b;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.f141915b = ((Number) obj).intValue();
            return anonymousClass1;
        }

        public final Object h(int i3, Continuation continuation) {
            return ((AnonymousClass1) create(Integer.valueOf(i3), continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return h(((Number) obj).intValue(), (Continuation) obj2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f141914a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Boxing.a(this.f141915b > 0);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", l = {223}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f141916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f141917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Flow f141918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ MutableSharedFlow f141919d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f141920f;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2$WhenMappings */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f141921a;

            static {
                int[] iArr = new int[SharingCommand.values().length];
                try {
                    iArr[SharingCommand.f142201a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SharingCommand.f142202b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[SharingCommand.f142203c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f141921a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Flow flow, MutableSharedFlow mutableSharedFlow, Object obj, Continuation continuation) {
            super(2, continuation);
            this.f141918c = flow;
            this.f141919d = mutableSharedFlow;
            this.f141920f = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f141918c, this.f141919d, this.f141920f, continuation);
            anonymousClass2.f141917b = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SharingCommand sharingCommand, Continuation continuation) {
            return ((AnonymousClass2) create(sharingCommand, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f141916a;
            if (i3 == 0) {
                ResultKt.b(obj);
                int i4 = WhenMappings.f141921a[((SharingCommand) this.f141917b).ordinal()];
                if (i4 == 1) {
                    Flow flow = this.f141918c;
                    MutableSharedFlow mutableSharedFlow = this.f141919d;
                    this.f141916a = 1;
                    if (flow.collect(mutableSharedFlow, this) == objF) {
                        return objF;
                    }
                } else if (i4 != 2) {
                    if (i4 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Object obj2 = this.f141920f;
                    if (obj2 == SharedFlowKt.f142198a) {
                        this.f141919d.e();
                    } else {
                        Boxing.a(this.f141919d.c(obj2));
                    }
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__ShareKt$launchSharing$1(SharingStarted sharingStarted, Flow flow, MutableSharedFlow mutableSharedFlow, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f141910b = sharingStarted;
        this.f141911c = flow;
        this.f141912d = mutableSharedFlow;
        this.f141913f = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FlowKt__ShareKt$launchSharing$1(this.f141910b, this.f141911c, this.f141912d, this.f141913f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
    
        if (r8.collect(r1, r7) == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
    
        if (r8.collect(r1, r7) != r0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        if (kotlinx.coroutines.flow.FlowKt.l(r8, r1, r7) == r0) goto L28;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f141909a
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L25
            if (r1 == r5) goto L21
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L21
            if (r1 != r2) goto L15
            goto L21
        L15:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1d:
            kotlin.ResultKt.b(r8)
            goto L5c
        L21:
            kotlin.ResultKt.b(r8)
            goto L8d
        L25:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.flow.SharingStarted r8 = r7.f141910b
            kotlinx.coroutines.flow.SharingStarted$Companion r1 = kotlinx.coroutines.flow.SharingStarted.f142210a
            kotlinx.coroutines.flow.SharingStarted r6 = r1.c()
            if (r8 != r6) goto L3f
            kotlinx.coroutines.flow.Flow r8 = r7.f141911c
            kotlinx.coroutines.flow.MutableSharedFlow r1 = r7.f141912d
            r7.f141909a = r5
            java.lang.Object r8 = r8.collect(r1, r7)
            if (r8 != r0) goto L8d
            goto L8c
        L3f:
            kotlinx.coroutines.flow.SharingStarted r8 = r7.f141910b
            kotlinx.coroutines.flow.SharingStarted r1 = r1.d()
            r5 = 0
            if (r8 != r1) goto L69
            kotlinx.coroutines.flow.MutableSharedFlow r8 = r7.f141912d
            kotlinx.coroutines.flow.StateFlow r8 = r8.d()
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1
            r1.<init>(r5)
            r7.f141909a = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.E(r8, r1, r7)
            if (r8 != r0) goto L5c
            goto L8c
        L5c:
            kotlinx.coroutines.flow.Flow r8 = r7.f141911c
            kotlinx.coroutines.flow.MutableSharedFlow r1 = r7.f141912d
            r7.f141909a = r3
            java.lang.Object r8 = r8.collect(r1, r7)
            if (r8 != r0) goto L8d
            goto L8c
        L69:
            kotlinx.coroutines.flow.SharingStarted r8 = r7.f141910b
            kotlinx.coroutines.flow.MutableSharedFlow r1 = r7.f141912d
            kotlinx.coroutines.flow.StateFlow r1 = r1.d()
            kotlinx.coroutines.flow.Flow r8 = r8.a(r1)
            kotlinx.coroutines.flow.Flow r8 = kotlinx.coroutines.flow.FlowKt.u(r8)
            kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2 r1 = new kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2
            kotlinx.coroutines.flow.Flow r3 = r7.f141911c
            kotlinx.coroutines.flow.MutableSharedFlow r4 = r7.f141912d
            java.lang.Object r6 = r7.f141913f
            r1.<init>(r3, r4, r6, r5)
            r7.f141909a = r2
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.l(r8, r1, r7)
            if (r8 != r0) goto L8d
        L8c:
            return r0
        L8d:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FlowKt__ShareKt$launchSharing$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
