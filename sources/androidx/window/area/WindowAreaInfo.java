package androidx.window.area;

import android.os.Binder;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.layout.WindowMetrics;
import java.util.HashMap;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class WindowAreaInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WindowMetrics f54082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Type f54083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Binder f54084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WindowAreaComponent f54085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap f54086e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Type {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f54087b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Type f54088c = new Type("REAR FACING");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f54089a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        private Type(String str) {
            this.f54089a = str;
        }

        public String toString() {
            return this.f54089a;
        }
    }

    public WindowAreaInfo(WindowMetrics metrics, Type type, Binder token, WindowAreaComponent windowAreaComponent) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(windowAreaComponent, "windowAreaComponent");
        this.f54082a = metrics;
        this.f54083b = type;
        this.f54084c = token;
        this.f54085d = windowAreaComponent;
        this.f54086e = new HashMap();
    }

    public final HashMap a() {
        return this.f54086e;
    }

    public final void b(WindowMetrics windowMetrics) {
        Intrinsics.checkNotNullParameter(windowMetrics, "<set-?>");
        this.f54082a = windowMetrics;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WindowAreaInfo)) {
            return false;
        }
        WindowAreaInfo windowAreaInfo = (WindowAreaInfo) obj;
        return Intrinsics.areEqual(this.f54082a, windowAreaInfo.f54082a) && Intrinsics.areEqual(this.f54083b, windowAreaInfo.f54083b) && Intrinsics.areEqual(this.f54086e.entrySet(), windowAreaInfo.f54086e.entrySet());
    }

    public int hashCode() {
        return (((this.f54082a.hashCode() * 31) + this.f54083b.hashCode()) * 31) + this.f54086e.entrySet().hashCode();
    }

    public String toString() {
        return "WindowAreaInfo{ Metrics: " + this.f54082a + ", type: " + this.f54083b + ", Capabilities: " + this.f54086e.entrySet() + " }";
    }
}
