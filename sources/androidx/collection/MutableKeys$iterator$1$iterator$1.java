package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

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
@DebugMetadata(c = "androidx.collection.MutableKeys$iterator$1$iterator$1", f = "ScatterMap.kt", l = {1622}, m = "invokeSuspend")
final class MutableKeys$iterator$1$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f2994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2997d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f2999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f3000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private /* synthetic */ Object f3001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ MutableKeys f3002j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MutableKeys$iterator$1$iterator$1(MutableKeys mutableKeys, Continuation continuation) {
        super(2, continuation);
        this.f3002j = mutableKeys;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MutableKeys$iterator$1$iterator$1 mutableKeys$iterator$1$iterator$1 = new MutableKeys$iterator$1$iterator$1(this.f3002j, continuation);
        mutableKeys$iterator$1$iterator$1.f3001i = obj;
        return mutableKeys$iterator$1$iterator$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0052 -> B:23:0x0098). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0054 -> B:14:0x0066). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006f -> B:20:0x008f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x008c -> B:20:0x008f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f3000h
            r3 = 0
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L2f
            if (r2 != r5) goto L27
            int r2 = r0.f2998f
            int r6 = r0.f2997d
            long r7 = r0.f2999g
            int r9 = r0.f2996c
            int r10 = r0.f2995b
            java.lang.Object r11 = r0.f2994a
            long[] r11 = (long[]) r11
            java.lang.Object r12 = r0.f3001i
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.b(r20)
            goto L8f
        L27:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L2f:
            kotlin.ResultKt.b(r20)
            java.lang.Object r2 = r0.f3001i
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            androidx.collection.MutableKeys r6 = r0.f3002j
            androidx.collection.MutableScatterMap r6 = androidx.collection.MutableKeys.a(r6)
            long[] r6 = r6.f3108a
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L9d
            r8 = r3
        L44:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L98
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            int r11 = 8 - r11
            r12 = r11
            r11 = r6
            r6 = r12
            r12 = r2
            r2 = r3
            r17 = r9
            r10 = r7
            r9 = r8
            r7 = r17
        L66:
            if (r2 >= r6) goto L92
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r7
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L8f
            int r13 = r9 << 3
            int r13 = r13 + r2
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.d(r13)
            r0.f3001i = r12
            r0.f2994a = r11
            r0.f2995b = r10
            r0.f2996c = r9
            r0.f2999g = r7
            r0.f2997d = r6
            r0.f2998f = r2
            r0.f3000h = r5
            java.lang.Object r13 = r12.a(r13, r0)
            if (r13 != r1) goto L8f
            return r1
        L8f:
            long r7 = r7 >> r4
            int r2 = r2 + r5
            goto L66
        L92:
            if (r6 != r4) goto L9d
            r8 = r9
            r7 = r10
            r6 = r11
            r2 = r12
        L98:
            if (r8 == r7) goto L9d
            int r8 = r8 + 1
            goto L44
        L9d:
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableKeys$iterator$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((MutableKeys$iterator$1$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
