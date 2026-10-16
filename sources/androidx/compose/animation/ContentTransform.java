package androidx.compose.animation;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ContentTransform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnterTransition f3443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExitTransition f3444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableFloatState f3445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SizeTransform f3446d;

    public ContentTransform(EnterTransition enterTransition, ExitTransition exitTransition, float f3, SizeTransform sizeTransform) {
        this.f3443a = enterTransition;
        this.f3444b = exitTransition;
        this.f3445c = PrimitiveSnapshotStateKt.a(f3);
        this.f3446d = sizeTransform;
    }

    public final ExitTransition a() {
        return this.f3444b;
    }

    public final SizeTransform b() {
        return this.f3446d;
    }

    public final EnterTransition c() {
        return this.f3443a;
    }

    public final float d() {
        return this.f3445c.c();
    }

    public final void e(SizeTransform sizeTransform) {
        this.f3446d = sizeTransform;
    }

    public /* synthetic */ ContentTransform(EnterTransition enterTransition, ExitTransition exitTransition, float f3, SizeTransform sizeTransform, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(enterTransition, exitTransition, (i3 & 4) != 0 ? 0.0f : f3, (i3 & 8) != 0 ? AnimatedContentKt.d(false, null, 3, null) : sizeTransform);
    }
}
