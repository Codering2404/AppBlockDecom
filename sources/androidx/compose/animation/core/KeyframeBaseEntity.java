package androidx.compose.animation.core;

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
public abstract class KeyframeBaseEntity<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f4006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Easing f4007b;

    public /* synthetic */ KeyframeBaseEntity(Object obj, Easing easing, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, easing);
    }

    public final Easing a() {
        return this.f4007b;
    }

    public final Object b() {
        return this.f4006a;
    }

    public final void c(Easing easing) {
        this.f4007b = easing;
    }

    private KeyframeBaseEntity(Object obj, Easing easing) {
        this.f4006a = obj;
        this.f4007b = easing;
    }
}
