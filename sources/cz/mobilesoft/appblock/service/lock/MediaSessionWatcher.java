package cz.mobilesoft.appblock.service.lock;

import android.content.ComponentName;
import android.content.Context;
import android.media.session.MediaController;
import android.os.Handler;
import android.os.Looper;
import cz.mobilesoft.appblock.service.NotificationService;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MediaSessionWatcher {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f94814f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f94815g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f94816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f94817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f94818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile List f94819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Flow f94820e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MediaSessionWatcher(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f94816a = context;
        this.f94817b = new ComponentName(context, (Class<?>) NotificationService.class);
        this.f94818c = new Handler(Looper.getMainLooper());
        this.f94819d = CollectionsKt.emptyList();
        this.f94820e = FlowKt.u(FlowKt.f(new MediaSessionWatcher$playingPackages$1(this, null)));
    }

    public final Flow f() {
        return this.f94820e;
    }

    public final void g(String packageName) {
        Object next;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Iterator it = this.f94819d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((MediaController) next).getPackageName(), packageName)) {
                    break;
                }
            }
        }
        MediaController mediaController = (MediaController) next;
        if (mediaController == null) {
            return;
        }
        try {
            mediaController.getTransportControls().pause();
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }
}
