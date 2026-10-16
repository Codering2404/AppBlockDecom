package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.CustomTab;
import com.facebook.internal.InstagramCustomTab;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginTargetApp;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CustomTabMainActivity extends Activity {
    public BroadcastReceiver redirectReceiver;
    public boolean shouldCloseCustomTab = true;
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_ACTION = CustomTabMainActivity.class.getSimpleName() + ".extra_action";
    public static final String EXTRA_PARAMS = CustomTabMainActivity.class.getSimpleName() + ".extra_params";
    public static final String EXTRA_CHROME_PACKAGE = CustomTabMainActivity.class.getSimpleName() + ".extra_chromePackage";
    public static final String EXTRA_URL = CustomTabMainActivity.class.getSimpleName() + ".extra_url";
    public static final String EXTRA_TARGET_APP = CustomTabMainActivity.class.getSimpleName() + ".extra_targetApp";
    public static final String REFRESH_ACTION = CustomTabMainActivity.class.getSimpleName() + ".action_refresh";
    public static final String NO_ACTIVITY_EXCEPTION = CustomTabMainActivity.class.getSimpleName() + ".no_activity_exception";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Bundle parseResponseUri(String str) {
            Uri uri = Uri.parse(str);
            Bundle urlQueryString = Utility.parseUrlQueryString(uri.getQuery());
            urlQueryString.putAll(Utility.parseUrlQueryString(uri.getFragment()));
            return urlQueryString;
        }

        public Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginTargetApp.values().length];
            try {
                iArr[LoginTargetApp.INSTAGRAM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void sendResult(int i3, Intent intent) {
        BroadcastReceiver broadcastReceiver = this.redirectReceiver;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.b(this).e(broadcastReceiver);
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra(EXTRA_URL);
            Bundle responseUri = stringExtra != null ? Companion.parseResponseUri(stringExtra) : new Bundle();
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "intent");
            Intent intentCreateProtocolResultIntent = NativeProtocol.createProtocolResultIntent(intent2, responseUri, null);
            if (intentCreateProtocolResultIntent != null) {
                intent = intentCreateProtocolResultIntent;
            }
            setResult(i3, intent);
        } else {
            Intent intent3 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent3, "intent");
            setResult(i3, NativeProtocol.createProtocolResultIntent(intent3, null, null));
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        String stringExtra;
        super.onCreate(bundle);
        String str = CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION;
        if (Intrinsics.areEqual(str, getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (bundle != null || (stringExtra = getIntent().getStringExtra(EXTRA_ACTION)) == null) {
            return;
        }
        Bundle bundleExtra = getIntent().getBundleExtra(EXTRA_PARAMS);
        boolean zOpenCustomTab = (WhenMappings.$EnumSwitchMapping$0[LoginTargetApp.Companion.fromString(getIntent().getStringExtra(EXTRA_TARGET_APP)).ordinal()] == 1 ? new InstagramCustomTab(stringExtra, bundleExtra) : new CustomTab(stringExtra, bundleExtra)).openCustomTab(this, getIntent().getStringExtra(EXTRA_CHROME_PACKAGE));
        this.shouldCloseCustomTab = false;
        if (!zOpenCustomTab) {
            setResult(0, getIntent().putExtra(NO_ACTIVITY_EXCEPTION, true));
            finish();
        } else {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.facebook.CustomTabMainActivity$onCreate$redirectReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    Intent intent2 = new Intent(this.this$0, (Class<?>) CustomTabMainActivity.class);
                    intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
                    String str2 = CustomTabMainActivity.EXTRA_URL;
                    intent2.putExtra(str2, intent.getStringExtra(str2));
                    intent2.addFlags(603979776);
                    this.this$0.startActivity(intent2);
                }
            };
            this.redirectReceiver = broadcastReceiver;
            LocalBroadcastManager.b(this).c(broadcastReceiver, new IntentFilter(str));
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        if (Intrinsics.areEqual(REFRESH_ACTION, intent.getAction())) {
            LocalBroadcastManager.b(this).d(new Intent(CustomTabActivity.DESTROY_ACTION));
            sendResult(-1, intent);
        } else if (Intrinsics.areEqual(CustomTabActivity.CUSTOM_TAB_REDIRECT_ACTION, intent.getAction())) {
            sendResult(-1, intent);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.shouldCloseCustomTab) {
            sendResult(0, null);
        }
        this.shouldCloseCustomTab = true;
    }
}
