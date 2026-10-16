package androidx.compose.foundation;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Density;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class AndroidEdgeEffectOverscrollFactory implements OverscrollFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Density f4570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f4571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PaddingValues f4572d;

    public /* synthetic */ AndroidEdgeEffectOverscrollFactory(Context context, Density density, long j3, PaddingValues paddingValues, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, density, j3, paddingValues);
    }

    @Override // androidx.compose.foundation.OverscrollFactory
    public OverscrollEffect a() {
        return new AndroidEdgeEffectOverscrollEffect(this.f4569a, this.f4570b, this.f4571c, this.f4572d, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(AndroidEdgeEffectOverscrollFactory.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.foundation.AndroidEdgeEffectOverscrollFactory");
        AndroidEdgeEffectOverscrollFactory androidEdgeEffectOverscrollFactory = (AndroidEdgeEffectOverscrollFactory) obj;
        return Intrinsics.areEqual(this.f4569a, androidEdgeEffectOverscrollFactory.f4569a) && Intrinsics.areEqual(this.f4570b, androidEdgeEffectOverscrollFactory.f4570b) && Color.t(this.f4571c, androidEdgeEffectOverscrollFactory.f4571c) && Intrinsics.areEqual(this.f4572d, androidEdgeEffectOverscrollFactory.f4572d);
    }

    public int hashCode() {
        return (((((this.f4569a.hashCode() * 31) + this.f4570b.hashCode()) * 31) + Color.z(this.f4571c)) * 31) + this.f4572d.hashCode();
    }

    private AndroidEdgeEffectOverscrollFactory(Context context, Density density, long j3, PaddingValues paddingValues) {
        this.f4569a = context;
        this.f4570b = density;
        this.f4571c = j3;
        this.f4572d = paddingValues;
    }
}
