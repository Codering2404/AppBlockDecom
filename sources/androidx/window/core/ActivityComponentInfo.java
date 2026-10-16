package androidx.window.core;

import android.content.ComponentName;
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
public final class ActivityComponentInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f54106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f54107b;

    public ActivityComponentInfo(String packageName, String className) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(className, "className");
        this.f54106a = packageName;
        this.f54107b = className;
    }

    public final String a() {
        return this.f54107b;
    }

    public final String b() {
        return this.f54106a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(ActivityComponentInfo.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.window.core.ActivityComponentInfo");
        ActivityComponentInfo activityComponentInfo = (ActivityComponentInfo) obj;
        return Intrinsics.areEqual(this.f54106a, activityComponentInfo.f54106a) && Intrinsics.areEqual(this.f54107b, activityComponentInfo.f54107b);
    }

    public int hashCode() {
        return (this.f54106a.hashCode() * 31) + this.f54107b.hashCode();
    }

    public String toString() {
        return "ClassInfo { packageName: " + this.f54106a + ", className: " + this.f54107b + " }";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ActivityComponentInfo(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        String packageName = componentName.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "componentName.packageName");
        String className = componentName.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "componentName.className");
        this(packageName, className);
    }
}
