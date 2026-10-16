package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", l = {417, 418, 420}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$distinctBy$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f141169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f141170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f141171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f141172d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f141173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ReceiveChannel f141174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function2 f141175h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f141174g = receiveChannel;
        this.f141175h = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.f141174g, this.f141175h, continuation);
        channelsKt__DeprecatedKt$distinctBy$1.f141173f = obj;
        return channelsKt__DeprecatedKt$distinctBy$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0079 A[PHI: r1 r5 r6 r11
      0x0079: PHI (r1v5 kotlinx.coroutines.channels.ChannelIterator) = (r1v6 kotlinx.coroutines.channels.ChannelIterator), (r1v11 kotlinx.coroutines.channels.ChannelIterator) binds: [B:14:0x0076, B:11:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x0079: PHI (r5v6 java.util.HashSet) = (r5v8 java.util.HashSet), (r5v12 java.util.HashSet) binds: [B:14:0x0076, B:11:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x0079: PHI (r6v3 kotlinx.coroutines.channels.ProducerScope) = (r6v5 kotlinx.coroutines.channels.ProducerScope), (r6v10 kotlinx.coroutines.channels.ProducerScope) binds: [B:14:0x0076, B:11:0x0041] A[DONT_GENERATE, DONT_INLINE]
      0x0079: PHI (r11v4 java.lang.Object) = (r11v11 java.lang.Object), (r11v0 java.lang.Object) binds: [B:14:0x0076, B:11:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a1 -> B:29:0x00ba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00b4 -> B:28:0x00b6). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f141172d
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L51
            if (r1 == r4) goto L41
            if (r1 == r3) goto L2c
            if (r1 != r2) goto L24
            java.lang.Object r1 = r10.f141171c
            java.lang.Object r5 = r10.f141170b
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.f141169a
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r7 = r10.f141173f
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.b(r11)
            goto Lb6
        L24:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L2c:
            java.lang.Object r1 = r10.f141171c
            java.lang.Object r5 = r10.f141170b
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.f141169a
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r7 = r10.f141173f
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.b(r11)
            r9 = r5
            r5 = r1
            r1 = r9
            goto L9d
        L41:
            java.lang.Object r1 = r10.f141170b
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r10.f141169a
            java.util.HashSet r5 = (java.util.HashSet) r5
            java.lang.Object r6 = r10.f141173f
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.b(r11)
            goto L79
        L51:
            kotlin.ResultKt.b(r11)
            java.lang.Object r11 = r10.f141173f
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            kotlinx.coroutines.channels.ReceiveChannel r5 = r10.f141174g
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r6 = r5
            r5 = r1
            r1 = r6
            r6 = r11
        L67:
            r10.f141173f = r6
            r10.f141169a = r5
            r10.f141170b = r1
            r11 = 0
            r10.f141171c = r11
            r10.f141172d = r4
            java.lang.Object r11 = r1.a(r10)
            if (r11 != r0) goto L79
            goto Lb3
        L79:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto Lbd
            java.lang.Object r11 = r1.next()
            kotlin.jvm.functions.Function2 r7 = r10.f141175h
            r10.f141173f = r6
            r10.f141169a = r5
            r10.f141170b = r1
            r10.f141171c = r11
            r10.f141172d = r3
            java.lang.Object r7 = r7.invoke(r11, r10)
            if (r7 != r0) goto L98
            goto Lb3
        L98:
            r9 = r5
            r5 = r11
            r11 = r7
            r7 = r6
            r6 = r9
        L9d:
            boolean r8 = r6.contains(r11)
            if (r8 != 0) goto Lba
            r10.f141173f = r7
            r10.f141169a = r6
            r10.f141170b = r1
            r10.f141171c = r11
            r10.f141172d = r2
            java.lang.Object r5 = r7.y(r5, r10)
            if (r5 != r0) goto Lb4
        Lb3:
            return r0
        Lb4:
            r5 = r1
            r1 = r11
        Lb6:
            r6.add(r1)
            r1 = r5
        Lba:
            r5 = r6
            r6 = r7
            goto L67
        Lbd:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
