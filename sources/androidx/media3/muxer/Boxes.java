package androidx.media3.muxer;

import android.media.MediaCodec;
import android.util.Pair;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.container.XmpData;
import androidx.media3.muxer.FragmentedMp4Writer;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.dumpapp.Framer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Bytes;
import com.google.common.primitives.Ints;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Boxes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImmutableList f47799a = ImmutableList.I((byte) -66, (byte) 122, (byte) -49, (byte) -53, (byte) -105, (byte) -87, (byte) 66, (byte) -24, (byte) -100, (byte) 113, (byte) -103, (byte) -108, (byte) -111, (byte) -29, (byte) -81, (byte) -84);

    public static int A(int i3, boolean z2) {
        return ((z2 ? 4 : 3) * i3 * 4) + 12;
    }

    private static ByteBuffer B(Format format) {
        Assertions.b(format.f40635r.size() > 1, "csd-1 should contain setup header for Vorbis.");
        byte[] bArr = (byte[]) format.f40635r.get(0);
        int length = bArr.length / 255;
        int i3 = length + 1;
        byte[] bArr2 = new byte[i3];
        Arrays.fill(bArr2, (byte) -1);
        bArr2[length] = (byte) (bArr.length % 255);
        byte[] bArr3 = (byte[]) format.f40635r.get(1);
        Assertions.b(bArr3.length > 0, "csd-1 should be present and contain setup header for Vorbis.");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i3 + bArr.length + bArr3.length + 2);
        byteBufferAllocate.put((byte) 2);
        byteBufferAllocate.put(bArr2);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.put(bArr3);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static ByteBuffer C(String str, String str2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put(Util.t0(str));
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put(Util.t0(str2));
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.flip();
        return BoxUtils.c("hdlr", byteBufferAllocate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ByteBuffer D(Format format) {
        Assertions.b(!format.f40635r.isEmpty(), "csd-0 not found in the format for hvcC box.");
        byte[] bArr = (byte[]) format.f40635r.get(0);
        Assertions.b(bArr.length > 0, "csd-0 is empty for hvcC box.");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferWrap.limit() + 200);
        ImmutableList immutableListC = AnnexBUtils.c(byteBufferWrap);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < immutableListC.size(); i3++) {
            arrayList.add(AnnexBUtils.f((ByteBuffer) immutableListC.get(i3)));
        }
        byteBufferAllocate.put((byte) 1);
        ByteBuffer byteBuffer = (ByteBuffer) arrayList.get(0);
        if (byteBuffer.get(byteBuffer.position()) != 64) {
            throw new IllegalArgumentException("First NALU in csd-0 is not the VPS.");
        }
        byteBufferAllocate.put(byteBuffer.get(6));
        byteBufferAllocate.putInt(byteBuffer.getInt(7));
        byteBufferAllocate.putInt(byteBuffer.getInt(11));
        byteBufferAllocate.putShort(byteBuffer.getShort(15));
        byteBufferAllocate.put(byteBuffer.get(17));
        byteBufferAllocate.putShort((short) -4096);
        byteBufferAllocate.put((byte) -4);
        ByteBuffer byteBuffer2 = (ByteBuffer) immutableListC.get(1);
        int iRemaining = byteBuffer2.remaining();
        byte[] bArr2 = new byte[iRemaining];
        byteBuffer2.get(bArr2);
        byteBuffer2.rewind();
        NalUnitUtil.H265SpsData h265SpsDataU = NalUnitUtil.u(bArr2, 0, iRemaining, null);
        byte b3 = (byte) (h265SpsDataU.f41710d | 252);
        byte b4 = (byte) (h265SpsDataU.f41711e | 248);
        byte b5 = (byte) (h265SpsDataU.f41712f | 248);
        byteBufferAllocate.put(b3);
        byteBufferAllocate.put(b4);
        byteBufferAllocate.put(b5);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.put(Ascii.SI);
        byteBufferAllocate.put((byte) immutableListC.size());
        for (int i4 = 0; i4 < immutableListC.size(); i4++) {
            ByteBuffer byteBuffer3 = (ByteBuffer) immutableListC.get(i4);
            byteBufferAllocate.put((byte) ((byteBuffer3.get(0) >> 1) & 63));
            byteBufferAllocate.putShort((short) 1);
            byteBufferAllocate.putShort((short) byteBuffer3.limit());
            byteBufferAllocate.put(byteBuffer3);
        }
        byteBufferAllocate.flip();
        return BoxUtils.c("hvcC", byteBufferAllocate);
    }

    public static ByteBuffer E(List list) {
        int i3 = 0;
        int length = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            length += ((MdtaMetadataEntry) list.get(i4)).f41659b.length + 24;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        while (i3 < list.size()) {
            int i5 = i3 + 1;
            MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) list.get(i3);
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(mdtaMetadataEntry.f41659b.length + 8);
            byteBufferAllocate2.putInt(mdtaMetadataEntry.f41661d);
            byteBufferAllocate2.putInt(mdtaMetadataEntry.f41660c);
            byteBufferAllocate2.put(mdtaMetadataEntry.f41659b);
            byteBufferAllocate2.flip();
            ByteBuffer byteBufferC = BoxUtils.c("data", byteBufferAllocate2);
            byteBufferAllocate.putInt(byteBufferC.remaining() + 8);
            byteBufferAllocate.putInt(i5);
            byteBufferAllocate.put(byteBufferC);
            i3 = i5;
        }
        byteBufferAllocate.flip();
        return BoxUtils.c("ilst", byteBufferAllocate);
    }

    public static ByteBuffer F(List list) {
        int length = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            length += ((MdtaMetadataEntry) list.get(i3)).f41658a.length() + 8;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            byteBufferAllocate.put(BoxUtils.c("mdta", ByteBuffer.wrap(Util.t0(((MdtaMetadataEntry) list.get(i4)).f41658a))));
        }
        byteBufferAllocate.flip();
        return BoxUtils.c("keys", byteBufferAllocate);
    }

    private static short G(String str) {
        if (str != null) {
            byte[] bArrT0 = Util.t0(str);
            if (bArrT0.length == 3) {
                return (short) (((bArrT0[2] & Ascii.US) + ((bArrT0[1] & Ascii.US) << 5) + ((bArrT0[0] & Ascii.US) << 10)) & 32767);
            }
        }
        return (short) 0;
    }

    public static ByteBuffer H() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.flip();
        return BoxUtils.c("url ", byteBufferAllocate);
    }

    public static ByteBuffer I(long j3, int i3, int i4, int i5, String str) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(i4);
        byteBufferAllocate.putInt(i5);
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.putInt((int) j3);
        byteBufferAllocate.putShort(G(str));
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.flip();
        return BoxUtils.c("mdhd", byteBufferAllocate);
    }

    public static ByteBuffer J(ByteBuffer... byteBufferArr) {
        return BoxUtils.b("mdia", Arrays.asList(byteBufferArr));
    }

    public static ByteBuffer K(ByteBuffer... byteBufferArr) {
        return BoxUtils.b("meta", Arrays.asList(byteBufferArr));
    }

    public static ByteBuffer L(int i3) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.flip();
        return BoxUtils.c("mfhd", byteBufferAllocate);
    }

    public static ByteBuffer M(ByteBuffer... byteBufferArr) {
        return BoxUtils.b("minf", Arrays.asList(byteBufferArr));
    }

    public static ByteBuffer N(ByteBuffer byteBuffer, List list) {
        return BoxUtils.b("moof", new ImmutableList.Builder().a(byteBuffer).k(list).m());
    }

    public static ByteBuffer O(List list, MetadataCollector metadataCollector, boolean z2, int i3) {
        long j3;
        ByteBuffer byteBufferX;
        String str;
        String str2;
        ByteBuffer byteBufferP0;
        int i4;
        long j4;
        ArrayList arrayList;
        Mp4TimestampData mp4TimestampData = metadataCollector.f47839d;
        int i5 = (int) mp4TimestampData.f41671a;
        int i6 = (int) mp4TimestampData.f41672b;
        long jV = v(list);
        if (!z2 && jV == -9223372036854775807L) {
            return ByteBuffer.allocate(0);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i7 = 0;
        long jMax = 0;
        int i8 = 1;
        while (i7 < list.size()) {
            Track track = (Track) list.get(i7);
            if (z2 || !track.f47892d.isEmpty()) {
                Format format = track.f47890b;
                String strE = e(format.f40621d);
                int i9 = i8;
                long j5 = jMax;
                List listK = k(track.f47892d, track.a(), i3, track.f47898j);
                ArrayList arrayList4 = arrayList2;
                ArrayList arrayList5 = arrayList3;
                long jIntValue = 0;
                for (int i10 = 0; i10 < listK.size(); i10++) {
                    jIntValue += (long) ((Integer) listK.get(i10)).intValue();
                }
                long j6 = track.f47892d.isEmpty() ? 0L : ((MediaCodec.BufferInfo) track.f47892d.get(0)).presentationTimeUs;
                long jM0 = m0(jIntValue, track.a());
                int iK = MimeTypes.k(format.f40632o);
                ByteBuffer byteBufferD0 = d0(listK);
                long j7 = jIntValue;
                ByteBuffer byteBufferL = MimeTypes.q(format.f40632o) ? l(track.f47892d, listK, track.a()) : ByteBuffer.allocate(0);
                ByteBuffer byteBufferC0 = c0(track.f47892d);
                ByteBuffer byteBufferZ = Z(track.f47894f);
                List list2 = track.f47893e;
                ByteBuffer byteBufferY = z2 ? Y(list2) : g(list2);
                if (iK == -1 || iK == 5) {
                    j3 = jM0;
                    ByteBuffer byteBufferR = R();
                    byteBufferX = X(a0(e0(format)), byteBufferD0, byteBufferC0, byteBufferZ, byteBufferY);
                    str = "MetaHandle";
                    str2 = "meta";
                    byteBufferP0 = byteBufferR;
                } else if (iK == 1) {
                    ByteBuffer byteBufferW = W();
                    j3 = jM0;
                    byteBufferX = X(a0(b(format)), byteBufferD0, byteBufferC0, byteBufferZ, byteBufferY);
                    str = "SoundHandle";
                    str2 = "soun";
                    byteBufferP0 = byteBufferW;
                } else {
                    if (iK != 2) {
                        throw new IllegalArgumentException("Unsupported track type");
                    }
                    byteBufferP0 = p0();
                    byteBufferX = X(a0(o0(format)), byteBufferD0, byteBufferL, byteBufferC0, byteBufferZ, byteBufferY, b0(track.f47892d));
                    j3 = jM0;
                    str2 = "vide";
                    str = "VideoHandle";
                }
                String str3 = str;
                i4 = i7;
                long j8 = j3;
                j4 = jV;
                ByteBuffer byteBufferI0 = i0(g0(i9, j3, i5, i6, metadataCollector.f47836a.f41670a, format), r(j6, jV, j8, 10000L, track.a()), J(I(j7, track.a(), i5, i6, strE), C(str2, str3), M(byteBufferP0, p(q(H())), byteBufferX)));
                arrayList2 = arrayList4;
                arrayList2.add(byteBufferI0);
                jMax = Math.max(j5, j8);
                arrayList = arrayList5;
                arrayList.add(j0(i9));
                i8 = i9 + 1;
            } else {
                arrayList = arrayList3;
                j4 = jV;
                i4 = i7;
            }
            i7 = i4 + 1;
            arrayList3 = arrayList;
            jV = j4;
        }
        ArrayList arrayList6 = arrayList3;
        ByteBuffer byteBufferQ = Q(i8, i5, i6, jMax);
        ByteBuffer byteBufferL0 = l0(metadataCollector.f47837b);
        ByteBuffer byteBufferAllocate = metadataCollector.f47838c.isEmpty() ? ByteBuffer.allocate(0) : K(C("mdta", ""), F(Lists.j(metadataCollector.f47838c)), E(Lists.j(metadataCollector.f47838c)));
        ArrayList arrayList7 = new ArrayList();
        arrayList7.add(byteBufferQ);
        arrayList7.add(byteBufferL0);
        arrayList7.add(byteBufferAllocate);
        arrayList7.addAll(arrayList2);
        if (z2) {
            arrayList7.add(P(arrayList6));
        }
        ByteBuffer byteBufferB = BoxUtils.b("moov", arrayList7);
        XmpData xmpData = metadataCollector.f47840e;
        return xmpData != null ? BoxUtils.a(byteBufferB, n0(f47799a, ByteBuffer.wrap(xmpData.f41775a))) : byteBufferB;
    }

    public static ByteBuffer P(List list) {
        return BoxUtils.b("mvex", list);
    }

    public static ByteBuffer Q(int i3, int i4, int i5, long j3) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(i4);
        byteBufferAllocate.putInt(i5);
        byteBufferAllocate.putInt(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        byteBufferAllocate.putInt((int) r0(j3, 10000L));
        byteBufferAllocate.putInt(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        byteBufferAllocate.putShort((short) 256);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        int[] iArr = {NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 0, 0, 0, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 0, 0, 0, 1073741824};
        for (int i6 = 0; i6 < 9; i6++) {
            byteBufferAllocate.putInt(iArr[i6]);
        }
        for (int i7 = 0; i7 < 6; i7++) {
            byteBufferAllocate.putInt(0);
        }
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.flip();
        return BoxUtils.c("mvhd", byteBufferAllocate);
    }

    public static ByteBuffer R() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.flip();
        return BoxUtils.c("nmhd", byteBufferAllocate);
    }

    private static ByteBuffer S(byte[] bArr, int i3) {
        byte b3 = 10;
        int i4 = 8;
        byte b4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < bArr.length; i6 += 3) {
            byte b5 = bArr[i6];
            int i7 = i6 + 2;
            if (b5 == 1) {
                b4 = bArr[i7];
            } else if (b5 == 2) {
                b3 = bArr[i7];
            } else if (b5 == 3) {
                i4 = bArr[i7];
            } else if (b5 == 4) {
                i5 = bArr[i7];
            }
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(3);
        byteBufferAllocate.put(b4);
        byteBufferAllocate.put(b3);
        byteBufferAllocate.put((byte) (i3 | (i4 << 4) | (i5 << 1)));
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static ByteBuffer T() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        byteBufferAllocate.putInt(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        byteBufferAllocate.rewind();
        return BoxUtils.c("pasp", byteBufferAllocate);
    }

    private static byte[] U(int i3) {
        if (i3 == 0) {
            return Util.n1(NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 0, 0, 0, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 0, 0, 0, 1073741824);
        }
        if (i3 == 90) {
            return Util.n1(0, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 0, -65536, 0, 0, 0, 0, 1073741824);
        }
        if (i3 == 180) {
            return Util.n1(-65536, 0, 0, 0, -65536, 0, 0, 0, 1073741824);
        }
        if (i3 == 270) {
            return Util.n1(0, -65536, 0, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 0, 0, 0, 0, 1073741824);
        }
        throw new IllegalArgumentException("invalid orientation " + i3);
    }

    private static ByteBuffer V(ColorInfo colorInfo) {
        byte[] bArr = colorInfo.f40557d;
        if (bArr == null) {
            return ByteBuffer.allocate(0);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.flip();
        return BoxUtils.c("SmDm", byteBufferAllocate);
    }

    public static ByteBuffer W() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.flip();
        return BoxUtils.c("smhd", byteBufferAllocate);
    }

    public static ByteBuffer X(ByteBuffer... byteBufferArr) {
        return BoxUtils.b("stbl", Arrays.asList(byteBufferArr));
    }

    public static ByteBuffer Y(List list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 4) + 8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue = ((Long) list.get(i3)).longValue();
            Assertions.h(jLongValue <= 4294967295L, "Only 32-bit chunk offset is allowed");
            byteBufferAllocate.putInt((int) jLongValue);
        }
        byteBufferAllocate.flip();
        return BoxUtils.c("stco", byteBufferAllocate);
    }

    public static ByteBuffer Z(List list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 12) + 200);
        byteBufferAllocate.putInt(0);
        int iPosition = byteBufferAllocate.position();
        byteBufferAllocate.putInt(0);
        int i3 = 1;
        int i4 = -1;
        int i5 = 0;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int iIntValue = ((Integer) list.get(i6)).intValue();
            if (iIntValue != i4) {
                byteBufferAllocate.putInt(i3);
                byteBufferAllocate.putInt(iIntValue);
                byteBufferAllocate.putInt(1);
                i5++;
                i4 = iIntValue;
            }
            i3++;
        }
        byteBufferAllocate.putInt(iPosition, i5);
        byteBufferAllocate.flip();
        return BoxUtils.c("stsc", byteBufferAllocate);
    }

    private static ByteBuffer a(Format format) {
        Assertions.b(!format.f40635r.isEmpty(), "csd-0 is not found in the format for avpC box");
        byte[] bArr = (byte[]) format.f40635r.get(0);
        Assertions.b(bArr.length > 0, "csd-0 is empty for avpC box.");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + 4);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.flip();
        return BoxUtils.c("apvC", byteBufferAllocate);
    }

    public static ByteBuffer a0(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.limit() + 200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.put(byteBuffer);
        byteBufferAllocate.flip();
        return BoxUtils.c("stsd", byteBufferAllocate);
    }

    public static ByteBuffer b(Format format) {
        String strI = i(format);
        ByteBuffer byteBufferH = h(format);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferH.remaining() + 200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 1);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) format.E);
        byteBufferAllocate.putShort((short) 16);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putInt(format.F << 16);
        byteBufferAllocate.put(byteBufferH);
        byteBufferAllocate.flip();
        return BoxUtils.c(strI, byteBufferAllocate);
    }

    public static ByteBuffer b0(List list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 4) + 200);
        byteBufferAllocate.putInt(0);
        int iPosition = byteBufferAllocate.position();
        byteBufferAllocate.putInt(list.size());
        int i3 = 0;
        int i4 = 1;
        for (int i5 = 0; i5 < list.size(); i5++) {
            if ((((MediaCodec.BufferInfo) list.get(i5)).flags & 1) > 0) {
                byteBufferAllocate.putInt(i4);
                i3++;
            }
            i4++;
        }
        byteBufferAllocate.putInt(iPosition, i3);
        byteBufferAllocate.flip();
        return BoxUtils.c("stss", byteBufferAllocate);
    }

    private static ByteBuffer c(Format format) {
        Assertions.b(!format.f40635r.isEmpty(), "csd-0 is not found in the format for av1C box");
        byte[] bArr = (byte[]) format.f40635r.get(0);
        Assertions.b(bArr.length > 0, "csd-0 is empty for av1C box.");
        return BoxUtils.c("av1C", ByteBuffer.wrap(bArr));
    }

    public static ByteBuffer c0(List list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 4) + 200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            byteBufferAllocate.putInt(((MediaCodec.BufferInfo) list.get(i3)).size);
        }
        byteBufferAllocate.flip();
        return BoxUtils.c("stsz", byteBufferAllocate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static ByteBuffer d(Format format) {
        Assertions.b(format.f40635r.size() >= 2, "csd-0 and/or csd-1 not found in the format for avcC box.");
        byte[] bArr = (byte[]) format.f40635r.get(0);
        Assertions.b(bArr.length > 0, "csd-0 is empty for avcC box.");
        byte[] bArr2 = (byte[]) format.f40635r.get(1);
        Assertions.b(bArr2.length > 0, "csd-1 is empty for avcC box.");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr2);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferWrap.limit() + byteBufferWrap2.limit() + 200);
        byteBufferAllocate.put((byte) 1);
        ImmutableList immutableListC = AnnexBUtils.c(byteBufferWrap);
        Assertions.b(immutableListC.size() == 1, "SPS data not found in csd0 for avcC box.");
        ByteBuffer byteBuffer = (ByteBuffer) immutableListC.get(0);
        int iRemaining = byteBuffer.remaining();
        byte[] bArr3 = new byte[iRemaining];
        byteBuffer.get(bArr3);
        byteBuffer.rewind();
        NalUnitUtil.SpsData spsDataC = NalUnitUtil.C(bArr3, 0, iRemaining);
        byteBufferAllocate.put((byte) spsDataC.f41734a);
        byteBufferAllocate.put((byte) spsDataC.f41735b);
        byteBufferAllocate.put((byte) spsDataC.f41736c);
        byteBufferAllocate.put((byte) -1);
        byteBufferAllocate.put((byte) -31);
        byteBufferAllocate.putShort((short) byteBuffer.remaining());
        byteBufferAllocate.put(byteBuffer);
        byteBuffer.rewind();
        ImmutableList immutableListC2 = AnnexBUtils.c(byteBufferWrap2);
        Assertions.h(immutableListC2.size() == 1, "PPS data not found in csd1.");
        byteBufferAllocate.put((byte) 1);
        ByteBuffer byteBuffer2 = (ByteBuffer) immutableListC2.get(0);
        byteBufferAllocate.putShort((short) byteBuffer2.remaining());
        byteBufferAllocate.put(byteBuffer2);
        byteBuffer2.rewind();
        byteBufferAllocate.flip();
        return BoxUtils.c("avcC", byteBufferAllocate);
    }

    public static ByteBuffer d0(List list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 8) + 200);
        byteBufferAllocate.putInt(0);
        int iPosition = byteBufferAllocate.position();
        byteBufferAllocate.putInt(0);
        int i3 = -1;
        long j3 = -1;
        int i4 = 0;
        for (int i5 = 0; i5 < list.size(); i5++) {
            int iIntValue = ((Integer) list.get(i5)).intValue();
            long j4 = iIntValue;
            if (j3 != j4) {
                int iPosition2 = byteBufferAllocate.position();
                byteBufferAllocate.putInt(1);
                byteBufferAllocate.putInt(iIntValue);
                i4++;
                i3 = iPosition2;
                j3 = j4;
            } else {
                byteBufferAllocate.putInt(i3, byteBufferAllocate.getInt(i3) + 1);
            }
        }
        byteBufferAllocate.putInt(iPosition, i4);
        byteBufferAllocate.flip();
        return BoxUtils.c("stts", byteBufferAllocate);
    }

    private static String e(String str) {
        if (str == null) {
            return null;
        }
        Locale localeForLanguageTag = Locale.forLanguageTag(str);
        return localeForLanguageTag.getISO3Language().isEmpty() ? str : localeForLanguageTag.getISO3Language();
    }

    public static ByteBuffer e0(Format format) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byte[] bArrT0 = Util.t0((String) Assertions.e(format.f40632o));
        byteBufferAllocate.put(bArrT0);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.put(bArrT0);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.flip();
        return BoxUtils.c("mett", byteBufferAllocate);
    }

    public static List f(List list, List list2, int i3) {
        List list3 = list;
        ArrayList arrayList = new ArrayList(list3.size());
        if (!list3.isEmpty()) {
            boolean z2 = false;
            long j3 = ((MediaCodec.BufferInfo) list3.get(0)).presentationTimeUs;
            long jIntValue = 0;
            int i4 = 0;
            boolean z3 = false;
            long j4 = 0;
            while (i4 < list3.size()) {
                long j5 = ((MediaCodec.BufferInfo) list3.get(i4)).presentationTimeUs - j3;
                long jR0 = r0(j5, i3) - jIntValue;
                if (jR0 <= 2147483647L) {
                    z2 = true;
                }
                Assertions.h(z2, "Only 32-bit composition offset is allowed");
                long j6 = j3;
                jIntValue += (long) ((Integer) list2.get(i4)).intValue();
                arrayList.add(Integer.valueOf((int) jR0));
                if (j5 < j4) {
                    z3 = true;
                }
                i4++;
                list3 = list;
                j4 = j5;
                j3 = j6;
                z2 = false;
            }
            if (!z3) {
                arrayList.clear();
            }
        }
        return arrayList;
    }

    public static ByteBuffer f0(int i3, long j3) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.putLong(j3);
        byteBufferAllocate.flip();
        return BoxUtils.c("tfhd", byteBufferAllocate);
    }

    public static ByteBuffer g(List list) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((list.size() * 8) + 8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(list.size());
        for (int i3 = 0; i3 < list.size(); i3++) {
            byteBufferAllocate.putLong(((Long) list.get(i3)).longValue());
        }
        byteBufferAllocate.flip();
        return BoxUtils.c("co64", byteBufferAllocate);
    }

    public static ByteBuffer g0(int i3, long j3, int i4, int i5, int i6, Format format) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(7);
        byteBufferAllocate.putInt(i4);
        byteBufferAllocate.putInt(i5);
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt((int) r0(j3, 10000L));
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort(MimeTypes.n(format.f40632o) ? (short) 256 : (short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.put(U(i6));
        int i7 = format.f40639v;
        if (i7 == -1) {
            i7 = 0;
        }
        int i8 = format.f40640w;
        int i9 = i8 != -1 ? i8 : 0;
        byteBufferAllocate.putInt(i7 << 16);
        byteBufferAllocate.putInt(i9 << 16);
        byteBufferAllocate.flip();
        return BoxUtils.c("tkhd", byteBufferAllocate);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ByteBuffer h(Format format) {
        String str = (String) Assertions.e(format.f40632o);
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    b3 = 0;
                }
                break;
            case -1662735862:
                if (str.equals("video/av01")) {
                    b3 = 1;
                }
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    b3 = 2;
                }
                break;
            case -1606874997:
                if (str.equals("audio/amr-wb")) {
                    b3 = 3;
                }
                break;
            case -1003765268:
                if (str.equals("audio/vorbis")) {
                    b3 = 4;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    b3 = 5;
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    b3 = 6;
                }
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    b3 = 7;
                }
                break;
            case 1331836563:
                if (str.equals("video/apv")) {
                    b3 = 8;
                }
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    b3 = 9;
                }
                break;
            case 1503095341:
                if (str.equals("audio/3gpp")) {
                    b3 = 10;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    b3 = Ascii.VT;
                }
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    b3 = Ascii.FF;
                }
                break;
        }
        switch (b3) {
            case 0:
                return m(format);
            case 1:
                return c(format);
            case 2:
                return D(format);
            case 3:
                return o((short) -31745);
            case 4:
            case 5:
                return u(format);
            case 6:
                return ByteBuffer.allocate(0);
            case 7:
                return u(format);
            case 8:
                return a(format);
            case 9:
                return d(format);
            case 10:
                return o((short) -32257);
            case 11:
                return n(format);
            case 12:
                return q0(format);
            default:
                throw new IllegalArgumentException("Unsupported format: " + str);
        }
    }

    public static ByteBuffer h0(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        return BoxUtils.b("traf", ImmutableList.A(byteBuffer, byteBuffer2));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static String i(Format format) {
        String str = (String) Assertions.e(format.f40632o);
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    b3 = 0;
                }
                break;
            case -1662735862:
                if (str.equals("video/av01")) {
                    b3 = 1;
                }
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    b3 = 2;
                }
                break;
            case -1606874997:
                if (str.equals("audio/amr-wb")) {
                    b3 = 3;
                }
                break;
            case -1003765268:
                if (str.equals("audio/vorbis")) {
                    b3 = 4;
                }
                break;
            case -53558318:
                if (str.equals("audio/mp4a-latm")) {
                    b3 = 5;
                }
                break;
            case 187094639:
                if (str.equals("audio/raw")) {
                    b3 = 6;
                }
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    b3 = 7;
                }
                break;
            case 1331836563:
                if (str.equals("video/apv")) {
                    b3 = 8;
                }
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    b3 = 9;
                }
                break;
            case 1503095341:
                if (str.equals("audio/3gpp")) {
                    b3 = 10;
                }
                break;
            case 1504891608:
                if (str.equals("audio/opus")) {
                    b3 = Ascii.VT;
                }
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    b3 = Ascii.FF;
                }
                break;
        }
        switch (b3) {
            case 0:
                return "s263";
            case 1:
                return "av01";
            case 2:
                return "hvc1";
            case 3:
                return "sawb";
            case 4:
            case 5:
                return "mp4a";
            case 6:
                int i3 = format.G;
                if (i3 == 2) {
                    return "sowt";
                }
                if (i3 == 268435456) {
                    return "twos";
                }
                throw new IllegalArgumentException("Unsupported PCM encoding: " + format.G);
            case 7:
                return "mp4v-es";
            case 8:
                return "apv1";
            case 9:
                return "avc1";
            case 10:
                return "samr";
            case 11:
                return "Opus";
            case 12:
                return "vp09";
            default:
                throw new IllegalArgumentException("Unsupported format: " + str);
        }
    }

    public static ByteBuffer i0(ByteBuffer... byteBufferArr) {
        return BoxUtils.b("trak", Arrays.asList(byteBufferArr));
    }

    private static ByteBuffer j(ColorInfo colorInfo) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(20);
        byteBufferAllocate.put((byte) 110);
        byteBufferAllocate.put((byte) 99);
        byteBufferAllocate.put((byte) 108);
        byteBufferAllocate.put(Framer.EXIT_FRAME_PREFIX);
        short sD = (short) ColorInfo.d(colorInfo.f40554a);
        short sG = (short) ColorInfo.g(colorInfo.f40556c);
        short sE = (short) ColorInfo.e(colorInfo.f40554a);
        byte b3 = colorInfo.f40555b == 1 ? (byte) -128 : (byte) 0;
        byteBufferAllocate.putShort(sD);
        byteBufferAllocate.putShort(sG);
        byteBufferAllocate.putShort(sE);
        byteBufferAllocate.put(b3);
        byteBufferAllocate.flip();
        return BoxUtils.c("colr", byteBufferAllocate);
    }

    public static ByteBuffer j0(int i3) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.flip();
        return BoxUtils.c("trex", byteBufferAllocate);
    }

    public static List k(List list, int i3, int i4, long j3) {
        long jR0;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        if (list.isEmpty()) {
            return arrayList2;
        }
        long j4 = 0;
        int i5 = 0;
        boolean z2 = false;
        while (i5 < list.size()) {
            long j5 = ((MediaCodec.BufferInfo) list.get(i5)).presentationTimeUs;
            arrayList.add(Long.valueOf(j5));
            if (j5 < j4) {
                z2 = true;
            }
            i5++;
            j4 = j5;
        }
        if (z2) {
            Collections.sort(arrayList);
        }
        long jLongValue = ((Long) arrayList.get(0)).longValue();
        int i6 = 1;
        while (i6 < arrayList.size()) {
            long jLongValue2 = ((Long) arrayList.get(i6)).longValue();
            long jR02 = r0(jLongValue2 - jLongValue, i3);
            Assertions.h(jR02 <= 2147483647L, "Only 32-bit sample duration is allowed");
            arrayList2.add(Integer.valueOf((int) jR02));
            i6++;
            jLongValue = jLongValue2;
        }
        if (j3 != -9223372036854775807L) {
            long j6 = i3;
            jR0 = r0(j3, j6) - r0(jLongValue, j6);
            Assertions.h(jR0 <= 2147483647L, "Only 32-bit sample duration is allowed");
        } else {
            jR0 = -1;
        }
        arrayList2.add(Integer.valueOf(y(arrayList2, i4, (int) jR0)));
        return arrayList2;
    }

    public static ByteBuffer k0(List list, int i3, boolean z2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(A(list.size(), z2));
        byteBufferAllocate.putInt(z2 ? 16781057 : 16779009);
        byteBufferAllocate.putInt(list.size());
        byteBufferAllocate.putInt(i3);
        for (int i4 = 0; i4 < list.size(); i4++) {
            FragmentedMp4Writer.SampleMetadata sampleMetadata = (FragmentedMp4Writer.SampleMetadata) list.get(i4);
            byteBufferAllocate.putInt(sampleMetadata.f47831a);
            byteBufferAllocate.putInt(sampleMetadata.f47832b);
            byteBufferAllocate.putInt((sampleMetadata.f47833c & 1) != 0 ? 33554432 : android.R.attr.theme);
            if (z2) {
                byteBufferAllocate.putInt(sampleMetadata.f47834d);
            }
        }
        byteBufferAllocate.flip();
        return BoxUtils.c("trun", byteBufferAllocate);
    }

    public static ByteBuffer l(List list, List list2, int i3) {
        List listF = f(list, list2, i3);
        if (listF.isEmpty()) {
            return ByteBuffer.allocate(0);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((listF.size() * 8) + 8);
        byteBufferAllocate.putInt(16777216);
        int iPosition = byteBufferAllocate.position();
        byteBufferAllocate.putInt(0);
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        for (int i7 = 0; i7 < listF.size(); i7++) {
            int iIntValue = ((Integer) listF.get(i7)).intValue();
            if (i4 != iIntValue) {
                int iPosition2 = byteBufferAllocate.position();
                byteBufferAllocate.putInt(1);
                byteBufferAllocate.putInt(iIntValue);
                i6++;
                i5 = iPosition2;
                i4 = iIntValue;
            } else {
                byteBufferAllocate.putInt(i5, byteBufferAllocate.getInt(i5) + 1);
            }
        }
        byteBufferAllocate.putInt(iPosition, i6);
        byteBufferAllocate.flip();
        return BoxUtils.c("ctts", byteBufferAllocate);
    }

    public static ByteBuffer l0(Mp4LocationData mp4LocationData) {
        if (mp4LocationData == null) {
            return ByteBuffer.allocate(0);
        }
        String strJ = Util.J("%+.4f%+.4f/", Float.valueOf(mp4LocationData.f41668a), Float.valueOf(mp4LocationData.f41669b));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(strJ.length() + 4);
        byteBufferAllocate.putShort((short) (byteBufferAllocate.capacity() - 4));
        byteBufferAllocate.putShort((short) 5575);
        byteBufferAllocate.put(Util.t0(strJ));
        Assertions.g(byteBufferAllocate.limit() == byteBufferAllocate.capacity());
        byteBufferAllocate.flip();
        return BoxUtils.c("udta", BoxUtils.d(new byte[]{-87, Framer.EXIT_FRAME_PREFIX, 121, 122}, byteBufferAllocate));
    }

    private static ByteBuffer m(Format format) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(7);
        byteBufferAllocate.put("    ".getBytes(StandardCharsets.UTF_8));
        byteBufferAllocate.put((byte) 0);
        Pair pairO = CodecSpecificDataUtil.o(format);
        if (pairO == null) {
            pairO = new Pair(1, 1);
        }
        byteBufferAllocate.put(((Integer) pairO.second).byteValue());
        byteBufferAllocate.put(((Integer) pairO.first).byteValue());
        byteBufferAllocate.flip();
        return BoxUtils.c("d263", byteBufferAllocate);
    }

    private static long m0(long j3, long j4) {
        return Util.b1(j3, 1000000L, j4, RoundingMode.HALF_UP);
    }

    private static ByteBuffer n(Format format) {
        Assertions.b(!format.f40635r.isEmpty(), "csd-0 not found in the format for dOps box.");
        byte[] bArr = (byte[]) format.f40635r.get(0);
        Assertions.b(bArr.length >= 8, "As csd0 contains 'OpusHead' in first 8 bytes, csd0 length should be greater than 8");
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
        byteBufferAllocate.put(bArr, 8, bArr.length - 8);
        byteBufferAllocate.flip();
        return BoxUtils.c("dOps", byteBufferAllocate);
    }

    public static ByteBuffer n0(List list, ByteBuffer byteBuffer) {
        Assertions.a(byteBuffer.remaining() > 0);
        return BoxUtils.b("uuid", ImmutableList.A(ByteBuffer.wrap(Bytes.f(list)), byteBuffer));
    }

    private static ByteBuffer o(short s2) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.put("    ".getBytes(StandardCharsets.UTF_8));
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.putShort(s2);
        byteBufferAllocate.put((byte) 0);
        byteBufferAllocate.put((byte) 1);
        byteBufferAllocate.flip();
        return BoxUtils.c("damr", byteBufferAllocate);
    }

    public static ByteBuffer o0(Format format) {
        ByteBuffer byteBufferH = h(format);
        String strI = i(format);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBufferH.limit() + 200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 1);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(0);
        int i3 = format.f40639v;
        byteBufferAllocate.putShort(i3 != -1 ? (short) i3 : (short) 0);
        int i4 = format.f40640w;
        byteBufferAllocate.putShort(i4 != -1 ? (short) i4 : (short) 0);
        byteBufferAllocate.putInt(4718592);
        byteBufferAllocate.putInt(4718592);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) 1);
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.putLong(0L);
        byteBufferAllocate.putShort((short) 24);
        byteBufferAllocate.putShort((short) -1);
        byteBufferAllocate.put(byteBufferH);
        if (format.C != null && strI.equals("vp09")) {
            byteBufferAllocate.put(V(format.C));
        }
        byteBufferAllocate.put(T());
        ColorInfo colorInfo = format.C;
        if (colorInfo != null) {
            byteBufferAllocate.put(j(colorInfo));
        }
        byteBufferAllocate.flip();
        return BoxUtils.c(strI, byteBufferAllocate);
    }

    public static ByteBuffer p(ByteBuffer byteBuffer) {
        return BoxUtils.c("dinf", byteBuffer);
    }

    public static ByteBuffer p0() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.flip();
        return BoxUtils.c("vmhd", byteBufferAllocate);
    }

    public static ByteBuffer q(ByteBuffer... byteBufferArr) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.putInt(byteBufferArr.length);
        byteBufferAllocate.flip();
        ArrayList arrayList = new ArrayList();
        arrayList.add(byteBufferAllocate);
        Collections.addAll(arrayList, byteBufferArr);
        return BoxUtils.b("dref", arrayList);
    }

    private static ByteBuffer q0(Format format) {
        int i3;
        int iE;
        int iG;
        int iD = 1;
        Assertions.b(!format.f40635r.isEmpty(), "csd-0 is not found in the format for vpcC box");
        byte[] bArr = (byte[]) format.f40635r.get(0);
        Assertions.b(bArr.length > 3, "csd-0 for vp9 is invalid.");
        if (Ints.g(bArr) == 16777216) {
            return BoxUtils.c("vpcC", ByteBuffer.wrap(bArr));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(200);
        byteBufferAllocate.putInt(16777216);
        ColorInfo colorInfo = format.C;
        if (colorInfo == null || (i3 = colorInfo.f40555b) == -1) {
            i3 = 0;
        }
        byteBufferAllocate.put(S(bArr, i3));
        ColorInfo colorInfo2 = format.C;
        if (colorInfo2 != null) {
            iD = ColorInfo.d(colorInfo2.f40554a);
            iG = ColorInfo.g(format.C.f40556c);
            iE = ColorInfo.e(format.C.f40554a);
        } else {
            iE = 1;
            iG = 1;
        }
        byteBufferAllocate.put((byte) iD);
        byteBufferAllocate.put((byte) iG);
        byteBufferAllocate.put((byte) iE);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.flip();
        return BoxUtils.c("vpcC", byteBufferAllocate);
    }

    public static ByteBuffer r(long j3, long j4, long j5, long j6, long j7) {
        if (j4 > 0) {
            j3 -= j4;
        }
        long j8 = j3;
        return j8 != 0 ? BoxUtils.c("edts", s(j8, j5, j6, j7)) : ByteBuffer.allocate(0);
    }

    private static long r0(long j3, long j4) {
        return Util.b1(j3, j4, 1000000L, RoundingMode.HALF_UP);
    }

    private static ByteBuffer s(long j3, long j4, long j5, long j6) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(50);
        byteBufferAllocate.putInt(16777216);
        if (j3 > 0) {
            byteBufferAllocate.putInt(2);
            byteBufferAllocate.put(t(r0(j3, j5), -1L, 1, 0));
            byteBufferAllocate.put(t(r0(j4, j5), 0L, 1, 0));
        } else {
            byteBufferAllocate.putInt(1);
            byteBufferAllocate.put(t(r0(j4 - Math.abs(j3), j5), r0(Math.abs(j3), j6), 1, 0));
        }
        byteBufferAllocate.flip();
        return BoxUtils.c("elst", byteBufferAllocate);
    }

    private static ByteBuffer t(long j3, long j4, int i3, int i4) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(20);
        byteBufferAllocate.putLong(j3);
        byteBufferAllocate.putLong(j4);
        byteBufferAllocate.putShort((short) i3);
        byteBufferAllocate.putShort((short) i4);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static ByteBuffer u(Format format) {
        Assertions.b(!format.f40635r.isEmpty(), "csd-0 not found in the format for esds box.");
        byte[] bArr = (byte[]) format.f40635r.get(0);
        Assertions.b(bArr.length > 0, "csd-0 is empty for esds box.");
        String str = (String) Assertions.e(format.f40632o);
        ByteBuffer byteBufferB = str.equals("audio/vorbis") ? B(format) : ByteBuffer.wrap(bArr);
        int i3 = format.f40626i;
        int i4 = format.f40625h;
        boolean zQ = MimeTypes.q(str);
        int iRemaining = byteBufferB.remaining();
        ByteBuffer byteBufferZ = z(iRemaining);
        ByteBuffer byteBufferZ2 = z(byteBufferZ.remaining() + iRemaining + 14);
        ByteBuffer byteBufferZ3 = z(byteBufferZ.remaining() + iRemaining + byteBufferZ2.remaining() + 21);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining + 200);
        byteBufferAllocate.putInt(0);
        byteBufferAllocate.put((byte) 3);
        byteBufferAllocate.put(byteBufferZ3);
        byteBufferAllocate.putShort((short) 0);
        byteBufferAllocate.put(zQ ? Ascii.US : (byte) 0);
        byteBufferAllocate.put((byte) 4);
        byteBufferAllocate.put(byteBufferZ2);
        byteBufferAllocate.put(((Byte) Assertions.e(MimeTypes.h(str))).byteValue());
        byteBufferAllocate.put((byte) ((zQ ? 16 : 20) | 1));
        byteBufferAllocate.putShort((short) (((zQ ? 96000 : 768) >> 8) & 65535));
        byteBufferAllocate.put((byte) 0);
        if (i3 == -1) {
            i3 = 0;
        }
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.putInt(i4 != -1 ? i4 : 0);
        byteBufferAllocate.put((byte) 5);
        byteBufferAllocate.put(byteBufferZ);
        byteBufferAllocate.put(byteBufferB);
        byteBufferB.rewind();
        byteBufferAllocate.put((byte) 6);
        byteBufferAllocate.put((byte) 1);
        byteBufferAllocate.put((byte) 2);
        byteBufferAllocate.flip();
        return BoxUtils.c("esds", byteBufferAllocate);
    }

    private static long v(List list) {
        long jMin = Long.MAX_VALUE;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Track track = (Track) list.get(i3);
            if (!track.f47892d.isEmpty()) {
                jMin = Math.min(((MediaCodec.BufferInfo) track.f47892d.get(0)).presentationTimeUs, jMin);
            }
        }
        if (jMin != Long.MAX_VALUE) {
            return jMin;
        }
        return -9223372036854775807L;
    }

    public static ByteBuffer w() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ByteBuffer.wrap(Util.t0("isom")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt(131072);
        byteBufferAllocate.flip();
        arrayList.add(byteBufferAllocate);
        String[] strArr = {"isom", "iso2", "mp41"};
        for (int i3 = 0; i3 < 3; i3++) {
            arrayList.add(ByteBuffer.wrap(Util.t0(strArr[i3])));
        }
        return BoxUtils.b("ftyp", arrayList);
    }

    public static ByteBuffer x(long j3) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.put(Util.t0("axte"));
        byteBufferAllocate.putLong(j3 + 16);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static int y(List list, int i3, int i4) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Unexpected value for the last frame duration behavior " + i3);
        }
        if (i4 != -1) {
            return i4;
        }
        if (list.size() < 2) {
            return 0;
        }
        return ((Integer) Iterables.j(list)).intValue();
    }

    private static ByteBuffer z(int i3) {
        ArrayDeque arrayDeque = new ArrayDeque();
        int i4 = 0;
        while (true) {
            arrayDeque.push(Byte.valueOf((byte) (i4 | (i3 & 127))));
            i3 >>= 7;
            if (i3 <= 0) {
                break;
            }
            i4 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(arrayDeque.size());
        while (!arrayDeque.isEmpty()) {
            byteBufferAllocate.put(((Byte) arrayDeque.removeFirst()).byteValue());
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }
}
