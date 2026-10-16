package androidx.glance.layout;

import android.content.res.Resources;
import androidx.compose.ui.unit.Dp;
import androidx.glance.GlanceModifier;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PaddingModifier implements GlanceModifier.Element {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PaddingDimension f39490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PaddingDimension f39491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PaddingDimension f39492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PaddingDimension f39493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PaddingDimension f39494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PaddingDimension f39495g;

    public PaddingModifier(PaddingDimension paddingDimension, PaddingDimension paddingDimension2, PaddingDimension paddingDimension3, PaddingDimension paddingDimension4, PaddingDimension paddingDimension5, PaddingDimension paddingDimension6) {
        this.f39490b = paddingDimension;
        this.f39491c = paddingDimension2;
        this.f39492d = paddingDimension3;
        this.f39493e = paddingDimension4;
        this.f39494f = paddingDimension5;
        this.f39495g = paddingDimension6;
    }

    public final PaddingModifier b(PaddingModifier paddingModifier) {
        return new PaddingModifier(this.f39490b.c(paddingModifier.f39490b), this.f39491c.c(paddingModifier.f39491c), this.f39492d.c(paddingModifier.f39492d), this.f39493e.c(paddingModifier.f39493e), this.f39494f.c(paddingModifier.f39494f), this.f39495g.c(paddingModifier.f39495g));
    }

    public final PaddingInDp c(Resources resources) {
        return new PaddingInDp(Dp.g(this.f39490b.a() + PaddingKt.g(this.f39490b.b(), resources)), Dp.g(this.f39491c.a() + PaddingKt.g(this.f39491c.b(), resources)), Dp.g(this.f39492d.a() + PaddingKt.g(this.f39492d.b(), resources)), Dp.g(this.f39493e.a() + PaddingKt.g(this.f39493e.b(), resources)), Dp.g(this.f39494f.a() + PaddingKt.g(this.f39494f.b(), resources)), Dp.g(this.f39495g.a() + PaddingKt.g(this.f39495g.b(), resources)), null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaddingModifier)) {
            return false;
        }
        PaddingModifier paddingModifier = (PaddingModifier) obj;
        return Intrinsics.areEqual(this.f39490b, paddingModifier.f39490b) && Intrinsics.areEqual(this.f39491c, paddingModifier.f39491c) && Intrinsics.areEqual(this.f39492d, paddingModifier.f39492d) && Intrinsics.areEqual(this.f39493e, paddingModifier.f39493e) && Intrinsics.areEqual(this.f39494f, paddingModifier.f39494f) && Intrinsics.areEqual(this.f39495g, paddingModifier.f39495g);
    }

    public int hashCode() {
        return (((((((((this.f39490b.hashCode() * 31) + this.f39491c.hashCode()) * 31) + this.f39492d.hashCode()) * 31) + this.f39493e.hashCode()) * 31) + this.f39494f.hashCode()) * 31) + this.f39495g.hashCode();
    }

    public String toString() {
        return "PaddingModifier(left=" + this.f39490b + ", start=" + this.f39491c + ", top=" + this.f39492d + ", right=" + this.f39493e + ", end=" + this.f39494f + ", bottom=" + this.f39495g + ')';
    }

    public /* synthetic */ PaddingModifier(PaddingDimension paddingDimension, PaddingDimension paddingDimension2, PaddingDimension paddingDimension3, PaddingDimension paddingDimension4, PaddingDimension paddingDimension5, PaddingDimension paddingDimension6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension, (i3 & 2) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension2, (i3 & 4) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension3, (i3 & 8) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension4, (i3 & 16) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension5, (i3 & 32) != 0 ? new PaddingDimension(0.0f, null, 3, null) : paddingDimension6);
    }
}
