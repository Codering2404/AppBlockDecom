package androidx.compose.ui.input.rotary;

import kotlin.Metadata;

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
public final class RotaryScrollEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f27005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f27006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f27007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f27008d;

    public RotaryScrollEvent(float f3, float f4, long j3, int i3) {
        this.f27005a = f3;
        this.f27006b = f4;
        this.f27007c = j3;
        this.f27008d = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RotaryScrollEvent)) {
            return false;
        }
        RotaryScrollEvent rotaryScrollEvent = (RotaryScrollEvent) obj;
        return rotaryScrollEvent.f27005a == this.f27005a && rotaryScrollEvent.f27006b == this.f27006b && rotaryScrollEvent.f27007c == this.f27007c && rotaryScrollEvent.f27008d == this.f27008d;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f27005a) * 31) + Float.hashCode(this.f27006b)) * 31) + Long.hashCode(this.f27007c)) * 31) + Integer.hashCode(this.f27008d);
    }

    public String toString() {
        return "RotaryScrollEvent(verticalScrollPixels=" + this.f27005a + ",horizontalScrollPixels=" + this.f27006b + ",uptimeMillis=" + this.f27007c + ",deviceId=" + this.f27008d + ')';
    }
}
