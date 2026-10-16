package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;
import com.google.firebase.platforminfo.KotlinDetector;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static /* synthetic */ String a(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? e(installerPackageName) : "";
    }

    public static /* synthetic */ String b(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.minSdkVersion) : "";
    }

    public static /* synthetic */ String c(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
    }

    public static /* synthetic */ String d(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : context.getPackageManager().hasSystemFeature("android.hardware.type.automotive") ? "auto" : context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") ? "embedded" : "";
    }

    private static String e(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(DefaultUserAgentPublisher.c());
        arrayList.add(DefaultHeartBeatController.g());
        arrayList.add(LibraryVersionComponent.b("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(LibraryVersionComponent.b("fire-core", "22.0.1"));
        arrayList.add(LibraryVersionComponent.b("device-name", e(Build.PRODUCT)));
        arrayList.add(LibraryVersionComponent.b("device-model", e(Build.DEVICE)));
        arrayList.add(LibraryVersionComponent.b("device-brand", e(Build.BRAND)));
        arrayList.add(LibraryVersionComponent.c("android-target-sdk", new LibraryVersionComponent.VersionExtractor() { // from class: com.google.firebase.c
            @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.c((Context) obj);
            }
        }));
        arrayList.add(LibraryVersionComponent.c("android-min-sdk", new LibraryVersionComponent.VersionExtractor() { // from class: com.google.firebase.d
            @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.b((Context) obj);
            }
        }));
        arrayList.add(LibraryVersionComponent.c("android-platform", new LibraryVersionComponent.VersionExtractor() { // from class: com.google.firebase.e
            @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.d((Context) obj);
            }
        }));
        arrayList.add(LibraryVersionComponent.c("android-installer", new LibraryVersionComponent.VersionExtractor() { // from class: com.google.firebase.f
            @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.a((Context) obj);
            }
        }));
        String strA = KotlinDetector.a();
        if (strA != null) {
            arrayList.add(LibraryVersionComponent.b("kotlin", strA));
        }
        return arrayList;
    }
}
