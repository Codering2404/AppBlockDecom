package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.sqlite.db.SimpleSQLiteQuery;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.SubAppRelation;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
public abstract class SubAppRelationDao implements BaseDao<SubAppRelation>, KoinComponent {
    public abstract Object J(long j3, Continuation continuation);

    public final Object K(long j3, Continuation continuation) {
        return P(j3, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object L(boolean r11, boolean r12, kotlin.coroutines.Continuation r13) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r11 != 0) goto L22
            cz.mobilesoft.coreblock.enums.ProfileType r11 = cz.mobilesoft.coreblock.enums.ProfileType.QUICK_BLOCK
            int r11 = r11.mask()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "p.typeCombinations != "
            r12.append(r1)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r0.add(r11)
            goto L43
        L22:
            if (r12 == 0) goto L43
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r11 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r11 = r11.f()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "(p.typeCombinations = p.onConditions OR p.onUntil > "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = ")"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.add(r11)
        L43:
            boolean r11 = r0.isEmpty()
            r12 = 0
            if (r11 != 0) goto L4c
            r1 = r0
            goto L4d
        L4c:
            r1 = r12
        L4d:
            if (r1 == 0) goto L5d
            r8 = 62
            r9 = 0
            java.lang.String r2 = " AND "
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r12 = kotlin.collections.CollectionsKt.joinToString$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L5d:
            if (r12 == 0) goto L72
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "AND "
            r11.append(r0)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            if (r11 != 0) goto L74
        L72:
            java.lang.String r11 = ""
        L74:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "SELECT EXISTS(SELECT 1 FROM SubAppRelation w JOIN Profile p ON w.profileId = p.id "
            r12.append(r0)
            r12.append(r11)
            java.lang.String r11 = ");"
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            androidx.sqlite.db.SimpleSQLiteQuery r12 = new androidx.sqlite.db.SimpleSQLiteQuery
            r12.<init>(r11)
            java.lang.Object r11 = r10.M(r12, r13)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao.L(boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object M(SimpleSQLiteQuery simpleSQLiteQuery, Continuation continuation);

    public abstract Object N(long j3, Continuation continuation);

    public abstract Object O(Collection collection, Continuation continuation);

    public abstract Object P(long j3, Continuation continuation);

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
