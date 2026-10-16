package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1", f = "SearchBar.android.kt", l = {202}, m = "invokeSuspend")
final class SearchBar_androidKt$SearchBar$2$1 extends SuspendLambda implements Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f19580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f19581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutatorMutex f19582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableFloatState f19583d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Animatable f19584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f19585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f19586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ MutableState f19587i;

    /* JADX INFO: renamed from: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1", f = "SearchBar.android.kt", l = {205, 216}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MutableFloatState f19589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Flow f19590c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Animatable f19591d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1 f19592f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ MutableState f19593g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ MutableState f19594h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MutableFloatState mutableFloatState, Flow flow, Animatable animatable, Function1 function1, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
            super(1, continuation);
            this.f19589b = mutableFloatState;
            this.f19590c = flow;
            this.f19591d = animatable;
            this.f19592f = function1;
            this.f19593g = mutableState;
            this.f19594h = mutableState2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f19589b, this.f19590c, this.f19591d, this.f19592f, this.f19593g, this.f19594h, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0075, code lost:
        
            if (androidx.compose.animation.core.Animatable.f(r4, r5, r6, null, null, r9, 12, null) != r0) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r12.f19588a
                r2 = 2143289344(0x7fc00000, float:NaN)
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L21
                if (r1 == r4) goto L1d
                if (r1 != r3) goto L15
                kotlin.ResultKt.b(r13)
                r9 = r12
                goto L78
            L15:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1d:
                kotlin.ResultKt.b(r13)     // Catch: java.util.concurrent.CancellationException -> L5d
                goto L40
            L21:
                kotlin.ResultKt.b(r13)
                androidx.compose.runtime.MutableFloatState r13 = r12.f19589b     // Catch: java.util.concurrent.CancellationException -> L5d
                r13.s(r2)     // Catch: java.util.concurrent.CancellationException -> L5d
                kotlinx.coroutines.flow.Flow r13 = r12.f19590c     // Catch: java.util.concurrent.CancellationException -> L5d
                androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1$1 r1 = new androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1$1$1     // Catch: java.util.concurrent.CancellationException -> L5d
                androidx.compose.runtime.MutableState r5 = r12.f19593g     // Catch: java.util.concurrent.CancellationException -> L5d
                androidx.compose.runtime.MutableState r6 = r12.f19594h     // Catch: java.util.concurrent.CancellationException -> L5d
                androidx.compose.animation.core.Animatable r7 = r12.f19591d     // Catch: java.util.concurrent.CancellationException -> L5d
                r1.<init>()     // Catch: java.util.concurrent.CancellationException -> L5d
                r12.f19588a = r4     // Catch: java.util.concurrent.CancellationException -> L5d
                java.lang.Object r13 = r13.collect(r1, r12)     // Catch: java.util.concurrent.CancellationException -> L5d
                if (r13 != r0) goto L40
                r9 = r12
                goto L77
            L40:
                androidx.compose.runtime.MutableFloatState r13 = r12.f19589b     // Catch: java.util.concurrent.CancellationException -> L5d
                androidx.compose.animation.core.Animatable r1 = r12.f19591d     // Catch: java.util.concurrent.CancellationException -> L5d
                java.lang.Object r1 = r1.n()     // Catch: java.util.concurrent.CancellationException -> L5d
                java.lang.Number r1 = (java.lang.Number) r1     // Catch: java.util.concurrent.CancellationException -> L5d
                float r1 = r1.floatValue()     // Catch: java.util.concurrent.CancellationException -> L5d
                r13.s(r1)     // Catch: java.util.concurrent.CancellationException -> L5d
                kotlin.jvm.functions.Function1 r13 = r12.f19592f     // Catch: java.util.concurrent.CancellationException -> L5d
                r1 = 0
                java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.a(r1)     // Catch: java.util.concurrent.CancellationException -> L5d
                r13.invoke(r1)     // Catch: java.util.concurrent.CancellationException -> L5d
                r9 = r12
                goto L88
            L5d:
                androidx.compose.animation.core.Animatable r4 = r12.f19591d
                r13 = 1065353216(0x3f800000, float:1.0)
                java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.c(r13)
                androidx.compose.animation.core.FiniteAnimationSpec r6 = androidx.compose.material3.SearchBar_androidKt.o()
                r12.f19588a = r3
                r7 = 0
                r8 = 0
                r10 = 12
                r11 = 0
                r9 = r12
                java.lang.Object r13 = androidx.compose.animation.core.Animatable.f(r4, r5, r6, r7, r8, r9, r10, r11)
                if (r13 != r0) goto L78
            L77:
                return r0
            L78:
                androidx.compose.runtime.MutableFloatState r13 = r9.f19589b
                r13.s(r2)
                androidx.compose.runtime.MutableState r13 = r9.f19593g
                r0 = 0
                r13.setValue(r0)
                androidx.compose.runtime.MutableState r13 = r9.f19594h
                r13.setValue(r0)
            L88:
                kotlin.Unit r13 = kotlin.Unit.f139807a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchBar_androidKt$SearchBar$2$1(MutatorMutex mutatorMutex, MutableFloatState mutableFloatState, Animatable animatable, Function1 function1, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.f19582c = mutatorMutex;
        this.f19583d = mutableFloatState;
        this.f19584f = animatable;
        this.f19585g = function1;
        this.f19586h = mutableState;
        this.f19587i = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SearchBar_androidKt$SearchBar$2$1 searchBar_androidKt$SearchBar$2$1 = new SearchBar_androidKt$SearchBar$2$1(this.f19582c, this.f19583d, this.f19584f, this.f19585g, this.f19586h, this.f19587i, continuation);
        searchBar_androidKt$SearchBar$2$1.f19581b = obj;
        return searchBar_androidKt$SearchBar$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Flow flow, Continuation continuation) {
        return ((SearchBar_androidKt$SearchBar$2$1) create(flow, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f19580a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flow = (Flow) this.f19581b;
            MutatorMutex mutatorMutex = this.f19582c;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f19583d, flow, this.f19584f, this.f19585g, this.f19586h, this.f19587i, null);
            this.f19580a = 1;
            if (MutatorMutex.e(mutatorMutex, null, anonymousClass1, this, 1, null) == objF) {
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
}
