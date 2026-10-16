package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Dp;
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
public final class FlowLineInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f6893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f6894d;

    public /* synthetic */ FlowLineInfo(int i3, int i4, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i4, f3, f4);
    }

    public final int a() {
        return this.f6891a;
    }

    public final float b() {
        return this.f6894d;
    }

    public final float c() {
        return this.f6893c;
    }

    public final int d() {
        return this.f6892b;
    }

    public final void e(int i3, int i4, float f3, float f4) {
        this.f6891a = i3;
        this.f6892b = i4;
        this.f6893c = f3;
        this.f6894d = f4;
    }

    private FlowLineInfo(int i3, int i4, float f3, float f4) {
        this.f6891a = i3;
        this.f6892b = i4;
        this.f6893c = f3;
        this.f6894d = f4;
    }

    public /* synthetic */ FlowLineInfo(int i3, int i4, float f3, float f4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i3, (i5 & 2) != 0 ? 0 : i4, (i5 & 4) != 0 ? Dp.g(0) : f3, (i5 & 8) != 0 ? Dp.g(0) : f4, null);
    }
}
