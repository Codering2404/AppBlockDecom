package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import c1.ub.AsHNMpHTEsKfE;
import com.google.firebase.crashlytics.internal.metadata.rSN.xSRx;
import com.pairip.VMRunner;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class CustomTabActivity extends Activity {
    public static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
    public BroadcastReceiver closeReceiver;
    public static final Companion Companion = new Companion(null);
    public static final String CUSTOM_TAB_REDIRECT_ACTION = CustomTabActivity.class.getSimpleName() + QaXmqxvjHhxVy.XlYhFWN;
    public static final String DESTROY_ACTION = CustomTabActivity.class.getSimpleName() + ".action_destroy";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        if (i4 == 0) {
            Intent intent2 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
            LocalBroadcastManager.b(this).d(intent2);
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.facebook.CustomTabActivity$onActivityResult$closeReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent3) {
                    VMRunner.invoke("GcrITuBygbxRgpiJ", new Object[]{this, context, intent3});
                }
            };
            LocalBroadcastManager.b(this).c(broadcastReceiver, new IntentFilter(DESTROY_ACTION));
            this.closeReceiver = broadcastReceiver;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalAccessException, InvocationTargetException {
        xSRx.DXnjn.invoke(null, this, bundle);
    }

    @Override // android.app.Activity
    protected void onDestroy() throws IllegalAccessException, InvocationTargetException {
        AsHNMpHTEsKfE.NESnRqppkp.invoke(null, this);
    }
}
