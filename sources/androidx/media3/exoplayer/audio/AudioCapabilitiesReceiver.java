package androidx.media3.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Handler;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.audio.AudioManagerCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioCapabilitiesReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f43677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Listener f43678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f43679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AudioDeviceCallbackV23 f43680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f43681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ExternalSurroundSoundSettingObserver f43682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AudioCapabilities f43683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AudioDeviceInfoApi23 f43684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AudioAttributes f43685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f43686j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api23 {
        public static void a(Context context, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            AudioManagerCompat.c(context).registerAudioDeviceCallback(audioDeviceCallback, handler);
        }

        public static void b(Context context, AudioDeviceCallback audioDeviceCallback) {
            AudioManagerCompat.c(context).unregisterAudioDeviceCallback(audioDeviceCallback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class AudioDeviceCallbackV23 extends AudioDeviceCallback {
        private AudioDeviceCallbackV23() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.f(AudioCapabilities.f(audioCapabilitiesReceiver.f43677a, AudioCapabilitiesReceiver.this.f43685i, AudioCapabilitiesReceiver.this.f43684h));
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (Util.u(audioDeviceInfoArr, AudioCapabilitiesReceiver.this.f43684h)) {
                AudioCapabilitiesReceiver.this.f43684h = null;
            }
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.f(AudioCapabilities.f(audioCapabilitiesReceiver.f43677a, AudioCapabilitiesReceiver.this.f43685i, AudioCapabilitiesReceiver.this.f43684h));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ExternalSurroundSoundSettingObserver extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f43688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f43689b;

        public ExternalSurroundSoundSettingObserver(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.f43688a = contentResolver;
            this.f43689b = uri;
        }

        public void a() {
            this.f43688a.registerContentObserver(this.f43689b, false, this);
        }

        public void b() {
            this.f43688a.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z2) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.f(AudioCapabilities.f(audioCapabilitiesReceiver.f43677a, AudioCapabilitiesReceiver.this.f43685i, AudioCapabilitiesReceiver.this.f43684h));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        private HdmiAudioPlugBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.f(AudioCapabilities.e(context, intent, audioCapabilitiesReceiver.f43685i, AudioCapabilitiesReceiver.this.f43684h));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(AudioCapabilities audioCapabilities);
    }

    /* JADX WARN: Multi-variable type inference failed */
    AudioCapabilitiesReceiver(Context context, Listener listener, AudioAttributes audioAttributes, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        Context applicationContext = context.getApplicationContext();
        this.f43677a = applicationContext;
        this.f43678b = (Listener) Assertions.e(listener);
        this.f43685i = audioAttributes;
        this.f43684h = audioDeviceInfoApi23;
        Handler handlerE = Util.E();
        this.f43679c = handlerE;
        Object[] objArr = 0;
        this.f43680d = Util.f41609a >= 23 ? new AudioDeviceCallbackV23() : null;
        this.f43681e = new HdmiAudioPlugBroadcastReceiver();
        Uri uriI = AudioCapabilities.i();
        this.f43682f = uriI != null ? new ExternalSurroundSoundSettingObserver(handlerE, applicationContext.getContentResolver(), uriI) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AudioCapabilities audioCapabilities) {
        if (!this.f43686j || audioCapabilities.equals(this.f43683g)) {
            return;
        }
        this.f43683g = audioCapabilities;
        this.f43678b.a(audioCapabilities);
    }

    public AudioCapabilities g() {
        AudioDeviceCallbackV23 audioDeviceCallbackV23;
        if (this.f43686j) {
            return (AudioCapabilities) Assertions.e(this.f43683g);
        }
        this.f43686j = true;
        ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = this.f43682f;
        if (externalSurroundSoundSettingObserver != null) {
            externalSurroundSoundSettingObserver.a();
        }
        if (Util.f41609a >= 23 && (audioDeviceCallbackV23 = this.f43680d) != null) {
            Api23.a(this.f43677a, audioDeviceCallbackV23, this.f43679c);
        }
        AudioCapabilities audioCapabilitiesE = AudioCapabilities.e(this.f43677a, this.f43677a.registerReceiver(this.f43681e, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.f43679c), this.f43685i, this.f43684h);
        this.f43683g = audioCapabilitiesE;
        return audioCapabilitiesE;
    }

    public void h(AudioAttributes audioAttributes) {
        this.f43685i = audioAttributes;
        f(AudioCapabilities.f(this.f43677a, audioAttributes, this.f43684h));
    }

    public void i(AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfoApi23 audioDeviceInfoApi23 = this.f43684h;
        if (Objects.equals(audioDeviceInfo, audioDeviceInfoApi23 == null ? null : audioDeviceInfoApi23.f43692a)) {
            return;
        }
        AudioDeviceInfoApi23 audioDeviceInfoApi232 = audioDeviceInfo != null ? new AudioDeviceInfoApi23(audioDeviceInfo) : null;
        this.f43684h = audioDeviceInfoApi232;
        f(AudioCapabilities.f(this.f43677a, this.f43685i, audioDeviceInfoApi232));
    }

    public void j() {
        AudioDeviceCallbackV23 audioDeviceCallbackV23;
        if (this.f43686j) {
            this.f43683g = null;
            if (Util.f41609a >= 23 && (audioDeviceCallbackV23 = this.f43680d) != null) {
                Api23.b(this.f43677a, audioDeviceCallbackV23);
            }
            this.f43677a.unregisterReceiver(this.f43681e);
            ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = this.f43682f;
            if (externalSurroundSoundSettingObserver != null) {
                externalSurroundSoundSettingObserver.b();
            }
            this.f43686j = false;
        }
    }
}
