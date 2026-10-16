package androidx.glance.session;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.PowerManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
public final class IdleEventBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f39539b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List f39540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final IntentFilter f39541d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f39542a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntentFilter a() {
            return IdleEventBroadcastReceiver.f39541d;
        }

        private Companion() {
        }
    }

    static {
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"android.os.action.DEVICE_IDLE_MODE_CHANGED", "android.os.action.LIGHT_DEVICE_IDLE_MODE_CHANGED", "android.os.action.LOW_POWER_STANDBY_ENABLED_CHANGED"});
        f39540c = listListOf;
        IntentFilter intentFilter = new IntentFilter();
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            intentFilter.addAction((String) it.next());
        }
        f39541d = intentFilter;
    }

    public IdleEventBroadcastReceiver(Function0 function0) {
        this.f39542a = function0;
    }

    public final void b(Context context) {
        int i3 = Build.VERSION.SDK_INT;
        Object systemService = context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager powerManager = (PowerManager) systemService;
        boolean zA = Api23Impl.f39523a.a(powerManager);
        if (i3 >= 33) {
            zA = zA || Api33Impl.f39524a.a(powerManager);
        }
        if (zA) {
            this.f39542a.invoke();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (CollectionsKt.contains(f39540c, intent.getAction())) {
            b(context);
        }
    }
}
