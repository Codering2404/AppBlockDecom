package cz.mobilesoft.coreblock.util;

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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.SingularCallbackHandler$onAttributionReceived$1", f = "SingularCallbackHandler.kt", l = {56, 57, 65, 68, 70, 70}, m = "invokeSuspend", v = 1)
final class SingularCallbackHandler$onAttributionReceived$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f127997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f127998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f127999d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f128000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ String f128001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f128002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f128003i;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.SingularCallbackHandler$onAttributionReceived$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.SingularCallbackHandler$onAttributionReceived$1$1", f = "SingularCallbackHandler.kt", l = {66}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f128004a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.SingularCallbackHandler$onAttributionReceived$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.util.SingularCallbackHandler$onAttributionReceived$1$1$1", f = "SingularCallbackHandler.kt", l = {}, m = "invokeSuspend", v = 1)
        static final class C03051 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f128005a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ boolean f128006b;

            C03051(Continuation continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                C03051 c03051 = new C03051(continuation);
                c03051.f128006b = ((Boolean) obj).booleanValue();
                return c03051;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (Continuation) obj2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                boolean z2 = this.f128006b;
                IntrinsicsKt.f();
                if (this.f128005a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Boxing.a(z2);
            }

            public final Object invoke(boolean z2, Continuation continuation) {
                return ((C03051) create(Boolean.valueOf(z2), continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f128004a;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return obj;
            }
            ResultKt.b(obj);
            StateFlow stateFlowA = RemoteConfigSignal.f127906a.a();
            C03051 c03051 = new C03051(null);
            this.f128004a = 1;
            Object objE = FlowKt.E(stateFlowA, c03051, this);
            return objE == objF ? objF : objE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SingularCallbackHandler$onAttributionReceived$1(String str, String str2, String str3, boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f128000f = str;
        this.f128001g = str2;
        this.f128002h = str3;
        this.f128003i = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SingularCallbackHandler$onAttributionReceived$1(this.f128000f, this.f128001g, this.f128002h, this.f128003i, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0171, code lost:
    
        if (r5.L5(r2, r8) != r0) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033 A[PHI: r1 r9
      0x0033: PHI (r1v19 java.lang.String) = (r1v16 java.lang.String), (r1v25 java.lang.String) binds: [B:43:0x0101, B:8:0x002c] A[DONT_GENERATE, DONT_INLINE]
      0x0033: PHI (r9v23 java.lang.Object) = (r9v22 java.lang.Object), (r9v0 java.lang.Object) binds: [B:43:0x0101, B:8:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.SingularCallbackHandler$onAttributionReceived$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((SingularCallbackHandler$onAttributionReceived$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
