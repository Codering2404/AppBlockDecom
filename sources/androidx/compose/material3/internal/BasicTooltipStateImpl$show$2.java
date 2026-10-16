package androidx.compose.material3.internal;

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
@DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipStateImpl$show$2", f = "BasicTooltip.kt", l = {152, 154}, m = "invokeSuspend")
final class BasicTooltipStateImpl$show$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f21899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BasicTooltipStateImpl f21900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f21901c;

    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1", f = "BasicTooltip.kt", l = {154}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f21903b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.f21903b = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f21903b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f21902a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Function1 function1 = this.f21903b;
                this.f21902a = 1;
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
    BasicTooltipStateImpl$show$2(BasicTooltipStateImpl basicTooltipStateImpl, Function1 function1, Continuation continuation) {
        super(1, continuation);
        this.f21900b = basicTooltipStateImpl;
        this.f21901c = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BasicTooltipStateImpl$show$2(this.f21900b, this.f21901c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.c(1500, r6, r5) == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f21899a
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L1d
            if (r1 == r4) goto Lf
            if (r1 != r3) goto L15
        Lf:
            kotlin.ResultKt.b(r6)     // Catch: java.lang.Throwable -> L13
            goto L46
        L13:
            r6 = move-exception
            goto L4e
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            kotlin.ResultKt.b(r6)
            androidx.compose.material3.internal.BasicTooltipStateImpl r6 = r5.f21900b     // Catch: java.lang.Throwable -> L13
            boolean r6 = r6.f()     // Catch: java.lang.Throwable -> L13
            if (r6 == 0) goto L33
            kotlin.jvm.functions.Function1 r6 = r5.f21901c     // Catch: java.lang.Throwable -> L13
            r5.f21899a = r4     // Catch: java.lang.Throwable -> L13
            java.lang.Object r6 = r6.invoke(r5)     // Catch: java.lang.Throwable -> L13
            if (r6 != r0) goto L46
            goto L45
        L33:
            androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1 r6 = new androidx.compose.material3.internal.BasicTooltipStateImpl$show$2$1     // Catch: java.lang.Throwable -> L13
            kotlin.jvm.functions.Function1 r1 = r5.f21901c     // Catch: java.lang.Throwable -> L13
            r4 = 0
            r6.<init>(r1, r4)     // Catch: java.lang.Throwable -> L13
            r5.f21899a = r3     // Catch: java.lang.Throwable -> L13
            r3 = 1500(0x5dc, double:7.41E-321)
            java.lang.Object r6 = kotlinx.coroutines.TimeoutKt.c(r3, r6, r5)     // Catch: java.lang.Throwable -> L13
            if (r6 != r0) goto L46
        L45:
            return r0
        L46:
            androidx.compose.material3.internal.BasicTooltipStateImpl r6 = r5.f21900b
            r6.g(r2)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L4e:
            androidx.compose.material3.internal.BasicTooltipStateImpl r0 = r5.f21900b
            r0.g(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipStateImpl$show$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BasicTooltipStateImpl$show$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
