package cz.mobilesoft.coreblock.util.permissions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
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
public final class HomeKeyWatcher {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f128994d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f128995e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f128996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OnKeyPressedListener f128997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HomeReceiver f128998c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class HomeReceiver extends BroadcastReceiver {
        public HomeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (!Intrinsics.areEqual(intent.getAction(), "android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null) {
                return;
            }
            HomeKeyWatcher homeKeyWatcher = HomeKeyWatcher.this;
            if (Intrinsics.areEqual(stringExtra, "homekey")) {
                homeKeyWatcher.f128997b.m();
            } else if (Intrinsics.areEqual(stringExtra, "recentapps")) {
                homeKeyWatcher.f128997b.q();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnKeyPressedListener {
        void m();

        void q();
    }

    public HomeKeyWatcher(Context context, OnKeyPressedListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f128996a = context;
        this.f128997b = listener;
        this.f128998c = new HomeReceiver();
    }

    public final void b() {
        ContextExtKt.h(this.f128996a, this.f128998c, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), 2);
    }

    public final void c() {
        this.f128996a.unregisterReceiver(this.f128998c);
    }
}
