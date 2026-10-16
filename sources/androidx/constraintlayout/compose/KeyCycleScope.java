package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

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
@LayoutScopeMarker
@Metadata
public final class KeyCycleScope extends BaseKeyFrameScope {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f30595b = {Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "alpha", "getAlpha()F", 0)), Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "scaleX", "getScaleX()F", 0)), Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "scaleY", "getScaleY()F", 0)), Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "rotationX", "getRotationX()F", 0)), Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "rotationY", "getRotationY()F", 0)), Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "rotationZ", "getRotationZ()F", 0)), Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "translationX", "getTranslationX-D9Ej5fM()F", 0)), Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "translationY", "getTranslationY-D9Ej5fM()F", 0)), Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "translationZ", "getTranslationZ-D9Ej5fM()F", 0)), Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "period", "getPeriod()F", 0)), Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "offset", "getOffset()F", 0)), Reflection.e(new MutablePropertyReference1Impl(KeyCycleScope.class, "phase", "getPhase()F", 0))};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f30596c = 8;
}
