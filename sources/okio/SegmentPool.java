package okio;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class SegmentPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SegmentPool f145111a = new SegmentPool();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f145112b = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Segment f145113c = new Segment(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f145114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicReference[] f145115e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f145114d = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i3 = 0; i3 < iHighestOneBit; i3++) {
            atomicReferenceArr[i3] = new AtomicReference();
        }
        f145115e = atomicReferenceArr;
    }

    private SegmentPool() {
    }

    private final AtomicReference a() {
        return f145115e[(int) (Thread.currentThread().getId() & (((long) f145114d) - 1))];
    }

    public static final void b(Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (segment.f145109f != null || segment.f145110g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.f145107d) {
            return;
        }
        AtomicReference atomicReferenceA = f145111a.a();
        Segment segment2 = f145113c;
        Segment segment3 = (Segment) atomicReferenceA.getAndSet(segment2);
        if (segment3 == segment2) {
            return;
        }
        int i3 = segment3 != null ? segment3.f145106c : 0;
        if (i3 >= f145112b) {
            atomicReferenceA.set(segment3);
            return;
        }
        segment.f145109f = segment3;
        segment.f145105b = 0;
        segment.f145106c = i3 + Utility.DEFAULT_STREAM_BUFFER_SIZE;
        atomicReferenceA.set(segment);
    }

    public static final Segment c() {
        AtomicReference atomicReferenceA = f145111a.a();
        Segment segment = f145113c;
        Segment segment2 = (Segment) atomicReferenceA.getAndSet(segment);
        if (segment2 == segment) {
            return new Segment();
        }
        if (segment2 == null) {
            atomicReferenceA.set(null);
            return new Segment();
        }
        atomicReferenceA.set(segment2.f145109f);
        segment2.f145109f = null;
        segment2.f145106c = 0;
        return segment2;
    }
}
