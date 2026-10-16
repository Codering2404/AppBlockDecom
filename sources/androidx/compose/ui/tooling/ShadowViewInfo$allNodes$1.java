package androidx.compose.ui.tooling;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.ui.tooling.ShadowViewInfo$allNodes$1", f = "ShadowViewInfo.android.kt", l = {43, 44}, m = "invokeSuspend")
final class ShadowViewInfo$allNodes$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super ShadowViewInfo>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f29768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f29770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ShadowViewInfo f29771d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowViewInfo$allNodes$1(ShadowViewInfo shadowViewInfo, Continuation continuation) {
        super(2, continuation);
        this.f29771d = shadowViewInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ShadowViewInfo$allNodes$1 shadowViewInfo$allNodes$1 = new ShadowViewInfo$allNodes$1(this.f29771d, continuation);
        shadowViewInfo$allNodes$1.f29770c = obj;
        return shadowViewInfo$allNodes$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        if (r1.a(r6, r5) == r0) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f29769b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r1 = r5.f29768a
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r5.f29770c
            kotlin.sequences.SequenceScope r3 = (kotlin.sequences.SequenceScope) r3
            kotlin.ResultKt.b(r6)
            goto L6a
        L1a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L22:
            java.lang.Object r1 = r5.f29770c
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            kotlin.ResultKt.b(r6)
            goto L3f
        L2a:
            kotlin.ResultKt.b(r6)
            java.lang.Object r6 = r5.f29770c
            r1 = r6
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            androidx.compose.ui.tooling.ShadowViewInfo r6 = r5.f29771d
            r5.f29770c = r1
            r5.f29769b = r3
            java.lang.Object r6 = r1.a(r6, r5)
            if (r6 != r0) goto L3f
            goto L82
        L3f:
            androidx.compose.ui.tooling.ShadowViewInfo r6 = r5.f29771d
            java.util.List r6 = r6.c()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r6 = r6.iterator()
        L50:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L64
            java.lang.Object r4 = r6.next()
            androidx.compose.ui.tooling.ShadowViewInfo r4 = (androidx.compose.ui.tooling.ShadowViewInfo) r4
            kotlin.sequences.Sequence r4 = r4.b()
            kotlin.collections.CollectionsKt.addAll(r3, r4)
            goto L50
        L64:
            java.util.Iterator r6 = r3.iterator()
            r3 = r1
            r1 = r6
        L6a:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L83
            java.lang.Object r6 = r1.next()
            androidx.compose.ui.tooling.ShadowViewInfo r6 = (androidx.compose.ui.tooling.ShadowViewInfo) r6
            r5.f29770c = r3
            r5.f29768a = r1
            r5.f29769b = r2
            java.lang.Object r6 = r3.a(r6, r5)
            if (r6 != r0) goto L6a
        L82:
            return r0
        L83:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ShadowViewInfo$allNodes$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((ShadowViewInfo$allNodes$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
