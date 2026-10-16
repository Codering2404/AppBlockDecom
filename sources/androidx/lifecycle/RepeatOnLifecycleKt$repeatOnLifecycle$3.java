package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

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
@DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {83}, m = "invokeSuspend")
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f40046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f40047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Lifecycle f40048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Lifecycle.State f40049d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function2 f40050f;

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {161}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f40051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f40052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f40053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f40054d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f40055f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f40056g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f40057h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Lifecycle f40058i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Lifecycle.State f40059j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f40060k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ Function2 f40061l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, CoroutineScope coroutineScope, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.f40058i = lifecycle;
            this.f40059j = state;
            this.f40060k = coroutineScope;
            this.f40061l = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f40058i, this.f40059j, this.f40060k, this.f40061l, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00cf  */
        /* JADX WARN: Removed duplicated region for block: B:45:? A[SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 213
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f40048c = lifecycle;
        this.f40049d = state;
        this.f40050f = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.f40048c, this.f40049d, this.f40050f, continuation);
        repeatOnLifecycleKt$repeatOnLifecycle$3.f40047b = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f40046a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f40047b;
            MainCoroutineDispatcher mainCoroutineDispatcherW0 = Dispatchers.c().w0();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f40048c, this.f40049d, coroutineScope, this.f40050f, null);
            this.f40046a = 1;
            if (BuildersKt.g(mainCoroutineDispatcherW0, anonymousClass1, this) == objF) {
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
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
