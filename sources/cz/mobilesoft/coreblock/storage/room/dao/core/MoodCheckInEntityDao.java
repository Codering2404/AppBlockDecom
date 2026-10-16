package cz.mobilesoft.coreblock.storage.room.dao.core;

import cz.mobilesoft.coreblock.enums.MoodType;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.MoodCheckInEntity;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.LocalDate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

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
public abstract class MoodCheckInEntityDao implements BaseDao<MoodCheckInEntity> {
    public abstract Object J(Continuation continuation);

    public abstract Object K(LocalDate localDate, Continuation continuation);

    public final Object L(LocalDate localDate, MoodType moodType, int i3, String str, Continuation continuation) {
        Object objN = n(new MoodCheckInEntity(0L, moodType, i3, localDate, TimeHelperExt.c(), str, 1, null), continuation);
        return objN == IntrinsicsKt.f() ? objN : Unit.f139807a;
    }
}
