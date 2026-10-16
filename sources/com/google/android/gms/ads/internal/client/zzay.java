package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnx;
import com.google.android.gms.internal.ads.zzbny;
import com.google.android.gms.internal.ads.zzbyy;
import com.google.android.gms.internal.ads.zzccu;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzay {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final zzay f69829g = new zzay();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f69830h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.util.client.zzf f69831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzaw f69832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f69833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VersionInfoParcel f69834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Random f69835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f69836f;

    protected zzay() {
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = new com.google.android.gms.ads.internal.util.client.zzf();
        zzaw zzawVar = new zzaw(new zzk(), new zzi(), new zzfc(), new zzbnx(), new zzccu(), new zzbyy(), new zzbny(), new zzl());
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(0, ModuleDescriptor.MODULE_VERSION, true);
        Random random = new Random();
        String strU = com.google.android.gms.ads.internal.util.client.zzf.u();
        this.f69831a = zzfVar;
        this.f69832b = zzawVar;
        this.f69833c = false;
        this.f69834d = versionInfoParcel;
        this.f69835e = random;
        this.f69836f = strU;
    }

    public static com.google.android.gms.ads.internal.util.client.zzf a() {
        return f69829g.f69831a;
    }

    public static zzaw b() {
        return f69829g.f69832b;
    }

    public static void c() {
        f69829g.f69833c = false;
    }

    public static void d() {
        f69829g.f69833c = true;
    }

    public static boolean e() {
        return f69829g.f69833c;
    }

    public static String f() {
        return f69829g.f69836f;
    }

    public static VersionInfoParcel g() {
        return f69829g.f69834d;
    }

    public static Random h() {
        return f69829g.f69835e;
    }
}
