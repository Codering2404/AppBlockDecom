package cz.mobilesoft.coreblock.scene.insights.usecase;

import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import java.util.List;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LongestContinuousBreakUseCase extends SuspendUseCase<Params, Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f103780a = 32400000;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f103781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f103782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f103783c;

        public Params(long j3, long j4, List ignoredNames) {
            Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
            this.f103781a = j3;
            this.f103782b = j4;
            this.f103783c = ignoredNames;
        }

        public final long a() {
            return this.f103782b;
        }

        public final List b() {
            return this.f103783c;
        }

        public final long c() {
            return this.f103781a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f103781a == params.f103781a && this.f103782b == params.f103782b && Intrinsics.areEqual(this.f103783c, params.f103783c);
        }

        public int hashCode() {
            return (((Long.hashCode(this.f103781a) * 31) + Long.hashCode(this.f103782b)) * 31) + this.f103783c.hashCode();
        }

        public String toString() {
            return "Params(start=" + this.f103781a + ", end=" + this.f103782b + ", ignoredNames=" + this.f103783c + ")";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase.Params r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase$invoke$1
            if (r0 == 0) goto L14
            r0 = r12
            cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase$invoke$1 r0 = (cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase$invoke$1) r0
            int r1 = r0.f103787d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f103787d = r1
        L12:
            r8 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase$invoke$1 r0 = new cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase$invoke$1
            r0.<init>(r10, r12)
            goto L12
        L1a:
            java.lang.Object r12 = r8.f103785b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f103787d
            r9 = 1
            if (r1 == 0) goto L37
            if (r1 != r9) goto L2f
            java.lang.Object r11 = r8.f103784a
            cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase$Params r11 = (cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase.Params) r11
            kotlin.ResultKt.b(r12)
            goto L68
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.statistics.api.Statistics r1 = cz.mobilesoft.statistics.api.Statistics.f133571a
            long r4 = r11.c()
            long r6 = r11.a()
            java.util.List r3 = r11.b()
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r12 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.APPLICATION
            int r12 = r12.getTypeId()
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.d(r12)
            java.util.List r12 = kotlin.collections.CollectionsKt.listOf(r12)
            r2 = r12
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r8.f103784a = r11
            r8.f103787d = r9
            java.lang.Object r12 = r1.o(r2, r3, r4, r6, r8)
            if (r12 != r0) goto L68
            return r0
        L68:
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto Lbf
            boolean r11 = r12.isEmpty()
            if (r11 == 0) goto L73
            goto Lbf
        L73:
            java.time.ZoneId r11 = java.time.ZoneId.systemDefault()
            java.lang.String r11 = r11.getId()
            int r0 = kotlin.collections.CollectionsKt.getLastIndex(r12)
            r1 = 0
            if (r9 > r0) goto Lba
        L83:
            int r3 = r9 + (-1)
            java.lang.Object r3 = r12.get(r3)
            cz.mobilesoft.statistics.model.RecordDuration r3 = (cz.mobilesoft.statistics.model.RecordDuration) r3
            java.lang.Object r4 = r12.get(r9)
            cz.mobilesoft.statistics.model.RecordDuration r4 = (cz.mobilesoft.statistics.model.RecordDuration) r4
            long r5 = r3.b()
            long r7 = r3.c()
            long r5 = r5 + r7
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            long r5 = cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt.a(r5, r11)
            long r3 = r4.b()
            long r3 = cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt.a(r3, r11)
            long r3 = r3 - r5
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto Lb5
            long r5 = r10.f103780a
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto Lb5
            r1 = r3
        Lb5:
            if (r9 == r0) goto Lba
            int r9 = r9 + 1
            goto L83
        Lba:
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.e(r1)
            return r11
        Lbf:
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase.a(cz.mobilesoft.coreblock.scene.insights.usecase.LongestContinuousBreakUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
