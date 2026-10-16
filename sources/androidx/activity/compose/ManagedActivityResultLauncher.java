package androidx.activity.compose;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.State;
import androidx.core.app.ActivityOptionsCompat;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ManagedActivityResultLauncher<I, O> extends ActivityResultLauncher<I> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f461c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActivityResultLauncherHolder f462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final State f463b;

    public ManagedActivityResultLauncher(ActivityResultLauncherHolder activityResultLauncherHolder, State state) {
        this.f462a = activityResultLauncherHolder;
        this.f463b = state;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public ActivityResultContract a() {
        return (ActivityResultContract) this.f463b.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void c(Object obj, ActivityOptionsCompat activityOptionsCompat) {
        this.f462a.a(obj, activityOptionsCompat);
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void d() {
        throw new UnsupportedOperationException("Registration is automatically handled by rememberLauncherForActivityResult");
    }
}
