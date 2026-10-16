package com.applovin.impl;

import com.applovin.impl.af;
import com.applovin.impl.e9;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class gf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String[] f59972a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    private static u3 a(int i3, ah ahVar) {
        int iJ = ahVar.j();
        if (ahVar.j() == 1684108385) {
            ahVar.g(8);
            String strB = ahVar.b(iJ - 16);
            return new u3("und", strB, strB);
        }
        oc.d("MetadataUtil", "Failed to parse comment attribute: " + j1.a(i3));
        return null;
    }

    public static af.b b(ah ahVar) {
        int iD = ahVar.d() + ahVar.j();
        int iJ = ahVar.j();
        int i3 = (iJ >> 24) & 255;
        try {
            if (i3 == 169 || i3 == 253) {
                int i4 = 16777215 & iJ;
                if (i4 == 6516084) {
                    return a(iJ, ahVar);
                }
                if (i4 == 7233901 || i4 == 7631467) {
                    return b(iJ, "TIT2", ahVar);
                }
                if (i4 == 6516589 || i4 == 7828084) {
                    return b(iJ, "TCOM", ahVar);
                }
                if (i4 == 6578553) {
                    return b(iJ, "TDRC", ahVar);
                }
                if (i4 == 4280916) {
                    return b(iJ, "TPE1", ahVar);
                }
                if (i4 == 7630703) {
                    return b(iJ, "TSSE", ahVar);
                }
                if (i4 == 6384738) {
                    return b(iJ, "TALB", ahVar);
                }
                if (i4 == 7108978) {
                    return b(iJ, "USLT", ahVar);
                }
                if (i4 == 6776174) {
                    return b(iJ, "TCON", ahVar);
                }
                if (i4 == 6779504) {
                    return b(iJ, "TIT1", ahVar);
                }
            } else {
                if (iJ == 1735291493) {
                    return c(ahVar);
                }
                if (iJ == 1684632427) {
                    return a(iJ, "TPOS", ahVar);
                }
                if (iJ == 1953655662) {
                    return a(iJ, "TRCK", ahVar);
                }
                if (iJ == 1953329263) {
                    return a(iJ, "TBPM", ahVar, true, false);
                }
                if (iJ == 1668311404) {
                    return a(iJ, "TCMP", ahVar, true, true);
                }
                if (iJ == 1668249202) {
                    return a(ahVar);
                }
                if (iJ == 1631670868) {
                    return b(iJ, "TPE2", ahVar);
                }
                if (iJ == 1936682605) {
                    return b(iJ, "TSOT", ahVar);
                }
                if (iJ == 1936679276) {
                    return b(iJ, "TSO2", ahVar);
                }
                if (iJ == 1936679282) {
                    return b(iJ, "TSOA", ahVar);
                }
                if (iJ == 1936679265) {
                    return b(iJ, "TSOP", ahVar);
                }
                if (iJ == 1936679791) {
                    return b(iJ, "TSOC", ahVar);
                }
                if (iJ == 1920233063) {
                    return a(iJ, "ITUNESADVISORY", ahVar, false, false);
                }
                if (iJ == 1885823344) {
                    return a(iJ, "ITUNESGAPLESS", ahVar, false, true);
                }
                if (iJ == 1936683886) {
                    return b(iJ, "TVSHOWSORT", ahVar);
                }
                if (iJ == 1953919848) {
                    return b(iJ, "TVSHOW", ahVar);
                }
                if (iJ == 757935405) {
                    return a(ahVar, iD);
                }
            }
            oc.a("MetadataUtil", "Skipped unknown metadata entry: " + j1.a(iJ));
            ahVar.f(iD);
            return null;
        } finally {
            ahVar.f(iD);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.applovin.impl.zn c(com.applovin.impl.ah r3) {
        /*
            int r3 = d(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = com.applovin.impl.gf.f59972a
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L1c
            com.applovin.impl.zn r1 = new com.applovin.impl.zn
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L1c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.applovin.impl.oc.d(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.gf.c(com.applovin.impl.ah):com.applovin.impl.zn");
    }

    private static int d(ah ahVar) {
        ahVar.g(4);
        if (ahVar.j() == 1684108385) {
            ahVar.g(8);
            return ahVar.w();
        }
        oc.d("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static v0 a(ah ahVar) {
        String str;
        int iJ = ahVar.j();
        if (ahVar.j() == 1684108385) {
            int iB = j1.b(ahVar.j());
            if (iB == 13) {
                str = "image/jpeg";
            } else {
                str = iB == 14 ? "image/png" : null;
            }
            if (str == null) {
                oc.d("MetadataUtil", "Unrecognized cover art flags: " + iB);
                return null;
            }
            ahVar.g(4);
            int i3 = iJ - 16;
            byte[] bArr = new byte[i3];
            ahVar.a(bArr, 0, i3);
            return new v0(str, null, 3, bArr);
        }
        oc.d("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    private static zn a(int i3, String str, ah ahVar) {
        int iJ = ahVar.j();
        if (ahVar.j() == 1684108385 && iJ >= 22) {
            ahVar.g(10);
            int iC = ahVar.C();
            if (iC > 0) {
                String str2 = "" + iC;
                int iC2 = ahVar.C();
                if (iC2 > 0) {
                    str2 = str2 + "/" + iC2;
                }
                return new zn(str, null, str2);
            }
        }
        oc.d("MetadataUtil", "Failed to parse index/count attribute: " + j1.a(i3));
        return null;
    }

    private static xa a(ah ahVar, int i3) {
        String strB = null;
        String strB2 = null;
        int i4 = -1;
        int i5 = -1;
        while (ahVar.d() < i3) {
            int iD = ahVar.d();
            int iJ = ahVar.j();
            int iJ2 = ahVar.j();
            ahVar.g(4);
            if (iJ2 == 1835360622) {
                strB = ahVar.b(iJ - 12);
            } else if (iJ2 == 1851878757) {
                strB2 = ahVar.b(iJ - 12);
            } else {
                if (iJ2 == 1684108385) {
                    i4 = iD;
                    i5 = iJ;
                }
                ahVar.g(iJ - 12);
            }
        }
        if (strB == null || strB2 == null || i4 == -1) {
            return null;
        }
        ahVar.f(i4);
        ahVar.g(16);
        return new rb(strB, strB2, ahVar.b(i5 - 16));
    }

    public static ed a(ah ahVar, int i3, String str) {
        while (true) {
            int iD = ahVar.d();
            if (iD >= i3) {
                return null;
            }
            int iJ = ahVar.j();
            if (ahVar.j() == 1684108385) {
                int iJ2 = ahVar.j();
                int iJ3 = ahVar.j();
                int i4 = iJ - 16;
                byte[] bArr = new byte[i4];
                ahVar.a(bArr, 0, i4);
                return new ed(str, bArr, iJ3, iJ2);
            }
            ahVar.f(iD + iJ);
        }
    }

    private static xa a(int i3, String str, ah ahVar, boolean z2, boolean z3) {
        int iD = d(ahVar);
        if (z3) {
            iD = Math.min(1, iD);
        }
        if (iD >= 0) {
            if (z2) {
                return new zn(str, null, Integer.toString(iD));
            }
            return new u3("und", str, Integer.toString(iD));
        }
        oc.d("MetadataUtil", "Failed to parse uint8 attribute: " + j1.a(i3));
        return null;
    }

    public static void a(int i3, y9 y9Var, e9.b bVar) {
        if (i3 == 1 && y9Var.a()) {
            bVar.e(y9Var.f65174a).f(y9Var.f65175b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(int r5, com.applovin.impl.af r6, com.applovin.impl.af r7, com.applovin.impl.e9.b r8, com.applovin.impl.af... r9) {
        /*
            com.applovin.impl.af r0 = new com.applovin.impl.af
            r1 = 0
            com.applovin.impl.af$b[] r2 = new com.applovin.impl.af.b[r1]
            r0.<init>(r2)
            r2 = 1
            if (r5 != r2) goto Le
            if (r6 == 0) goto L3c
            goto L3d
        Le:
            r6 = 2
            if (r5 != r6) goto L3c
            if (r7 == 0) goto L3c
            r5 = r1
        L14:
            int r6 = r7.c()
            if (r5 >= r6) goto L3c
            com.applovin.impl.af$b r6 = r7.a(r5)
            boolean r3 = r6 instanceof com.applovin.impl.ed
            if (r3 == 0) goto L39
            com.applovin.impl.ed r6 = (com.applovin.impl.ed) r6
            java.lang.String r3 = r6.f59459a
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L39
            com.applovin.impl.af r5 = new com.applovin.impl.af
            com.applovin.impl.af$b[] r7 = new com.applovin.impl.af.b[r2]
            r7[r1] = r6
            r5.<init>(r7)
            r6 = r5
            goto L3d
        L39:
            int r5 = r5 + 1
            goto L14
        L3c:
            r6 = r0
        L3d:
            int r5 = r9.length
        L3e:
            if (r1 >= r5) goto L49
            r7 = r9[r1]
            com.applovin.impl.af r6 = r6.a(r7)
            int r1 = r1 + 1
            goto L3e
        L49:
            int r5 = r6.c()
            if (r5 <= 0) goto L52
            r8.a(r6)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.gf.a(int, com.applovin.impl.af, com.applovin.impl.af, com.applovin.impl.e9$b, com.applovin.impl.af[]):void");
    }

    private static zn b(int i3, String str, ah ahVar) {
        int iJ = ahVar.j();
        if (ahVar.j() == 1684108385) {
            ahVar.g(8);
            return new zn(str, null, ahVar.b(iJ - 16));
        }
        oc.d("MetadataUtil", "Failed to parse text attribute: " + j1.a(i3));
        return null;
    }
}
