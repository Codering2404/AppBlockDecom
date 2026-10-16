package cz.mobilesoft.coreblock.view.compose;

import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ActivityLauncher<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ManagedActivityResultLauncher f130298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutableState f130299b;

    public ActivityLauncher(ManagedActivityResultLauncher launcher, MutableState condition) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        Intrinsics.checkNotNullParameter(condition, "condition");
        this.f130298a = launcher;
        this.f130299b = condition;
    }

    public final MutableState a() {
        return this.f130299b;
    }

    public final ManagedActivityResultLauncher b() {
        return this.f130298a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityLauncher)) {
            return false;
        }
        ActivityLauncher activityLauncher = (ActivityLauncher) obj;
        return Intrinsics.areEqual(this.f130298a, activityLauncher.f130298a) && Intrinsics.areEqual(this.f130299b, activityLauncher.f130299b);
    }

    public int hashCode() {
        return (this.f130298a.hashCode() * 31) + this.f130299b.hashCode();
    }

    public String toString() {
        return "ActivityLauncher(launcher=" + this.f130298a + ", condition=" + this.f130299b + ")";
    }
}
