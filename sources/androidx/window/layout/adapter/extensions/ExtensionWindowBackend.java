package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.adapter.WindowBackend;
import java.util.concurrent.Executor;
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
public final class ExtensionWindowBackend implements WindowBackend {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f54377b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowBackend f54378a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WindowBackend a(WindowLayoutComponent component, ConsumerAdapter adapter) {
            Intrinsics.checkNotNullParameter(component, "component");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            int iA = ExtensionsUtil.f54127a.a();
            return iA >= 2 ? new ExtensionWindowBackendApi2(component) : iA == 1 ? new ExtensionWindowBackendApi1(component, adapter) : new ExtensionWindowBackendApi0();
        }

        private Companion() {
        }
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void a(Consumer callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f54378a.a(callback);
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void b(Context context, Executor executor, Consumer callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f54378a.b(context, executor, callback);
    }
}
