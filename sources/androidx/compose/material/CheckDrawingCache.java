package androidx.compose.material;

import androidx.compose.ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
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
final class CheckDrawingCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f12355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PathMeasure f12356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f12357c;

    public CheckDrawingCache(Path path, PathMeasure pathMeasure, Path path2) {
        this.f12355a = path;
        this.f12356b = pathMeasure;
        this.f12357c = path2;
    }

    public final Path a() {
        return this.f12355a;
    }

    public final PathMeasure b() {
        return this.f12356b;
    }

    public final Path c() {
        return this.f12357c;
    }

    public /* synthetic */ CheckDrawingCache(Path path, PathMeasure pathMeasure, Path path2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? AndroidPath_androidKt.a() : path, (i3 & 2) != 0 ? AndroidPathMeasure_androidKt.a() : pathMeasure, (i3 & 4) != 0 ? AndroidPath_androidKt.a() : path2);
    }
}
