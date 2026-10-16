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
public final class HashingSource extends ForwardingSource implements Source {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f145055d = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MessageDigest f145056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Mac f145057c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // okio.ForwardingSource, okio.Source
    public long t2(Buffer sink, long j3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long jT2 = super.t2(sink, j3);
        if (jT2 != -1) {
            long size = sink.size() - jT2;
            long size2 = sink.size();
            Segment segment = sink.f144986a;
            Intrinsics.checkNotNull(segment);
            while (size2 > size) {
                segment = segment.f145110g;
                Intrinsics.checkNotNull(segment);
                size2 -= (long) (segment.f145106c - segment.f145105b);
            }
            while (size2 < sink.size()) {
                int i3 = (int) ((((long) segment.f145105b) + size) - size2);
                MessageDigest messageDigest = this.f145056b;
                if (messageDigest != null) {
                    messageDigest.update(segment.f145104a, i3, segment.f145106c - i3);
                } else {
                    Mac mac = this.f145057c;
                    Intrinsics.checkNotNull(mac);
                    mac.update(segment.f145104a, i3, segment.f145106c - i3);
                }
                size2 += (long) (segment.f145106c - segment.f145105b);
                segment = segment.f145109f;
                Intrinsics.checkNotNull(segment);
                size = size2;
            }
        }
        return jT2;
    }
}
