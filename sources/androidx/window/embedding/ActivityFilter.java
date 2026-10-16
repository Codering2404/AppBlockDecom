package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import androidx.window.core.ActivityComponentInfo;
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
public final class ActivityFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActivityComponentInfo f54175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f54176b;

    public final boolean a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!MatcherUtils.f54221a.b(activity, this.f54175a)) {
            return false;
        }
        String str = this.f54176b;
        if (str == null) {
            return true;
        }
        Intent intent = activity.getIntent();
        return Intrinsics.areEqual(str, intent != null ? intent.getAction() : null);
    }

    public final boolean b(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!MatcherUtils.f54221a.c(intent, this.f54175a)) {
            return false;
        }
        String str = this.f54176b;
        return str == null || Intrinsics.areEqual(str, intent.getAction());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        return Intrinsics.areEqual(this.f54175a, activityFilter.f54175a) && Intrinsics.areEqual(this.f54176b, activityFilter.f54176b);
    }

    public int hashCode() {
        int iHashCode = this.f54175a.hashCode() * 31;
        String str = this.f54176b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.f54175a + ", intentAction=" + this.f54176b + ')';
    }
}
