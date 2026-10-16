package androidx.credentials.playservices;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.credentials.playservices.controllers.CredentialProviderBaseController;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public class IdentityCredentialApiHiddenActivity extends Activity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f34953c = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ResultReceiver f34954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f34955b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void a(Bundle bundle) {
        if (bundle != null) {
            this.f34955b = bundle.getBoolean("androidx.credentials.playservices.AWAITING_RESULT", false);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        ResultReceiver resultReceiver = this.f34954a;
        if (resultReceiver != null) {
            CredentialProviderBaseController.f35097b.f(resultReceiver, i3, i4, intent);
        }
        this.f34955b = false;
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws IntentSender.SendIntentException {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("RESULT_RECEIVER");
        this.f34954a = resultReceiver;
        if (resultReceiver == null) {
            finish();
        }
        a(bundle);
        if (this.f34955b) {
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra("EXTRA_GET_CREDENTIAL_INTENT");
        if (pendingIntent != null) {
            startIntentSenderForResult(pendingIntent.getIntentSender(), CredentialProviderBaseController.f35097b.b(), null, 0, 0, 0, null);
            return;
        }
        ResultReceiver resultReceiver2 = this.f34954a;
        if (resultReceiver2 != null) {
            CredentialProviderBaseController.f35097b.e(resultReceiver2, "GET_UNKNOWN", "Internal error");
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean("androidx.credentials.playservices.AWAITING_RESULT", this.f34955b);
        super.onSaveInstanceState(outState);
    }
}
