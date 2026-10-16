package androidx.compose.animation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
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
public final class TransitionData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fade f3756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Slide f3757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ChangeSize f3758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Scale f3759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f3760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f3761f;

    public TransitionData(Fade fade, Slide slide, ChangeSize changeSize, Scale scale, boolean z2, Map map) {
        this.f3756a = fade;
        this.f3757b = slide;
        this.f3758c = changeSize;
        this.f3759d = scale;
        this.f3760e = z2;
        this.f3761f = map;
    }

    public final ChangeSize a() {
        return this.f3758c;
    }

    public final Map b() {
        return this.f3761f;
    }

    public final Fade c() {
        return this.f3756a;
    }

    public final boolean d() {
        return this.f3760e;
    }

    public final Scale e() {
        return this.f3759d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransitionData)) {
            return false;
        }
        TransitionData transitionData = (TransitionData) obj;
        return Intrinsics.areEqual(this.f3756a, transitionData.f3756a) && Intrinsics.areEqual(this.f3757b, transitionData.f3757b) && Intrinsics.areEqual(this.f3758c, transitionData.f3758c) && Intrinsics.areEqual(this.f3759d, transitionData.f3759d) && this.f3760e == transitionData.f3760e && Intrinsics.areEqual(this.f3761f, transitionData.f3761f);
    }

    public final Slide f() {
        return this.f3757b;
    }

    public int hashCode() {
        Fade fade = this.f3756a;
        int iHashCode = (fade == null ? 0 : fade.hashCode()) * 31;
        Slide slide = this.f3757b;
        int iHashCode2 = (iHashCode + (slide == null ? 0 : slide.hashCode())) * 31;
        ChangeSize changeSize = this.f3758c;
        int iHashCode3 = (iHashCode2 + (changeSize == null ? 0 : changeSize.hashCode())) * 31;
        Scale scale = this.f3759d;
        return ((((iHashCode3 + (scale != null ? scale.hashCode() : 0)) * 31) + Boolean.hashCode(this.f3760e)) * 31) + this.f3761f.hashCode();
    }

    public String toString() {
        return "TransitionData(fade=" + this.f3756a + ", slide=" + this.f3757b + ", changeSize=" + this.f3758c + ", scale=" + this.f3759d + ", hold=" + this.f3760e + ", effectsMap=" + this.f3761f + ')';
    }

    public /* synthetic */ TransitionData(Fade fade, Slide slide, ChangeSize changeSize, Scale scale, boolean z2, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : fade, (i3 & 2) != 0 ? null : slide, (i3 & 4) != 0 ? null : changeSize, (i3 & 8) != 0 ? null : scale, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? MapsKt.emptyMap() : map);
    }
}
