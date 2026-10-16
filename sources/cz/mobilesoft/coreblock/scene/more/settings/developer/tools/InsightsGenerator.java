package cz.mobilesoft.coreblock.scene.more.settings.developer.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.random.Random;

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
public final class InsightsGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InsightsGenerator f109440a = new InsightsGenerator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f109441b = TimeUnit.DAYS.toMillis(14);

    private InsightsGenerator() {
    }

    private final List a(long j3, long j4, int i3, Random random) {
        long j5;
        int iK;
        ArrayList arrayList = new ArrayList();
        TimeUnit timeUnit = TimeUnit.HOURS;
        long millis = timeUnit.toMillis(6L);
        long millis2 = timeUnit.toMillis(18L);
        long millis3 = timeUnit.toMillis(18L);
        long millis4 = timeUnit.toMillis(23L);
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3 && i5 < 250) {
            i5++;
            Pair pairA = random.h() < 0.75f ? TuplesKt.a(Long.valueOf(millis), Long.valueOf(millis2)) : TuplesKt.a(Long.valueOf(millis3), Long.valueOf(millis4));
            long j6 = millis;
            long jLongValue = ((Number) pairA.a()).longValue();
            long jLongValue2 = ((Number) pairA.b()).longValue();
            if (random.h() < 0.6f) {
                j5 = millis3;
                iK = random.k(1, 10);
            } else {
                j5 = millis3;
                iK = random.h() < 0.9f ? random.k(10, 25) : random.k(25, 46);
            }
            long j7 = millis2;
            long millis5 = TimeUnit.MINUTES.toMillis(iK);
            long j8 = jLongValue2 - millis5;
            if (j8 > jLongValue) {
                long jM = j3 + random.m(jLongValue, j8);
                long j9 = millis5 + jM;
                if (j9 <= j4) {
                    if (arrayList.isEmpty()) {
                        arrayList.add(TuplesKt.a(Long.valueOf(jM), Long.valueOf(j9)));
                        i4 += iK;
                    } else {
                        int size = arrayList.size();
                        int i6 = 0;
                        while (i6 < size) {
                            Object obj = arrayList.get(i6);
                            i6++;
                            Pair pair = (Pair) obj;
                            long jLongValue3 = ((Number) pair.a()).longValue();
                            if (jM >= ((Number) pair.b()).longValue() || j9 <= jLongValue3) {
                            }
                        }
                        arrayList.add(TuplesKt.a(Long.valueOf(jM), Long.valueOf(j9)));
                        i4 += iK;
                    }
                }
            }
            millis = j6;
            millis3 = j5;
            millis2 = j7;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03b0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x03a6 -> B:82:0x03ac). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao r41, kotlin.coroutines.Continuation r42) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1032
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.developer.tools.InsightsGenerator.b(cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
