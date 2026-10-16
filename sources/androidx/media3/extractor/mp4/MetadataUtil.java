package androidx.media3.extractor.mp4;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4Box;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.Id3Util;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MetadataUtil {
    public static MdtaMetadataEntry a(Metadata metadata, String str) {
        for (int i3 = 0; i3 < metadata.e(); i3++) {
            Metadata.Entry entryD = metadata.d(i3);
            if (entryD instanceof MdtaMetadataEntry) {
                MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entryD;
                if (mdtaMetadataEntry.f41658a.equals(str)) {
                    return mdtaMetadataEntry;
                }
            }
        }
        return null;
    }

    private static CommentFrame b(int i3, ParsableByteArray parsableByteArray) {
        int iQ = parsableByteArray.q();
        if (parsableByteArray.q() == 1684108385) {
            parsableByteArray.X(8);
            String strC = parsableByteArray.C(iQ - 16);
            return new CommentFrame("und", strC, strC);
        }
        Log.i("MetadataUtil", "Failed to parse comment attribute: " + Mp4Box.a(i3));
        return null;
    }

    private static ApicFrame c(ParsableByteArray parsableByteArray) {
        int iQ = parsableByteArray.q();
        if (parsableByteArray.q() != 1684108385) {
            Log.i("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int iO = BoxParser.o(parsableByteArray.q());
        String str = iO == 13 ? "image/jpeg" : iO == 14 ? "image/png" : null;
        if (str == null) {
            Log.i("MetadataUtil", "Unrecognized cover art flags: " + iO);
            return null;
        }
        parsableByteArray.X(4);
        int i3 = iQ - 16;
        byte[] bArr = new byte[i3];
        parsableByteArray.l(bArr, 0, i3);
        return new ApicFrame(str, null, 3, bArr);
    }

    public static Metadata.Entry d(ParsableByteArray parsableByteArray) {
        int iF = parsableByteArray.f() + parsableByteArray.q();
        int iQ = parsableByteArray.q();
        int i3 = (iQ >> 24) & 255;
        try {
            if (i3 == 169 || i3 == 253) {
                int i4 = 16777215 & iQ;
                if (i4 == 6516084) {
                    return b(iQ, parsableByteArray);
                }
                if (i4 == 7233901 || i4 == 7631467) {
                    return k(iQ, "TIT2", parsableByteArray);
                }
                if (i4 == 6516589 || i4 == 7828084) {
                    return k(iQ, "TCOM", parsableByteArray);
                }
                if (i4 == 6578553) {
                    return k(iQ, "TDRC", parsableByteArray);
                }
                if (i4 == 4280916) {
                    return k(iQ, "TPE1", parsableByteArray);
                }
                if (i4 == 7630703) {
                    return k(iQ, "TSSE", parsableByteArray);
                }
                if (i4 == 6384738) {
                    return k(iQ, "TALB", parsableByteArray);
                }
                if (i4 == 7108978) {
                    return k(iQ, "USLT", parsableByteArray);
                }
                if (i4 == 6776174) {
                    return k(iQ, "TCON", parsableByteArray);
                }
                if (i4 == 6779504) {
                    return k(iQ, "TIT1", parsableByteArray);
                }
            } else {
                if (iQ == 1735291493) {
                    return j(parsableByteArray);
                }
                if (iQ == 1684632427) {
                    return e(iQ, "TPOS", parsableByteArray);
                }
                if (iQ == 1953655662) {
                    return e(iQ, "TRCK", parsableByteArray);
                }
                if (iQ == 1953329263) {
                    return g(iQ, "TBPM", parsableByteArray, true, false);
                }
                if (iQ == 1668311404) {
                    return g(iQ, "TCMP", parsableByteArray, true, true);
                }
                if (iQ == 1668249202) {
                    return c(parsableByteArray);
                }
                if (iQ == 1631670868) {
                    return k(iQ, "TPE2", parsableByteArray);
                }
                if (iQ == 1936682605) {
                    return k(iQ, "TSOT", parsableByteArray);
                }
                if (iQ == 1936679276) {
                    return k(iQ, "TSOA", parsableByteArray);
                }
                if (iQ == 1936679282) {
                    return k(iQ, "TSOP", parsableByteArray);
                }
                if (iQ == 1936679265) {
                    return k(iQ, "TSO2", parsableByteArray);
                }
                if (iQ == 1936679791) {
                    return k(iQ, "TSOC", parsableByteArray);
                }
                if (iQ == 1920233063) {
                    return g(iQ, "ITUNESADVISORY", parsableByteArray, false, false);
                }
                if (iQ == 1885823344) {
                    return g(iQ, "ITUNESGAPLESS", parsableByteArray, false, true);
                }
                if (iQ == 1936683886) {
                    return k(iQ, "TVSHOWSORT", parsableByteArray);
                }
                if (iQ == 1953919848) {
                    return k(iQ, "TVSHOW", parsableByteArray);
                }
                if (iQ == 757935405) {
                    return h(parsableByteArray, iF);
                }
            }
            Log.b("MetadataUtil", "Skipped unknown metadata entry: " + Mp4Box.a(iQ));
            parsableByteArray.W(iF);
            return null;
        } finally {
            parsableByteArray.W(iF);
        }
    }

    private static TextInformationFrame e(int i3, String str, ParsableByteArray parsableByteArray) {
        int iQ = parsableByteArray.q();
        if (parsableByteArray.q() == 1684108385 && iQ >= 22) {
            parsableByteArray.X(10);
            int iP = parsableByteArray.P();
            if (iP > 0) {
                String str2 = "" + iP;
                int iP2 = parsableByteArray.P();
                if (iP2 > 0) {
                    str2 = str2 + "/" + iP2;
                }
                return new TextInformationFrame(str, null, ImmutableList.z(str2));
            }
        }
        Log.i("MetadataUtil", "Failed to parse index/count attribute: " + Mp4Box.a(i3));
        return null;
    }

    private static int f(ParsableByteArray parsableByteArray) {
        int iQ = parsableByteArray.q();
        if (parsableByteArray.q() == 1684108385) {
            parsableByteArray.X(8);
            int i3 = iQ - 16;
            if (i3 == 1) {
                return parsableByteArray.H();
            }
            if (i3 == 2) {
                return parsableByteArray.P();
            }
            if (i3 == 3) {
                return parsableByteArray.K();
            }
            if (i3 == 4 && (parsableByteArray.j() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                return parsableByteArray.L();
            }
        }
        Log.i("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static Id3Frame g(int i3, String str, ParsableByteArray parsableByteArray, boolean z2, boolean z3) {
        int iF = f(parsableByteArray);
        if (z3) {
            iF = Math.min(1, iF);
        }
        if (iF >= 0) {
            return z2 ? new TextInformationFrame(str, null, ImmutableList.z(Integer.toString(iF))) : new CommentFrame("und", str, Integer.toString(iF));
        }
        Log.i("MetadataUtil", "Failed to parse uint8 attribute: " + Mp4Box.a(i3));
        return null;
    }

    private static Id3Frame h(ParsableByteArray parsableByteArray, int i3) {
        String strC = null;
        String strC2 = null;
        int i4 = -1;
        int i5 = -1;
        while (parsableByteArray.f() < i3) {
            int iF = parsableByteArray.f();
            int iQ = parsableByteArray.q();
            int iQ2 = parsableByteArray.q();
            parsableByteArray.X(4);
            if (iQ2 == 1835360622) {
                strC = parsableByteArray.C(iQ - 12);
            } else if (iQ2 == 1851878757) {
                strC2 = parsableByteArray.C(iQ - 12);
            } else {
                if (iQ2 == 1684108385) {
                    i4 = iF;
                    i5 = iQ;
                }
                parsableByteArray.X(iQ - 12);
            }
        }
        if (strC == null || strC2 == null || i4 == -1) {
            return null;
        }
        parsableByteArray.W(i4);
        parsableByteArray.X(16);
        return new InternalFrame(strC, strC2, parsableByteArray.C(i5 - 16));
    }

    public static MdtaMetadataEntry i(ParsableByteArray parsableByteArray, int i3, String str) {
        while (true) {
            int iF = parsableByteArray.f();
            if (iF >= i3) {
                return null;
            }
            int iQ = parsableByteArray.q();
            if (parsableByteArray.q() == 1684108385) {
                int iQ2 = parsableByteArray.q();
                int iQ3 = parsableByteArray.q();
                int i4 = iQ - 16;
                byte[] bArr = new byte[i4];
                parsableByteArray.l(bArr, 0, i4);
                return new MdtaMetadataEntry(str, bArr, iQ3, iQ2);
            }
            parsableByteArray.W(iF + iQ);
        }
    }

    private static TextInformationFrame j(ParsableByteArray parsableByteArray) {
        String strA = Id3Util.a(f(parsableByteArray) - 1);
        if (strA != null) {
            return new TextInformationFrame("TCON", null, ImmutableList.z(strA));
        }
        Log.i("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static TextInformationFrame k(int i3, String str, ParsableByteArray parsableByteArray) {
        int iQ = parsableByteArray.q();
        if (parsableByteArray.q() == 1684108385) {
            parsableByteArray.X(8);
            return new TextInformationFrame(str, null, ImmutableList.z(parsableByteArray.C(iQ - 16)));
        }
        Log.i("MetadataUtil", "Failed to parse text attribute: " + Mp4Box.a(i3));
        return null;
    }

    public static void l(int i3, GaplessInfoHolder gaplessInfoHolder, Format.Builder builder) {
        if (i3 == 1 && gaplessInfoHolder.a()) {
            builder.Z(gaplessInfoHolder.f46175a).a0(gaplessInfoHolder.f46176b);
        }
    }

    public static void m(int i3, Metadata metadata, Format.Builder builder, Metadata metadata2, Metadata... metadataArr) {
        if (metadata2 == null) {
            metadata2 = new Metadata(new Metadata.Entry[0]);
        }
        if (metadata != null) {
            for (int i4 = 0; i4 < metadata.e(); i4++) {
                Metadata.Entry entryD = metadata.d(i4);
                if (entryD instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entryD;
                    if (!mdtaMetadataEntry.f41658a.equals("com.android.capture.fps")) {
                        metadata2 = metadata2.a(mdtaMetadataEntry);
                    } else if (i3 == 2) {
                        metadata2 = metadata2.a(mdtaMetadataEntry);
                    }
                }
            }
        }
        for (Metadata metadata3 : metadataArr) {
            metadata2 = metadata2.b(metadata3);
        }
        if (metadata2.e() > 0) {
            builder.n0(metadata2);
        }
    }
}
