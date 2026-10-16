package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ja, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\u0002J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0007H\u0087\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\tH\u0007J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\nH\u0007J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\fH\u0007J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\rH\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/MetaExoPlayerUpgradeConfig;", "", "<init>", "()V", "CONFIG", "", "Lcom/facebook/video/heroplayer/exocustom/MetaExoPlayerUpgradeConfig$ID;", "", "INTEGER_CONFIG", "Lcom/facebook/video/heroplayer/exocustom/MetaExoPlayerUpgradeConfig$INTEGER_ID;", "", "LONG_CONFIG", "Lcom/facebook/video/heroplayer/exocustom/MetaExoPlayerUpgradeConfig$LONG_ID;", "", "get", "upgradeIdentifier", "set", "", "value", "getInteger", "setInteger", "getLong", "setLong", "ID", "INTEGER_ID", "LONG_ID", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MetaExoPlayerUpgradeConfig {
    public static byte[] A00;
    public static final MetaExoPlayerUpgradeConfig A01;
    public static final Map<EnumC1808jX, Boolean> A02;
    public static final Map<EnumC1809jY, Integer> A03;
    public static final Map<EnumC1810jZ, Long> A04;

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 122);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{126, 73, 93, 89, 69, 94, 73, 72, Ascii.FF, 90, 77, 64, 89, 73, Ascii.FF, 91, 77, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.FF, 66, 89, 64, 64, 2, 39, 34, 53, 32, 51, 54, 55, Ascii.ESC, 54, 55, 60, 38, 59, 52, 59, 55, 32};
    }

    static {
        A02();
        A01 = new MetaExoPlayerUpgradeConfig();
        A02 = new EnumMap(EnumC1808jX.class);
        A03 = new EnumMap(EnumC1809jY.class);
        A04 = new EnumMap(EnumC1810jZ.class);
        for (EnumC1808jX enumC1808jX : EnumC1808jX.valuesCustom()) {
            A02.put(enumC1808jX, false);
        }
        for (EnumC1809jY enumC1809jY : EnumC1809jY.valuesCustom()) {
            A03.put(enumC1809jY, -1);
        }
        for (EnumC1810jZ id : EnumC1810jZ.values()) {
            A04.put(id, -1L);
        }
        A02.put(EnumC1808jX.A0W, true);
        A02.put(EnumC1808jX.A0Q, true);
        A02.put(EnumC1808jX.A1j, true);
        A03.put(EnumC1809jY.A05, 100);
    }

    @JvmStatic
    public static final int A00(EnumC1809jY enumC1809jY) {
        C2222qY.A09(enumC1809jY, A01(24, 17, 40));
        Integer num = A03.get(enumC1809jY);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException(A01(0, 24, 86).toString());
    }

    @JvmStatic
    public static final boolean A03(EnumC1808jX enumC1808jX) {
        C2222qY.A09(enumC1808jX, A01(24, 17, 40));
        return C2222qY.A0C(true, A02.get(enumC1808jX));
    }
}
