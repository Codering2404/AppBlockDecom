package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ComponentActivity$activityResultRegistry$1 extends ActivityResultRegistry {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ComponentActivity f349i;

    ComponentActivity$activityResultRegistry$1(ComponentActivity componentActivity) {
        this.f349i = componentActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i3, ActivityResultContract.SynchronousResult synchronousResult) {
        componentActivity$activityResultRegistry$1.f(i3, synchronousResult.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i3, IntentSender.SendIntentException sendIntentException) {
        componentActivity$activityResultRegistry$1.e(i3, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", sendIntentException));
    }

    @Override // androidx.activity.result.ActivityResultRegistry
    public void i(final int i3, ActivityResultContract contract, Object obj, ActivityOptionsCompat activityOptionsCompat) {
        Bundle bundleB;
        final int i4;
        Intrinsics.checkNotNullParameter(contract, "contract");
        ComponentActivity componentActivity = this.f349i;
        final ActivityResultContract.SynchronousResult synchronousResult = contract.getSynchronousResult(componentActivity, obj);
        if (synchronousResult != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.h
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentActivity$activityResultRegistry$1.s(this.f525a, i3, synchronousResult);
                }
            });
            return;
        }
        Intent intentCreateIntent = contract.createIntent(componentActivity, obj);
        if (intentCreateIntent.getExtras() != null) {
            Bundle extras = intentCreateIntent.getExtras();
            Intrinsics.checkNotNull(extras);
            if (extras.getClassLoader() == null) {
                intentCreateIntent.setExtrasClassLoader(componentActivity.getClassLoader());
            }
        }
        if (intentCreateIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleB = intentCreateIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentCreateIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundleB = activityOptionsCompat != null ? activityOptionsCompat.b() : null;
        }
        Bundle bundle = bundleB;
        if (Intrinsics.areEqual("androidx.activity.result.contract.action.REQUEST_PERMISSIONS", intentCreateIntent.getAction())) {
            String[] stringArrayExtra = intentCreateIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            ActivityCompat.e(componentActivity, stringArrayExtra, i3);
            return;
        }
        if (!Intrinsics.areEqual("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST", intentCreateIntent.getAction())) {
            ActivityCompat.i(componentActivity, intentCreateIntent, i3, bundle);
            return;
        }
        IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentCreateIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            Intrinsics.checkNotNull(intentSenderRequest);
            i4 = i3;
        } catch (IntentSender.SendIntentException e3) {
            e = e3;
            i4 = i3;
        }
        try {
            ActivityCompat.j(componentActivity, intentSenderRequest.f(), i4, intentSenderRequest.c(), intentSenderRequest.d(), intentSenderRequest.e(), 0, bundle);
        } catch (IntentSender.SendIntentException e4) {
            e = e4;
            final IntentSender.SendIntentException sendIntentException = e;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.activity.i
                @Override // java.lang.Runnable
                public final void run() {
                    ComponentActivity$activityResultRegistry$1.t(this.f528a, i4, sendIntentException);
                }
            });
        }
    }
}
