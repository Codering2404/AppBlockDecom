package cz.mobilesoft.coreblock.view.compose.skeleton;

import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import cz.mobilesoft.coreblock.view.compose.skeleton.SkeletonSlot;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SkeletonPresets {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SkeletonPresets f131964a = new SkeletonPresets();

    private SkeletonPresets() {
    }

    public static /* synthetic */ List b(SkeletonPresets skeletonPresets, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 8;
        }
        return skeletonPresets.a(i3);
    }

    public static /* synthetic */ List f(SkeletonPresets skeletonPresets, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 5;
        }
        return skeletonPresets.e(i3);
    }

    public final List a(int i3) {
        SkeletonSlot.Companion companion = SkeletonSlot.f131965a;
        return CollectionsKt.listOf(companion.f(i3, companion.d(Dp.g(64), true, true), Dp.g(8)));
    }

    public final List c(int i3) {
        SkeletonSlot.Companion companion = SkeletonSlot.f131965a;
        ComposableSingletons$StructuredSkeletonKt composableSingletons$StructuredSkeletonKt = ComposableSingletons$StructuredSkeletonKt.f131947a;
        return CollectionsKt.listOf((Object[]) new SkeletonSlot[]{companion.c(composableSingletons$StructuredSkeletonKt.r()), companion.f(i3, companion.c(composableSingletons$StructuredSkeletonKt.p()), Dp.g(16))});
    }

    public final List d() {
        SkeletonSlot.Companion companion = SkeletonSlot.f131965a;
        float f3 = 36;
        SkeletonSlot skeletonSlotB = companion.b(0.9f, Dp.g(f3));
        float f4 = 32;
        SkeletonSlot skeletonSlotH = companion.h(Dp.g(f4));
        SkeletonSlot skeletonSlotB2 = companion.b(0.5f, Dp.g(f3));
        float f5 = 12;
        return CollectionsKt.listOf((Object[]) new SkeletonSlot[]{skeletonSlotB, skeletonSlotH, skeletonSlotB2, companion.h(Dp.g(f5)), companion.b(0.35f, Dp.g(24)), companion.h(Dp.g(16)), companion.a(20, Dp.g(f5), Dp.g(160), true), companion.h(Dp.g(f4)), companion.e(Dp.d(Dp.g(120)), Dp.g(20)), companion.h(Dp.g(f5)), companion.f(6, companion.g(Dp.g(58)), Dp.g(8))});
    }

    public final List e(int i3) {
        SkeletonSlot.Companion companion = SkeletonSlot.f131965a;
        float f3 = 24;
        return CollectionsKt.listOf((Object[]) new SkeletonSlot[]{companion.b(0.5f, Dp.g(SensibleDefaults.X_OFFSET)), companion.h(Dp.g(f3)), companion.b(0.6f, Dp.g(32)), companion.h(Dp.g(12)), companion.b(0.8f, Dp.g(20)), companion.h(Dp.g(f3)), companion.f(i3, companion.c(ComposableSingletons$StructuredSkeletonKt.f131947a.q()), Dp.g(8))});
    }

    public final List g(int i3) {
        return CollectionsKt.listOf(SkeletonSlot.f131965a.c(ComposableSingletons$StructuredSkeletonKt.f131947a.o()));
    }
}
