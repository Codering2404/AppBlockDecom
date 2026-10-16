package cz.mobilesoft.coreblock.util;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.installations.FirebaseInstallations;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AnswersSenderHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static FirebaseAnalytics f127776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f127777c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnswersSenderHelper f127775a = new AnswersSenderHelper();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f127778d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f127779e = 8;

    private AnswersSenderHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Task task) {
        String str;
        FirebaseAnalytics firebaseAnalytics;
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful() || (str = (String) task.getResult()) == null || (firebaseAnalytics = f127776b) == null) {
            return;
        }
        firebaseAnalytics.c("installation_id", str);
    }

    public final void b(Context context, String str) {
        f127777c = str;
        f127778d = FlavoredInitHelper.f127873a.b(str);
        try {
            Intrinsics.checkNotNull(context);
            f127776b = FirebaseAnalytics.getInstance(context);
        } catch (Exception e3) {
            CrashHelper.j(e3);
            e3.printStackTrace();
        }
        FirebaseInstallations.p().getId().addOnCompleteListener(new OnCompleteListener() { // from class: cz.mobilesoft.coreblock.util.i
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                AnswersSenderHelper.c(task);
            }
        });
    }

    public final boolean d() {
        return f127778d;
    }

    public final void e(String eventId, Bundle bundle) {
        FirebaseAnalytics firebaseAnalytics;
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        if (!f127778d || (firebaseAnalytics = f127776b) == null) {
            return;
        }
        firebaseAnalytics.a(eventId, bundle);
    }

    public final void f() {
        FirebaseAnalytics firebaseAnalytics = f127776b;
        if (firebaseAnalytics != null) {
            firebaseAnalytics.a("first_install", BundleKt.b(TuplesKt.a("source", f127777c)));
        }
    }

    public final void g(boolean z2) {
        FirebaseAnalytics firebaseAnalytics = f127776b;
        if (firebaseAnalytics != null) {
            firebaseAnalytics.b(z2);
        }
    }

    public final void h(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        FirebaseAnalytics firebaseAnalytics = f127776b;
        if (firebaseAnalytics != null) {
            firebaseAnalytics.c(key, value);
        }
    }
}
