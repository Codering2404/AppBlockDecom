package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

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
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActivityResultLauncher f540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ActivityResultContract f541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ActivityResultContract f543d;

    @Override // androidx.activity.result.ActivityResultLauncher
    public ActivityResultContract a() {
        return this.f543d;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void d() {
        this.f540a.d();
    }

    public final ActivityResultContract e() {
        return this.f541b;
    }

    public final Object f() {
        return this.f542c;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void c(Unit input, ActivityOptionsCompat activityOptionsCompat) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.f540a.c(this.f542c, activityOptionsCompat);
    }
}
