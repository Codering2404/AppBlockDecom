package okio;

import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class HashingSink extends ForwardingSink implements Sink {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f145052d = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MessageDigest f145053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Mac f145054c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void H0(Buffer source, long j3) {
        Intrinsics.checkNotNullParameter(source, "source");
        SegmentedByteString.b(source.size(), 0L, j3);
        Segment segment = source.f144986a;
        Intrinsics.checkNotNull(segment);
        long j4 = 0;
        while (j4 < j3) {
            int iMin = (int) Math.min(j3 - j4, segment.f145106c - segment.f145105b);
            MessageDigest messageDigest = this.f145053b;
            if (messageDigest != null) {
                messageDigest.update(segment.f145104a, segment.f145105b, iMin);
            } else {
                Mac mac = this.f145054c;
                Intrinsics.checkNotNull(mac);
                mac.update(segment.f145104a, segment.f145105b, iMin);
            }
            j4 += (long) iMin;
            segment = segment.f145109f;
            Intrinsics.checkNotNull(segment);
        }
        super.H0(source, j3);
    }
}
