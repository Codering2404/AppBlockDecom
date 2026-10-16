package cz.mobilesoft.coreblock.storage.room.management;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt", f = "GreendaoToRoomMigration.kt", l = {408, 409, 535, 538, 542, 546, 550, 554, 558}, m = "migrateProfilesToBlocking", v = 1)
final class GreendaoToRoomMigrationKt$migrateProfilesToBlocking$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f126736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f126737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f126738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f126739d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f126740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f126741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f126742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f126743i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f126744j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f126745k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f126746l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f126747m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f126748n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f126749o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    long f126750p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    long f126751q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    /* synthetic */ Object f126752r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f126753s;

    GreendaoToRoomMigrationKt$migrateProfilesToBlocking$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f126752r = obj;
        this.f126753s |= Integer.MIN_VALUE;
        return GreendaoToRoomMigrationKt.z(null, null, null, this);
    }
}
