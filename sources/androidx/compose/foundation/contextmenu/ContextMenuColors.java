package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.graphics.Color;
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
public final class ContextMenuColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f5245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f5246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f5247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f5248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f5249e;

    public /* synthetic */ ContextMenuColors(long j3, long j4, long j5, long j6, long j7, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, j5, j6, j7);
    }

    public final long a() {
        return this.f5245a;
    }

    public final long b() {
        return this.f5249e;
    }

    public final long c() {
        return this.f5248d;
    }

    public final long d() {
        return this.f5247c;
    }

    public final long e() {
        return this.f5246b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ContextMenuColors)) {
            return false;
        }
        ContextMenuColors contextMenuColors = (ContextMenuColors) obj;
        return Color.t(this.f5245a, contextMenuColors.f5245a) && Color.t(this.f5246b, contextMenuColors.f5246b) && Color.t(this.f5247c, contextMenuColors.f5247c) && Color.t(this.f5248d, contextMenuColors.f5248d) && Color.t(this.f5249e, contextMenuColors.f5249e);
    }

    public int hashCode() {
        return (((((((Color.z(this.f5245a) * 31) + Color.z(this.f5246b)) * 31) + Color.z(this.f5247c)) * 31) + Color.z(this.f5248d)) * 31) + Color.z(this.f5249e);
    }

    public String toString() {
        return "ContextMenuColors(backgroundColor=" + ((Object) Color.A(this.f5245a)) + ", textColor=" + ((Object) Color.A(this.f5246b)) + ", iconColor=" + ((Object) Color.A(this.f5247c)) + ", disabledTextColor=" + ((Object) Color.A(this.f5248d)) + ", disabledIconColor=" + ((Object) Color.A(this.f5249e)) + ')';
    }

    private ContextMenuColors(long j3, long j4, long j5, long j6, long j7) {
        this.f5245a = j3;
        this.f5246b = j4;
        this.f5247c = j5;
        this.f5248d = j6;
        this.f5249e = j7;
    }
}
