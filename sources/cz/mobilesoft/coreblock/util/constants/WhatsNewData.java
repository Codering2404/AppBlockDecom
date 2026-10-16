package cz.mobilesoft.coreblock.util.constants;

import cz.mobilesoft.coreblock.repository.AppVersionRepository;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogVersionItem;
import cz.mobilesoft.coreblock.util.constants.WhatsNewData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class WhatsNewData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f128462a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f128463b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map a() {
            return WhatsNewData.f128463b;
        }

        private Companion() {
        }
    }

    static {
        List<ChangelogVersionItem> listM = AppVersionRepository.f97355a.m();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listM, 10)), 16));
        for (ChangelogVersionItem changelogVersionItem : listM) {
            Pair pairA = TuplesKt.a(changelogVersionItem.e().toString(), changelogVersionItem.b());
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        f128463b = MapsKt.withDefault(linkedHashMap, new Function1() { // from class: h2.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WhatsNewData.c((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List c(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.emptyList();
    }
}
