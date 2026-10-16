package androidx.media3.exoplayer.audio;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.audio.AudioManagerCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioCapabilities {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AudioCapabilities f43668c = new AudioCapabilities(ImmutableList.z(AudioProfile.f43673d));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ImmutableList f43669d = ImmutableList.B(2, 5, 6);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final ImmutableMap f43670e = new ImmutableMap.Builder().g(5, 6).g(17, 6).g(7, 6).g(30, 10).g(18, 6).g(6, 8).g(8, 8).g(14, 8).d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray f43671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f43672b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api23 {
        private static ImmutableSet a() {
            ImmutableSet.Builder builderJ = new ImmutableSet.Builder().j(8, 7);
            int i3 = Util.f41609a;
            if (i3 >= 31) {
                builderJ.j(26, 27);
            }
            if (i3 >= 33) {
                builderJ.e(30);
            }
            return builderJ.n();
        }

        public static boolean b(AudioManager audioManager, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            AudioDeviceInfo[] devices = audioDeviceInfoApi23 == null ? ((AudioManager) Assertions.e(audioManager)).getDevices(2) : new AudioDeviceInfo[]{audioDeviceInfoApi23.f43692a};
            ImmutableSet immutableSetA = a();
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                if (immutableSetA.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api29 {
        /* JADX WARN: Multi-variable type inference failed */
        public static ImmutableList a(AudioAttributes audioAttributes) {
            ImmutableList.Builder builderO = ImmutableList.o();
            UnmodifiableIterator it = AudioCapabilities.f43670e.keySet().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                int iIntValue = num.intValue();
                if (Util.f41609a >= Util.N(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), audioAttributes.a().f40530a)) {
                    builderO.a(num);
                }
            }
            builderO.a(2);
            return builderO.m();
        }

        public static int b(int i3, int i4, AudioAttributes audioAttributes) {
            for (int i5 = 10; i5 > 0; i5--) {
                int iP = Util.P(i5);
                if (iP != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i3).setSampleRate(i4).setChannelMask(iP).build(), audioAttributes.a().f40530a)) {
                    return i5;
                }
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api33 {
        public static AudioCapabilities a(AudioManager audioManager, AudioAttributes audioAttributes) {
            return new AudioCapabilities(AudioCapabilities.c(audioManager.getDirectProfilesForAttributes(audioAttributes.a().f40530a)));
        }

        public static AudioDeviceInfoApi23 b(AudioManager audioManager, AudioAttributes audioAttributes) {
            try {
                List audioDevicesForAttributes = ((AudioManager) Assertions.e(audioManager)).getAudioDevicesForAttributes(audioAttributes.a().f40530a);
                if (audioDevicesForAttributes.isEmpty()) {
                    return null;
                }
                return new AudioDeviceInfoApi23((AudioDeviceInfo) audioDevicesForAttributes.get(0));
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    private static boolean b() {
        String str = Build.MANUFACTURER;
        return str.equals("Amazon") || str.equals("Xiaomi");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ImmutableList c(List list) {
        HashMap map = new HashMap();
        map.put(2, new HashSet(Ints.c(12)));
        for (int i3 = 0; i3 < list.size(); i3++) {
            android.media.AudioProfile audioProfileA = a.a(list.get(i3));
            if (audioProfileA.getEncapsulationType() != 1) {
                int format = audioProfileA.getFormat();
                if (Util.C0(format) || f43670e.containsKey(Integer.valueOf(format))) {
                    if (map.containsKey(Integer.valueOf(format))) {
                        ((Set) Assertions.e((Set) map.get(Integer.valueOf(format)))).addAll(Ints.c(audioProfileA.getChannelMasks()));
                    } else {
                        map.put(Integer.valueOf(format), new HashSet(Ints.c(audioProfileA.getChannelMasks())));
                    }
                }
            }
        }
        ImmutableList.Builder builderO = ImmutableList.o();
        for (Map.Entry entry : map.entrySet()) {
            builderO.a(new AudioProfile(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
        }
        return builderO.m();
    }

    private static ImmutableList d(int[] iArr, int i3) {
        ImmutableList.Builder builderO = ImmutableList.o();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i4 : iArr) {
            builderO.a(new AudioProfile(i4, i3));
        }
        return builderO.m();
    }

    static AudioCapabilities e(Context context, Intent intent, AudioAttributes audioAttributes, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        AudioManager audioManagerC = AudioManagerCompat.c(context);
        if (audioDeviceInfoApi23 == null) {
            audioDeviceInfoApi23 = Util.f41609a >= 33 ? Api33.b(audioManagerC, audioAttributes) : null;
        }
        int i3 = Util.f41609a;
        if (i3 >= 33 && (Util.H0(context) || Util.z0(context))) {
            return Api33.a(audioManagerC, audioAttributes);
        }
        if (i3 >= 23 && Api23.b(audioManagerC, audioDeviceInfoApi23)) {
            return f43668c;
        }
        ImmutableSet.Builder builder = new ImmutableSet.Builder();
        builder.e(2);
        if (i3 >= 29 && (Util.H0(context) || Util.z0(context))) {
            builder.k(Api29.a(audioAttributes));
            return new AudioCapabilities(d(Ints.n(builder.n()), 10));
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z2 = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if ((z2 || b()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            builder.k(f43669d);
        }
        if (intent == null || z2 || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new AudioCapabilities(d(Ints.n(builder.n()), 10));
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            builder.k(Ints.c(intArrayExtra));
        }
        return new AudioCapabilities(d(Ints.n(builder.n()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
    }

    static AudioCapabilities f(Context context, AudioAttributes audioAttributes, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        return e(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), audioAttributes, audioDeviceInfoApi23);
    }

    private static int g(int i3) {
        int i4 = Util.f41609a;
        if (i4 <= 28) {
            if (i3 == 7) {
                i3 = 8;
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                i3 = 6;
            }
        }
        if (i4 <= 26 && "fugu".equals(Build.DEVICE) && i3 == 1) {
            i3 = 2;
        }
        return Util.P(i3);
    }

    static Uri i() {
        if (b()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        return Util.v(this.f43671a, audioCapabilities.f43671a) && this.f43672b == audioCapabilities.f43672b;
    }

    public Pair h(Format format, AudioAttributes audioAttributes) {
        int iE = MimeTypes.e((String) Assertions.e(format.f40632o), format.f40628k);
        if (!f43670e.containsKey(Integer.valueOf(iE))) {
            return null;
        }
        if (iE == 18 && !k(18)) {
            iE = 6;
        } else if ((iE == 8 && !k(8)) || (iE == 30 && !k(30))) {
            iE = 7;
        }
        if (!k(iE)) {
            return null;
        }
        AudioProfile audioProfile = (AudioProfile) Assertions.e((AudioProfile) this.f43671a.get(iE));
        int iB = format.E;
        if (iB == -1 || iE == 18) {
            int i3 = format.F;
            if (i3 == -1) {
                i3 = 48000;
            }
            iB = audioProfile.b(i3, audioAttributes);
        } else if (!format.f40632o.equals("audio/vnd.dts.uhd;profile=p2") || Util.f41609a >= 33) {
            if (!audioProfile.c(iB)) {
                return null;
            }
        } else if (iB > 10) {
            return null;
        }
        int iG = g(iB);
        if (iG == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iE), Integer.valueOf(iG));
    }

    public int hashCode() {
        return this.f43672b + (Util.w(this.f43671a) * 31);
    }

    public boolean j(Format format, AudioAttributes audioAttributes) {
        return h(format, audioAttributes) != null;
    }

    public boolean k(int i3) {
        return Util.t(this.f43671a, i3);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f43672b + ", audioProfiles=" + this.f43671a + "]";
    }

    private AudioCapabilities(List list) {
        this.f43671a = new SparseArray();
        for (int i3 = 0; i3 < list.size(); i3++) {
            AudioProfile audioProfile = (AudioProfile) list.get(i3);
            this.f43671a.put(audioProfile.f43674a, audioProfile);
        }
        int iMax = 0;
        for (int i4 = 0; i4 < this.f43671a.size(); i4++) {
            iMax = Math.max(iMax, ((AudioProfile) this.f43671a.valueAt(i4)).f43675b);
        }
        this.f43672b = iMax;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AudioProfile {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AudioProfile f43673d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ImmutableSet f43676c;

        static {
            f43673d = Util.f41609a >= 33 ? new AudioProfile(2, a(10)) : new AudioProfile(2, 10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AudioProfile(int i3, Set set) {
            this.f43674a = i3;
            ImmutableSet immutableSetU = ImmutableSet.u(set);
            this.f43676c = immutableSetU;
            UnmodifiableIterator it = immutableSetU.iterator();
            int iMax = 0;
            while (it.hasNext()) {
                iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
            }
            this.f43675b = iMax;
        }

        private static ImmutableSet a(int i3) {
            ImmutableSet.Builder builder = new ImmutableSet.Builder();
            for (int i4 = 1; i4 <= i3; i4++) {
                builder.e(Integer.valueOf(Util.P(i4)));
            }
            return builder.n();
        }

        public int b(int i3, AudioAttributes audioAttributes) {
            return this.f43676c != null ? this.f43675b : Util.f41609a >= 29 ? Api29.b(this.f43674a, i3, audioAttributes) : ((Integer) Assertions.e((Integer) AudioCapabilities.f43670e.getOrDefault(Integer.valueOf(this.f43674a), 0))).intValue();
        }

        public boolean c(int i3) {
            if (this.f43676c == null) {
                return i3 <= this.f43675b;
            }
            int iP = Util.P(i3);
            if (iP == 0) {
                return false;
            }
            return this.f43676c.contains(Integer.valueOf(iP));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioProfile)) {
                return false;
            }
            AudioProfile audioProfile = (AudioProfile) obj;
            return this.f43674a == audioProfile.f43674a && this.f43675b == audioProfile.f43675b && Objects.equals(this.f43676c, audioProfile.f43676c);
        }

        public int hashCode() {
            int i3 = ((this.f43674a * 31) + this.f43675b) * 31;
            ImmutableSet immutableSet = this.f43676c;
            return i3 + (immutableSet == null ? 0 : immutableSet.hashCode());
        }

        public String toString() {
            return "AudioProfile[format=" + this.f43674a + ", maxChannelCount=" + this.f43675b + ", channelMasks=" + this.f43676c + "]";
        }

        public AudioProfile(int i3, int i4) {
            this.f43674a = i3;
            this.f43675b = i4;
            this.f43676c = null;
        }
    }
}
