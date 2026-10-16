package com.google.firebase.crashlytics.internal.settings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class Settings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SessionData f89051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FeatureFlagData f89052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f89053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f89054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f89055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f89056f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f89057g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f89058h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FeatureFlagData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f89059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f89060b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f89061c;

        public FeatureFlagData(boolean z2, boolean z3, boolean z4) {
            this.f89059a = z2;
            this.f89060b = z3;
            this.f89061c = z4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class SessionData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f89062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f89063b;

        public SessionData(int i3, int i4) {
            this.f89062a = i3;
            this.f89063b = i4;
        }
    }

    public Settings(long j3, SessionData sessionData, FeatureFlagData featureFlagData, int i3, int i4, double d3, double d4, int i5) {
        this.f89053c = j3;
        this.f89051a = sessionData;
        this.f89052b = featureFlagData;
        this.f89054d = i3;
        this.f89055e = i4;
        this.f89056f = d3;
        this.f89057g = d4;
        this.f89058h = i5;
    }

    public boolean a(long j3) {
        return this.f89053c < j3;
    }
}
