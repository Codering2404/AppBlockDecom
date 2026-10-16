package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import android.content.Context;
import cz.mobilesoft.coreblock.enums.Category;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.Regex;

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
public abstract class AppWebsiteCategoryDao implements BaseDao<AppWebsiteCategoryRelation> {
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a9, code lost:
    
        if (r6.p(r9, r0) == r1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00db, code lost:
    
        if (r6.n(r2, r0) == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object K(cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao.K(cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object O(AppWebsiteCategoryDao appWebsiteCategoryDao, Context context, Continuation continuation) {
        Object objT = appWebsiteCategoryDao.t(appWebsiteCategoryDao.Q(context), continuation);
        return objT == IntrinsicsKt.f() ? objT : Unit.f139807a;
    }

    private final AppWebsiteCategoryRelation P(String str) {
        String[] strArr = (String[]) new Regex(",").m(str, 0).toArray(new String[0]);
        String str2 = strArr[0];
        String str3 = strArr[1];
        if (str3.length() == 0) {
            str3 = null;
        }
        return new AppWebsiteCategoryRelation(str2, str3, Category.Companion.b(strArr[2]), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x002e A[EXC_TOP_SPLITTER, PHI: r1
      0x002e: PHI (r1v3 java.io.InputStream) = (r1v2 java.io.InputStream), (r1v4 java.io.InputStream) binds: [B:16:0x0038, B:12:0x002c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List Q(android.content.Context r4) {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            java.lang.String r2 = "apps_webs_categories.csv"
            java.io.InputStream r1 = r4.open(r2)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
        L1a:
            java.lang.String r2 = r4.readLine()     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            if (r2 == 0) goto L2c
            cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation r2 = r3.P(r2)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            r0.add(r2)     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2a
            goto L1a
        L28:
            r4 = move-exception
            goto L3c
        L2a:
            r4 = move-exception
            goto L32
        L2c:
            if (r1 == 0) goto L3b
        L2e:
            r1.close()     // Catch: java.io.IOException -> L3b
            goto L3b
        L32:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L28
            cz.mobilesoft.coreblock.util.CrashHelper.j(r4)     // Catch: java.lang.Throwable -> L28
            if (r1 == 0) goto L3b
            goto L2e
        L3b:
            return r0
        L3c:
            if (r1 == 0) goto L41
            r1.close()     // Catch: java.io.IOException -> L41
        L41:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao.Q(android.content.Context):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object S(cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao r4, java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            if (r5 == 0) goto L27
            kotlin.text.Regex r2 = new kotlin.text.Regex     // Catch: java.lang.Exception -> L20
            java.lang.String r3 = ";"
            r2.<init>(r3)     // Catch: java.lang.Exception -> L20
            java.util.List r5 = r2.m(r5, r1)     // Catch: java.lang.Exception -> L20
            if (r5 == 0) goto L27
            java.util.Collection r5 = (java.util.Collection) r5     // Catch: java.lang.Exception -> L20
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch: java.lang.Exception -> L20
            java.lang.Object[] r5 = r5.toArray(r2)     // Catch: java.lang.Exception -> L20
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch: java.lang.Exception -> L20
            goto L28
        L20:
            r5 = move-exception
            cz.mobilesoft.coreblock.util.CrashHelper.j(r5)
            java.lang.String[] r5 = new java.lang.String[r1]
            goto L28
        L27:
            r5 = 0
        L28:
            if (r5 == 0) goto L3e
            int r2 = r5.length
        L2b:
            if (r1 >= r2) goto L3e
            r3 = r5[r1]
            cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation r3 = r4.P(r3)     // Catch: java.lang.Exception -> L37
            r0.add(r3)     // Catch: java.lang.Exception -> L37
            goto L3b
        L37:
            r3 = move-exception
            cz.mobilesoft.coreblock.util.CrashHelper.j(r3)
        L3b:
            int r1 = r1 + 1
            goto L2b
        L3e:
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L52
            java.lang.Object r4 = r4.t(r0, r6)
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r4 != r5) goto L4f
            return r4
        L4f:
            kotlin.Unit r4 = kotlin.Unit.f139807a
            return r4
        L52:
            kotlin.Unit r4 = kotlin.Unit.f139807a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao.S(cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object J(String str, String str2, Continuation continuation) {
        return K(this, str, str2, continuation);
    }

    public abstract Object L(String str, Continuation continuation);

    public abstract Object M(Collection collection, Continuation continuation);

    public Object N(Context context, Continuation continuation) {
        return O(this, context, continuation);
    }

    public Object R(String str, Continuation continuation) {
        return S(this, str, continuation);
    }

    public abstract Object k(Continuation continuation);
}
