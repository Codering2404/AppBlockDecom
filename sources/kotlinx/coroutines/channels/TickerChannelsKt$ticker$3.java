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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", l = {68, 69}, m = "invokeSuspend")
final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f141370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f141371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TickerMode f141372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f141373d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f141374f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f141375a;

        static {
            int[] iArr = new int[TickerMode.values().length];
            try {
                iArr[TickerMode.f141376a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TickerMode.f141377b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f141375a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TickerChannelsKt$ticker$3(TickerMode tickerMode, long j3, long j4, Continuation continuation) {
        super(2, continuation);
        this.f141372c = tickerMode;
        this.f141373d = j3;
        this.f141374f = j4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TickerChannelsKt$ticker$3 tickerChannelsKt$ticker$3 = new TickerChannelsKt$ticker$3(this.f141372c, this.f141373d, this.f141374f, continuation);
        tickerChannelsKt$ticker$3.f141371b = obj;
        return tickerChannelsKt$ticker$3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((TickerChannelsKt$ticker$3) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        if (kotlinx.coroutines.channels.TickerChannelsKt.c(r4, r6, r8, r10) == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        if (kotlinx.coroutines.channels.TickerChannelsKt.d(r1, r3, r11, r10) == r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f141370a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r11)
            r6 = r10
            goto L62
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1b:
            kotlin.ResultKt.b(r11)
            goto L62
        L1f:
            kotlin.ResultKt.b(r11)
            java.lang.Object r11 = r10.f141371b
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
            kotlinx.coroutines.channels.TickerMode r1 = r10.f141372c
            int[] r4 = kotlinx.coroutines.channels.TickerChannelsKt$ticker$3.WhenMappings.f141375a
            int r1 = r1.ordinal()
            r1 = r4[r1]
            if (r1 == r3) goto L4e
            if (r1 != r2) goto L47
            long r4 = r10.f141373d
            long r6 = r10.f141374f
            kotlinx.coroutines.channels.SendChannel r8 = r11.n()
            r10.f141370a = r2
            r9 = r10
            java.lang.Object r11 = kotlinx.coroutines.channels.TickerChannelsKt.a(r4, r6, r8, r9)
            r6 = r9
            if (r11 != r0) goto L62
            goto L61
        L47:
            r6 = r10
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L4e:
            r6 = r10
            long r1 = r6.f141373d
            r5 = r3
            long r3 = r6.f141374f
            kotlinx.coroutines.channels.SendChannel r11 = r11.n()
            r6.f141370a = r5
            r5 = r11
            java.lang.Object r11 = kotlinx.coroutines.channels.TickerChannelsKt.b(r1, r3, r5, r6)
            if (r11 != r0) goto L62
        L61:
            return r0
        L62:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
