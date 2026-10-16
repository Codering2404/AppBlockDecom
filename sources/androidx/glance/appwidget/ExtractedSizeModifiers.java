package androidx.glance.appwidget;

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
final class ExtractedSizeModifiers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GlanceModifier f37916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GlanceModifier f37917b;

    public ExtractedSizeModifiers(GlanceModifier glanceModifier, GlanceModifier glanceModifier2) {
        this.f37916a = glanceModifier;
        this.f37917b = glanceModifier2;
    }

    public static /* synthetic */ ExtractedSizeModifiers d(ExtractedSizeModifiers extractedSizeModifiers, GlanceModifier glanceModifier, GlanceModifier glanceModifier2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            glanceModifier = extractedSizeModifiers.f37916a;
        }
        if ((i3 & 2) != 0) {
            glanceModifier2 = extractedSizeModifiers.f37917b;
        }
        return extractedSizeModifiers.c(glanceModifier, glanceModifier2);
    }

    public final GlanceModifier a() {
        return this.f37916a;
    }

    public final GlanceModifier b() {
        return this.f37917b;
    }

    public final ExtractedSizeModifiers c(GlanceModifier glanceModifier, GlanceModifier glanceModifier2) {
        return new ExtractedSizeModifiers(glanceModifier, glanceModifier2);
    }

    public final GlanceModifier e() {
        return this.f37917b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExtractedSizeModifiers)) {
            return false;
        }
        ExtractedSizeModifiers extractedSizeModifiers = (ExtractedSizeModifiers) obj;
        return Intrinsics.areEqual(this.f37916a, extractedSizeModifiers.f37916a) && Intrinsics.areEqual(this.f37917b, extractedSizeModifiers.f37917b);
    }

    public final GlanceModifier f() {
        return this.f37916a;
    }

    public int hashCode() {
        return (this.f37916a.hashCode() * 31) + this.f37917b.hashCode();
    }

    public String toString() {
        return "ExtractedSizeModifiers(sizeModifiers=" + this.f37916a + ", nonSizeModifiers=" + this.f37917b + ')';
    }

    public /* synthetic */ ExtractedSizeModifiers(GlanceModifier glanceModifier, GlanceModifier glanceModifier2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? GlanceModifier.f37605a : glanceModifier, (i3 & 2) != 0 ? GlanceModifier.f37605a : glanceModifier2);
    }
}
