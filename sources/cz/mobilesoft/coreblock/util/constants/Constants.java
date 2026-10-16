package cz.mobilesoft.coreblock.util.constants;

import android.os.Build;
import cz.mobilesoft.coreblock.BuildConfig;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class Constants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f128443a = CollectionsKt.listOf((Object[]) new Integer[]{3, 14, 30});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f128444b = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f128445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set f128446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set f128447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set f128448f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set f128449g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f128450h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set f128451i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set f128452j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Set f128453k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set f128454l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public @interface LoginProvider {
    }

    static {
        f128445c = ((long) ((BuildConfig.f95357b.booleanValue() ? 2 : 10) * 60)) * 1000;
        f128446d = SetsKt.setOf((Object[]) new String[]{"com.android.settings.SubSettings", "com.android.settings.bluetooth.BluetoothPairingDialog"});
        f128447e = SetsKt.setOf((Object[]) new String[]{"com.google.android.apps.search.assistant.surfaces.voice.robin.main.MainActivity", "com.google.android.apps.search.lens.LensIntentActivity"});
        f128448f = SetsKt.setOf((Object[]) new String[]{"com.google.android.finsky.inappreviewdialog.InAppReviewActivity", "com.google.android.finsky.installservice.DevTriggeredUpdateService"});
        f128449g = SetsKt.setOf((Object[]) new String[]{"com.facebook.katana", "com.instagram.android", "com.google.android.googlequicksearchbox", "com.whatsapp"});
        f128450h = Build.VERSION.SDK_INT >= 29 ? "((.*:)//)?(www\\.)?([\\p{Ll}\\p{Lt}\\p{IsHangul}\\p{Arabic}一-龯ぁ-んァ-ン0-9\\-]+)(:[0-9]+)?(.*)" : "((.*:)//)?(www\\.)?([\\p{Ll}\\p{Lt}\\p{Arabic}一-龯ぁ-んァ-ン0-9\\-]+)(:[0-9]+)?(.*)";
        f128451i = SetsKt.setOf("com.samsung.knox.securefolder");
        f128452j = SetsKt.setOf((Object[]) new String[]{"Facebook", "Facebook Web"});
        f128453k = SetsKt.setOf((Object[]) new String[]{"com.samsung.android.lool", "com.oplus.battery"});
        f128454l = SetsKt.setOf((Object[]) new String[]{"com.samsung.accessory.berrymgr", "com.samsung.accessory.popcornmgr", "com.samsung.accessory.beatsmgr", "com.samsung.accessory.budsplugin", "com.samsung.accessory.neobeanmgr", "com.samsung.accessory.beansmgr", "com.samsung.accessory.dewdropmgr", "com.samsung.accessory.elikipmgr", "com.samsung.accessory.fridaymgr", "com.samsung.accessory.framemanager", "com.samsung.accessory.atticmgr", "com.samsung.android.smarttag"});
    }
}
