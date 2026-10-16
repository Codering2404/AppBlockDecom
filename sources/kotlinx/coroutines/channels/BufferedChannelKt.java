package kotlinx.coroutines.channels;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

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
public final class BufferedChannelKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ChannelSegment f141104a = new ChannelSegment(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f141105b = SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f141106c = SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", ColorExtractionConstants.MAX_PIXEL_SAMPLES, 0, 0, 12, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Symbol f141107d = new Symbol("BUFFERED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Symbol f141108e = new Symbol("SHOULD_BUFFER");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Symbol f141109f = new Symbol("S_RESUMING_BY_RCV");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Symbol f141110g = new Symbol("RESUMING_BY_EB");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Symbol f141111h = new Symbol("POISONED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Symbol f141112i = new Symbol("DONE_RCV");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Symbol f141113j = new Symbol("INTERRUPTED_SEND");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Symbol f141114k = new Symbol("INTERRUPTED_RCV");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Symbol f141115l = new Symbol("CHANNEL_CLOSED");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Symbol f141116m = new Symbol("SUSPEND");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Symbol f141117n = new Symbol("SUSPEND_NO_WAITER");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Symbol f141118o = new Symbol("FAILED");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Symbol f141119p = new Symbol("NO_RECEIVE_RESULT");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Symbol f141120q = new Symbol("CLOSE_HANDLER_CLOSED");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Symbol f141121r = new Symbol("CLOSE_HANDLER_INVOKED");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Symbol f141122s = new Symbol("NO_CLOSE_CAUSE");

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A(int i3) {
        if (i3 == 0) {
            return 0L;
        }
        if (i3 != Integer.MAX_VALUE) {
            return i3;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(CancellableContinuation cancellableContinuation, Object obj, Function3 function3) {
        Object objQ = cancellableContinuation.Q(obj, null, function3);
        if (objQ == null) {
            return false;
        }
        cancellableContinuation.R(objQ);
        return true;
    }

    static /* synthetic */ boolean C(CancellableContinuation cancellableContinuation, Object obj, Function3 function3, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            function3 = null;
        }
        return B(cancellableContinuation, obj, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(long j3, boolean z2) {
        return (z2 ? 4611686018427387904L : 0L) + j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w(long j3, int i3) {
        return (((long) i3) << 60) + j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChannelSegment x(long j3, ChannelSegment channelSegment) {
        return new ChannelSegment(j3, channelSegment, channelSegment.y(), 0);
    }

    public static final KFunction y() {
        return BufferedChannelKt$createSegmentFunction$1.f141123a;
    }

    public static final Symbol z() {
        return f141115l;
    }
}
