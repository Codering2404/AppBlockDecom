package androidx.collection;

import androidx.collection.MutableSetWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: Add missing generic type declarations: [E] */
/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.collection.MutableSetWrapper$iterator$1$iterator$1", f = "ScatterSet.kt", l = {1188}, m = "invokeSuspend")
final class MutableSetWrapper$iterator$1$iterator$1<E> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super E>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f3044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f3045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f3046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f3047d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3048f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f3049g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f3050h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f3051i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f3052j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private /* synthetic */ Object f3053k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ MutableSetWrapper f3054l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ MutableSetWrapper.AnonymousClass1 f3055m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MutableSetWrapper$iterator$1$iterator$1(MutableSetWrapper mutableSetWrapper, MutableSetWrapper.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(2, continuation);
        this.f3054l = mutableSetWrapper;
        this.f3055m = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MutableSetWrapper$iterator$1$iterator$1 mutableSetWrapper$iterator$1$iterator$1 = new MutableSetWrapper$iterator$1$iterator$1(this.f3054l, this.f3055m, continuation);
        mutableSetWrapper$iterator$1$iterator$1.f3053k = obj;
        return mutableSetWrapper$iterator$1$iterator$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005d -> B:23:0x00b3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005f -> B:14:0x0073). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x007c -> B:20:0x00a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00a4 -> B:20:0x00a7). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f3052j
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L36
            if (r2 != r5) goto L2e
            int r2 = r0.f3050h
            int r6 = r0.f3049g
            long r7 = r0.f3051i
            int r9 = r0.f3048f
            int r10 = r0.f3047d
            java.lang.Object r11 = r0.f3046c
            long[] r11 = (long[]) r11
            java.lang.Object r12 = r0.f3045b
            androidx.collection.MutableSetWrapper r12 = (androidx.collection.MutableSetWrapper) r12
            java.lang.Object r13 = r0.f3044a
            androidx.collection.MutableSetWrapper$iterator$1 r13 = (androidx.collection.MutableSetWrapper.AnonymousClass1) r13
            java.lang.Object r14 = r0.f3053k
            kotlin.sequences.SequenceScope r14 = (kotlin.sequences.SequenceScope) r14
            kotlin.ResultKt.b(r22)
            goto La7
        L2e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L36:
            kotlin.ResultKt.b(r22)
            java.lang.Object r2 = r0.f3053k
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            androidx.collection.MutableSetWrapper r6 = r0.f3054l
            androidx.collection.MutableScatterSet r6 = androidx.collection.MutableSetWrapper.d(r6)
            androidx.collection.MutableSetWrapper$iterator$1 r7 = r0.f3055m
            androidx.collection.MutableSetWrapper r8 = r0.f3054l
            long[] r6 = r6.f3115a
            int r9 = r6.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto Lb8
            r10 = 0
        L4f:
            r11 = r6[r10]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto Lb3
            int r13 = r10 - r9
            int r13 = ~r13
            int r13 = r13 >>> 31
            int r13 = 8 - r13
            r14 = r10
            r10 = r9
            r9 = r14
            r14 = r2
            r2 = 0
            r19 = r11
            r11 = r6
            r12 = r8
            r6 = r13
            r13 = r7
            r7 = r19
        L73:
            if (r2 >= r6) goto Laa
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r7
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto La7
            int r15 = r9 << 3
            int r15 = r15 + r2
            r13.a(r15)
            androidx.collection.MutableScatterSet r3 = androidx.collection.MutableSetWrapper.d(r12)
            java.lang.Object[] r3 = r3.f3116b
            r3 = r3[r15]
            r0.f3053k = r14
            r0.f3044a = r13
            r0.f3045b = r12
            r0.f3046c = r11
            r0.f3047d = r10
            r0.f3048f = r9
            r0.f3051i = r7
            r0.f3049g = r6
            r0.f3050h = r2
            r0.f3052j = r5
            java.lang.Object r3 = r14.a(r3, r0)
            if (r3 != r1) goto La7
            return r1
        La7:
            long r7 = r7 >> r4
            int r2 = r2 + r5
            goto L73
        Laa:
            if (r6 != r4) goto Lb8
            r2 = r10
            r10 = r9
            r9 = r2
            r6 = r11
            r8 = r12
            r7 = r13
            r2 = r14
        Lb3:
            if (r10 == r9) goto Lb8
            int r10 = r10 + 1
            goto L4f
        Lb8:
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableSetWrapper$iterator$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((MutableSetWrapper$iterator$1$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
