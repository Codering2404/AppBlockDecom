package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", l = {374, 375, 375}, m = "invokeSuspend")
final class ChannelsKt__DeprecatedKt$mapIndexed$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f141272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f141273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f141274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f141275d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f141276f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ReceiveChannel f141277g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Function3 f141278h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f141277g = receiveChannel;
        this.f141278h = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.f141277g, this.f141278h, continuation);
        channelsKt__DeprecatedKt$mapIndexed$1.f141276f = obj;
        return channelsKt__DeprecatedKt$mapIndexed$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a6 -> B:13:0x0059). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f141275d
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L48
            if (r1 == r4) goto L3a
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r10.f141274c
            java.lang.Object r5 = r10.f141272a
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.f141276f
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.b(r11)
            r11 = r6
            goto L59
        L20:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L28:
            int r1 = r10.f141274c
            java.lang.Object r5 = r10.f141273b
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            java.lang.Object r6 = r10.f141272a
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r10.f141276f
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.b(r11)
            goto L94
        L3a:
            int r1 = r10.f141274c
            java.lang.Object r5 = r10.f141272a
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.f141276f
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.b(r11)
            goto L6b
        L48:
            kotlin.ResultKt.b(r11)
            java.lang.Object r11 = r10.f141276f
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
            kotlinx.coroutines.channels.ReceiveChannel r1 = r10.f141277g
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = 0
            r9 = r5
            r5 = r1
            r1 = r9
        L59:
            r10.f141276f = r11
            r10.f141272a = r5
            r10.f141274c = r1
            r10.f141275d = r4
            java.lang.Object r6 = r5.a(r10)
            if (r6 != r0) goto L68
            goto La5
        L68:
            r9 = r6
            r6 = r11
            r11 = r9
        L6b:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto La9
            java.lang.Object r11 = r5.next()
            kotlin.jvm.functions.Function3 r7 = r10.f141278h
            int r8 = r1 + 1
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.d(r1)
            r10.f141276f = r6
            r10.f141272a = r5
            r10.f141273b = r6
            r10.f141274c = r8
            r10.f141275d = r3
            java.lang.Object r11 = r7.invoke(r1, r11, r10)
            if (r11 != r0) goto L90
            goto La5
        L90:
            r7 = r6
            r1 = r8
            r6 = r5
            r5 = r7
        L94:
            r10.f141276f = r7
            r10.f141272a = r6
            r8 = 0
            r10.f141273b = r8
            r10.f141274c = r1
            r10.f141275d = r2
            java.lang.Object r11 = r5.y(r11, r10)
            if (r11 != r0) goto La6
        La5:
            return r0
        La6:
            r5 = r6
            r11 = r7
            goto L59
        La9:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
