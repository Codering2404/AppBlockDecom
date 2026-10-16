package cz.mobilesoft.coreblock.scene.more.settings.statistics;

import cz.mobilesoft.coreblock.base.ViewState;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StatisticsSettingsViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f110239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f110240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f110241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f110242d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f110243f;

    public StatisticsSettingsViewState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f110239a = z2;
        this.f110240b = z3;
        this.f110241c = z4;
        this.f110242d = z5;
        this.f110243f = z6;
    }

    public static /* synthetic */ StatisticsSettingsViewState b(StatisticsSettingsViewState statisticsSettingsViewState, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = statisticsSettingsViewState.f110239a;
        }
        if ((i3 & 2) != 0) {
            z3 = statisticsSettingsViewState.f110240b;
        }
        if ((i3 & 4) != 0) {
            z4 = statisticsSettingsViewState.f110241c;
        }
        if ((i3 & 8) != 0) {
            z5 = statisticsSettingsViewState.f110242d;
        }
        if ((i3 & 16) != 0) {
            z6 = statisticsSettingsViewState.f110243f;
        }
        boolean z7 = z6;
        boolean z8 = z4;
        return statisticsSettingsViewState.a(z2, z3, z8, z5, z7);
    }

    public final StatisticsSettingsViewState a(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return new StatisticsSettingsViewState(z2, z3, z4, z5, z6);
    }

    public final boolean c() {
        return this.f110241c;
    }

    public final boolean d() {
        return this.f110243f;
    }

    public final boolean e() {
        return this.f110240b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatisticsSettingsViewState)) {
            return false;
        }
        StatisticsSettingsViewState statisticsSettingsViewState = (StatisticsSettingsViewState) obj;
        return this.f110239a == statisticsSettingsViewState.f110239a && this.f110240b == statisticsSettingsViewState.f110240b && this.f110241c == statisticsSettingsViewState.f110241c && this.f110242d == statisticsSettingsViewState.f110242d && this.f110243f == statisticsSettingsViewState.f110243f;
    }

    public final boolean f() {
        return this.f110242d;
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.f110239a) * 31) + Boolean.hashCode(this.f110240b)) * 31) + Boolean.hashCode(this.f110241c)) * 31) + Boolean.hashCode(this.f110242d)) * 31) + Boolean.hashCode(this.f110243f);
    }

    public String toString() {
        return "StatisticsSettingsViewState(isStrictModeOn=" + this.f110239a + ", areStatisticsEnabled=" + this.f110240b + ", areAppStatisticsEnabled=" + this.f110241c + ", areWebStatisticsEnabled=" + this.f110242d + ", areIncognitoStatisticsEnabled=" + this.f110243f + ")";
    }

    public /* synthetic */ StatisticsSettingsViewState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? false : z4, (i3 & 8) != 0 ? false : z5, (i3 & 16) != 0 ? false : z6);
    }
}
