package com.applovin.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.provider.Settings;
import com.applovin.impl.db;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class n1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n1 f61953c = new n1(new int[]{2}, 8);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final n1 f61954d = new n1(new int[]{2, 5, 6}, 8);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f61955e = {5, 6, 18, 17, 14, 7, 8};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f61956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f61957b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {
        public static int[] a() {
            db.a aVarF = db.f();
            for (int i3 : n1.f61955e) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(i3).setSampleRate(48000).build(), new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build())) {
                    aVarF.b(Integer.valueOf(i3));
                }
            }
            aVarF.b(2);
            return tb.a(aVarF.a());
        }
    }

    public n1(int[] iArr, int i3) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.f61956a = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.f61956a = new int[0];
        }
        this.f61957b = i3;
    }

    public static n1 a(Context context) {
        return a(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    private static boolean b() {
        if (xp.f65027a < 17) {
            return false;
        }
        String str = xp.f65029c;
        return "Amazon".equals(str) || "Xiaomi".equals(str);
    }

    public int c() {
        return this.f61957b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return false;
        }
        n1 n1Var = (n1) obj;
        return Arrays.equals(this.f61956a, n1Var.f61956a) && this.f61957b == n1Var.f61957b;
    }

    public int hashCode() {
        return this.f61957b + (Arrays.hashCode(this.f61956a) * 31);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f61957b + ", supportedEncodings=" + Arrays.toString(this.f61956a) + "]";
    }

    public boolean a(int i3) {
        return Arrays.binarySearch(this.f61956a, i3) >= 0;
    }

    static n1 a(Context context, Intent intent) {
        if (b() && Settings.Global.getInt(context.getContentResolver(), "external_surround_sound_enabled", 0) == 1) {
            return f61954d;
        }
        if (xp.f65027a >= 29 && xp.d(context)) {
            return new n1(a.a(), 8);
        }
        if (intent != null && intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 0) {
            return new n1(intent.getIntArrayExtra("android.media.extra.ENCODINGS"), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
        }
        return f61953c;
    }
}
