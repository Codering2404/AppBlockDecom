package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jW, reason: from Kotlin metadata */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\b\"\u0002H\u0006H\u0007¢\u0006\u0002\u0010\tJ-\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\b\"\u0002H\u0006H\u0007¢\u0006\u0002\u0010\tJ-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00060\f\"\u0004\b\u0000\u0010\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00060\b\"\u0002H\u0006H\u0007¢\u0006\u0002\u0010\rJ6\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00110\u000f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u000fH\u0007J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u0006H\u0007¨\u0006\u0014"}, d2 = {"Lcom/facebook/video/heroplayer/exocustom/MetaExoPlayerCustomizedCollections;", "", "<init>", "()V", "immutableListOf", "", "T", "elements", "", "([Ljava/lang/Object;)Ljava/util/List;", "immutableListCopyOf", "immutableSetOf", "", "([Ljava/lang/Object;)Ljava/util/Set;", "immutableMapCopyOf", "", "K", "V", "mapToCopy", "emptyList", "fbandroid.java.com.facebook.video.heroplayer.exocustom.exocustom"}, k = 1, mv = {2, 1, 0}, xi = 48)
@MetaExoPlayerCustomization("On VRShell, Google Guava dependencies do not behave well. This is still under investigation but for now we are replacing those calls with vanilla java calls")
public final class MetaExoPlayerCustomizedCollections {
    public static byte[] A00;
    public static final MetaExoPlayerCustomizedCollections A01;

    static {
        A06();
        A01 = new MetaExoPlayerCustomizedCollections();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 122);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{Ascii.DEL, 118, Ascii.DEL, 119, Ascii.DEL, 116, 110, 105};
    }

    @JvmStatic
    public static final <T> List<T> A01() {
        return AbstractC0581Af.A06();
    }

    @JvmStatic
    public static final <T> List<T> A02(T... tArr) {
        C2222qY.A09(tArr, A00(0, 8, 96));
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        return new ArrayList(AbstractC0581Af.A07(Arrays.copyOf(objArrCopyOf, objArrCopyOf.length)));
    }

    @JvmStatic
    public static final <T> List<T> A03(T... tArr) {
        C2222qY.A09(tArr, A00(0, 8, 96));
        return new ArrayList(AbstractC0581Af.A07(Arrays.copyOf(tArr, tArr.length)));
    }

    @JvmStatic
    public static final <K, V> Map<K, V> A04(Map<K, ? extends V> map) {
        return new HashMap(map);
    }

    @JvmStatic
    public static final <T> Set<T> A05(T... tArr) {
        C2222qY.A09(tArr, A00(0, 8, 96));
        return new HashSet(AbstractC0581Af.A07(Arrays.copyOf(tArr, tArr.length)));
    }
}
