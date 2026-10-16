package com.valentinilk.shimmer;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class Shimmer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f93784d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ShimmerTheme f93785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ShimmerEffect f93786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableStateFlow f93787c;

    public Shimmer(ShimmerTheme theme, ShimmerEffect effect, Rect rect) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(effect, "effect");
        this.f93785a = theme;
        this.f93786b = effect;
        this.f93787c = StateFlowKt.a(rect);
    }

    public final MutableStateFlow a() {
        return this.f93787c;
    }

    public final ShimmerEffect b() {
        return this.f93786b;
    }

    public final ShimmerTheme c() {
        return this.f93785a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(Shimmer.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.valentinilk.shimmer.Shimmer");
        Shimmer shimmer = (Shimmer) obj;
        return Intrinsics.areEqual(this.f93785a, shimmer.f93785a) && Intrinsics.areEqual(this.f93786b, shimmer.f93786b);
    }

    public int hashCode() {
        return (this.f93785a.hashCode() * 31) + this.f93786b.hashCode();
    }
}
