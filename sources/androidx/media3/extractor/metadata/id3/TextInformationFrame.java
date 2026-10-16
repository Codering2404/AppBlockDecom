package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TextInformationFrame extends Id3Frame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImmutableList f46489d;

    /* JADX WARN: Multi-variable type inference failed */
    public TextInformationFrame(String str, String str2, List list) {
        super(str);
        Assertions.a(!list.isEmpty());
        this.f46487b = str2;
        ImmutableList immutableListT = ImmutableList.t(list);
        this.f46489d = immutableListT;
        this.f46488c = (String) immutableListT.get(0);
    }

    private static List d(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.common.Metadata.Entry
    public void b(MediaMetadata.Builder builder) {
        String str = this.f46475a;
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    b3 = 0;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    b3 = 1;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    b3 = 2;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    b3 = 3;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    b3 = 4;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    b3 = 5;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    b3 = 6;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    b3 = 7;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    b3 = 8;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    b3 = 9;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    b3 = 10;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    b3 = Ascii.VT;
                }
                break;
            case 2569358:
                if (str.equals("TCON")) {
                    b3 = Ascii.FF;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    b3 = Ascii.CR;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    b3 = Ascii.SO;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    b3 = Ascii.SI;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    b3 = Ascii.DLE;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    b3 = 17;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    b3 = Ascii.DC2;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    b3 = 19;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    b3 = Ascii.DC4;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    b3 = Ascii.NAK;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    b3 = Ascii.SYN;
                }
                break;
        }
        try {
            switch (b3) {
                case 0:
                case 10:
                    builder.P((CharSequence) this.f46489d.get(0));
                    break;
                case 1:
                case 11:
                    builder.U((CharSequence) this.f46489d.get(0));
                    break;
                case 2:
                case 13:
                    String str2 = (String) this.f46489d.get(0);
                    builder.i0(Integer.valueOf(Integer.parseInt(str2.substring(2, 4)))).h0(Integer.valueOf(Integer.parseInt(str2.substring(0, 2))));
                    break;
                case 3:
                case 18:
                    builder.Q((CharSequence) this.f46489d.get(0));
                    break;
                case 4:
                case 19:
                    builder.O((CharSequence) this.f46489d.get(0));
                    break;
                case 5:
                case 20:
                    builder.V((CharSequence) this.f46489d.get(0));
                    break;
                case 6:
                case 21:
                    String[] strArrH1 = Util.h1((String) this.f46489d.get(0), "/");
                    builder.t0(Integer.valueOf(Integer.parseInt(strArrH1[0]))).s0(strArrH1.length > 1 ? Integer.valueOf(Integer.parseInt(strArrH1[1])) : null);
                    break;
                case 7:
                case 17:
                    builder.q0((CharSequence) this.f46489d.get(0));
                    break;
                case 8:
                case 16:
                    builder.v0((CharSequence) this.f46489d.get(0));
                    break;
                case 9:
                case 22:
                    builder.j0(Integer.valueOf(Integer.parseInt((String) this.f46489d.get(0))));
                    break;
                case 12:
                    Integer numO = Ints.o((String) this.f46489d.get(0));
                    if (numO != null) {
                        String strA = Id3Util.a(numO.intValue());
                        if (strA != null) {
                            builder.c0(strA);
                        }
                    } else {
                        builder.c0((CharSequence) this.f46489d.get(0));
                    }
                    break;
                case 14:
                    List listD = d((String) this.f46489d.get(0));
                    int size = listD.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                builder.h0((Integer) listD.get(2));
                            }
                        }
                        builder.i0((Integer) listD.get(1));
                    }
                    builder.j0((Integer) listD.get(0));
                    break;
                case 15:
                    List listD2 = d((String) this.f46489d.get(0));
                    int size2 = listD2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                builder.k0((Integer) listD2.get(2));
                            }
                        }
                        builder.l0((Integer) listD2.get(1));
                    }
                    builder.m0((Integer) listD2.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TextInformationFrame.class == obj.getClass()) {
            TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
            if (Objects.equals(this.f46475a, textInformationFrame.f46475a) && Objects.equals(this.f46487b, textInformationFrame.f46487b) && this.f46489d.equals(textInformationFrame.f46489d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (527 + this.f46475a.hashCode()) * 31;
        String str = this.f46487b;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f46489d.hashCode();
    }

    @Override // androidx.media3.extractor.metadata.id3.Id3Frame
    public String toString() {
        return this.f46475a + ": description=" + this.f46487b + ": values=" + this.f46489d;
    }
}
