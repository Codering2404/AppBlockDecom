package cz.mobilesoft.coreblock.repository;

import com.google.gson.GsonBuilder;
import cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO;
import cz.mobilesoft.coreblock.dto.diagnostic.ProfileDTO;
import cz.mobilesoft.coreblock.dto.diagnostic.ProfileIntervalDTO;
import cz.mobilesoft.coreblock.dto.diagnostic.ProfileWebsiteDTO;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DiagnosticRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProfileDao f97634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ApplicationDao f97635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StrictModeDataStore f97636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoreMultiProcessDataStore f97637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CoreDataStore f97638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PremiumRepositoryV2 f97639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final StrictModeRepository f97640g;

    public DiagnosticRepository(ProfileDao profileDao, ApplicationDao applicationDao, StrictModeDataStore strictModeDataStore, CoreMultiProcessDataStore coreMultiProcessDataStore, CoreDataStore coreDataStore, PremiumRepositoryV2 premiumRepository, StrictModeRepository strictModeRepository) {
        Intrinsics.checkNotNullParameter(profileDao, "profileDao");
        Intrinsics.checkNotNullParameter(applicationDao, "applicationDao");
        Intrinsics.checkNotNullParameter(strictModeDataStore, "strictModeDataStore");
        Intrinsics.checkNotNullParameter(coreMultiProcessDataStore, "coreMultiProcessDataStore");
        Intrinsics.checkNotNullParameter(coreDataStore, "coreDataStore");
        Intrinsics.checkNotNullParameter(premiumRepository, "premiumRepository");
        Intrinsics.checkNotNullParameter(strictModeRepository, "strictModeRepository");
        this.f97634a = profileDao;
        this.f97635b = applicationDao;
        this.f97636c = strictModeDataStore;
        this.f97637d = coreMultiProcessDataStore;
        this.f97638e = coreDataStore;
        this.f97639f = premiumRepository;
        this.f97640g = strictModeRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence f(Ref.IntRef intRef, ProfileDTO profileDTO) {
        String strJoinToString$default;
        Integer numValueOf;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(profileDTO, "profileDTO");
        int i3 = intRef.f140142a;
        intRef.f140142a = i3 + 1;
        String strX = profileDTO.x();
        String str4 = profileDTO.B() ? "on" : "off";
        long jM = profileDTO.m();
        List listP = profileDTO.p();
        Integer numValueOf2 = null;
        String strJoinToString$default2 = listP != null ? CollectionsKt.joinToString$default(listP, ", ", null, null, 0, null, null, 62, null) : null;
        String strH = profileDTO.h();
        String strJoinToString$default3 = CollectionsKt.joinToString$default(profileDTO.j(), "+", null, null, 0, null, null, 62, null);
        if (profileDTO.A()) {
            strJoinToString$default = "all-day";
        } else {
            List listU = profileDTO.u();
            strJoinToString$default = listU != null ? CollectionsKt.joinToString$default(listU, null, null, null, 0, null, new Function1() { // from class: cz.mobilesoft.coreblock.repository.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DiagnosticRepository.g((ProfileIntervalDTO) obj);
                }
            }, 31, null) : null;
        }
        List listT = profileDTO.t();
        Integer numValueOf3 = listT != null ? Integer.valueOf(listT.size()) : null;
        List listV = profileDTO.v();
        if (listV != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listV) {
                if (((ProfileWebsiteDTO) obj).a() == 0) {
                    arrayList.add(obj);
                }
            }
            numValueOf = Integer.valueOf(arrayList.size());
        } else {
            numValueOf = null;
        }
        List listV2 = profileDTO.v();
        if (listV2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : listV2) {
                if (((ProfileWebsiteDTO) obj2).a() == 1) {
                    arrayList2.add(obj2);
                }
            }
            numValueOf2 = Integer.valueOf(arrayList2.size());
        }
        if (profileDTO.a()) {
            str3 = ", ania";
        } else {
            if (profileDTO.b()) {
                str2 = ", adult content";
            } else {
                if (profileDTO.c()) {
                    str = ", in-app purchases";
                } else {
                    str = (profileDTO.f() ? ", unsupported browsers" : "</li>");
                }
                str2 = str;
            }
            str3 = str2;
        }
        return "<li><b>S" + i3 + " (" + strX + ")</b> -> " + str4 + ", id: " + jM + ", type: " + strJoinToString$default2 + ", mode: " + strH + ", " + strJoinToString$default3 + ", " + strJoinToString$default + ", (A:" + numValueOf3 + ", W:" + numValueOf + ", K:" + numValueOf2 + ")" + str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(ProfileIntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        return "[" + interval.b() + " - " + interval.d() + "]";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.repository.DiagnosticRepository$getCompressedDiagnosticDataJson$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.repository.DiagnosticRepository$getCompressedDiagnosticDataJson$1 r0 = (cz.mobilesoft.coreblock.repository.DiagnosticRepository$getCompressedDiagnosticDataJson$1) r0
            int r1 = r0.f97645f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97645f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.DiagnosticRepository$getCompressedDiagnosticDataJson$1 r0 = new cz.mobilesoft.coreblock.repository.DiagnosticRepository$getCompressedDiagnosticDataJson$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f97643c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97645f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r1 = r0.f97642b
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.f97641a
            java.io.ByteArrayOutputStream r0 = (java.io.ByteArrayOutputStream) r0
            kotlin.ResultKt.b(r9)
            goto L78
        L34:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3c:
            java.lang.Object r2 = r0.f97641a
            java.io.ByteArrayOutputStream r2 = (java.io.ByteArrayOutputStream) r2
            kotlin.ResultKt.b(r9)
            goto L5a
        L44:
            kotlin.ResultKt.b(r9)
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream
            r9.<init>()
            r0.f97641a = r9
            r0.f97645f = r4
            java.lang.Object r2 = r8.h(r0)
            if (r2 != r1) goto L57
            goto L76
        L57:
            r7 = r2
            r2 = r9
            r9 = r7
        L5a:
            java.lang.String r9 = (java.lang.String) r9
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.b()
            cz.mobilesoft.coreblock.repository.DiagnosticRepository$getCompressedDiagnosticDataJson$2 r5 = new cz.mobilesoft.coreblock.repository.DiagnosticRepository$getCompressedDiagnosticDataJson$2
            r6 = 0
            r5.<init>(r2, r9, r6)
            r0.f97641a = r2
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f97642b = r9
            r0.f97645f = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.g(r4, r5, r0)
            if (r9 != r1) goto L77
        L76:
            return r1
        L77:
            r0 = r2
        L78:
            byte[] r9 = r0.toByteArray()
            java.lang.String r0 = "toByteArray(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.DiagnosticRepository.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0205 A[LOOP:0: B:37:0x01ff->B:39:0x0205, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 956
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.DiagnosticRepository.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(android.content.Context r31, kotlin.coroutines.Continuation r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 796
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.DiagnosticRepository.e(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.repository.DiagnosticRepository$getDiagnosticDataJson$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.repository.DiagnosticRepository$getDiagnosticDataJson$1 r0 = (cz.mobilesoft.coreblock.repository.DiagnosticRepository$getDiagnosticDataJson$1) r0
            int r1 = r0.f97683d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97683d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.DiagnosticRepository$getDiagnosticDataJson$1 r0 = new cz.mobilesoft.coreblock.repository.DiagnosticRepository$getDiagnosticDataJson$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f97681b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97683d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.f97680a
            com.google.gson.Gson r0 = (com.google.gson.Gson) r0
            kotlin.ResultKt.b(r6)
            goto L53
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L35:
            kotlin.ResultKt.b(r6)
            com.google.gson.GsonBuilder r6 = new com.google.gson.GsonBuilder
            r6.<init>()
            com.google.gson.GsonBuilder r6 = r6.f()
            com.google.gson.Gson r6 = r6.b()
            r0.f97680a = r6
            r0.f97683d = r3
            java.lang.Object r0 = r5.d(r0)
            if (r0 != r1) goto L50
            return r1
        L50:
            r4 = r0
            r0 = r6
            r6 = r4
        L53:
            java.lang.String r6 = r0.s(r6)
            java.lang.String r0 = "toJson(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.DiagnosticRepository.h(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.repository.DiagnosticRepository$getRevenueCatInfoJson$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.repository.DiagnosticRepository$getRevenueCatInfoJson$1 r0 = (cz.mobilesoft.coreblock.repository.DiagnosticRepository$getRevenueCatInfoJson$1) r0
            int r1 = r0.f97689g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f97689g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.repository.DiagnosticRepository$getRevenueCatInfoJson$1 r0 = new cz.mobilesoft.coreblock.repository.DiagnosticRepository$getRevenueCatInfoJson$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f97687d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f97689g
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r1 = r0.f97686c
            java.io.ByteArrayOutputStream r1 = (java.io.ByteArrayOutputStream) r1
            java.lang.Object r2 = r0.f97685b
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.f97684a
            com.revenuecat.purchases.CustomerInfo r0 = (com.revenuecat.purchases.CustomerInfo) r0
            kotlin.ResultKt.b(r9)
            goto L7e
        L35:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3d:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2 r9 = r8.f97639f
            com.revenuecat.purchases.CustomerInfo r9 = r9.B()
            com.google.gson.GsonBuilder r2 = new com.google.gson.GsonBuilder
            r2.<init>()
            com.google.gson.GsonBuilder r2 = r2.f()
            com.google.gson.Gson r2 = r2.b()
            java.lang.String r2 = r2.s(r9)
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.b()
            cz.mobilesoft.coreblock.repository.DiagnosticRepository$getRevenueCatInfoJson$2 r6 = new cz.mobilesoft.coreblock.repository.DiagnosticRepository$getRevenueCatInfoJson$2
            r7 = 0
            r6.<init>(r4, r2, r7)
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f97684a = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
            r0.f97685b = r9
            r0.f97686c = r4
            r0.f97689g = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.g(r5, r6, r0)
            if (r9 != r1) goto L7d
            return r1
        L7d:
            r1 = r4
        L7e:
            byte[] r9 = r1.toByteArray()
            java.lang.String r0 = "toByteArray(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.DiagnosticRepository.i(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final DiagnosticDTO j(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Object objJ = new GsonBuilder().b().j(json, DiagnosticDTO.class);
        Intrinsics.checkNotNullExpressionValue(objJ, "fromJson(...)");
        return (DiagnosticDTO) objJ;
    }
}
