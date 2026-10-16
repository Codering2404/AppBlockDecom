package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.usecase.FlowUseCase;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
public final class InitApplicationsUseCase extends FlowUseCase<Params, List<? extends ApplicationDTO>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoreMultiProcessDataStore f127172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ApplicationDao f127173b;

    public InitApplicationsUseCase(CoreMultiProcessDataStore coreMultiProcessDataStore, ApplicationDao applicationDao) {
        Intrinsics.checkNotNullParameter(coreMultiProcessDataStore, "coreMultiProcessDataStore");
        Intrinsics.checkNotNullParameter(applicationDao, "applicationDao");
        this.f127172a = coreMultiProcessDataStore;
        this.f127173b = applicationDao;
    }

    public Flow c(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return FlowKt.I(new InitApplicationsUseCase$invoke$1(params, this, null));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements FlowUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f127174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f127175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f127176c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f127177d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List f127178e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f127179f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f127180g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f127181h;

        public Params(Map applicationStates, List list, boolean z2, boolean z3, List recentItems, boolean z4, boolean z5, boolean z6) {
            Intrinsics.checkNotNullParameter(applicationStates, "applicationStates");
            Intrinsics.checkNotNullParameter(recentItems, "recentItems");
            this.f127174a = applicationStates;
            this.f127175b = list;
            this.f127176c = z2;
            this.f127177d = z3;
            this.f127178e = recentItems;
            this.f127179f = z4;
            this.f127180g = z5;
            this.f127181h = z6;
        }

        public final Map a() {
            return this.f127174a;
        }

        public final boolean b() {
            return this.f127180g;
        }

        public final List c() {
            return this.f127178e;
        }

        public final boolean d() {
            return this.f127177d;
        }

        public final List e() {
            return this.f127175b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127174a, params.f127174a) && Intrinsics.areEqual(this.f127175b, params.f127175b) && this.f127176c == params.f127176c && this.f127177d == params.f127177d && Intrinsics.areEqual(this.f127178e, params.f127178e) && this.f127179f == params.f127179f && this.f127180g == params.f127180g && this.f127181h == params.f127181h;
        }

        public final boolean f() {
            return this.f127176c;
        }

        public final boolean g() {
            return this.f127181h;
        }

        public final boolean h() {
            return this.f127179f;
        }

        public int hashCode() {
            int iHashCode = this.f127174a.hashCode() * 31;
            List list = this.f127175b;
            return ((((((((((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Boolean.hashCode(this.f127176c)) * 31) + Boolean.hashCode(this.f127177d)) * 31) + this.f127178e.hashCode()) * 31) + Boolean.hashCode(this.f127179f)) * 31) + Boolean.hashCode(this.f127180g)) * 31) + Boolean.hashCode(this.f127181h);
        }

        public String toString() {
            return "Params(applicationStates=" + this.f127174a + ", usages=" + this.f127175b + ", isAllowlist=" + this.f127176c + ", selectSystemApps=" + this.f127177d + ", recentItems=" + this.f127178e + ", isStrictModeOn=" + this.f127179f + ", onlySelected=" + this.f127180g + ", isFromOnboarding=" + this.f127181h + ")";
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ Params(java.util.Map r2, java.util.List r3, boolean r4, boolean r5, java.util.List r6, boolean r7, boolean r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
            /*
                r1 = this;
                r11 = r10 & 1
                if (r11 == 0) goto L8
                java.util.Map r2 = kotlin.collections.MapsKt.emptyMap()
            L8:
                r11 = r10 & 2
                if (r11 == 0) goto Ld
                r3 = 0
            Ld:
                r11 = r10 & 16
                if (r11 == 0) goto L15
                java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            L15:
                r11 = r10 & 32
                r0 = 0
                if (r11 == 0) goto L1b
                r7 = r0
            L1b:
                r11 = r10 & 64
                if (r11 == 0) goto L20
                r8 = r0
            L20:
                r10 = r10 & 128(0x80, float:1.8E-43)
                if (r10 == 0) goto L2e
                r11 = r0
                r9 = r7
                r10 = r8
                r7 = r5
                r8 = r6
                r5 = r3
                r6 = r4
                r3 = r1
                r4 = r2
                goto L37
            L2e:
                r11 = r9
                r10 = r8
                r8 = r6
                r9 = r7
                r6 = r4
                r7 = r5
                r4 = r2
                r5 = r3
                r3 = r1
            L37:
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase.Params.<init>(java.util.Map, java.util.List, boolean, boolean, java.util.List, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
