package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC04323y {
    public static byte[] A00;

    static {
        A06();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T A01(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T A02(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T A03(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new IllegalStateException(String.valueOf(obj));
    }

    public static String A04(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{54, 17, Ascii.ESC, Ascii.SUB, 7, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 90, Ascii.ESC, 81, Framer.STDIN_REQUEST_FRAME_PREFIX, 44, Ascii.VT, Ascii.RS, Ascii.CR, Ascii.VT, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 90, Ascii.ESC, 81, Framer.STDIN_REQUEST_FRAME_PREFIX, 51, Ascii.SYN, Ascii.DC2, Ascii.SYN, Ascii.VT, 69, Framer.STDIN_REQUEST_FRAME_PREFIX, 90, Ascii.ESC};
    }

    @Pure
    public static int A00(int i3, int i4, int i5) {
        if (i3 < i4 || i3 >= i5) {
            throw new IndexOutOfBoundsException(String.format(A04(0, 31, 117), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
        }
        return i3;
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static String A05(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    @Pure
    public static void A07(boolean z2) {
        if (z2) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Pure
    public static void A08(boolean z2) {
        if (z2) {
        } else {
            throw new IllegalStateException();
        }
    }

    @Pure
    public static void A09(boolean z2, Object obj) {
        if (z2) {
        } else {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @Pure
    public static void A0A(boolean z2, Object obj) {
        if (z2) {
        } else {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
