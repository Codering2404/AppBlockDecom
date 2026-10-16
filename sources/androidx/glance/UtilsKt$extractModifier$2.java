package androidx.glance;

import androidx.glance.GlanceModifier;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
public final class UtilsKt$extractModifier$2 extends Lambda implements Function2<Pair<Object, ? extends GlanceModifier>, GlanceModifier.Element, Pair<Object, ? extends GlanceModifier>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UtilsKt$extractModifier$2 f37657a;

    static {
        Intrinsics.needClassReification();
        f37657a = new UtilsKt$extractModifier$2();
    }

    public UtilsKt$extractModifier$2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Pair invoke(Pair pair, GlanceModifier.Element element) {
        Intrinsics.reifiedOperationMarker(3, "T");
        return element != null ? TuplesKt.a(element, pair.f()) : TuplesKt.a(pair.e(), ((GlanceModifier) pair.f()).a(element));
    }
}
