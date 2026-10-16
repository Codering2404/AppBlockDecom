package com.facebook.ads.redexgen.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class P2 {
    public static P2 A05;
    public static byte[] A06;
    public static final Object A07;
    public final Context A00;
    public final Handler A01;
    public final HashMap<BroadcastReceiver, ArrayList<P1>> A04 = new HashMap<>();
    public final HashMap<String, ArrayList<P1>> A03 = new HashMap<>();
    public final ArrayList<P0> A02 = new ArrayList<>();

    public static String A01(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 63);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{Ascii.VT, Ascii.VT, 109, 66, 71, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, 89, Ascii.VT, 79, 66, 79, Ascii.VT, 69, 68, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.VT, 70, 74, Framer.STDIN_REQUEST_FRAME_PREFIX, 72, 67, 17, Ascii.VT, Framer.STDIN_REQUEST_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX, 57, Ascii.SYN, 19, Ascii.VT, Ascii.SUB, Ascii.CR, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.DC2, Ascii.RS, Ascii.VT, Ascii.FS, Ascii.ETB, Ascii.SUB, Ascii.ESC, 94, Framer.STDIN_REQUEST_FRAME_PREFIX, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.DC2, Ascii.RS, Ascii.VT, Ascii.FS, Ascii.ETB, 66, 79, 7, 42, 101, 108, 42, 99, 100, 126, 111, 100, 126, 42, 37, 118, 102, 109, 96, 104, 96, 37, 86, 116, 99, 126, Framer.EXIT_FRAME_PREFIX, 121, 55, 123, 126, 100, 99, Framer.STDIN_FRAME_PREFIX, 55, 84, 119, 123, 121, 116, 90, 106, 119, 121, 124, 123, 121, 107, 108, 85, 121, 118, 121, Ascii.DEL, 125, 106, Ascii.CAN, 52, Framer.ENTER_FRAME_PREFIX, 54, 61, 60, 59, Framer.STDERR_FRAME_PREFIX, 117, 52, Framer.STDERR_FRAME_PREFIX, 52, 60, 59, 38, Framer.ENTER_FRAME_PREFIX, 117, 51, 60, 57, Framer.ENTER_FRAME_PREFIX, 48, 39, 117, Ascii.CAN, 47, 57, 37, 38, 60, 35, 36, Framer.STDIN_FRAME_PREFIX, 106, 62, 51, 58, 47, 106, 56, 58, Framer.STDIN_FRAME_PREFIX, 48, 54, 55, 78, 76, 89, 72, 74, 66, Framer.STDIN_REQUEST_FRAME_PREFIX, 84, Ascii.FF, 9, Ascii.FS, 9, 72, 69, 76, 89, 91, 64, 69, 64, 65, 89, 64, Ascii.SO, 92, 75, 79, 93, 65, 64};
    }

    static {
        A03();
        A07 = new Object();
    }

    public P2(Context context) {
        this.A00 = context;
        this.A01 = new HandlerC0957Oz(this, context.getMainLooper());
    }

    public static P2 A00(Context context) {
        P2 p22;
        synchronized (A07) {
            if (A05 == null) {
                A05 = new P2(context.getApplicationContext());
            }
            p22 = A05;
        }
        return p22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Incorrect condition in loop: B:12:0x001c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A02() {
        /*
            r8 = this;
        L0:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.facebook.ads.redexgen.X.P1>> r1 = r8.A04
            monitor-enter(r1)
            java.util.ArrayList<com.facebook.ads.redexgen.X.P0> r0 = r8.A02     // Catch: java.lang.Throwable -> L45
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L45
            if (r0 > 0) goto Ld
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L45
            goto L44
        Ld:
            com.facebook.ads.redexgen.X.P0[] r7 = new com.facebook.ads.redexgen.core.P0[r0]     // Catch: java.lang.Throwable -> L45
            java.util.ArrayList<com.facebook.ads.redexgen.X.P0> r0 = r8.A02     // Catch: java.lang.Throwable -> L45
            r0.toArray(r7)     // Catch: java.lang.Throwable -> L45
            java.util.ArrayList<com.facebook.ads.redexgen.X.P0> r0 = r8.A02     // Catch: java.lang.Throwable -> L45
            r0.clear()     // Catch: java.lang.Throwable -> L45
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L45
            r6 = 0
        L1b:
            int r0 = r7.length
            if (r6 >= r0) goto L0
            r5 = r7[r6]
            java.util.ArrayList<com.facebook.ads.redexgen.X.P1> r0 = r5.A01
            int r4 = r0.size()
            r3 = 0
        L27:
            if (r3 >= r4) goto L41
            java.util.ArrayList<com.facebook.ads.redexgen.X.P1> r0 = r5.A01
            java.lang.Object r1 = r0.get(r3)
            com.facebook.ads.redexgen.X.P1 r1 = (com.facebook.ads.redexgen.core.P1) r1
            boolean r0 = r1.A01
            if (r0 != 0) goto L3e
            android.content.BroadcastReceiver r2 = r1.A02
            android.content.Context r1 = r8.A00
            android.content.Intent r0 = r5.A00
            r2.onReceive(r1, r0)
        L3e:
            int r3 = r3 + 1
            goto L27
        L41:
            int r6 = r6 + 1
            goto L1b
        L44:
            return
        L45:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L45
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.P2.A02():void");
    }

    public final void A05(BroadcastReceiver broadcastReceiver) {
        synchronized (this.A04) {
            ArrayList<P1> arrayListRemove = this.A04.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                P1 p12 = arrayListRemove.get(size);
                p12.A01 = true;
                for (int j3 = 0; j3 < p12.A03.countActions(); j3++) {
                    String action = p12.A03.getAction(j3);
                    ArrayList<P1> arrayList = this.A03.get(action);
                    if (arrayList != null) {
                        int i3 = arrayList.size();
                        for (int i4 = i3 - 1; i4 >= 0; i4--) {
                            P1 p13 = arrayList.get(i4);
                            if (p13.A02 == broadcastReceiver) {
                                p13.A01 = true;
                                arrayList.remove(i4);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.A03.remove(action);
                        }
                    }
                }
            }
        }
    }

    public final void A06(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.A04) {
            P1 p12 = new P1(intentFilter, broadcastReceiver);
            ArrayList<P1> arrayList = this.A04.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.A04.put(broadcastReceiver, arrayList);
            }
            arrayList.add(p12);
            for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                String action = intentFilter.getAction(i3);
                ArrayList<P1> arrayList2 = this.A03.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.A03.put(action, arrayList2);
                }
                arrayList2.add(p12);
            }
        }
    }

    public final boolean A07(Intent intent) {
        String strA01;
        synchronized (this.A04) {
            String action = intent.getAction();
            String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.A00.getContentResolver());
            Uri data = intent.getData();
            String action2 = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean debug = (intent.getFlags() & 8) != 0;
            if (debug) {
                StringBuilder sb = new StringBuilder();
                String type = A01(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 15, 117);
                StringBuilder sbAppend = sb.append(type).append(strResolveTypeIfNeeded);
                String type2 = A01(62, 8, 58);
                StringBuilder sbAppend2 = sbAppend.append(type2).append(action2);
                String type3 = A01(51, 11, 53);
                sbAppend2.append(type3).append(intent).toString();
            }
            HashMap<String, ArrayList<P1>> map = this.A03;
            String type4 = intent.getAction();
            ArrayList<P1> arrayList = map.get(type4);
            if (arrayList != null) {
                if (debug) {
                    StringBuilder sb2 = new StringBuilder();
                    String type5 = A01(70, 13, 40);
                    sb2.append(type5).append(arrayList).toString();
                }
                ArrayList arrayList2 = null;
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    P1 p12 = arrayList.get(i3);
                    if (debug) {
                        StringBuilder sb3 = new StringBuilder();
                        String type6 = A01(104, 24, 106);
                        sb3.append(type6).append(p12.A03).toString();
                    }
                    if (!p12.A00) {
                        int iMatch = p12.A03.match(action, strResolveTypeIfNeeded, action2, data, categories, A01(83, 21, 39));
                        if (iMatch >= 0) {
                            if (debug) {
                                String str = A01(24, 27, 64) + Integer.toHexString(iMatch);
                            }
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(p12);
                            p12.A00 = true;
                        } else if (debug) {
                            switch (iMatch) {
                                case -4:
                                    strA01 = A01(149, 8, 18);
                                    break;
                                case -3:
                                    strA01 = A01(143, 6, 102);
                                    break;
                                case -2:
                                    strA01 = A01(157, 4, 87);
                                    break;
                                case -1:
                                    strA01 = A01(161, 4, 3);
                                    break;
                                default:
                                    strA01 = A01(165, 14, 17);
                                    break;
                            }
                            String str2 = A01(0, 24, 20) + strA01;
                        }
                    }
                }
                if (arrayList2 != null) {
                    for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                        ((P1) arrayList2.get(i4)).A00 = false;
                    }
                    this.A02.add(new P0(intent, arrayList2));
                    if (!this.A01.hasMessages(1)) {
                        this.A01.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
