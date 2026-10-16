package androidx.compose.animation;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.ContentScale;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ContentScaleTransitionEffect extends TransitionEffect {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Key f3440c = new Key(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ContentScale f3441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Alignment f3442b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Key implements TransitionEffectKey<ContentScaleTransitionEffect> {
        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Key() {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentScaleTransitionEffect)) {
            return false;
        }
        ContentScaleTransitionEffect contentScaleTransitionEffect = (ContentScaleTransitionEffect) obj;
        return Intrinsics.areEqual(this.f3441a, contentScaleTransitionEffect.f3441a) && Intrinsics.areEqual(this.f3442b, contentScaleTransitionEffect.f3442b);
    }

    public int hashCode() {
        return (this.f3441a.hashCode() * 31) + this.f3442b.hashCode();
    }

    public String toString() {
        return "ContentScaleTransitionEffect(contentScale=" + this.f3441a + ", alignment=" + this.f3442b + ')';
    }
}
