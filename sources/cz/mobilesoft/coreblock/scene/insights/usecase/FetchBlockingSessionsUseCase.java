package cz.mobilesoft.coreblock.scene.insights.usecase;

import cz.mobilesoft.coreblock.dto.InsightsBlockingSessions;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao;
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
public final class FetchBlockingSessionsUseCase extends SuspendUseCase<Params, InsightsBlockingSessions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockSessionDao f103708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f103709b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f103710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f103711b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f103712c;

        public Params(long j3, long j4, List ignoredNames) {
            Intrinsics.checkNotNullParameter(ignoredNames, "ignoredNames");
            this.f103710a = j3;
            this.f103711b = j4;
            this.f103712c = ignoredNames;
        }

        public final long a() {
            return this.f103711b;
        }

        public final List b() {
            return this.f103712c;
        }

        public final long c() {
            return this.f103710a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f103710a == params.f103710a && this.f103711b == params.f103711b && Intrinsics.areEqual(this.f103712c, params.f103712c);
        }

        public int hashCode() {
            return (((Long.hashCode(this.f103710a) * 31) + Long.hashCode(this.f103711b)) * 31) + this.f103712c.hashCode();
        }

        public String toString() {
            return "Params(start=" + this.f103710a + ", end=" + this.f103711b + ", ignoredNames=" + this.f103712c + ")";
        }
    }

    public FetchBlockingSessionsUseCase(BlockSessionDao blockSessionDao) {
        Intrinsics.checkNotNullParameter(blockSessionDao, "blockSessionDao");
        this.f103708a = blockSessionDao;
        this.f103709b = 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase.Params r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase$invoke$1
            if (r0 == 0) goto L14
            r0 = r13
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase$invoke$1 r0 = (cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase$invoke$1) r0
            int r1 = r0.f103717f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f103717f = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase$invoke$1 r0 = new cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase$invoke$1
            r0.<init>(r11, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r7.f103715c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f103717f
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L44
            if (r1 == r2) goto L3c
            if (r1 != r8) goto L34
            long r0 = r7.f103714b
            java.lang.Object r12 = r7.f103713a
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase$Params r12 = (cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase.Params) r12
            kotlin.ResultKt.b(r13)
            goto L90
        L34:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3c:
            java.lang.Object r12 = r7.f103713a
            cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase$Params r12 = (cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase.Params) r12
            kotlin.ResultKt.b(r13)
            goto L63
        L44:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao r1 = r11.f103708a
            java.util.List r13 = r12.b()
            java.util.Collection r13 = (java.util.Collection) r13
            long r3 = r12.c()
            long r5 = r12.a()
            r7.f103713a = r12
            r7.f103717f = r2
            r2 = r13
            java.lang.Object r13 = r1.K(r2, r3, r5, r7)
            if (r13 != r0) goto L63
            goto L8e
        L63:
            java.lang.Number r13 = (java.lang.Number) r13
            long r9 = r13.longValue()
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao r1 = r11.f103708a
            java.util.List r13 = r12.b()
            r2 = r13
            java.util.Collection r2 = (java.util.Collection) r2
            long r3 = r12.c()
            long r5 = r12.a()
            r13 = r8
            r8 = r7
            int r7 = r11.f103709b
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
            r8.f103713a = r12
            r8.f103714b = r9
            r8.f103717f = r13
            java.lang.Object r13 = r1.L(r2, r3, r5, r7, r8)
            if (r13 != r0) goto L8f
        L8e:
            return r0
        L8f:
            r0 = r9
        L90:
            java.util.List r13 = (java.util.List) r13
            cz.mobilesoft.coreblock.dto.InsightsBlockingSessions r12 = new cz.mobilesoft.coreblock.dto.InsightsBlockingSessions
            int r0 = (int) r0
            r12.<init>(r0, r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase.a(cz.mobilesoft.coreblock.scene.insights.usecase.FetchBlockingSessionsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
