package androidx.window.embedding;

import android.app.Activity;
import android.os.IBinder;
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
public final class SplitInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActivityStack f54281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ActivityStack f54282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SplitAttributes f54283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IBinder f54284d;

    public SplitInfo(ActivityStack primaryActivityStack, ActivityStack secondaryActivityStack, SplitAttributes splitAttributes, IBinder token) {
        Intrinsics.checkNotNullParameter(primaryActivityStack, "primaryActivityStack");
        Intrinsics.checkNotNullParameter(secondaryActivityStack, "secondaryActivityStack");
        Intrinsics.checkNotNullParameter(splitAttributes, "splitAttributes");
        Intrinsics.checkNotNullParameter(token, "token");
        this.f54281a = primaryActivityStack;
        this.f54282b = secondaryActivityStack;
        this.f54283c = splitAttributes;
        this.f54284d = token;
    }

    public final boolean a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return this.f54281a.a(activity) || this.f54282b.a(activity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitInfo)) {
            return false;
        }
        SplitInfo splitInfo = (SplitInfo) obj;
        return Intrinsics.areEqual(this.f54281a, splitInfo.f54281a) && Intrinsics.areEqual(this.f54282b, splitInfo.f54282b) && Intrinsics.areEqual(this.f54283c, splitInfo.f54283c) && Intrinsics.areEqual(this.f54284d, splitInfo.f54284d);
    }

    public int hashCode() {
        return (((((this.f54281a.hashCode() * 31) + this.f54282b.hashCode()) * 31) + this.f54283c.hashCode()) * 31) + this.f54284d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplitInfo:{");
        sb.append("primaryActivityStack=" + this.f54281a + ", ");
        sb.append("secondaryActivityStack=" + this.f54282b + ", ");
        sb.append("splitAttributes=" + this.f54283c + ", ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("token=");
        sb2.append(this.f54284d);
        sb.append(sb2.toString());
        sb.append("}");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
