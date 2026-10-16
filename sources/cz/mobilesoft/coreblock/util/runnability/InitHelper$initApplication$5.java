package cz.mobilesoft.coreblock.util.runnability;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.SupervisorKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.runnability.InitHelper$initApplication$5", f = "InitHelper.kt", l = {208}, m = "invokeSuspend", v = 1)
final class InitHelper$initApplication$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f129497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f129498b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.runnability.InitHelper$initApplication$5$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.runnability.InitHelper$initApplication$5$1", f = "InitHelper.kt", l = {240, 243}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f129499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f129500b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f129501c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f129502d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f129503f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f129504g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f129505h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f129506i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f129507j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f129508k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private /* synthetic */ Object f129509l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ Context f129510m;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.runnability.InitHelper$initApplication$5$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.util.runnability.InitHelper$initApplication$5$1$1", f = "InitHelper.kt", l = {244}, m = "invokeSuspend", v = 1)
        static final class C03101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f129511a;

            C03101(Continuation continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C03101(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.f129511a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    InitHelper initHelper = InitHelper.f129486a;
                    this.f129511a = 1;
                    if (initHelper.s(this) == objF) {
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
                return ((C03101) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, Continuation continuation) {
            super(2, continuation);
            this.f129510m = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f129510m, continuation);
            anonymousClass1.f129509l = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0195, code lost:
        
            if (kotlinx.coroutines.BuildersKt.g(r14, r15, r19) == r1) goto L16;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 411
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.InitHelper$initApplication$5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitHelper$initApplication$5(Context context, Continuation continuation) {
        super(2, continuation);
        this.f129498b = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InitHelper$initApplication$5(this.f129498b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f129497a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f129498b, null);
            this.f129497a = 1;
            if (SupervisorKt.c(anonymousClass1, this) == objF) {
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
        return ((InitHelper$initApplication$5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
