package androidx.window.embedding;

import android.app.Activity;
import java.util.List;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ActivityStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f54179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f54180b;

    public ActivityStack(List activitiesInProcess, boolean z2) {
        Intrinsics.checkNotNullParameter(activitiesInProcess, "activitiesInProcess");
        this.f54179a = activitiesInProcess;
        this.f54180b = z2;
    }

    public final boolean a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.f54179a.contains(activity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityStack)) {
            return false;
        }
        ActivityStack activityStack = (ActivityStack) obj;
        return Intrinsics.areEqual(this.f54179a, activityStack.f54179a) && this.f54180b == activityStack.f54180b;
    }

    public int hashCode() {
        return (this.f54179a.hashCode() * 31) + Boolean.hashCode(this.f54180b);
    }

    public String toString() {
        return "ActivityStack{activitiesInProcess=" + this.f54179a + ", isEmpty=" + this.f54180b + '}';
    }
}
