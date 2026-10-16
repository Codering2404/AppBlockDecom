package cz.mobilesoft.coreblock.scene.statistics;

import androidx.fragment.app.Fragment;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseFragmentActivityToolbarSurface;
import cz.mobilesoft.coreblock.scene.statistics.overview.StatisticsOverviewFragment;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class StatisticsActivity extends BaseFragmentActivityToolbarSurface {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Companion f119684u = new Companion(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f119685v = 8;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final AdUnitId f119686t = AdUnitId.PROFILE_LIST_BANNER;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    protected AdUnitId b0() {
        return this.f119686t;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseFragmentActivitySurface
    protected Fragment getFragment() {
        return StatisticsOverviewFragment.f120024u.a((Pair) getIntent().getSerializableExtra("STATISTICS_INTERVAL"));
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseActivitySurface
    protected String v0() {
        String string = getString(R.string.OD);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
