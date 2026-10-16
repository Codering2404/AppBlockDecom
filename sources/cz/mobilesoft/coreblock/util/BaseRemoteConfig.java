package cz.mobilesoft.coreblock.util;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public abstract class BaseRemoteConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f127780a = TimeUnit.MINUTES.toSeconds(5);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f127781b = SetsKt.setOf((Object[]) new String[]{"com.google.android.youtube", "com.google.android.apps.youtube.music", "com.android.chrome", "com.samsung.android.game.gamehome", "com.samsung.android.game.gametools", "com.sec.android.gallery3d", "com.google.android.play.games", "com.samsung.android.tvplus", "tv.twitch.android.app", "com.instagram.android", "com.netflix.mediaclient", "com.google.android.apps.photos", "com.android.vending", "com.google.android.apps.docs", "com.oneplus.gallery", "com.oplus.games", "com.miui.player", "com.miui.videoplayer", "com.miui.gallery", "com.facebook.katana", "com.samsung.android.bixby.agent", "com.samsung.android.arzone", "com.sec.android.app.samsungapps", "com.google.android.googlequicksearchbox", "com.google.android.apps.tachyon", "com.microsoft.skydrive", "com.samsung.android.app.spage", "com.samsung.android.samsungpass"});

    public static String a(String str) {
        return "android_paywall_" + str.replace('-', '_');
    }
}
