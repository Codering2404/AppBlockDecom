package okhttp3.internal.http2;

import com.applovin.exoplayer2.common.base.Ascii;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

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
public final class Huffman {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Huffman f144773a = new Huffman();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f144774b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f144775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Node f144776d;

    static {
        byte[] bArr = {Ascii.CR, Ascii.ETB, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.CAN, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, 6, 10, 10, Ascii.FF, Ascii.CR, 6, 8, Ascii.VT, 10, 10, 8, Ascii.VT, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, Ascii.SI, 6, Ascii.FF, 10, Ascii.CR, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, Ascii.CR, 19, Ascii.CR, Ascii.SO, 6, Ascii.SI, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, Ascii.SI, Ascii.VT, Ascii.SO, Ascii.CR, Ascii.FS, Ascii.DC4, Ascii.SYN, Ascii.DC4, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.CAN, Ascii.CAN, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.SYN, Ascii.NAK, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.CAN, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SUB, Ascii.SUB, Ascii.DC4, 19, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.EM, Ascii.SUB, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.CAN, Ascii.EM, 19, Ascii.NAK, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.ESC, Ascii.CAN, Ascii.NAK, Ascii.NAK, Ascii.SUB, Ascii.SUB, Ascii.FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.DC4, Ascii.CAN, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.EM, Ascii.EM, Ascii.CAN, Ascii.CAN, Ascii.SUB, Ascii.ETB, Ascii.SUB, Ascii.ESC, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.SUB};
        f144775c = bArr;
        f144776d = new Node();
        int length = bArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            f144773a.a(i3, f144774b[i3], f144775c[i3]);
        }
    }

    private Huffman() {
    }

    private final void a(int i3, int i4, int i5) {
        Node node = new Node(i3, i5);
        Node node2 = f144776d;
        while (i5 > 8) {
            i5 -= 8;
            int i6 = (i4 >>> i5) & 255;
            Node[] nodeArrA = node2.a();
            Intrinsics.checkNotNull(nodeArrA);
            Node node3 = nodeArrA[i6];
            if (node3 == null) {
                node3 = new Node();
                nodeArrA[i6] = node3;
            }
            node2 = node3;
        }
        int i7 = 8 - i5;
        int i8 = (i4 << i7) & 255;
        Node[] nodeArrA2 = node2.a();
        Intrinsics.checkNotNull(nodeArrA2);
        ArraysKt.fill(nodeArrA2, node, i8, (1 << i7) + i8);
    }

    public final void b(BufferedSource source, long j3, BufferedSink sink) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        Node node = f144776d;
        int iD = 0;
        long j4 = 0;
        int iC = 0;
        while (j4 < j3) {
            j4++;
            iD = (iD << 8) | Util.d(source.readByte(), 255);
            iC += 8;
            while (iC >= 8) {
                Node[] nodeArrA = node.a();
                Intrinsics.checkNotNull(nodeArrA);
                node = nodeArrA[(iD >>> (iC - 8)) & 255];
                Intrinsics.checkNotNull(node);
                if (node.a() == null) {
                    sink.writeByte(node.b());
                    iC -= node.c();
                    node = f144776d;
                } else {
                    iC -= 8;
                }
            }
        }
        while (iC > 0) {
            Node[] nodeArrA2 = node.a();
            Intrinsics.checkNotNull(nodeArrA2);
            Node node2 = nodeArrA2[(iD << (8 - iC)) & 255];
            Intrinsics.checkNotNull(node2);
            if (node2.a() != null || node2.c() > iC) {
                return;
            }
            sink.writeByte(node2.b());
            iC -= node2.c();
            node = f144776d;
        }
    }

    public final void c(ByteString source, BufferedSink sink) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        int iC = source.C();
        long j3 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < iC) {
            int i5 = i3 + 1;
            int iD = Util.d(source.g(i3), 255);
            int i6 = f144774b[iD];
            byte b3 = f144775c[iD];
            j3 = (j3 << b3) | ((long) i6);
            i4 += b3;
            while (i4 >= 8) {
                i4 -= 8;
                sink.writeByte((int) (j3 >> i4));
            }
            i3 = i5;
        }
        if (i4 > 0) {
            sink.writeByte((int) ((j3 << (8 - i4)) | (255 >>> i4)));
        }
    }

    public final int d(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int iC = bytes.C();
        long j3 = 0;
        int i3 = 0;
        while (i3 < iC) {
            int i4 = i3 + 1;
            j3 += (long) f144775c[Util.d(bytes.g(i3), 255)];
            i3 = i4;
        }
        return (int) ((j3 + ((long) 7)) >> 3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Node {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Node[] f144777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f144778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f144779c;

        public Node() {
            this.f144777a = new Node[Function.MAX_NARGS];
            this.f144778b = 0;
            this.f144779c = 0;
        }

        public final Node[] a() {
            return this.f144777a;
        }

        public final int b() {
            return this.f144778b;
        }

        public final int c() {
            return this.f144779c;
        }

        public Node(int i3, int i4) {
            this.f144777a = null;
            this.f144778b = i3;
            int i5 = i4 & 7;
            this.f144779c = i5 == 0 ? 8 : i5;
        }
    }
}
