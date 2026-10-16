package cz.mobilesoft.widgets;

import androidx.glance.appwidget.GlanceAppWidget;
import androidx.glance.appwidget.GlanceAppWidgetReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public abstract class AppBlockWidgetReceiver<T extends GlanceAppWidget> extends GlanceAppWidgetReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f133865d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f133866e = GlanceAppWidgetReceiver.f38011c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Mutex f133867f = MutexKt.b(false, 1, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0183, code lost:
        
            if (r4.a(r10, r1) == r3) goto L52;
         */
        /* JADX WARN: Finally extract failed */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0154  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x018a  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0198  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x020d  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0219  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /* JADX WARN: Type inference failed for: r4v0, types: [int] */
        /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r4v25 */
        /* JADX WARN: Type inference failed for: r4v26 */
        /* JADX WARN: Type inference failed for: r4v5, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x020d -> B:16:0x0064). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(android.content.Context r17, kotlin.jvm.functions.Function1 r18, java.util.List r19, androidx.glance.appwidget.GlanceAppWidget r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 544
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.widgets.AppBlockWidgetReceiver.Companion.a(android.content.Context, kotlin.jvm.functions.Function1, java.util.List, androidx.glance.appwidget.GlanceAppWidget, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private Companion() {
        }
    }
}
