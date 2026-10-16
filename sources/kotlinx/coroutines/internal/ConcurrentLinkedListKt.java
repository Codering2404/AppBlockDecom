package kotlinx.coroutines.internal;

import kotlin.Metadata;
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
public final class ConcurrentLinkedListKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Symbol f142427a = new Symbol("CLOSED");

    public static final ConcurrentLinkedListNode b(ConcurrentLinkedListNode concurrentLinkedListNode) {
        while (true) {
            Object objG = concurrentLinkedListNode.g();
            if (objG == f142427a) {
                return concurrentLinkedListNode;
            }
            ConcurrentLinkedListNode concurrentLinkedListNode2 = (ConcurrentLinkedListNode) objG;
            if (concurrentLinkedListNode2 != null) {
                concurrentLinkedListNode = concurrentLinkedListNode2;
            } else if (concurrentLinkedListNode.m()) {
                return concurrentLinkedListNode;
            }
        }
    }

    public static final Object c(Segment segment, long j3, Function2 function2) {
        while (true) {
            if (segment.f142482c >= j3 && !segment.k()) {
                return SegmentOrClosed.a(segment);
            }
            Object objG = segment.g();
            if (objG == f142427a) {
                return SegmentOrClosed.a(f142427a);
            }
            Segment segment2 = (Segment) ((ConcurrentLinkedListNode) objG);
            if (segment2 == null) {
                segment2 = (Segment) function2.invoke(Long.valueOf(segment.f142482c + 1), segment);
                if (segment.o(segment2)) {
                    if (segment.k()) {
                        segment.n();
                    }
                }
            }
            segment = segment2;
        }
    }
}
