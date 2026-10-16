package com.google.firebase.crashlytics.internal;

import android.content.Context;
import com.facebook.LegacyTokenHelper;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DevelopmentPlatformProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f88275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DevelopmentPlatform f88276b = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DevelopmentPlatform {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f88277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f88278b;

        private DevelopmentPlatform() {
            int iP = CommonUtils.p(DevelopmentPlatformProvider.this.f88275a, "com.google.firebase.crashlytics.unity_version", LegacyTokenHelper.TYPE_STRING);
            if (iP == 0) {
                if (!DevelopmentPlatformProvider.this.c("flutter_assets/NOTICES.Z")) {
                    this.f88277a = null;
                    this.f88278b = null;
                    return;
                } else {
                    this.f88277a = "Flutter";
                    this.f88278b = null;
                    Logger.f().i("Development platform is: Flutter");
                    return;
                }
            }
            this.f88277a = "Unity";
            String string = DevelopmentPlatformProvider.this.f88275a.getResources().getString(iP);
            this.f88278b = string;
            Logger.f().i("Unity Editor version is: " + string);
        }
    }

    public DevelopmentPlatformProvider(Context context) {
        this.f88275a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        if (this.f88275a.getAssets() == null) {
            return false;
        }
        try {
            InputStream inputStreamOpen = this.f88275a.getAssets().open(str);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private DevelopmentPlatform f() {
        if (this.f88276b == null) {
            this.f88276b = new DevelopmentPlatform();
        }
        return this.f88276b;
    }

    public String d() {
        return f().f88277a;
    }

    public String e() {
        return f().f88278b;
    }
}
