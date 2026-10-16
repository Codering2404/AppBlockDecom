package dev.doubledot.doki.ui;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import dev.doubledot.doki.api.extensions.ConstantsKt;
import dev.doubledot.doki.api.tasks.DokiApi;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DokiActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion(null);
    public static final String MANUFACTURER_EXTRA = "dev.doubledot.doki.ui.DokiActivity.MANUFACTURER_EXTRA";
    private DokiApi api;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ Intent newIntent$default(Companion companion, Context context, String str, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = ConstantsKt.getDONT_KILL_MY_APP_DEFAULT_MANUFACTURER();
            }
            return companion.newIntent(context, str);
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, String str, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = ConstantsKt.getDONT_KILL_MY_APP_DEFAULT_MANUFACTURER();
            }
            companion.start(context, str);
        }

        public final Intent newIntent(Context context) {
            return newIntent$default(this, context, null, 2, null);
        }

        public final void start(Context context) {
            start$default(this, context, null, 2, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent newIntent(Context context, String manufacturerId) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(manufacturerId, "manufacturerId");
            Intent intent = new Intent(context, (Class<?>) DokiActivity.class);
            intent.putExtra(DokiActivity.MANUFACTURER_EXTRA, manufacturerId);
            return intent;
        }

        public final void start(Context context, String manufacturerId) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(manufacturerId, "manufacturerId");
            context.startActivity(newIntent(context, manufacturerId));
        }
    }

    public final DokiApi getApi() {
        return this.api;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r7) {
        /*
            r6 = this;
            super.onCreate(r7)
            dev.doubledot.doki.views.DokiContentView r0 = new dev.doubledot.doki.views.DokiContentView
            r4 = 6
            r5 = 0
            r2 = 0
            r3 = 0
            r1 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            r6.setContentView(r0)
            android.content.Intent r7 = r6.getIntent()
            java.lang.String r2 = "intent"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r2)
            android.os.Bundle r7 = r7.getExtras()
            if (r7 == 0) goto L2f
            java.lang.String r2 = "dev.doubledot.doki.ui.DokiActivity.MANUFACTURER_EXTRA"
            java.lang.Object r7 = r7.get(r2)
            boolean r2 = r7 instanceof java.lang.String
            if (r2 != 0) goto L2a
            r7 = 0
        L2a:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L2f
            goto L33
        L2f:
            java.lang.String r7 = dev.doubledot.doki.api.extensions.ConstantsKt.getDONT_KILL_MY_APP_DEFAULT_MANUFACTURER()
        L33:
            dev.doubledot.doki.api.tasks.DokiApi r7 = r0.loadContent(r7)
            r1.api = r7
            dev.doubledot.doki.ui.DokiActivity$onCreate$2 r7 = new dev.doubledot.doki.ui.DokiActivity$onCreate$2
            r7.<init>()
            r0.setOnCloseListener(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.doubledot.doki.ui.DokiActivity.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        DokiApi dokiApi = this.api;
        if (dokiApi != null) {
            dokiApi.cancel();
        }
    }

    public final void setApi(DokiApi dokiApi) {
        this.api = dokiApi;
    }
}
