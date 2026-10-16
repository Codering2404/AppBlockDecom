package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.89, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization("Exo version is final but in Meta code HeroLeastRecentlyUsedCacheEvictor extends this")
public final class AnonymousClass89 implements InterfaceC1863kS {
    public static byte[] A03;
    public static String[] A04 = {"jtWHdC1JS00IQCACyTEvOJEMPrvoo3Ob", "eCCt1HwS4IToKXyi1WzLFL1R4PlgsDM4", "yXgy4dLxj37Ni2Ba12KifyhgeRBIXCXp", "5p7nRT0g4n3u8StY", "28aCkGMBHBRgMUJ0i4knnGO", "XAmyqmpuCXa4X38XkweYk7F1knbiAlXr", "krkFdswQPRExlipS29WIEjh8hbH7SBjj", "jb"};

    @MetaExoPlayerCustomization("Exo version is private but in Meta code HeroLeastRecentlyUsedCacheEvictor extends this")
    public long A00;

    @MetaExoPlayerCustomization("Exo version is private but in Meta code HeroLeastRecentlyUsedCacheEvictor extends this")
    public final long A01;

    @MetaExoPlayerCustomization("Exo version is private but in Meta code HeroLeastRecentlyUsedCacheEvictor extends this")
    public final TreeSet<MZ> A02 = new TreeSet<>(new Comparator() { // from class: com.facebook.ads.redexgen.X.Mn
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AnonymousClass89.A00((MZ) obj, (MZ) obj2);
        }
    });

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{46, 61, 34, 40, 63, 8, 42, 40, 35, 46};
    }

    static {
        A02();
    }

    public AnonymousClass89(long j3) {
        this.A01 = j3;
    }

    @MetaExoPlayerCustomization("Exo version is private but in Meta code HeroLeastRecentlyUsedCacheEvictor extends this")
    public static int A00(MZ mz, MZ mz2) {
        if (mz.A00 - mz2.A00 == 0) {
            return mz.compareTo(mz2);
        }
        return mz.A00 < mz2.A00 ? -1 : 1;
    }

    private void A03(MP mp, long j3) {
        AnonymousClass54.A02(A01(0, 10, 87));
        while (this.A00 + j3 > this.A01 && !this.A02.isEmpty()) {
            MZ mzFirst = this.A02.first();
            if (A04[1].charAt(10) != 'T') {
                throw new RuntimeException();
            }
            A04[4] = "DjrmhsDHxGC2SVigK1e7Rl2";
            mp.AIV(mzFirst);
        }
        AnonymousClass54.A00();
    }

    @Override // com.facebook.ads.redexgen.core.MO
    public final void AG2(MP mp, MZ mz) {
        this.A02.add(mz);
        this.A00 += mz.A01;
        A03(mp, 0L);
    }

    @Override // com.facebook.ads.redexgen.core.MO
    public final void AG3(MP mp, MZ mz) {
        this.A02.remove(mz);
        this.A00 -= mz.A01;
    }

    @Override // com.facebook.ads.redexgen.core.MO
    public final void AG4(MP mp, MZ mz, MZ mz2) {
        AG3(mp, mz);
        AG2(mp, mz2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1863kS
    public final void AG5(MP mp, String str, long j3, long j4) {
        if (j4 != -1) {
            A03(mp, j4);
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1863kS
    public final boolean AIj() {
        return true;
    }
}
