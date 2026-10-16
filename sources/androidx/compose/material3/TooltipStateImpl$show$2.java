package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material3.TooltipStateImpl$show$2", f = "Tooltip.kt", l = {504, 506}, m = "invokeSuspend")
final class TooltipStateImpl$show$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f21489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TooltipStateImpl f21490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f21491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutatePriority f21492d;

    /* JADX INFO: renamed from: androidx.compose.material3.TooltipStateImpl$show$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.TooltipStateImpl$show$2$1", f = "Tooltip.kt", l = {506}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f21494b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f21494b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f21494b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f21493a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1 function1 = this.f21494b;
                this.f21493a = 1;
                if (function1.invoke(this) == objF) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TooltipStateImpl$show$2(TooltipStateImpl tooltipStateImpl, Function1 function1, MutatePriority mutatePriority, Continuation continuation) {
        super(1, continuation);
        this.f21490b = tooltipStateImpl;
        this.f21491c = function1;
        this.f21492d = mutatePriority;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new TooltipStateImpl$show$2(this.f21490b, this.f21491c, this.f21492d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.c(1500, r5, r4) == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f21489a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto Le
            if (r1 != r2) goto L14
        Le:
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L12
            goto L45
        L12:
            r5 = move-exception
            goto L53
        L14:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1c:
            kotlin.ResultKt.b(r5)
            androidx.compose.material3.TooltipStateImpl r5 = r4.f21490b     // Catch: java.lang.Throwable -> L12
            boolean r5 = r5.f()     // Catch: java.lang.Throwable -> L12
            if (r5 == 0) goto L32
            kotlin.jvm.functions.Function1 r5 = r4.f21491c     // Catch: java.lang.Throwable -> L12
            r4.f21489a = r3     // Catch: java.lang.Throwable -> L12
            java.lang.Object r5 = r5.invoke(r4)     // Catch: java.lang.Throwable -> L12
            if (r5 != r0) goto L45
            goto L44
        L32:
            androidx.compose.material3.TooltipStateImpl$show$2$1 r5 = new androidx.compose.material3.TooltipStateImpl$show$2$1     // Catch: java.lang.Throwable -> L12
            kotlin.jvm.functions.Function1 r1 = r4.f21491c     // Catch: java.lang.Throwable -> L12
            r3 = 0
            r5.<init>(r1, r3)     // Catch: java.lang.Throwable -> L12
            r4.f21489a = r2     // Catch: java.lang.Throwable -> L12
            r1 = 1500(0x5dc, double:7.41E-321)
            java.lang.Object r5 = kotlinx.coroutines.TimeoutKt.c(r1, r5, r4)     // Catch: java.lang.Throwable -> L12
            if (r5 != r0) goto L45
        L44:
            return r0
        L45:
            androidx.compose.foundation.MutatePriority r5 = r4.f21492d
            androidx.compose.foundation.MutatePriority r0 = androidx.compose.foundation.MutatePriority.f5073c
            if (r5 == r0) goto L50
            androidx.compose.material3.TooltipStateImpl r5 = r4.f21490b
            r5.dismiss()
        L50:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L53:
            androidx.compose.foundation.MutatePriority r0 = r4.f21492d
            androidx.compose.foundation.MutatePriority r1 = androidx.compose.foundation.MutatePriority.f5073c
            if (r0 == r1) goto L5e
            androidx.compose.material3.TooltipStateImpl r0 = r4.f21490b
            r0.dismiss()
        L5e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TooltipStateImpl$show$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((TooltipStateImpl$show$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
