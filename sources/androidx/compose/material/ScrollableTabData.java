package androidx.compose.material;

import androidx.compose.foundation.ScrollState;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
final class ScrollableTabData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollState f13748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineScope f13749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f13750c;

    public ScrollableTabData(ScrollState scrollState, CoroutineScope coroutineScope) {
        this.f13748a = scrollState;
        this.f13749b = coroutineScope;
    }

    private final int b(TabPosition tabPosition, Density density, int i3, List list) {
        int iZ0 = density.z0(((TabPosition) CollectionsKt.last(list)).b()) + i3;
        int iM = iZ0 - this.f13748a.m();
        return RangesKt.p(density.z0(tabPosition.a()) - ((iM / 2) - (density.z0(tabPosition.c()) / 2)), 0, RangesKt.f(iZ0 - iM, 0));
    }

    public final void c(Density density, int i3, List list, int i4) {
        int iB;
        Integer num = this.f13750c;
        if (num != null && num.intValue() == i4) {
            return;
        }
        this.f13750c = Integer.valueOf(i4);
        TabPosition tabPosition = (TabPosition) CollectionsKt.getOrNull(list, i4);
        if (tabPosition == null || this.f13748a.n() == (iB = b(tabPosition, density, i3, list))) {
            return;
        }
        BuildersKt__Builders_commonKt.d(this.f13749b, null, null, new ScrollableTabData$onLaidOut$1$1(this, iB, null), 3, null);
    }
}
