package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
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
public final class SplitPairFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ActivityComponentInfo f54285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ActivityComponentInfo f54286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f54287c;

    public final ComponentName a() {
        return new ComponentName(this.f54285a.b(), this.f54285a.a());
    }

    public final ComponentName b() {
        return new ComponentName(this.f54286b.b(), this.f54286b.a());
    }

    public final boolean c(Activity primaryActivity, Intent secondaryActivityIntent) {
        Intrinsics.checkNotNullParameter(primaryActivity, "primaryActivity");
        Intrinsics.checkNotNullParameter(secondaryActivityIntent, "secondaryActivityIntent");
        MatcherUtils matcherUtils = MatcherUtils.f54221a;
        if (!matcherUtils.b(primaryActivity, this.f54285a) || !matcherUtils.c(secondaryActivityIntent, this.f54286b)) {
            return false;
        }
        String str = this.f54287c;
        return str == null || Intrinsics.areEqual(str, secondaryActivityIntent.getAction());
    }

    public final boolean d(Activity primaryActivity, Activity secondaryActivity) {
        Intrinsics.checkNotNullParameter(primaryActivity, "primaryActivity");
        Intrinsics.checkNotNullParameter(secondaryActivity, "secondaryActivity");
        MatcherUtils matcherUtils = MatcherUtils.f54221a;
        if (!matcherUtils.b(primaryActivity, this.f54285a) || !matcherUtils.b(secondaryActivity, this.f54286b)) {
            return false;
        }
        String str = this.f54287c;
        if (str == null) {
            return true;
        }
        Intent intent = secondaryActivity.getIntent();
        return Intrinsics.areEqual(str, intent != null ? intent.getAction() : null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(SplitPairFilter.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.window.embedding.SplitPairFilter");
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        return Intrinsics.areEqual(this.f54285a, splitPairFilter.f54285a) && Intrinsics.areEqual(this.f54286b, splitPairFilter.f54286b) && Intrinsics.areEqual(this.f54287c, splitPairFilter.f54287c);
    }

    public int hashCode() {
        int iHashCode = ((this.f54285a.hashCode() * 31) + this.f54286b.hashCode()) * 31;
        String str = this.f54287c;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + a() + ", secondaryActivityName=" + b() + ", secondaryActivityAction=" + this.f54287c + '}';
    }
}
