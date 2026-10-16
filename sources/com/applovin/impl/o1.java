package com.applovin.impl;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioManager f62155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f62156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f62157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l1 f62158d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f62160f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AudioFocusRequest f62162h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f62163i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f62161g = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f62159e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f62164a;

        public a(Handler handler) {
            this.f62164a = handler;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i3) {
            this.f62164a.post(new Runnable() { // from class: com.applovin.impl.yz
                @Override // java.lang.Runnable
                public final void run() {
                    this.f65272a.a(i3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i3) {
            o1.this.b(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void b(float f3);

        void f(int i3);
    }

    public o1(Context context, Handler handler, b bVar) {
        this.f62155a = (AudioManager) b1.a((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.f62157c = bVar;
        this.f62156b = new a(handler);
    }

    private void a() {
        this.f62155a.abandonAudioFocus(this.f62156b);
    }

    private void b() {
        if (this.f62159e == 0) {
            return;
        }
        if (xp.f65027a >= 26) {
            c();
        } else {
            a();
        }
        c(0);
    }

    private void c() {
        AudioFocusRequest audioFocusRequest = this.f62162h;
        if (audioFocusRequest != null) {
            this.f62155a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private int f() {
        if (this.f62159e == 1) {
            return 1;
        }
        if ((xp.f65027a >= 26 ? h() : g()) == 1) {
            c(1);
            return 1;
        }
        c(0);
        return -1;
    }

    private int g() {
        return this.f62155a.requestAudioFocus(this.f62156b, xp.e(((l1) b1.a(this.f62158d)).f61094c), this.f62160f);
    }

    private int h() {
        AudioFocusRequest audioFocusRequest = this.f62162h;
        if (audioFocusRequest == null || this.f62163i) {
            this.f62162h = (audioFocusRequest == null ? new AudioFocusRequest.Builder(this.f62160f) : new AudioFocusRequest.Builder(this.f62162h)).setAudioAttributes(((l1) b1.a(this.f62158d)).a()).setWillPauseWhenDucked(i()).setOnAudioFocusChangeListener(this.f62156b).build();
            this.f62163i = false;
        }
        return this.f62155a.requestAudioFocus(this.f62162h);
    }

    private boolean i() {
        l1 l1Var = this.f62158d;
        return l1Var != null && l1Var.f61092a == 1;
    }

    public float d() {
        return this.f62161g;
    }

    public void e() {
        this.f62157c = null;
        b();
    }

    private boolean d(int i3) {
        return i3 == 1 || this.f62160f != 1;
    }

    private static int a(l1 l1Var) {
        if (l1Var == null) {
            return 0;
        }
        switch (l1Var.f61094c) {
            case 0:
                oc.d("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (l1Var.f61092a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                oc.d("AudioFocusManager", "Unidentified audio usage: " + l1Var.f61094c);
                return 0;
            case 16:
                return xp.f65027a >= 19 ? 4 : 2;
        }
    }

    private void c(int i3) {
        if (this.f62159e == i3) {
            return;
        }
        this.f62159e = i3;
        float f3 = i3 == 3 ? 0.2f : 1.0f;
        if (this.f62161g == f3) {
            return;
        }
        this.f62161g = f3;
        b bVar = this.f62157c;
        if (bVar != null) {
            bVar.b(f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i3) {
        if (i3 == -3 || i3 == -2) {
            if (i3 != -2 && !i()) {
                c(3);
                return;
            } else {
                a(0);
                c(2);
                return;
            }
        }
        if (i3 == -1) {
            a(-1);
            b();
        } else {
            if (i3 != 1) {
                oc.d("AudioFocusManager", "Unknown focus change type: " + i3);
                return;
            }
            c(1);
            a(1);
        }
    }

    private void a(int i3) {
        b bVar = this.f62157c;
        if (bVar != null) {
            bVar.f(i3);
        }
    }

    public int a(boolean z2, int i3) {
        if (d(i3)) {
            b();
            return z2 ? 1 : -1;
        }
        if (z2) {
            return f();
        }
        return -1;
    }

    public void b(l1 l1Var) {
        if (xp.a(this.f62158d, l1Var)) {
            return;
        }
        this.f62158d = l1Var;
        int iA = a(l1Var);
        this.f62160f = iA;
        boolean z2 = true;
        if (iA != 1 && iA != 0) {
            z2 = false;
        }
        b1.a(z2, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }
}
