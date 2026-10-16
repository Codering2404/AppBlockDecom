package androidx.glance;

import androidx.glance.GlanceModifier;
import androidx.glance.layout.ContentScale;
import androidx.glance.unit.ColorProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class BackgroundModifier implements GlanceModifier.Element {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorProvider f37524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImageProvider f37525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f37526d;

    public /* synthetic */ BackgroundModifier(ImageProvider imageProvider, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageProvider, i3);
    }

    public final ColorProvider b() {
        return this.f37524b;
    }

    public final int c() {
        return this.f37526d;
    }

    public final ImageProvider d() {
        return this.f37525c;
    }

    public String toString() {
        return "BackgroundModifier(colorProvider=" + this.f37524b + ", imageProvider=" + this.f37525c + ", contentScale=" + ((Object) ContentScale.i(this.f37526d)) + ')';
    }

    private BackgroundModifier(ColorProvider colorProvider, ImageProvider imageProvider, int i3) {
        this.f37524b = colorProvider;
        this.f37525c = imageProvider;
        this.f37526d = i3;
        if (!((colorProvider != null) ^ (imageProvider != null))) {
            throw new IllegalArgumentException("Exactly one of colorProvider and imageProvider must be non-null");
        }
    }

    /* synthetic */ BackgroundModifier(ColorProvider colorProvider, ImageProvider imageProvider, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorProvider, imageProvider, (i4 & 4) != 0 ? ContentScale.f39463b.b() : i3);
    }

    public BackgroundModifier(ColorProvider colorProvider) {
        this(colorProvider, null, 0, 4, null);
    }

    private BackgroundModifier(ImageProvider imageProvider, int i3) {
        this((ColorProvider) null, imageProvider, i3);
    }
}
