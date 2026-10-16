package androidx.glance.appwidget;

import android.os.Build;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class Tracing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Tracing f38505a = new Tracing();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f38506b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38507c = 8;

    private Tracing() {
    }

    public final void a() {
        if (Build.VERSION.SDK_INT < 29 || !f38506b.get()) {
            return;
        }
        TracingApi29Impl.f38508a.a("GlanceAppWidget::update", 0);
    }

    public final void b() {
        if (Build.VERSION.SDK_INT < 29 || !f38506b.get()) {
            return;
        }
        TracingApi29Impl.f38508a.b("GlanceAppWidget::update", 0);
    }
}
